package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.RelationDatasetsInstanceList;
import crdc.airi.datesets_manager.dao.RelationDatasetsInstanceListMapper;

@Service
public class RelationDatasetsInstanceListService {
	@Autowired
	private RelationDatasetsInstanceListMapper mapper;

	public int insert(int datasets_id, int instance_list_id) throws Exception {
		return mapper.insert(datasets_id, instance_list_id);
	}

	public List<RelationDatasetsInstanceList> selectByDatasetsId(int id) throws Exception {
		return mapper.selectByDatasetsId(id);
	}

	public List<RelationDatasetsInstanceList> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
}
