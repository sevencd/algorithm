package Searching.src.UnorderedST;

public class LinearProbingHashST<Key, Value> implements UnorderedST<Key, Value> {

    private int N = 0;
    private int M = 16;
    private Key[] keys;
    private Value[] values;


    public LinearProbingHashST() {
        init();
    }


    public LinearProbingHashST(int M) {
        this.M = M;
        init();
    }


    private void init() {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }


    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }


    @Override
    public int size() {
        return N;
    }


    @Override
    public void put(Key key, Value value) {
        resize();
        putInternal(key, value);
    }


    /**
     * 因为 put() 会调用 resize()，而 resize() 操作又需要将键值对重新插入
     * 如果 resize() 又调用 put()，那么就会循环调用，不仅容易出错，而且会造成一些多于的检查步骤
     */
    private void putInternal(Key key, Value value) {

        int i;

        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        keys[i] = key;
        values[i] = value;
        N++;
    }


    @Override
    public Value get(Key key) {

        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }


    @Override
    public void delete(Key key) {

        int i = hash(key);

        while (keys[i] != null && !key.equals(keys[i])) {
            i = (i + 1) % M;
        }

        // 不存在，直接返回
        if (keys[i] == null) {
            return;
        }

        keys[i] = null;
        values[i] = null;

        // 将之后相连的键值对重新插入
        i = (i + 1) % M;
        while (keys[i] != null) {

            Key keyToRedo = keys[i];
            Value valToRedo = values[i];

            keys[i] = null;
            values[i] = null;

            N--;

            putInternal(keyToRedo, valToRedo);

            i = (i + 1) % M;
        }

        N--;

        resize();
    }


    private void resize() {

        if (N >= M / 2) {
            resize(2 * M);

        } else if (N <= M / 8) {
            resize(M / 2);
        }
    }


    private void resize(int cap) {

        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<Key, Value>(cap);

        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.putInternal(keys[i], values[i]);
            }
        }

        keys = t.keys;
        values = t.values;
        M = t.M;
    }
}