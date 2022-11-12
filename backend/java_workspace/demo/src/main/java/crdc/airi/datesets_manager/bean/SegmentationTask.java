package crdc.airi.datesets_manager.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SegmentationTask {
	private int id;
	private String name;
	private String authors;
	private String description;
	private String test_dataset_url;
	private String model_files_url;
	private String pico_results_url;
	private String modalities;
	private float miou;
	private float macc;
	private float mboundary;
	private float fps;
	private String result_details_url;
	private String state_report_url;
	private int nb_object_class;
	private String create_time;
	private String update_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTest_dataset_url() {
		return test_dataset_url;
	}
	public void setTest_dataset_url(String test_dataset_url) {
		this.test_dataset_url = test_dataset_url;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getModel_files_url() {
		return model_files_url;
	}
	public void setModel_files_url(String model_files_url) {
		this.model_files_url = model_files_url;
	}
	public String getPico_results_url() {
		return pico_results_url;
	}
	public void setPico_results_url(String pico_results_url) {
		this.pico_results_url = pico_results_url;
	}
	public float getMiou() {
		return miou;
	}
	public void setMiou(float miou) {
		this.miou = miou;
	}
	public String getModalities() {
		return modalities;
	}
	public void setModalities(String modalities) {
		this.modalities = modalities;
	}
	public float getMacc() {
		return macc;
	}
	public void setMacc(float macc) {
		this.macc = macc;
	}
	public float getMboundary() {
		return mboundary;
	}
	public void setMboundary(float mboundary) {
		this.mboundary = mboundary;
	}
	public float getFps() {
		return fps;
	}
	public void setFps(float fps) {
		this.fps = fps;
	}
	public String getResult_details_url() {
		return result_details_url;
	}
	public void setResult_details_url(String result_details_url) {
		this.result_details_url = result_details_url;
	}
	public String getState_report_url() {
		return state_report_url;
	}
	public void setState_report_url(String state_report_url) {
		this.state_report_url = state_report_url;
	}
	public int getNb_object_class() {
		return nb_object_class;
	}
	public void setNb_object_class(int nb_object_class) {
		this.nb_object_class = nb_object_class;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
}
