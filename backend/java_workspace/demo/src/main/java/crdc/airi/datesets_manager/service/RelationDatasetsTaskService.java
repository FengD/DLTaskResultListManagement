package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.RelationDatasetsTask;
import crdc.airi.datesets_manager.dao.RelationDatasetsTaskMapper;

@Service
public class RelationDatasetsTaskService {
	@Autowired
	private RelationDatasetsTaskMapper mapper;

	public int insert(int datasets_id, int task_type_id) throws Exception {
		return mapper.insert(datasets_id, task_type_id);
	}

	public List<RelationDatasetsTask> selectByDatasetsId(int id) throws Exception {
		return mapper.selectByDatasetsId(id);
	}

	public List<RelationDatasetsTask> selectByTaskTypeId(int id) throws Exception {
		return mapper.selectByTaskTypeId(id);
	}

	public List<RelationDatasetsTask> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
}
