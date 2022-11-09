package crdc.airi.datesets_manager.controller;

import java.util.ArrayList;
import java.util.List;

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

import crdc.airi.datesets_manager.bean.DatasetsInfoDetails;
import crdc.airi.datesets_manager.bean.DatasetsInfoDetailsOut;
import crdc.airi.datesets_manager.bean.RelationDatasetsTask;
import crdc.airi.datesets_manager.service.CameraInstanceService;
import crdc.airi.datesets_manager.service.DatasetsInfoService;
import crdc.airi.datesets_manager.service.InstanceListService;
import crdc.airi.datesets_manager.service.LidarInstanceService;
import crdc.airi.datesets_manager.service.RadarInstanceService;
import crdc.airi.datesets_manager.service.RelationDatasetsTaskService;
import crdc.airi.datesets_manager.utils.Response;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("DatasetsInfo")
public class DatasetsInfoController {
	@Autowired
	private DatasetsInfoService service;
	@Autowired
	private LidarInstanceService rdllService;
	@Autowired
	private CameraInstanceService rdclService;
	@Autowired
	private RadarInstanceService rdrlService;
	@Autowired
	private InstanceListService ilService;
	@Autowired
	private RelationDatasetsTaskService rdtService;

	@GetMapping("id/{id}")
	@ApiOperation(value = "DatasetsInfoDetails", notes = "get DatasetsInfo by id")
	public Object getById(@PathVariable int id) {
		Response response;
		try {
			DatasetsInfoDetailsOut datasets = DatasetsInfoDetailsOut.builder().datasets(service.selectById(id))
					.lidars(rdllService.selectByDatasetsId(id)).cameras(rdclService.selectByDatasetsId(id))
					.radars(rdrlService.selectByDatasetsId(id)).classes(ilService.selectByDatasetsId(id)).build();
			response = new Response(datasets, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

	private boolean checkValid(DatasetsInfoDetailsOut datasets, String applicable_scene, String car_type, String city,
			String weather, String time_interval, String scenario) {
		if (applicable_scene != null && !datasets.getDatasets().getApplicable_scene().equals(applicable_scene)) {
			return false;
		}
		if (city != null && !datasets.getDatasets().getCity().equals(city)) {
			return false;
		}
		if (car_type != null && !datasets.getDatasets().getCar_type().equals(city)) {
			return false;
		}
		if (weather != null && !datasets.getDatasets().getWeather().equals(weather)) {
			return false;
		}
		if (time_interval != null && !datasets.getDatasets().getTime_interval().equals(time_interval)) {
			return false;
		}
		if (scenario != null && !datasets.getDatasets().getScenario().equals(scenario)) {
			return false;
		}

		return true;
	}

	@GetMapping("")
	@ApiOperation(value = "DatasetsInfoDetails", notes = "get all DatasetsInfo")
	public Object getAll(@RequestParam(required = false) Integer task_id,
			@RequestParam(required = false) String applicable_scene, @RequestParam(required = false) String car_type,
			@RequestParam(required = false) String city, @RequestParam(required = false) String weather,
			@RequestParam(required = false) String time_interval, @RequestParam(required = false) String scenario) {
		Response response;
		try {
			List<DatasetsInfoDetailsOut> out = new ArrayList<DatasetsInfoDetailsOut>();
			if (task_id != null) {
				List<RelationDatasetsTask> datasets = rdtService.selectByTaskTypeId(task_id);
				for (RelationDatasetsTask d : datasets) {
					DatasetsInfoDetailsOut o = DatasetsInfoDetailsOut.builder()
							.datasets(service.selectById(d.getDatasets_id()))
							.lidars(rdllService.selectByDatasetsId(d.getDatasets_id()))
							.cameras(rdclService.selectByDatasetsId(d.getDatasets_id()))
							.radars(rdrlService.selectByDatasetsId(d.getDatasets_id()))
							.classes(ilService.selectByDatasetsId(d.getDatasets_id())).build();
					if (checkValid(o, applicable_scene, car_type, city, weather, time_interval, scenario)) {
						out.add(o);
					}

				}
			} else {
				List<DatasetsInfoDetails> ass = service.selectAll();
				for (DatasetsInfoDetails as : ass) {
					DatasetsInfoDetailsOut o = DatasetsInfoDetailsOut.builder().datasets(as)
							.lidars(rdllService.selectByDatasetsId(as.getId()))
							.cameras(rdclService.selectByDatasetsId(as.getId()))
							.radars(rdrlService.selectByDatasetsId(as.getId()))
							.classes(ilService.selectByDatasetsId(as.getId())).build();
					if (checkValid(o, applicable_scene, car_type, city, weather, time_interval, scenario)) {
						out.add(o);
					}
				}
			}
			response = new Response(out, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

	@PostMapping("")
	@ApiOperation(value = "DatasetsInfo", notes = "insert DatasetsInfo")
	public Object insert(String name, String scene_picture_link, String datasets_link, int nb_frames, int nb_instances,
			int nb_classes, String collection_start_time, String collection_recorder, int applicable_scene_id,
			int car_type_id, int city_id, String place_details, int weather_id, int time_interval_id, int scenario_id,
			int nb_lidars, int nb_cameras, int nb_radars, String labeling_specification_file_path,
			String datasets_raw_link, String datasets_labeled_jpg_link, String datasets_training_png_link,
			String datasets_lidar_pcd_link, String datasets_ins_txt_link, String datasets_chassis_txt_link,
			int nb_frames_extract_img, int nb_frames_extract_lidar, int nb_frames_extract_ins,
			int nb_frames_extract_chassis, int raw_data_type_id, int collection_period_seconds, int collection_img_fps,
			int collection_lidar_fps, String collection_information_file_path) {
		Response response;
		try {
			response = new Response(service.insert(name, scene_picture_link, datasets_link, nb_frames, nb_instances,
					nb_classes, collection_start_time, collection_recorder, applicable_scene_id, car_type_id, city_id,
					place_details, weather_id, time_interval_id, scenario_id, nb_lidars, nb_cameras, nb_radars,
					labeling_specification_file_path, datasets_raw_link, datasets_labeled_jpg_link,
					datasets_training_png_link, datasets_lidar_pcd_link, datasets_ins_txt_link,
					datasets_chassis_txt_link, nb_frames_extract_img, nb_frames_extract_lidar, nb_frames_extract_ins,
					nb_frames_extract_chassis, raw_data_type_id, collection_period_seconds, collection_img_fps,
					collection_lidar_fps, collection_information_file_path), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.FOUND);
		}
		return response.getResponse();
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "DatasetsInfo", notes = "delete DatasetsInfo by id")
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
	@ApiOperation(value = "DatasetsInfo", notes = "update DatasetsInfo by id")
	public Object update(@PathVariable int id, String name, String scene_picture_link, String datasets_link,
			int nb_frames, int nb_instances, int nb_classes, String collection_start_time, String collection_recorder,
			int applicable_scene_id, int car_type_id, int city_id, String place_details, int weather_id,
			int time_interval_id, int scenario_id, int nb_lidars, int nb_cameras, int nb_radars,
			String labeling_specification_file_path, int examining_times, String datasets_raw_link,
			String datasets_labeled_jpg_link, String datasets_training_png_link, String datasets_lidar_pcd_link,
			String datasets_ins_txt_link, String datasets_chassis_txt_link, int nb_frames_extract_img,
			int nb_frames_extract_lidar, int nb_frames_extract_ins, int nb_frames_extract_chassis, int raw_data_type_id,
			int collection_period_seconds, int collection_img_fps, int collection_lidar_fps,
			String collection_information_file_path) {
		Response response;
		try {
			response = new Response(service.updateById(id, name, scene_picture_link, datasets_link, nb_frames,
					nb_instances, nb_classes, collection_start_time, collection_recorder, applicable_scene_id,
					car_type_id, city_id, place_details, weather_id, time_interval_id, scenario_id, nb_lidars,
					nb_cameras, nb_radars, labeling_specification_file_path, examining_times, datasets_raw_link,
					datasets_labeled_jpg_link, datasets_training_png_link, datasets_lidar_pcd_link,
					datasets_ins_txt_link, datasets_chassis_txt_link, nb_frames_extract_img, nb_frames_extract_lidar,
					nb_frames_extract_ins, nb_frames_extract_chassis, raw_data_type_id, collection_period_seconds,
					collection_img_fps, collection_lidar_fps, collection_information_file_path), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(null, HttpStatus.NOT_FOUND);
		}
		return response.getResponse();
	}

}
