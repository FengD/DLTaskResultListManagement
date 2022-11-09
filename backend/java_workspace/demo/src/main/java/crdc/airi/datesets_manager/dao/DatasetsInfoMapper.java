package crdc.airi.datesets_manager.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.DatasetsInfoDetails;

@Mapper
public interface DatasetsInfoMapper {
	@Insert("INSERT INTO crdc_airi_datasets_info" + "(name, scene_picture_link, "
			+ "datasets_link, nb_frames, nb_instances, nb_classes,"
			+ "collection_start_time, collection_recorder, applicable_scene_id,"
			+ "car_type_id, city_id, place_details, weather_id,"
			+ "time_interval_id, scenario_id, nb_lidars, nb_cameras,nb_radars,labeling_specification_file_path,"
			+ "datasets_raw_link, datasets_labeled_jpg_link,\n"
			+ "					datasets_training_png_link, datasets_lidar_pcd_link, datasets_ins_txt_link,\n"
			+ "					datasets_chassis_txt_link, nb_frames_extract_img, nb_frames_extract_lidar, nb_frames_extract_ins,\n"
			+ "					nb_frames_extract_chassis, raw_data_type_id, collection_period_seconds, collection_img_fps,\n"
			+ "					collection_lidar_fps, collection_information_file_path) "
			+ "VALUES (#{name,jdbcType=VARCHAR}, #{scene_picture_link,jdbcType=VARCHAR},"
			+ "#{datasets_link,jdbcType=VARCHAR},#{nb_frames,jdbcType=INTEGER},"
			+ "#{nb_instances,jdbcType=INTEGER},#{nb_classes,jdbcType=INTEGER},"
			+ "#{collection_start_time,jdbcType=TIMESTAMP},#{collection_recorder,jdbcType=VARCHAR},"
			+ "#{applicable_scene_id,jdbcType=INTEGER},#{car_type_id,jdbcType=INTEGER},"
			+ "#{city_id,jdbcType=INTEGER}, #{place_details,jdbcType=VARCHAR},"
			+ "#{weather_id,jdbcType=INTEGER},#{time_interval_id,jdbcType=INTEGER},"
			+ "#{scenario_id,jdbcType=INTEGER},#{nb_lidars,jdbcType=INTEGER},"
			+ "#{nb_cameras,jdbcType=INTEGER},#{nb_radars,jdbcType=INTEGER}, "
			+ "#{labeling_specification_file_path,jdbcType=VARCHAR}," + "#{datasets_raw_link,jdbcType=VARCHAR},"
			+ "#{datasets_labeled_jpg_link,jdbcType=VARCHAR}," + "#{datasets_training_png_link,jdbcType=VARCHAR},"
			+ "#{datasets_lidar_pcd_link,jdbcType=VARCHAR}," + "#{datasets_ins_txt_link,jdbcType=VARCHAR},"
			+ "#{datasets_chassis_txt_link,jdbcType=VARCHAR}," + "#{nb_frames_extract_img,jdbcType=INTEGER},"
			+ "#{nb_frames_extract_lidar,jdbcType=INTEGER}," + "#{nb_frames_extract_ins,jdbcType=INTEGER},"
			+ "#{nb_frames_extract_chassis,jdbcType=INTEGER}," + "#{raw_data_type_id,jdbcType=INTEGER},"
			+ "#{collection_period_seconds,jdbcType=INTEGER}," + "#{collection_img_fps,jdbcType=INTEGER},"
			+ "#{collection_lidar_fps,jdbcType=INTEGER}," + "#{collection_information_file_path,jdbcType=VARCHAR})")
	int insert(String name, String scene_picture_link, String datasets_link, int nb_frames, int nb_instances,
			int nb_classes, Timestamp collection_start_time, String collection_recorder, int applicable_scene_id,
			int car_type_id, int city_id, String place_details, int weather_id, int time_interval_id, int scenario_id,
			int nb_lidars, int nb_cameras, int nb_radars, String labeling_specification_file_path,
			String datasets_raw_link, String datasets_labeled_jpg_link, String datasets_training_png_link,
			String datasets_lidar_pcd_link, String datasets_ins_txt_link, String datasets_chassis_txt_link,
			int nb_frames_extract_img, int nb_frames_extract_lidar, int nb_frames_extract_ins,
			int nb_frames_extract_chassis, int raw_data_type_id, int collection_period_seconds, int collection_img_fps,
			int collection_lidar_fps, String collection_information_file_path);

