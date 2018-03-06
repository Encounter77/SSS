package com.ex.service;

import com.ex.pojo.Transaction;


public interface TransactionService {
    public Transaction getTransaction(int id);

    public void InsertTransaction(Transaction transaction);

    public void updateTransaction(Transaction transaction);

    public void InsertTransaction(int pid,int uid);
}
