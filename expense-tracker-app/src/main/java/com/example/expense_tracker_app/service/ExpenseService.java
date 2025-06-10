package com.example.expense_tracker_app.service;

import com.example.expense_tracker_app.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto expenseDto);

    ExpenseDto getExpenseById(Long id);

    List<ExpenseDto> getExpense();

    ExpenseDto updateExpense(Long id,ExpenseDto expenseDto);

    void deleteExpense(Long id);
}
