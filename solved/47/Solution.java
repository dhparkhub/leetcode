class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        int[] numCnt = new int[21];
        for (int num : nums) {
            numCnt[num + 10]++;
        }

        List<List<Integer>> answer = new ArrayList<>();
        permute(nums, new int[nums.length], numCnt, 0, answer);
        return answer;
    }

    private void permute(int[] nums, int[] temp, int[] numCnt, int index, List<List<Integer>> list) {
        if (index == nums.length) {
            list.add(Arrays.stream(temp).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (numCnt[nums[i] + 10] > 0) {
                temp[index] = nums[i];
                numCnt[nums[i] + 10]--;
                permute(nums, temp, numCnt, index + 1, list);
                numCnt[nums[i] + 10]++;
            }
        }
    }
}