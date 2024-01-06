package com.ztbu.service;

import com.ztbu.mapper.brandMapper;
import com.ztbu.pojo.Brand;
import com.ztbu.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有
     * @return
     */
    public List<Brand> selectAll(){
        //调用BrandMapper.selectAll()

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);

        //4. 调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;
    }

    public void addBrand(Brand brand){
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        mapper.addBrand(brand);

        sqlSession.commit();
        sqlSession.close();
    }

    public Brand selectById(int id){
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    public void update(Brand brand){
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        mapper.update(brand);

        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteById(int id){
        SqlSession sqlSession = factory.openSession();
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();

    }
}