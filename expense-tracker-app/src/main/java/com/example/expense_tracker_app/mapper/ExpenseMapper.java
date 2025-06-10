package com.example.expense_tracker_app.mapper;

import com.example.expense_tracker_app.dto.CategoryDto;
import com.example.expense_tracker_app.dto.ExpenseDto;
import com.example.expense_tracker_app.entity.Category;
import com.example.expense_tracker_app.entity.Expense;


public class ExpenseMapper {

    public static Expense mapToExpense(ExpenseDto expenseDto){
         Category num=new Category();
         num.setId(expenseDto.categoryDto().id());
        Expense sam = new Expense(expenseDto.id(),
                           expenseDto.amount(),
                           expenseDto.expenseDate(),
                            num);
        return sam;
    }

    public static ExpenseDto mapToExpenseDto(Expense expense){
        return new ExpenseDto(expense.getId(),expense.getAmount(),expense.getExpenseDate(),
                        new CategoryDto(
                                expense.getCategory().getId(),
                                expense.getCategory().getName()
                        ));
    }
}
