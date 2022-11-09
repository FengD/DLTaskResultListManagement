package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.TimeInterval;

@Mapper
public interface TimeIntervalMapper {
	
	@Insert("INSERT INTO crdc_airi_dictionary_time_interval(name, description) VALUES (#{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})")
	int insert(String name, String description);

	@Select("SELECT * FROM crdc_airi_dictionary_time_interval WHERE time_interval_id=#{id,jdbcType=INTEGER}")
	TimeInterval selectById(int id);

	@Select("SELECT * FROM crdc_airi_dictionary_time_interval WHERE name=#{name,jdbcType=VARCHAR}")
	TimeInterval selectByName(String name);

	@Select("SELECT * FROM crdc_airi_dictionary_time_interval ORDER BY time_interval_id ASC")
	List<TimeInterval> selectAll();

	@Delete("delete from crdc_airi_dictionary_time_interval where time_interval_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
	
	@Update("Update crdc_airi_dictionary_time_interval set "
			+ " name=#{name,jdbcType=VARCHAR},"
			+ " description=#{description,jdbcType=VARCHAR}, "
			+ " update_time = CURRENT_TIMESTAMP where"
			+ " time_interval_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String name, String description);
}
