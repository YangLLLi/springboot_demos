package github.yangllli.springboot_demos.mybatis.xmlMapper;

import github.yangllli.springboot_demos.mybatis.xmlPojo.City;
import github.yangllli.springboot_demos.mybatis.xmlPojo.CityExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * 增删改查id、example
 */

@Mapper
public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    List<City> selectByExample(CityExample example);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}