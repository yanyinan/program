package LongestSubstringWithoutRepeating;

public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128]; // 假设使用ASCII字符集
        int left = 0;

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            // 如果字符已经在窗口内，更新左边界
            if (charIndex[currentChar] > 0) {
                System.out.println(charIndex[currentChar]);
                System.out.println("left" +left);
                left = Math.max(left, charIndex[currentChar]);
            }
            // 计算当前子串长度并更新最大长度
            System.out.println("maz"+maxLength);
            maxLength = Math.max(maxLength, right - left + 1);
            // 更新字符的出现位置
            charIndex[currentChar] = right + 1;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        int result = lengthOfLongestSubstring(input);
        System.out.println("最长子串的长度为: " + result);
    }
}

