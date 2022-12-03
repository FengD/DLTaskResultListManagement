ALTER TABLE crdc_airi_detection_task RENAME COLUMN precision1 TO precision_box;
ALTER TABLE crdc_airi_detection_task RENAME COLUMN precision2 TO precision_point;
ALTER TABLE crdc_airi_detection_task RENAME COLUMN recall1 TO recall_box;
ALTER TABLE crdc_airi_detection_task RENAME COLUMN recall2 TO recall_point;
ALTER TABLE crdc_airi_detection_task DROP COLUMN percision1;
ALTER TABLE crdc_airi_detection_task DROP COLUMN percision2;