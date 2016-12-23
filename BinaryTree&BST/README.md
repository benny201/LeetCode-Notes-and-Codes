# BinarySearch Notes     
     
## 1 递归     

### 1.1递归三要素

* 递归的定义
* 递归的拆解
* 递归的出口
     
#      
### 2 Binary search 

#### 2.1 Find the first/any/last position      
     
#### 2.2 algorithm which rumtime is O(log n) is almost BinarySearch      
     
#### 2.3 指针变化
* 2.3.1 while(start + 1 < end); 相邻则退出；      
* 2.3.2 while(start < end); 相等则退出；            
     
#### 2.4 结束条件        
#### 2.5 tempalte:     
```
if (nums == null || nums.length == 0) {
	return -1;
}
int start = 0;
int end = nums.length - 1;
while (start + 1 < end) {
	int mid = start + (end - start)/2;

	if (nums[mid] == target) {
		return mid;
	}

	if (nums[mid] < target) {
		start = mid;
	} else {
		end = mid;
	}
}
if (nums[start] == target) {
	return start;
} 
if (nums[end] == target) {
	return end;
}

return -1;

```        
      
#### 2.6 二分位置／Binary Search on Index       
* 2.6.1 把问题转化成探讨找第一个符合标准的index／最后一个符合的index       

#### 2.7 倍增法／二分法的延伸     
#### 2.8 BinarySearch on Result      
* 2.8.1 sqrt();     

#      

### 3 BFS > DFS     
#### 3.1 BFS:非递归，业界尽量避免递归，避免栈溢出。(栈空间)
      
#       
### 4 树遍历一般考非递归,多讨论     

###
