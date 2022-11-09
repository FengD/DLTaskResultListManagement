package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.InstanceList;
import crdc.airi.datesets_manager.dao.InstanceListMapper;

@Service
public class InstanceListService {
	@Autowired
	private InstanceListMapper mapper;

	public int insert(String name, String description, int number, int instance_type_id) throws Exception {
		int ret = mapper.insert(name, description, number, instance_type_id);
		if (ret == 1) {
			return mapper.selectLastId();
		}
		return ret;
	}

	public List<InstanceList> selectByDatasetsId(int id) throws Exception {
		return mapper.selectByDatasetsId(id);
	}

	public List<InstanceList> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int updateById(int id, String name, String description, int number, int instance_type_id) throws Exception {
		return mapper.updateById(id, name, description, number, instance_type_id);
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
}
