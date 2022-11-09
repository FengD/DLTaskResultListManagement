package crdc.airi.datesets_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crdc.airi.datesets_manager.service.RelationDatasetsCarActionService;
import crdc.airi.datesets_manager.utils.Response;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("RelationDatasetsCarAction")
public class RelationDatasetsCarActionController {
	@Autowired
	private RelationDatasetsCarActionService service;

	@GetMapping("datasets/{id}")
	@ApiOperation(value = "RelationDatasetsCarAction", notes = "get RelationDatasetsCarAction by datasets_id")
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
	
	@GetMapping("carActionType/{id}")
	@ApiOperation(value = "RelationDatasetsCarAction", notes = "get RelationDatasetsCarAction by car_action_type_id")
	public Object getByCarActionId(@PathVariable int id) {
		Response response;
		try {
			response = new Response(service.selectByCarActionTypeId(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

	@GetMapping("")
	@ApiOperation(value = "RelationDatasetsCarAction", notes = "get all RelationDatasetsCarAction")
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
	@ApiOperation(value = "RelationDatasetsCarAction", notes = "insert RelationDatasetsCarAction")
	public Object insert(int datasets_id, int car_action_type_id) {
		Response response;
		try {
			response = new Response(service.insert(datasets_id, car_action_type_id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.FOUND);
		}
		return response.getResponse();
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "RelationDatasetsCarAction", notes = "delete RelationDatasetsCarAction by id")
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
