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
			String result_details_url, String state_report_url, int nb_object_class) throws Exception {
		return mapper.insert(name, authors, description, test_dataset_url, model_files_url, pico_results_url,
				modalities, amota, amotp, motar, mota, motp, result_details_url, state_report_url, nb_object_class);
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

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
}
