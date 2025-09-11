package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @NotNull(message = "Id not blank")
    private Long id;

    private String name;

    private String type;
    private Integer totalAmount;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.ALL)
    private List<OderResource> orders = new ArrayList<>();
}
