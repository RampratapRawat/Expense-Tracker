package com.example.expense_tracker_app.exceptionHandler;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(
        description = "ErrorDetail DTO(Data Transfer Object) to transfer error response the data between client and server"
)
public class ErrorsDetails {
    @Schema(
            description = " Error occurred date time"
    )
    private LocalDateTime timestamp;
    @Schema(
            description = " Error message"
    )
    private String message;
    @Schema(
            description = " Error details"
    )
    private String details;
    @Schema(
            description = " Error code"
    )
    private String errorCode;
}
