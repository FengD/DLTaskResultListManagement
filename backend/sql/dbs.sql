-- namespace crdc (Central Research & Development Center)
-- namespace airi (AI Research Institute)
-- namespace dictionary (the type list prefix)
-- namespace relation (table multi-multi relation)

-- using when init

DROP TABLE IF EXISTS crdc_airi_detection_task;
DROP TABLE IF EXISTS crdc_airi_tracking_task;
DROP TABLE IF EXISTS crdc_airi_segmentation_task;
DROP TABLE IF EXISTS crdc_airi_dictionary_modalities;

CREATE TABLE crdc_airi_dictionary_modalities(
  modalities_id serial NOT NULL PRIMARY KEY,
  name varchar(256),
  description varchar(256),
  create_time timestamp DEFAULT CURRENT_TIMESTAMP,
  update_time timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE crdc_airi_detection_task(
  detection_task_id serial NOT NULL PRIMARY KEY,
  name varchar(256),
  team varchar(256) DEFAULT 'crdc_airi',
  authors varchar(256),
  affiliation varchar(256),
  description varchar(1024),
  project_url varchar(512),
  paper_url varchar(512),
  test_dataset_url varchar(512),
  model_files_url varchar(512),
  pico_results_url varchar(512),
  modalities_id integer REFERENCES crdc_airi_dictionary_modalities(modalities_id),
  picture_link_url varchar(512),
  map float DEFAULT 0,
  mate float DEFAULT 0,
  mase float DEFAULT 0,
  maoe float DEFAULT 0,
  mave float DEFAULT 0,
  maae float DEFAULT 0,
  nds float DEFAULT 0,
  fps float DEFAULT 0,
  recall float DEFAULT 0,
  precision float DEFAULT 0,
  result_details_url varchar(512),
  state_report_url varchar(512),
  nb_object_class integer DEFAULT 0,
  examination_time timestamp DEFAULT CURRENT_TIMESTAMP,
  create_time timestamp DEFAULT CURRENT_TIMESTAMP,
  update_time timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE crdc_airi_tracking_task(
  tracking_task_id serial NOT NULL PRIMARY KEY,
  name varchar(256),
  team varchar(256) DEFAULT 'crdc_airi',
  authors varchar(256),
  affiliation varchar(256),
  description varchar(1024),
  project_url varchar(512),
  paper_url varchar(512),
  test_dataset_url varchar(512),
  model_files_url varchar(512),
  pico_results_url varchar(512),
  modalities_id integer REFERENCES crdc_airi_dictionary_modalities(modalities_id),
  picture_link_url varchar(512),
  amota float DEFAULT 0,
  amotp float DEFAULT 0,
  motar float DEFAULT 0,
  mota float DEFAULT 0,
  motp float DEFAULT 0,
  recall float DEFAULT 0,
  gt float DEFAULT 0,
  mt float DEFAULT 0,
  ml float DEFAULT 0,
  faf float DEFAULT 0,
  tp float DEFAULT 0,
  fp float DEFAULT 0,
  fn float DEFAULT 0,
  ids float DEFAULT 0,
  frag float DEFAULT 0,
  tid float DEFAULT 0,
  lgd float DEFAULT 0,
  fps float DEFAULT 0,
  result_details_url varchar(512),
  state_report_url varchar(512),
  nb_object_class integer DEFAULT 0,
  examination_time timestamp DEFAULT CURRENT_TIMESTAMP,
  create_time timestamp DEFAULT CURRENT_TIMESTAMP,
  update_time timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE crdc_airi_segmentation_task(
  segmentation_task_id serial NOT NULL PRIMARY KEY,
  name varchar(256),
  team varchar(256) DEFAULT 'crdc_airi',
  authors varchar(256),
  affiliation varchar(256),
  description varchar(1024),
  project_url varchar(512),
  paper_url varchar(512),
  test_dataset_url varchar(512),
  model_files_url varchar(512),
  pico_results_url varchar(512),
  modalities_id integer REFERENCES crdc_airi_dictionary_modalities(modalities_id),
  picture_link_url varchar(512),
  miou float DEFAULT 0,
  macc float DEFAULT 0,
  fwiou float DEFAULT 0,
  fps float DEFAULT 0,
  result_details_url varchar(512),
  state_report_url varchar(512),
  nb_object_class integer DEFAULT 0,
  examination_time timestamp DEFAULT CURRENT_TIMESTAMP,
  create_time timestamp DEFAULT CURRENT_TIMESTAMP,
  update_time timestamp DEFAULT CURRENT_TIMESTAMP
);