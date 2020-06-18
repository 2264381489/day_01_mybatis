package com.itheima.Dao.impl;

import com.itheima.Dao.UserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;
    //构造函数让他传一个工厂进来

//这个函数就是userDao的代理实现类
    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }
//在这个实现类中实现了,正常使用
    @Override
    public List<User> findAll() {
  //1.使用工厂创建Sqlsession对象
        SqlSession session = factory.openSession();
        //2.使用session执行的查询所有方法
        List<User> users=session.selectList("com.itheima.Dao.UserDao.findAll");
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    @Override
    public int findTotal() {
        return 0;
    }

    @Override
    public List<User> findUserByVo(QueryVo vo) {
        return null;
    }
}
