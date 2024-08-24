
/**
 * Eviction policy based on LRU algorithm.
 *
 * @param <Key> Key type.
 */
public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{

    private DoublyLinkedList<key> dll;
    private Map<Key, DoublyLinkedListNode> mapper;

    public LRUEvictionPolicy()
    {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key)
    {
        if(mapper.contains(key))
        {
            DoublyLinkedListNode node = mapper.get(key);
            this.dll.detachNode(node);
            this.dll.addNodeAtLast(node);
        }
        else{
            DoublyLinkedListNode node = DoublyLinkedListNode<>(key);
            mapper.put(key, node);
        }

    }

    @Override
    public Key evictKey()
    {   
        
        DoublyLinkedListNode first = this.dll.getFirstNode();
        if(node==null)
        {
            return null;
        }
        this.dll.detachNode(node);
        mapper.remove(node);
        return first.getElement();
    }

}   `

