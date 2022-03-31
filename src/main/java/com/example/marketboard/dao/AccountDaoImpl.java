//package com.example.marketboard.dao;
//
//import com.example.marketboard.model.Account;
//
//import java.util.List;
//import java.util.UUID;
//
//public class AccountDaoImpl implements AccountDao {
//    private final SqlSessionFactory sqlSessionFactory;
//
//    public AccountDaoImpl(final SqlSessionFactory sqlSessionFactory) {
//        this.sqlSessionFactory = sqlSessionFactory;
//    }
//
//    public Account getAccount(final UUID id) {
//        try (final var session = sqlSessionFactory.openSession()) {
//            final var mapper = session.getMapper(AccountMapper.class);
//            final var account = mapper.getAccount(id);
//            return account;
//        }
//    }
//
//    public List<Account> getAll() {
//        try (final var session = sqlSessionFactory.openSession()) {
//            final var mapper = session.getMapper(AccountMapper.class);
//            final var accounts = mapper.getAll();
//            return accounts;
//        }
//    }
//
//    public void save(final Account account) {
//        try (final var session = sqlSessionFactory.openSession()) {
//            final var mapper = session.getMapper(AccountMapper.class);
//            mapper.save(account);
//            session.commit();
//        }
//    }
//
//    public void create(final Account account) {
//        try (final var session = sqlSessionFactory.openSession()) {
//            final var mapper = session.getMapper(AccountMapper.class);
//            mapper.create(account);
//            session.commit();
//        }
//    }
//}
