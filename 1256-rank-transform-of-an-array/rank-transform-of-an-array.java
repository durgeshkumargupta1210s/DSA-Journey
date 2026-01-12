class Solution {
    public int[] arrayRankTransform(int[] arr) {

        if (arr.length == 0) {
            return new int[0];
        }

        int[] rank = new int[arr.length];
        int[] temp = arr.clone();

        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();

        int r = 1;
        map.put(temp[0], r);

        for (int i = 1; i < temp.length; i++) {
            if (temp[i] != temp[i - 1]) {
                r++;
                map.put(temp[i], r);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            rank[i] = map.get(arr[i]);
        }

        return rank;
    }
}
