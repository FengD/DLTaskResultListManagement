package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.City;

@Mapper
public interface CityMapper {
	
	@Insert("INSERT INTO crdc_airi_dictionary_city(name, description) VALUES (#{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})")
	int insert(String name, String description);

	@Select("SELECT * FROM crdc_airi_dictionary_city WHERE city_id=#{id,jdbcType=INTEGER}")
	City selectById(int id);

	@Select("SELECT * FROM crdc_airi_dictionary_city WHERE name=#{name,jdbcType=VARCHAR}")
	City selectByName(String name);

	@Select("SELECT * FROM crdc_airi_dictionary_city ORDER BY city_id ASC")
	List<City> selectAll();

	@Delete("delete from crdc_airi_dictionary_city where city_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
	
	@Update("Update crdc_airi_dictionary_city set "
			+ " name=#{name,jdbcType=VARCHAR},"
			+ " description=#{description,jdbcType=VARCHAR}, "
			+ " update_time = CURRENT_TIMESTAMP where"
			+ " city_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String name, String description);
}
