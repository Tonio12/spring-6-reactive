package com.toniolearnsjava.spring6reactive.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer {
    @Id
    private int id;
    private String firstName;
    private String  lastName;

    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedDate
    private LocalDate lastDateModified;
}