	@Select("SELECT crdc_airi_datasets_info.datasets_id,\n" + "       crdc_airi_datasets_info.name,\n"
			+ "       crdc_airi_datasets_info.scene_picture_link,\n" + "       crdc_airi_datasets_info.datasets_link,\n"
			+ "       crdc_airi_datasets_info.nb_frames,\n" + "       crdc_airi_datasets_info.nb_instances,\n"
			+ "       crdc_airi_datasets_info.nb_classes,\n" + "       crdc_airi_datasets_info.collection_start_time,\n"
			+ "       crdc_airi_datasets_info.collection_recorder,\n"
			+ "       crdc_airi_dictionary_applicable_scene.name as applicable_scene,\n"
			+ "       crdc_airi_dictionary_car_type.name as car_type,\n"
			+ "       crdc_airi_dictionary_city.name as city, crdc_airi_datasets_info.place_details,\n"
			+ "       crdc_airi_dictionary_weather.name as weather,\n"
			+ "       crdc_airi_dictionary_time_interval.name as time_interval,\n"
			+ "       crdc_airi_dictionary_scenario.name as scenario,\n" + "       crdc_airi_datasets_info.nb_lidars,\n"
			+ "       crdc_airi_datasets_info.nb_cameras,\n" + "       crdc_airi_datasets_info.nb_radars,\n"
			+ "       crdc_airi_datasets_info.create_time,\n" + "       crdc_airi_datasets_info.update_time,\n"
			+ "       crdc_airi_datasets_info.labeling_specification_file_path,\n"
			+ "       crdc_airi_datasets_info.examining_times,\n"
			+ "       crdc_airi_datasets_info.datasets_raw_link,\n"
			+ "       crdc_airi_datasets_info.datasets_labeled_jpg_link,\n"
			+ "       crdc_airi_datasets_info.datasets_training_png_link,\n"
			+ "       crdc_airi_datasets_info.datasets_lidar_pcd_link,\n"
			+ "       crdc_airi_datasets_info.datasets_ins_txt_link,\n"
			+ "       crdc_airi_datasets_info.datasets_chassis_txt_link,\n"
			+ "       crdc_airi_datasets_info.nb_frames_extract_img,\n"
			+ "       crdc_airi_datasets_info.nb_frames_extract_lidar,\n"
			+ "       crdc_airi_datasets_info.nb_frames_extract_ins,\n"
			+ "       crdc_airi_datasets_info.nb_frames_extract_chassis,\n"
			+ "       crdc_airi_dictionary_raw_data_type.name as raw_data_type,\n"
			+ "       crdc_airi_datasets_info.collection_period_seconds,\n"
			+ "       crdc_airi_datasets_info.collection_img_fps,\n"
			+ "       crdc_airi_datasets_info.collection_lidar_fps,\n"
			+ "       crdc_airi_datasets_info.collection_information_file_path\n" + "      FROM\n"
			+ "       crdc_airi_datasets_info, \n" + "       crdc_airi_dictionary_applicable_scene,\n"
			+ "       crdc_airi_dictionary_car_type,\n" + "       crdc_airi_dictionary_city,\n"
			+ "       crdc_airi_dictionary_weather,\n" + "       crdc_airi_dictionary_time_interval,\n"
			+ "       crdc_airi_dictionary_scenario, crdc_airi_dictionary_raw_data_type\n" + "      WHERE \n"
			+ "       crdc_airi_datasets_info.applicable_scene_id = crdc_airi_dictionary_applicable_scene.applicable_scene_id AND\n"
			+ "       crdc_airi_datasets_info.car_type_id = crdc_airi_dictionary_car_type.car_type_id AND\n"
			+ "       crdc_airi_datasets_info.city_id = crdc_airi_dictionary_city.city_id AND\n"
			+ "       crdc_airi_datasets_info.weather_id = crdc_airi_dictionary_weather.weather_id AND\n"
			+ "       crdc_airi_datasets_info.raw_data_type_id = crdc_airi_dictionary_raw_data_type.raw_data_type_id AND\n"
			+ "       crdc_airi_datasets_info.time_interval_id = crdc_airi_dictionary_time_interval.time_interval_id AND\n"
			+ "       crdc_airi_datasets_info.scenario_id = crdc_airi_dictionary_scenario.scenario_id AND crdc_airi_datasets_info.datasets_id=#{id,jdbcType=INTEGER}")
	DatasetsInfoDetails selectById(int id);

