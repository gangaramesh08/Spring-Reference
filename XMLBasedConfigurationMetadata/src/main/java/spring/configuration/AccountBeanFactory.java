package spring.configuration;

import spring.service.AccountServiceImpl;

public class AccountBeanFactory {
    public static AccountServiceImpl accountService(){
        AccountServiceImpl accountService = new AccountServiceImpl();
        return accountService;
    }
    public AccountServiceImpl accountServiceImpl(){
        AccountServiceImpl accountService = new AccountServiceImpl();
        return accountService;
    }
}
