import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        generateUniquePermutations(nums, new ArrayList<>(), used, result);
        return result;
    }
    private void generateUniquePermutations(int[] nums, List<Integer> currentList, boolean[] used, List<List<Integer>> result) {
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            currentList.add(nums[i]);
            generateUniquePermutations(nums, currentList, used, result);
            currentList.remove(currentList.size() - 1);
            used[i] = false;
        }
    }
}
