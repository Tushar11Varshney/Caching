

public class Cache<Key, Value> {

    private final Storage<Key, Value> storage;
    private final EvictionPolicy<Key> evictionPolicy;

    public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy)
    {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key, Value value)
    {
        try{
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        }
        catch(StorageFullException exception)
        {
            System.out.println("Storage is full. Evicting the oldest key.")
            Key keyToRemove = this.evictionPolicy.evictKey();
            if(keyToRemove==null)
            {
                throw RunTimeException("Unexpected State. List is full but not able to evict");
            }
            this.storage.remove(keyToRemove);
            put(key, value);
        }
    }

    public Value get(Key key)
    {
        try{
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
        }
        catch (NotFoundException exception){
            System.out.println("Tried to access non existing key");
            return null;
        }

        return value;
    }

}