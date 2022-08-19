package com.ajitabh.repositories;

import com.ajitabh.config.AppConfig;
import com.ajitabh.entities.Account;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;


@Transactional
@ActiveProfiles("test")
public class JdbcAccountRepositoryTest {


    private static AccountRepository repository;
    private static ApplicationContext ctx;

    @BeforeAll
    public static void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        repository = ctx.getBean("repository", AccountRepository.class);
        System.out.println("Before All");
    }

    @Test
    public void testGetAccounts() throws Exception {
        System.out.println("thisGetAccounts");
        List<Account> accounts = repository.getAccounts();
        System.out.println("accounts = " + accounts);
        assertThat(accounts.size(), is(4));
    }

    @Test
    public void testGetAccount() throws Exception {
        System.out.println("thisGetAccount");
        Account account = repository.getAccount(1L);
        assertThat(account.getId(), is(1L));
        assertThat(new BigDecimal("100.0"),
                is(closeTo(account.getBalance(), new BigDecimal("0.01"))));
    }

    @Test
    public void testGetNumberOfAccounts() throws Exception {
        System.out.println("testGetNumberOfAccounts");
        assertThat(repository.getNumberOfAccounts(), is(4));
    }

    @Test
    public void testCreateAccount() throws Exception {
        System.out.println("testCreateAccount");
        Long id = repository.createAccount(new BigDecimal("250.00"));
        assertThat(id, is(notNullValue()));

        Account account = repository.getAccount(id);
        assertThat(account.getId(), is(id));
        assertThat(account.getBalance(), is(closeTo(new BigDecimal("250.00"),
                new BigDecimal("0.01"))));
    }

    @Test
    public void testUpdateAccount() throws Exception {
        System.out.println("testUpdateAccount");
        Account account = repository.getAccount(1L);
        BigDecimal current = account.getBalance();
        BigDecimal amount = new BigDecimal("50.0");
        account.setBalance(current.add(amount));
        repository.updateAccount(account);

        Account again = repository.getAccount(1L);
        assertThat(again.getBalance(), is(closeTo(current.add(amount),
                new BigDecimal("0.01"))));
    }

    @Test
    public void testDeleteAccount() throws Exception {
        System.out.println("testDeleteAccount");
        for (Account account : repository.getAccounts()) {
            repository.deleteAccount(account.getId());
        }
        assertThat(repository.getNumberOfAccounts(), is(0));
    }
}
