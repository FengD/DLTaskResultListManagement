package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.DetectionTask;
import crdc.airi.datesets_manager.dao.DetecitonTaskMapper;

@Service
public class DetectionTaskService {
	@Autowired
	private DetecitonTaskMapper mapper;

	public int insert(String name, String authors, String description, String test_dataset_url, String model_files_url,
			String pico_results_url, String modalities, float map, float mate, float mase, float maoe, float mave,
			float maae, float nds, float fps, String result_details_url, String state_report_url, int nb_object_class)
			throws Exception {
		return mapper.insert(name, authors, description, test_dataset_url, model_files_url, pico_results_url,
				modalities, map, mate, mase, maoe, mave, maae, nds, fps, result_details_url, state_report_url,
				nb_object_class);
	}

	public List<DetectionTask> selectByName(String name) throws Exception {
		return mapper.selectByName(name);
	}

	public DetectionTask selectById(int id) throws Exception {
		return mapper.selectById(id);
	}

	public List<DetectionTask> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int updateById(int id, String description) throws Exception {
		return mapper.updateById(id, description);
	}
	
	public int updateFpsById(int id, float fps) throws Exception {
		return mapper.updateFpsById(id, fps);
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
}
