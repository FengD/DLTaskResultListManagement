const gridOptions = {
    columnDefs: [
      {
        headerName: 'Basic Infomation',
        children: [
          { headerName: 'DATE', field: 'create_time', chartDataType: 'category'},
          { headerName: 'NAME', field: 'name', chartDataType: 'category'},
          { headerName: 'MODALITIES', field: 'modalities', chartDataType: 'category'},
          { headerName: 'PROJECT_NAME', field: 'project_name', chartDataType: 'category'},
          { headerName: 'mAP', field: 'map', chartDataType: 'series', columnGroupShow: 'closed' ,
          icons: {
            sortAscending: '<i class="fa fa-sort-alpha-up"/>',
            sortDescending: '<i class="fa fa-sort-alpha-down"/>',
          },},
          { headerName: 'mATE', field: 'mate', columnGroupShow: 'open' },
          { headerName: 'mASE', field: 'mase', columnGroupShow: 'open' },
          { headerName: 'mAOE', field: 'maoe', columnGroupShow: 'open' },
          { headerName: 'mAVE', field: 'mave', columnGroupShow: 'open' },
          { headerName: 'mAAE', field: 'maae', columnGroupShow: 'open' },
          { headerName: 'NDS', field: 'nds',
          icons: {
            sortAscending: '<i class="fa fa-sort-alpha-up"/>',
            sortDescending: '<i class="fa fa-sort-alpha-down"/>',
          },},
          { headerName: 'FPS', field: 'fps', columnGroupShow: 'closed',
          icons: {
            sortAscending: '<i class="fa fa-sort-alpha-up"/>',
            sortDescending: '<i class="fa fa-sort-alpha-down"/>',
          }, },
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
            return '<a href=' + params.value + '><i class="fa fa-database"></i></a>'
          }},
          { headerName: 'Model', field: 'model_files_url', columnGroupShow: 'closed',
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i></a>'
          }},
          { headerName: 'Pico', field: 'pico_results_url', columnGroupShow: 'open',
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-database"></i></a>'
          }},
          // { headerName: 'Date', field: 'picture_link_url', columnGroupShow: 'open'}
        ]
      },
      {
        headerName: 'Details Information',
        children : [
          { headerName: 'Team', field: 'team', columnGroupShow: 'open'},
          { headerName: 'Authors', field: 'authors', columnGroupShow: 'closed'},
          { headerName: 'Affilication', field: 'affilication', columnGroupShow: 'open' },
          { headerName: 'Description', field: 'description', columnGroupShow: 'open'},
          { headerName: 'Project', field: 'project_url', columnGroupShow: 'open' ,
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-diagram-project"></i></a>'
          }},
          { headerName: 'Paper', field: 'paper_url', columnGroupShow: 'open',
          cellRenderer: function(params) {
            return '<a href=' + params.value + '><i class="fa fa-paper-plane"></i></a>'
          }}
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
  
// setup the grid after the page has finished loading
document.addEventListener('DOMContentLoaded', function () {
  var gridDiv = document.querySelector('#myGrid');
  new agGrid.Grid(gridDiv, gridOptions);
});