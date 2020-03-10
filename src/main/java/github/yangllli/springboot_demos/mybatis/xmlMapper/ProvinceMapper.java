package github.yangllli.springboot_demos.mybatis.xmlMapper;

import github.yangllli.springboot_demos.mybatis.xmlPojo.Province;
import github.yangllli.springboot_demos.mybatis.xmlPojo.ProvinceExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper
public interface ProvinceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Province record);

    int insertSelective(Province record);

    List<Province> selectByExample(ProvinceExample example);

    Province selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}