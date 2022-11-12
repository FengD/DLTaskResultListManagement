function getDetectionTaskData() {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "GET", "http://127.0.0.1/dl_manager_api/DetectionTask", false );
  xmlHttp.send( null );
  return JSON.parse(xmlHttp.responseText).data;
}

function getSegmentationTaskData() {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "GET", "http://127.0.0.1/dl_manager_api/SegmentationTask", false );
  xmlHttp.send( null );
  return JSON.parse(xmlHttp.responseText).data;
}

function getTrackingTaskData() {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "GET", "http://127.0.0.1/dl_manager_api/TrackingTask", false );
  xmlHttp.send( null );
  return JSON.parse(xmlHttp.responseText).data;
}

// function getData() {
//     return [
//       {
//         name: '1',
//         team: '1',
//         authors: '1',
//         affiliation: '1',
//         description: '1',
//         project_url: '1',
//         project_name: '1',
//         papar_url: '1',
//         test_dataset_url: '1',
//         model_files_url: '1',
//         pico_results_url: '1',
//         modalities: '1',
//         picture_link_url: '1',
//         map: 10,
//         mate: 10,
//         mase: 10,
//         maoe: 10,
//         mave: 10,
//         maae: 10,
//         nds: 10,
//         fps: 10,
//         recall: 10,
//         precision: 10,
//         result_details_url: '1',
//         state_report_url: '1',
//         nb_object_class: 1,
//         examination_time: '20222222',
//         create_time: '20222222',
//         update_time: '20222222'
//       },
//       {
//         name: '2',
//         team: '2',
//         authors: '2',
//         affiliation: '2',
//         description: '2',
//         project_url: '2',
//         project_name: '222',
//         papar_url: '2',
//         test_dataset_url: '2',
//         model_files_url: '2',
//         pico_results_url: '2',
//         modalities: '2',
//         picture_link_url: '2',
//         map: 20,
//         mate: 20,
//         mase: 20,
//         maoe: 20,
//         mave: 20,
//         maae: 20,
//         nds: 20,
//         fps: 20,
//         recall: 20,
//         precision: 20,
//         result_details_url: '2',
//         state_report_url: '2',
//         nb_object_class: 2,
//         examination_time: '2',
//         create_time: '2',
//         update_time: '2'
//       },
//       {
//         name: '3',
//         team: '3',
//         authors: '3',
//         affiliation: '33',
//         description: '3',
//         project_url: '3',
//         papar_url: '3',
//         project_name: '331',
//         test_dataset_url: '3',
//         model_files_url: '3',
//         pico_results_url: '3',
//         modalities: '3',
//         picture_link_url: '3',
//         map: 30,
//         mate: 30,
//         mase: 3,
//         maoe: 30,
//         mave: 30,
//         maae: 30,
//         nds: 20,
//         fps: 70,
//         recall: 30,
//         precision: 30,
//         result_details_url: '3',
//         state_report_url: '3',
//         nb_object_class: 30,
//         examination_time: '3',
//         create_time: '3',
//         update_time: '3'
//       },
//       {
//         name: '4',
//         team: '4',
//         authors: '4',
//         affiliation: '4',
//         description: '4',
//         project_url: '4',
//         papar_url: '4',
//         test_dataset_url: '4',
//         model_files_url: '4',
//         pico_results_url: '4',
//         modalities: '4',
//         picture_link_url: '4',
//         map: 40,
//         mate: 40,
//         mase: 40,
//         maoe: 40,
//         mave: 40,
//         maae: 40,
//         nds: 4,
//         fps: 89,
//         recall: 40,
//         precision: 40,
//         result_details_url: '4',
//         state_report_url: '4',
//         nb_object_class: 4,
//         examination_time: '4',
//         create_time: '4',
//         update_time: '4'
//       },
//     ];
//   }