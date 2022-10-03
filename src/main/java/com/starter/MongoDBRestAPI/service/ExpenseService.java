package com.starter.MongoDBRestAPI.service;

import com.starter.MongoDBRestAPI.model.Expense;
import com.starter.MongoDBRestAPI.repository.ExpenseRepository;
import com.starter.MongoDBRestAPI.model.Expense;
import com.starter.MongoDBRestAPI.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }
    public void updateExpense(Expense expense){
        Expense savedExpense= expenseRepository.findById(expense.getId()).
                orElseThrow(() -> new RuntimeException(String.format("Cannot find Expense by ID %s",expense.getId())));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(savedExpense);
    }
    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }
    public Expense getExpenseyName(String name) {
        return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException((String.format("Cannot find Expense by name %s", name))));
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
    

}
