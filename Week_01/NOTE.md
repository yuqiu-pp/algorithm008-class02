学习笔记

”五毒神掌“刷题法的体会：
1.对自己10分钟内想不出解法的题，直接学习解法。可以节约时间，避免打击信心；
2.各种解法要多看，选讲解易懂的看。看不透彻也没关系，大概理解，照着代码先练起来；
3.对5遍刷题，可以帮助自己把没理解透彻点理解清楚，把一些容易忽略的点让你体会到；

知识方面的总结：
1.对双指针的思想有了不错的理解；
总结为3类：快慢、左右夹逼、指向要替换位置
以前总是觉得双指针使用起来太乱，不容易搞清楚。这周刷了多道可以应用双指针技能的题，基本熟练的掌握了这项技能。
也熟悉了该技能的应用场景。

2.对整数取整、取模的应用场景有了进一步认识。避免总是往BigDecimal上靠；

3.解题的一个思考方式：找最近重复子问题，推导递推公式；

4.习惯了用双目运算符代替简单的if else；

5.跳过相同值的局部操作
while (l < r && nums[l] == nums[l-1]) {      l ++;    }

6.对循环的一些判断条件的边界
for (int i = 0; i < len-2; i++) { // 注意结束条件
    for (int j = i+1; j < len-1; j++) {
        for (int k = j+1; k < len; k++) {

7.在一些不要求保存中间结果的场景下，可以用变量，不需要数组
[1221]分割平衡字符串：因为只求数量，不要求把字符串也返回，所以用L -1，R +1，sum=0，相当于栈空；
[70]爬楼梯：递推公式 f(n) = f(n-1) + f(n-2)，只用两个变量来缓存f(n-1)、f(n-2)就可以，不需要保留每个值；

老师的授之于渔：
1.工具、检索；
2.阅读源码；