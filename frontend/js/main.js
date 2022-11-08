const gridOptions = {
    columnDefs: [
      {
        headerName: 'Basic Infomation',
        children: [
          { headerName: 'Date', field: 'create_time', chartDataType: 'category'},
          { field: 'name', chartDataType: 'category'},
          { field: 'modalities', chartDataType: 'category'},
          { field: 'map', chartDataType: 'series', columnGroupShow: 'closed' },
          { field: 'mate', columnGroupShow: 'open' },
          { field: 'mase', columnGroupShow: 'open' },
          { field: 'maoe', columnGroupShow: 'open' },
          { field: 'mave', columnGroupShow: 'open' },
          { field: 'maae', columnGroupShow: 'open' },
          { field: 'nds', columnGroupShow: 'closed' },
          { field: 'fps', columnGroupShow: 'closed' },
          { field: 'state_report_url', columnGroupShow: 'closed' },
        ]
      },
      {
        headerName: 'Link Information',
        children : [
          { field: 'test_dataset_url', columnGroupShow: 'open'},
          { field: 'model_files_url', columnGroupShow: 'closed'},
          { field: 'pico_results_url', columnGroupShow: 'open'},
          { field: 'picture_link_url', columnGroupShow: 'open'}
        ]
      },
      {
        headerName: 'Details Information',
        children : [
          { headerName: 'Team', field: 'team', columnGroupShow: 'open'},
          { field: 'authors', columnGroupShow: 'closed'},
          { field: 'affilication', columnGroupShow: 'open' },
          { field: 'description', columnGroupShow: 'open'},
          { field: 'project_url', columnGroupShow: 'open' },
          { field: 'paper_url', columnGroupShow: 'open'}
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
    rowData: getData(),
    enableCharts: true,
    chartThemes: ['ag-default-dark'],
    onFirstDataRendered: onFirstDataRendered,
  };
  
  function onFirstDataRendered(params) {
    createMAPChart(params.api);
    createNDSChart(params.api);
    createFPSChart(params.api);
  }
  
function createMAPChart(gridApi) {
  gridApi.createCrossFilterChart({
    chartType: 'line',
    cellRange: {
      columns: ['name', 'map'],
    },
    aggFunc: 'count',
    chartThemeOverrides: {
      common: {
        title: {
          enabled: true,
          text: 'Model Name and mAP',
        },
        legend: {
          enabled: false
        },
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
    aggFunc: 'count',
    chartThemeOverrides: {
      common: {
        title: {
          enabled: true,
          text: 'Model Name and NDS',
        },
        legend: {
          enabled: false
        },
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
    aggFunc: 'count',
    chartThemeOverrides: {
      common: {
        title: {
          enabled: true,
          text: 'Model Name and FPS',
        },
        legend: {
          enabled: false
        },
      }
    },
    chartContainer: document.querySelector('#fps-chart'),
  });
}
  
// setup the grid after the page has finished loading
document.addEventListener('DOMContentLoaded', function () {
  var gridDiv = document.querySelector('#myGrid');
  new agGrid.Grid(gridDiv, gridOptions);
});