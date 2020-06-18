package com.itheima.Dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {


    /**
     * 查询所有操作
     * @return
     */
//    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    User findById(Integer id);

    /**
     * 根据名称模糊查询.
     * @param name
     * @return
     */
    List<User> findByName(String name);
    /**
     * 使用聚合函数
     */
    int findTotal();

    /**
     * 根据queryVo得条件查询用户,即用已经查出来的东西去检查其他东西.
     * @param
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

}
