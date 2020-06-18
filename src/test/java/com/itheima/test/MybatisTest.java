package com.itheima.test;

//import javax.annotation.Resources;
//import javax.annotation.Resources;
import com.itheima.Dao.UserDao;
import com.itheima.Dao.impl.UserDaoImpl;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class MybatisTest {
    private InputStream in;
    private SqlSession session;
    private UserDao userDao;
    @Before//用于在测试方法之前执行
    public void init() throws IOException {
        //1.读取配置文件
      in= Resources.getResourceAsStream("sqlMapConfig.xml");
        //2.创建SQLSessionFactory工厂模式
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
//        UserDaoImpl userDao = new UserDaoImpl(factory);



        //3.使用工厂生产的SqlSession对象
        session=factory.openSession(true);
        //4.使用SqlSession创建Dao接口的代理对象
       userDao=session.getMapper(UserDao.class);
    }

    @After//用于在测试运行之后执行
    public void destroy() throws IOException {
//        session.commit();
        session.close();
        in.close();
    }
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws IOException {



    }
    @Test
    public void testSave() throws IOException {
        User user=new User();
        user.setUsername("mybaitis saveuser insertid");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("之前"+user);
        //保存方法
        userDao.saveUser(user);
                //5.使用代理对象执行方法
        System.out.println(user);
    }
    @Test
    public void Update() throws IOException {
        User user=new User();
        user.setId(41);
        user.setUsername("mybait111is updateuser");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        //保存方法
        userDao.updateUser(user);
        //5.使用代理对象执行方法
    }
    @Test
    public void delete() throws IOException {

        //保存方法
        userDao.deleteUser(42);
        //5.使用代理对象执行方法
    }
    @Test
    public void testFindOne() throws IOException {

        //保存方法
        User byId = userDao.findById(41);
        System.out.println(byId);
        //5.使用代理对象执行方法
    }
    @Test
    public void testfindByName() throws IOException {

        //保存方法
        List<User> byName = userDao.findByName("王");
        for (User u:byName
             ) {
            System.out.println(u);
        }

        //5.使用代理对象执行方法
    }

    /**
     * 查询总记录条数
     * @throws IOException
     */
    @Test
    public void testfindTotal() throws IOException {

        //保存方法
        int total = userDao.findTotal();
        System.out.println(total);
        //5.使用代理对象执行方法
    }
    @Test
    public void testfindUserByVo() throws IOException {


        QueryVo VO=new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        VO.setUser(user);

        List<User> userByVo = userDao.findUserByVo(VO);
        for (User u:userByVo
             ) {
            System.out.println(u);

        }


    }
}
