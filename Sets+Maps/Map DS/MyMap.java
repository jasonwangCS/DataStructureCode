import java.util.*;
public class MyMap<K,V> implements MapInterface<K,V>
{
	private ArrayList<MapEnt<K,V>> map;

    public MyMap()
    {
        map = new ArrayList<MapEnt<K, V>>();
    }
    public void clear()
    {
        map.clear();
    }
	public boolean containsKey(K key)
    {
        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).getKey() == key || map.get(i).getKey().equals(key))
            {
                return true;
            }
        }
        return false;
    }
	public boolean containsValue(V value)
    {
        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).getValue() == value || map.get(i).getValue().equals(value))
            {
                return true;
            }
        }
        return false;
    }
	public SetInterface<MapEnt<K,V>> entrySet()
    {
        MySet<MapEnt<K,V>> set = new MySet<MapEnt<K, V>>();
        for(int i = 0; i < map.size(); i++)
        {
            set.add(map.get(i));
        }
        return set;
    }
	public V get(K o)
    {
        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).getKey() == o)
            {
                return map.get(i).getValue();
            }
        }
        return null;
    }
	public boolean isEmpty()
    {
        if(map.size() == 0)
        {
            return true;
        }
        return false;
    }
	public SetInterface<K> keySet()
    {
        MySet<K> set = new MySet<K>();
        for(int i = 0; i < map.size(); i++)
        {
            set.add(map.get(i).getKey());
        }
        return set;
    }
	public V put(K key, V value)
    {
        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).getKey() == key)
            {
                V val = map.get(i).getValue();
                map.remove(i);
                MapEnt<K, V> tmptmp = new MapEnt(key, value);
                map.add(tmptmp);
                return val;
            }
        }
        MapEnt<K, V> tmp = new MapEnt(key, value);
        map.add(tmp);
        return null;
    }
	public int size()
    {
        return map.size();
    }
	public V remove(K key)
    {
        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).getKey() == key)
            {
                V value = map.get(i).getValue();
                map.remove(i);
                return value;
            }
        }
        return null;
    }
	public ArrayList<V> values()
    {
        ArrayList<V> val = new ArrayList<V>();
        for(int i = 0; i < map.size(); i++)
        {
            val.add(map.get(i).getValue());
        }
        return val;
    }
}