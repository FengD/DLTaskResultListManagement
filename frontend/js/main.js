const detectionOptions = {
    columnDefs: [
      {
        headerName: 'Basic Infomation',
        children: [
          { headerName: 'DATE', field: 'create_time', chartDataType: 'category',tooltipValueGetter: getCellValue},
          { headerName: 'NAME', field: 'name', chartDataType: 'category',tooltipValueGetter: getCellValue},
          { headerName: 'MODALITIES', field: 'modalities', chartDataType: 'category',tooltipValueGetter: getCellValue},
          { headerName: 'mAP', field: 'map', chartDataType: 'series', columnGroupShow: 'closed'},
          { headerName: 'mATE', field: 'mate', columnGroupShow: 'open' },
          { headerName: 'mASE', field: 'mase', columnGroupShow: 'open' },
          { headerName: 'mAOE', field: 'maoe', columnGroupShow: 'open' },
          { headerName: 'mAVE', field: 'mave', columnGroupShow: 'open' },
          { headerName: 'mAAE', field: 'maae', columnGroupShow: 'open' },
          { headerName: 'NDS', field: 'nds'},
          { headerName: 'FPS', field: 'fps', columnGroupShow: 'closed',
          editable: true, 
          cellEditor: 'agTextCellEditor'},
          { headerName: 'STATE', field: 'state_report_url', columnGroupShow: 'closed',tooltipValueGetter: getCellValue,
            cellRenderer: function(params) {
              return '<a href=' + params.value + '><i class="fa fa-chart-simple"></i>' + params.value + '</a>'
            }
          },
        ]
      },
      {
        headerName: 'Link Information',
        children : [
          { headerName: 'Dateset', field: 'test_dataset_url', tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
          }},
          { headerName: 'Model', field: 'model_files_url', columnGroupShow: 'closed',tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
          }},
          { headerName: 'Pico', field: 'pico_results_url', columnGroupShow: 'open',tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
          }},
          { headerName: 'Details', field: 'result_details_url', columnGroupShow: 'open',tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
          }},
          { headerName: 'Class', field: 'nb_object_class', columnGroupShow: 'open'}
        ]
      },
      {
        headerName: 'Details Information',
        children : [
          { headerName: 'Authors', field: 'authors', columnGroupShow: 'closed',tooltipValueGetter: getCellValue},
          { headerName: 'Description', field: 'description', columnGroupShow: 'open',
              editable: true, 
              cellEditor: 'agTextCellEditor',tooltipValueGetter: getCellValue}
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
      createMAPChart(params.api);
      createNDSChart(params.api);
      createFPSChart(params.api);
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
        { headerName: 'DATE', field: 'create_time', chartDataType: 'category',tooltipValueGetter: getCellValue},
        { headerName: 'NAME', field: 'name', chartDataType: 'category',tooltipValueGetter: getCellValue},
        { headerName: 'MODALITIES', field: 'modalities', chartDataType: 'category',tooltipValueGetter: getCellValue},
        { headerName: 'mIOU', field: 'miou'},
        { headerName: 'mACC', field: 'macc'},
        { headerName: 'mBoundary', field: 'mboundary'},
        { headerName: 'FPS', field: 'fps',
        editable: true, 
        cellEditor: 'agTextCellEditor'},
        { headerName: 'STATE', field: 'state_report_url',tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-chart-simple"></i>' + params.value + '</a>'
          }
        },
      ]
    },
    {
      headerName: 'Link Information',
      children : [
        { headerName: 'Dateset', field: 'test_dataset_url',tooltipValueGetter: getCellValue,
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }},
        { headerName: 'Model', field: 'model_files_url', columnGroupShow: 'closed',tooltipValueGetter: getCellValue,
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }},
        { headerName: 'Pico', field: 'pico_results_url', columnGroupShow: 'open',tooltipValueGetter: getCellValue,
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }},
        { headerName: 'Details', field: 'result_details_url', columnGroupShow: 'open',tooltipValueGetter: getCellValue,
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }},
        { headerName: 'Class', field: 'nb_object_class', columnGroupShow: 'open'}
      ]
    },
    {
      headerName: 'Details Information',
      children : [
        { headerName: 'Authors', field: 'authors', columnGroupShow: 'closed',tooltipValueGetter: getCellValue},
        { headerName: 'Description', field: 'description', columnGroupShow: 'open',tooltipValueGetter: getCellValue,
        editable: true, 
        cellEditor: 'agTextCellEditor'}
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
    createMIOUChart(params.api);
    createMACCChart(params.api);
    createFPSChart(params.api);
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
        { headerName: 'DATE', field: 'create_time', chartDataType: 'category',tooltipValueGetter: getCellValue},
        { headerName: 'NAME', field: 'name', chartDataType: 'category',tooltipValueGetter: getCellValue},
        { headerName: 'MODALITIES', field: 'modalities', chartDataType: 'category',tooltipValueGetter: getCellValue},
        { headerName: 'MOTA', field: 'mota'},
        { headerName: 'MOTP', field: 'motp'},
        { headerName: 'AMOTA', field: 'amota', columnGroupShow: 'open'},
        { headerName: 'AMOTP', field: 'amotp', columnGroupShow: 'open'},
        { headerName: 'MOTAR', field: 'motar', columnGroupShow: 'open'},
        { headerName: 'STATE', field: 'state_report_url',tooltipValueGetter: getCellValue,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-chart-simple"></i>' + params.value + '</a>'
          }
        },
      ]
    },
    {
      headerName: 'Link Information',
      children : [
        { headerName: 'Dateset', field: 'test_dataset_url',tooltipValueGetter: getCellValue,
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }},
        { headerName: 'Model', field: 'model_files_url', columnGroupShow: 'closed',tooltipValueGetter: getCellValue,
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }},
        { headerName: 'Pico', field: 'pico_results_url', columnGroupShow: 'open',tooltipValueGetter: getCellValue,
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }},
        { headerName: 'Details', field: 'result_details_url', columnGroupShow: 'open',tooltipValueGetter: getCellValue,
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }},
        { headerName: 'Class', field: 'nb_object_class', columnGroupShow: 'open'}
      ]
    },
    {
      headerName: 'Details Information',
      children : [
        { headerName: 'Authors', field: 'authors', columnGroupShow: 'closed',tooltipValueGetter: getCellValue},
        { headerName: 'Description', field: 'description', columnGroupShow: 'open',tooltipValueGetter: getCellValue,editable: true, 
        // uses the provided Text Cell Editor (which is the default)
        cellEditor: 'agTextCellEditor' }
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
    createMOTPChart(params.api);
    createMOTAChart(params.api);
  },
  onCellValueChanged: function(event) {
    if (event.column.colId == "description") {
      if (event.newValue != event.oldValue) {
        putTaskDesciption("TrackingTask", event.data.id, event.newValue);
      }
    }
  }
};
  
