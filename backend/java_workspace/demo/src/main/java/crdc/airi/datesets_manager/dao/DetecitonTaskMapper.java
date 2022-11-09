package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import crdc.airi.datesets_manager.bean.DetectionTask;

@Mapper
public interface DetecitonTaskMapper {

	@Insert("INSERT INTO crdc_airi_detection_task(name,authors,description,test_dataset_url,"
			+ "model_files_url,pico_results_url,modalities," + "map,mate,mase,maoe,mave,maae,nds,fps,"
			+ "result_details_url,state_report_url,nb_object_class) VALUES (" + "#{name,jdbcType=VARCHAR}, "
			+ "#{authors,jdbcType=VARCHAR}," + "#{description,jdbcType=VARCHAR},"
			+ "#{test_dataset_url,jdbcType=VARCHAR}," + "#{model_files_url,jdbcType=VARCHAR},"
			+ "#{pico_results_url,jdbcType=VARCHAR}," + "#{modalities,jdbcType=VARCHAR}," + "#{map,jdbcType=FLOAT},"
			+ "#{mate,jdbcType=FLOAT}," + "#{mase,jdbcType=FLOAT}," + "#{maoe,jdbcType=FLOAT},"
			+ "#{mave,jdbcType=FLOAT}," + "#{maae,jdbcType=FLOAT}," + "#{nds,jdbcType=FLOAT},"
			+ "#{fps,jdbcType=FLOAT}," + "#{result_details_url,jdbcType=VARCHAR},"
			+ "#{state_report_url,jdbcType=VARCHAR}," + "#{nb_object_class,jdbcType=INTEGER}" + ")")
	int insert(String name, String authors, String description, String test_dataset_url, String model_files_url,
			String pico_results_url, String modalities, float map, float mate, float mase, float maoe, float mave,
			float maae, float nds, float fps, String result_details_url, String state_report_url, int nb_object_class);

	@Select("SELECT crdc_airi_detection_task.detection_task_id,crdc_airi_detection_task.name,crdc_airi_detection_task.authors,"
			+ "crdc_airi_detection_task.description,crdc_airi_detection_task.test_dataset_url,"
			+ "crdc_airi_detection_task.model_files_url,crdc_airi_detection_task.pico_results_url,"
			+ "crdc_airi_detection_task.modalities,crdc_airi_detection_task.map,crdc_airi_detection_task.mate,"
			+ "crdc_airi_detection_task.mase,crdc_airi_detection_task.maoe,crdc_airi_detection_task.mave,"
			+ "crdc_airi_detection_task.maae,crdc_airi_detection_task.nds,crdc_airi_detection_task.fps,"
			+ "crdc_airi_detection_task.result_details_url,crdc_airi_detection_task.state_report_url,"
			+ "crdc_airi_detection_task.nb_object_class,crdc_airi_detection_task.create_time,"
			+ "crdc_airi_detection_task.update_time"
			+ " FROM crdc_airi_detection_task WHERE detection_task_id=#{id,jdbcType=INTEGER}")
	DetectionTask selectById(int id);

	@Select("SELECT * FROM crdc_airi_detection_task WHERE name=#{name,jdbcType=VARCHAR}")
	DetectionTask selectByName(String name);

	@Select("SELECT * FROM crdc_airi_detection_task ORDER BY detection_task_id ASC")
	List<DetectionTask> selectAll();

	@Delete("delete from crdc_airi_detection_task where detection_task_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);

}
