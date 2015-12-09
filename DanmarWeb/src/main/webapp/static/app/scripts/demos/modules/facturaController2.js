angular
    .module('theme.demos.ng_grid', [
        'agGrid', 'theme.core.servicesFactura'
    ])
    .controller('FacturaController', ['$modal', '$scope', '$http', 'ArticuloService', 'ArticuloServiceFiltro', function($modal, $scope, $http, ArticuloService, ArticuloServiceFiltro) {
        'use strict';

        var borraProducto = true;
        var dataSource;
        var dataSourceCliente;

        var resultadoBusqueda = "";
        var modalInstance;
        var modalInstanceCliente ;


        var columnCliente = [{
            headerName: "Razon Social",
            field: "razonSocial",
            width: 150
        }];
        var columnProductos = [{
                headerName: "Articulo",
                field: "articulo",
                width: 250
            }, {
                headerName: "Codigo",
                field: "codigo",
                width: 90
            }, {
                headerName: "Precio",
                field: "precio",
                width: 90
            }


        ];
        var columnsFactura = [{
                headerName: "Articulo",
                field: "articulo",
                width: 250
            }, {
                headerName: "Codigo",
                field: "codigo",
                width: 90
            }, {
                headerName: "Precio",
                field: "precio",
                width: 90
            }, {
                headerName: "Cantidad",
                field: "canMaxima",
                width: 90,
                editable: true,
                value: 2
            },

            {
                headerName: "Acciones",
                field: "total",
                width: 100,
                cellRenderer: function(params) {
                    return '<button ng-click="borrarFila(' + params.rowIndex + ')">X</button>';
                }
            },


        ];

        init();

        function pruebaFocusFactura(event) {
        	$("#productoGrid").css("border-style","none")
        	$("#facturaGrid").css("border-style","dotted")
        	console.log("FOCUS",event)
        }
        function pruebaFocusProductos(event) {
        	
        	var valor=false
        	$("#productoGrid").css("border-style","dotted")
        	$("#facturaGrid").css("border-style","none")
        		//Le hago foco a algun elemento como para que pueda empezar a ir para abajo directamente con la flecha de abajo
        	   angular.element(angular.element('.cell-col-0')[0]).trigger('focus');
     
        }
        /*Arranque del controlador*/
        function init() {

            $scope.onKeyCliente = showClientePopup;
            $scope.guardarFactura = guardarFactura;
            $scope.borrarFila = borrarFila;
            $scope.pruebaFocusProductos = pruebaFocusProductos;
            $scope.pruebaFocusFactura = pruebaFocusFactura;

            
            //Variables que contendran la informacion para el header
            $scope.clienteSeleccionadoRazon;
            $scope.clienteSeleccionadoId;
            $scope.fechaFactura = new Date();
            $scope.subTotal =0;
            $scope.TotalFact =0;
            //Fin Variables que contendran la informacion para el header

            
            setDatasources()
            setGrids()
            setGridEvents()
            setModals()

        }
        /*Eventos de las Grillas*/

        function setGridEvents() {
            $scope.externalFilterChanged = function() {
                $scope.gridOptionsProductos.api.onFilterChanged();
            };
            $scope.busquedaCliente = function() {
                $scope.gridOptionsCliente.api.onFilterChanged();
            };

        }
        /*Setear Datasource*/

        function setDatasources() {
            var pageSize = 50;
        	
        	dataSource = {
                rowCount: null, // behave as infinite scroll
                pageSize: pageSize,
                overflowSize: 50,
                maxConcurrentRequests: 2,
                maxPagesInCache: 2,
                getRows: function(params) {
                    $scope.openDemoModal('lg');
                    console.log('asking for ' + params.startRow + ' to ' + params.endRow);

                    var start = params.startRow + 1;
                    console.log('params.endRow ' + params.endRow + ' pageSize ' + pageSize);
                    var pagina = (params.endRow / pageSize);
                    console.log('Pagina ' + pagina + ' Tamanio ' + pageSize);
                    
                    $.ajax({
                        type: 'POST',
                        url:'http://localhost:8080/DanmarWeb/articulo/searchByFiltros',
                        contentType : "application/json",
            			data :  JSON.stringify(getFiltroBusqueda(pagina,pageSize)),
            		    dataType: 'json',

                       // url: 'http://localhost:8080/DanmarWeb/articulo/findAll/' + start + '/' + params.endRow,

                        success: function(data) {
                            resultadoBusqueda = JSON.parse(angular.toJson(data))
                            modalInstance.close();
                            var rowsThisPage = resultadoBusqueda.slice(params.startRow, params.endRow);
                            var lastRow = -1;

                            params.successCallback(rowsThisPage, lastRow);

                        }
                    });
                }
            }

            dataSourceCliente = {
                rowCount: null, // behave as infinite scroll
                pageSize: 50,
                overflowSize: 50,
                maxConcurrentRequests: 2,
                maxPagesInCache: 2,
                getRows: function(params) {
                    //$scope.openDemoModal('lg');
                    console.log('asking for ' + params.startRow + ' to ' + params.endRow);
                    
                    var start = params.startRow + 1;
                    console.log('params.endRow ' + params.endRow + ' pageSize ' + pageSize);
                    var pagina = (params.endRow / pageSize);
                    console.log('Pagina ' + pagina + ' Tamanio ' + pageSize);
                    
                    $.ajax({
                        type: 'POST',
                        url:'http://localhost:8080/DanmarWeb/cliente/searchByFiltros',
                        contentType : "application/json",
            			data :  JSON.stringify(getFiltroBusquedaCliente(pagina,pageSize)),
            		    dataType: 'json',
                       // url: 'http://localhost:8080/DanmarWeb/articulo/findAll/' + start + '/' + params.endRow,

                        success: function(data) {
                            resultadoBusqueda = JSON.parse(angular.toJson(data))
                        //    modalInstance.close();
                            var rowsThisPage = resultadoBusqueda.slice(params.startRow, params.endRow);
                            var lastRow = -1;

                            params.successCallback(rowsThisPage, lastRow);
                        }                    

                    });
                }
            };
        }
        /*Setear Modals*/

        function setModals() {
            $scope.openDemoModal = function(size) {
                modalInstance = $modal.open({
                    templateUrl: 'modalTardanza.html',
                    backdrop: 'static',
                    controller: function($scope, $modalInstance) {
                        $scope.cancel = function() {
                            $modalInstance.dismiss('cancel');
                        };
                    },
                    size: size,
                });
            }
            $scope.openDemoModalCliente = function(size) {
                modalInstanceCliente = $modal.open({
                    templateUrl: 'modalBuscadorCliente.html',
                    backdrop: 'static',
                    scope: $scope,
                    controller: function($scope, $modalInstance) {
                        $scope.cancel = function() {
                            $modalInstance.dismiss('cancel');
                        };
                    },
                    size: size,
                });
            }
        }

        /*Inicializar las grillas*/

        function setGrids() {
            $scope.gridOptionsProductos = {
                columnDefs: columnProductos,
                rowSelection: 'multiple',
                rowData: null,
                enableFilter: true,
                enableServerSideFilter: true,
                virtualPaging: true, // this is important, if not set, normal paging will be done
                onSelectionChanged: seleccionCambiada,
                ready: function(api) {
                    console.log("LISTO")
                    $scope.gridOptionsProductos.api.setDatasource(dataSource);
                }
            };

            $scope.gridOptionsCliente = {
                columnDefs: columnCliente,
                rowSelection: 'multiple',
                rowData: null,
                enableFilter: true,
                enableServerSideFilter: true,
                virtualPaging: true,
                onSelectionChanged: seleccionClienteCambiada,

                ready: function(api) {
                    $scope.gridOptionsCliente.api.setDatasource(dataSourceCliente);
                }
            };

            $scope.gridOptionsFactura = {
                columnDefs: columnsFactura,
                rowSelection: 'single',
                rowData: null,
                enableFilter: true,
                onCellValueChanged: valorCeldaCambiado,
                angularCompileRows: true
            };
        }


        /*****Eventos Grillas*******/

        function rowDeselectedFunc(event) {
            // console.log("row " , event.node.data.athlete , " de-selected");
        }

        function valorCeldaCambiado() {
            // after a value changes, get the volatile cells to update
            calculateSubtotal()
            calculateTotalFact()
        }

        /*function rowSelectedFunc(event) {
                	  	$scope.seleccionados=$scope.gridOptionsProductos.api.getSelectedRows()
                  }*/
        function seleccionCambiada(event) {
            if (borraProducto == true) {

                var clonedArray = JSON.parse(JSON.stringify($scope.gridOptionsProductos.api.getSelectedRows()))
                $scope.gridOptionsFactura.api.setRowData(clonedArray);
                calculateSubtotal()
                calculateTotalFact()
            }
            borraProducto = true

        }
        function seleccionClienteCambiada(event) {
            console.log("event",event)
            modalInstanceCliente.close();
            //Seteamos el valor del cliente elegido

            $scope.clienteSeleccionadoRazon =event.selectedRows[0].razonSocial;
            //$scope.clienteSeleccionadoId = ?
        }

        //Se elimina el producto en la grilla de Factura y se deseleccionda el producto en la Grillas de "Productos",se pone
        // en boolean la variable borraProducto,porque al momento que deseleccionamos en la grilla de Productos el elemento,se llama
        //automaticamente y por el plugin,el metodo seleccionCambiada ,y no queremos que ejecute nada dentro.
        function borrarFila(data) {

            var nombreArticuloEliminar = $scope.gridOptionsFactura.rowData[data].articulo

            var arrayNodes = jQuery.extend({}, $scope.gridOptionsProductos.api.getSelectedNodes());
            var producto;


            for (producto in arrayNodes) {
                if (nombreArticuloEliminar === arrayNodes[producto].data.articulo) {

                    borraProducto = false;

                }

            }
            $scope.gridOptionsProductos.api.forEachNode(function(node) {

                if (node.data.articulo === nombreArticuloEliminar) {
                    $scope.gridOptionsProductos.api.selectionController.deselectNode(node);
                }
            });
            $scope.gridOptionsFactura.rowData.splice(data, 1);

            var newArray = $scope.gridOptionsFactura.rowData
            $scope.gridOptionsFactura.api.setRowData(newArray); //Investigar refrescar y no hacer esto
            //calculateSubtotal()
        }

        /*****FIN Eventos Grillas*******/

        /*****Calculos*******/
        function calculateSubtotal() {
            var producto;
            var subTotal = 0;
            console.log("DATA", $scope.gridOptionsFactura)
            for (producto in $scope.gridOptionsFactura.rowData) {
                subTotal = subTotal + (parseInt($scope.gridOptionsFactura.rowData[producto].canMaxima) * parseInt($scope.gridOptionsFactura.rowData[producto].precio));
            }
            $scope.subTotal = subTotal
            $scope.$apply();
        }
        
        function calculateTotalFact() {
            var producto;
//            var totalFact = 0;
            console.log("DATA", $scope.gridOptionsFactura)

            var totalFact = $scope.subTotal;
            $scope.TotalFact = totalFact
            $scope.$apply();
        }        
        /*****Otros*******/

        function showClientePopup(event) {
            $scope.openDemoModalCliente('lg');
        }


        function getFiltroBusqueda(start, end) {
            var filtro = new Object();
            filtro.cc1 = $scope.codigo1;
            filtro.cc2 = $scope.codigo2;
            filtro.cc3=$scope.codigo3;
            filtro.articulo = $scope.articulo;
            filtro.pagina = start;
            filtro.cantRegistros = end;
            return filtro;
        }

        function getFiltroBusquedaCliente(start, end) {
            var filtro = new Object();
            filtro.codigo = $scope.codigoCliente;
            filtro.razonSocial = $scope.razonSocial;
            filtro.pagina = start;
            filtro.cantRegistros = end;
            return filtro;
        }
        
    function guardarFactura(){
    	var factura
    	factura=getHeader()
    	factura.lineas=getLineas()   
    	console.log("FAC",factura)

    	$.ajax({
                        type: 'POST',
                        url:'http://localhost:8080/DanmarWeb/DocumentoEncabezado/save',
                        contentType : "application/json",
            			data :  JSON.stringify(factura),
            		    dataType: 'json',

                       // url: 'http://localhost:8080/DanmarWeb/articulo/findAll/' + start + '/' + params.endRow,

                        success: function(data) {
                            console.log("RESULETOADO",data)
                        }
                    });
    }
    //Se arma el objeto Header con la informacion.IMPORTANTE,los atributos tienen que coincidir con los atributos JAVA del objeto donde se mapearan los valores
   function getHeader(){
	   //Hay Datos que se van a crear en el Backend,como la fecha por ejemplo y el usuario
    	var header=new Object();
    	 header.idCliente=$scope.clienteSeleccionadoId;
    	 header.descripcion=$scope.descripcion;
    	 return header;
    }
   function getLineas(){
	   
	   var linea;
	   var arrayLineas=new Array();
   	console.log("LINEAS a FActurar/Iterar",$scope.gridOptionsFactura.rowData)

	     for (linea in $scope.gridOptionsFactura.rowData) {
                var lineaFacturar=new Object()
                lineaFacturar.codigo=$scope.gridOptionsFactura.rowData[linea].codigoProv
                arrayLineas.push(lineaFacturar)
            }
	   
	   return arrayLineas
   }
        //ArticuloService.query(null,function(data) {

        //var articulos=JSON.parse(angular.toJson(data))


        //$scope.gridOptionsProductos.api.setRowData(articulos);

        // } );




    }]);