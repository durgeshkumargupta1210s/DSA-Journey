class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        // Convert array to list so that Collections.sort() can be used
        List<Integer> list = new ArrayList<>();

        for (int num : arr) {
            list.add(num);
        }

        // Sort elements based on:
        // 1. Distance from x (smaller distance comes first)
        // 2. If distances are equal, smaller element comes first
        Collections.sort(list, (a, b) -> {

            int diff1 = Math.abs(a - x);
            int diff2 = Math.abs(b - x);

            // If both elements are equally close to x,
            // place the smaller element first
            if (diff1 == diff2) {
                return a - b;
            }

            // Otherwise, place the element with smaller distance first
            return diff1 - diff2;
        });

        // Keep only the first k closest elements
        list = list.subList(0, k);

        // Sort the selected elements in ascending order
        // because the final answer must be sorted
        Collections.sort(list);

        return list;
    }
}