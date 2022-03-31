package com.example.marketboard.controller;

import com.example.marketboard.constant.DebugMessage;
import com.example.marketboard.model.Stock;
import com.example.marketboard.model.StockRequest;
import com.example.marketboard.model.CreateStockRequest;
import com.example.marketboard.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@Slf4j
public class StockController {

    private final StockService service;

    public StockController(final StockService service){
        this.service = service;
    }

//    @GetMapping("/view")
//    public ResponseEntity<List<Stock>> view() {
//        final var result = service.listAll();
//        return ResponseEntity.ok().body(result);
//    }

    @GetMapping("/stock")
    public ResponseEntity<Stock> getStock(@Validated @RequestBody StockRequest stockRequest) {
        final var stock = service.getStock(stockRequest.getId());
        return ResponseEntity.ok().body(stock);
    }


    @PostMapping("/create")
    public ResponseEntity<Stock> createStock(@Validated @RequestBody CreateStockRequest createStockRequest) throws IOException {
        final var stock = Stock.builder()
                .email(createStockRequest.getEmail())
                .firstName(createStockRequest.getFirstName())
                .lastName(createStockRequest.getLastName())
                .posts(createStockRequest.getPosts())
                .comments(createStockRequest.getComments())
                .build();
        service.createStock(stock);
        log.debug(DebugMessage.MSG5,stock.getFirstName(),stock.getLastName(),stock.getId());
        return ResponseEntity.ok(stock);
    }
}
////Hello world