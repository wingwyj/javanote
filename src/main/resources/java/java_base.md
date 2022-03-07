## JAVA_BASE
 ### String 的不可变
   * String被final修饰是不可变类，不能被继承。  
   * String中存储数据的数组被private和final修饰(private final char value[];)。final使char数组的引用地址不可变，private私有化使数组value不能被外部类修改，不过不可变的`核心因素`是String中没有提供修改char数组value的public方法。  
 ### String、StringBuilder、StringBuffer 区别  
   #### 线程安全  
   > 1.`String 线程安全` 其不可变保证其线程安全。  
   > 2.`StringBuilder 非线程安全` StringBuilder 没有对方法加同步锁(synchronized)。  
   > 3.`StringBuffer 线程安全` StringBuffer 对方法加了同步锁(synchronized)全。(StringBuilder 和 StringBuffer 都继承了AbstractStringBuilder类，存储用的char数组在抽象类中)  
   #### 性能
   > 1.`String` 每次修改都会创建新对象，然后将引用指向新的对象。  
   > 2.`StringBuilder` 每次修改是修改对象本身，单线程效率更高(数据量大)。  
   > 3.`StringBuffer` 每次也是修改对象本身，多线程中保证线程安全。  
 ### final关键字
   * 修饰`类`，不能被继承，类中所有方法被隐式指定未final。  
   * 修饰`方法`，不能被重写(继承), 可以任意重载。  
   * 修饰`变量(成员变量、局部变量)`，`基础变量`是值不能被更改，`引用变量`是引用地址值不可被更改(地址所指的对象value可变)。final修饰变量需要声明时被赋值或者类构造方法中赋值。  
   > ```java
   > /**
   > * todo 思考原因？
   > * 1.final 修饰的变量编译的时候会被优化认为是常量。  
   > * 2."+" 号两边如果都是常量，编译时jvm会直接优化看成一个常量。  
   > * 3."+" 号两边有引用类型，通过反编译(javap -c 或者可通过idea查看)后,  
   > *   看到是通过new StringBuilder对象调用append()来实现的。  
   > * 4."+" 号两边有null时，查看StringBuilder源码可看到对null时会被转成字符串"null"。
   > **/
   > public void finalTest() {
   >    String a = "hello2";
   >    final String b = "hello";
   >    String e = "hello";
   >    String c = b + "2";
   >    String d = e + "2";
   >    String f = "hello" + "2";
   >
   >    System.out.println(a == c); // true
   >    System.out.println(a == d); // false
   >    System.out.println(b == e); // true
   >    System.out.println(a == f); // true
   > }
   > ```
 ### Java中只有值传递
   * 对于`基本类型`, 方法的形参相当于copy一份。因此，对形参的修改不会影响实参。  
   * 对于`引用类型`, 方法的形参其实是引用对象的`内存中地址值`。因此，对形参修改不会影响实参(地址值)，但是对`引用对象`的修改会改变实参。  
 ### 循环中 continue、break、return 区别
   * continue 结束本次循环继续执行下一次循环；  
   * break 直接跳出其最近的一层循环(如果加了标识，就会直接跳到标识所在层循环)；  
   * return 直接跳出多层循环；  







