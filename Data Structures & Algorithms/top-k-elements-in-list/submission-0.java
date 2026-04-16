
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];

        // Step 1: Count frequency
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        // Step 2: Sort by frequency (descending)
        Map<Integer, Integer> orderedCount = new LinkedHashMap<>();

        count.entrySet()
             .stream()
             .sorted(Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder()))
             .forEachOrdered(x -> orderedCount.put(x.getKey(), x.getValue()));

        // Step 3: Take top k elements
        int index = 0;
        for (int key : orderedCount.keySet()) {
            res[index++] = key;
            if (index == k) break;
        }

        return res;
    }
}