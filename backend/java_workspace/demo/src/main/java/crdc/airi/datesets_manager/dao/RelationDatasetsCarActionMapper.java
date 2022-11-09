package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import crdc.airi.datesets_manager.bean.RelationDatasetsCarAction;

@Mapper
public interface RelationDatasetsCarActionMapper {

	@Insert("INSERT INTO crdc_airi_relation_datasets_info_car_action_type(datasets_id, car_action_type_id) VALUES (#{datasets_id,jdbcType=INTEGER}, #{car_action_type_id,jdbcType=INTEGER})")
	int insert(int datasets_id, int car_action_type_id);

	@Select("SELECT * FROM crdc_airi_relation_datasets_info_car_action_type WHERE datasets_id=#{id,jdbcType=INTEGER}")
	List<RelationDatasetsCarAction> selectByDatasetsId(int id);
	
	@Select("SELECT * FROM crdc_airi_relation_datasets_info_car_action_type WHERE car_action_type_id=#{id,jdbcType=INTEGER}")
	List<RelationDatasetsCarAction> selectByCarActionTypeId(int id);

	@Select("SELECT * FROM crdc_airi_relation_datasets_info_car_action_type ORDER BY datasets_info_car_action_type_id ASC")
	List<RelationDatasetsCarAction> selectAll();

	@Delete("delete from crdc_airi_relation_datasets_info_car_action_type where datasets_info_car_action_type_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
}
