package github.yangllli.springboot_demos.mybatis.mapper;

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
public interface ProvinceMapper {
    @Insert("insert into province values(null,#{name})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void add(Province province);

    @Select("select * from province")
    @Results(id="provinceMap",value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    List<Province> list();

    @Select("select * from province where id=#{id}")
    @ResultMap({"provinceMap"})
    Province findById(int id);

}
