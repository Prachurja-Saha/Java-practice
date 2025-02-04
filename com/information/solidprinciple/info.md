# Solid principle 
set of five design principles intended to make software designs more `understandable`, `flexible`, and `maintainable`. 
They are frequently used during Object-Oriented Software Development (OOP).

1. [S]Single Responsibility Principle (SRP) : Class should have only one reason to change, 
                                              meaning that a class should only have one job or responsibility.
Example: Service class -> We are calculating invoice, saving DB, and calling external service (Not following SRP)
         Class has multiple responsibilities (should have only one responsibility)

Solution : 
Invoice Calculation: You could have a class specifically for handling the logic of invoice calculation.
Database Operations: A separate repository class using JPA to save data to the database.
External Service Calls: Another class dedicated to managing external service integrations.

2. [O]Open/Closed Principle (OCP): suggests that software entities (classes, modules, functions, etc.) should be open 
                                   for extension but closed for modification. (If there is new responsibility)
                                   This means that the behavior of a module can be extended without modifying its 
                                   source code. [Open for extension closed for modification]
[If in SF case for generic case creation there is certain fields for that I created Case Class, Now for different 
Case create scenarios has different fields for that I extends case class and create new class without modiying case class
There is a possibilities where i have to override some methods based on scenarios of different class]
Above here I am not modifying Case class, I am creating new class and overriding and modifying based on the scenario
Example :  pls check the OCP.java Class

3. [L]Liskov Substitution Principle (LSP): This principle states that objects of a superclass should be replaceable with
                                           objects of a subclass without affecting the correctness of the program. 
                                           Essentially, derived classes must be substitutable for their base classes.
Example : LSP.java Class

4. [I]Interface Segregation Principle(ISP): Interface should be such that client/Implemented class shouldn't implement 
                                            unnecessary functions they do not need (solution is break the interface)
Example : ISP.java Class

5. [D] Dependency Inversion Principle(DIP): Class should depend on interface rather than concrete class.
                                            Example: Constructor injection [instead of tight coupling we can do loose]
i.e. 
interface ServiceInterface{
void getData();
}

public class Service implements ServiceInterface{
// Implements getData
}
public class Service2 implements ServiceInterface{
   // Implements getData
}
`Not floowing DIP`
public class DependentService { 
 Service s;
 DependentService(Service sc){ this.s = sc } ` Tight couple can't use implementaion of Service2 Class `
}

`Following DIP`
public class DependentService{
 ServiceInterface serviceInterface;
 DependentService(ServiceInterface sc){ this.serviceInterface =sc} `Loose couple can use implementaion of Service2 Class `
}