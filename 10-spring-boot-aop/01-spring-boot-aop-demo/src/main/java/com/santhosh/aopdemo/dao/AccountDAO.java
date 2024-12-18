package com.santhosh.aopdemo.dao;

import com.santhosh.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
