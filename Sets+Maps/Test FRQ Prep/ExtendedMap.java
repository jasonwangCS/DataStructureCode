import java.util.*;

public class ExtendedMap<K,V> extends MyMap<K,V>
{
    /* nonUnique - Returns a list of all the keys that have values
    * that are not unique in the map.
    * @return (ArrayList<K>) a list of keys that have values that are not unique.
    */
    public ArrayList<K> nonUnique()
    {
        ArrayList<K> not = new ArrayList<K>();

        Iterator<MapEnt<K,V>> outsideIt = entrySet().iterator();
        while(outsideIt.hasNext())
        {
            MapEnt<K,V> out = outsideIt.next();
            Iterator<MapEnt<K,V>> insideIt = entrySet().iterator();
            int count = 0;
            while(insideIt.hasNext())
            {
                MapEnt<K,V> in = insideIt.next();
                if(out.getValue().equals(in.getValue()))
                    count++;
            }
            if(count>1)
                not.add(out.getKey());
        }
        return not;
    }
}