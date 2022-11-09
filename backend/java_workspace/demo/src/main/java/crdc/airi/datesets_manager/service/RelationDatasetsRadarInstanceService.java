package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.RelationDatasetsRadarInstance;
import crdc.airi.datesets_manager.dao.RelationDatasetsRadarInstanceMapper;

@Service
public class RelationDatasetsRadarInstanceService {
	@Autowired
	private RelationDatasetsRadarInstanceMapper mapper;

	public int insert(int datasets_id, int radar_type_id) throws Exception {
		return mapper.insert(datasets_id, radar_type_id);
	}

	public List<RelationDatasetsRadarInstance> selectByDatasetsId(int id) throws Exception {
		return mapper.selectByDatasetsId(id);
	}

	public List<RelationDatasetsRadarInstance> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
}
