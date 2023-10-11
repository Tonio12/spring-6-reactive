package com.toniolearnsjava.spring6reactive.repositories;

import com.toniolearnsjava.spring6reactive.domain.Beer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BeerRepository extends ReactiveCrudRepository<Beer, Integer> {

}
