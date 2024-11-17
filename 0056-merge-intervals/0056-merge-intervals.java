import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on the start value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // If the list is empty or the current interval does not overlap with the previous one
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } else {
                // Merge the current interval with the previous one
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // Convert the list back to a 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}
