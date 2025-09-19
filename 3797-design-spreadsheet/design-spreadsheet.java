import java.util.*;

class Spreadsheet {
    private Map<String, Integer> cells;
    private int rows;

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.cells = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }
    
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    
    public int getValue(String formula) {
        // Remove spaces
        formula = formula.replaceAll("\\s+", "");
        
        // Strip leading '=' if present
        if (formula.startsWith("=")) {
            formula = formula.substring(1);
        }
        
        int result = 0;
        int sign = 1;
        StringBuilder token = new StringBuilder();

        for (int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);

            if (ch == '+' || ch == '-') {
                result += sign * evaluateToken(token.toString());
                token.setLength(0);
                sign = (ch == '+') ? 1 : -1;
            } else {
                token.append(ch);
            }
        }

        // Last token
        if (token.length() > 0) {
            result += sign * evaluateToken(token.toString());
        }

        return result;
    }

    private int evaluateToken(String token) {
        if (token.isEmpty()) return 0;
        
        if (token.matches("[A-Z]+[0-9]+")) { // If it's a cell reference
            return cells.getOrDefault(token, 0);
        } else { // It's a number
            return Integer.parseInt(token);
        }
    }
}

/**
 * Example usage:
 * Spreadsheet obj = new Spreadsheet(3);
 * System.out.println(obj.getValue("=5+7"));   // 12
 * obj.setCell("A1", 10);
 * System.out.println(obj.getValue("=A1+6")); // 16
 * obj.setCell("B2", 15);
 * System.out.println(obj.getValue("=A1+B2"));// 25
 * obj.resetCell("A1");
 * System.out.println(obj.getValue("=A1+B2"));// 15 (since A1 reset to 0)
 */
