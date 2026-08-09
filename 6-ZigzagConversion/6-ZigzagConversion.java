// Last updated: 8/9/2026, 4:40:07 PM
class Solution {
    public String convert(String s, int numRows) {
        // Edge cases: if 1 row or string length <= numRows, no conversion needed
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Initialize a StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = false;

        // Traverse each character in the string
        for (char c : s.toCharArray()) {
            rows[currRow].append(c);

            // Reverse direction when hitting the top or bottom row
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currRow += goingDown ? 1 : -1;
        }

        // Combine all rows into a single result string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}