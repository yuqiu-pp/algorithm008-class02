//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针

package leetcode.editor.cn;

import java.util.Stack;

class LC42{
    public static void main(String[] args) {
        Solution solution = new LC42().new Solution();
        // TO TEST
        int[] height = {0,1,2,3,4,5};
        System.out.println(solution.trap2(height));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双指针：那边小，那边移动
        public int trap(int[] height) {
            int len = height.length;
            int l = 0;
            int r = len-1;
            // find the left and right edge which can hold water
            // while (l < r) {
            //     if (height[l] == 0 && height[l] <= height[l+1]) {
            //         l++;
            //     } else {
            //         break;
            //     }
            // }
            // 上面的语句简写。
            // ？ l+1是否会越界,增加条件l+1 < len   l<r，所以l+1最多等于r，不会越界；因此l<r必须是第一个条件
            while (l < r && height[l] <= height[l+1]) {
                l++;
            }
            while (l < r && height[r] <= height[r-1]) {
                r--;
            }

            int res = 0;
            while (l < r) {
                int left = height[l];
                int right = height[r];
                // left is smaller than right, so the (left-A[a]) water can be stored
                if (left <= right) {
                    while (l < r && left >= height[++l]) {
                        res += left - height[l];
                    }
                } else {
                    while (l < r && right >= height[--r]) {
                        res += right - height[r];
                    }
                }
            }
            return res;
        }

        // 单调递减栈，按层计算水量的思想
        public int trap2(int[] height) {
            if (height == null){
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                    // 小于时，可以存水，要出栈
                    // 每次计算一层，出栈一次
                    int poped = stack.pop();
                    // 栈顶元素相等，都要出栈，因为是同一层
                    while (!stack.isEmpty() && height[stack.peek()] == height[poped]){
                        stack.pop();
                    }
                    // 水量 = 宽*高 = （i - top - 1）* (min(height[i],height[top])-height[poped])
                    if (!stack.isEmpty()){
                        int top = stack.peek();
                        max += (Math.min(height[i],height[top]) - height[poped]) * (i - top - 1);
                    }
                }
                stack.add(i);
            }
            return max;
        }

        public int trap1(int[] height) {
            // 双指针：leftMax < rightMax，leftMax-A[l]，如果leftMax==l，那么两者相减为0
            // 双指针一般都是交替移动
            int l = 0;
            int r = height.length - 1;
            int max = 0;
            int leftMax = 0;
            int rightMax = 0;
            while(l <= r){
                leftMax = Math.max(leftMax, height[l]);
                rightMax = Math.max(rightMax, height[r]);
                if(leftMax < rightMax){
                    max += (leftMax - height[l]);
                    l ++;
                }
                else{
                    max += (rightMax - height[r]);
                    r --;
                }
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
