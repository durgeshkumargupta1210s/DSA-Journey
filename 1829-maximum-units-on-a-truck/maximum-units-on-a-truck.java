import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort the box types in descending order of units per box
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int total = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            int noOfBoxes = boxTypes[i][0];  // Number of boxes of this type
            int units = boxTypes[i][1];      // Units per box

            if (truckSize == 0) break; // Truck is full

            if (noOfBoxes <= truckSize) {
                // Truck can take all boxes of this type
                total += noOfBoxes * units;
                truckSize -= noOfBoxes;
            } else {
                // Truck can only take part of this box type
                total += truckSize * units;
                truckSize = 0; // Truck is now full
            }
        }

        return total;
    }
}
