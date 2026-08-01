// Last updated: 8/1/2026, 11:39:15 PM
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        java.util.HashSet<Character> set = new java.util.HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, shrink the window from the left
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // Add the current character to the set
            set.add(s.charAt(right));
            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}