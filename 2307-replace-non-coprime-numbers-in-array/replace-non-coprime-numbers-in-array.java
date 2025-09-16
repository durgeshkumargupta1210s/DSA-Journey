class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
            while (list.size() > 1) {
                int last = list.get(list.size() - 1);
                int secondLast = list.get(list.size() - 2);

                int g = gcd(last, secondLast);

                if (g > 1) { // Non-coprime
                    long lcm = (long) last * secondLast / g;

                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    list.add((int) lcm);
                } else {
                    break;
                }
            }
        }
        return list;
    }
}
