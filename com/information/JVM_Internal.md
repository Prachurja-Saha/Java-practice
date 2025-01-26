
### 1. Class Loader Subsystem
The Class Loader Subsystem loads Java class files into memory for execution.

1. **Bootstrap Class Loader**: Loads core Java classes, like `java.lang.String`.
2. **Extension Class Loader**: Loads additional classes from the `jre/lib/ext` directory.
3. **Application Class Loader**: Loads classes from your program's specified paths.

Imagine you have a `.java` file. When you compile it, it becomes a `.class` file with bytecode. This bytecode is what gets loaded into the JVM.

### 2. Runtime Data Areas
The JVM uses several data areas to run your program.

1. **Method Area**:
    - Stores information about classes, like methods and variables.
    - Example: If you have a class `Person`, information about its methods (e.g., `getName()`) and variables (e.g., `age`) is stored here.

2. **Heap**:
    - Where Java objects are created.
    - Example: When you create a new `Person()`, that object lives in the heap.

3. **Java Stack**:
    - Each thread (like a mini-program) has its own stack that holds method calls and local variables.
    - Example: If a method in `Person` is called, its variables are stored in the stack.

4. **PC (Program Counter) Register**:
    - Each thread has a PC register that keeps track of which instruction is being executed.
    - Example: A thread executing a loop will update its PC register with each iteration.

5. **Native Method Stack**:
    - Used for native methods, which are not written in Java but other languages like C/C++.
    - Example: If `Person` calls a C++ method for more efficient processing, it uses the native method stack.

### 3. Execution Engine
The Execution Engine runs the bytecode.

1. **Interpreter**:
    - Reads and executes bytecode one instruction at a time.
    - Example: If your `Person` class has 10 instructions, the interpreter runs each in sequence.

2. **Just-In-Time (JIT) Compiler**:
    - Converts bytecode to native machine code for faster execution.
    - Example: Frequently executed methods in `Person` are compiled to machine code, making them run faster.

3. **Garbage Collector**:
    - Frees up memory by removing objects no longer in use.
    - Example: If your `Person` object is no longer needed, the garbage collector deletes it to free up memory.

### 4. Java Native Interface (JNI)
JNI allows Java to call native applications.

1. **Native Method Interface**: Lets Java interact with native code.
2. **Native Method Libraries**: These libraries are platform-specific.

### 5. Native Method Interface
This interface connects the JVM to native libraries needed for executing native methods.

1. **Platform-specific Libraries**: Perform tasks outside the JVM's domain.
2. **Functionality Extension**: Boosts Java capabilities by using platform-specific functions.
