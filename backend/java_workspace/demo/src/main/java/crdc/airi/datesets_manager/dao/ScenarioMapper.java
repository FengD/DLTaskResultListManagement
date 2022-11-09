package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.Scenario;

@Mapper
public interface ScenarioMapper {

	@Insert("INSERT INTO crdc_airi_dictionary_scenario(name, description) VALUES (#{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})")
	int insert(String name, String description);

	@Select("SELECT * FROM crdc_airi_dictionary_scenario WHERE scenario_id=#{id,jdbcType=INTEGER}")
	Scenario selectById(int id);

	@Select("SELECT * FROM crdc_airi_dictionary_scenario WHERE name=#{name,jdbcType=VARCHAR}")
	Scenario selectByName(String name);

	@Select("SELECT * FROM crdc_airi_dictionary_scenario ORDER BY scenario_id ASC")
	List<Scenario> selectAll();

	@Delete("delete from crdc_airi_dictionary_scenario where scenario_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
	
	@Update("Update crdc_airi_dictionary_scenario set "
			+ " name=#{name,jdbcType=VARCHAR},"
			+ " description=#{description,jdbcType=VARCHAR}, "
			+ " update_time = CURRENT_TIMESTAMP where"
			+ " scenario_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String name, String description);
}
