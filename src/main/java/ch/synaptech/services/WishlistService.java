package ch.synaptech.services;

import ch.synaptech.domain.Present;
import ch.synaptech.domain.Wishlist;

/**
 * Created by mwatson on 11/30/15.
 */
public interface WishlistService {
    Iterable<Wishlist> listAllWishlists();

    Wishlist getWishlistById(Integer id);

    Wishlist saveWishlist(Wishlist wishlist);

    void deleteWishlist(Integer id);

    Wishlist addPresent(Wishlist wishlist, Present present);

    void removePresent(Wishlist wishlist, Present present);
}
