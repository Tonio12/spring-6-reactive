package com.toniolearnsjava.spring6reactive.services;

import com.toniolearnsjava.spring6reactive.mappers.BeerMapper;
import com.toniolearnsjava.spring6reactive.model.BeerDTO;
import com.toniolearnsjava.spring6reactive.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    private final BeerMapper beerMapper;

    @Override
    public Flux<BeerDTO> listBeers() {
        return beerRepository.findAll()
                .map(beerMapper::beerToBeerDTO);
    }

    @Override
    public Mono<BeerDTO> getBeerById(Integer beerId) {
        return beerRepository.findById(beerId)
                .map(beerMapper::beerToBeerDTO);
    }

    @Override
    public Mono<BeerDTO> createNewBeer(BeerDTO dto) {
        return beerRepository.save(beerMapper.beerDtoToBeer(dto))
                .map(beerMapper::beerToBeerDTO);
    }

    @Override
    public Mono<BeerDTO> updateBeer(Integer beerId, BeerDTO dto) {
        return beerRepository.findById(beerId)
                .map(foundBeer -> {
                    foundBeer.setBeerName(dto.getBeerName());
                    foundBeer.setBeerStyle(dto.getBeerStyle());
                    foundBeer.setPrice(dto.getPrice());
                    foundBeer.setUpc(dto.getUpc());
                    foundBeer.setQuantityOnHand(dto.getQuantityOnHand());

                    return foundBeer;
                }).flatMap(beerRepository::save)
                .map(beerMapper::beerToBeerDTO);
    }

    @Override
    public Mono<BeerDTO> patchBeer(Integer beerId, BeerDTO dto) {
        return beerRepository.findById(beerId)
                .map(foundBeer -> {
                    if(dto.getBeerName() != null) {
                        foundBeer.setBeerName(dto.getBeerName());
                    }
                    if(dto.getBeerStyle() != null) {
                        foundBeer.setBeerStyle(dto.getBeerStyle());
                    }
                    if(dto.getPrice() != null) {
                        foundBeer.setPrice(dto.getPrice());
                    }
                    if(dto.getUpc() != null) {
                        foundBeer.setUpc(dto.getUpc());
                    }
                    if(dto.getQuantityOnHand() != null) {
                        foundBeer.setQuantityOnHand(dto.getQuantityOnHand());
                    }

                    return foundBeer;
                }).flatMap(beerRepository::save)
                .map(beerMapper::beerToBeerDTO);
    }

    @Override
    public Mono<Void> deleteBeerById(Integer beerId) {
        return beerRepository.deleteById(beerId);
    }
}
