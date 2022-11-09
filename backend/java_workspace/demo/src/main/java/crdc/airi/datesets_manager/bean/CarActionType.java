package crdc.airi.datesets_manager.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarActionType {
	private int id;
	private String name;
	private String description;
	private String create_time;
	private String update_time;
}
