package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.RawDataType;

@Mapper
public interface RawDataTypeMapper {

	@Insert("INSERT INTO crdc_airi_dictionary_raw_data_type(name, description) VALUES (#{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})")
	int insert(String name, String description);

	@Select("SELECT * FROM crdc_airi_dictionary_raw_data_type WHERE raw_data_type_id=#{id,jdbcType=INTEGER}")
	RawDataType selectById(int id);

	@Select("SELECT * FROM crdc_airi_dictionary_raw_data_type WHERE name=#{name,jdbcType=VARCHAR}")
	RawDataType selectByName(String name);

	@Select("SELECT * FROM crdc_airi_dictionary_raw_data_type ORDER BY raw_data_type_id ASC")
	List<RawDataType> selectAll();

	@Delete("delete from crdc_airi_dictionary_raw_data_type where raw_data_type_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
	
	@Update("Update crdc_airi_dictionary_raw_data_type set "
			+ " name=#{name,jdbcType=VARCHAR},"
			+ " description=#{description,jdbcType=VARCHAR}, "
			+ " update_time = CURRENT_TIMESTAMP where"
			+ " raw_data_type_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String name, String description);
}
