package com.starter.MongoDBRestAPI.controller;

import com.starter.MongoDBRestAPI.model.Expense;
import com.starter.MongoDBRestAPI.service.ExpenseService;
import com.starter.MongoDBRestAPI.model.Expense;
import com.starter.MongoDBRestAPI.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PutMapping("/addExpense")
    public ResponseEntity add(@RequestBody Expense expense){
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/updateExpense")
    public ResponseEntity Update(@RequestBody Expense expense){
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpense());
    }
    @GetMapping("getByName/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name){
        return ResponseEntity.ok(expenseService.getExpenseyName(name));
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity deleteByID(@PathVariable String id){
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
