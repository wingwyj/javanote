## JAVA_BASE
 ### int 的最大值是2147483647,那int i = 2147483647 + 1;报错吗？
   > `不报错` 结果是-2147483648。超过范围后的异常显示。
 ### short s1 = 1;s1 = s1 + 1;有错吗？short s1 = 1;s1 += 1;有错吗？  
   > `前者有错误，后者没有。` 1 是int类型 s1 + 1 结果也是int类型，需要强转才可以赋值给short。而 `+=` 默认会强转，相当于s1 = (short)(s1 + 1)，所以编译不会报错。  
 ### == 与 equals() 区别  
   * 对于基本类型，`==` 比较的是值是否相等。  
   * 对于引用类型，`==` 比较的是两个对象的引用地址(对象所指的堆内存地址)是否相等。  
   * 对于引用类型(包括包装类型)，`equals` 没有被重写，则比较的是地址值。`equals` 被重写(如 String), 则比较的是引用地址里的内容。  
 ### hashCode()、equals() 总结  
   * `hashCode` 相等，对象不一定相同。  
   * `equals` 相等，对象一定相同。  
   * 两个对象相同，`hashCode` 不一定相等。  
   * 两个对象相同， `equals` 一定返回true。 
 ### 循环中 continue、break、return 区别
   * continue 结束本次循环继续执行下一次循环；  
   * break 直接跳出其最近的一层循环(如果加了标识，就会直接跳到标识所在层循环)；  
   * return 直接跳出多层循环；   
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
 ### final 关键字
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
 ### Java 中只有值传递
   * 对于`基本类型`, 方法的形参相当于copy一份。因此，对形参的修改不会影响实参。  
   * 对于`引用类型`, 方法的形参其实是引用对象的`内存中地址值`。因此，对形参修改不会影响实参(地址值)，但是对`引用对象`的修改会改变实参。  
 ### 序列化
   * 什么是序列化？  
     > **序列化** 是将内存中对象信息转化为可存储(传输)的字节序列过程。  
     > **反序列化** 是将磁盘(网络传输)中的字节序列转化为具体的对象过程。  
   * 序列化的原因？  
     > 需要将内存中数据存储到磁盘或者通过网络传输出去。**序列化最终目的** 是为了`跨平台存储`或者`网络传输`，而跨平台和网络传输的方式是 **IO** ，IO支持的数据结构是字节数组。  
   * 常见的序列化方式  
     > jdk自带，xml序列化，**JSON**（fastJSON、Jackson、Gson），**ProtoBuf**，Hessian，Kryo等。  
 ### Java 两种动态代理
   * JDK动态代理
     > 1.需要`接口`代理类和被代理类实现统一接口，实现InvocationHandler(把被代理对象传给InvocationHandler)，并将InvocationHandler传给代理类；  
     > 2.动态生成代理来，代理类通过`反射`拿到被代理类的方法，调用代理类实现的同一接口的方法时会拿被代理类的方法去InvocationHandler中去执行；  
     > 3.核心类是 `Proxy` 和 `InvocationHandler`。  
   * CGLB动态代理
     > 1.不需要接口，是通过`继承`被代理类实现;  
     > 2.`动态生成继承子类(代理)` 通过调用代理对象的方法，跳转到自定义拦截器中进行代码增强，增强后调用父类的方法;  
     > 3.核心类是 `Enhancer` 和 `MethodInterceptor`。
 ### Java 中的语法糖  
   `语法糖` 程序中某些特殊的语法，可以减少程序员的代码量，增加代码可读性，且不影响功能。Java中的语法糖在编译后就被还原成基础语法。所以，只有编译阶段支持语法糖，编译后Jvm执行的还是基础语法代码。  
   > **常见语法糖**
   > * `泛型` 通过类型擦除来实现的，Jvm中没有泛型。  
   > * `自动拆装箱` 8中基本数据类型的包装类和基本类型之间的装换。  
   > * `枚举` 枚举只是一个语法糖，在编译完成后就会被编译成一个普通的类，也是用 Class 修饰。这个类继承于 java.lang.Enum，并被 final 关键字修饰。  
   > * `Switch 支持字符串和枚举`  switch 关键字原生只能支持整数类型。如果 switch 后面是 String 类型的话，编译器会将其转换成 String 的hashCode 的值，所以其实 switch 语法比较的是 String 的 hashCode。
   > * `增强for循环`
   > * `变长参数`  
   > * `内部类`  
   > * `try-with-resources`  
   > 




