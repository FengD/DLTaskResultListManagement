ALTER table crdc_airi_detection_task add platform varchar(255);
ALTER table crdc_airi_tracking_task add platform varchar(255);
ALTER table crdc_airi_segmentation_task add platform varchar(255);
ALTER table crdc_airi_detection_task add inference_time_second float;
ALTER table crdc_airi_tracking_task add inference_time_second float;
ALTER table crdc_airi_segmentation_task add inference_time_second float;
ALTER table crdc_airi_detection_task add precision1 float;
ALTER table crdc_airi_detection_task add recall1 float;
ALTER table crdc_airi_detection_task add offset_pixel float;
ALTER table crdc_airi_detection_task add mse float;
ALTER table crdc_airi_detection_task add precision2 float;
ALTER table crdc_airi_detection_task add recall2 float;


UPDATE crdc_airi_detection_task set platform = '';
UPDATE crdc_airi_tracking_task set platform  = '';
UPDATE crdc_airi_segmentation_task set platform  = '';
UPDATE crdc_airi_detection_task set inference_time_second  = 0;
UPDATE crdc_airi_tracking_task set inference_time_second  = 0;
UPDATE crdc_airi_segmentation_task set inference_time_second = 0;
UPDATE crdc_airi_detection_task set precision1 = 0;
UPDATE crdc_airi_detection_task set recall1 = 0;
UPDATE crdc_airi_detection_task set offset_pixel = 0;
UPDATE crdc_airi_detection_task set mse = 0;
UPDATE crdc_airi_detection_task set precision2 = 0;
UPDATE crdc_airi_detection_task set recall2 = 0;