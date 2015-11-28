package ch.synaptech.repositories;

import ch.synaptech.domain.Present;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mwatson on 11/28/2015.
 */
public interface PresentRepository extends CrudRepository<Present, Integer> {
}
