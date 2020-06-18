package com.itheima.Mybatis.sqlsession;

//import org.apache.ibatis.session.SqlSession;

public interface SqlSessionFactory {
    SqlSession openSession();
}
