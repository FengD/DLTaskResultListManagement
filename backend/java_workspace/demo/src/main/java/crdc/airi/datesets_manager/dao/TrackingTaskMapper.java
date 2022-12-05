package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.TrackingTask;

@Mapper
public interface TrackingTaskMapper {
	@Insert("INSERT INTO crdc_airi_tracking_task(name,authors,description,test_dataset_url,"
			+ "model_files_url,pico_results_url,modalities," + "amota,amotp,motar,mota,motp,"
			+ "result_details_url,state_report_url,nb_object_class,platform,inference_time_second,head_angle_avg_error,long_v_avg_error,lat_v_avg_error) VALUES ("
			+ "#{name,jdbcType=VARCHAR}, " + "#{authors,jdbcType=VARCHAR}," + "#{description,jdbcType=VARCHAR},"
			+ "#{test_dataset_url,jdbcType=VARCHAR}," + "#{model_files_url,jdbcType=VARCHAR},"
			+ "#{pico_results_url,jdbcType=VARCHAR}," + "#{modalities,jdbcType=VARCHAR}," + "#{amota,jdbcType=FLOAT},"
			+ "#{amotp,jdbcType=FLOAT}," + "#{motar,jdbcType=FLOAT}," + "#{mota,jdbcType=FLOAT},"
			+ "#{motp,jdbcType=FLOAT}," + "#{result_details_url,jdbcType=VARCHAR},"
			+ "#{state_report_url,jdbcType=VARCHAR}," + "#{nb_object_class,jdbcType=INTEGER},"
			+ "#{platform,jdbcType=VARCHAR}," + "#{inference_time_second,jdbcType=FLOAT},"
			+ "#{head_angle_avg_error,jdbcType=FLOAT}," + "#{long_v_avg_error,jdbcType=FLOAT},"
			+ "#{lat_v_avg_error,jdbcType=FLOAT}" + ")")
	int insert(String name, String authors, String description, String test_dataset_url, String model_files_url,
			String pico_results_url, String modalities, float amota, float amotp, float motar, float mota, float motp,
			String result_details_url, String state_report_url, int nb_object_class, String platform,
			float inference_time_second, float head_angle_avg_error, float long_v_avg_error, float lat_v_avg_error);

	@Select("SELECT tracking_task_id as id, * FROM crdc_airi_tracking_task WHERE tracking_task_id=#{id,jdbcType=INTEGER}")
	TrackingTask selectById(int id);

	@Select("SELECT tracking_task_id as id, * FROM crdc_airi_tracking_task WHERE name=#{name,jdbcType=VARCHAR}")
	List<TrackingTask> selectByName(String name);

	@Select("SELECT tracking_task_id as id, * FROM crdc_airi_tracking_task ORDER BY tracking_task_id ASC")
	List<TrackingTask> selectAll();

	@Update("Update crdc_airi_tracking_task set description=#{description,jdbcType=VARCHAR}, update_time = CURRENT_TIMESTAMP where"
			+ " tracking_task_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String description);

	@Update("Update crdc_airi_tracking_task set head_angle_avg_error=#{head_angle_avg_error,jdbcType=FLOAT}, update_time = CURRENT_TIMESTAMP where"
			+ " tracking_task_id=#{id,jdbcType=INTEGER}")
	int updateHeadAngleById(int id, float head_angle_avg_error);

	@Update("Update crdc_airi_tracking_task set long_v_avg_error=#{long_v_avg_error,jdbcType=FLOAT}, update_time = CURRENT_TIMESTAMP where"
			+ " tracking_task_id=#{id,jdbcType=INTEGER}")
	int updateVXById(int id, float long_v_avg_error);

	@Update("Update crdc_airi_tracking_task set lat_v_avg_error=#{lat_v_avg_error,jdbcType=FLOAT}, update_time = CURRENT_TIMESTAMP where"
			+ " tracking_task_id=#{id,jdbcType=INTEGER}")
	int updateVYById(int id, float lat_v_avg_error);

	@Delete("delete from crdc_airi_tracking_task where tracking_task_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);

}
