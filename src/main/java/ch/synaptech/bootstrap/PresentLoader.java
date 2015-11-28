package ch.synaptech.bootstrap;

import ch.synaptech.domain.Present;
import ch.synaptech.repositories.PresentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by mwatson on 11/28/2015.
 */
@Component
public class PresentLoader implements ApplicationListener<ContextRefreshedEvent> {

    private PresentRepository presentRepository;

    private Logger log = Logger.getLogger(PresentLoader.class);

    @Autowired
    public void setPresentRepository(PresentRepository presentRepository) {
        this.presentRepository = presentRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Present xboxOne = new Present();
        xboxOne.setDescription("Xbox One");
        xboxOne.setPrice(new BigDecimal("399.99"));
        xboxOne.setId(209384302);
        presentRepository.save(xboxOne);

        log.info("Saved Xbox One Id: " + xboxOne.getId());
    }

}
