const detectionOptions = {
    columnDefs: [
      {
        headerName: 'Basic Infomation',
        
        children: [
          { headerName: 'DATE', field: 'create_time', chartDataType: 'category', tooltipValueGetter: getCellValue},
          { headerName: 'NAME', headerTooltip: 'testest',field: 'name', chartDataType: 'category', tooltipValueGetter: getCellValue},
          { headerName: 'MODALITIES', field: 'modalities', chartDataType: 'category', tooltipValueGetter: getCellValue, headerTooltip: 'lidar,camera,radar,lidar|camera,lidar|radar,lidar|camera|radar'},
          { headerName: 'mAP', field: 'map', chartDataType: 'series', columnGroupShow: 'closed'},
          // { headerName: 'mATE', field: 'mate', columnGroupShow: 'open' },
          // { headerName: 'mASE', field: 'mase', columnGroupShow: 'open' },
          // { headerName: 'mAOE', field: 'maoe', columnGroupShow: 'open' },
          // { headerName: 'mAVE', field: 'mave', columnGroupShow: 'open' },
          // { headerName: 'mAAE', field: 'maae', columnGroupShow: 'open' },
          { headerName: 'MSE', field: 'mse', columnGroupShow: 'open' },
          { headerName: 'Offset(P)', field: 'offset_pixel', columnGroupShow: 'closed' },
          { headerName: 'Precision', field: 'precision_box', columnGroupShow: 'open' },
          { headerName: 'Precision(P)', field: 'precision_point', columnGroupShow: 'open' },
          { headerName: 'Recall', field: 'recall_box'},
          { headerName: 'Recall(P)', field: 'recall_point', columnGroupShow: 'open' },
          { headerName: 'NDS', field: 'nds', columnGroupShow: 'open' },
          { headerName: 'Inference Time(s)', field: 'inference_time_second', columnGroupShow: 'closed'},
          { headerName: 'FPS', field: 'fps', columnGroupShow: 'open',
            editable: true, 
            cellEditor: 'agTextCellEditor'},
          { headerName: 'STATE', field: 'state_report_url', columnGroupShow: 'closed', tooltipValueGetter: getCellValue,
            cellRenderer: function(params) {
              return '<a href=' + params.value + '><i class="fa fa-chart-simple"></i>' + params.value + '</a>'
            }, headerTooltip: 'The report link address'
          },
        ]
      },
      {
        headerName: 'Link Information',
        children : [
          { headerName: 'DATASET', field: 'test_dataset_url', columnGroupShow: 'open', tooltipValueGetter: getCellValue,
            cellRenderer: function(params) {
              return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
          }, headerTooltip: 'The dataset link address of the test of this model'},
          { headerName: 'MODEL', field: 'model_files_url', columnGroupShow: 'closed', tooltipValueGetter: getCellValue,
            cellRenderer: function(params) {
              return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
          }, headerTooltip: 'The model or the model folder link address'},
          { headerName: 'PICKEL', field: 'pico_results_url', columnGroupShow: 'open', tooltipValueGetter: getCellValue,
            cellRenderer: function(params) {
              return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
          }, headerTooltip: 'The the result link address'},
          { headerName: 'DETAILS', field: 'result_details_url', columnGroupShow: 'open', tooltipValueGetter: getCellValue,
            cellRenderer: function(params) {
              return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
          }, headerTooltip: 'The model details link address'},
          { headerName: 'CLASS', field: 'nb_object_class', columnGroupShow: 'open'}
        ]
      },
      {
        headerName: 'Details Information',
        children : [
          { headerName: 'Authors', field: 'authors', tooltipValueGetter: getCellValue},
          { headerName: 'Description', field: 'description', columnGroupShow: 'open', editable: true, cellEditor: 'agTextCellEditor', tooltipValueGetter: getCellValue},
          { headerName: 'Platform', field: 'platform', columnGroupShow: 'open', tooltipValueGetter: getCellValue, headerTooltip: 'The platform type, for example "X86", "TDA4"'},
        ]
      }
      
    ],
    defaultColDef: {
      flex: 1,
      editable: false,
      sortable: true,
      filter: 'agMultiColumnFilter',
      floatingFilter: true,
      resizable: true,
    },
    rowData: getTaskData("DetectionTask"),
    enableCharts: true,
    chartThemes: ['ag-default-dark'],
    onFirstDataRendered: function(params) {
      createChart(params.api);
    },
    chartToolPanelsDef: {
      panels: ['data', 'format', 'settings'],
      defaultToolPanel: 'data',
    },
    onCellValueChanged: function(event) {
      if (event.column.colId == "description") {
        if (event.newValue != event.oldValue) {
          putTaskDesciption("DetectionTask", event.data.id, event.newValue);
        }
      } else if (event.column.colId == "fps") {
        if (event.newValue != event.oldValue) {
          putTaskFps("DetectionTask", event.data.id, event.newValue);
        }
      }
    }
};

