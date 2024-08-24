// A generic type in programming is a way to write code that works with any data type. Instead of writing
//  separate versions of your code for different types (like int, String, or CustomClass),
//  you can use a generic type to handle all of them.

// Example:
// If you’re making a list of items:

// Without Generics: You’d have to create a different list for numbers, words, or other items.
// With Generics: You create one list that can hold any type of item, like numbers, words, or custom objects.

// Why Use Generics?
// Flexibility: You can write one piece of code that works with different types of data.
// Type Safety: Generics help ensure that you don’t accidentally put the wrong type of data in your 
// collection (like putting a book in a box meant for toys).

//Type-Safe References: The next and prev references are of the type 
// DoublyLinkedListNode<E>, ensuring that each node points to another node that holds the same type of element.


// Getter annotation from Lombok is used to automatically generate getter methods for fields in a Java class. 
// Lombok is a library that helps reduce boilerplate code in Java by automatically generating common methods like 
// getters, setters, constructors, and more.
// If you annotate the entire class with @Getter, Lombok generates getter methods for all fields in that class.
// If you annotate individual fields with @Getter, Lombok generates getter methods for those fields.
import lombok.Getter;
@Getter

/**
 * Object which is inserted in the CT{@link DoublyLinkedList}. A single node is expected to be created for each element.
 *
 * @param <E> Type of element to be inserted into the list.
 */
public class DoublyLinkedListNode<E>{

    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;
    E element ;

    DoublyLinkedListNode(E element)
    {
        this.next = null;
        this.prev = null;
        this.element = element;
    }
}

