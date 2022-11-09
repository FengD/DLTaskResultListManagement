package crdc.airi.datesets_manager.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SegmentationTask {
	private int id;
	private String name;
	private String authors;
	private String description;
	private String test_dataset_url;
	private String model_files_url;
	private String pico_results_url;
	private String modalities;
	private float miou;
	private float macc;
	private float fps;
	private String result_details_url;
	private String state_report_url;
	private int nb_object_class;
	private String create_time;
	private String update_time;
}
