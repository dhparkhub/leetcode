import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> firstArray = arrays.get(0);
        int minVal = firstArray.get(0);
        int maxVal = firstArray.get(firstArray.size() - 1);

        int maxDist = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> tempList = arrays.get(i);
            int nMinVal = tempList.get(0);
            int nMaxVal = tempList.get(tempList.size() - 1);

            int dist1 = Math.abs(minVal - nMaxVal);
            int dist2 = Math.abs(maxVal - nMinVal);
            maxDist = Math.max(maxDist, Math.max(dist1, dist2));

            minVal = Math.min(minVal, nMinVal);
            maxVal = Math.max(maxVal, nMaxVal);
        }
        
        return maxDist;
    }
}