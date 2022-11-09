package crdc.airi.datesets_manager.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DatasetsInfo {
	private int id;
	private String name;
	private String scene_picture_link;
	private String datasets_link;
	private int nb_frames;
	private int nb_instances;
	private int nb_classes;
	private String collection_start_time;
	private String collection_recorder;
	private int applicable_scene_id;
	private int car_type_id;
	private int city_id;
	private String place_details;
	private int weather_id;
	private int time_interval_id;
	private int scenario_id;
	private int nb_lidars;
	private int nb_cameras;
	private int nb_radars;
	private String create_time;
	private String update_time;
	private String labeling_specification_file_path;
	private int examining_times;
//	raw info
	private String datasets_raw_link;
	private String datasets_labeled_jpg_link;
	private String datasets_training_png_link;
	private String datasets_lidar_pcd_link;
	private String datasets_ins_txt_link;
	private String datasets_chassis_txt_link;
	private int nb_frames_extract_img;
	private int nb_frames_extract_lidar;
	private int nb_frames_extract_ins;
	private int nb_frames_extract_chassis;
	private int raw_data_type_id;
	private int collection_period_seconds;
	private int collection_img_fps;
	private int collection_lidar_fps;
	private String collection_information_file_path;
//	raw info end
}