function createMAPChart(gridApi) {
  gridApi.createCrossFilterChart({
    chartType: 'line',
    cellRange: {
      columns: ['name', 'map'],
    },
    aggFunc: 'sum',
    chartThemeOverrides: {
      common: {
        title: {
          enabled: true,
          text: 'Model mAP',
        }
      }
    },
    chartContainer: document.querySelector('#map-chart'),
  });
}

function createNDSChart(gridApi) {
  gridApi.createCrossFilterChart({
    chartType: 'line',
    cellRange: {
      columns: ['name', 'nds'],
    },
    aggFunc: 'sum',
    chartThemeOverrides: {
      common: {
        title: {
          enabled: true,
          text: 'Model NDS',
        }
      }
    },
    chartContainer: document.querySelector('#nds-chart'),
  });
}

function createFPSChart(gridApi) {
  gridApi.createCrossFilterChart({
    chartType: 'line',
    cellRange: {
      columns: ['name', 'fps'],
    },
    aggFunc: 'sum',
    chartThemeOverrides: {
      common: {
        title: {
          enabled: true,
          text: 'Model FPS',
        }
      }
    },
    chartContainer: document.querySelector('#fps-chart'),
  });
}

function createMIOUChart(gridApi) {
  gridApi.createCrossFilterChart({
    chartType: 'line',
    cellRange: {
      columns: ['name', 'miou'],
    },
    aggFunc: 'sum',
    chartThemeOverrides: {
      common: {
        title: {
          enabled: true,
          text: 'Model mIOU',
        }
      }
    },
    chartContainer: document.querySelector('#miou-chart'),
  });
}

function createMACCChart(gridApi) {
  gridApi.createCrossFilterChart({
    chartType: 'line',
    cellRange: {
      columns: ['name', 'macc'],
    },
    aggFunc: 'sum',
    chartThemeOverrides: {
      common: {
        title: {
          enabled: true,
          text: 'Model mACC',
        }
      }
    },
    chartContainer: document.querySelector('#macc-chart'),
  });
}

function createMOTAChart(gridApi) {
  gridApi.createCrossFilterChart({
    chartType: 'line',
    cellRange: {
      columns: ['name', 'mota'],
    },
    aggFunc: 'sum',
    chartThemeOverrides: {
      common: {
        title: {
          enabled: true,
          text: 'Model MOTA',
        }
      }
    },
    chartContainer: document.querySelector('#mota-chart'),
  });
}

function createMOTPChart(gridApi) {
  gridApi.createCrossFilterChart({
    chartType: 'line',
    cellRange: {
      columns: ['name', 'motp'],
    },
    aggFunc: 'sum',
    chartThemeOverrides: {
      common: {
        title: {
          enabled: true,
          text: 'Model MOTP',
        }
      }
    },
    chartContainer: document.querySelector('#motp-chart'),
  });
}

function getCellValue(params) {      
  return params.value;
}
  
// setup the grid after the page has finished loading
document.addEventListener('DOMContentLoaded', function () {
  var detectionGrid = document.querySelector('#detectionGrid');
  if (detectionGrid != null) {
    console.log(1)

    new agGrid.Grid(detectionGrid, detectionOptions);
  }
  var segmentationGrid = document.querySelector('#segmentationGrid');
  if (segmentationGrid != null) {
    console.log(2)
    new agGrid.Grid(segmentationGrid, segmentationOptions);
  }
  var trackingGrid = document.querySelector('#trackingGrid');
  if (trackingGrid != null) {
    console.log(3)

    new agGrid.Grid(trackingGrid, trackingOptions);
  }
});