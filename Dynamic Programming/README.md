# Dynamic Programming

## 1.divide & conquer
* 后决策: 先让小弟递归，再自己判断        

```
return Math.min(divide(x+1), divide(x+2));
```    
## 2.DP也是后决策！   
     
## 3.DP的两种方法    
* 多重循环    
* 记忆化搜索    

### 3.1多重循环     
* 优点：正规，优化空间    
* 缺点: 思考难度
* bottom-up or top-down


### 3.2记忆化搜索
* 优点: 可以从搜索算法转化而成，可能更省时间    
* 缺点: 递归


## 4.可以考虑Greedy,但是Greedy不一定能解决。    

## 5.DP的使用条件(满足之一)
* 求最小值/最大值
* 判断是否可行
* 统计方案个数
* 有无后效性

## 6.不适用DP的问题
* 求出具体的方案, 而非个数(极有可能是用搜索来做！！！)     
* 输入的是集合,而不是数列(不一定，背包问题)     
* brute-force 的求解方法已是asypmtotic级别的(擅长将2^n优化成n^2)          

## 7.DP四要素
* State:sub-problem     
* Function:状态转移方程     
* Initialization:初始化(起点)     
* Answer:答案     
     
## 8.DP常见类型
* 坐标型
* 序列型
* 双序型
* 划分型
* 背包型
* 区间型     
      
### 8.1 坐标型
* State: F(x)/F(x,y) 从起点走到坐标x/坐标（x，y）.
* Funtion: 研究走到(x,y)之前的一步.
* intialize: 起点
* answer: 终点

### 知识点补充:     
 * subarray个数: n^2 个     
 * subsquence : 2^n 个

### 8.2 单序列     
* 一般是字符串序列     
* 区别：f[i] 表第i个的state / 坐标型中f[i]表前i个的state     
* Word Break : word的长度有限，可以先检测最长word     
* !!!: O(n^2) 下用递推检测一个String是否是回文串palindrome

### 8.3双序列型
* e.g longest common subsequence (LCS : an important eaxample)
* f[i][j] : substring(0,i) 以及 substring(0,j) 的结果   
* 研究最后一个字符的匹配关系.
* 分多种情况讨论f[i - 1][j - 1] & f[i - 1][j] & f[i][j - 1]的转化关系

  
