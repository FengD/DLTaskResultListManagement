package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.CameraType;

@Mapper
public interface CameraTypeMapper {

	@Insert("INSERT INTO crdc_airi_dictionary_camera_type(name, description) VALUES (#{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})")
	int insert(String name, String description);

	@Select("SELECT * FROM crdc_airi_dictionary_camera_type WHERE camera_type_id=#{id,jdbcType=INTEGER}")
	CameraType selectById(int id);

	@Select("SELECT * FROM crdc_airi_dictionary_camera_type WHERE name=#{name,jdbcType=VARCHAR}")
	CameraType selectByName(String name);

	@Select("SELECT * FROM crdc_airi_dictionary_camera_type ORDER BY camera_type_id ASC")
	List<CameraType> selectAll();

	@Delete("delete from crdc_airi_dictionary_camera_type where camera_type_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
	
	@Update("Update crdc_airi_dictionary_camera_type set "
			+ " name=#{name,jdbcType=VARCHAR},"
			+ " description=#{description,jdbcType=VARCHAR}, "
			+ " update_time = CURRENT_TIMESTAMP where"
			+ " camera_type_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String name, String description);
}
