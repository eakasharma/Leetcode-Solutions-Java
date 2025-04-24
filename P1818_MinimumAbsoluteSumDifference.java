import java.util.*;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = 1_000_000_007;
        int n = nums1.length;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long total = 0;
        int maxGain = 0;

        for (int i = 0; i < n; i++) {
            int originalDiff = Math.abs(nums1[i] - nums2[i]);
            total += originalDiff;

            int idx = Arrays.binarySearch(sorted, nums2[i]);
            if (idx < 0) idx = -idx - 1;

            if (idx < n) {
                int gain = originalDiff - Math.abs(sorted[idx] - nums2[i]);
                maxGain = Math.max(maxGain, gain);
            }

            if (idx > 0) {
                int gain = originalDiff - Math.abs(sorted[idx - 1] - nums2[i]);
                maxGain = Math.max(maxGain, gain);
            }
        }

        return (int) ((total - maxGain) % mod);
    }
}
