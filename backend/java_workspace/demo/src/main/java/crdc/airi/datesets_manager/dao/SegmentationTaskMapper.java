package crdc.airi.datesets_manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import crdc.airi.datesets_manager.bean.SegmentationTask;

@Mapper
public interface SegmentationTaskMapper {

	@Insert("INSERT INTO crdc_airi_segmentation_task(" + "name,authors,description,test_dataset_url,"
			+ "model_files_url,pico_results_url,modalities," + "miou,macc,mboundary,fps,"
			+ "result_details_url,state_report_url,nb_object_class) VALUES (" + "#{name,jdbcType=VARCHAR}, "
			+ "#{authors,jdbcType=VARCHAR}," + "#{description,jdbcType=VARCHAR},"
			+ "#{test_dataset_url,jdbcType=VARCHAR}," + "#{model_files_url,jdbcType=VARCHAR},"
			+ "#{pico_results_url,jdbcType=VARCHAR}," + "#{modalities,jdbcType=VARCHAR}," + "#{miou,jdbcType=FLOAT},"
			+ "#{macc,jdbcType=FLOAT}," + "#{mboundary,jdbcType=FLOAT}," + "#{fps,jdbcType=FLOAT},"
			+ "#{result_details_url,jdbcType=VARCHAR}," + "#{state_report_url,jdbcType=VARCHAR},"
			+ "#{nb_object_class,jdbcType=INTEGER}" + ")")
	int insert(String name, String authors, String description, String test_dataset_url, String model_files_url,
			String pico_results_url, String modalities, float miou, float macc, float mboundary, float fps,
			String result_details_url, String state_report_url, int nb_object_class);

	@Select("SELECT * FROM crdc_airi_segmentation_task WHERE segmentation_task_id=#{id,jdbcType=INTEGER}")
	SegmentationTask selectById(int id);

	@Select("SELECT * FROM crdc_airi_segmentation_task WHERE name=#{name,jdbcType=VARCHAR}")
	List<SegmentationTask> selectByName(String name);

	@Select("SELECT * FROM crdc_airi_segmentation_task ORDER BY segmentation_task_id ASC")
	List<SegmentationTask> selectAll();
	
	@Update("Update crdc_airi_segmentation_task set description=#{description,jdbcType=VARCHAR} where"
			+ " segmentation_task_id=#{id,jdbcType=INTEGER}")
	int updateById(int id, String description);

	@Delete("delete from crdc_airi_segmentation_task where segmentation_task_id=#{id,jdbcType=INTEGER}")
	int deleteById(int id);

}
