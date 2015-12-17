angular
    .module('theme.demos.busquedaFactura', [
        'agGrid'
    ])
    .controller('ConsultaFacturaController', ['$modal', '$scope', '$http',  function($modal, $scope, $http) {
        'use strict';
var columnFacturas = [{
	            headerName: "Codigo",
	            field: "codigo",
	            width: 150
        	} , {
                headerName: "Total",
                field: "total",
                width: 90
            },
			 {
                headerName: "Acciones",
                field: "total",
                width: 100,
                cellRenderer: function(params) {
                	return '<img ng-click="borrarFila(' + params.rowIndex + ')" src="https://cdn3.iconfinder.com/data/icons/softwaredemo/PNG/128x128/DeleteRed.png" height="22" width="22">'
                   //return '<button tabindex="-1"   ng-click="borrarFila(' + params.rowIndex + ')">X</button>';
                }
            }
        ];
        init();
        
        /*Arranque del controlador*/
        function init() {

            $scope.onBusquedaFactura = onBusquedaFactura;
            $scope.onGetDetalleFactura=onGetDetalleFactura;
           setGrids()

        }
		function setGrids(){
			   $scope.gridOptionsFacturas = {
                columnDefs: columnFacturas,
                rowSelection: 'multiple',
                rowData: null,
                enableFilter: true,
                enableServerSideFilter: true,
                virtualPaging: true, // this is important, if not set, normal paging will be done
                //onSelectionChanged: seleccionCambiada,
                ready: function(api) {
                    //$scope.gridOptionsFacturas.api.setDatasource(dataSource);
                }
            };
		}
        function onBusquedaFactura(){
        	doBusqueda(getBusquedaFiltro());
        }
        function onGetDetalleFactura(){
        	
        }
        function getBusquedaFiltro(){
        	var filtro =new Object()
        	filtro.codigo=$scope.codigo
        	return filtro
        }
        function doBusqueda(filtro){
         	
        	$.ajax({
                            type: 'POST',
                            url:'http://localhost:8080/DanmarWeb/DocumentoEncabezado/save',
                            contentType : "application/json",
                			data :  JSON.stringify(filtro),
                		    dataType: 'json',

                            success: function(data) {
                            	actualizarPantalla()
                               
                            }
                        });
        }
        function actualizarPantalla(){
        	
        }

    }]);