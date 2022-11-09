package crdc.airi.datesets_manager.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.DatasetsInfoDetails;
import crdc.airi.datesets_manager.dao.DatasetsInfoMapper;

@Service
public class DatasetsInfoService {
	@Autowired
	private DatasetsInfoMapper mapper;

	public int insert(String name, String scene_picture_link, String datasets_link, int nb_frames, int nb_instances,
			int nb_classes, String collection_start_time, String collection_recorder, int applicable_scene_id,
			int car_type_id, int city_id, String place_details, int weather_id, int time_interval_id, int scenario_id,
			int nb_lidars, int nb_cameras, int nb_radars, String labeling_specification_file_path,
			String datasets_raw_link, String datasets_labeled_jpg_link, String datasets_training_png_link,
			String datasets_lidar_pcd_link, String datasets_ins_txt_link, String datasets_chassis_txt_link,
			int nb_frames_extract_img, int nb_frames_extract_lidar, int nb_frames_extract_ins,
			int nb_frames_extract_chassis, int raw_data_type_id, int collection_period_seconds, int collection_img_fps,
			int collection_lidar_fps, String collection_information_file_path) throws Exception {
		return mapper.insert(name, scene_picture_link, datasets_link, nb_frames, nb_instances, nb_classes,
				Timestamp.valueOf(collection_start_time), collection_recorder, applicable_scene_id, car_type_id,
				city_id, place_details, weather_id, time_interval_id, scenario_id, nb_lidars, nb_cameras, nb_radars,
				labeling_specification_file_path, datasets_raw_link, datasets_labeled_jpg_link,
				datasets_training_png_link, datasets_lidar_pcd_link, datasets_ins_txt_link, datasets_chassis_txt_link,
				nb_frames_extract_img, nb_frames_extract_lidar, nb_frames_extract_ins, nb_frames_extract_chassis,
				raw_data_type_id, collection_period_seconds, collection_img_fps, collection_lidar_fps,
				collection_information_file_path);
	}

	public DatasetsInfoDetails selectByName(String name) throws Exception {
		return mapper.selectByName(name);
	}

	public DatasetsInfoDetails selectById(int id) throws Exception {
		return mapper.selectById(id);
	}

	public List<DatasetsInfoDetails> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}

	public int updateById(int id, String name, String scene_picture_link, String datasets_link, int nb_frames,
			int nb_instances, int nb_classes, String collection_start_time, String collection_recorder,
			int applicable_scene_id, int car_type_id, int city_id, String place_details, int weather_id,
			int time_interval_id, int scenario_id, int nb_lidars, int nb_cameras, int nb_radars,
			String labeling_specification_file_path, int examining_times, String datasets_raw_link,
			String datasets_labeled_jpg_link, String datasets_training_png_link, String datasets_lidar_pcd_link,
			String datasets_ins_txt_link, String datasets_chassis_txt_link, int nb_frames_extract_img,
			int nb_frames_extract_lidar, int nb_frames_extract_ins, int nb_frames_extract_chassis, int raw_data_type_id,
			int collection_period_seconds, int collection_img_fps, int collection_lidar_fps,
			String collection_information_file_path) throws Exception {
		return mapper.updateById(id, name, scene_picture_link, datasets_link, nb_frames, nb_instances, nb_classes,
				Timestamp.valueOf(collection_start_time), collection_recorder, applicable_scene_id, car_type_id,
				city_id, place_details, weather_id, time_interval_id, scenario_id, nb_lidars, nb_cameras, nb_radars,
				labeling_specification_file_path, examining_times, datasets_raw_link, datasets_labeled_jpg_link,
				datasets_training_png_link, datasets_lidar_pcd_link, datasets_ins_txt_link, datasets_chassis_txt_link,
				nb_frames_extract_img, nb_frames_extract_lidar, nb_frames_extract_ins, nb_frames_extract_chassis,
				raw_data_type_id, collection_period_seconds, collection_img_fps, collection_lidar_fps,
				collection_information_file_path);
	}
}
