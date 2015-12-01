package ch.synaptech.services;

import ch.synaptech.domain.Present;
import ch.synaptech.domain.Wishlist;
import ch.synaptech.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mwatson on 11/30/15.
 */
public class WishlistServiceImpl implements WishlistService {

    private WishlistRepository wishlistRepository;

    @Autowired
    public void setWishlistRepository(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public Iterable<Wishlist> listAllWishlists() {
        return wishlistRepository.findAll();
    }

    @Override
    public Wishlist getWishlistById(Integer id) {
        return wishlistRepository.findOne(id);
    }

    @Override
    public Wishlist saveWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    @Override
    public void deleteWishlist(Integer id) {
        wishlistRepository.delete(id);
    }

    @Override
    public Wishlist addPresent(Wishlist wishlist, Present present) {
        wishlist.getPresents().add(present);
        return wishlistRepository.save(wishlist);
    }

    @Override
    public void removePresent(Wishlist wishlist, Present present) {


    }
}
