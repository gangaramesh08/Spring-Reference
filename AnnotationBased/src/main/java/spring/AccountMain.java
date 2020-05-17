package spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.model.Account;
import spring.service.AccountService;
import spring.service.AccountServiceImpl;

import java.time.LocalDateTime;

public class AccountMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Account account = new Account(1,"Ganga",60000, LocalDateTime.now());
        Account account2 = new Account(2,"Ashwin",30000, LocalDateTime.now());
        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountServiceImpl.class);
        accountService.addAccount(account);
        accountService.addAccount(account2);
        System.out.println("Before transfer");
        System.out.println(account.getOwnerName()+" : "+account.getBalance());
        System.out.println(account2.getOwnerName()+" : "+account2.getBalance());
        accountService.transferMoney(1,2,60000);
        System.out.println("After transfer");
        System.out.println(account.getOwnerName()+" : "+account.getBalance());
        System.out.println(account2.getOwnerName()+" : "+account2.getBalance());
    }
}
