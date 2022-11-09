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

import crdc.airi.datesets_manager.service.RadarInstanceService;
import crdc.airi.datesets_manager.utils.Response;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("RadarInstance")
public class RadarInstanceController {
	@Autowired
	private RadarInstanceService service;

	@GetMapping("")
	@ApiOperation(value = "RadarInstance", notes = "get all RadarInstance")
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

	@GetMapping("datasets/{id}")
	@ApiOperation(value = "RadarInstance", notes = "get RadarInstance by datasets_id")
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

	@PostMapping("")
	@ApiOperation(value = "RadarInstance", notes = "insert RadarInstance")
	public Object insert(String name, String description, int type_id, String calibration_file_path) {
		Response response;
		try {
			response = new Response(service.insert(name, description, type_id, calibration_file_path), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.FOUND);
		}
		return response.getResponse();
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "RadarInstance", notes = "delete RadarInstance by id")
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
	@ApiOperation(value = "RadarInstance", notes = "update RadarInstance by id")
	public Object update(@PathVariable int id, String name, String description, int radar_type_id,
			String radar_calibration_file_path) {
		Response response;
		try {
			response = new Response(
					service.updateById(id, name, description, radar_type_id, radar_calibration_file_path),
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

}
