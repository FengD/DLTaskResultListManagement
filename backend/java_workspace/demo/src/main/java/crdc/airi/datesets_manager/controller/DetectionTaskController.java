package crdc.airi.datesets_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crdc.airi.datesets_manager.service.DetectionTaskService;
import crdc.airi.datesets_manager.utils.Response;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("DetectionTask")
public class DetectionTaskController {
	@Autowired
	private DetectionTaskService service;

	@GetMapping("id/{id}")
	@ApiOperation(value = "DetectionTask", notes = "get DetectionTask by id")
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
	@ApiOperation(value = "DetectionTask", notes = "get DetectionTask by name")
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
	@ApiOperation(value = "DetectionTask", notes = "get all DetectionTask")
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
	@ApiOperation(value = "DetectionTask", notes = "insert DetectionTask")
	public Object insert(@RequestParam String name, @RequestParam String authors, @RequestParam String description,
			@RequestParam String test_dataset_url, @RequestParam String model_files_url,
			@RequestParam String pico_results_url, @RequestParam String modalities, @RequestParam float map,
			@RequestParam(required = false, defaultValue = "0") float mate,
			@RequestParam(required = false, defaultValue = "0") float mase,
			@RequestParam(required = false, defaultValue = "0") float maoe,
			@RequestParam(required = false, defaultValue = "0") float mave,
			@RequestParam(required = false, defaultValue = "0") float maae,
			@RequestParam(required = false, defaultValue = "0") float nds,
			@RequestParam(required = false, defaultValue = "0") float fps,
			@RequestParam(required = false, defaultValue = "") String result_details_url,
			@RequestParam String state_report_url, @RequestParam int nb_object_class,
			@RequestParam(required = false, defaultValue = "") String platform,
			@RequestParam(required = false, defaultValue = "0") float inference_time_second,
			@RequestParam(required = false, defaultValue = "0") float precision_box,
			@RequestParam(required = false, defaultValue = "0") float recall_box,
			@RequestParam(required = false, defaultValue = "0") float offset_pixel,
			@RequestParam(required = false, defaultValue = "0") float mse,
			@RequestParam(required = false, defaultValue = "0") float precision_point,
			@RequestParam(required = false, defaultValue = "0") float recall_point) {
		Response response;
		try {
			response = new Response(service.insert(name, authors, description, test_dataset_url, model_files_url,
					pico_results_url, modalities, map, mate, mase, maoe, mave, maae, nds, fps, result_details_url,
					state_report_url, nb_object_class, platform, inference_time_second, precision_box, recall_box,
					offset_pixel, mse, precision_point, recall_point), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.FOUND);
		}
		return response.getResponse();
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "DetectionTask", notes = "delete DetectionTask by id")
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
	@ApiOperation(value = "DetectionTask", notes = "update DetectionTask description by id")
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

	@PutMapping("fps/{id}")
	@ApiOperation(value = "DetectionTask", notes = "update DetectionTask fps by id")
	public Object updateFps(@PathVariable int id, float fps) {
		Response response;
		try {
			response = new Response(service.updateFpsById(id, fps), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}
}
