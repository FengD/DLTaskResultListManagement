package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.RelationDatasetsCarAction;
import crdc.airi.datesets_manager.dao.RelationDatasetsCarActionMapper;

@Service
public class RelationDatasetsCarActionService {
	@Autowired
	private RelationDatasetsCarActionMapper mapper;

	public int insert(int datasets_id, int car_action_type_id) throws Exception {
		return mapper.insert(datasets_id, car_action_type_id);
	}

	public List<RelationDatasetsCarAction> selectByDatasetsId(int id) throws Exception {
		return mapper.selectByDatasetsId(id);
	}
	
	public List<RelationDatasetsCarAction> selectByCarActionTypeId(int id) throws Exception {
		return mapper.selectByCarActionTypeId(id);
	}

	public List<RelationDatasetsCarAction> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
}
