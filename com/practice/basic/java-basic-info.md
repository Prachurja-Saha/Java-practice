
// JRE, JVM, JDK

JVM -> JAVA Virtual machine
1) Provides runtime environment in which Java bytecode can be executed.
2) Platform independent

JRE -> JAVA runtime environment
1) Set of software tools which are used for developing Java applications
2) It contains a set of libraries + other files that JVM uses at runtime.
3) It is the implementation of JVM

JDK -> JAVA Development kit
The JDK contains a private Java Virtual Machine (JVM) and a few other resources such as an interpreter/loader (java),
a compiler (javac), an archiver (jar), a documentation generator (Javadoc), etc. to complete the development of
a Java Application.

JDK : { 
JRE: {JVM, Set of libraries, other files}, 
Development tool : {i.e javac, javadoc..etc} 
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
1) this() method will call the default constructor
2) this(5) method will call the parameterized constructor
3) Student(int roll,String name,String course){  
   this.roll=roll;  
   this.name=name;  
   this.course=course;  
   }  

   Student(int roll,String name,String course,float fee){  
   this(roll,name,course);//reusing constructor-->IMPORTANT:this(roll,name,course)should be always before this.fee = fee
   this.fee=fee;  --> should After - this(roll,name,course)
   }
4) We can pass this as an argument: 
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

