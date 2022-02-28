###Java源码阅读
#### 集合篇
____
**ArrayList**
1. RandomAccess接口  
   标记接口没有具体的方法，如ArrayList实现了此接口，LinkList没有实现此接口，可以用instanceof 来区分这两个集合。
2. Cloneable接口  
   实现此接口colne()方法，可以实现浅拷贝

 