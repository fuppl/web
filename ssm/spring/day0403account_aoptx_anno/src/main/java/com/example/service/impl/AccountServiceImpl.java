package com.example.service.impl;

import com.example.dao.IAccountDao;
import com.example.dao.impl.AccountDaoImpl;
import com.example.entity.Account;
import com.example.service.IAccountService;
import com.example.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
        return  accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {

        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) {

        accountDao.deleteAccount(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, double money) {
        System.out.println("transfor...");
            //2.1根据名称查询转出账户
            Account source = accountDao.findByName(sourceName);
            //2.2根据名称查询转入账户
            Account target = accountDao.findByName(targetName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney() - money);
            //2.4转入账户加钱
            target.setMoney(target.getMoney() + money);
            //2.5更新转出账户
            accountDao.updateAccount(source);
            int i = 1/0;
            //2.6更新转入账户
            accountDao.updateAccount(target);

    }

}
