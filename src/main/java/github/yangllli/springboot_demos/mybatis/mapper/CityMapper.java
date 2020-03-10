package github.yangllli.springboot_demos.mybatis.mapper;

import github.yangllli.springboot_demos.mybatis.pojo.City;
import github.yangllli.springboot_demos.mybatis.pojo.Province;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Mapper
 *
 * @Select @Results @Result
 * @Insert @Options
 * @Update
 * @Delete
 *
 */

//@Mapper
public interface CityMapper {

    @Insert("insert into city values(null,#{name},#{province.id})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void add(City city);

    @Select("select * from city where pid=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "province",column = "pid",one = @One(select = "github.yangllli.springboot_demos.mybatis.mapper.ProvinceMapper.findById"))
    })
    List<City> listByProvince(Province province);
}
