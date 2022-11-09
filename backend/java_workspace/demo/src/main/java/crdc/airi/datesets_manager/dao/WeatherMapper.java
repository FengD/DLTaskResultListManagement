package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.Weather;

@Mapper
public interface WeatherMapper {
	
	@Insert("INSERT INTO crdc_airi_dictionary_weather(name, description) VALUES (#{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})")
	int insert(String name, String description);

	@Select("SELECT * FROM crdc_airi_dictionary_weather WHERE weather_id=#{id,jdbcType=INTEGER}")
	Weather selectById(int id);

	@Select("SELECT * FROM crdc_airi_dictionary_weather WHERE name=#{name,jdbcType=VARCHAR}")
	Weather selectByName(String name);

	@Select("SELECT * FROM crdc_airi_dictionary_weather ORDER BY weather_id ASC")
	List<Weather> selectAll();

	@Delete("delete from crdc_airi_dictionary_weather where weather_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
	
	@Update("Update crdc_airi_dictionary_weather set "
			+ " name=#{name,jdbcType=VARCHAR},"
			+ " description=#{description,jdbcType=VARCHAR}, "
			+ " update_time = CURRENT_TIMESTAMP where"
			+ " weather_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String name, String description);
}
