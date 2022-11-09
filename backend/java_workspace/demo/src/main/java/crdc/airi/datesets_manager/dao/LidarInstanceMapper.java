package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.LidarInstance;

@Mapper
public interface LidarInstanceMapper {
	@Insert("INSERT INTO crdc_airi_lidar_instance(name, description, lidar_type_id, lidar_correction_file_path,"
			+ "lidar_calibration_file_path) VALUES " + "(" + "#{name,jdbcType=VARCHAR},"
			+ "#{description,jdbcType=VARCHAR},#{lidar_type_id, jdbcType=INTEGER}, "
			+ "#{lidar_correction_file_path,jdbcType=VARCHAR}, " + "#{lidar_calibration_file_path,jdbcType=VARCHAR})")
	int insert(String name, String description, int lidar_type_id, String lidar_correction_file_path,
			String lidar_calibration_file_path);

	@Select("select last_value from crdc_airi_lidar_instance_lidar_instance_id_seq;")
	int selectLastId();

	@Select("SELECT crdc_airi_lidar_instance.lidar_instance_id,crdc_airi_lidar_instance.name,crdc_airi_lidar_instance.description,crdc_airi_dictionary_lidar_type.name as lidar_type,crdc_airi_lidar_instance.lidar_correction_file_path,crdc_airi_lidar_instance.lidar_calibration_file_path,crdc_airi_lidar_instance.create_time,crdc_airi_lidar_instance.update_time  FROM crdc_airi_relation_datasets_info_lidar_instance,crdc_airi_lidar_instance,crdc_airi_dictionary_lidar_type WHERE crdc_airi_relation_datasets_info_lidar_instance.lidar_instance_id=crdc_airi_lidar_instance.lidar_instance_id AND crdc_airi_lidar_instance.lidar_type_id=crdc_airi_dictionary_lidar_type.lidar_type_id AND datasets_id=#{id,jdbcType=INTEGER}")
	List<LidarInstance> selectByDatasetsId(int id);

	@Select("SELECT crdc_airi_lidar_instance.lidar_instance_id,crdc_airi_lidar_instance.name,crdc_airi_lidar_instance.description,crdc_airi_dictionary_lidar_type.name as lidar_type,crdc_airi_lidar_instance.lidar_correction_file_path,crdc_airi_lidar_instance.lidar_calibration_file_path,crdc_airi_lidar_instance.create_time,crdc_airi_lidar_instance.update_time  FROM crdc_airi_relation_raw_datasets_info_lidar_instance,crdc_airi_lidar_instance,crdc_airi_dictionary_lidar_type WHERE crdc_airi_relation_raw_datasets_info_lidar_instance.lidar_instance_id=crdc_airi_lidar_instance.lidar_instance_id AND crdc_airi_lidar_instance.lidar_type_id=crdc_airi_dictionary_lidar_type.lidar_type_id AND raw_datasets_id=#{id,jdbcType=INTEGER}")
	List<LidarInstance> selectByRawDatasetsId(int id);

	@Select("SELECT crdc_airi_lidar_instance.lidar_instance_id,crdc_airi_lidar_instance.name,crdc_airi_lidar_instance.description,crdc_airi_dictionary_lidar_type.name as lidar_type,crdc_airi_lidar_instance.lidar_correction_file_path,crdc_airi_lidar_instance.lidar_calibration_file_path,crdc_airi_lidar_instance.create_time,crdc_airi_lidar_instance.update_time  FROM crdc_airi_lidar_instance, crdc_airi_dictionary_lidar_type WHERE crdc_airi_lidar_instance.lidar_type_id=crdc_airi_dictionary_lidar_type.lidar_type_id")
	List<LidarInstance> selectAll();

	@Update("Update crdc_airi_lidar_instance set name=#{name,jdbcType=VARCHAR},"
			+ " description=#{description,jdbcType=VARCHAR}," + " lidar_type_id=#{lidar_type_id,jdbcType=INTEGER},"
			+ " lidar_correction_file_path=#{lidar_correction_file_path,jdbcType=VARCHAR},"
			+ " lidar_calibration_file_path=#{lidar_calibration_file_path,jdbcType=VARCHAR},"
			+ " update_time = CURRENT_TIMESTAMP where" + " lidar_instance_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String name, String description, int lidar_type_id, String lidar_correction_file_path,
			String lidar_calibration_file_path);

	@Delete("delete from crdc_airi_lidar_instance where lidar_instance_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
}
