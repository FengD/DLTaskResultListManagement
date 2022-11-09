package crdc.airi.datesets_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crdc.airi.datesets_manager.service.RelationDatasetsCameraInstanceService;
import crdc.airi.datesets_manager.utils.Response;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("RelationDatasetsCameraInstance")
public class RelationDatasetsCameraInstanceController {
	@Autowired
	private RelationDatasetsCameraInstanceService service;

	@GetMapping("datasets/{id}")
	@ApiOperation(value = "RelationDatasetsCameraInstance", notes = "get RelationDatasetsCameraInstance by datasets_id")
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

	@GetMapping("")
	@ApiOperation(value = "RelationDatasetsCameraInstance", notes = "get all RelationDatasetsCameraInstance")
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
	@ApiOperation(value = "RelationDatasetsCameraInstance", notes = "insert RelationDatasetsCameraInstance")
	public Object insert(int datasets_id, int camera_instance_id) {
		Response response;
		try {
			response = new Response(service.insert(datasets_id, camera_instance_id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.FOUND);
		}
		return response.getResponse();
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "RelationDatasetsCameraInstance", notes = "delete RelationDatasetsCameraInstance by id")
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

}
