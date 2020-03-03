package com.example.service;

/**
 * 账户业务层接口
 */
public interface IAccountService {
    //todo 此接口三个函数分别表示了无返回值无参，无返回值有参，有返回值无参三种类型，只是模拟，无任何实际意义，不需考虑方法本身
    /**
     * 模拟保存账户
     * @param
     */
    void saveAccount();

    /**
     * 模拟更新用户
     * @param
     */
    void updateAccount(int i);

    /**
     * 模拟删除用户
     * @param
     */
    int  deleteAccount();
}
