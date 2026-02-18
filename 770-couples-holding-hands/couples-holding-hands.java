class Solution {
    public int minSwapsCouples(int[] row) {

        // Map to store the current index of each person
        // Key   = person number
        // Value = index where that person is sitting
        Map<Integer, Integer> map = new HashMap<>();

        // Fill the map with initial positions
        for (int i = 0; i < row.length; i++) {
            map.put(row[i], i);
        }

        // Variable to count minimum swaps
        int swap = 0;

        // Traverse seats in pairs (0,1), (2,3), (4,5), ...
        for (int i = 0; i < row.length; i += 2) {

            // Person sitting at current seat
            int person = row[i];

            // Find the partner of this person
            // Couples are defined as:
            // (0,1), (2,3), (4,5), ...
            // Even number -> partner = person + 1
            // Odd number  -> partner = person - 1
            int partner;
            if (person % 2 == 0) {
                partner = person + 1;
            } else {
                partner = person - 1;
            }

            // If partner is already sitting next to person, no swap needed
            if (row[i + 1] == partner) {
                continue;
            }

            // Otherwise, we must swap to bring partner next to person
            swap++;

            // Find index where partner is currently sitting
            int partnerIdx = map.get(partner);

            // Swap the partner with the person sitting at i+1
            int temp = row[i + 1];
            row[i + 1] = row[partnerIdx];
            row[partnerIdx] = temp;

            // Update map after swap
            // temp person moved to partnerIdx
            map.put(temp, partnerIdx);

            // partner moved to i+1
            map.put(partner, i + 1);
        }

        // Return minimum swaps required
        return swap;
    }
}
