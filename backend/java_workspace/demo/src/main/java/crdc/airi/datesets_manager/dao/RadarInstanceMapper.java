package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.RadarInstance;

@Mapper
public interface RadarInstanceMapper {

	@Insert("INSERT INTO crdc_airi_radar_instance(name, description, radar_type_id,"
			+ "radar_calibration_file_path) VALUES " + "(#{name,jdbcType=VARCHAR}," + "#{description,jdbcType=VARCHAR},"
			+ "#{radar_type_id, jdbcType=INTEGER}, " + "#{radar_calibration_file_path,jdbcType=VARCHAR})")
	int insert(String name, String description, int radar_type_id, String radar_calibration_file_path);

	@Select("select last_value from crdc_airi_radar_instance_radar_instance_id_seq;")
	int selectLastId();

	@Select("SELECT crdc_airi_radar_instance.radar_instance_id,crdc_airi_radar_instance.name,crdc_airi_radar_instance.description,\n"
			+ "  crdc_airi_dictionary_radar_type.name as radar_type,\n"
			+ "  crdc_airi_radar_instance.radar_calibration_file_path,\n" + "  crdc_airi_radar_instance.create_time,\n"
			+ "  crdc_airi_radar_instance.update_time \n" + "FROM \n"
			+ "  crdc_airi_relation_datasets_info_radar_instance,\n" + "  crdc_airi_radar_instance,\n"
			+ "  crdc_airi_dictionary_radar_type \n" + "WHERE \n"
			+ "  crdc_airi_relation_datasets_info_radar_instance.radar_instance_id=crdc_airi_radar_instance.radar_instance_id \n"
			+ "AND crdc_airi_radar_instance.radar_type_id=crdc_airi_dictionary_radar_type.radar_type_id AND datasets_id=#{id,jdbcType=INTEGER}")
	List<RadarInstance> selectByDatasetsId(int id);

	@Select("SELECT crdc_airi_radar_instance.radar_instance_id,crdc_airi_radar_instance.name,crdc_airi_radar_instance.description,\n"
			+ "  crdc_airi_dictionary_radar_type.name as radar_type,\n"
			+ "  crdc_airi_radar_instance.radar_calibration_file_path,\n" + "  crdc_airi_radar_instance.create_time,\n"
			+ "  crdc_airi_radar_instance.update_time \n" + "FROM \n"
			+ "  crdc_airi_relation_raw_datasets_info_radar_instance,\n" + "  crdc_airi_radar_instance,\n"
			+ "  crdc_airi_dictionary_radar_type \n" + "WHERE \n"
			+ "  crdc_airi_relation_raw_datasets_info_radar_instance.radar_instance_id=crdc_airi_radar_instance.radar_instance_id \n"
			+ "AND crdc_airi_radar_instance.radar_type_id=crdc_airi_dictionary_radar_type.radar_type_id AND raw_datasets_id=#{id,jdbcType=INTEGER}")
	List<RadarInstance> selectByRawDatasetsId(int id);

	@Select("SELECT crdc_airi_radar_instance.radar_instance_id,crdc_airi_radar_instance.name,crdc_airi_radar_instance.description,\n"
			+ "  crdc_airi_dictionary_radar_type.name as radar_type,\n"
			+ "  crdc_airi_radar_instance.radar_calibration_file_path,\n" + "  crdc_airi_radar_instance.create_time,\n"
			+ "  crdc_airi_radar_instance.update_time \n" + "FROM \n" + "  crdc_airi_radar_instance,\n"
			+ "  crdc_airi_dictionary_radar_type \n"
			+ "WHERE  crdc_airi_radar_instance.radar_type_id=crdc_airi_dictionary_radar_type.radar_type_id;")
	List<RadarInstance> selectAll();

	@Update("Update crdc_airi_radar_instance set name=#{name,jdbcType=VARCHAR},"
			+ " description=#{description,jdbcType=VARCHAR}," + " radar_type_id=#{radar_type_id,jdbcType=INTEGER},"
			+ " radar_calibration_file_path=#{radar_calibration_file_path,jdbcType=VARCHAR},"
			+ " update_time = CURRENT_TIMESTAMP where" + " radar_instance_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String name, String description, int radar_type_id, String radar_calibration_file_path);

	@Delete("delete from crdc_airi_radar_instance where radar_instance_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
}
