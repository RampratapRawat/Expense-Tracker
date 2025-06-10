package com.example.expense_tracker_app.controller;

import com.example.expense_tracker_app.dto.ExpenseDto;
import com.example.expense_tracker_app.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name="CRUD REST APIs for Expense Resource",
        description = "CRUD REST APIs for Expense Resource - Create Expense"+
                "Get Expense, Update Expense, and Delete Expense"
)
@RestController
@RequestMapping("/api/expenses")
@AllArgsConstructor
public class ExpenseController {

    private ExpenseService service;

    @Operation(
            summary = "Create Expense REST API",
            description = "Create Expense Rest API to save Expense into Database"
    )@ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        return new ResponseEntity<>(service.createExpense(expenseDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "GET Expense REST API",
            description = "Get Expense Rest API Get Expense from Database"
    )@ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/find/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getExpenseById(id));
    }

    @Operation(
            summary = "GetAll Expense REST API",
            description = "GetALL Expenses Rest API GetALL Expenses from Database"
    )@ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/findAll")
    public ResponseEntity<List<ExpenseDto>> getAllExpense(){
        return ResponseEntity.ok(service.getExpense());
    }

    @Operation(
            summary = "Delete Expense REST API",
            description = "Delete Expense Rest API Delete Expense from Database"
    )@ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long id){
        service.deleteExpense(id);
        return ResponseEntity.ok("Expense has been delete");
    }

    @Operation(
            summary = "Update Expense REST API",
            description = "Update Expense Rest API Update Expense into Database"
    )@ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseDto> update(@PathVariable("id") Long id,@RequestBody ExpenseDto expenseDto){
        return ResponseEntity.ok(service.updateExpense(id,expenseDto));
    }
}
