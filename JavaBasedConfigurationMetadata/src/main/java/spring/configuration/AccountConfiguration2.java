package spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.model.Account;

@Configuration
public class AccountConfiguration2 {

    @Bean
    public Account account(){
        Account account = new Account();
        account.setOwnerName("ashwin");
        return account;
    }
}
