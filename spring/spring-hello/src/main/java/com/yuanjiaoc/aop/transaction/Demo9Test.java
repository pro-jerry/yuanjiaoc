package com.yuanjiaoc.aop.transaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author 何二白
 * @version 1.0
 * @since 2023年01月03日
 */
public class Demo9Test {

    JdbcTemplate jdbcTemplate;
    PlatformTransactionManager platformTransactionManager;

    @Before
    public void before() {
        //定义一个数据源
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/employees?characterEncoding=UTF-8");
        dataSource.setUsername("mina");
        dataSource.setPassword("123456");
        dataSource.setInitialSize(5);
        //定义一个JdbcTemplate，用来方便执行数据库增删改查
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.platformTransactionManager = new DataSourceTransactionManager(dataSource);
        this.jdbcTemplate.update("truncate table t_user");
    }

    @Test
    public void m0() throws Exception {
        System.out.println("PROPAGATION_REQUIRED start");
        //2.定义事务属性：TransactionDefinition，TransactionDefinition可以用来配置事务的属性信息，比如事务隔离级别、事务超时时间、事务传播方式、是否是只读事务等等。
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition(
                TransactionDefinition.PROPAGATION_REQUIRED);
        //3.开启事务：调用platformTransactionManager.getTransaction开启事务操作，得到事务状态(TransactionStatus)对象
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        this.addSynchronization("ts-1", 2);
        this.addSynchronization("ts-2", 1);
        //4.执行业务操作，下面就执行2个插入操作
        jdbcTemplate.update("insert into t_user (name) values (?)", "test1-1");
        jdbcTemplate.update("insert into t_user (name) values (?)", "test1-2");
        this.m1();
        //5.提交事务：platformTransactionManager.commit
        System.out.println("PROPAGATION_REQUIRED 准备commit");
        platformTransactionManager.commit(transactionStatus);
        System.out.println("PROPAGATION_REQUIRED commit完毕");

        System.out.println("after:" + jdbcTemplate.queryForList("SELECT * from t_user"));
    }

    public void m1() {
        System.out.println("PROPAGATION_REQUIRES_NEW start");
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition(
                TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        jdbcTemplate.update("insert into t_user (name) values (?)", "test2-1");
        jdbcTemplate.update("insert into t_user (name) values (?)", "test2-2");
        this.addSynchronization("ts-3", 2);
        this.addSynchronization("ts-4", 1);
        System.out.println("PROPAGATION_REQUIRES_NEW 准备commit");
        platformTransactionManager.commit(transactionStatus);
        System.out.println("PROPAGATION_REQUIRES_NEW commit完毕");
    }

    public void addSynchronization(final String name, final int order) {
        if (TransactionSynchronizationManager.isSynchronizationActive()) {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public int getOrder() {
                    return order;
                }

                @Override
                public void suspend() {
                    System.out.println(name + ":suspend");
                }

                @Override
                public void resume() {
                    System.out.println(name + ":resume");
                }

                @Override
                public void flush() {
                    System.out.println(name + ":flush");
                }

                @Override
                public void beforeCommit(boolean readOnly) {
                    System.out.println(name + ":beforeCommit:" + readOnly);
                }

                @Override
                public void beforeCompletion() {
                    System.out.println(name + ":beforeCompletion");
                }

                @Override
                public void afterCommit() {
                    System.out.println(name + ":afterCommit");
                }

                @Override
                public void afterCompletion(int status) {
                    System.out.println(name + ":afterCompletion:" + status);
                }
            });
        }
    }
}
