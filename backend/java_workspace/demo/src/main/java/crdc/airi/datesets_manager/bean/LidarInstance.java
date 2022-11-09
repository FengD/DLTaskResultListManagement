package crdc.airi.datesets_manager.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LidarInstance {
	private int id;
	private String name;
	private String description;
	private String type;
	private String correction_file_path;
	private String calibration_file_path;
	private String create_time;
	private String update_time;
}
