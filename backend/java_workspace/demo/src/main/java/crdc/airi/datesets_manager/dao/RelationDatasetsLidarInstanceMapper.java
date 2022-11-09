package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import crdc.airi.datesets_manager.bean.RelationDatasetsLidarInstance;

@Mapper
public interface RelationDatasetsLidarInstanceMapper {

	@Insert("INSERT INTO crdc_airi_relation_datasets_info_lidar_instance(datasets_id, lidar_instance_id) VALUES (#{datasets_id,jdbcType=INTEGER}, #{lidar_instance_id,jdbcType=INTEGER})")
	int insert(int datasets_id, int lidar_instance_id);

	@Select("SELECT * FROM crdc_airi_relation_datasets_info_lidar_instance WHERE datasets_id=#{id,jdbcType=INTEGER}")
	List<RelationDatasetsLidarInstance> selectByDatasetsId(int id);

	@Select("SELECT * FROM crdc_airi_relation_datasets_info_lidar_instance ORDER BY crdc_airi_relation_datasets_info_lidar_list_id ASC")
	List<RelationDatasetsLidarInstance> selectAll();

	@Delete("delete from crdc_airi_relation_datasets_info_lidar_instance where crdc_airi_relation_datasets_info_lidar_list_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
}
