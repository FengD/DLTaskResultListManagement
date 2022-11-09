package crdc.airi.datesets_manager.bean;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DatasetsInfoDetailsOut {
	private DatasetsInfoDetails datasets;
	private List<LidarInstance> lidars;
	private List<CameraInstance> cameras;
	private List<RadarInstance> radars;
	private List<InstanceList> classes;
}
