package com.example.expense_tracker_app.service;

import com.example.expense_tracker_app.dto.ExpenseDto;
import com.example.expense_tracker_app.entity.Category;
import com.example.expense_tracker_app.entity.Expense;
import com.example.expense_tracker_app.exceptionHandler.ResourceNotFoundException;
import com.example.expense_tracker_app.mapper.ExpenseMapper;
import com.example.expense_tracker_app.repository.CategoryRepository;
import com.example.expense_tracker_app.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{

    private ExpenseRepository repo;
    private CategoryRepository categoryRepository;


    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        return ExpenseMapper.mapToExpenseDto(repo.save(ExpenseMapper.mapToExpense(expenseDto)));
    }

    @Override
    public ExpenseDto getExpenseById(Long id) {
        return ExpenseMapper.mapToExpenseDto(repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("data no found related to this id:"+id)));
    }

    @Override
    public List<ExpenseDto> getExpense() {
        List<Expense> num=repo.findAll();
        return num.stream().map(ExpenseMapper::mapToExpenseDto).collect(Collectors.toList());

    }

    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {
        Expense user= repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("data no found related to this id:"+id));
        // updated expense amount
        user.setAmount(expenseDto.amount());
        // updated expenseDate
        user.setExpenseDate(expenseDto.expenseDate());

          // updated category
        if(expenseDto.categoryDto() != null) {

            //get category entity by id
            Category category = categoryRepository.findById(expenseDto.categoryDto().id())
                    .orElseThrow(() -> new ResourceNotFoundException("data no found related to this id:" + expenseDto.categoryDto().id()));

            user.setCategory(category);

        }
        // updated expense Entity
        Expense updatedExpense = repo.save(user);
        return ExpenseMapper.mapToExpenseDto(updatedExpense);
    }

    @Override
    public void deleteExpense(Long id) {
         repo.deleteById(id);
    }


}
