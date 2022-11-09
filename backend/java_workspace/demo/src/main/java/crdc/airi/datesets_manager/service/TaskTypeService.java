package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.TaskType;
import crdc.airi.datesets_manager.dao.TaskTypeMapper;

@Service
public class TaskTypeService {
	@Autowired
	private TaskTypeMapper mapper;

	public int insert(String name, String description) throws Exception {
		return mapper.insert(name, description);
	}

	public TaskType selectByName(String name) throws Exception {
		return mapper.selectByName(name);
	}

	public TaskType selectById(int id) throws Exception {
		return mapper.selectById(id);
	}

	public List<TaskType> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
	
	public int updateById(int id, String name, String description) throws Exception {
		return mapper.updateById(id, name, description);
	}
}