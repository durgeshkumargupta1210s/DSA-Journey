import java.util.*;

class MovieRentingSystem {

    static class Entry {
        int shop, movie, price;

        Entry(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    // Comparator for available movies of a specific movieId
    static class AvailableComparator implements Comparator<Entry> {
        public int compare(Entry a, Entry b) {
            if (a.price != b.price) return a.price - b.price;
            return a.shop - b.shop;
        }
    }

    // Comparator for rented movies (global report set)
    static class RentedComparator implements Comparator<Entry> {
        public int compare(Entry a, Entry b) {
            if (a.price != b.price) return a.price - b.price;
            if (a.shop != b.shop) return a.shop - b.shop;
            return a.movie - b.movie;
        }
    }

    // Price lookup: (shop, movie) → price
    private final Map<String, Integer> priceMap;

    // Available movies grouped by movieId
    private final Map<Integer, TreeSet<Entry>> available;

    // Global rented set
    private final TreeSet<Entry> rented;

    // Quick lookup for (shop, movie) → Entry object
    private final Map<String, Entry> entryMap;

    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        available = new HashMap<>();
        rented = new TreeSet<>(new RentedComparator());
        entryMap = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            String key = shop + "#" + movie;

            Entry entry = new Entry(shop, movie, price);
            priceMap.put(key, price);
            entryMap.put(key, entry);

            available.computeIfAbsent(movie, k -> new TreeSet<>(new AvailableComparator()))
                     .add(entry);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!available.containsKey(movie)) return result;

        Iterator<Entry> it = available.get(movie).iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            result.add(it.next().shop);
            count++;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        String key = shop + "#" + movie;
        Entry entry = entryMap.get(key);

        // remove from available
        available.get(movie).remove(entry);

        // add to rented
        rented.add(entry);
    }

    public void drop(int shop, int movie) {
        String key = shop + "#" + movie;
        Entry entry = entryMap.get(key);

        // remove from rented
        rented.remove(entry);

        // add back to available
        available.get(movie).add(entry);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        Iterator<Entry> it = rented.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            Entry e = it.next();
            result.add(Arrays.asList(e.shop, e.movie));
            count++;
        }
        return result;
    }
}
