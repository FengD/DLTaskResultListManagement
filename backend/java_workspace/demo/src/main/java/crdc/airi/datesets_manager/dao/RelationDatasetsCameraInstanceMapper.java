package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import crdc.airi.datesets_manager.bean.RelationDatasetsCameraInstance;

@Mapper
public interface RelationDatasetsCameraInstanceMapper {

	@Insert("INSERT INTO crdc_airi_relation_datasets_info_camera_instance(datasets_id, camera_instance_id) VALUES (#{datasets_id,jdbcType=INTEGER}, #{camera_instance_id,jdbcType=INTEGER})")
	int insert(int datasets_id, int camera_instance_id);

	@Select("SELECT * FROM crdc_airi_relation_datasets_info_camera_instance WHERE datasets_id=#{id,jdbcType=INTEGER}")
	List<RelationDatasetsCameraInstance> selectByDatasetsId(int id);

	@Select("SELECT * FROM crdc_airi_relation_datasets_info_camera_instance ORDER BY crdc_airi_relation_datasets_info_camera_list_id ASC")
	List<RelationDatasetsCameraInstance> selectAll();

	@Delete("delete from crdc_airi_relation_datasets_info_camera_instance where crdc_airi_relation_datasets_info_camera_list_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
}
