package com.example.Laundry.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table
@Data
public class OderDetail {
    private BigDecimal price;
    private BigDecimal amount;
    
}
