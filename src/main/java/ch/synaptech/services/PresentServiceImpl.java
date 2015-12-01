package ch.synaptech.services;

import ch.synaptech.domain.Present;
import ch.synaptech.domain.User;
import ch.synaptech.repositories.PresentRepository;
import ch.synaptech.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mwatson on 11/28/15.
 */
@Service
public class PresentServiceImpl implements PresentService {

    private PresentRepository presentRepository;

    private UserRepository userRepository;

    @Autowired
    public void setProductRepository(PresentRepository presentRepository) {
        this.presentRepository = presentRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<Present> listAllPresents() {
        return presentRepository.findAll();
    }

    @Override
    public Iterable<Present> listAllPresentsForUserId(Integer id) {
        return null;
    }

    @Override
    public Present getPresentById(Integer id) {
        return presentRepository.findOne(id);
    }

    @Override
    public Present savePresent(Present present) {
        return presentRepository.save(present);
    }

    @Override
    public void deletePresent(Integer id) {
        presentRepository.delete(id);
    }

    @Override
    public void purchasePresent(Integer id, Integer purchaserId) {
        Present present = presentRepository.findOne(id);
        User user = userRepository.findOne(purchaserId);
        present.setPurchaser(user);
        presentRepository.save(present);
    }
}
