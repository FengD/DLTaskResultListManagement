-- namespace crdc (Central Research & Development Center)
-- namespace airi (AI Research Institute)
-- namespace dictionary (the type list prefix)
-- namespace relation (table multi-multi relation)

-- using when init

DROP TABLE IF EXISTS crdc_airi_detection_task;
DROP TABLE IF EXISTS crdc_airi_tracking_task;
DROP TABLE IF EXISTS crdc_airi_segmentation_task;

-- name,authors,description,test_dataset_url,model_files_url,pico_results_url,modalities,map,mate ,mase,maoe,mave,maae,nds,fps,result_details_url,state_report_url,nb_object_class

CREATE TABLE crdc_airi_detection_task(
  detection_task_id serial NOT NULL PRIMARY KEY,
  name varchar(256) NOT NULL,
  authors varchar(256) NOT NULL,
  description varchar(1024),
  test_dataset_url varchar(512),
  model_files_url varchar(512),
  pico_results_url varchar(512),
  modalities varchar(512) NOT NULL,
  map float DEFAULT 0,
  mate float DEFAULT 0,
  mase float DEFAULT 0,
  maoe float DEFAULT 0,
  mave float DEFAULT 0,
  maae float DEFAULT 0,
  nds float DEFAULT 0,
  fps float DEFAULT 0,
  result_details_url varchar(512),
  state_report_url varchar(512),
  nb_object_class integer DEFAULT 0,
  create_time timestamp DEFAULT CURRENT_TIMESTAMP,
  update_time timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE crdc_airi_tracking_task(
  tracking_task_id serial NOT NULL PRIMARY KEY,
  name varchar(256) NOT NULL,
  authors varchar(256) NOT NULL,
  description varchar(1024),
  test_dataset_url varchar(512),
  model_files_url varchar(512),
  pico_results_url varchar(512),
  modalities varchar(512) NOT NULL,
  amota float DEFAULT 0,
  amotp float DEFAULT 0,
  motar float DEFAULT 0,
  mota float DEFAULT 0,
  motp float DEFAULT 0,
  result_details_url varchar(512),
  state_report_url varchar(512),
  nb_object_class integer DEFAULT 0,
  create_time timestamp DEFAULT CURRENT_TIMESTAMP,
  update_time timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE crdc_airi_segmentation_task(
  segmentation_task_id serial NOT NULL PRIMARY KEY,
  name varchar(256) NOT NULL,
  authors varchar(256) NOT NULL,
  description varchar(1024),
  test_dataset_url varchar(512),
  model_files_url varchar(512),
  pico_results_url varchar(512),
  modalities varchar(512) NOT NULL,
  miou float DEFAULT 0,
  macc float DEFAULT 0,
  mboundary float DEFAULT 0,
  fps float DEFAULT 0,
  result_details_url varchar(512),
  state_report_url varchar(512),
  nb_object_class integer DEFAULT 0,
  create_time timestamp DEFAULT CURRENT_TIMESTAMP,
  update_time timestamp DEFAULT CURRENT_TIMESTAMP
);