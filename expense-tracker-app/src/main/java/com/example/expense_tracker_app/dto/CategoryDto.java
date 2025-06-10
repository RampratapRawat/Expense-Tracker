package com.example.expense_tracker_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Category DTO(Data Transfer Object) to transfer the data between client and server"
)
public record CategoryDto(Long id,

                          @Schema(
                                  description = "Category name"
                          )
                          String name){}

