package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.RelationDatasetsCameraInstance;
import crdc.airi.datesets_manager.dao.RelationDatasetsCameraInstanceMapper;

@Service
public class RelationDatasetsCameraInstanceService {
	@Autowired
	private RelationDatasetsCameraInstanceMapper mapper;

	public int insert(int datasets_id, int camera_type_id) throws Exception {
		return mapper.insert(datasets_id, camera_type_id);
	}

	public List<RelationDatasetsCameraInstance> selectByDatasetsId(int id) throws Exception {
		return mapper.selectByDatasetsId(id);
	}

	public List<RelationDatasetsCameraInstance> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
}
