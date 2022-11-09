package crdc.airi.datesets_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crdc.airi.datesets_manager.bean.CameraInstance;
import crdc.airi.datesets_manager.dao.CameraInstanceMapper;

@Service
public class CameraInstanceService {
	@Autowired
	private CameraInstanceMapper mapper;

	public int insert(String name, String description, int camera_type_id, String camera_undistortion_file_path,
			String camera_calibration_file_path) throws Exception {
		int ret = mapper.insert(name, description, camera_type_id, camera_undistortion_file_path,
				camera_calibration_file_path);
		if (ret == 1) {
			return mapper.selectLastId();
		}
		return ret;
	}

	public List<CameraInstance> selectByDatasetsId(int id) throws Exception {
		return mapper.selectByDatasetsId(id);
	}

	public List<CameraInstance> selectByRawDatasetsId(int id) throws Exception {
		return mapper.selectByRawDatasetsId(id);
	}

	public List<CameraInstance> selectAll() throws Exception {
		return mapper.selectAll();
	}

	public int deleteById(int id) throws Exception {
		return mapper.deleteById(id);
	}

	public int updateById(int id, String name, String description, int camera_type_id,
			String camera_undistortion_file_path, String camera_calibration_file_path) throws Exception {
		return mapper.updateById(id, name, description, camera_type_id, camera_undistortion_file_path,
				camera_calibration_file_path);
	}
}
