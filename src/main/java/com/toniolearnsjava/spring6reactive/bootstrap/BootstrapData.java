package com.toniolearnsjava.spring6reactive.bootstrap;

import com.toniolearnsjava.spring6reactive.domain.Beer;
import com.toniolearnsjava.spring6reactive.domain.Customer;
import com.toniolearnsjava.spring6reactive.repositories.BeerRepository;
import com.toniolearnsjava.spring6reactive.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository  customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();
    }

    private void loadBeerData() {
        beerRepository.count().subscribe(count -> {
            if (count == 0) {
                Beer beer1 = Beer.builder()
                        .beerName("Galaxy Cat")
                        .beerStyle("Pale Ale")
                        .upc("12356")
                        .price(new BigDecimal("12.99"))
                        .quantityOnHand(122)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                Beer beer2 = Beer.builder()
                        .beerName("Crank")
                        .beerStyle("Pale Ale")
                        .upc("12356222")
                        .price(new BigDecimal("11.99"))
                        .quantityOnHand(392)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                Beer beer3 = Beer.builder()
                        .beerName("Sunshine City")
                        .beerStyle("IPA")
                        .upc("12356")
                        .price(new BigDecimal("13.99"))
                        .quantityOnHand(144)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                beerRepository.save(beer1).subscribe();
                beerRepository.save(beer2).subscribe();
                beerRepository.save(beer3).subscribe();
            }
        });
    }

    private void loadCustomerData(){
        customerRepository.count().subscribe(count -> {
            if(count == 0){
                Customer customer1 = Customer.builder()
                        .firstName("Antonio")
                        .lastName("Nelson")
                        .createdDate(LocalDate.now())
                        .lastDateModified(LocalDate.now())
                        .build();

                Customer customer2 = Customer.builder()
                        .firstName("Pascalene")
                        .lastName("Robertson")
                        .createdDate(LocalDate.now())
                        .lastDateModified(LocalDate.now())
                        .build();

                Customer customer3 = Customer.builder()
                        .firstName("Hubert")
                        .lastName("Nelson")
                        .createdDate(LocalDate.now())
                        .lastDateModified(LocalDate.now())
                        .build();

                customerRepository.save(customer1).subscribe();
                customerRepository.save(customer2).subscribe();
                customerRepository.save(customer3).subscribe();
            }
        });
    }
}
