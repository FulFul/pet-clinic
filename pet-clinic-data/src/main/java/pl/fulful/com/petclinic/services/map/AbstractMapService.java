package pl.fulful.com.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(ID id, T object) {
        return map.put(id, object);
    }

    public void delete(T object) {
        map.values().removeIf(value -> value.equals(object));
    }

    public void deleteById(ID id) {
        map.remove(id);
    }
}