const segmentationOptions = {
  columnDefs: [
    {
      headerName: 'Basic Infomation',
      children: [
        { headerName: 'DATE', field: 'create_time', chartDataType: 'category', tooltipValueGetter: getCellValue},
        { headerName: 'NAME', field: 'name', chartDataType: 'category', tooltipValueGetter: getCellValue},
        { headerName: 'MODALITIES', field: 'modalities', chartDataType: 'category', tooltipValueGetter: getCellValue, headerTooltip: 'lidar,camera,radar,lidar|camera,lidar|radar,lidar|camera|radar'},
        { headerName: 'mIoU', field: 'miou'},
        { headerName: 'mACC', field: 'macc'},
        { headerName: 'mBoundary', field: 'mboundary', columnGroupShow: 'open'},
        { headerName: 'Inference Time(s)', field: 'inference_time_second'},
        { headerName: 'FPS', field: 'fps', columnGroupShow: 'open', editable: true, cellEditor: 'agTextCellEditor'},
        { headerName: 'STATE', field: 'state_report_url', tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-chart-simple"></i>' + params.value + '</a>'
          }, headerTooltip: 'The report link address'
        },
      ]
    },
    {
      headerName: 'Link Information',
      children : [
        { headerName: 'DATASET', field: 'test_dataset_url', columnGroupShow: 'open', tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }, headerTooltip: 'The dataset link address of the test of this model'},
        { headerName: 'MODEL', field: 'model_files_url', columnGroupShow: 'closed', tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }, headerTooltip: 'The model or the model folder link address'},
        { headerName: 'PICKEL', field: 'pico_results_url', columnGroupShow: 'open', tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }, headerTooltip: 'The the result link address'},
        { headerName: 'DETAILS', field: 'result_details_url', columnGroupShow: 'open', tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }, headerTooltip: 'The model details link address'},
        { headerName: 'CLASS', field: 'nb_object_class', columnGroupShow: 'open'}
      ]
    },
    {
      headerName: 'Details Information',
      children : [
        { headerName: 'Authors', field: 'authors', tooltipValueGetter: getCellValue},
        { headerName: 'Description', field: 'description', columnGroupShow: 'open', editable: true, cellEditor: 'agTextCellEditor', tooltipValueGetter: getCellValue},
        { headerName: 'Platform', field: 'platform', columnGroupShow: 'open', tooltipValueGetter: getCellValue, headerTooltip: 'The platform type, for example "X86", "TDA4"'},
      ]
    }
    
  ],
  defaultColDef: {
    flex: 1,
    editable: false,
    sortable: true,
    filter: 'agMultiColumnFilter',
    floatingFilter: true,
    resizable: true,
  },
  rowData: getTaskData("SegmentationTask"),
  enableCharts: true,
  chartThemes: ['ag-default-dark'],
  onFirstDataRendered: function(params) {
    createChart(params.api);
  },
  chartToolPanelsDef: {
    panels: ['data', 'format', 'settings'],
    defaultToolPanel: 'data',
  },
  onCellValueChanged: function(event) {
    if (event.column.colId == "description") {
      if (event.newValue != event.oldValue) {
        putTaskDesciption("SegmentationTask", event.data.id, event.newValue);
      }
    } else if (event.column.colId == "fps") {
      if (event.newValue != event.oldValue) {
        putTaskFps("SegmentationTask", event.data.id, event.newValue);
      }
    }
  }
};

