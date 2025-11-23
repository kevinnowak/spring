package com.github.kevinnowak;

import com.github.kevinnowak.exception.AccountNotFoundException;
import com.github.kevinnowak.model.Account;
import com.github.kevinnowak.repository.AccountRepository;
import com.github.kevinnowak.service.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferServiceWithAnnotationsTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransferService transferService;

    @Test
    public void moneyTransferHappyFlow() {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1_000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1_000));

        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId())).willReturn(Optional.of(receiver));

        transferService.transferMoney(sender.getId(), receiver.getId(), new BigDecimal(100));

        verify(accountRepository).changeAmount(sender.getId(), new BigDecimal(900));
        verify(accountRepository).changeAmount(receiver.getId(), new BigDecimal(1_100));
    }

    @Test
    public void moneyTransferDestinationAccountNotFoundFlow() {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1_000));

        long otherId = 2;

        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(otherId)).willReturn(Optional.empty());

        assertThrows(
                AccountNotFoundException.class,
                () -> transferService.transferMoney(sender.getId(), otherId, new BigDecimal(100))
        );

        verify(accountRepository, never()).changeAmount(anyLong(), any());
    }
}
