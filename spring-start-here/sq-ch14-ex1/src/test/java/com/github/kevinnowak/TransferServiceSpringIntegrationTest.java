package com.github.kevinnowak;

import com.github.kevinnowak.model.Account;
import com.github.kevinnowak.repository.AccountRepository;
import com.github.kevinnowak.service.TransferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransferServiceSpringIntegrationTest {

    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private TransferService transferService;

    @Test
    void transferServiceTransferAmountTest() {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1_000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1_000));

        when(accountRepository.findById(sender.getId())).thenReturn(Optional.of(sender));
        when(accountRepository.findById(receiver.getId())).thenReturn(Optional.of(receiver));

        transferService.transferMoney(sender.getId(), receiver.getId(), new BigDecimal(100));

        verify(accountRepository).changeAmount(sender.getId(), new BigDecimal(900));
        verify(accountRepository).changeAmount(receiver.getId(), new BigDecimal(1_100));
    }
}
