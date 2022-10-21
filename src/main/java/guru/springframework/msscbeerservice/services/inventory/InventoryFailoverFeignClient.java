package guru.springframework.msscbeerservice.services.inventory;

import guru.springframework.msscbeerservice.services.inventory.model.BeerInventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * For histrix failover.
 */
@FeignClient(name = "beer-inventory-failover-service")
public interface InventoryFailoverFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "inventory-failover")
    ResponseEntity<List<BeerInventoryDto>> getOnhandInventory();
}
