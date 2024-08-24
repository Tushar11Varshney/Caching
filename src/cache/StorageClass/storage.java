
public interface Storage<Key, Value> {

    void add(Key key, Value value) throws StorageFullException;

    void remove(Key key) throws NotFoundException;

    void get(Key key) throws NotFoundException;
}
