package guru.springframework.msscbeerservice.services.inventory;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
// @Service
public class BeerInventoryServiceDummyImpl implements BeerInventoryService {
    @Override
    public Integer getOnhandInventory(UUID beerId) {
        return 50;
    }
}
