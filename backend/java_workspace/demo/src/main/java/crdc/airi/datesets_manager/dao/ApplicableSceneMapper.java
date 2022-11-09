package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.ApplicableScene;

@Mapper
public interface ApplicableSceneMapper {

	@Insert("INSERT INTO crdc_airi_dictionary_applicable_scene(name, description) VALUES (#{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})")
	int insert(String name, String description);

	@Select("SELECT * FROM crdc_airi_dictionary_applicable_scene WHERE applicable_scene_id=#{id,jdbcType=INTEGER}")
	ApplicableScene selectById(int id);

	@Select("SELECT * FROM crdc_airi_dictionary_applicable_scene WHERE name=#{name,jdbcType=VARCHAR}")
	ApplicableScene selectByName(String name);

	@Select("SELECT * FROM crdc_airi_dictionary_applicable_scene ORDER BY applicable_scene_id ASC")
	List<ApplicableScene> selectAll();

	@Delete("delete from crdc_airi_dictionary_applicable_scene where applicable_scene_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);

	@Update("Update crdc_airi_dictionary_applicable_scene set name=#{name,jdbcType=VARCHAR},"
			+ " description=#{description,jdbcType=VARCHAR}, update_time = CURRENT_TIMESTAMP where"
			+ " applicable_scene_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String name, String description);
}
