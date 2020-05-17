package spring;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.configuration.AccountConfiguration;
import spring.model.Account;
import spring.service.AccountService;

import java.time.LocalDateTime;

public class AccountMain {
  /*  @Autowired
    static BeanFactory applicationContext;*/

    public static void main(String[] args) {
        /***Java Based Configuration metadata ***/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfiguration.class);
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);

        Account account = new Account(1, "Ganga", 60000, LocalDateTime.now());
        Account account2 = new Account(2, "Ashwin", 30000, LocalDateTime.now());

        System.out.println("Java based configuration Metadata ");
        accountService.addAccount(account);
        accountService.addAccount(account2);
        AccountService accountService1 = applicationContext.getBean("accountService",AccountService.class);
        accountService1.addAccount(account);

        System.out.println("Before transfer : ");
        System.out.println(account.getOwnerName() + " : " + account.getBalance() + "\n" + account2.getOwnerName() + " : " + account2.getBalance());
        System.out.println("After transferring 10000");
        accountService.transferMoney(1, 2, 10000);
        System.out.println(account.getOwnerName() + " : " + account.getBalance() + "\n" + account2.getOwnerName() + " : " + account2.getBalance());
    }
}