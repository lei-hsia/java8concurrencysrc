#### hashmap
1. 说说你对hash算法的理解
	1. 追问：hash算法任意长度的输入 转化为了 固定长度的输出，会不会有问题呢？
	2. 追问：hash冲突能避免么？
2. 你认为好的hash算法，应该考虑点有哪些呢？
3. HashMap中存储数据的结构是什么样的呢？
4. 创建HashMap时，不指定散列表数组长度，初始长度是多少呢？
	1. 追问：散列表是new HashMap() 时创建的么？
5. 默认负载因子是多少呢，并且这个负载因子有什么作用？
6. 链表转化为红黑树，需要达到什么条件呢？
7. Node对象内部的hash字段，这个hash值是key对象的hashcode()返回值么？
	1. 追问：这个hash值是怎么得到呢？
	2. 追问：hash字段为什么采用高低位异或？
8. HashMap put 写数据的具体流程，尽可能的详细点！
9. 红黑树的写入操作，是怎么找到父节点的，找父节点流程？
10. TreeNode数据结构，简单说下。
11. 红黑树的原则有哪些呢？
12. JDK8 hashmap为什么引入红黑树？解决什么问题？
	1. 追问：为什么hash冲突后性能变低了？【送分题】
13. hashmap 什么情况下会触发扩容呢？
	1. 追问：触发扩容后，会扩容多大呢？算法是什么？
	2. 追问：为什么采用位移运算，不是直接*2？
14. hashmap扩容后，老表的数据怎么迁移到扩容后的表的呢？
15. hashmap扩容后，迁移数据发现该slot是颗红黑树，怎么处理呢？

#### threadLocal

1. 大体说下你对 ThreadLocal的理解？
2. ThreadLocal的原理是什么呢？
	1. ThreadLocalMap内存储的是什么？
	2. ThreadLocal它是怎样做到线程之间互不干扰的呢？
	3. 老版本JDK的ThreadLocal是怎么设计的呢？
3. JDK8 版本的ThreadLocal设计有什么优势相比更早之前的老版本（不指jdk1.7，比jdk1.7还要老，可以认为是ThreadLocal第一版）？
4. ThreadLocalMap 存放数据时，数据的hash值是从Object.hashCode()拿到的，还是其它方式？为什么？
5. 为什么ThreadLocal选择自定义一款Map而没有沿用JDK中的HashMap？
6. 每个线程的 ThreadLocalMap对象 是什么时候创建的呢？
7. ThreadLocalMap 底层存储数据的数组长度 初始化是多少？
	1. 这个数组大小为什么必须为 2的次方数？
	2. ThreadLocalMap的扩容阈值是多少呢？
	3. ThreadLocalMap达到扩容阈值一定会扩容么？
	4. 扩容算法 你简单说一说。
8. ThreadLocalMap对象的 get逻辑，你说下。
	1. 假设get首次未命中，向下迭代查找时，碰到过期数据了，怎么处理？
	2. 探测式清理过期数据，向下迭代过程中碰到正常数据，怎么处理？
9. ThreadLocalMap set数据流程，大体说一下。
	1. set数据时碰到过期数据了，需要做替换逻辑，这个替换逻辑是怎么做的？


#### 红黑树 

手撕红黑树

#### CAS

1. JDK的CAS操作: 4个变量:
	- `obj`
	- `offset`
	- `expected`
	- `value`
	
	java提供了对CAS操作的支持, 在sun.misc.unsafe类中, 声明如下: `public final native boolean compareAndSwapObject/Int/Long(Object var1, Object var2, Object var4, Object var5)`

2. CAS实现原理: 通过调用JNI代码实现, JNI:Java Native Interface, 允许java调用其他语言；而compareAndSwapXXX系列的方法就是借助C语言来调用CPU底层指令实现的；(8大数据原子指令): e.g. Intel x86_64平台，最终映射到CPU指令为"cmpxchg", 这是一个原子指令

3. 多核CPU，`cmpxchg`如何保证多核下线程安全？"bus总线加`lock`"

4. CAS的问题: ABA问题: 解决办法: 加version: `AtomicStampedReference`

#### io多路复用

1. BIO缺陷
2. 针对C10K的需求, NIO靠什么解决问题
3. 多路复用OS函数 select 工作原理
4. 多路复用OS函数 select 默认监听socket数量为什么是1024？
5. 多路复用OS函数 select 第一遍O(N)未发现就绪的socket，后续在某个socket就绪后，select如何感知的(socket:读缓存,写缓存,等待队列)？是不停轮询吗？
6. 多路复用OS函数 select和poll的区别？
7. 为什么有epoll这个技术，产生背景？
8. epoll函数的工作原理?
9. eventpoll对象的就绪列表数据是如何维护的？
10. eventpoll对象中存放需要检查的socket信息是用的什么数据结构? 为什么?

