package pl.fulful.com.petclinic.services.map;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Service;
import pl.fulful.com.petclinic.model.BaseEntity;

import java.util.*;

@Service
public class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet(map.values());
    }

    public T findById(Long id) {
        return map.get(id);
    }

    public T save(ID id, T object) {
        return map.put(id, object);
    }

    public T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            } else {
                throw new RuntimeException("Object cannot be null");
            }

            map.put(getNextId(), object);
        }
//        System.out.println("object = " + object);
//        System.out.println("object.getId() = " + object.getId());

        return object;
    }

    protected Long getNextId() {
//        if (map.isEmpty()) {
//            return 1L;
//        } else {
//            return Collections.max(map.keySet()) + 1;
//        }
        try {
            return Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            return 1L;
        }
    }

    public void delete(T object) {
        map.values().removeIf(value -> value.equals(object));
    }

    public void deleteById(ID id) {
        map.remove(id);
    }
}
