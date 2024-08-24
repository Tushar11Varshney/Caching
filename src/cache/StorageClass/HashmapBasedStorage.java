

public HashmapBasedStorage<Key, Value> implements Storage<Key, Value>{

    Map<Key, Value> storage;
    private final Integer capacity;       //CT:Difference btw int and Integer

    HashmapBasedStorage(Integer capacity)
    {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException
    {
        if(isCapacityFull())
            throw new StorageFullException("Capacity Full");
        storage.put(key, value);
        this.capacity++;
    }

    @Override   
    public void remove(Key key) throws NotFoundException
    {
        if(!storage.contains(key))
            throw new NotFoundException(String.format("%s doesn't exist in cache", key));
        storage.remove(key);
        this.capacity--;
    }

    @Override
    public Value get(Key key) throws NotFoundException
    {
        if(!storage.contains(key))
            throw new  NotFoundException(String.format("%s doesn't exist in cache", key));
        return map.get(key);
    }

    public boolean isCapacityFull()
    {
        return storage.size() == this.capacity;
    }

}
