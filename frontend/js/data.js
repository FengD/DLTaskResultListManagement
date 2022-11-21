var serverIP = "127.0.0.1";

function getTaskData(task) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "GET", "http://" + serverIP + "/dl_manager_api/" + task, false );
  xmlHttp.send( null );
  return JSON.parse(xmlHttp.responseText).data;
}

function putTaskDesciption(task, id, description) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "PUT", "http://" + serverIP + "/dl_manager_api/" + task + "/"
  + id +"?description=" + description, false );
  xmlHttp.send( null );
  return JSON.parse(xmlHttp.responseText).data;
}

function putTaskFps(task, id, fps) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "PUT", "http://" + serverIP + "/dl_manager_api/" + task + "/fps/"
  + id +"?fps=" + fps, false );
  xmlHttp.send( null );
  console.log(xmlHttp.responseText);
  return JSON.parse(xmlHttp.responseText).data;
}