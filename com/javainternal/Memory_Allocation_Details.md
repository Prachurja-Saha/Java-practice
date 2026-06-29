When you run a Java program, memory is mainly divided into:

1. **Method Area (MetaSpace)**
2. **Stack Memory**
3. **Heap Memory**

Example program:

```java
class Student {
    int id = 10;

    void show() {
        int x = 5;
        System.out.println(id + x);
    }
}

public class Test {
    public static void main(String[] args) {

        int a = 20;

        Student s = new Student();

        s.show();
    }
}
```

---

# Step-by-step Memory Flow

---

# 1. Class Loading → Method Area

When JVM starts:

```java
class Student
class Test
```

Class metadata goes into **Method Area**.

Stored in Method Area:

* Class name
* Method definitions
* Static variables
* Runtime constant pool

So:

```text
Method Area
------------
Student class info
Test class info
main()
show()
```

---

# 2. main() Method Starts → Stack Memory

When JVM calls:

```java
main()
```

A **stack frame** is created inside Stack Memory. [Stack frame is structure of method]

```text
Stack
------
main frame
```

---

# 3. Local Variable Created

```java
int a = 20;
```

`a` is a local primitive variable.

Stored inside:

```text
Stack (main frame)
-------------------
a = 20
```

Primitive local variables stay directly in stack memory.

---

# 4. Object Creation → Heap Memory

```java
Student s = new Student();
```

Two things happen:

## A. Object created in Heap

```text
Heap
------
Student object
id = 10
```

## B. Reference variable stored in Stack

```text
Stack (main frame)
-------------------
s ----> Heap object
```

`s` does NOT store actual object.

It stores:

* memory address/reference of object.

---

# Visual Representation

```text
Method Area
-------------
Student class
Test class
main()
show()

Stack
-------------
main frame
a = 20
s -----------+

Heap
-------------|
Student Obj <-+
id = 10
```

---

# 5. Method Call

```java
s.show();
```

A new stack frame is created.

```text
Stack
----------------
show frame
x = 5

main frame
a = 20
s -----> Heap obj
```

---

# 6. Accessing Object Variable

Inside:

```java
System.out.println(id + x);
```

JVM:

* gets `x` from current stack frame
* gets `id` from heap object using reference `s`

---

# 7. Method Ends

After `show()` finishes:

```text
show frame removed
```

`x` disappears.

Stack becomes:

```text
Stack
----------------
main frame
a = 20
s -----> Heap obj
```

---

# 8. main() Ends

When `main()` completes:

* main frame removed
* `a` removed
* `s` reference removed

Now heap object has no reference.

```text
Heap
------
Student object (unreachable)
```

Then:

# Garbage Collector

JVM garbage collector later removes unreachable heap objects.

---

# Important Points

## Stack Memory

Stores:

* Method calls
* Local variables
* References

Characteristics:

* Fast
* Thread-specific
* Automatically cleaned

---

## Heap Memory

Stores:

* Objects
* Instance variables
* Arrays

Characteristics:

* Shared
* Larger memory
* Garbage collected

---

## Method Area

Stores:

* Class metadata
* Static variables
* Bytecode
* Methods

Shared across JVM.

---

# Primitive vs Reference

## Primitive

```java
int a = 10;
```

Stored directly in stack.

---

## Reference Type

```java
Student s = new Student();
```

* Object → Heap
* Reference `s` → Stack

---

# Array Example

```java
int[] arr = new int[3];
```

```text
Stack
------
arr -----> Heap array object

Heap
------
[0,0,0]
```

Array objects are always in heap.

---

# Short Flow Summary

```text
Program Start
   ↓
Classes loaded → Method Area
   ↓
main() called → Stack frame
   ↓
Objects created → Heap
   ↓
Method calls → New stack frames
   ↓
Methods end → Frames removed
   ↓
No references → GC removes heap objects
```
