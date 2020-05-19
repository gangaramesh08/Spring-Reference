package spring;

import org.springframework.beans.factory.annotation.Autowired;
import spring.model.Account;
import spring.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class AccountMain {
    public static void main(String[] args) {


        /***XML based Configuration Metadata***/
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = context.getBean("serviceAlias", AccountService.class);

        Account account = new Account(1, "Ganga", 60000, LocalDateTime.now());
        Account account2 = new Account(2, "Ashwin", 30000, LocalDateTime.now());
        accountService.addAccount(account);
        accountService.addAccount(account2);

        System.out.println("Before transfer : ");
        System.out.println(account.getOwnerName() + " : " + account.getBalance() + "\n" + account2.getOwnerName() + " : " + account2.getBalance());
        System.out.println("After transfering 10000");
        accountService.transferMoney(1, 2, 10000);
        System.out.println(account.getOwnerName() + " : " + account.getBalance() + "\n" + account2.getOwnerName() + " : " + account2.getBalance());

    }
}