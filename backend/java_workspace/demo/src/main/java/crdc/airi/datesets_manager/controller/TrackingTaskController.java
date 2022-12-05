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

import crdc.airi.datesets_manager.service.TrackingTaskService;
import crdc.airi.datesets_manager.utils.Response;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("TrackingTask")
public class TrackingTaskController {
	@Autowired
	private TrackingTaskService service;

	@GetMapping("id/{id}")
	@ApiOperation(value = "TrackingTask", notes = "get TrackingTask by id")
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
	@ApiOperation(value = "TrackingTask", notes = "get TrackingTask by name")
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
	@ApiOperation(value = "TrackingTask", notes = "get all TrackingTask")
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
	@ApiOperation(value = "TrackingTask", notes = "insert TrackingTask")
	public Object insert(@RequestParam String name, @RequestParam String authors, @RequestParam String description,
			@RequestParam String test_dataset_url, @RequestParam String model_files_url,
			@RequestParam String pico_results_url, @RequestParam String modalities,
			@RequestParam(required = false, defaultValue = "0") float amota,
			@RequestParam(required = false, defaultValue = "0") float amotp,
			@RequestParam(required = false, defaultValue = "0") float motar, @RequestParam float mota,
			@RequestParam float motp, @RequestParam(required = false, defaultValue = "") String result_details_url,
			@RequestParam String state_report_url, @RequestParam int nb_object_class,
			@RequestParam(required = false, defaultValue = "") String platform,
			@RequestParam(required = false, defaultValue = "0") float inference_time_second,
			@RequestParam(required = false, defaultValue = "0") float head_angle_avg_error,
			@RequestParam(required = false, defaultValue = "0") float long_v_avg_error,
			@RequestParam(required = false, defaultValue = "0") float lat_v_avg_error) {
		Response response;
		try {
			response = new Response(service.insert(name, authors, description, test_dataset_url, model_files_url,
					pico_results_url, modalities, amota, amotp, motar, mota, motp, result_details_url, state_report_url,
					nb_object_class, platform, inference_time_second, head_angle_avg_error, long_v_avg_error,
					lat_v_avg_error), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.FOUND);
		}
		return response.getResponse();
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "TrackingTask", notes = "delete TrackingTask by id")
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
	@ApiOperation(value = "TrackingTask", notes = "update TrackingTask description by id")
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

	@PutMapping("head_angle_avg_error/{id}")
	@ApiOperation(value = "TrackingTask", notes = "update Head Angle Average Error description by id")
	public Object updateHeadAngleById(@PathVariable int id, float head_angle_avg_error) {
		Response response;
		try {
			response = new Response(service.updateHeadAngleById(id, head_angle_avg_error), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

	@PutMapping("long_v_avg_error/{id}")
	@ApiOperation(value = "TrackingTask", notes = "update Long V Average Error description by id")
	public Object updateVXById(@PathVariable int id, float long_v_avg_error) {
		Response response;
		try {
			response = new Response(service.updateVXById(id, long_v_avg_error), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

	@PutMapping("lat_v_avg_error/{id}")
	@ApiOperation(value = "TrackingTask", notes = "update Lat V Average Error  description by id")
	public Object updateVYById(@PathVariable int id, float lat_v_avg_error) {
		Response response;
		try {
			response = new Response(service.updateVYById(id, lat_v_avg_error), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}
}
