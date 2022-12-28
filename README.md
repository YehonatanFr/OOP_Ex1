# OOP_Ex1
Ex1 in OOP Course.
The project were wriiten by:
- [Yehonatan Friedman](https://github.com/YehonatanFr?tab=repositories)
+ [Hagay Knorovich](https://github.com/hagayknoro)

In This Ex we will practice about Design patterns, we will learn about Observer, one of many kind of Design patterns.
## About Design Patterns
A design pattern provides a general reusable solution for the common problems that occur in software design. The pattern typically shows relationships and interactions between classes or objects. The idea is to speed up the development process by providing well-tested, proven development/design paradigms. Design patterns are programming language independent strategies for solving a common problem. That means a design pattern represents an idea, not a particular implementation. By using design patterns, you can make your code more flexible, reusable, and maintainable.

It’s not mandatory to always implement design patterns in your project. Design patterns are not meant for project development. Design patterns are meant for common problem-solving. Whenever there is a need, you have to implement a suitable pattern to avoid such problems in the future. To find out which pattern to use, you just have to try to understand the design patterns and their purposes. Only by doing that, you will be able to pick the right one. 

**Types of Design Patterns:**   
There are mainly three types of design patterns:     
***Creational***    
These design patterns are all about class instantiation or object creation. These patterns can be further categorized into Class-creational patterns and object-creational patterns. While class-creation patterns use inheritance effectively in the instantiation process, object-creation patterns use delegation effectively to get the job done. 
Creational design patterns are the Factory Method, Abstract Factory, Builder, Singleton, Object Pool, and Prototype.    
***Structural***    
These design patterns are about organizing different classes and objects to form larger structures and provide new functionality. 
Structural design patterns are Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Private Class Data, and Proxy    
***Behavioral***     
Behavioral patterns are about identifying common communication patterns between objects and realizing these patterns. 
Behavioral patterns are Chain of responsibility, Command, Interpreter, Iterator, Mediator, Memento, Null Object, Observer, State, Strategy, Template method, Visitor    
## About Observer pattern
Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified, its depenedent objects are to be notified automatically. Observer pattern falls under behavioral pattern category.    
# About The project   
In our project we have 2 Interface classes and 2 Implements classes. We have UndoStringBuilder class(From Ex_0), and we need to use this class in this Ex. We want to trace after two variable, UndoStringBuilder and GroupAdmin, and in case we change a member in group admin, its automataclly update the usb.
So the goal in this Ex is to trace after this two variables and update in case we need to.   
## The Interfaces
We have two Intefaces. Member and Sender.   
Sender -> GroupAdmin    
Member -> ConcreteMember   
## The classes   
**UndoableStringBuilder**    
This is the class from Ex_0. We used the solution that provided us by the lecturer in the moudle. In this class we create new object of UndoableStringBuilder with some action we can make on the object, For example: insert, append, delete. We also add option to do undo if you regret and you want to do undo.    
**ConcreteMember**    
This class implements from Member class. In this class we update the UndoableStringBuilder in case we change something, we also have getters & setters for the variable of the class.   
**GroupAdmin**    
This class implements fron Sender. In this class we build GroupAdmin Object, Its actually a group of members, for the group we used in ArrayList. Also, in this class we have UndoableStringBuilder variable for the trace of the action. Any case something change, we need to update.    



