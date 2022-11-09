package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.InstanceType;

@Mapper
public interface InstanceTypeMapper {

	@Insert("INSERT INTO crdc_airi_dictionary_instance_type(name, description) VALUES (#{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})")
	int insert(String name, String description);

	@Select("SELECT * FROM crdc_airi_dictionary_instance_type WHERE instance_type_id=#{id,jdbcType=INTEGER}")
	InstanceType selectById(int id);

	@Select("SELECT * FROM crdc_airi_dictionary_instance_type WHERE name=#{name,jdbcType=VARCHAR}")
	InstanceType selectByName(String name);

	@Select("SELECT * FROM crdc_airi_dictionary_instance_type ORDER BY instance_type_id ASC")
	List<InstanceType> selectAll();

	@Delete("delete from crdc_airi_dictionary_instance_type where instance_type_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
	
	@Update("Update crdc_airi_dictionary_instance_type set "
			+ " name=#{name,jdbcType=VARCHAR},"
			+ " description=#{description,jdbcType=VARCHAR}, "
			+ " update_time = CURRENT_TIMESTAMP where"
			+ " instance_type_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String name, String description);
}
