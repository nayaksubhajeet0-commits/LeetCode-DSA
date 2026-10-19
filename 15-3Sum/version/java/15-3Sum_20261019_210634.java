// Last updated: 10/19/2026, 9:06:34 PM
/*
 * 1.  Sort the array: Sort the array to enable the two-pointer technique and easily skip duplicates.
 * 2.  Anchor iteration: Iterate through the array with a fixed anchor element, skipping duplicates.
 * 3.  Two pointers: Use left and right pointers moving inward to find triplets that sum to zero.
*/

1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> threeSum(int[] nums) {
7        List<List<Integer>> result = new ArrayList<>();
8        
9        // Step 1: Sort the array
10        Arrays.sort(nums);
11        
12        // Step 2: Iterate through the array
13        for (int i = 0; i < nums.length - 2; i++) {
14            // Skip duplicate elements for the anchor
15            if (i > 0 && nums[i] == nums[i - 1]) {
16                continue;
17            }
18            
19            // Step 3: Two pointers
20            int j = i + 1;
21            int k = nums.length - 1;
22            
23            while (j < k) {
24                int sum = nums[i] + nums[j] + nums[k];
25                
26                if (sum == 0) {
27                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
28                    
29                    // Skip duplicates for the second element
30                    while (j < k && nums[j] == nums[j + 1]) j++;
31                    // Skip duplicates for the third element
32                    while (j < k && nums[k] == nums[k - 1]) k--;
33                    
34                    j++;
35                    k--;
36                } else if (sum < 0) {
37                    j++;
38                } else {
39                    k--;
40                }
41            }
42        }
43        
44        return result;
45    }
46}