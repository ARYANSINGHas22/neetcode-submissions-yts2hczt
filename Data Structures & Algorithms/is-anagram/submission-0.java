class Solution {
    public boolean isAnagram(String s, String t) {
        int s1 = s.length();
        int t1 = t.length();

        if (s1 != t1) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1; i++) {
            char sc = s.charAt(i);
            char st = t.charAt(i);

            map.put(sc, map.getOrDefault(sc, 0) + 1);
            map.put(st, map.getOrDefault(st, 0) - 1);
        }

        for (int val : map.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}