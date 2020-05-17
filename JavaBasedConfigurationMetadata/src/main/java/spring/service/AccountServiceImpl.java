package spring.service;


import spring.dao.AccountDao;
import spring.model.Account;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transferMoney(long sourceAccountId, long targetAccountId, double amount) {
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
        accountDao.insert(account);
    }
}
