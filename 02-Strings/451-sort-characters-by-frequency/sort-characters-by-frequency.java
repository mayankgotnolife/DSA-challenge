class Solution {
    public String frequencySort(String s) {
       
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buckets = new List[s.length() + 1];
        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(c);
        }

        StringBuilder result = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) continue;
            for (char c : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}