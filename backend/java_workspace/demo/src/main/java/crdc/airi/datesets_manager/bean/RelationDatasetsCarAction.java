package crdc.airi.datesets_manager.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RelationDatasetsCarAction {
	private int id;
	private int datasets_id;
	private int car_action_type_id;
	private String create_time;
	private String update_time;
}