	@Select("SELECT crdc_airi_datasets_info.datasets_id,\n" + "       crdc_airi_datasets_info.name,\n"
			+ "       crdc_airi_datasets_info.scene_picture_link,\n" + "       crdc_airi_datasets_info.datasets_link,\n"
			+ "       crdc_airi_datasets_info.nb_frames,\n" + "       crdc_airi_datasets_info.nb_instances,\n"
			+ "       crdc_airi_datasets_info.nb_classes,\n" + "       crdc_airi_datasets_info.collection_start_time,\n"
			+ "       crdc_airi_datasets_info.collection_recorder,\n"
			+ "       crdc_airi_dictionary_applicable_scene.name as applicable_scene,\n"
			+ "       crdc_airi_dictionary_car_type.name as car_type,\n"
			+ "       crdc_airi_dictionary_city.name as city, crdc_airi_datasets_info.place_details,\n"
			+ "       crdc_airi_dictionary_weather.name as weather,\n"
			+ "       crdc_airi_dictionary_time_interval.name as time_interval,\n"
			+ "       crdc_airi_dictionary_scenario.name as scenario,\n" + "       crdc_airi_datasets_info.nb_lidars,\n"
			+ "       crdc_airi_datasets_info.nb_cameras,\n" + "       crdc_airi_datasets_info.nb_radars,\n"
			+ "       crdc_airi_datasets_info.create_time,\n" + "       crdc_airi_datasets_info.update_time,\n"
			+ "       crdc_airi_datasets_info.labeling_specification_file_path,\n"
			+ "       crdc_airi_datasets_info.examining_times,\n"
			+ "       crdc_airi_datasets_info.datasets_raw_link,\n"
			+ "       crdc_airi_datasets_info.datasets_labeled_jpg_link,\n"
			+ "       crdc_airi_datasets_info.datasets_training_png_link,\n"
			+ "       crdc_airi_datasets_info.datasets_lidar_pcd_link,\n"
			+ "       crdc_airi_datasets_info.datasets_ins_txt_link,\n"
			+ "       crdc_airi_datasets_info.datasets_chassis_txt_link,\n"
			+ "       crdc_airi_datasets_info.nb_frames_extract_img,\n"
			+ "       crdc_airi_datasets_info.nb_frames_extract_lidar,\n"
			+ "       crdc_airi_datasets_info.nb_frames_extract_ins,\n"
			+ "       crdc_airi_datasets_info.nb_frames_extract_chassis,\n"
			+ "       crdc_airi_dictionary_raw_data_type.name as raw_data_type,\n"
			+ "       crdc_airi_datasets_info.collection_period_seconds,\n"
			+ "       crdc_airi_datasets_info.collection_img_fps,\n"
			+ "       crdc_airi_datasets_info.collection_lidar_fps,\n"
			+ "       crdc_airi_datasets_info.collection_information_file_path\n" + "      FROM\n"
			+ "       crdc_airi_datasets_info, \n" + "       crdc_airi_dictionary_applicable_scene,\n"
			+ "       crdc_airi_dictionary_car_type,\n" + "       crdc_airi_dictionary_city,\n"
			+ "       crdc_airi_dictionary_weather,\n"
			+ "       crdc_airi_dictionary_time_interval,crdc_airi_dictionary_raw_data_type,\n"
			+ "       crdc_airi_dictionary_scenario\n" + "      WHERE \n"
			+ "       crdc_airi_datasets_info.applicable_scene_id = crdc_airi_dictionary_applicable_scene.applicable_scene_id AND\n"
			+ "       crdc_airi_datasets_info.car_type_id = crdc_airi_dictionary_car_type.car_type_id AND\n"
			+ "       crdc_airi_datasets_info.city_id = crdc_airi_dictionary_city.city_id AND\n"
			+ "       crdc_airi_datasets_info.raw_data_type_id = crdc_airi_dictionary_raw_data_type.raw_data_type_id AND\n"
			+ "       crdc_airi_datasets_info.weather_id = crdc_airi_dictionary_weather.weather_id AND\n"
			+ "       crdc_airi_datasets_info.time_interval_id = crdc_airi_dictionary_time_interval.time_interval_id AND\n"
			+ "       crdc_airi_datasets_info.scenario_id = crdc_airi_dictionary_scenario.scenario_id AND crdc_airi_datasets_info.name=#{name,jdbcType=VARCHAR}")
	DatasetsInfoDetails selectByName(String name);

