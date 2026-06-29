
# All instance member (primitive/ Non-primitive) memory allocation will be inside heap b/c to use instance member 
# we need create an object. When you create an object using the new keyword, all its instance variables are stored in the heap.

Primitives: These are basic data types like int, char, float, etc. They hold actual values directly. 
In the context of a class, if a primitive type is an instance variable, it is stored in the heap as part of the 
object's state. However, primitives themselves do not refer to objects—they simply hold their values.
in primitive both the reference (if applicable) and the value are stored in the heap as part of the object.

int a = 10; 
int b = a; // it will create copy not like object 

Heap:
-------------------------
| Object (Example)      |
|-----------------------|
| int a = 10            |
| int b = 0             |
| String c -> [address] |
-------------------------

# Local variables in Java, primitive types, are allocated on the stack. and non primitive in Heap
Stack:
--------------------------------
| Method Frame (myMethod)      |
|------------------------------|
| int x = 5                    |
| String y -> [address of "Hello"] |
--------------------------------

Heap:
--------------------------------
| String Object ("Hello")      |
--------------------------------

`whether it's an instance variable or a local variable—the memory for non-primitive type objects 
(like arrays or instances of classes) is created in the heap.`



+--------------------------------------+
|          Java Virtual Machine        |
+--------------------------------------+
|                                      |
|   +-----------------------------+    |
|   |       Method Area           |    |
|   +-----------------------------+    |
|                                      |
|   +-----------------------------+    |
|   |          Heap               |    |
|   |  +-----------------------+  |    |
|   |  |   Garbage Collector   |  |    |
|   |  +-----------------------+  |    |
|   +-----------------------------+    |
|                                      |
|   +-----------------------------+    |
|   |   Native Method Stack       |    |
|   +-----------------------------+    |
|                                      |
|   +-----------------------------+    |
|   |  Stack (for each thread)    |    |
|   +-----------------------------+    |
|                                      |
|   +-----------------------------+    |
|   |  PC (Program Counter)       |    |
|   +-----------------------------+    |
|                                      |
|   +-----------------------------+    |
|   |     Runtime Data Area       |    |
|   +-----------------------------+    |
|                                      |
+--------------------------------------+

# Java : is good in CPU bound task (To run Java SE we don't need any server)
`CPU bound task`: A CPU-bound task is one that requires significant computation and processing power. 
These tasks utilize the CPU extensively and often involve complex calculations or operations.
Example: Prime Number Calculation: Finding all prime numbers up to a large value.

Non-Blocking I/O
Non-blocking I/O operations allow other operations to continue before the previous I/O operation completes. 
This is useful for applications that require handling many simultaneous I/O operations efficiently, 
such as servers and real-time applications.

Example:
Reading Data from a Socket: Non-blocking read operations from a network socket/file.

Where Is a Method Like display() Stored?
- Methods are part of the class definition, and their bytecode is stored in the Method Area (also known as the Class Area).
- The Method Area is part of the JVM memory structure where class metadata, method code, and static variables reside.
- When a method like display() is called, its execution context (including local variables) gets stored in the Stack Memory.

Execution Flow in Memory:
- Method Definition (display()) → Stored in the Method Area.
- When display() is called → A new frame is created in the Stack Memory.
- Local variables inside display() → Stored in the Stack Memory.
- If display() accesses instance variables → They remain in Heap Memory.


----------------------------------------------------------
|                      JVM Memory                       |
| ------------------------------------------------------ |
|  Method Area                                          |
|  - Stores class metadata                              |
|  - Stores static variables                            |
|  - Stores method bytecode                             |
| ------------------------------------------------------ |
|  Heap Memory                                          |
|  - Stores objects and instance variables             |
| ------------------------------------------------------ |
|  Stack Memory                                         |
|  - Stores local variables                            |
|  - Stores method call frames                         |
|  - Each thread has its own stack                     |
| ------------------------------------------------------ |
|  Native Method Stack (Optional)                      |
|  - Stores native method calls                        |
| ------------------------------------------------------ |



