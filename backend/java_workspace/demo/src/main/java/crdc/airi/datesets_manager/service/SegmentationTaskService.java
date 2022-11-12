package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.SegmentationTask;
import crdc.airi.datesets_manager.dao.SegmentationTaskMapper;

@Service
public class SegmentationTaskService {
	@Autowired
	private SegmentationTaskMapper mapper;

	public int insert(String name, String authors, String description, String test_dataset_url, String model_files_url,
			String pico_results_url, String modalities, float miou, float macc, float mboundary, float fps,
			String result_details_url, String state_report_url, int nb_object_class) throws Exception {
		return mapper.insert(name, authors, description, test_dataset_url, model_files_url, pico_results_url,
				modalities, miou, macc, mboundary, fps, result_details_url, state_report_url, nb_object_class);
	}

	public List<SegmentationTask> selectByName(String name) throws Exception {
		return mapper.selectByName(name);
	}

	public SegmentationTask selectById(int id) throws Exception {
		return mapper.selectById(id);
	}

	public List<SegmentationTask> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
}
