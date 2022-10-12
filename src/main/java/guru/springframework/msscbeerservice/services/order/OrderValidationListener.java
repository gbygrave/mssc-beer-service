package guru.springframework.msscbeerservice.services.order;

import guru.sfg.brewery.model.BeerOrderDto;
import guru.sfg.brewery.model.events.ValidateOrderRequest;
import guru.sfg.brewery.model.events.ValidateOrderResponse;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static guru.springframework.msscbeerservice.config.JmsConfig.VALIDATE_ORDER_QUEUE;
import static guru.springframework.msscbeerservice.config.JmsConfig.VALIDATE_ORDER_RESULT_QUEUE;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderValidationListener {
    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = VALIDATE_ORDER_QUEUE)
    public void listen(ValidateOrderRequest event) {
        BeerOrderDto beerOrderDto = event.getBeerOrderDto();
        boolean isValid = beerOrderDto.getBeerOrderLines().stream()
                .map(line -> beerRepository.findByUpc(line.getUpc()) != null)
                .reduce((l,r) -> l && r).orElse(false);

        log.debug("Order " + beerOrderDto.getId() + (isValid?"is":"is not") + " valid.");

        ValidateOrderResponse validateOrderResponse = new ValidateOrderResponse(beerOrderDto.getId(), isValid);
        jmsTemplate.convertAndSend(VALIDATE_ORDER_RESULT_QUEUE, validateOrderResponse);
    }
}
