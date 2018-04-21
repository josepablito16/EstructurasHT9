/**
 *
 * @author Jose Cifuentes
 * @author Luis Delgado
 * @version 20.4.18
 * Clase Asociacion
 */
import java.util.Map;


public class Association<K, V> implements Map.Entry<K,V> 
{
    protected K key;
    protected V value;

	public Association(K key, V value) 
        {
            this.key = key;
            this.value = value;
	}

    @Override
    public K getKey() 
    {
        return key;
        
    }

    @Override
    public V getValue() 
    {
        return value;
    }

    @Override
    public V setValue(V v) 
    {
        return value=v;
    }
    
}
