package behavioural;

import java.util.*;

/*

 The Memento design pattern is used for restoring the state of an object to a previous state. It provides a way to implement undo operations in an application. The pattern is also known as Snapshot.

The Memento pattern involves three types of objects:

Originator: The object whose state needs to be saved and restored. It creates a memento object which captures its internal state.

Memento: The object that holds the snapshot of the Originator's state. This is the object that the Originator uses to restore its state.

Caretaker: The object that keeps track of multiple mementos. It doesn't operate on or examine the contents of mementos.

The Memento pattern is useful when you need to provide a rollback mechanism for an object's state, like in a text editor where you can undo your actions. It's also useful when the internal state of an object must be saved externally without exposing the implementation details of the object.

However, it's worth noting that the Memento pattern can consume a lot of memory if the Originator object has a large amount of state or if the client creates mementos frequently.


Command vs memento:
The Memento design pattern is used for restoring the state of an object to a previous state. It provides a way to implement undo operations in an application. The pattern is also known as Snapshot.

The Memento pattern involves three types of objects:

Originator: The object whose state needs to be saved and restored. It creates a memento object which captures its internal state.

Memento: The object that holds the snapshot of the Originator's state. This is the object that the Originator uses to restore its state.

Caretaker: The object that keeps track of multiple mementos. It doesn't operate on or examine the contents of mementos.

The Memento pattern is useful when you need to provide a rollback mechanism for an object's state, like in a text editor where you can undo your actions. It's also useful when the internal state of an object must be saved externally without exposing the implementation details of the object.

However, it's worth noting that the Memento pattern can consume a lot of memory if the Originator object has a large amount of state or if the client creates mementos frequently.

mukund-madhav_hrd
but if this also helps in undo.. then how is it diffrent from command pattern



 */

public class Memento {
    
}
