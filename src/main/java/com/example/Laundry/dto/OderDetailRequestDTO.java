package com.example.Laundry.dto;

import javax.validation.constraints.Future;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;



public class OderDetailRequestDTO {

    @NotNull(message = "OderId khong duoc de trong")
    private Long oderId;

    @Future (message = "Ngay tuong lai")
    private Date oderDate;

    @Negative
    private BigDecimal totalAmount;

    private String note;
}
