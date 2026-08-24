// Last updated: 8/24/2026, 8:07:04 PM
// This solution first skips all leading whitespace and parses the optional sign bit. It then iterates through the numeric characters, accumulating the total value using standard arithmetic (result = result * 10 + digit). To prevent integer overflow, intermediate values are held in a 64-bit long variable, and boundaries are clamped immediately to Integer.MAX_VALUE or Integer.MIN_VALUE whenever an overflow is detected. This single-pass linear approach runs in $O(N)$ time complexity and uses $O(1)$ auxiliary space.
1class Solution {
2    public int myAtoi(String s) {
3        if (s == null || s.length() == 0) {
4            return 0;
5        }
6
7        int index = 0;
8        int n = s.length();
9
10        // 1. Skip leading whitespace
11        while (index < n && s.charAt(index) == ' ') {
12            index++;
13        }
14
15        if (index == n) {
16            return 0;
17        }
18
19        // 2. Check optional sign
20        int sign = 1;
21        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
22            sign = (s.charAt(index) == '-') ? -1 : 1;
23            index++;
24        }
25
26        // 3. Convert digits and handle overflow
27        long result = 0;
28        while (index < n && Character.isDigit(s.charAt(index))) {
29            int digit = s.charAt(index) - '0';
30
31            result = result * 10 + digit;
32
33            // 4. Round if out of 32-bit signed integer range
34            if (sign == 1 && result > Integer.MAX_VALUE) {
35                return Integer.MAX_VALUE;
36            }
37            if (sign == -1 && -result < Integer.MIN_VALUE) {
38                return Integer.MIN_VALUE;
39            }
40
41            index++;
42        }
43
44        return (int) (sign * result);
45    }
46}