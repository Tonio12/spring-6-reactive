package com.toniolearnsjava.spring6reactive.controllers;

import com.toniolearnsjava.spring6reactive.model.BeerDTO;
import com.toniolearnsjava.spring6reactive.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class BeerController {
    public static final String BEER_PATH = "/api/v2/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

    private final BeerService beerService;

    @GetMapping(BEER_PATH)
    Flux<BeerDTO> listBeers(){
        return beerService.listBeers();
    }

    @GetMapping(BEER_PATH_ID)
    Mono<BeerDTO> getBeerById(@PathVariable("beerId") Integer beerId){
        return beerService.getBeerById(beerId);
    }

    @PostMapping(BEER_PATH)
    Mono<ResponseEntity<Void>> createNewBeer(@Validated @RequestBody BeerDTO dto){
        return beerService.createNewBeer(dto)
                .map(savedDTO -> ResponseEntity.created(UriComponentsBuilder
                        .fromHttpUrl("http://localhost:8080/" +  BEER_PATH +
                                "/" + savedDTO.getId()).build()
                        .toUri())
                        .build());
    }

    @PutMapping(BEER_PATH_ID)
    Mono<ResponseEntity<Void>> updateBeer(@PathVariable("beerId") Integer beerId,
                                         @Validated @RequestBody BeerDTO dto){
       return beerService.updateBeer(beerId, dto)
               .map(savedDto -> ResponseEntity.ok().build());
    }

    @PatchMapping(BEER_PATH_ID)
    Mono<ResponseEntity<Void>> patchBeer(@PathVariable("beerId") Integer beerId,
                                         @Validated @RequestBody BeerDTO dto){
        return beerService.patchBeer(beerId, dto)
                .map(savedDto -> ResponseEntity.ok().build());
    }

    @DeleteMapping(BEER_PATH_ID)
    Mono<ResponseEntity<Void>> deleteBeerById(@PathVariable  Integer beerId){
        return beerService.deleteBeerById(beerId)
                .then(Mono.fromCallable(() -> ResponseEntity.noContent().build()));
    }
}
