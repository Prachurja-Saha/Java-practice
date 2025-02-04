
# How JAVA works 
Java source code is written in plain text .java files
source code is `compile`(after compilation) into byte code .class files for the JVM
JVM must be installed on a target computer(JVM is platform dependent, different OS has different JVM which converts
byte code to machine level code[1 & 0s]) <- `AT RUN TIME`
JVM executes your application by translating java byte code instruction into platform independent code

# JVM is platform dependent for different OS different JVM (which converts java byte code to machine level code)
# because JVM is platform dependent JAVA byte code is platform independent

# Notes
1. System -> Class 
out -> static member of type PrintStream in System class (public static final PrintStream out = null;)
and println is the method of PrintStream class
System.out.println()
2. String xyz=" ", abc="x"; -> allowed, variable declared in method is called local variable
   In java there is no global variable, but there is static variable which can be access from any where if it is 
   not declare private

# Java Compiler
1. command: [javac <Class-Name>.java] after compilation 
[`<Class-Name>.class` (contains byte code) and pass to JVM(different OS has different JVM implementation 
so JVM platform dependent byte code platform independent) to convert this byte code to machine level code ]
2. command: [java <Class-Name>] -> command for JVM(byte code `.class` file) to machine level code (running application)
   JVM knows it is .class file so the command don't have .class [java <Class-Name>]


