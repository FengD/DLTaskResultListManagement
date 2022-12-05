ALTER table crdc_airi_tracking_task add head_angle_avg_error float;
ALTER table crdc_airi_tracking_task add long_v_avg_error float;
ALTER table crdc_airi_tracking_task add lat_v_avg_error float;


UPDATE crdc_airi_tracking_task set head_angle_avg_error = 0;
UPDATE crdc_airi_tracking_task set long_v_avg_error  = 0;
UPDATE crdc_airi_tracking_task set lat_v_avg_error  = 0;
