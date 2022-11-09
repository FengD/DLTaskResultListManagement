package crdc.airi.datesets_manager.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstanceList {
	private int id;
	private String name;
	private String description;
	private int number;
	private String instance_type;
	private String create_time;
	private String update_time;
}
