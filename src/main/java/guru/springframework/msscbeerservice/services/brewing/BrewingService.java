package guru.springframework.msscbeerservice.services.brewing;

import org.springframework.scheduling.annotation.Scheduled;

public interface BrewingService {
    @Scheduled(fixedRate = 5000)
    void checkForLowInventory();
}
