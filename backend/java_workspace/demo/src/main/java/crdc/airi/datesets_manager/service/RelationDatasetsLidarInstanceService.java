package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.RelationDatasetsLidarInstance;
import crdc.airi.datesets_manager.dao.RelationDatasetsLidarInstanceMapper;

@Service
public class RelationDatasetsLidarInstanceService {
	@Autowired
	private RelationDatasetsLidarInstanceMapper mapper;

	public int insert(int datasets_id, int lidar_type_id) throws Exception {
		return mapper.insert(datasets_id, lidar_type_id);
	}

	public List<RelationDatasetsLidarInstance> selectByDatasetsId(int id) throws Exception {
		return mapper.selectByDatasetsId(id);
	}

	public List<RelationDatasetsLidarInstance> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
}
