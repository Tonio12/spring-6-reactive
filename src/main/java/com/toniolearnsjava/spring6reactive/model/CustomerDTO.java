package com.toniolearnsjava.spring6reactive.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String firstName;

    @Size(min = 3, max = 255)
    private String lastName;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
