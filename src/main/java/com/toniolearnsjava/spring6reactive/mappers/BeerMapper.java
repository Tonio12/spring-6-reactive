package com.toniolearnsjava.spring6reactive.mappers;

import com.toniolearnsjava.spring6reactive.domain.Beer;
import com.toniolearnsjava.spring6reactive.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    BeerDTO beerToBeerDTO(Beer beer);

    Beer beerDtoToBeer(BeerDTO dto);
}
