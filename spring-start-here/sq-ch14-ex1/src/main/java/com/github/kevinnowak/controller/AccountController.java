package com.github.kevinnowak.controller;

import com.github.kevinnowak.dto.TransferRequest;
import com.github.kevinnowak.model.Account;
import com.github.kevinnowak.service.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount()
        );
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name) {
        return name == null ? transferService.getAllAccounts() : transferService.findAccountsByName(name);
    }
}
