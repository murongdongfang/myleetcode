# 数组
+ 88合并两个有序数组
+ 283 把0移动到数组末尾，保证元素的向相对位置不变 eg
+ 27 删除数组中所有指定的元素 (26和27对比) √
+ 26 对有序数组中元素进行去重，返回去重后的元素长度 √
+ 80 26题变式（使每个元素 最多出现两次 ）
+ 75 三种数字进行排序： 计数排序思想，适用于元素种类有限的数组排序 eg
+ 88 合并两个有序的数组成为一个有序数组
+ 215 在一个整数数组中寻找第k大的元素：快排思想
+ 167 有序数组寻找和为target的索引：对撞指针 eg
+ 125 回文串
+ 344 返回倒叙字符串
+ 345 反转字符串中元音字母
+ 11 容器容纳水：对撞指针
双索引/对撞指针/滑动窗口
+ 209 连续子数组和小于target：滑动窗口 eg
+ 3 最小连续子数组，数组中没有重复的元素：滑动窗口 eg
+ 438
+ 76
+ 189 旋转数组 √

第283，27，26，80这四道题对比学习，里边都是在数组中删除和移动元素并保持元素相对位置不变的操作
没有bug的二分查找方法，75题和283题有内在的联系，
设计到字串的问题考虑使用滑动窗口，3，209，其中209题中包括了滑动窗口的模板写法

# 递归回溯+剪枝法
+ 17 电话按钮字母组合 √
+ 39 找出没有重复元素数组所有指定集合，要求每个集合中所有元素之和为给定值，原来数组中每个元素能够使用多次 √
+ 40 找出可能有重复元素数组所有指定集合，要求每个集合中所有元素之和为给定值而且原来数组中每个元素只能使用一次√
+ 46
+ 47
+ 77 递归回溯剪枝求取组合数 √
+ 78 没有重复元素的数组求所有子集：本质上就是求组合数  子集个数=1+C(n,1)+C(n,2)..+C(n,n); √
+ 90 可能包含重复元素数组求所有子集：先把数组排序，只有相邻元素不相等的时候才递归 √
+ 216
+ 401
+ 93 复原ip地址
+ 51， 315（和51一样）,327,493 归并排序的应用

总结：天然带有递归结构的数据结构又链表，树。排列组合一类问题，DFS都可以考虑使用递归的方式求解，
for+递归是解决排列组合问题的固定模板
# 二维平面上的递归问题
+ 79  四周搜索小技巧
+ 200 floodFill（DFS）
+ 130
+ 417
+ 51 N皇后问题变式：输出每一个解集合图形
+ 52 N皇后问题：只求解集个数
+ 37 数独问题求解

# 链表
+ 206 逆转单链表：普通方法/递归  √
+ 92 逆转指定位置处的链表：普通方法/递归  √
+ 203 删除单链表指定节点：普通方法/虚拟头节点删除单链表指定元素/递归删除，递归思想和21题类似 √
+ 83 排序链表删除重复元素，使得每个元素只能出现一遍：虚拟头节点/递归 √
+ 82 排序链表中只要出现重复元素，就把这个重复元素删除 普通方法/递归√
+ 86  分隔链表：虚拟头节点 √
+ 328 奇偶链表：
+ 2   链表数相加I
+ 445 链表数相加II √
+ 21  合并两个有序单链表：递归方法和203题类似 √
+ 24  交换相邻位置节点：递归方法和虚拟头节点的方法 √
+ 25  K个一组翻转链表
+ 147 对链表插入排序  √
+ 148 链表排序（归并排序）
+ 237  删除链表中当前节点（如何在没有pre指针的情况下删除当前节点） √
+ 19 删除倒数的第n个节点：链表双指针技术+虚拟头节点/递归删除 √
+ 61  旋转链表
+ 141 判断链表是否有环：哈希表/快慢指针 √
+ 142 环形链表 √
+ 143 重排链表
+ 234 判断回文链表：采用辅助栈/数组或者快慢指针+反转链表 √

 
**快慢指针在链表中的应用**：获取倒数第k个元素，获取中间位置的元素，判断链表是否存在环，判断环的长度  
**快慢指针的方法定位链表的中间节点原理19**：快指针移动速度是满指针的两倍，快指针到达链表尾节点满指针正好是中间的位置  
**快慢指针获取倒数第n个链表节点原理234，143**：头节点到正数第n个节点长度等于尾节点到倒数第n个节点长度。
**快慢指针判断链表是否有环原理141**：快慢指针沿着链表移动如果能够相遇就存在环     


