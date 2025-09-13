package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resources")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotBlank(message = "type cannot be blank")
    private String type;

    @Negative(message = "totalAmount cannot be negative")
    private Integer totalAmount;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.ALL)
    private List<OderResource> orders = new ArrayList<>();
}
