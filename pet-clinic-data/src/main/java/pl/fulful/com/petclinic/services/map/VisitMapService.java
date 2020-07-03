package pl.fulful.com.petclinic.services.map;

import org.springframework.stereotype.Service;
import pl.fulful.com.petclinic.model.Visit;
import pl.fulful.com.petclinic.services.VisitService;

import java.time.LocalDate;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit save(Visit visit) {

        if (visit != null) {

            if (visit.getPet() == null) {
                throw new RuntimeException("Pet cannot be null");
            }

            if (visit.getDate() == null) {
                visit.setDate(LocalDate.now());
            }

            if (visit.getPet().getOwner() == null) {
                throw new RuntimeException("Pet have no Owner!");
            }

            super.save(visit);
        }

        return visit;
    }
}
