# ByteCode(intermediate form of code(1010) that machine can understand) is platform independent(can run anywhere)
// JRE, JVM, JDK

JRE -> JAVA runtime environment
1) Set of software tools which are used for developing Java applications
2) It contains a set of libraries + other files that JVM uses at runtime.
3) It is the implementation of JVM

# JDK -> JAVA Development kit (It includes several tools, utilities, and libraries that assist in Java programming.)
Key Components :
- Java Compiler (javac): Translates Java source code into bytecode.
- Java Runtime Environment (JRE): Part of the JDK that includes the JVM, core libraries, and other components necessary 
                                  for running Java applications.
- Java Virtual Machine (JVM): Interprets the compiled Java bytecode and executes it on the host machine, 
                              providing platform independence.
- Java Libraries: A comprehensive set of standard libraries that provide essential functionalities like data structures,
                  input/output operations, networking, graphical user interface development, etc.
- Java Debugger (jdb): Helps in debugging Java programs by providing features like setting breakpoints, 
                       examining variables, and stepping through code.
- JavaDoc: A tool used for generating API documentation in HTML format from Java source code comments.
- Java Archive (JAR) Tools: Utilities for packaging Java classes and associated resources into JAR files, 
                            which can be used to distribute Java applications and libraries.

JDK : { 
JRE: {JVM, Set of libraries, other files}, 
Development tool : {i.e. javac, javadoc..etc} 
} 

# Data types
1) Primitive types -> boolean, char, byte, short, int, long, float and double.
2) Non-Primitive types ->  String, Classes, Interfaces, and Arrays.

# Key words
1) synchronized
2) transient

# Why is the Java main method static?
Ans: It is because the object is not required to call a static method. If it were a non-static method, 
JVM creates an object first then call main() method that will lead the problem of extra memory allocation.

# this() constructor use 
 We can pass this as an argument: 
   class S2{  
     void m(S2 obj) {  
      System.out.println("method is invoked");  
     }  
     void p() {  
      m(this);  
     }  
   public static void main(String args[]){  
     S2 s1 = new S2();  
     s1.p();  
    }
   } 

# final keyword
- Final Variable
1) A static final variable that is not initialized at the time of declaration is known as static blank final variable. 
It can be initialized only in static block.
   example->
   class A{  
   static final int data;//static blank final variable  
   static{ data=50;}  
   public static void main(String args[]) {  
   System.out.println(A.data);  
    }  
   }  
2) Constructor cannot be final

- Final Method
  A method declared as final cannot be overridden by subclasses. This is useful when you want to make sure that 
  the method's implementation remains unchanged in any derived class.

- Final Class
  A class declared as final cannot be subclassed. This means no other class can extend a final class. 
  This is used to prevent inheritance, ensuring that the class's implementation cannot be altered through subclassing.

- Final Parameters
  A method parameter declared as final means that within the method, 
  the parameter cannot be reassigned to refer to a different object.
  public void display(final int age) {
  age = 25;  // Compilation error
  }


# IMP ----> Data type
1. Primitive -> Size fix. -> This is the only part in java which is not object type so java is not fully 100% OOP
                              this will not extend object class
    int x = 10; x-> primitive variable

2. Non-Primitive -> Size not fix. -> Object type stores in heap memory
    String s = "abc" -> reference variable
    Integer x = 11 size not fixed

### -> == compares object reference only allowed for primitive and String literal
