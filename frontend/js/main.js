const detectionOptions = {
    columnDefs: [
      {
        headerName: 'Basic Infomation',
        children: [
          { headerName: 'DATE', field: 'create_time', chartDataType: 'category'},
          { headerName: 'NAME', field: 'name', chartDataType: 'category'},
          { headerName: 'MODALITIES', field: 'modalities', chartDataType: 'category'},
          { headerName: 'mAP', field: 'map', chartDataType: 'series', columnGroupShow: 'closed'},
          { headerName: 'mATE', field: 'mate', columnGroupShow: 'open' },
          { headerName: 'mASE', field: 'mase', columnGroupShow: 'open' },
          { headerName: 'mAOE', field: 'maoe', columnGroupShow: 'open' },
          { headerName: 'mAVE', field: 'mave', columnGroupShow: 'open' },
          { headerName: 'mAAE', field: 'maae', columnGroupShow: 'open' },
          { headerName: 'NDS', field: 'nds'},
          { headerName: 'FPS', field: 'fps', columnGroupShow: 'closed'},
          { headerName: 'STATE', field: 'state_report_url', columnGroupShow: 'closed',
            cellRenderer: function(params) {
              return '<a href=' + params.value + '><i class="fa fa-chart-simple"></i></a>'
            }
          },
        ]
      },
      {
        headerName: 'Link Information',
        children : [
          { headerName: 'Dateset', field: 'test_dataset_url',
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
          }},
          { headerName: 'Model', field: 'model_files_url', columnGroupShow: 'closed',
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
          }},
          { headerName: 'Pico', field: 'pico_results_url', columnGroupShow: 'open',
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i></a>'
          }},
          { headerName: 'Details', field: 'result_details_url', columnGroupShow: 'open',
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i></a>'
          }},
          { headerName: 'Class', field: 'nb_object_class', columnGroupShow: 'open'}
        ]
      },
      {
        headerName: 'Details Information',
        children : [
          { headerName: 'Authors', field: 'authors', columnGroupShow: 'closed'},
          { headerName: 'Description', field: 'description', columnGroupShow: 'open'}
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
    rowData: getDetectionTaskData(),
    enableCharts: true,
    chartThemes: ['ag-default-dark'],
    onFirstDataRendered: function(params) {
      createMAPChart(params.api);
      createNDSChart(params.api);
      createFPSChart(params.api);
    },
};

const segmentationOptions = {
  columnDefs: [
    {
      headerName: 'Basic Infomation',
      children: [
        { headerName: 'DATE', field: 'create_time', chartDataType: 'category'},
        { headerName: 'NAME', field: 'name', chartDataType: 'category'},
        { headerName: 'MODALITIES', field: 'modalities', chartDataType: 'category'},
        { headerName: 'mIOU', field: 'miou'},
        { headerName: 'mACC', field: 'macc'},
        { headerName: 'mBoundary', field: 'mboundary'},
        { headerName: 'FPS', field: 'fps'},
        { headerName: 'STATE', field: 'state_report_url',
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-chart-simple"></i></a>'
          }
        },
      ]
    },
    {
      headerName: 'Link Information',
      children : [
        { headerName: 'Dateset', field: 'test_dataset_url',
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }},
        { headerName: 'Model', field: 'model_files_url', columnGroupShow: 'closed',
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }},
        { headerName: 'Pico', field: 'pico_results_url', columnGroupShow: 'open',
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i></a>'
        }},
        { headerName: 'Details', field: 'result_details_url', columnGroupShow: 'open',
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i></a>'
        }},
        { headerName: 'Class', field: 'nb_object_class', columnGroupShow: 'open'}
      ]
    },
    {
      headerName: 'Details Information',
      children : [
        { headerName: 'Authors', field: 'authors', columnGroupShow: 'closed'},
        { headerName: 'Description', field: 'description', columnGroupShow: 'open'}
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
  rowData: getSegmentationTaskData(),
  enableCharts: true,
  chartThemes: ['ag-default-dark'],
  onFirstDataRendered: function(params) {
    createMIOUChart(params.api);
    createMACCChart(params.api);
    createFPSChart(params.api);
  },
};

const trackingOptions = {
  columnDefs: [
    {
      headerName: 'Basic Infomation',
      children: [
        { headerName: 'DATE', field: 'create_time', chartDataType: 'category'},
        { headerName: 'NAME', field: 'name', chartDataType: 'category'},
        { headerName: 'MODALITIES', field: 'modalities', chartDataType: 'category'},
        { headerName: 'MOTA', field: 'mota'},
        { headerName: 'MOTP', field: 'motp'},
        { headerName: 'AMOTA', field: 'amota', columnGroupShow: 'open'},
        { headerName: 'AMOTP', field: 'amotp', columnGroupShow: 'open'},
        { headerName: 'MOTAR', field: 'motar', columnGroupShow: 'open'},
        { headerName: 'STATE', field: 'state_report_url',
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-chart-simple"></i></a>'
          }
        },
      ]
    },
    {
      headerName: 'Link Information',
      children : [
        { headerName: 'Dateset', field: 'test_dataset_url',
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }},
        { headerName: 'Model', field: 'model_files_url', columnGroupShow: 'closed',
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i>' + params.value + '</a>'
        }},
        { headerName: 'Pico', field: 'pico_results_url', columnGroupShow: 'open',
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i></a>'
        }},
        { headerName: 'Details', field: 'result_details_url', columnGroupShow: 'open',
        cellRenderer: function(params) {
          return '<a href=' + params.value + '><i class="fa fa-database"></i></a>'
        }},
        { headerName: 'Class', field: 'nb_object_class', columnGroupShow: 'open'}
      ]
    },
    {
      headerName: 'Details Information',
      children : [
        { headerName: 'Authors', field: 'authors', columnGroupShow: 'closed'},
        { headerName: 'Description', field: 'description', columnGroupShow: 'open'}
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
  rowData: getTrackingTaskData(),
  enableCharts: true,
  chartThemes: ['ag-default-dark'],
  onFirstDataRendered: function(params) {
    createMOTPChart(params.api);
    createMOTAChart(params.api);
  },
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