package guru.springframework.msscbeerservice.web.mappers;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.sfg.brewery.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {
    @Mapping(target="quantityOnHand", ignore=true)
    BeerDto beerToBeerDto(Beer beer);

    @Mapping(target="quantityOnHand", ignore=true)
    BeerDto beerToBeerDtoWithInventory(Beer beer);

    @Mapping(target="minOnHand", ignore=true)
    @Mapping(target="quantityToBrew", ignore=true)
    Beer beerDtoToBeer(BeerDto dto);
}
