package crdc.airi.datesets_manager.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RelationDatasetsRadarInstance {
	private int id;
	private int datasets_id;
	private int radar_instance_id;
	private String create_time;
	private String update_time;
}