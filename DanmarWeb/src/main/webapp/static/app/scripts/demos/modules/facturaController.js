angular
		.module('theme.demos.ng_grid',
				[ 'agGrid', 'theme.core.servicesFactura' ])
		.controller(
				'FacturaController',
				[
						'$modal',
						'$scope',
						'$http',
						'ArticuloService',
						'ArticuloServiceFiltro',
						'$route',
						function($modal, $scope, $http, ArticuloService,
								ArticuloServiceFiltro, $route) {
							'use strict';

							$scope.estaDeshabilitado = function(e) {
								if ($scope.montoEfectivo > 0) {
									if ($scope.montoTC != 0) {
										if ($scope.cuotaSeleccionada != undefined) {
											return false
										} else {
											return true
										}
										if ($scope.cuponTC != undefined) {

											return false;
										} else {
											return true;
										}

										return false;
									} else {
										return false
									}
								} else if ($scope.montoTC != 0
										&& $scope.cuotaSeleccionada != undefined
										&& $scope.cuponTC != undefined) {

									return false
								} else {

									return true
								}

							}

							var borraProducto = true;
							var dataSource;
							var dataSourceCliente;

							var resultadoBusqueda = "";
							var modalInstance;
							var modalInstanceCliente;
							var modalInstanceArticulo;
							var modalInstanceSuccessFactura;

							var columnCliente = [ {
								headerName : "Razon Social",
								field : "razonSocial",
								width : 150
							}, {
								headerName : "codigo",
								field : "codigo",
								width : 90
							}, {
								headerName : "cuit",
								field : "cuit",
								width : 90
							}, {
								headerName : "categoria",
								field : "categoria",
								width : 90
							} ];
							var columnProductos = [ {
								headerName : "Cod",
								field : "codigo",
								width : 90
							},
							{
								headerName : "CC1",
								field : "cc1",
								width : 55
							},
							{
								headerName : "CC2",
								field : "cc2",
								width : 55
							},
							{
								headerName : "CC3",
								field : "cc3",
								width : 55
							},
							{
								headerName : "CC4",
								field : "cc4",
								width : 55
							},
							{
								headerName : "CC5",
								field : "cc5",
								width : 55
							}, {
								headerName : "Articulo",
								field : "articulo",
								width : 200
							}, {
								headerName : "Precio",
								field : "precio",
								width : 90
							}

							];
							var columnsFactura = [
									{
										headerName : "Cod",
										field : "codigo",
										width : 75
									},
									{
										headerName : "CC1",
										field : "cc1",
										width : 55
									},
									{
										headerName : "CC2",
										field : "cc2",
										width : 55
									},
									{
										headerName : "CC3",
										field : "cc3",
										width : 55
									},
									{
										headerName : "CC4",
										field : "cc4",
										width : 55
									},
									{
										headerName : "CC5",
										field : "cc5",
										width : 55
									},
							        {
										headerName : "Articulo",
										field : "articulo",
										width : 250
									},
									{
										headerName : "Qt",
										field : "canMaxima",
										width : 40,
										editable : true
									},
									{
										headerName : "Precio",
										field : "precio",
										width : 90
									},
//									{
//										headerName : "Iva",
//										valueGetter : '(getValue("canMaxima") * ctx.getNumberFrmt(getValue("precio")) *21/100)',
//										width : 90,
//										editable : true
//									},
									{
										headerName : "Total",
										field: "precioLp",
										valueGetter : 'ctx.totalReal(ctx.getNumberFrmt(getValue("precio")),getValue("canMaxima"))',
										width : 90
									},

									{
										headerName : "",
										field : "total",
										width : 30,
										cellRenderer : function(params) {
											return '<img ng-click="borrarFila('
													+ params.rowIndex
													+ ')" src="https://cdn3.iconfinder.com/data/icons/softwaredemo/PNG/128x128/DeleteRed.png" height="22" width="22">'
											// return '<button tabindex="-1"
											// ng-click="borrarFila(' +
											// params.rowIndex +
											// ')">X</button>';
										}
									},

							];

							$scope.$on('$viewContentLoaded', function() {
								console.log("termino de cargar")
							});
							init();

							function pruebaFocusFactura(event) {
								// console.log("ENRAFOC")
								// $("#productoGrid").css("border-style","none")
								// $("#facturaGrid").css("border-style","dotted")
								// Le hago foco a algun elemento como para que
								// pueda empezar a ir para abajo directamente
								// con la flecha de abajo
								// angular.element(angular.element('.cell-col-0')[0]).trigger('focus');
								// console.log("FOCUS",event)
							}

							function pruebaFocusProductos(event) {

								$scope.gridOptionsProductos.api.setFocusedCell(
										0, 0)

							}
							function pruebaLostFocusProductos(event) {
								console.log("PIEDERE")
								// $("#productoGrid").css("border-style","none")
								// $("#productoGrid").css("border-style","none")

							}

							function clienteFocus(event) {
								$("#facturaGrid").css("border-style", "none")
							}

							/* Arranque del controlador */
							function init() {

								$scope.onKeyCliente = showClientePopup;
								$scope.onKeyArticulo = showArticuloPopup;
								$scope.onKeySelectArticulo = showSelectArticuloPopup;
								$scope.guardarFactura = guardarFactura;
								$scope.borrarFila = borrarFila;
								$scope.changeEfectivo = changeEfectivo;
								$scope.seleccionConsumidorFinal = seleccionConsumidorFinal;
								$scope.clienteFocus = clienteFocus;
								$scope.pruebaFocusFactura = pruebaFocusFactura;
								$scope.pruebaFocusProductos = pruebaFocusProductos;
								$scope.pruebaLostFocusProductos = pruebaLostFocusProductos;
								$scope.obtenerAlicuotaTarjeta = obtenerAlicuotaTarjeta;
								$scope.obtenerCuotasTarjeta = obtenerCuotasTarjeta;
								$scope.cuotaChange = cuotaChange;
								$scope.calcularTC = calcularTC;
								$scope.cuotaSeleccionada;

								$scope.articuloSeleccionadoBuscar = "";
								$scope.data = {
									articulo : "",
									codigo1 : "",
									codigo2 : "",
									codigo3 : ""
								};

								// Variables que contendran la informacion para
								// el header
								$scope.clienteSeleccionadoRazon;
								$scope.clienteSeleccionadoCategoria;
								$scope.clienteSeleccionadoCuit;
								$scope.clienteSeleccionadoId;
								//Flag que se usa cuando se entra a la busqueda de articulos,si es la primera vez se posiciona en el primer lugar.Esto es para evitar que 
								//cuando se pagine ,cada vez que traigo nuevos valores se posicione en el primer lugar.Porque se posiciona luego de encontrar informacion
                                $scope.primerIngreso;
								$scope.fechaFactura = new Date();
								$scope.tipoFactura = "B";
								$scope.chkConsumidorFinal = true;
								$scope.numeroFactura = "Xxxxxxxxxxx"
								$scope.subTotal = 0;
								$scope.ivaInscripto = 0;
								obtenerAlicuotaCategoriaIvaConsumidorFinal();
								$scope.ivaInscriptoTotal = 0;
								$scope.ivaNoInscripto = 0;
								$scope.TotalFact = 0;

								// pago
								$scope.montoEfectivo = 0;
								// $scope.interesTarjeta = 0;
								$scope.selectTarjetaCredito = 0;
								$scope.montoTC = 0;
								$scope.cuotasTC = 0;
								$scope.interesTC = 0;
								// Fin Variables que contendran la informacion
								// para el header

								// Inicializo el listado de tarjetas de credito
								obtenerTarjetas();

								setDatasources()
								setGrids()
								setGridEvents()
								setModals()

							}
							/* Eventos de las Grillas */

							function setGridEvents() {
								$scope.externalFilterChanged = function() {
									$scope.gridOptionsProductos.api
											.onFilterChanged();
								};
								$scope.busquedaCliente = function() {
									$scope.gridOptionsCliente.api
											.onFilterChanged();
								};

							}
							/* Setear Datasource */

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
										// console.log('params.endRow ' +
										// params.endRow + ' pageSize ' +
										// pageSize);
										var pagina = (params.endRow / pageSize);
										// console.log('Pagina ' + pagina + '
										// Tamanio ' + pageSize);
										//debugger;
										console.log("PAGINA",pagina,"PAGESIZE",pageSize)
										$
												.ajax({
													type : 'POST',
													url : 'http://localhost:8080/DanmarWeb/articulo/searchByFiltros',
													contentType : "application/json",
													data : JSON
															.stringify(getFiltroBusqueda(
																	pagina,
																	pageSize)),
													dataType : 'json',

													// url:
													// 'http://localhost:8080/DanmarWeb/articulo/findAll/'
													// + start + '/' +
													// params.endRow,

													success : function(data) {
														// Se posiciona en el
														// INPUT de Busqueda
														// focus($("#busquedaArticulo"))

														resultadoBusqueda = JSON
																.parse(angular
																		.toJson(data))
														var rowsThisPage = resultadoBusqueda;
														var lastRow = -1;

														params.successCallback(
																rowsThisPage,
																lastRow);
														if ($scope.primerIngreso==1){
															console.log("ENTRA")
															$scope.primerIngreso=0;
															pruebaFocusProductos()
														}
														 

													}
												});
									}
								}

								dataSourceCliente = {
									rowCount : null, // behave as infinite
														// scroll
									pageSize : 50,
									overflowSize : 50,
									maxConcurrentRequests : 2,
									maxPagesInCache : 2,
									getRows : function(params) {

										var start = params.startRow + 1;
										var pagina = (params.endRow / pageSize);

										$
												.ajax({
													type : 'POST',
													url : 'http://localhost:8080/DanmarWeb/cliente/searchByFiltros',
													contentType : "application/json",
													data : JSON
															.stringify(getFiltroBusquedaCliente(
																	pagina,
																	pageSize)),
													dataType : 'json',
													// url:
													// 'http://localhost:8080/DanmarWeb/articulo/findAll/'
													// + start + '/' +
													// params.endRow,

													success : function(data) {
														resultadoBusqueda = JSON
																.parse(angular
																		.toJson(data))
														// modalInstance.close();
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
								};
							}
							/* Setear Modals */

							function setModals() {

								$scope.openDemoModalSuccessFactura = function(
										size) {

									modalInstanceSuccessFactura = $modal
											.open({
												templateUrl : 'modalFacturaGenerada.html',
												backdrop : 'static',
												scope : $scope,
												controller : function($scope,
														$modalInstance) {
													$scope.cancel = function() {
														$modalInstance
																.dismiss('cancel');
													};
													$scope.opened = function() {
														console.log("AABABAA")
													};
												},
												size : size,
											});

									modalInstanceSuccessFactura.result.then(
											function(selectedItem) {
												console.log("ABRIOOO")

											}, function() {
												// Se ejecuta esto cuando se
												// presiona Escape en el dialogo
												$route.reload();

											});
								}

								$scope.openDemoModal = function(size) {
									modalInstance = $modal.open({
										templateUrl : 'modalTardanza.html',
										backdrop : 'static',
										controller : function($scope,
												$modalInstance) {
											$scope.cancel = function() {
												$modalInstance
														.dismiss('cancel');
											};
										},
										size : size,
									});
								}
								$scope.openDemoModalCliente = function(size) {
									modalInstanceCliente = $modal
											.open({
												templateUrl : 'modalBuscadorCliente.html',
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
									modalInstanceCliente.result.then(function(
											selectedItem) {

									}, function() {
										// Se ejecuta esto cuando se presiona
										// Escape en el dialogo
										focus($("#busquedaCliente"))
									});
								}
								$scope.openDemoModalArticulo = function(size) {

									modalInstanceArticulo = $modal
											.open({
												templateUrl : 'modalBuscadorArticulo.html',
												backdrop : 'static',
												scope : $scope,
												controller : function($scope,
														$modalInstance) {
													$scope.cancel = function() {
														$modalInstance
																.dismiss('cancel');
													};
													$scope.open = function() {
														console.log("OPENARTI")
													};
												},
												size : size,
											});
									modalInstanceArticulo.result.then(function(
											selectedItem) {
										console.log("ABRIOERER")
									}, function() {
										// Se ejecuta esto cuando se presiona
										// Escape en el dialogo
										focus($("#busquedaProd"))
									});
									// Add a function for when the dialog is
									// opened
									modalInstanceArticulo.opened
											.then(function() {
												console.log("ABRIOEREROPENEd")

											})
								}

							}

							/* Inicializar las grillas */

							function setGrids() {
								$scope.gridOptionsProductos = {
									columnDefs : columnProductos,
									rowSelection : 'multiple',
									rowData : null,
									enableFilter : true,
									enableServerSideFilter : true,
									cellFocused : function() {
										console.log("CELFOC")
									},
									virtualPaging : true, // this is
															// important, if not
															// set, normal
															// paging will be
															// done
									// onSelectionChanged: seleccionCambiada,
									ready : function(api) {
										console.log("READY")
										$scope.gridOptionsProductos.api
												.setDatasource(dataSource);
									}
								};

								$scope.gridOptionsCliente = {
									columnDefs : columnCliente,
									rowSelection : 'multiple',
									rowData : null,
									enableFilter : true,
									enableServerSideFilter : true,
									virtualPaging : true,
									onSelectionChanged : seleccionClienteCambiada,

									ready : function(api) {
										$scope.gridOptionsCliente.api
												.setDatasource(dataSourceCliente);
									}
								};

								$scope.gridOptionsFactura = {
									enableCellExpressions : true,

									columnDefs : columnsFactura,
									rowSelection : 'single',
									rowData : null,
									enableFilter : true,
									context : {},
									onCellValueChanged : valorCeldaCambiado,
									angularCompileRows : true
								};
								console.log("GRID", $scope.gridOptionsFactura)
								$scope.gridOptionsFactura.context.totalReal = function(precio, cantidad) {
									var total = calculaTotalLinea(precio, cantidad);
									
									return total;
								};
								$scope.gridOptionsFactura.context.getNumberFrmt = function(
										numeroStr) {
									var rta = getNumber(numeroStr);
									console.log("salgaHermano", rta);
									return rta;
								};

							}
	
							function getIva() {
								return $scope.ivaInscripto;
							}
							
							function calculaTotalLinea(precio, cantidad) {
								var coeficienteTarjeta = 0;
									var coeficienteEfectivo = 0;
									var totalEfectivoConCoeficiente = 0;
									var totalTarjetaConCoeficiente = 0;
									var totalRealProducto = 0;
									// elimino las comas para hacer la cuenta
									precio = getNumber(precio);
									/* Se bloquea el uso de IVA para calculo de articulo
									var totalProducto = (cantidad * precio + (cantidad	* precio * (getIva() / 100) )); */
									var totalProducto = (cantidad * precio); 
									
									
									//Caso Monto tarjeta de credito con monto > 0  y cuotas no seleccionadas
									if ($scope.montoEfectivo != 0 && $scope.montoTC != 0 && $scope.cuotaSeleccionada == undefined) {
										coeficienteEfectivo = (parseFloat($scope.montoEfectivo) + parseFloat($scope.montoTC)) / getSubTotalConIva();
										totalEfectivoConCoeficiente = totalProducto	* coeficienteEfectivo;
									} else if ($scope.montoEfectivo != 0) {
										coeficienteEfectivo = $scope.montoEfectivo / getSubTotalConIva();
										totalEfectivoConCoeficiente = totalProducto	* coeficienteEfectivo;
									}

									if (coeficienteEfectivo > 0
											&& coeficienteEfectivo < 1 &&  $scope.cuotaSeleccionada != undefined) {
										coeficienteTarjeta = 1 - coeficienteEfectivo;
										var coeficienteTC = $scope.cuotaSeleccionada.coeficiente
										totalTarjetaConCoeficiente = (totalProducto - totalEfectivoConCoeficiente) * coeficienteTC;
									} else {

									}
									totalRealProducto = totalEfectivoConCoeficiente + totalTarjetaConCoeficiente

									console.log("TOTAL REl", totalRealProducto.toFixed(2), precio)
									return totalRealProducto.toFixed(2);

							}
							
							function recalculateGridProductos() {
								$scope.gridOptionsFactura.api.refreshView();
							}
							/** ***Eventos Grillas****** */

							function rowDeselectedFunc(event) {
								// console.log("row " , event.node.data.athlete
								// , " de-selected");
							}

							function valorCeldaCambiado() {

								cleanTotales();
								
								recalculateGridProductos()
								$scope.$apply() // Averiguar que hace
							}
							function valorCeldaCambiadoIva() {
								recalculateGridProductos()
								cleanTotales();
								calculateTotales()
								recalculateGridProductos()
								$scope.$apply() // Averiguar que hace
							}

							function calculateTotales() {
								obtenerTotales();
								setEfectivo()

							}
							function cleanTotales() {

								$scope.TotalFact = 0
								$scope.subTotal = 0
								$scope.montoTC = 0;
								$scope.interesTC = 0
								$scope.selectTarjetaCredito = 0;
								setEfectivo();
								$scope.cuotas = {}
								$scope.cuotaSeleccionada = undefined

							}
							/*
							 * function rowSelectedFunc(event) {
							 * $scope.seleccionados=$scope.gridOptionsProductos.api.getSelectedRows() }
							 */
							function clone(obj) {
								if (null == obj || "object" != typeof obj)
									return obj;
								var copy = obj.constructor();
								for ( var attr in obj) {
									if (obj.hasOwnProperty(attr))
										copy[attr] = clone(obj[attr]);
								}
								return copy;
							}
							// Chequea si ya existe un elemento en la tabla de
							// factura,para no agregarlo nuevamente
							function existe(arrayABuscar, codigo) {
								console.log("arrayabuscar", arrayABuscar)
								var x;
								for (x in arrayABuscar) {

									if (arrayABuscar[x].codigo == codigo) {
										return true

									}
								}
								return false
							}
							function seleccionCambiada(event) {

								var clonedArray = JSON
										.parse(JSON
												.stringify($scope.gridOptionsProductos.api
														.getSelectedRows()))
								var arrayViejo = clone($scope.gridOptionsFactura.rowData);

								var x;
								if (arrayViejo != null) {
									for (x in clonedArray) {
										if (!existe(arrayViejo,
												clonedArray[x].codigo))
											arrayViejo.push(clonedArray[x]);
									}

									$scope.gridOptionsFactura.api
											.setRowData(arrayViejo);
								} else {
									$scope.gridOptionsFactura.api
											.setRowData(clonedArray);
								}
								modalInstanceArticulo.close();
								cleanTotales()

								calculateTotales()
								recalculateGridProductos()

								focus($("#busquedaProd"))
							}
							function focus(element) {
								element.focus();
							}
							function seleccionClienteCambiada(event) {
								console.log("event", event)
								modalInstanceCliente.close();
								// Seteamos el valor del cliente elegido

								$scope.clienteSeleccionadoRazon = event.selectedRows[0].razonSocial;
								$scope.clienteSeleccionadoId = event.selectedRows[0].codigo;
								$scope.clienteSeleccionadoCuit = event.selectedRows[0].cuit;
								$scope.clienteSeleccionadoCategoria = event.selectedRows[0].categoria;

								// actualizo el Iva Inscripto
								obtenerAlicuotaCategoriaIva();

								// Actualizo la letra del tipo de Factura
								obtenerLetraCategoriaIva();

								
								$scope.chkConsumidorFinal = false;

							}


							function obtenerLetraCategoriaIvaConsumidorFinal() {
								var tipoFacturaConsumidorFinal = "B";
								$scope.tipoFactura = tipoFacturaConsumidorFinal;
							}

							function obtenerLetraCategoriaIvaByCategoria(categoria) {
								$
										.ajax({
											type : 'POST',
											url : 'http://localhost:8080/DanmarWeb/documento/getLetraCategoriaIva',
											contentType : "application/json",
											data : JSON
													.stringify(categoria),
											dataType : 'json',

											complete : function(data) {
												if (data.status = 200) {
													console.log("RES", data)
													$scope.tipoFactura = data.responseText;

												}
											}
										});

							}

							function obtenerLetraCategoriaIva() {
								 obtenerLetraCategoriaIvaByCategoria($scope.clienteSeleccionadoCategoria)
							}
							
							// Se elimina el producto en la grilla de Factura y
							// se deseleccionda el producto en la Grillas de
							// "Productos",se pone
							// en boolean la variable borraProducto,porque al
							// momento que deseleccionamos en la grilla de
							// Productos el elemento,se llama
							// automaticamente y por el plugin,el metodo
							// seleccionCambiada ,y no queremos que ejecute nada
							// dentro.
							function borrarFila(data) {

								var nombreArticuloEliminar = $scope.gridOptionsFactura.rowData[data].articulo

								var arrayNodes = jQuery.extend({},
										$scope.gridOptionsProductos.api
												.getSelectedNodes());
								var producto;

								for (producto in arrayNodes) {
									if (nombreArticuloEliminar === arrayNodes[producto].data.articulo) {

										borraProducto = false;

									}

								}
								$scope.gridOptionsProductos.api
										.forEachNode(function(node) {

											if (node.data.articulo === nombreArticuloEliminar) {
												$scope.gridOptionsProductos.api.selectionController
														.deselectNode(node);
											}
										});
								$scope.gridOptionsFactura.rowData.splice(data,
										1);

								var newArray = $scope.gridOptionsFactura.rowData
								$scope.gridOptionsFactura.api
										.setRowData(newArray); // Investigar
																// refrescar y
																// no hacer esto
								cleanTotales()
								calculateTotales()
								recalculateGridProductos()
							}

							/** ***FIN Eventos Grillas****** */

							/** ***Calculos****** */
							function obtenerTotales() {
								console.log("Calcula Totales")
								calculateSaldosTotales();
							}
							function setEfectivo() {
								console.log("Actualiza el monto de efectivo")
								$scope.montoEfectivo = getTotal();
							}
							/* Se bloquea el uso de IVA para calculo de articulo
							function getResultadoConIva(valor) {
								return valor + valor * getIva() / 100;
							}*/

							function calculateSaldosTotales() {
								var producto;
								var total = 0;

								for (producto in $scope.gridOptionsFactura.rowData) {
									total = total
											+ (parseInt($scope.gridOptionsFactura.rowData[producto].canMaxima) * parseInt(getNumber($scope.gridOptionsFactura.rowData[producto].precio)));
								}
								//Agrego que el subtotal sea el total menos el IVA
								var ivaTotal = calculaIva(total);
								setIvaInscriptoTotal(ivaTotal)

								//Calculo el sub total
								var subTotal = (total - ivaTotal);
								setSubTotal(subTotal);

								//Calculo el Total
								var subTotal = (total - ivaTotal);
								setSubTotal(subTotal);
								
								//Sumo los intereses al subtotal para obtener el total
								var totalFact = sumoInteresTarjetaAlTotalFactura(total);
								setTotal(totalFact);
								
							}
							
							function sumoInteresTarjetaAlTotalFactura(totalSinTarjeta) {
								var totalFact = totalSinTarjeta;
								
								if ($scope.montoTC > 0 && $scope.interesTC > 0) {
									// totalFact = totalFact + (
									// ($scope.interesTarjeta * $scope.montoTC *
									// $scope.cuotasTC) - $scope.montoTC) ;
									totalFact = parseFloat(totalFact) + (parseFloat($scope.interesTC) - $scope.montoTC)
								}
								
								return totalFact;
							}
							
							
							function setIvaInscriptoTotal(ivaTotal) {
								$scope.ivaInscriptoTotal = parseFloat(ivaTotal).toFixed(2);
							}

							function getIvaInscriptoTotal() {
								return parseFloat($scope.ivaInscriptoTotal);
							}
							
							function setSubTotal(subTotal) {
								$scope.subTotal = parseFloat(subTotal).toFixed(2);
							}
							function getSubTotal() {
								return parseFloat($scope.subTotal);
							}


							function setTotal(total) {
								$scope.TotalFact = parseFloat(total).toFixed(2);
							}
				
							function getTotal() {
								return parseFloat($scope.TotalFact);
							}

							function getSubTotalConIva() {
								return parseFloat(getSubTotal() + getIvaInscriptoTotal() );
							}

							
							function calculaIva(valor) {
								return valor * getIva() / 100;
							}

							function getNumber(strNumber) {
								var rta = strNumber.replace(",", "");
								return rta;
							}
							function calculateTotalFact() {
								var producto;
								// var totalFact = 0;

								var totalFact = $scope.montoEfectivo;
								if ($scope.ivaInscripto > 0) {
									console
											.log("Comento porque el total en efectivo ya tiene el iva")
									// totalFact = totalFact + (totalFact *
									// ($scope.ivaInscripto / 100));
								}
								if ($scope.interesTC > 0) {
									// totalFact = totalFact + (
									// ($scope.interesTarjeta * $scope.montoTC *
									// $scope.cuotasTC) - $scope.montoTC) ;
									console.log("ENTRA Interes",
											$scope.interesTC, totalFact);

									totalFact = parseFloat(totalFact)
											+ parseFloat($scope.interesTC) 
									console.log("TOTAL FAc", totalFact)
								}

								//Sumo los intereses al total
								totalFact = totalFact + $scope.ivaInscriptoTotal;
								
								$scope.TotalFact = parseFloat(totalFact)
										.toFixed(2)
								// $scope.$apply();
							}

							function calcularTC() {
								obtenerCuotasTarjeta();

							}

							/** ***Otros****** */

							function showClientePopup(event) {
								if (event.which == 13) {
									$scope.openDemoModalCliente('lg');
								}
							}

							function showArticuloPopup(event) {
								$scope.data.articulo = $scope.articuloSeleccionadoBuscar;
								if (event.which == 13) {
									$scope.articuloSeleccionadoBuscar = "";
									$scope.primerIngreso=1;
									$scope.openDemoModalArticulo('lg');
								}

							}
							function showSelectArticuloPopup(event) {
								seleccionCambiada(event);
							}

							function getFiltroBusqueda(start, end) {
								var filtro = new Object();
								filtro.cc1 = $scope.data.codigo1;
								filtro.cc2 = $scope.data.codigo2;
								filtro.cc3 = $scope.data.codigo3;
								filtro.articulo = $scope.data.articulo;
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

							function guardarFactura() {
								var factura
								factura = getHeader()
								factura.lineas = getLineas();
								factura.pagos = getPagos();
								console.log("FAC", factura)

								$
										.ajax({
											type : 'POST',
											url : 'http://localhost:8080/DanmarWeb/Documento/save',
											contentType : "application/json",
											data : JSON.stringify(factura),
											dataType : 'json',

											complete : function(data) {
												if (data.status = 200) {
													console.log("RES", data)
													$scope.numeroFactura = data.responseText;
													$scope
															.openDemoModalSuccessFactura('lg');
												}

											}
										});
							}

							function obtenerAlicuotaCategoriaIvaByCategoria(categoria) {
								$
										.ajax({
											type : 'POST',
											url : 'http://localhost:8080/DanmarWeb/documento/getAlicuotaCategoriaIva',
											contentType : "application/json",
											data : JSON
													.stringify(categoria),
											dataType : 'json',

											success : function(data) {
												resultadoBusqueda = JSON
														.parse(angular
																.toJson(data))
												$scope.ivaInscripto = data;
												//actualizo grilla de alicuota
												valorCeldaCambiado();
																
											}
										});
							}
							function obtenerAlicuotaCategoriaIva() {
								obtenerAlicuotaCategoriaIvaByCategoria($scope.clienteSeleccionadoCategoria);
							}


							function obtenerAlicuotaCategoriaIvaConsumidorFinal() {
								obtenerAlicuotaCategoriaIvaByCategoria(1);
				
							}

							function cuotaChange() {

								calculateInteresTotalCuotas()
								recalculateGridProductos()

							}
							function calculateInteresTotalCuotas() {
								console.log("CUOTACHANGE",
										$scope.cuotaSeleccionada)

								if ($scope.cuotaSeleccionada != undefined) {
									var test = $scope.cuotaSeleccionada.coeficiente;
									$scope.interesTC = ($scope.montoTC * test)
											.toFixed(2);
								}
									console.log("INTEREs", $scope.interesTC)
									obtenerTotales();
								
							}

							function obtenerCuotasTarjeta() {
								// $scope.interesTarjeta=0;
								console.log("TARJETA CHANGE ",
										$scope.selectTarjetaCredito.codigo);
								

									var tarjeta = new Object()
									tarjeta.codigo = $scope.selectTarjetaCredito.codigo;
									tarjeta.monto = $scope.montoTC;
									var codigoTarjeta = $scope.selectTarjetaCredito.codigo;

									$
											.ajax({
												type : 'POST',
												url : 'http://localhost:8080/DanmarWeb/tarjeta/getCuotas',
												contentType : "application/json",
												data : JSON.stringify(tarjeta),
												dataType : 'json',

												success : function(data) {
													resultadoBusqueda = JSON
															.parse(angular
																	.toJson(data))
													// selecciono la cuotra 1
													$scope.cuotasTC = 1;
													$scope.cuotas = resultadoBusqueda;
													obtenerTarjetas() 
													console.log($scope.cuotas);
													// $scope.tipoFactura = data;
												}
											});
							}

							function obtenerTarjetas() {
								console.log("Lee tarjetas");
								$
										.ajax({
											type : 'POST',
											url : 'http://localhost:8080/DanmarWeb/tarjeta/getTarjetas',
											contentType : "application/json",
											dataType : 'json',

											complete : function(data) {
												if (data.status == 200) {
													// resultadoBusqueda =
													// data.responseText;
													console.log("DATA ARjeta",data)
													resultadoBusqueda = data.responseJSON;
													$scope.tarjetasList = resultadoBusqueda;

													console.log($scope.tarjetasList);
												}
											}
										});
							}

							function obtenerAlicuotaTarjeta() {
								console.log("PASSS")
								var tarjeta = new Object();
								tarjeta.codigo = $scope.selectTarjetaCredito.codigo;
								tarjeta.cuotas = $scope.cuotasTC;

								$
										.ajax({
											type : 'POST',
											url : 'http://localhost:8080/DanmarWeb/tarjeta/getAlicuota',
											contentType : "application/json",
											data : JSON.stringify(tarjeta),
											dataType : 'json',

											success : function(data) {
												resultadoBusqueda = JSON
														.parse(angular
																.toJson(data))
												$scope.interesTC = data;
												calcularTC();
											}
										});
							}

							// Se arma el objeto Header con la
							// informacion.IMPORTANTE,los atributos tienen que
							// coincidir con los atributos JAVA del objeto donde
							// se mapearan los valores
							function getHeader() {
								// Hay Datos que se van a crear en el
								// Backend,como la fecha por ejemplo y el
								// usuario
								var header = new Object();
								console.log("CLICLIEEENTEEE",$scope.clienteSeleccionadoId);
								
								header.clienteNro = $scope.clienteSeleccionadoId;
								header.letra = $scope.tipoFactura;

								header.clienteNro = "1";
								header.descripcion = $scope.facturaNotas;
								return header;
							}
							function getLineas() {

								var linea;
								var arrayLineas = new Array();
								console.log("LINEAS a FActurar/Iterar",
										$scope.gridOptionsFactura.rowData)

								for (linea in $scope.gridOptionsFactura.rowData) {
									var lineaFacturar = new Object()
									console.log("Ale: aca trae quiqui23---- ", $scope.gridOptionsFactura.rowData[linea]);
									lineaFacturar.articuloId = $scope.gridOptionsFactura.rowData[linea].codigo;
									lineaFacturar.precioUnitario = $scope.gridOptionsFactura.rowData[linea].precio;
									lineaFacturar.precio = calculaTotalLinea($scope.gridOptionsFactura.rowData[linea].precio,$scope.gridOptionsFactura.rowData[linea].canMaxima);
									lineaFacturar.cantidad = $scope.gridOptionsFactura.rowData[linea].canMaxima
									arrayLineas.push(lineaFacturar)
								}
								console.log("Ale: aca trae---- " + arrayLineas);
								return arrayLineas;
							}

							function getPagos() {

								var pago;
								var arrayPagoss = new Array();
								// validacion a tener en cuenta para la tarjeta
								// de credito
								// if (($scope.selectTarjetaCredito = 0) &&
								// ($scope.montoTC != 00) && ($scope.cuotasTC !=
								// 00)){
								// var pagoFacturar=new Object()
								// pagoFacturar.tipoPago = 2;
								// pagoFacturar.importe=$scope.montoEfectivo;
								// arrayPagoss.push(pagoFacturar)
								// }

								if (($scope.montoTC > 0)) {
									var pagoFacturar = new Object()

									pagoFacturar.tipoPago = "TC";
									pagoFacturar.importe = $scope.montoTC;
									pagoFacturar.cuotas = $scope.cuotaSeleccionada.cuotas;
									console.log("cocoroco",$scope.cuotasTC);
									pagoFacturar.coeficiente = $scope.cuotaSeleccionada.coeficiente;
									pagoFacturar.cupon = $scope.cuponTC;
									pagoFacturar.tarjeta = $scope.selectTarjetaCredito.codigo;
									arrayPagoss.push(pagoFacturar)
								}
								if (($scope.montoEfectivo > 0)) {

									var pagoFacturar = new Object()
									pagoFacturar.tipoPago = "EF";
									pagoFacturar.importe = $scope.montoEfectivo;
									arrayPagoss.push(pagoFacturar)
								}

								return arrayPagoss;
							}

							function changeEfectivo() {
								// $scope.montoTC=$scope.TotalFact
								// -$scope.montoEfectivo;
								var nuevoMonto = parseFloat(getTotal() - $scope.montoEfectivo).toFixed(2); ;
										
								if (nuevoMonto >= 0){
									$scope.montoTC = nuevoMonto;
								} else {
									$scope.montoTC = 0;
									$scope.interesTC = 0
									$scope.selectTarjetaCredito = 0;
									$scope.cuotas = {};
								} 
								
								console.log("ChangeEfec", $scope.montoTC)
								if ($scope.montoTC > 0) {
									cuotaChange()
									// obtenerCuotasTarjeta()
								}
								recalculateGridProductos()
							}
							
							function seleccionConsumidorFinal() {
								if ($scope.chkConsumidorFinal == true){
									// Borro cliente seleccionado
									$scope.clienteSeleccionadoRazon = "";
									$scope.clienteSeleccionadoId = -1;
									$scope.clienteSeleccionadoCuit = "";
									$scope.clienteSeleccionadoCategoria = "";

									// Actualizo la letra del tipo de Factura
									// CONSUMIDOR FINAL

									obtenerAlicuotaCategoriaIvaConsumidorFinal();
									// Actualizo la letra del tipo de Factura
									// CONSUMIDOR FINAL
									obtenerLetraCategoriaIvaConsumidorFinal();


									$scope.chkConsumidorFinal = true;
								}

							}
							function estaHabilitadoGuardar() {

							}
/*
							function actualizarGrilla() {
								$scope.onDoubleJillian = function() {
								// at the end of the update below, this array will
								// have all of the items that we updated
								var updatedNodes = [];
								// look for all the 'Jillian' nodes
								gridOptionsFactura.api.forEachNode( function(node) {
									var data = node.data;
									if (data.owner == 'Jillian') {
										// we found a Jilly node!!!
										data.price *= 2;
										updatedNodes.push(node);
									}
									});
									// now tell the grid it needs refresh all these rows
									gridOptionsFactura.api.refreshRows(updatedNodes);
								};
								
								for (linea in $scope.gridOptionsFactura.rowData) {
									var lineaFacturar = new Object()
									console.log("Ale: aca trae quiqui23---- ", $scope.gridOptionsFactura.rowData[linea]);
									lineaFacturar.articuloId = $scope.gridOptionsFactura.rowData[linea].codigo;
									lineaFacturar.precioUnitario = $scope.gridOptionsFactura.rowData[linea].precio;
									lineaFacturar.precio = calculaTotalLinea($scope.gridOptionsFactura.rowData[linea].precio,$scope.gridOptionsFactura.rowData[linea].canMaxima);
									lineaFacturar.cantidad = $scope.gridOptionsFactura.rowData[linea].canMaxima
									arrayLineas.push(lineaFacturar)
								}

							}*/

							

		
		

						} ]);