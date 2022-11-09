package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.RadarInstance;
import crdc.airi.datesets_manager.dao.RadarInstanceMapper;

@Service
public class RadarInstanceService {
	@Autowired
	private RadarInstanceMapper mapper;

	public int insert(String name, String description, int radar_type_id, String radar_calibration_file_path)
			throws Exception {
		int ret = mapper.insert(name, description, radar_type_id, radar_calibration_file_path);
		if (ret == 1) {
			return mapper.selectLastId();
		}
		return ret;
	}

	public List<RadarInstance> selectByDatasetsId(int id) throws Exception {
		return mapper.selectByDatasetsId(id);
	}

	public List<RadarInstance> selectByRawDatasetsId(int id) throws Exception {
		return mapper.selectByRawDatasetsId(id);
	}

	public List<RadarInstance> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}

	public int updateById(int id, String name, String description, int radar_type_id,
			String radar_calibration_file_path) throws Exception {
		return mapper.updateById(id, name, description, radar_type_id, radar_calibration_file_path);
	}
}