总结：
基本操作：删除和插入常用方法虚拟头节点 eg：203，82，83，147需要滚瓜烂熟
反转链表，删除链表中的指定元素，这些都是链表题中的常规，一定要滚瓜烂熟，147对链表进行插入排序是链表中的指针操作的集大成者
逆转单链表206，逆转指定区间单链表92，删除单链表指定节点203，删除单链表指定倒数n节点19，
将两个顺序单链表合并成为一个顺序单链表21，交换相邻节点24，都存在相应的递归求解的方法，经常练练手可以更加深入理解递归。  
链表中递归模板：递归删除203，递归逆转206。这两个可以当成模板记忆
链表题中涉及到删除节点的操作通常需要头指针203，这样可以避免讨论待删除节点是头指针的情况  
链表中的模板：删除链表指定节点203

# 栈
+ 20 括号匹配 √
+ 150 逆波兰表达式 √
+ 71 简化路径
+ 144 利于栈先序遍历二叉树
+ 94 利用栈中序遍历二叉树
+ 145 利用栈后序遍历二叉树
+ 341

# 队列
+ 102 利用队列二叉树层次遍历：利用queue.size判断节点是否同一层 √
+ 107 二叉树层序遍历，从底向上：和102题方法思路一样 √
+ 103 二叉树之字形层次遍历：BFS/DFS：BFS对res.size进行取余操作，根据取余结果更改从头入队还是从尾入队√
+ 199 二叉树右视图：BFS/DFS，BFS右节点先入栈，每一层取出第一个即可  √
+ 279 一个数拆成最少个数的完全平方数之和：构造成图然后使用图BFS √
+ 127
+ 126

二叉树的层次遍历模板一定要牢记于心
总结：队列queue的一个经典用法就是用于树或者图的广度优先遍历，广度优先遍历如何判断队列中的节点是否属于同一层，
此时有一个小技巧需要借助于queue.size()，或者res.size()。围绕判断queue中的元素置否属于同一层这个考点BFS可以有107，103，199变式
# 优先级队列
+ 347 前k高词频
+ 23
# 树
+ 100 判断两个二叉树是否一致 √
+ 101 判断一颗二叉树是否左右对称 √
+ 110 判断一颗二叉树是否为平衡二叉树（和递归求二叉树高度类比） √
+ 112 判断从根到叶子所所经过路径节点之和为sum：注意递归的终止条件 √
+ 98 判断一棵树是否为二分搜索树 √
+ 958 判断一棵树是否为完全二叉树（BFS） √
+ 105或者剑指offer第7题：根据前序遍历和中序遍历还原二叉树 √
+ 104 求二叉树的最大深度 √
+ 111 求一颗二叉树的最低深度 √ （104题和111题相互对比）
+ 226 交换二叉树的左右孩子 √
+ 222 求一颗完全二叉树节点的个数 √
+ 404 求一颗二叉树所有的左叶子和
+ 257 求一颗二叉树所有从根节点到叶子节点所有路径的字符串
+ 113 
+ 129 
更复杂一点的递归逻辑
+ 437 相比112只要任意节点到任意节点都行，不要求从根节点到叶子节点
二分搜索树中的问题  
+ 235 二分搜索树中任意两个节点最近公共祖先 √
+ 236 任意一颗二叉树中寻找任意两个节点的最近公共祖先 √ A和B的一定位于最近公共祖先的左右两侧
+ 450 删除一个二分搜索树中的一个节点
+ 108 将一个有序数组转换成为二分搜索树
+ 230 再二分搜索树中寻找第k小的元素

二叉树基础问题搞懂这些有利于理解递归
求二叉树的深度，求二叉树的节点个数，交换二叉树所有节点的左右孩子



# 图

# 动态规划
+ 343 拆分正数，使得乘积最大 eg
+ 300 最长上升子序列  eg
+ 376
+ LCS   最长公共子序列  
+ knapsack01  01背包问题 eg
+ 完全背包问题，01背包问题的基础上每个物品可以无限使用
+ 多重背包问题，每个物品可以有限次数的使用
+ 打家劫舍问题
+ 416 判断一个数组是否可以分割为两部分，要求这两个部分的和是一样的  eg
+ 322 凑硬币
+ 377
+ 474
+ 139
+ 494

重点理解第343题416题还有01背包问题分别使用记忆化搜索算法和动态规划

# 排序
+ 归并排序（二叉树后续遍历）：51 求逆序对
+ 快速排序：单路快排，二路快排，三路快排，75 三色国旗 215 第k大的元素  
**单路快排和二路快排的缺点**


# 贪心
+ 455 分饼干 eg
+ 392 判断一个字符串是不是另一个字符串的子序列（子序列不需要连续，子串需要连续）
+ 435 不重叠的区间个数 eg

贪心算法和排序密不可分
