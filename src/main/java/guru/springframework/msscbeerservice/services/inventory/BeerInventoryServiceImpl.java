package guru.springframework.msscbeerservice.services.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
// @Service
public class BeerInventoryServiceImpl implements BeerInventoryService {
    @Override
    public Integer getOnhandInventory(UUID beerId) {
        return 50;
    }
}
