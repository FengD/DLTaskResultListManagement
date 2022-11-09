package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.CameraInstance;

@Mapper
public interface CameraInstanceMapper {

	@Insert("INSERT INTO crdc_airi_camera_instance(name, description, camera_type_id, camera_undistortion_file_path,"
			+ "camera_calibration_file_path) VALUES " + "(" + "#{name,jdbcType=VARCHAR}, "
			+ "#{description,jdbcType=VARCHAR}, #{camera_type_id, jdbcType=INTEGER}, "
			+ "#{camera_undistortion_file_path,jdbcType=VARCHAR}, "
			+ "#{camera_calibration_file_path,jdbcType=VARCHAR})")
	int insert(String name, String description, int camera_type_id, String camera_undistortion_file_path,
			String camera_calibration_file_path);

	@Select("select last_value from crdc_airi_camera_instance_camera_instance_id_seq;")
	int selectLastId();

	@Select("SELECT crdc_airi_camera_instance.camera_instance_id,crdc_airi_camera_instance.name,crdc_airi_camera_instance.description,\n"
			+ "  crdc_airi_dictionary_camera_type.name as camera_type,\n"
			+ "  crdc_airi_camera_instance.camera_undistortion_file_path,\n"
			+ "  crdc_airi_camera_instance.camera_calibration_file_path,\n"
			+ "  crdc_airi_camera_instance.create_time,\n" + "  crdc_airi_camera_instance.update_time \n" + "FROM \n"
			+ "  crdc_airi_relation_datasets_info_camera_instance,\n" + "  crdc_airi_camera_instance,\n"
			+ "  crdc_airi_dictionary_camera_type \n" + "WHERE \n"
			+ "  crdc_airi_relation_datasets_info_camera_instance.camera_instance_id=crdc_airi_camera_instance.camera_instance_id \n"
			+ "AND crdc_airi_camera_instance.camera_type_id=crdc_airi_dictionary_camera_type.camera_type_id AND datasets_id=#{id,jdbcType=INTEGER}")
	List<CameraInstance> selectByDatasetsId(int id);

	@Select("SELECT crdc_airi_camera_instance.camera_instance_id,crdc_airi_camera_instance.name,crdc_airi_camera_instance.description,\n"
			+ "  crdc_airi_dictionary_camera_type.name as camera_type,\n"
			+ "  crdc_airi_camera_instance.camera_undistortion_file_path,\n"
			+ "  crdc_airi_camera_instance.camera_calibration_file_path,\n"
			+ "  crdc_airi_camera_instance.create_time,\n" + "  crdc_airi_camera_instance.update_time \n" + "FROM \n"
			+ "  crdc_airi_relation_raw_datasets_info_camera_instance,\n" + "  crdc_airi_camera_instance,\n"
			+ "  crdc_airi_dictionary_camera_type \n" + "WHERE \n"
			+ "  crdc_airi_relation_raw_datasets_info_camera_instance.camera_instance_id=crdc_airi_camera_instance.camera_instance_id \n"
			+ "AND crdc_airi_camera_instance.camera_type_id=crdc_airi_dictionary_camera_type.camera_type_id AND raw_datasets_id=#{id,jdbcType=INTEGER}")
	List<CameraInstance> selectByRawDatasetsId(int id);

	@Select("SELECT crdc_airi_camera_instance.camera_instance_id,crdc_airi_camera_instance.name,crdc_airi_camera_instance.description,\n"
			+ "  crdc_airi_dictionary_camera_type.name as camera_type ,\n"
			+ "  crdc_airi_camera_instance.camera_undistortion_file_path,\n"
			+ "  crdc_airi_camera_instance.camera_calibration_file_path,\n"
			+ "  crdc_airi_camera_instance.create_time,\n" + "  crdc_airi_camera_instance.update_time \n" + "FROM \n"
			+ "  crdc_airi_camera_instance,\n" + "  crdc_airi_dictionary_camera_type \n" + "WHERE \n"
			+ " crdc_airi_camera_instance.camera_type_id=crdc_airi_dictionary_camera_type.camera_type_id;")
	List<CameraInstance> selectAll();

	@Update("Update crdc_airi_camera_instance set name=#{name,jdbcType=VARCHAR},"
			+ " description=#{description,jdbcType=VARCHAR}," + " camera_type_id=#{camera_type_id,jdbcType=INTEGER},"
			+ " camera_undistortion_file_path=#{camera_undistortion_file_path,jdbcType=VARCHAR},"
			+ " camera_calibration_file_path=#{camera_calibration_file_path,jdbcType=VARCHAR},"
			+ " update_time = CURRENT_TIMESTAMP where" + " camera_instance_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String name, String description, int camera_type_id, String camera_undistortion_file_path,
			String camera_calibration_file_path);

	@Delete("delete from crdc_airi_camera_instance where camera_instance_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);
}
