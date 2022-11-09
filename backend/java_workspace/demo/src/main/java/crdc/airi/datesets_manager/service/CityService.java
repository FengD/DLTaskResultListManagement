package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.City;
import crdc.airi.datesets_manager.dao.CityMapper;

@Service
public class CityService {
	@Autowired
	private CityMapper mapper;

	public int insert(String name, String description) throws Exception {
		return mapper.insert(name, description);
	}

	public City selectByName(String name) throws Exception {
		return mapper.selectByName(name);
	}

	public City selectById(int id) throws Exception {
		return mapper.selectById(id);
	}

	public List<City> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
	
	public int updateById(int id, String name, String description) throws Exception {
		return mapper.updateById(id, name, description);
	}
}
