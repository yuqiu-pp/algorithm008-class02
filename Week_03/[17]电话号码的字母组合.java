//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法

package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.DDIV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LC17{
    public static void main(String[] args) {
        Solution solution = new LC17().new Solution();
        // TO TEST
        System.out.println(solution.letterCombinations("23"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Character, String> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        public List<String> letterCombinations(String digits) {
            if (digits.equals("")) {
                return res;
            }
            map.put('1', "");               map.put('0', "");
            map.put('2',"abc");             map.put('3', "def");
            map.put('4', "ghi");            map.put('5', "jkl");
            map.put('6', "mno");            map.put('7', "pqrs");
            map.put('8', "tuv");            map.put('9', "wxyz");

            helper(digits, 0, "");
            return res;
        }

        // n 格子数量
        // index 从digit的第几位开始处理， 也就是level
        private void helper(String digit, int index, String curr)  {
            if (curr.length() == index) {
                res.add(curr);
                return;
            }
            // 当前层：第一个格子填充  从2 对应string中 选1个 "" + String.valueOf(c)
            char ch = digit.charAt(index);
            String di = map.get(ch);
            for (char c : di.toCharArray()) {
                // 进入下一层 ：填下一个格子
                // 不要用digit.substring的方式切，1.有溢出问题 2.开销问题
                helper(digit, index+1, curr + String.valueOf(c));
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