	@Select("SELECT crdc_airi_datasets_info.datasets_id,\n" + "       crdc_airi_datasets_info.name,\n"
			+ "       crdc_airi_datasets_info.scene_picture_link,\n" + "       crdc_airi_datasets_info.datasets_link,\n"
			+ "       crdc_airi_datasets_info.nb_frames,\n" + "       crdc_airi_datasets_info.nb_instances,\n"
			+ "       crdc_airi_datasets_info.nb_classes,\n" + "       crdc_airi_datasets_info.collection_start_time,\n"
			+ "       crdc_airi_datasets_info.collection_recorder,\n"
			+ "       crdc_airi_dictionary_applicable_scene.name as applicable_scene,\n"
			+ "       crdc_airi_dictionary_car_type.name as car_type,\n"
			+ "       crdc_airi_dictionary_city.name as city, crdc_airi_datasets_info.place_details,\n"
			+ "       crdc_airi_dictionary_weather.name as weather,\n"
			+ "       crdc_airi_dictionary_time_interval.name as time_interval,\n"
			+ "       crdc_airi_dictionary_scenario.name as scenario,\n" + "       crdc_airi_datasets_info.nb_lidars,\n"
			+ "       crdc_airi_datasets_info.nb_cameras,\n" + "       crdc_airi_datasets_info.nb_radars,\n"
			+ "       crdc_airi_datasets_info.create_time,\n" + "       crdc_airi_datasets_info.update_time,\n"
			+ "       crdc_airi_datasets_info.labeling_specification_file_path,\n"
			+ "       crdc_airi_datasets_info.examining_times,\n"
			+ "       crdc_airi_datasets_info.datasets_raw_link,\n"
			+ "       crdc_airi_datasets_info.datasets_labeled_jpg_link,\n"
			+ "       crdc_airi_datasets_info.datasets_training_png_link,\n"
			+ "       crdc_airi_datasets_info.datasets_lidar_pcd_link,\n"
			+ "       crdc_airi_datasets_info.datasets_ins_txt_link,\n"
			+ "       crdc_airi_datasets_info.datasets_chassis_txt_link,\n"
			+ "       crdc_airi_datasets_info.nb_frames_extract_img,\n"
			+ "       crdc_airi_datasets_info.nb_frames_extract_lidar,\n"
			+ "       crdc_airi_datasets_info.nb_frames_extract_ins,\n"
			+ "       crdc_airi_datasets_info.nb_frames_extract_chassis,\n"
			+ "       crdc_airi_dictionary_raw_data_type.name as raw_data_type,\n"
			+ "       crdc_airi_datasets_info.collection_period_seconds,\n"
			+ "       crdc_airi_datasets_info.collection_img_fps,\n"
			+ "       crdc_airi_datasets_info.collection_lidar_fps,\n"
			+ "       crdc_airi_datasets_info.collection_information_file_path\n" + "      FROM\n"
			+ "       crdc_airi_datasets_info, \n" + "       crdc_airi_dictionary_applicable_scene,\n"
			+ "       crdc_airi_dictionary_car_type,\n" + "       crdc_airi_dictionary_city,\n"
			+ "       crdc_airi_dictionary_weather,\n"
			+ "       crdc_airi_dictionary_time_interval,crdc_airi_dictionary_raw_data_type,\n"
			+ "       crdc_airi_dictionary_scenario\n" + "      WHERE \n"
			+ "       crdc_airi_datasets_info.applicable_scene_id = crdc_airi_dictionary_applicable_scene.applicable_scene_id AND\n"
			+ "       crdc_airi_datasets_info.car_type_id = crdc_airi_dictionary_car_type.car_type_id AND\n"
			+ "       crdc_airi_datasets_info.city_id = crdc_airi_dictionary_city.city_id AND\n"
			+ "       crdc_airi_datasets_info.raw_data_type_id = crdc_airi_dictionary_raw_data_type.raw_data_type_id AND\n"
			+ "       crdc_airi_datasets_info.weather_id = crdc_airi_dictionary_weather.weather_id AND\n"
			+ "       crdc_airi_datasets_info.time_interval_id = crdc_airi_dictionary_time_interval.time_interval_id AND\n"
			+ "       crdc_airi_datasets_info.scenario_id = crdc_airi_dictionary_scenario.scenario_id ORDER BY datasets_id ASC")
	List<DatasetsInfoDetails> selectAll();

