package crdc.airi.datesets_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crdc.airi.datesets_manager.service.LidarInstanceService;
import crdc.airi.datesets_manager.utils.Response;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("LidarInstance")
public class LidarInstanceController {
	@Autowired
	private LidarInstanceService service;

	@GetMapping("")
	@ApiOperation(value = "LidarInstance", notes = "get all LidarInstance")
	public Object getAll() {
		Response response;
		try {
			response = new Response(service.selectAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

	@PostMapping("")
	@ApiOperation(value = "LidarInstance", notes = "insert LidarInstance")
	public Object insert(String name, String description, int type_id, String correction_file_path,
			String calibration_file_path) {
		Response response;
		try {
			response = new Response(
					service.insert(name, description, type_id, correction_file_path, calibration_file_path),
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.FOUND);
		}
		return response.getResponse();
	}

	@GetMapping("datasets/{id}")
	@ApiOperation(value = "LidarInstance", notes = "get LidarInstance by datasets_id")
	public Object getByDatasetsId(@PathVariable int id) {
		Response response;
		try {
			response = new Response(service.selectByDatasetsId(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "LidarInstance", notes = "delete LidarInstance by id")
	public Object delete(@PathVariable int id) {
		Response response;
		try {
			response = new Response(service.deleteById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

	@PutMapping("{id}")
	@ApiOperation(value = "LidarInstance", notes = "update LidarInstance by id")
	public Object update(@PathVariable int id, String name, String description, int lidar_type_id,
			String lidar_correction_file_path, String lidar_calibration_file_path) {
		Response response;
		try {
			response = new Response(service.updateById(id, name, description, lidar_type_id, lidar_correction_file_path,
					lidar_calibration_file_path), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

}
