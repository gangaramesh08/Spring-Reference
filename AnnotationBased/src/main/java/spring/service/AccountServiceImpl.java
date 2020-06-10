package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import spring.dao.AccountDao;
import spring.model.Account;

@Service
//@DependsOn({"accountDaoInMemoryImpl","account"})
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDaos;


    /*public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }*/

    @Override
    public void transferMoney(long sourceAccountId, long targetAccountId, double amount) {
        Account source = accountDaos.find(sourceAccountId);
        Account target = accountDaos.find(targetAccountId);
        if(source.getBalance()>=amount){
            source.setBalance(source.getBalance() - amount);
            target.setBalance(target.getBalance() + amount);
            accountDaos.update(source);
            accountDaos.update(target);
        }
        else{
            System.out.println("Not enough balance");
        }

    }

    @Override
    public void depositMoney(long accountId, double amount) throws Exception {
        Account account = accountDaos.find(accountId);
        if(account!=null){
            account.setBalance(amount);
            accountDaos.update(account);
        }
    }

    @Override
    public Account getAccount(long accountId) {
        return accountDaos.find(accountId);
    }

    @Override
    public void addAccount(Account account) {
        accountDaos.insert(account);
    }
}