	@Delete("delete from crdc_airi_datasets_info where datasets_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);

	@Update("Update crdc_airi_datasets_info set " + "name=#{name,jdbcType=VARCHAR}, "
			+ "scene_picture_link=#{scene_picture_link,jdbcType=VARCHAR},"
			+ "datasets_link=#{datasets_link,jdbcType=VARCHAR}," + "nb_frames=#{nb_frames,jdbcType=INTEGER},"
			+ "nb_instances=#{nb_instances,jdbcType=INTEGER}," + "nb_classes=#{nb_classes,jdbcType=INTEGER},"
			+ "collection_start_time=#{collection_start_time,jdbcType=TIMESTAMP},"
			+ "collection_recorder=#{collection_recorder,jdbcType=VARCHAR},"
			+ "applicable_scene_id=#{applicable_scene_id,jdbcType=INTEGER},"
			+ "car_type_id=#{car_type_id,jdbcType=INTEGER}," + "city_id=#{city_id,jdbcType=INTEGER}, "
			+ "place_details=#{place_details,jdbcType=VARCHAR}," + "weather_id=#{weather_id,jdbcType=INTEGER},"
			+ "time_interval_id=#{time_interval_id,jdbcType=INTEGER}," + "scenario_id=#{scenario_id,jdbcType=INTEGER},"
			+ "nb_lidars=#{nb_lidars,jdbcType=INTEGER}," + "nb_cameras=#{nb_cameras,jdbcType=INTEGER},"
			+ "nb_radars=#{nb_radars,jdbcType=INTEGER}, labeling_specification_file_path=#{labeling_specification_file_path,jdbcType=VARCHAR},"
			+ "examining_times=#{examining_times,jdbcType=INTEGER}," + "update_time = CURRENT_TIMESTAMP,"
			+ "datasets_raw_link=#{datasets_raw_link,jdbcType=VARCHAR},"
			+ "datasets_labeled_jpg_link=#{datasets_labeled_jpg_link,jdbcType=VARCHAR},"
			+ "datasets_training_png_link=#{datasets_training_png_link,jdbcType=VARCHAR},"
			+ "datasets_lidar_pcd_link=#{datasets_lidar_pcd_link,jdbcType=VARCHAR},"
			+ "datasets_ins_txt_link=#{datasets_ins_txt_link,jdbcType=VARCHAR},"
			+ "datasets_chassis_txt_link=#{datasets_chassis_txt_link,jdbcType=VARCHAR},"
			+ "nb_frames_extract_img=#{nb_frames_extract_img,jdbcType=INTEGER},"
			+ "nb_frames_extract_lidar=#{nb_frames_extract_lidar,jdbcType=INTEGER},"
			+ "nb_frames_extract_ins=#{nb_frames_extract_ins,jdbcType=INTEGER},"
			+ "nb_frames_extract_chassis=#{nb_frames_extract_chassis,jdbcType=INTEGER},"
			+ "raw_data_type_id=#{raw_data_type_id,jdbcType=INTEGER},"
			+ "collection_period_seconds=#{collection_period_seconds,jdbcType=INTEGER},"
			+ "collection_img_fps=#{collection_img_fps,jdbcType=INTEGER},"
			+ "collection_lidar_fps=#{collection_lidar_fps,jdbcType=INTEGER},"
			+ "collection_information_file_path=#{collection_information_file_path,jdbcType=VARCHAR} " + " where "
			+ " datasets_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String name, String scene_picture_link, String datasets_link, int nb_frames,
			int nb_instances, int nb_classes, Timestamp collection_start_time, String collection_recorder,
			int applicable_scene_id, int car_type_id, int city_id, String place_details, int weather_id,
			int time_interval_id, int scenario_id, int nb_lidars, int nb_cameras, int nb_radars,
			String labeling_specification_file_path, int examining_times,String datasets_raw_link, String datasets_labeled_jpg_link, String datasets_training_png_link,
			String datasets_lidar_pcd_link, String datasets_ins_txt_link, String datasets_chassis_txt_link,
			int nb_frames_extract_img, int nb_frames_extract_lidar, int nb_frames_extract_ins,
			int nb_frames_extract_chassis, int raw_data_type_id, int collection_period_seconds, int collection_img_fps,
			int collection_lidar_fps, String collection_information_file_path);
}
