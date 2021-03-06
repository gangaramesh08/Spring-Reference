package spring.service;

import spring.configuration.PrototypeManager;
import spring.dao.AccountDao;
import spring.dao.AutowireCheck;
import spring.model.Account;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    private AutowireCheck check;
    private PrototypeManager prototypeManager;

    public AccountServiceImpl() {
    }

   /* public AccountDao getAccountDao() {
        return accountDao;
    }*/

    public AccountServiceImpl(AutowireCheck check, AccountDao accountDao) {
        this.accountDao=accountDao;
        this.check = check;
    }

    public void setPrototypeManager(PrototypeManager prototypeManager) {
        this.prototypeManager = prototypeManager;
    }

    public void setAutowireCheck(AutowireCheck check){
        this.check = check;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transferMoney(long sourceAccountId, long targetAccountId, double amount) {
        System.out.println("Printing the hashcode of accountDao in transferMoney :"+prototypeManager.getAccountDao().hashCode());
        Account source = accountDao.find(sourceAccountId);
        Account target = accountDao.find(targetAccountId);
        if(source.getBalance()>=amount){
            source.setBalance(source.getBalance() - amount);
            target.setBalance(target.getBalance() + amount);
            accountDao.update(source);
            accountDao.update(target);
        }
        else{
            System.out.println("Not enough balance");
        }

    }

    @Override
    public void depositMoney(long accountId, double amount) throws Exception {
        Account account = accountDao.find(accountId);
        if(account!=null){
            account.setBalance(amount);
            accountDao.update(account);
        }
    }

    @Override
    public Account getAccount(long accountId) {
        return accountDao.find(accountId);
    }

    @Override
    public void addAccount(Account account) {
        System.out.println("Printing the hashcode of accountDao in addAccount:"+prototypeManager.getAccountDao().hashCode());
        System.out.println("Before adding money check if account is autowired: "+check.getName());
        accountDao.insert(account);
    }
}
