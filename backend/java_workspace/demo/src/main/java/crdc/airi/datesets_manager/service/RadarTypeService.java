package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.RadarType;
import crdc.airi.datesets_manager.dao.RadarTypeMapper;

@Service
public class RadarTypeService {
	@Autowired
	private RadarTypeMapper mapper;

	public int insert(String name, String description) throws Exception {
		return mapper.insert(name, description);
	}

	public RadarType selectByName(String name) throws Exception {
		return mapper.selectByName(name);
	}

	public RadarType selectById(int id) throws Exception {
		return mapper.selectById(id);
	}

	public List<RadarType> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
	
	public int updateById(int id, String name, String description) throws Exception {
		return mapper.updateById(id, name, description);
	}
}
