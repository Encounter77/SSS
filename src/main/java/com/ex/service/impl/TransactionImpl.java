package com.ex.service.impl;

import com.ex.dao.ContentDao;
import com.ex.dao.TransactionDao;
import com.ex.pojo.Transaction;
import com.ex.service.TransactionService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;

@Service
public class TransactionImpl implements TransactionService {

    @Resource
    private TransactionDao transactionDao;

    @Resource
    private ContentDao contentDao;


    public Transaction getTransaction(int id) {
        return transactionDao.getTransaction(id);
    }

    public void InsertTransaction(Transaction transaction) {
        transactionDao.InsertTransaction(transaction);
    }

    public void updateTransaction(Transaction transaction) {
        transactionDao.updateTransaction(transaction);
    }

    @Override
    public void InsertTransaction(int pid, int uid) {
        Transaction transaction = new Transaction();
        transaction.setContentId(pid);
        transaction.setPersonId(uid);
//        Transaction transaction1 = transactionDao.getTransaction(pid);
//        double p = transaction1.getPrice();
        transaction.setPrice(contentDao.getContent(pid).getPrice());
        transaction.setTime(new Date().getTime());
        transactionDao.InsertTransaction(transaction);
    }
}
