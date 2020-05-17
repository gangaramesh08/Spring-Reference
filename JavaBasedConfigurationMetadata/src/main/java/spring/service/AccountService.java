package spring.service;

import spring.model.Account;


public interface AccountService {
    void transferMoney(long sourceAccountId, long targetAccountId, double amount);
    void depositMoney(long accountId, double amount) throws Exception;
    Account getAccount(long accountId);
    void addAccount(Account account);
}
