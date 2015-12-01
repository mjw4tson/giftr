package ch.synaptech.services;

import ch.synaptech.domain.Present;

/**
 * Created by mwatson on 11/28/15.
 */
public interface PresentService {
    Iterable<Present> listAllPresents();

    Iterable<Present> listAllPresentsForUserId(Integer id);

    Present getPresentById(Integer id);

    Present savePresent(Present present);

    void deletePresent(Integer id);

    void purchasePresent(Integer id, Integer purchaserId);
}
