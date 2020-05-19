package spring.configuration;

import spring.dao.AccountDao;
import spring.dao.AccountDaoInMemoryImpl;
import spring.service.AccountService;
import spring.service.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class AccountConfiguration {

    @Bean(name ={"service","serviceAlias"})
    @DependsOn("accountDao")
    public AccountService accountService(){
        AccountServiceImpl accountServicebean = new AccountServiceImpl();
        accountServicebean.setAccountDao(accountDao());
        return accountServicebean;
    }

    @Bean
    public AccountDao accountDao(){
        AccountDaoInMemoryImpl accountDaoInMemorybean = new AccountDaoInMemoryImpl();
        return accountDaoInMemorybean;
    }
}
