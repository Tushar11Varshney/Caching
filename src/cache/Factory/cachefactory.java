
public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(final Integer capacity)
    {   
        return new Cache<Key, Value>(
            new HashmapBasedStorage<Key, Value>(capacity), 
            new LRUEvictionPolicy<Key>()
        );
    }
}