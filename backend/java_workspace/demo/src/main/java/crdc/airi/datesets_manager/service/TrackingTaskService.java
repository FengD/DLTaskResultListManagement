package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.TrackingTask;
import crdc.airi.datesets_manager.dao.TrackingTaskMapper;

@Service
public class TrackingTaskService {
	@Autowired
	private TrackingTaskMapper mapper;

	public int insert(String name, String authors, String description, String test_dataset_url, String model_files_url,
			String pico_results_url, String modalities, float amota, float amotp, float motar, float mota, float motp,
			String result_details_url, String state_report_url, int nb_object_class, String platform,
			float inference_time_second, float head_angle_avg_error, float long_v_avg_error, float lat_v_avg_error)
			throws Exception {
		return mapper.insert(name, authors, description, test_dataset_url, model_files_url, pico_results_url,
				modalities, amota, amotp, motar, mota, motp, result_details_url, state_report_url, nb_object_class,
				platform, inference_time_second, head_angle_avg_error, long_v_avg_error, lat_v_avg_error);
	}

	public List<TrackingTask> selectByName(String name) throws Exception {
		return mapper.selectByName(name);
	}

	public TrackingTask selectById(int id) throws Exception {
		return mapper.selectById(id);
	}

	public List<TrackingTask> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int updateById(int id, String description) throws Exception {
		return mapper.updateById(id, description);
	}

	public int updateHeadAngleById(int id, float inference_time_second) throws Exception {
		return mapper.updateHeadAngleById(id, inference_time_second);
	}

	public int updateVXById(int id, float long_v_avg_error) throws Exception {
		return mapper.updateVXById(id, long_v_avg_error);
	}

	public int updateVYById(int id, float lat_v_avg_error) throws Exception {
		return mapper.updateVYById(id, lat_v_avg_error);
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
}
