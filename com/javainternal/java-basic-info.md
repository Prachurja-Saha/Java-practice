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

# Why is the Java main method static?
Ans: It is because the object is not required to call a static method. If it were a non-static method, 
JVM creates an object first then call main() method that will lead the problem of extra memory allocation.

# main method
When you run a Java program, the JVM looks for this exact method signature: public static void main(String[] args)
and starts execute from there

# How JAVA works
Java source code is written in plain text .java files (i.e MyClass.java)
source code is `compile`(after compilation) The compiler creates a .class file (MyClass.class) in the same folder 
(or in a bin folder if specified). .class file contains bytecode, which the JVM can execute.
JVM must be installed on a target computer(JVM is platform dependent, `different OS has different JVM which converts
byte code to machine level code`[1 & 0s]) <- `AT RUN TIME`
`No JAR is created. The JVM just reads the bytecode from .class files.`

# JVM is platform dependent for different OS different JVM (which converts java byte code to machine level code)
# because JVM is platform dependent  ---->  JAVA byte code is platform independent

# Java Compiler
1. command: [javac <Class-Name>.java] after compilation
   [`<Class-Name>.class` (contains byte code) and pass to JVM ]
2. command: [java <Class-Name>] -> command for JVM(byte code `.class` file) to machine level code (running application)
   JVM knows it is .class file so the command don't have .class [java <Class-Name>]


