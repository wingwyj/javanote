## JAVA_BASE
 ### final关键字
   * 修饰`类`，不能被继承，类中所有方法被隐式指定未final。
   * 修饰`方法`，不能被重写(继承), 可以任意重载。
   * 修饰`变量(成员变量、局部变量)`，变量值不能被更改，final修饰变量需要声明是被赋值或者类构造方法中赋值。
   > ```java
   > /**
   > * todo思考原因？
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
 ### 序列化
   * 什么是序列化？  
     > **序列化** 是将内存中对象信息转化为可存储(传输)的字节序列过程。  
     > **反序列化** 是将磁盘(网络传输)中的字节序列转化为具体的对象过程。  
   * 序列化的原因？  
     > 需要将内存中数据存储到磁盘或者通过网络传输出去。**序列化最终目的** 是为了`跨平台存储`或者`网络传输`，而跨平台和网络传输的方式是 **IO** ，IO支持的数据结构是字节数组。  
   * 常见的序列化方式  
     > jdk自带，xml序列化，**JSON**（fastJSON、Jackson、Gson），**ProtoBuf**，Hessian，Kryo等。  
 ### Java两种动态代理
   * JDK动态代理
     > * 需要`接口`代理类和被代理类实现统一接口，实现InvocationHandler(把被代理对象传给Invocation)；  
     > * 代理类中通过`反射`拿到被代理类的方法，调用代理类的方法时会拿被代理类的方法去Invocation中去执行；  
   * CGLB动态代理
     > * 不需要接口，是通过`继承`被代理类实现;
     > * `动态生成继承子类(代理)` 通过调用代理对象的方法，跳转到自定义拦截器中进行代码增强，增强后调用父类的方法;
