package com.toniolearnsjava.spring6reactive.services;

import com.toniolearnsjava.spring6reactive.model.BeerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface BeerService {
    Flux<BeerDTO> listBeers();

    Mono<BeerDTO> getBeerById(Integer beerId);

    Mono<BeerDTO> createNewBeer(BeerDTO dto);

    Mono<BeerDTO> updateBeer(Integer beerId, BeerDTO dto);

    Mono<BeerDTO> patchBeer(Integer beerId, BeerDTO dto);

    Mono<Void> deleteBeerById(Integer beerId);
}
