package ch.synaptech.repositories;

import ch.synaptech.configuration.RepositoryConfiguration;
import ch.synaptech.domain.Present;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by mwatson on 11/28/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class PresentRepositoryTest {

    private PresentRepository presentRepository;

    @Autowired
    public void setPresentRepository(PresentRepository presentRepository) {
        this.presentRepository = presentRepository;
    }

    @Test
    public void testSavePresent() {
        Present present = new Present();
        present.setDescription("Xbox One");
        present.setPrice(new BigDecimal("399.99"));

        // Test create and verify present id is created after save
        assertNull(present.getId());
        presentRepository.save(present);
        assertNotNull(present.getId());

        // Fetch and compare read present
        Present fetchedPresent = presentRepository.findOne(present.getId());
        assertNotNull(fetchedPresent);
        assertEquals(present.getId(), fetchedPresent.getId());
        assertEquals(present.getDescription(), fetchedPresent.getDescription());

        // Test update of fetched present and save
        fetchedPresent.setDescription("New Description");
        presentRepository.save(fetchedPresent);
        Present fetchedUpdatedPresent = presentRepository.findOne(fetchedPresent.getId());
        assertEquals(fetchedPresent.getDescription(), fetchedUpdatedPresent.getDescription());

        // Verify DB size
        long presentCount = presentRepository.count();
        assertEquals(presentCount, 1);

        Iterable<Present> presents =  presentRepository.findAll();

        int count = 0;

        for (Present p : presents)
            ++count;

        assertEquals(count, 1);

        // Test delete present
        presentRepository.delete(present.getId());
        Present deletedPresent = presentRepository.findOne(present.getId());
        assertNull(deletedPresent);

        presentCount = presentRepository.count();
        assertEquals(presentCount, 0);
    }

}
