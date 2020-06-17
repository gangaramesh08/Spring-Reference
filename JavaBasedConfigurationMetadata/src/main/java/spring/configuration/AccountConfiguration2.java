package spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import spring.model.Account;

@Configuration
@PropertySource("classpath:application.properties")
public class AccountConfiguration2 {

    @Bean
    public Account account(){
        Account account = new Account();
        account.setOwnerName("ashwin");
        return account;
    }
}
