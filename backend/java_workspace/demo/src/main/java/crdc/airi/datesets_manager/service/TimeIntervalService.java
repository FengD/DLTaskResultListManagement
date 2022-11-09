package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.TimeInterval;
import crdc.airi.datesets_manager.dao.TimeIntervalMapper;

@Service
public class TimeIntervalService {
	@Autowired
	private TimeIntervalMapper mapper;

	public int insert(String name, String description) throws Exception {
		return mapper.insert(name, description);
	}

	public TimeInterval selectByName(String name) throws Exception {
		return mapper.selectByName(name);
	}

	public TimeInterval selectById(int id) throws Exception {
		return mapper.selectById(id);
	}

	public List<TimeInterval> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
	
	public int updateById(int id, String name, String description) throws Exception {
		return mapper.updateById(id, name, description);
	}
}
