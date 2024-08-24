public interface EvictionPolicy<Key>{

    public abstract void keyAccessed(Key k);

    /**
     * Evict key from eviction policy and return it.
    */
    public abstract Key evictKey();
}
