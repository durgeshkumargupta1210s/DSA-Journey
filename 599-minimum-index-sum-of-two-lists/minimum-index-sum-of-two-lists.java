class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {

        int min = Integer.MAX_VALUE;

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < list1.length; i++) {

            String word = list1[i];

            int idx = indexOf(list2, word);

            if (idx != -1) {

                int val = i + idx;

                if (val < min) {

                    min = val;
                    ans.clear();
                    ans.add(word);

                } else if (val == min) {

                    ans.add(word);
                }
            }
        }

        String[] arr = new String[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }

        return arr;
    }

    public static int indexOf(String[] arr, String target) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].equals(target))
                return i;
        }

        return -1;
    }
}