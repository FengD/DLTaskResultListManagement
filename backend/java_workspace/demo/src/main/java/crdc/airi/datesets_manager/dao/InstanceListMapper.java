package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.InstanceList;

@Mapper
public interface InstanceListMapper {

	@Insert("INSERT INTO crdc_airi_instance_list(name, description, number, instance_type_id) VALUES ("
			+ "#{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR},"
			+ "#{number,jdbcType=INTEGER}, #{instance_type_id,jdbcType=INTEGER})")
	int insert(String name, String description, int number, int instance_type_id);

	@Select("select last_value from crdc_airi_instance_list_instance_list_id_seq;")
	int selectLastId();

	@Select("SELECT crdc_airi_instance_list.instance_list_id,crdc_airi_instance_list.name,crdc_airi_instance_list.description,crdc_airi_instance_list.number,crdc_airi_dictionary_instance_type.name as instance_type,crdc_airi_instance_list.create_time,crdc_airi_instance_list.update_time  FROM crdc_airi_relation_datasets_info_instance_list,crdc_airi_instance_list,crdc_airi_dictionary_instance_type WHERE crdc_airi_relation_datasets_info_instance_list.instance_list_id=crdc_airi_instance_list.instance_list_id AND crdc_airi_instance_list.instance_type_id=crdc_airi_dictionary_instance_type.instance_type_id AND datasets_id=#{id,jdbcType=INTEGER}")
	List<InstanceList> selectByDatasetsId(int id);

	@Select("SELECT crdc_airi_instance_list.instance_list_id,crdc_airi_instance_list.name,crdc_airi_instance_list.description,crdc_airi_instance_list.number,crdc_airi_dictionary_instance_type.name as instance_type,crdc_airi_instance_list.create_time,crdc_airi_instance_list.update_time  FROM crdc_airi_instance_list, crdc_airi_dictionary_instance_type WHERE crdc_airi_instance_list.instance_type_id=crdc_airi_dictionary_instance_type.instance_type_id")
	List<InstanceList> selectAll();
	
	@Update("Update crdc_airi_instance_list set name=#{name,jdbcType=VARCHAR},"
			+ " description=#{description,jdbcType=VARCHAR},"
			+ " number=#{number,jdbcType=INTEGER},"
			+ " instance_type_id=#{instance_type_id,jdbcType=INTEGER},"
			+ " update_time = CURRENT_TIMESTAMP where"
			+ " instance_list_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String name, String description, int number, int instance_type_id);

	@Delete("delete from crdc_airi_instance_list where instance_list_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
}
