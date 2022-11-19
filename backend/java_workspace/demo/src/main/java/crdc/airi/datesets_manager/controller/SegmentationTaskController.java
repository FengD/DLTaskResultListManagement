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

import crdc.airi.datesets_manager.service.SegmentationTaskService;
import crdc.airi.datesets_manager.utils.Response;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("SegmentationTask")
public class SegmentationTaskController {
	@Autowired
	private SegmentationTaskService service;

	@GetMapping("id/{id}")
	@ApiOperation(value = "SegmentationTask", notes = "get SegmentationTask by id")
	public Object getById(@PathVariable int id) {
		Response response;
		try {
			response = new Response(service.selectById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

	@GetMapping("name/{name}")
	@ApiOperation(value = "SegmentationTask", notes = "get SegmentationTask by name")
	public Object getByName(@PathVariable String name) {
		Response response;
		try {
			response = new Response(service.selectByName(name), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

	@GetMapping("")
	@ApiOperation(value = "SegmentationTask", notes = "get all SegmentationTask")
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
	@ApiOperation(value = "SegmentationTask", notes = "insert SegmentationTask")
	public Object insert(String name, String authors, String description, String test_dataset_url,
			String model_files_url, String pico_results_url, String modalities, float miou, float macc, float mboundary,
			float fps, String result_details_url, String state_report_url, int nb_object_class) {
		Response response;
		try {
			response = new Response(service.insert(name, authors, description, test_dataset_url, model_files_url,
					pico_results_url, modalities, miou, macc, mboundary, fps, result_details_url, state_report_url,
					nb_object_class), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.FOUND);
		}
		return response.getResponse();
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "SegmentationTask", notes = "delete SegmentationTask by id")
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
	@ApiOperation(value = "SegmentationTask", notes = "update SegmentationTask description by id")
	public Object update(@PathVariable int id, String description) {
		Response response;
		try {
			response = new Response(service.updateById(id, description), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}
}
