class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int freq1[] = new int[1001];
        int freq2[] = new int[1001];

        for (int num : nums1) {
            freq1[num]++;
        }
        for (int num : nums2) {
            freq2[num]++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            if (freq1[i] > 0 && freq2[i] > 0) {
                ans.add(i);
            }
        }

        int ansf[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansf[i] = ans.get(i);
        }
        return ansf;
    }
}
