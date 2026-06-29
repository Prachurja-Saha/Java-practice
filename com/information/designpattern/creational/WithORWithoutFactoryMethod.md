Key Differences and Benefits

# Separation of Concerns:
`Without Factory Method`: All the logic for object creation and the object's usage is in the same place. 
This can make the code harder to manage and extend.

[With Factory Method]: The object creation logic is separated from the usage logic. 
This adheres to the Single Responsibility Principle (SRP) as each class has one reason to change.

# Extensibility:
`Without Factory Method`: If you want to add a new shape, you need to modify the main method to include the new 
instantiation logic. This requires changing existing code, which can lead to bugs.

[With Factory Method]: Adding a new shape only requires creating a new factory class and modifying the factory selection 
logic. The client code that uses the factory remains unchanged.

# Polymorphism and Inheritance:
`Without Factory Method`: You might end up with a lot of conditional statements (if-else or switch) scattered 
throughout your code whenever you need to create a new shape.

[With Factory Method]: The factory method uses polymorphism and inheritance to encapsulate object creation. 
This makes the code cleaner and easier to extend.

# Consistency:
`Without Factory Method`: Different parts of the code might have different ways of creating objects, 
leading to inconsistency.

[With Factory Method]: A consistent approach to object creation is enforced across the codebase, making maintenance easier.