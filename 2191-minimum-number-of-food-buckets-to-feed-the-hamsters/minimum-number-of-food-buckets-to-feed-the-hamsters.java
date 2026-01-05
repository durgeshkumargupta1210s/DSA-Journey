class Solution {
    public int minimumBuckets(String hamsters) {
        char[] arr = hamsters.toCharArray();
        int n = arr.length;
        int buckets = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'H') {

                // Check if already fed by left bucket
                if (i - 1 >= 0 && arr[i - 1] == 'B') {
                    continue;
                }

                // Prefer placing bucket on the right
                if (i + 1 < n && arr[i + 1] == '.') {
                    arr[i + 1] = 'B';
                    buckets++;
                }
                // Else place on the left
                else if (i - 1 >= 0 && arr[i - 1] == '.') {
                    arr[i - 1] = 'B';
                    buckets++;
                }
                // Impossible to feed this hamster
                else {
                    return -1;
                }
            }
        }

        return buckets;
    }
}
