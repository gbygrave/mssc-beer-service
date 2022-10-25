package guru.springframework.msscbeerservice;

import guru.springframework.msscbeerservice.services.brewing.BrewingService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@MockBean(BrewingService.class) // Switch off brewing service scheduled tasks during testing
class MsscBeerServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
