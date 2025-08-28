package algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题目：给定一个字符串，求最长不重复子串的长度
 *
 * @author wyj
 * @version 1.0
 * @date 2025/5/24
 */
public class LengthStringAlgorithm {
    @Test
    public void test() {
        String str = "abcabcbb";
        System.out.println(lengthMax(str));
    }

    /**
     * 优化：使用map存储字符最后出现的位置,有重复后left直接跳到重复字符的下一个位置
     * @param str
     * @return
     */
    public int lengthMax(String str){
        int left = 0;
        int maxLength = 0;
        // 存储字符最后出现的位置
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);

            // 如果当前字符已经存在于map中，并且其位置大于等于left，则更新left
            if (map.containsKey(c) && map.get(c) >= left) {
                // 有重复了后，left跳到重复字符的下一个位置
                left = map.get(c) + 1;
            }
            map.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }


    /**
     * 这样写也会逐个清理set，性能不高
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    /**
     * 滑动窗口法
     *
     * @param s
     * @return 最长子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.clear(); // 频繁的清空操作，性能不高
                set.add(c);
                left = i;
                right = i;
            }
        }
        return maxLength;
    }
}
