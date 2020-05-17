package spring.dao;


import spring.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoInMemoryImpl implements AccountDao {
    private Map<Long, Account> accountsMap = new HashMap<>();

    @Override
    public void insert(Account account) {
        accountsMap.put(account.getId(),account);

    }

    @Override
    public void update(Account account) {
        accountsMap.put(account.getId(),account);
    }

    @Override
    public void update(List<Account> accounts) {
        accounts.forEach(account -> accountsMap.put(account.getId(),account));

    }

    @Override
    public void delete(long accountId) {
        accountsMap.remove(accountId);
    }

    @Override
    public Account find(long accountId) {
        return accountsMap.get(accountId);
    }

    @Override
    public List<Account> find(List<Long> accountIds) {
        List<Account> accountList = new ArrayList<>();
        accountIds.forEach(accountId-> accountList.add(find(accountId)));
        return accountList;
    }

    @Override
    public List<Account> find(String ownerName) {
        List<Account> accountList = new ArrayList<>();
        Account account;
        for (Map.Entry<Long,Account> map: accountsMap.entrySet()){
            account = map.getValue();
            if(account.getOwnerName().equalsIgnoreCase(ownerName)){
                accountList.add(account);
            }
        }
        return accountList;
    }

    /*@Override
    public List<Account> find(boolean locked) {
        return null;
    }*/
}
