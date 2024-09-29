# ABSTRACTION
Abstraction is a process of hiding the implementation details and showing only functionality to the user.
There are two ways to achieve abstraction in java
* Abstract Class
  An abstract class must be declared with an abstract keyword.
  It can have abstract and non-abstract methods.
  It cannot be instantiated.
  It can have constructors and static methods also.
  It can have final methods which will force the subclass not to change the body of the method.

* If there is an abstract method in a class, that class must be abstract.

* Rule: If you are extending an abstract class that has an abstract method, 
        you must either provide the implementation of the method or make this class abstract.

* The abstract class can also be used to provide some implementation of the interface. In such case, 
  the end user may not be forced to override all the methods of the interface.

INTERFACE
* Drawable interface has only one method.
* Supports Multiple inheritance.