const trackingOptions = {
  columnDefs: [
    {
      headerName: 'Basic Infomation',
      children: [
        { headerName: 'DATE', field: 'create_time', chartDataType: 'category', tooltipValueGetter: getCellValue},
        { headerName: 'NAME', field: 'name', chartDataType: 'category', tooltipValueGetter: getCellValue, headerTooltip: 'The name of the tracking module'},
        { headerName: 'MODALITIES', field: 'modalities', chartDataType: 'category', tooltipValueGetter: getCellValue, headerTooltip: 'lidar,camera,radar,lidar|camera,lidar|radar,lidar|camera|radar'},
        { headerName: 'MOTA', field: 'mota'},
        { headerName: 'MOTP', field: 'motp'},
        { headerName: 'HEAD_ANGLE_AVG_ERROR', field: 'head_angle_avg_error', editable: true, cellEditor: 'agTextCellEditor'},
        { headerName: 'LONG_V_AVG_ERROR', field: 'long_v_avg_error', editable: true, cellEditor: 'agTextCellEditor'},
        { headerName: 'LAT_V_AVG_ERROR', field: 'lat_v_avg_error', editable: true, cellEditor: 'agTextCellEditor'},
        { headerName: 'AMOTA', field: 'amota', columnGroupShow: 'open'},
        { headerName: 'AMOTP', field: 'amotp', columnGroupShow: 'open'},
        { headerName: 'MOTAR', field: 'motar', columnGroupShow: 'open'},
        { headerName: 'Inference Time(s)', field: 'inference_time_second', headerTooltip: 'Inference Time in second'},
        { headerName: 'STATE', field: 'state_report_url', tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-chart-simple"></i>' + params.value + '</a>'
          }, headerTooltip: 'The report link address'
        },
      ]
    },
    {
      headerName: 'Link Information',
      children : [
        { headerName: 'DATASET', field: 'test_dataset_url', columnGroupShow: 'open', tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }, headerTooltip: 'The dataset link address of the test of this model'},
        { headerName: 'MODEL', field: 'model_files_url', columnGroupShow: 'closed', tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }, headerTooltip: 'The model or the model folder link address'},
        { headerName: 'PICKEL', field: 'pico_results_url', columnGroupShow: 'open', tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }, headerTooltip: 'The the result link address'},
        { headerName: 'DETAILS', field: 'result_details_url', columnGroupShow: 'open', tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }, headerTooltip: 'The model details link address'},
        { headerName: 'CLASS', field: 'nb_object_class', columnGroupShow: 'open'}
      ]
    },
    {
      headerName: 'Details Information',
      children : [
        { headerName: 'Authors', field: 'authors', tooltipValueGetter: getCellValue},
        { headerName: 'Description', field: 'description', columnGroupShow: 'open', editable: true, cellEditor: 'agTextCellEditor', tooltipValueGetter: getCellValue},
        { headerName: 'Platform', field: 'platform', columnGroupShow: 'open', tooltipValueGetter: getCellValue, headerTooltip: 'The platform type, for example "X86", "TDA4"'},
      ]
    }
  ],
  defaultColDef: {
    flex: 1,
    editable: false,
    sortable: true,
    filter: 'agMultiColumnFilter',
    floatingFilter: true,
    resizable: true,
  },
  rowData: getTaskData("TrackingTask"),
  enableCharts: true,
  chartThemes: ['ag-default-dark'],
  onFirstDataRendered: function(params) {
    createChart(params.api);
  },
  chartToolPanelsDef: {
    panels: ['data', 'format', 'settings'],
    defaultToolPanel: 'data',
  },
  onCellValueChanged: function(event) {
    if (event.column.colId == "description") {
      if (event.newValue != event.oldValue) {
        putTaskDesciption("TrackingTask", event.data.id, event.newValue);
      }
    } else if (event.column.colId == "head_angle_avg_error") {
      if (event.newValue != event.oldValue) {
        putTaskHeadAngle("TrackingTask", event.data.id, event.newValue);
      }
    } else if (event.column.colId == "long_v_avg_error") {
      if (event.newValue != event.oldValue) {
        putTaskVx("TrackingTask", event.data.id, event.newValue);
      }
    } else if (event.column.colId == "lat_v_avg_error") {
      if (event.newValue != event.oldValue) {
        putTaskVy("TrackingTask", event.data.id, event.newValue);
      }
    }
  }
};
  
function createChart(gridApi) {
  var createRangeChartParams = {
    chartType: 'line',
    cellRange: {
      columns: ['name', 'map', 'miou', 'mota', 'precision_box'],
    },
    chartThemeOverrides: {
      common: {
        title: {
          enabled: true,
          text: 'Model Data Details',
        }
      }
    },
    chartContainer: document.querySelector('#chart'),
  };
  gridApi.createRangeChart(createRangeChartParams);
}

function getCellValue(params) {      
  return params.value;
}
  
// setup the grid after the page has finished loading
document.addEventListener('DOMContentLoaded', function () {
  var detectionGrid = document.querySelector('#detectionGrid');
  if (detectionGrid != null) {
    new agGrid.Grid(detectionGrid, detectionOptions);
  }
  var segmentationGrid = document.querySelector('#segmentationGrid');
  if (segmentationGrid != null) {
    new agGrid.Grid(segmentationGrid, segmentationOptions);
  }
  var trackingGrid = document.querySelector('#trackingGrid');
  if (trackingGrid != null) {
    new agGrid.Grid(trackingGrid, trackingOptions);
  }
});