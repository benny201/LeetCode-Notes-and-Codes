# Linked List

## 栈空间和堆空间
* reference引用：类似于C＋＋中的pointer
* 栈空间：一些基本类型的变量和对象的引用变量都是在函数的栈内存中分配
* 堆空间：堆内存用于存放由new创建的对象和数组
* 引用变量是普通变量，定义时在栈中分配内存，引用变量在程序运行到作用域外释放
* 数组和对象在没有引用变量指向它的时候，才变成垃圾，不能再被使用，但是仍然占着内存，在随后的一个不确定的时间被垃圾回收器释放掉。这个也是java比较占内存的主要原因.

## Array & Linked List
* 

## Dummy Node
* pseudo-head
* save head information
* 创建prev 和 curt node
* curt != null && curt.val 先判断对象是否为空

## reverse linked list

* 1 -> 2 -> 3
* pre -> null; cur -> 1;
* 反转就是 1 指向 pre， 2 指向 cur， 然后pre ＝ 2， cur ＝ 3；

```java
		ListNode pre = null;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        
        return pre;
```






