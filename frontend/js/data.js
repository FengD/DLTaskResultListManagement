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

function putTaskHeadAngle(task, id, hd) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "PUT", "http://" + serverIP + "/dl_manager_api/" + task + "/head_angle_avg_error/"
  + id +"?head_angle_avg_error=" + hd, false );
  xmlHttp.send( null );
  console.log(xmlHttp.responseText);
  return JSON.parse(xmlHttp.responseText).data;
}

function putTaskVx(task, id, vx) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "PUT", "http://" + serverIP + "/dl_manager_api/" + task + "/long_v_avg_error/"
  + id +"?long_v_avg_error=" + vx, false );
  xmlHttp.send( null );
  console.log(xmlHttp.responseText);
  return JSON.parse(xmlHttp.responseText).data;
}

function putTaskVy(task, id, vy) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "PUT", "http://" + serverIP + "/dl_manager_api/" + task + "/lat_v_avg_error/"
  + id +"?lat_v_avg_error=" + vy, false );
  xmlHttp.send( null );
  console.log(xmlHttp.responseText);
  return JSON.parse(xmlHttp.responseText).data;
}