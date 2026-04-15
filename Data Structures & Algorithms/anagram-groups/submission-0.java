class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);                 // sort characters
            String key = new String(chars);     // make it a string

            // if key not present → create new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str); // add original string
        }

        return new ArrayList<>(map.values());
    }
}