package com.ztbu.service;

import com.ztbu.mapper.userMapper;
import com.ztbu.pojo.User;
import com.ztbu.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    public SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User login(String username, String password){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        //4. 调用方法
        User user = mapper.selectByusername(username,password);
        //释放资源
        sqlSession.close();

        return  user;
    }

    public boolean register(User user){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
          userMapper mapper = sqlSession.getMapper(userMapper.class);
        //4. 判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());

        if(u == null){
            // 用户名不存在，注册
            mapper.insert(user);
            sqlSession.commit();
        }
        sqlSession.close();

        return u == null;

    }

    public User selectByUsername(String username){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        //4. 判断用户名是否存在
        User u = mapper.selectByUsername(username);

        sqlSession.close();
        return  u;
    }
}
