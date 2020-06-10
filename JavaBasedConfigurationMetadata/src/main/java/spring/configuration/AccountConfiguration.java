package spring.configuration;

import org.springframework.beans.factory.annotation.Autowire;
import spring.dao.AccountDao;
import spring.dao.AccountDaoInMemoryImpl;
import spring.dao.AccountDaoJdbcImpl;
import spring.model.Account;
import spring.service.AccountService;
import spring.service.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class AccountConfiguration {

    @Bean(name ={"service","serviceAlias"})
    @DependsOn({"accountDao","account"})
    public AccountService accountService(){
        AccountServiceImpl accountServicebean = new AccountServiceImpl();
        //accountServicebean.setAccountDao(accountDao());
        return accountServicebean;
    }

    @Bean
    public AccountDao accountDao(){
        AccountDaoInMemoryImpl accountDaoInMemorybean = new AccountDaoInMemoryImpl();
        return accountDaoInMemorybean;
    }

    @Bean
    public AccountDao accountJdbcDao(){
        AccountDaoJdbcImpl accountDaoJdbc = new AccountDaoJdbcImpl();
        return accountDaoJdbc;
    }

    @Bean
    public Account account(){
        Account account = new Account();
        account.setOwnerName("Ganga");
        return account;
    }
}
