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

import crdc.airi.datesets_manager.service.CameraInstanceService;
import crdc.airi.datesets_manager.utils.Response;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("CameraInstance")
public class CameraInstanceController {
	@Autowired
	private CameraInstanceService service;

	@GetMapping("")
	@ApiOperation(value = "CameraInstance", notes = "get all CameraInstance")
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
	@ApiOperation(value = "CameraInstance", notes = "insert CameraInstance")
	public Object insert(String name, String description, int type_id, String undistortion_file_path,
			String calibration_file_path) {
		Response response;
		try {
			response = new Response(
					service.insert(name, description, type_id, undistortion_file_path, calibration_file_path),
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.FOUND);
		}
		return response.getResponse();
	}

	@GetMapping("datasets/{id}")
	@ApiOperation(value = "CameraInstance", notes = "get CameraInstance by datasets_id")
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
	@ApiOperation(value = "CameraInstance", notes = "delete CameraInstance by id")
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
	@ApiOperation(value = "CameraInstance", notes = "update CameraInstance by id")
	public Object update(@PathVariable int id, String name, String description, int camera_type_id,
			String camera_undistortion_file_path, String camera_calibration_file_path) {
		Response response;
		try {
			response = new Response(service.updateById(id, name, description, camera_type_id,
					camera_undistortion_file_path, camera_calibration_file_path), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

}
