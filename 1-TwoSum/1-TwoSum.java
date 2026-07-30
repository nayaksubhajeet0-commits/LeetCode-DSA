// Last updated: 7/30/2026, 6:20:37 PM
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
    
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            
            
            numMap.put(nums[i], i);
        }
        
        return new int[] {};
    }
}