import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums, new ArrayList<>(), result);
        return result;
    }
    private void generatePermutations(int[] nums, List<Integer> currentList, List<List<Integer>> result) {
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            if (currentList.contains(currentNum)) {
                continue;
            }
            currentList.add(currentNum);
            generatePermutations(nums, currentList, result);
            currentList.remove(currentList.size() - 1);
        }
    }
}
