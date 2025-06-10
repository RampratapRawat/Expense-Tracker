package com.example.expense_tracker_app.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(
        description = "Expense DTO(Data Transfer Object) to transfer the data between client and server"
)
public record ExpenseDto(Long id,
                         @Schema(
                                 description = " Expense amount"
                         )
                         BigDecimal amount,
                         @Schema(
                                 description = "Expense create date "
                         )
                         LocalDate expenseDate,
                         @Schema(
                                 description = "Expense category "
                         )
                         CategoryDto categoryDto) {
}
