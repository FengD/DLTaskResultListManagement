package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import crdc.airi.datesets_manager.bean.RelationDatasetsInstanceList;

@Mapper
public interface RelationDatasetsInstanceListMapper {

	@Insert("INSERT INTO crdc_airi_relation_datasets_info_instance_list(datasets_id, instance_list_id) VALUES (#{datasets_id,jdbcType=INTEGER}, #{instance_list_id,jdbcType=INTEGER})")
	int insert(int datasets_id, int instance_list_id);

	@Select("SELECT * FROM crdc_airi_relation_datasets_info_instance_list WHERE datasets_id=#{id,jdbcType=INTEGER}")
	List<RelationDatasetsInstanceList> selectByDatasetsId(int id);

	@Select("SELECT * FROM crdc_airi_relation_datasets_info_instance_list ORDER BY crdc_airi_relation_datasets_info_instance_list_id ASC")
	List<RelationDatasetsInstanceList> selectAll();

	@Delete("delete from crdc_airi_relation_datasets_info_instance_list where crdc_airi_relation_datasets_info_instance_list_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
}
