Package


# Access modifier->
Private: The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
Default: The access level of a default modifier is only within the package. It cannot be accessed from outside the package. 
If you do not specify any access level, it will be the default.

* Protected: The access level of a protected modifier is within the package and outside the package through child class. 
If you do not make the child class, it cannot be accessed from outside the package.
Parent Class A where protected method and variables are there , if we need to access that from outside package then 
Child B should extend Parent Class A.

Public: The access level of a public modifier is everywhere. It can be accessed from within the class, outside the class ,
within the package and outside the package.

* If you make any class constructor private, you cannot create the instance of that class from outside the class.

# IMP
*** 
If you are overriding any method, overridden method (i.e. declared in subclass) must not be more restrictive

class A{  
protected void msg(){System.out.println("Hello java");}  
}

public class Simple extends A{  
void msg(){System.out.println("Hello java");}//C.T.Error -> void msg() -> default method

public static void main(String args[]){  
Simple obj=new Simple();  
obj.msg();  
}  
}
***