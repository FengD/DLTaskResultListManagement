package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.LidarInstance;
import crdc.airi.datesets_manager.dao.LidarInstanceMapper;

@Service
public class LidarInstanceService {
	@Autowired
	private LidarInstanceMapper mapper;

	public Integer insert(String name, String description, int lidar_type_id, String lidar_correction_file_path,
			String lidar_calibration_file_path) throws Exception {
		int ret = mapper.insert(name, description, lidar_type_id, lidar_correction_file_path,
				lidar_calibration_file_path);
		if (ret == 1) {
			return mapper.selectLastId();
		}
		return ret;
	}

	public List<LidarInstance> selectByDatasetsId(int id) throws Exception {
		return mapper.selectByDatasetsId(id);
	}

	public List<LidarInstance> selectByRawDatasetsId(int id) throws Exception {
		return mapper.selectByRawDatasetsId(id);
	}

	public List<LidarInstance> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int updateById(int id, String name, String description, int lidar_type_id, String lidar_correction_file_path,
			String lidar_calibration_file_path) throws Exception {
		return mapper.updateById(id, name, description, lidar_type_id, lidar_correction_file_path,
				lidar_calibration_file_path);
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}
}
