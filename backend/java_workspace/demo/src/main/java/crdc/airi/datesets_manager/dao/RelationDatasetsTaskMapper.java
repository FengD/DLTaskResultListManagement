package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import crdc.airi.datesets_manager.bean.RelationDatasetsTask;

@Mapper
public interface RelationDatasetsTaskMapper {

	@Insert("INSERT INTO crdc_airi_relation_datasets_info_task_type(datasets_id, task_type_id) VALUES (#{datasets_id,jdbcType=INTEGER}, #{task_type_id,jdbcType=INTEGER})")
	int insert(int datasets_id, int task_type_id);

	@Select("SELECT * FROM crdc_airi_relation_datasets_info_task_type WHERE datasets_id=#{id,jdbcType=INTEGER}")
	List<RelationDatasetsTask> selectByDatasetsId(int id);

	@Select("SELECT * FROM crdc_airi_relation_datasets_info_task_type WHERE task_type_id=#{id,jdbcType=INTEGER}")
	List<RelationDatasetsTask> selectByTaskTypeId(int id);

	@Select("SELECT * FROM crdc_airi_relation_datasets_info_task_type ORDER BY datasets_info_task_type_id ASC")
	List<RelationDatasetsTask> selectAll();

	@Delete("delete from crdc_airi_relation_datasets_info_task_type where datasets_info_task_type_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
}
