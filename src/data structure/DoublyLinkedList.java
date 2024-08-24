
/**
 * An object which support creating a list with non-contiguous memory allocation. You cannot access a random element
 * directly using index. But if you have a pointer to a node, then you can traverse the list both in forward and
 * backward direction in the list.
 *
 * @param <E> Type of element stored in list.
 */
public class DoublyLinkedList{

    DoublyLinkedListNode<E> dummyHead;
    DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList()
    {
        // We can instantiate these by null, since we are never gonna use val for these dummyNodes
        dummyHead = new DoublyLinkedListNode<>(null);
        dummyTail = new DoublyLinkedListNode<>(null);

        // Also Initially there are no items
        // so just join dummyHead and Tail, we can add items in between them easily.
        dummyHead.next=dummyTail;
        dummyTail.prev=dummyHead.next;
    }

    /**
     * Method to detach a random node from the doubly linked list. The node itself will not be removed from the memory.
     * Just that it will be removed from the list and becomes orphaned.
     *
     * @param node Node to be detached.
     */

    public void detachNode(DoublyLinkedListNode<E> node)
    {
        if(node!=null)
        {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    

    /**
     * Helper method to add a node at the end of the list.
     *
     * @param node Node to be added.
     */
    public void addNodeAtLast(DoublyLinkedListNode<E> node)
    {
        if(node!=null)
        {
            if(!isListEmpty())
            {
                this.dummyHead = node;
                this.dummyTail = node;
            }
            else{
                this.dummyTail.next = node;
                node.prev = this.dummyTail;
                this.dummyTail = node;
                node.next = null;
            }
        }
    }


    /**
     * Helper method to add an element at the end.
     *
     * @param element Element to be added.
     * @return Reference to new node created for the element.
     */
    public DoublyLinkedListNode<E> addElementAtLast(E element)
    {
        if(element==null)
        {
            throw new InvalidElementException();
        }
        DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
        addNodeAtLast(node);
        return node;
    }

    public boolean isListEmpty()
    {
        return this.dummyHead==null;
    }

    public DoublyLinkedListNode<E> getFirstNode()
    {
        if(isListEmpty())
            return null;

        return this.dummyHead;
    }

    public DoublyLinkedListNode<E> getLastNode()
    {
        if(isListEmpty())
            return null;

        return this.dummyTail;
    }
}
