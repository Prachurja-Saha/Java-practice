
# Polymorphism
* TWO TYPES
1) Compile time -> Method Overloading
   In method overloading the decision about which method to call is made at compile time.The compiler determines
   the correct method to call based on the method signature.
   No confusion that which method to call because of only one object and method can be differentiated based on signature
2) Run time -> Method Overriding
   In method overriding the method to be called as determined at runtime based on the actual object type not reference
   type. JVM determines the appropriate method to call at runtime

* UPCASTING -> If the reference variable of Parent class refers to the object of Child class, it is known as upcasting.
  example :
  class A{}  
  class B extends A{}
* Upcasting enables polymorphism, which allows a single interface to be used for a general class of actions. 
  This makes it easier to write flexible and reusable code.
* Parent reference -> multiple object implementation (gives flexibility)
  Using Upcasting we are only allowing common instance of super and child class

A a=new B();//upcasting

* Java Runtime Polymorphism with Multilevel Inheritance
  Example ->
  class Animal{  
  void eat(){System.out.println("animal is eating...");}  
  }  
  class Dog extends Animal{ 
  @override
  void eat(){System.out.println("dog is eating...");}  
  }  
  class BabyDog1 extends Dog{  
  public static void main(String args[]){  
  Animal a=new BabyDog1();  
  a.eat();  
  }}

OUTPUT -> Dog is eating
Since, BabyDog is not overriding the eat() method, so eat() method of Dog class is invoked b/c BabyDog1 extends Dog


# #########  ### BINDING ## ################################
* Binding 2 types
1) Static/Early Binding -> Static binding (also known as early binding) refers to the compile-time determination of
   which method or variable to call. This means that the method or variable to be accessed is determined by the compiler
   based on the reference type, not the object type.
   example ->
   class StaticBindingExample {
   public void display(int num) {
   System.out.println("Display method with integer parameter: " + num);
   }

   public void display(String str) {
   System.out.println("Display method with string parameter: " + str);
   }

   public static void main(String[] args) {
   StaticBindingExample example = new StaticBindingExample();
   example.display(10); // Calls the display(int num) method
   example.display("Hello"); // Calls the display(String str) method
   }
   }
2) Dynamic Binding ->
* Dynamic binding refers specifically to the method call resolution process.
* It means that the decision about which method implementation to execute (in the case of overridden methods)
* is made at runtime based on the actual object type, not the reference type.
  example ->
  abstract class ClassA {
  abstract void display();
  }

class ClassB extends ClassA {
void display() {
System.out.println("Display from ClassB");
}
}

class ClassC extends ClassA {
void display() {
System.out.println("Display from ClassC");
}
}

public class Main {
public static void main(String[] args) {
ClassA a1 = new ClassB(); // Instantiation at runtime
ClassA a2 = new ClassC(); // Instantiation at runtime

        a1.display(); // Dynamic binding: calls ClassB's display method
        a2.display(); // Dynamic binding: calls ClassC's display method
    }
}

When a1.display() is called,
the JVM looks at the actual object type of a1, which is ClassB, and calls the display method of ClassB.
When a2.display() is called,
the JVM looks at the actual object type of a2, which is ClassC, and calls the display method of ClassC.

## Static binding is determined by the compiler, whereas dynamic binding is determined by the JVM at runtime.
# ################################################################################################################