class Solution {
    public int removeDuplicates(int[] nums) {
        int[] visited = new int[20001];
        int index = 0;
        for (int num : nums) {
            if (visited[num + 10000] >= 2) continue;
            visited[num + 10000]++;
            nums[index++] = num;
        }
        return index;
    }
}