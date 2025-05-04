package com.example.demo.controller;

import com.example.demo.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<String> getStockData(@PathVariable String symbol){
        String res = stockService.getDailyStockData(symbol);
        return ResponseEntity.ok(res);
    }
}
