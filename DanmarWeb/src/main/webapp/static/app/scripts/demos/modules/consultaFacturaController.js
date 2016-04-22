angular
    .module('theme.demos.busquedaFactura', [
        'agGrid'
    ])
    .controller('ConsultaFacturaController', ['$modal', '$scope', '$http',  function($modal, $scope, $http) {
        'use strict';
var columnFacturas = [
			{
	            headerName: "Codigo",
	            field: "id",
	            width: 90
        	} , {
                headerName: "Fecha",
                field: "fecha",
                width: 90
        	},
			{
                headerName: "Tipo",
                field: "tipoDocumentoNombre",
                width: 75
        	} , {
                headerName: "Numero",
                field: "numero",
                width: 150
        	} , {
                headerName: "Cliente",
                field: "clienteNombre",
                width: 200
        	} ,  {
                headerName: "Categoria",
                field: "clienteCategoriaNombre",
                width: 150
            },
			{
				headerName : "",
				field : "id",
				width : 30,
				cellRenderer : function(params) {
					return '<img ng-click="verFila('
							+ params.rowIndex
							+ ')" src="http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/blue-metallic-orbs-icons-people-things/061229-blue-metallic-orb-icon-people-things-eye4-sc48.png" height="22" width="22">'
					// return '<button tabindex="-1"
					// ng-click="borrarFila(' +
					// params.rowIndex +
					// ')">X</button>';
				}
			},
        ];


		var modalInstanceFactura;
		var dataSource;
		var resultadoBusqueda = "";
        init();
        
        /*Arranque del controlador*/
        function init() {

            $scope.onBusquedaFactura = keyPressBuscarFactura;
            $scope.onGetDetalleFactura=verPantallaFactura;
			$scope.verFila = verFila;
			setDatasources()
            setGrids()
			setGridEvents()

        }

		function setGrids(){
			   $scope.gridOptionsFacturas = {
                columnDefs: columnFacturas,
                rowSelection: 'single',
                rowData: null,
                enableFilter: true,
				enableServerSideFilter: true,
				angularCompileRows : true,
                virtualPaging: true, // this is important, if not set, normal paging will be done
                //onSelectionChanged: seleccionCambiada,
                ready: function(api) {
                    $scope.gridOptionsFacturas.api.setDatasource(dataSource);
                }
            };

		}

		/* Eventos de las Grillas */
		function setGridEvents() {
			$scope.externalFilterChanged = function() {
				$scope.gridOptionsFacturas.api
						.onFilterChanged();
			};
		}

		
		function setDatasources() {
								var pageSize = 50;

								dataSource = {
									rowCount : null, // behave as infinite
														// scroll
									pageSize : pageSize,
									overflowSize : 50,
									maxConcurrentRequests : 2,
									maxPagesInCache : 2,
									getRows : function(params) {

										var start = params.startRow + 1;
										var pagina = (params.endRow / pageSize);
										$.ajax({
													type : 'POST',
													url : 'documento/getFacturaAll',
													contentType : "application/json",
													data : JSON
															.stringify(getFiltroBusqueda(
																	pagina,
																	pageSize)),
													dataType : 'json',
													success : function(data) {
														resultadoBusqueda = JSON.parse(angular.toJson(data))
														var rowsThisPage = resultadoBusqueda
																.slice(
																		params.startRow,
																		params.endRow);
														var lastRow = -1;

														params.successCallback(
																rowsThisPage,
																lastRow);
												

													}
												});
									}
								}	
		}								
		function keyPressBuscarFactura(event) {
			if (event.which == 13) {
				//$scope.openDemoModalArticulo('lg');
				$scope.externalFilterChanged();
			}

		}
		/*
		function doBusqueda(){
		//			var pageSize = 50;
//			var start = params.startRow + 1;
//			var pagina = (params.endRow / pageSize);
			var tamanio = 50;
			var start = 1
			var pagina = 1;
        	callServiceBusqueda(getFiltroBusqueda(pagina,tamanio));
			//callServiceGetFactura(5);
        }*/
		
		function getFiltroBusqueda(pagina, tamanio) {

			var filtro = new Object();
			filtro.codigoFactura = $scope.facturaBusquedaCodigo;
			filtro.numeroFactura = $scope.facturaBusquedaFact;
			filtro.fechaDesde = $scope.facturaBusquedaFechaMay;
			filtro.FechaHasta = $scope.facturaBusquedaFechaMen;
			filtro.pagina = pagina;
			filtro.cantRegistros = tamanio;

			return filtro;
		}
		/*
        function callServiceBusqueda(filtro){

        	$.ajax({
                            type: 'POST',
                            url:'documento/getFacturaAll',
                            contentType : "application/json",
                			data :  JSON.stringify(filtro),
                		    dataType: 'json',

                            success: function(data) {
                            	actualizarPantalla();
                            	console.log(data)
                            }
                        });
        }*/
		function verFila(data) {
			console.log("tetaculo",data, $scope.gridOptionsFacturas)
			var facturaConsultar = $scope.gridOptionsFacturas.api.grid.rowRenderer.renderedRows[data].node.data.id;
			console.log("nana",facturaConsultar )
			callServiceGetFactura(facturaConsultar);
		}
		
        function callServiceGetFactura(codigo){

					$.ajax({
                            type: 'POST',
                            url:'documento/getFactura',
                            contentType : "application/json",
                			data :  JSON.stringify(codigo),
                		    dataType: 'json',

							complete : function(data) {

								if (data.status == 200) {
									actualizarPantallaVerFactura(data.responseJSON);
								}
							}
							
                       });
        }        
        function actualizarPantalla(){
        	alert("Traigo Facturas");
        	verPantallaFactura()
        }

        function verPantallaFactura(){

//			if (event.which == 13) {
				alert("Muestro Factura");
				$scope.openDemoModalFactura('lg');
//			}			
    	}
		
		$scope.openDemoModalFactura = function(size) {
									modalInstanceFactura = $modal
											.open({
												templateUrl : 'modalFacturaVer.html',
												backdrop : 'static',
												scope : $scope,
												controller : function($scope,
														$modalInstance) {
													$scope.cancel = function() {
														$modalInstance
																.dismiss('cancel');
													};
												},
												size : size,
											});
									modalInstanceFactura.result.then(function(
											selectedItem) {

									}, function() {
										// Se ejecuta esto cuando se presiona
										// Escape en el dialogo
//										focus($("#busquedaCliente"))
									});
		}
		
		function actualizarPantallaVerFactura(data){
			$scope.openDemoModalFactura('lg');
			console.log("quiuiq",data.numero)
			
			$scope.viewNumeroFactura= data.numero;
			$scope.viewFechaFactura = data.fecha;
			$scope.viewLetra = data.letra;
			$scope.viewTipoFactura = data.tipoDocumentoNombre;
			$scope.viewDescripcion = data.descripcion ;
			$scope.viewSubTotal = data.totalArticulos ;
			$scope.viewIvaInscriptoTotal = data.totalDocumento ;
			$scope.viewIvaNoInscripto = data.totalDocumento ;
			$scope.viewTotalFact = data.totalDocumento ;
			$scope.viewMontoEfectivo = data.pagoEfectivoMonto;
			$scope.viewTarjetaNombre = data.pagoTarjetaNombre;
			$scope.viewTarjetaRecargo = data.pagoTarjetaCoefRecargoTC;
			$scope.viewTarjetaMonto = data.pagoTarjetaMonto;
			$scope.viewTarjetaCuotas = data.pagoTarjetaCuotas;
			$scope.tarjetaMontoInteres = data.pagoTarjetaMontoConInteres;
			$scope.viewTarjetaCupon = data.pagoTarjetaCupon;
			$scope.viewClienteNombre = data.clienteNombre ;
			$scope.viewClienteCategoria = data.clienteCategoria ;
			$scope.viewClienteCuit = data.clienteCuit ;
			$scope.viewLineasProductos = data.lineas;
			
        }

		}]);
		

		