package ch.synaptech.repositories;

import ch.synaptech.domain.Present;
import ch.synaptech.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mwatson on 11/28/2015.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
