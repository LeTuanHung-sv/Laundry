package com.example.Laundry.entity;

import com.example.Laundry.OderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table(name = "oder_status_history")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class OderStatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id cannot blank")
    private Long id;

    @Enumerated(EnumType.STRING)
    private OderStatus oderStatus;

    private LocalDateTime changedAt;

    @ManyToOne
    @JoinColumn(name ="oder_id")
    private Oder oder;
}
