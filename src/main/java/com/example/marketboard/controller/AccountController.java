package com.example.marketboard.controller;

import com.example.marketboard.model.Account;
import com.example.marketboard.model.AccountRequest;
import com.example.marketboard.model.CreateAccountRequest;
import com.example.marketboard.service.AccountService;
import com.example.marketboard.constant.DebugMessage;
import com.example.marketboard.model.Account;
import com.example.marketboard.model.AccountRequest;
import com.example.marketboard.model.CreateAccountRequest;
import com.example.marketboard.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
public class AccountController {

    private final AccountService service;

    public AccountController(final AccountService service){
        this.service = service;
    }

//    @GetMapping("/list")
//    public ResponseEntity<List<Account>> view() {
//        final var result = service.listAll();
//        return ResponseEntity.ok().body(result);
//    }

    @GetMapping("/account")
    public ResponseEntity<Account> getAccount(@Validated @RequestBody AccountRequest accountRequest) {
        final var account = service.getAccount(accountRequest.getId());
        return ResponseEntity.ok().body(account);
    }


    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@Validated @RequestBody CreateAccountRequest createAccountRequest) throws IOException {
        final var account = Account.builder()
                .email(createAccountRequest.getEmail())
                .firstName(createAccountRequest.getFirstName())
                .lastName(createAccountRequest.getLastName())
                .posts(createAccountRequest.getPosts())
                .comments(createAccountRequest.getComments())
                .build();
        service.createAccount(account);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/update")
    public ResponseEntity<Account> updateAccount(@Validated @RequestBody AccountUpdateRequest accountUpdateRequest) throws IOException {
        final var id = accountUpdateRequest.getId();
        final var result = service.updateAccount();
        return ResponseEntity.ok().body(result);
    }
}