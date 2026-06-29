# JVM -> JAVA Virtual machine (piece of software where java code runs)
1) Provides runtime environment in which Java bytecode can be executed.
2) Platform dependent

# 1. Class Loader Subsystem
Reads .class files and stores class metadata in the Method Area (Memory).

`Loading` – Finds the .class file and brings it into memory. [During class loading JVM creates one special Class object 
   in the heap that holds information about the class. For every loaded “.class” file, only one object of the class is created]
        Example: class Test { 
                    int x = 10;
                        void show() {
                            System.out.println("Hello");
                        }
                    } 
        Class Object (in Heap) -> Class<Test> `Class object stores class info, and real objects store actual data.`
                                  Class<?> c = Test.class;

   How class loader finds classes -> The JVM uses the classpath to know where to look.
   Classpath can include: Folders containing .class files, .jar files

   When your program tries to use a class, like ArrayList, the class loader searches in this order (parent delegation model):
   [Bootstrap loader] → core Java classes (like `java.lang.String`.)
   [Extension loader] → optional libraries (classes from the `jre/lib/ext` directory.)
   [System/Application loader] → your program’s classes and other jars

Imagine you have a `.java` file. When you compile it, it becomes a `.class` file with bytecode.
This bytecode is what gets loaded into the JVM.

# 2. Linking – Prepares the class so JVM can use it:
 - Checks if it’s correct. [JVM checks that the class follows Java rules.
   Example: Makes sure bytecode isn’t corrupt and doesn’t break security.]
 - `Sets up memory` for static variables. [Assigns default values (like 0 for int, null for objects).]
   [ i.e. Method Area:
            x = 0          (default value)
            name = null    (default value) ]
 - Connects it with other classes it needs. [If your class uses OtherClass, JVM finds the actual memory address of OtherClass.]

# 3. Initialization – Runs any static { } blocks or assigns initial/actual values to static variables.

# 4. Method Execution  (JVM calls the main method, it checks method must be public static(no obj needed) void (correct signature))
A thread is created to run your program, Every Java program starts with one main thread
Stack memory created for that thread (each thread gets its own stack)

# 5. Object Creation and Memory Allocation
     When you do new MyClass():
Memory is allocated in Heap. Instance variables are set to default values Constructor runs → assigns actual values

1. Method Area:
    - Stores information about classes, like methods and variables.
    - Example: If you have a class `Person`, information about its methods (e.g., `getName()`) and variables (e.g., `age`) 
               is stored here. [Used during the class loading, used once per class]

2. Heap:
    - Where Java objects are created. Main memory for objects (All objects, instance variables)
    - Shared Across threads managed by garbage collectors 
    - Example: When you create a new `Person()`, that object lives in the heap. [used at runtime whenever obj is created]

3. Java Stack: 
    - [Stack memory area used by each thread to execute methods, every thread gets its own stack]
    - (stores local variable, method call, references [used during method call])
    - Each thread (like a mini-program) has its own stack that holds method calls and local variables.
    - Example: If a method in `Person` is called, its variables are stored in the stack.
    - ## STACK FRAME
    - [whole java application from start to end (memory flow): 1. method area (stores class info) 2. main thread created
      stack created for the main thread  3. stack frame (structure) for main method created 4. inside main (obj = new Obj()
      or int z = 0;)  here obj(reference) and int z = 0 are stored in stack but new Obj() stored in heap
      when obj.method1() called new stack trace is created for method1 same cycle goes  5. If method returns/ends stack
      frame removed and stack destroyed. Heap objects clean by GC]

4. PC (Program Counter) Register: [Small memory area per thread, store address(location of instruction) of current 
                                   executing instruction]
    - `Used during program execution. Why its needed (JVM supports multithreading, each threads run independently, 
       so each thread needs its own execution tracker) PC Register = current executing instruction tracker for each thread`
    - Each thread has a PC register that keeps track of which instruction is being executed.
    - Example: A thread executing a loop will update its PC register with each iteration.

5. Native Method Stack:
    - Used for native methods, which are not written in Java but other languages like C/C++.
    - Example: If `Person` calls a C++ method for more efficient processing, it uses the native method stack.

# 3. Execution Engine
The Execution Engine runs the bytecode.

1. Interpreter:
    - Reads and executes bytecode one instruction at a time.
    - Example: If your `Person` class has 10 instructions, the interpreter runs each in sequence.

2. Just-In-Time (JIT) Compiler:
    - Converts bytecode to native machine code for faster execution.
    - Example: Frequently executed methods in `Person` are compiled to machine code, making them run faster.

3. Garbage Collector:
    - Frees up memory by removing objects no longer in use.
    - Example: If your `Person` object is no longer needed, the garbage collector deletes it to free up memory.

# 4. Java Native Interface (JNI)
JNI allows Java to call native applications.

1. Native Method Interface: Lets Java interact with native code.
2. Native Method Libraries: These libraries are platform-specific.

# 5. Native Method Interface
This interface connects the JVM to native libraries needed for executing native methods.

1. Platform-specific Libraries: Perform tasks outside the JVM's domain.
2. Functionality Extension: Boosts Java capabilities by using platform-specific functions.
