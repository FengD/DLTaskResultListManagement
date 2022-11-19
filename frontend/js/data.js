var serverIP = "127.0.0.1";

function getDetectionTaskData() {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "GET", "http://" + serverIP + "/dl_manager_api/DetectionTask", false );
  xmlHttp.send( null );
  return JSON.parse(xmlHttp.responseText).data;
}

function getSegmentationTaskData() {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "GET", "http://" + serverIP + "/dl_manager_api/SegmentationTask", false );
  xmlHttp.send( null );
  return JSON.parse(xmlHttp.responseText).data;
}

function getTrackingTaskData() {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "GET", "http://" + serverIP + "/dl_manager_api/TrackingTask", false );
  xmlHttp.send( null );
  return JSON.parse(xmlHttp.responseText).data;
}

function putDetectionTaskDesciption(id, description) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "PUT", "http://" + serverIP + "/dl_manager_api/DetectionTask/"
  + id +"?description=" + description, false );
  xmlHttp.send( null );
  console.log(xmlHttp.responseText);
  return JSON.parse(xmlHttp.responseText).data;
}

function putSegmentationTaskDesciption(id, description) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "PUT", "http://" + serverIP + "/dl_manager_api/SegmentationTask/"
  + id +"?description=" + description, false );
  xmlHttp.send( null );
  return JSON.parse(xmlHttp.responseText).data;
}

function putTrackingTaskDesciption(id, description) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "PUT", "http://" + serverIP + "/dl_manager_api/TrackingTask/"
  + id +"?description=" + description, false );
  xmlHttp.send( null );
  return JSON.parse(xmlHttp.responseText).data;
}
