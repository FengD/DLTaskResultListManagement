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

import crdc.airi.datesets_manager.service.InstanceListService;
import crdc.airi.datesets_manager.utils.Response;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("InstanceList")
public class InstanceListController {
	@Autowired
	private InstanceListService service;

	@GetMapping("")
	@ApiOperation(value = "InstanceList", notes = "get all InstanceList")
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
	@ApiOperation(value = "InstanceList", notes = "insert InstanceList")
	public Object insert(String name, String description, int number, int instance_type_id) {
		Response response;
		try {
			response = new Response(service.insert(name, description, number, instance_type_id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.FOUND);
		}
		return response.getResponse();
	}

	@GetMapping("datasets/{id}")
	@ApiOperation(value = "InstanceList", notes = "get InstanceList by datasets_id")
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
	@ApiOperation(value = "InstanceList", notes = "delete InstanceList by id")
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
	@ApiOperation(value = "InstanceList", notes = "update InstanceList by id")
	public Object update(@PathVariable int id, String name, String description, int number, int instance_type_id) {
		Response response;
		try {
			response = new Response(service.updateById(id, name, description, number, instance_type_id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

}
