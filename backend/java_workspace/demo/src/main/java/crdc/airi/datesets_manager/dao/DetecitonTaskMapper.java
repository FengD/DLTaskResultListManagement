package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

	@Select("SELECT * FROM crdc_airi_detection_task WHERE detection_task_id=#{id,jdbcType=INTEGER}")
	DetectionTask selectById(int id);

	@Select("SELECT * FROM crdc_airi_detection_task WHERE name=#{name,jdbcType=VARCHAR}")
	List<DetectionTask> selectByName(String name);

	@Select("SELECT * FROM crdc_airi_detection_task ORDER BY detection_task_id ASC")
	List<DetectionTask> selectAll();

	@Update("Update crdc_airi_detection_task set description=#{description,jdbcType=VARCHAR} where"
			+ " detection_task_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String description);

	@Delete("delete from crdc_airi_detection_task where detection_task_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);

}
