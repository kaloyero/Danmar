angular
    .module('theme.demos.ng_grid', ['agGrid'])
    .controller(
        'FacturaController', [
            '$modal',
            '$scope',
            '$http',
            '$route', '$timeout',
            function($modal, $scope, $http, $route, $timeout) {
                'use strict';

                $scope.estaDeshabilitado = function(e) {
                    if ($scope.TotalFact >= 1000 && $scope.chkConsumidorFinal == true) {
                        if ($scope.nombreConsumidorFinal == "" || $scope.documentoConsumidorFinal == "") {

                            return true
                        }
                    }
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
                    } else if ($scope.montoTC != 0 &&
                        $scope.cuotaSeleccionada != undefined &&
                        $scope.cuponTC != undefined) {

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

                var columnCliente = [{
                    headerName: "codigo",
                    field: "codigo",
                    width: 120
                }, {
                    headerName: "Razon Social",
                    field: "razonSocial",
                    width: 350
                }, {
                    headerName: "cuit",
                    field: "cuit",
                    width: 150
                }, {
                    headerName: "categoria",
                    field: "categoria",
                    width: 200
                }];
                var columnProductos = [{
                        headerName: "Cod",
                        field: "codigo",
                        width: 100
                    }, {
                        headerName: "Cod Prov",
                        field: "cc1",
                        width: 70
                    }, {
                        headerName: "CC2",
                        field: "cc2",
                        width: 70
                    }, {
                        headerName: "CC3",
                        field: "cc3",
                        width: 70
                    }, {
                        headerName: "CC4",
                        field: "cc4",
                        width: 70
                    }, {
                        headerName: "CC5",
                        field: "cc5",
                        width: 70
                    }, {
                        headerName: "Articulo",
                        field: "articulo"
                    }, {
                        headerName: "Precio",
                        field: "precio",
                        width: 100,
                        cellClass: "text-right"
                    }

                ];
                var columnsFactura = [{
                        headerName: "Cod",
                        field: "codigoFormateado",
                        width: 110,
                        valueGetter: 'ctx.formatearCodigo(getValue("cc1"),getValue("cc2"),getValue("cc3"),getValue("cc4"),getValue("cc5"))',

                    }, {
                        headerName: "Cod Pro",
                        field: "cc1",
                        width: 55,
                        hide: true
                    }, {
                        headerName: "CC2",
                        field: "cc2",
                        width: 55,
                        hide: true

                    }, {
                        headerName: "CC3",
                        field: "cc3",
                        hide: true
                    }, {
                        headerName: "CC4",
                        field: "cc4",
                        hide: true
                    }, {
                        headerName: "CC5",
                        field: "cc5",
                        hide: true
                    }, {
                        headerName: "Articulo",
                        field: "articulo",
                        width: 300,
                        cellClass: "text-left"
                    }, {
                        headerName: "Cant",
                        field: "canMaxima",
                        width: 100,
                        cellClass: "text-right",
                        editable: true
                    }, {
                        headerName: "Precio",
                        field: "precio",
                        width: 90,
                        editable: true,
                        cellClass: "text-right"
                    }, {
                        headerName: "Precio Final",
                        field: "precioFinal",
                        width: 120,
                        cellClass: "text-right",
                        valueGetter: 'ctx.calcularPrecioFinal(ctx.getNumberFrmt(getValue("precioLp")),getValue("canMaxima"))',

                    },
                    //									{
                    //										headerName : "Iva",
                    //										valueGetter : '(getValue("canMaxima") * ctx.getNumberFrmt(getValue("precio")) *21/100)',
                    //										width : 90,
                    //										editable : true
                    //									},
                    /*{
                    	headerName : "Total Lista",
                    	field: "precioTl",
                    	valueGetter : 'ctx.fnTotalPrecioLista(ctx.getNumberFrmt(getValue("precio")),getValue("canMaxima"))',
                    	width : 90
                    },*/
                    {
                        headerName: "Total",
                        field: "precioLp",
                        valueGetter: 'ctx.totalReal(ctx.getNumberFrmt(getValue("precio")),getValue("canMaxima"))',
                        width: 90,
                        cellClass: "text-right"
                    }, {
                        headerName: "",
                        field: "total",
                        width: 30,
						editable:function(params){
							console.log("HEYPara",params)
							borrarFila(params.rowIndex)
						},
                        cellClass: "text-right",
                        cellRenderer: function(params) {
                            return '<img ng-click="borrarFila(' +
                                params.rowIndex +
                                ')" src="https://cdn3.iconfinder.com/data/icons/softwaredemo/PNG/128x128/DeleteRed.png" height="22" width="22">'
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
				
                    if ($scope.focusedFactura == true) {
                        $timeout(function() {
                            $('#botonBorrarArticulos').focus();
                        });
                        $scope.focusedFactura = false
                    } else {

                        $scope.focusedFactura = true
                        $scope.gridOptionsFactura.api.setFocusedCell(0, 0)
                    }


                    //$scope.gridOptionsFactura.api.setFocusedCell(0, 0)

                    // $("#productoGrid").css("border-style","none")
                    // $("#facturaGrid").css("border-style","dotted")
                    // Le hago foco a algun elemento como para que
                    // pueda empezar a ir para abajo directamente
                    // con la flecha de abajo
                    // angular.element(angular.element('.cell-col-0')[0]).trigger('focus');
                    // console.log("FOCUS",event)
                }

                function onClienteFocus(event, status) {
					//angular.element('.ag-row-selected').removeClass("ag-row-selected")
				$scope.gridOptionsCliente.api.deselectAll()
                    $scope.va = "true"
                    $timeout(function() {
                        // anything you want can go here and will safely be run on the next digest.
						if (status == "noinit") {
							if ($scope.isBusquedaClientes==true){
								$scope.isBusquedaClientes=false
								$scope.gridOptionsCliente.api.setFocusedCell(0, 0)
					
							}
							$scope.focusedClientes = true
							

						}
						
						
                        if (status == "init") {
                            $scope.focusedClientes = true
                            $scope.focusedClientesJustAdded = true
                            $scope.gridOptionsCliente.api.setFocusedCell(0, 0)
                        } else if (status == "focus") {
                            if ($scope.focusedClientes == true) {
                                $timeout(function() {
                                    $('#numeroCuit').focus();
                                });
                                $scope.focusedClientes = false
                            } else {

                                $scope.focusedClientes = true
                                $scope.gridOptionsCliente.api.setFocusedCell(0, 0)


                            }

                        }
                    })
                    console.log("FINAL", $scope.focusedClientes)
                }
                //$scope.$apply(function(){$scope.focusedClientes=true});

                /* if (status=="init"){
                	 console.log("INIT")
                	 $scope.focusedClientes=true
                	   $scope.focusedClientesJustAdded=true
                		$scope.gridOptionsCliente.api.setFocusedCell(0, 0)
                 }else{
                	if ($scope.focusedClientes==true){
                		console.log("IGUALIGUAL")
                	  $timeout(function() {$('#numeroCuit').focus(); });
                		$scope.focusedClientes=false
                	}else{
                		
                		$scope.focusedClientes=true
                		$scope.gridOptionsCliente.api.setFocusedCell(0, 0)
                		
                	
                 }} */

                function pruebaFocusProductos(event, status) {
                 
					//angular.element('.ag-row-selected').removeClass("ag-row-selected")
					console.log("STATUS",status)
		
																


                    $timeout(function() {
						if (status == "noinit") {
							if ($scope.externalFilterSearch==true){
								console.log("ENTR",$scope.externalFilterSearch)
								$scope.externalFilterSearch=false;
								$scope.gridOptionsProductos.api.deselectAll()
								$scope.focusedProductos = true
								$scope.gridOptionsProductos.api.setFocusedCell(0, 0)
								selectOldProducts()
							}
							 //$scope.gridOptionsProductos.api.setFocusedCell(0, 0)
							//console.log($scope.gridOptionsProductos.api.getFocusedCell())
							//var currentRow=$scope.gridOptionsProductos.api.getFocusedCell()
							 //$scope.gridOptionsProductos.api.deselectAll()
							   //$scope.gridOptionsProductos.api.setFocusedCell(currentRow.rowIndex, currentRow.colIndex)

						}
                        if (status == "init") {
                            console.log("INIT")
                            $scope.focusedProductos = true
                            $scope.focusedProductosJustAdded = true

                            $scope.gridOptionsProductos.api.setFocusedCell(0, 0)
                        } else if (status == "focus") {
							console.log("ELSE")
                            if ($scope.focusedProductos == true) {
                                console.log("IGUALIGUAL")
                                $timeout(function() {
                                    $('#busquedaArticulo').focus();
                                });
                                $scope.focusedProductos = false
                            } else {

                                $scope.focusedProductos = true
                                $scope.gridOptionsProductos.api.setFocusedCell(0, 1)

                            }
                        }
						
                    })
                }

                function focusOnFilter() {
                    //No se porque el Timeout,investigar.Angular lo necesita asi.
                    $timeout(function() {
                        $('#cc1').focus();
                    });
                }

                function pruebaFocusCliente(event) {

                    $scope.gridOptionsCliente.api.setFocusedCell(
                        0, 0)

                }

                function pruebaLostFocusProductos(event) {
                    $scope.focusedFactura = false
                        // $("#productoGrid").css("border-style","none")
                        // $("#productoGrid").css("border-style","none")

                }

                function clienteFocus(event) {
                    //$("#facturaGrid").css("border-style", "none")
                    $scope.focusedFactura = false
					$scope.focusedBorrarTodos = true
                }

                function lostGridProductosFocus(event) {
                    //$("#facturaGrid").css("border-style", "none")
                    console.log("LOSTGRID")
                    $scope.focusedProductos = false
                }

                function lostFocusSpecial(event) {
                    //Cuando pierde el Foco,siempre ir al campo Articulo,ya que si lo pierde para adelante
                    //Osea con TAB,no hay nada adelante.
                    console.log("LOSSPECIAL", $scope.focusedProductosJustAdded)
                        //Hago esto raro,porque apenas selecciono el elemento,selecciono la primera fila,y toma como que se deselcciono
                    if ($scope.focusedProductosJustAdded == true) {
                        //$scope.focusedProductosJustAdded=false
                    } else {
                        //$scope.focusedProductos=false
                        //$timeout(function() {$('#busquedaArticulo').focus(); });
                    }


                }

                /* Arranque del controlador */
                function init() {
				
                    $scope.onKeyCliente = showClientePopup;
                    $scope.onKeyArticulo = showArticuloPopup;
                    $scope.borrarArticulosTodos = borrarArticulosTodos;
                    $scope.onKeySelectArticulo = showSelectArticuloPopup;
                    $scope.seleccionClienteCambiada = seleccionClienteCambiada
                    $scope.guardarFactura = guardarFactura;
                    $scope.borrarFila = borrarFila;
                    $scope.changeEfectivo = changeEfectivo;
                    $scope.seleccionConsumidorFinal = seleccionConsumidorFinal;
                    $scope.clienteFocus = clienteFocus;
                    $scope.lostGridProductosFocus = lostGridProductosFocus
                    $scope.lostFocusSpecial = lostFocusSpecial
                    $scope.pruebaFocusFactura = pruebaFocusFactura;
                    $scope.pruebaFocusProductos = pruebaFocusProductos;
                    $scope.onClienteFocus = onClienteFocus
                    $scope.onFocusTipoDocumento = onFocusTipoDocumento
                    $scope.pruebaLostFocusProductos = pruebaLostFocusProductos;
                    $scope.obtenerAlicuotaTarjeta = obtenerAlicuotaTarjeta;
                    $scope.obtenerCuotasTarjeta = obtenerCuotasTarjeta;
                    $scope.cuotaChange = cuotaChange;
                    $scope.calcularTC = calcularTC;
                    $scope.checkClient = checkClient;
                    $scope.nombreConsumidorFinal = "";
                    $scope.documentoConsumidorFinal = "";
                    $scope.focusedFactura = false
                    $scope.focusedProductos = false
                    $scope.focusedClientes = false
                    $scope.focusedClientesJustAdded = false
					$scope.arrayPruebas=new Object()
					$scope.arrayPruebasClientes=new Object()
					$scope.selectOldProducts=selectOldProducts

                    $scope.focusedProductosJustAdded = false
                    $scope.isShowingArticuloPopup = false
                    $scope.isShowingClientePopup = false


                    $scope.cuotaSeleccionada;
                    $scope.articuloSeleccionadoBuscar = "";
                    $scope.data = {
                        articulo: "",
                        codigo1: "",
                        codigo2: "",
                        codigo3: ""
                    };
                    $scope.dataCliente = {
                        razonSocial: "",
                        codigo: ""
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
					$scope.focusedBusqueda=true

                    $scope.fechaFactura = new Date();
                    $scope.tipoFactura = "B";
                    $scope.chkConsumidorFinal = true;
                    $scope.numeroFactura = "Xxxxxxxxxxx"
                    $scope.recargoTC = "";
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
                    $scope.totalPrecioLista = 0;
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
					 focus($("#busquedaProd"))

                }
                /* Eventos de las Grillas */
				function selectOldProducts(){
					console.log("ARRAY PRO",$scope.arrayPruebas)
					$scope.gridOptionsProductos.api.forEachNode( function (node) {
						console.log("RE",$scope.arrayPruebas[node.data.codigo])
						if ($scope.arrayPruebas[node.data.codigo]!=undefined){
							console.log("ENRAAAA")
							$scope.gridOptionsProductos.api.selectNode(node, true);
						}
						//console.log("RE",$scope.arrayPruebas[node.data.codigo])
							
					});
				}
                function setGridEvents() {
                    $scope.externalFilterChanged = function() {
						
                        if ((event instanceof MouseEvent) || (event instanceof KeyboardEvent && event.code == "Enter")) {
							console.log("FILTERCH")
							$scope.externalFilterSearch=true;
                            $scope.gridOptionsProductos.api.onFilterChanged();
                        };
                    }
                    $scope.busquedaCliente = function() {
                        if ((event instanceof MouseEvent) || (event instanceof KeyboardEvent && event.code == "Enter")) {
							$scope.isBusquedaClientes=true;
                            $scope.gridOptionsCliente.api.onFilterChanged();
                        }
                    };

                }
                /* Setear Datasource */

                function setDatasources() {
                    var pageSize = 60;

                    dataSource = {
                        rowCount: null, // behave as infinite
                        // scroll
                        pageSize: pageSize,
                        overflowSize: 50,
                        maxConcurrentRequests: 2,
                        maxPagesInCache: 60,
                        getRows: function(params) {

                            var start = params.startRow + 1;
                            // console.log('params.endRow ' +
                            // params.endRow + ' pageSize ' +
                            // pageSize);
                            var pagina = (params.endRow / pageSize);
                            // console.log('Pagina ' + pagina + '
                            // Tamanio ' + pageSize);
                            console.log("PAGINA", pagina, "PAGESIZE", pageSize, params.endRow)
                            $
                                .ajax({
                                    type: 'POST',
                                    url: 'articulo/searchByFiltros',
                                    contentType: "application/json",
                                    data: JSON
                                        .stringify(getFiltroBusqueda(
                                            pagina,
                                            pageSize)),
                                    dataType: 'json',

                                    // url:
                                    // 'articulo/findAll/'
                                    // + start + '/' +
                                    // params.endRow,

                                    success: function(data) {
                                        // Se posiciona en el
                                        // INPUT de Busqueda
                                        // focus($("#busquedaArticulo"))
										
                                        resultadoBusqueda = JSON
                                            .parse(angular
                                                .toJson(data.lista))
                                        var rowsThisPage = resultadoBusqueda;
                                        var lastRow = data.tamanio;
                                        params.successCallback(
                                            rowsThisPage,
                                            lastRow);
											

											console.log("PRIMERIN",$scope.primerIngreso)
                                        if ($scope.primerIngreso == 1) {
											
											selectOldProducts()
                                            $scope.primerIngreso = 0;
                                            if ($scope.data.articulo != '') {
                                                focusOnFilter()
                                            } else {
                                                pruebaFocusProductos("event", "init")

                                            }
                                        }else{
											pruebaFocusProductos("event", "noinit")
										} 


                                    }
                                });
                        }
                    }

                    dataSourceCliente = {
                        rowCount: null, // behave as infinite
                        // scroll
                        pageSize: 50,
                        overflowSize: 50,
                        maxConcurrentRequests: 2,
                        maxPagesInCache: 2,
                        getRows: function(params) {

                            var start = params.startRow + 1;
                            var pagina = (params.endRow / pageSize);

                            $
                                .ajax({
                                    type: 'POST',
                                    url: 'cliente/searchByFiltros',
                                    contentType: "application/json",
                                    data: JSON
                                        .stringify(getFiltroBusquedaCliente(
                                            pagina,
                                            pageSize)),
                                    dataType: 'json',
                                    // url:
                                    // 'articulo/findAll/'
                                    // + start + '/' +
                                    // params.endRow,

                                    success: function(data) {
                                        resultadoBusqueda = JSON
                                            .parse(angular
                                                .toJson(data.lista))
                                            // modalInstance.close();
                                        var rowsThisPage = resultadoBusqueda
                                            .slice(
                                                params.startRow,
                                                params.endRow);
                                        var lastRow = data.tamanio;

                                        params.successCallback(
                                            rowsThisPage,
                                            lastRow);
                                        if ($scope.primerIngresoCliente == 1) {
                                            $scope.primerIngresoCliente = 0;
                                            onClienteFocus("event", "init")
                                        }else{
											onClienteFocus("event", "noinit")
										} 

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
                                templateUrl: 'modalFacturaGenerada.html',
                                backdrop: 'static',
                                scope: $scope,
                                controller: function($scope,
                                    $modalInstance) {
                                    $scope.cancel = function() {
                                        $modalInstance
                                            .dismiss('cancel');
                                    };
                                    $scope.opened = function() {};
                                },
                                size: size,
                            });

                        modalInstanceSuccessFactura.result.then(
                            function(selectedItem) {

                            },
                            function() {
                                // Se ejecuta esto cuando se
                                // presiona Escape en el dialogo
                                $route.reload();

                            });
                    }

                    $scope.openDemoModal = function(size) {
                        modalInstance = $modal.open({
                            templateUrl: 'modalTardanza.html',
                            backdrop: 'static',
                            controller: function($scope,
                                $modalInstance) {
                                $scope.cancel = function() {
                                    $modalInstance
                                        .dismiss('cancel');
                                };
                            },
                            size: size,
                        });
                    }
                    $scope.openDemoModalCliente = function(size) {
                        modalInstanceCliente = $modal
                            .open({
                                templateUrl: 'modalBuscadorCliente.html',
                                backdrop: 'static',
                                scope: $scope,
                                controller: function($scope,
                                    $modalInstance) {
                                    $scope.cancel = function() {
                                        $modalInstance
                                            .dismiss('cancel');
                                    };
                                },
                                size: size,
                            });
                        modalInstanceCliente.result.then(function(
                            selectedItem) {

                        }, function() {
                            // Se ejecuta esto cuando se presiona
                            // Escape en el dialogo
                            $scope.isShowingClientePopup = false
                            focus($("#busquedaCliente"))
                        });
                    }
                    $scope.openDemoModalArticulo = function(size) {
                        modalInstanceArticulo = $modal
                            .open({
                                templateUrl: 'modalBuscadorArticulo.html',
                                backdrop: 'static',
                                scope: $scope,
                                controller: function($scope,
                                    $modalInstance) {
                                    $scope.cancel = function() {
                                        $modalInstance
                                            .dismiss('cancel');
                                    };
                                    $scope.open = function() {};
                                },
                                size: size,
                            });
                        modalInstanceArticulo.result.then(function(
                            selectedItem) {}, function() {
                            // Se ejecuta esto cuando se presiona
                            // Escape en el dialogo
                            $scope.isShowingArticuloPopup = false
                            focus($("#busquedaProd"))
                        });
                        // Add a function for when the dialog is
                        // opened
                        modalInstanceArticulo.opened
                            .then(function() {

                            })
                    }

                }

                /* Inicializar las grillas */

                function setGrids() {
                    $scope.gridOptionsProductos = {
                        columnDefs: columnProductos,
                        rowSelection: 'multiple',
                        rowData: null,
						onRowSelected:  function rowSelected(event) {
						$scope.arrayPruebas[String(event.node.data.codigo)]=event.node.data
						},  onRowDeselected:  function rowDes(event) {
								delete $scope.arrayPruebas[event.node.data.codigo];
						},
                        enableFilter: true,
                        enableServerSideFilter: true,
                        cellFocused: function() {},
                        virtualPaging: true, // this is
                        // important, if not
                        // set, normal
                        // paging will be
                        // done
                        // onSelectionChanged: seleccionCambiada,
                        ready: function(api) {
							if ($scope.gridOptionsProductos.datasource==undefined)
								$scope.gridOptionsProductos.api.setDatasource(dataSource);
                        }
                    };
                    $scope.gridOptionsCliente = {
                        columnDefs: columnCliente,
                        rowSelection: 'single',
                        rowData: null,
                        enableFilter: true,
                        enableServerSideFilter: true,
                        virtualPaging: true,
						onRowSelected:  function rowSelected(event) {
							$scope.arrayPruebasClientes=new Object()
							$scope.arrayPruebasClientes[String(event.node.data.codigo)]=event.node.data
						},  onRowDeselected:  function rowDes(event) {
							delete $scope.arrayPruebasClientes[event.node.data.codigo];
					},

                        //onSelectionChanged : seleccionClienteCambiada,
                        cellFocused: function() {},
                        ready: function(api) {

							if ($scope.gridOptionsCliente.datasource==undefined)
								$scope.gridOptionsCliente.api.setDatasource(dataSourceCliente);
                        }
                    };

                    $scope.gridOptionsFactura = {
                        enableCellExpressions: true,

                        columnDefs: columnsFactura,
                        rowSelection: 'single',
                        rowData: null,
                        enableFilter: true,
                        context: {},
                        onCellFocused: function(val) {
                            $scope.currentFocusedRow = val.rowIndex
                            $scope.currentFocusedColumn = val.colIndex
                        },
                        onCellValueChanged: function(value) {
                            valorCeldaCambiado();
                            $scope.gridOptionsFactura.api.setFocusedCell($scope.currentFocusedRow, $scope.currentFocusedColumn);
                        },
                        angularCompileRows: true
                    };
                    $scope.gridOptionsFactura.context.totalReal = function(precio, cantidad) {
                        var total = calculaTotalLinea(precio, cantidad);

                        return total;
                    };
                    $scope.gridOptionsFactura.context.formatearCodigo = function(cc1, cc2, cc3, cc4, cc5) {
                        var codigoFormateado = cc1 + "-" + cc2 + "-" + cc3 + "-" + cc4 + "-" + cc5 + "-"

                        return codigoFormateado;
                    };
                    $scope.gridOptionsFactura.context.calcularPrecioFinal = function(total, cantidad) {

                        var totalPrecio = (total / cantidad);
                        console.log("TOTAL", totalPrecio.toLocaleString(), totalPrecio.toLocaleString('ar-EG'))
                        var var1 = parseFloat(totalPrecio).toFixed(2)
                        var var2 = totalPrecio.toLocaleString()
                        console.log("CURE", "$" + totalPrecio.toFixed(2).replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,"))
                        return totalPrecio.toFixed(2).replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,")
                            //return totalPrecio.toFixed(2);
                    };


                    $scope.gridOptionsFactura.context.fnTotalPrecioLista = function(precio, cantidad) {
                        var total = calculaTotalPrecioLista(precio, cantidad);
                        return total.toFixed(2).replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,")
                            //return total.toFixed(2);
                    };

                    $scope.gridOptionsFactura.context.getNumberFrmt = function(
                        numeroStr) {
                        var rta = getNumber(numeroStr);
                        return rta;
                    };

                }

                function getIva() {
                    return $scope.ivaInscripto;
                }

                function calculaTotalPrecioLista(precio, cantidad) {
                    precio = getNumber(precio);
                    /* Se bloquea el uso de IVA para calculo de articulo
                    var totalProducto = (cantidad * precio + (cantidad	* precio * (getIva() / 100) )); */
                    var totalProducto = (cantidad * precio);
                    return totalProducto;

                }

                function getTotalVeridico() {

                    var producto;
                    var total = 0
                    for (producto in $scope.gridOptionsFactura.rowData) {
                        total = total + (parseFloat($scope.gridOptionsFactura.rowData[producto].precio.replace(",", "")) * parseFloat($scope.gridOptionsFactura.rowData[producto].canMaxima.replace(",", ".")));

                    }
                    return total;
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
                    if ($scope.montoEfectivo != 0 && $scope.montoEfectivo != null && $scope.montoTC != 0 && $scope.cuotaSeleccionada == undefined) {
                        coeficienteEfectivo = (parseFloat($scope.montoEfectivo) + parseFloat($scope.montoTC)) / getSubTotalConIva();
                        totalEfectivoConCoeficiente = totalProducto * coeficienteEfectivo;


                    } else if ($scope.montoEfectivo != 0 && $scope.montoEfectivo != null) {
                        //coeficienteEfectivo = $scope.montoEfectivo / getSubTotalConIva();
                        coeficienteEfectivo = $scope.montoEfectivo / getTotalVeridico();
                        totalEfectivoConCoeficiente = totalProducto * coeficienteEfectivo;

                    } else if ($scope.montoEfectivo == null || $scope.montoEfectivo == 0) {
                        //coeficienteEfectivo = $scope.montoEfectivo / getSubTotalConIva();
                        coeficienteEfectivo = 0
                        totalEfectivoConCoeficiente = totalProducto * coeficienteEfectivo;
                        coeficienteTarjeta = 1
                        totalTarjetaConCoeficiente = (totalProducto - totalEfectivoConCoeficiente);
                        if ($scope.cuotaSeleccionada != undefined) {
                            var coeficienteTC = $scope.cuotaSeleccionada.coeficiente
                            totalTarjetaConCoeficiente = calculateInteresTC(coeficienteTC, totalTarjetaConCoeficiente, parseFloat($scope.recargoTC))

                        }
                    }

                    if (coeficienteEfectivo > 0 &&
                        coeficienteEfectivo < 1 && $scope.cuotaSeleccionada != undefined) {
                        coeficienteTarjeta = 1 - coeficienteEfectivo;
                        var coeficienteTC = $scope.cuotaSeleccionada.coeficiente
                        var recargoTC = parseFloat($scope.recargoTC);
                        totalTarjetaConCoeficiente = (totalProducto - totalEfectivoConCoeficiente); //* coeficienteTC;
                        //										totalTarjetaConCoeficiente = totalTarjetaConCoeficiente + (totalTarjetaConCoeficiente * (recargoTC / 100));
                        totalTarjetaConCoeficiente = calculateInteresTC(coeficienteTC, totalTarjetaConCoeficiente, parseFloat($scope.recargoTC))

                    } else {

                    }


                    totalRealProducto = totalEfectivoConCoeficiente + totalTarjetaConCoeficiente

                    return totalRealProducto.toFixed(2).replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,")

                    //return totalRealProducto.toFixed(2);

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
                    calculateTotales()
                    recalculateGridProductos()


                    $scope.$apply() // Averiguar que hace
                }
                /*function valorCeldaCambiadoIva() {
                	recalculateGridProductos()
                	cleanTotales();
                	calculateTotales()
                	recalculateGridProductos()
                	$scope.$apply() // Averiguar que hace
                }*/

                function calculateTotales() {
                    obtenerTotales();
                    setEfectivo()

                }

                function cleanTotales() {
                    resetSelectedTC()
                    resetSelectedInfoTC()
                    $scope.TotalFact = 0
                    $scope.subTotal = 0
                    setEfectivo();
                    $scope.cuotaSeleccionada = undefined;
                    cleanClienteData();

                }

                function cleanClienteData() {
                    $scope.nombreConsumidorFinal = ""
                    $scope.documentoConsumidorFinal = ""
                }

                function resetSelectedTC() {
                    $scope.montoTC = 0;
                    $scope.selectTarjetaCredito = null;
                }

                function resetSelectedInfoTC() {
                    $scope.cuotaSeleccionada = undefined
                    $scope.interesTC = 0
                    $scope.recargoTC = ""
                    $scope.cuotas = {};
                    $scope.cuponTC = ""


                }

                /*
                 * function rowSelectedFunc(event) {
                 * $scope.seleccionados=$scope.gridOptionsProductos.api.getSelectedRows() }
                 */
                function clone(obj) {
                    if (null == obj || "object" != typeof obj)
                        return obj;
                    var copy = obj.constructor();
                    for (var attr in obj) {
                        if (obj.hasOwnProperty(attr))
                            copy[attr] = clone(obj[attr]);
                    }
                    return copy;
                }
                // Chequea si ya existe un elemento en la tabla de
                // factura,para no agregarlo nuevamente
                function existe(arrayABuscar, codigo) {
                    var x;
                    for (x in arrayABuscar) {

                        if (arrayABuscar[x].codigo == codigo) {
                            return true

                        }
                    }
                    return false
                }

                function seleccionCambiada() {
					var clonedArray3 =$scope.gridOptionsProductos.api.getSelectedRows()
					var clonedArray=new Array()
					var clonedArray2=$scope.arrayPruebas
					for (var key in clonedArray2) {
						console.log("VA",clonedArray2[key])
						clonedArray.push(clonedArray2[key])
}
                    var arrayViejo = clone($scope.gridOptionsFactura.rowData);
					console.log("ccambia",clonedArray,clonedArray2)

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

                    //focus($("#busquedaProd"))
                    $scope.gridOptionsFactura.api.setFocusedCell(0, 2)
                    $scope.focusedFactura = true
                    $scope.isShowingArticuloPopup = false
                }

                function focus(element) {
                    element.focus();
                }

                function seleccionClienteCambiada(event) {

                    modalInstanceCliente.close();
					console.log(Object.keys($scope.arrayPruebasClientes)[0])
					var indexCliente=Object.keys($scope.arrayPruebasClientes)[0]
                    var seleccion = $scope.arrayPruebasClientes[indexCliente]
					console.log("seleccion",seleccion)
                        // Seteamos el valor del cliente elegido

                    $scope.clienteSeleccionadoRazon = seleccion.razonSocial;
                    $scope.clienteSeleccionadoId = seleccion.codigo;
                    $scope.clienteSeleccionadoCuit = seleccion.cuit;
                    $scope.clienteSeleccionadoCategoria = seleccion.categoria;

                    // actualizo el Iva Inscripto
                    obtenerAlicuotaCategoriaIva();

                    // Actualizo la letra del tipo de Factura
                    obtenerLetraCategoriaIva();


                    $scope.chkConsumidorFinal = false;
                    $scope.isShowingClientePopup = false
                    focus($("#busquedaCliente"))
                        //Limpio DNY Y NOMBRE

                    cleanClienteData()
                }


                function obtenerLetraCategoriaIvaConsumidorFinal() {
                    var tipoFacturaConsumidorFinal = "B";
                    $scope.tipoFactura = tipoFacturaConsumidorFinal;
                }

                function obtenerLetraCategoriaIvaByCategoria(categoria) {
                    $
                        .ajax({
                            type: 'POST',
                            url: 'documento/getLetraCategoriaIva',
                            contentType: "application/json",
                            data: JSON
                                .stringify(categoria),
                            dataType: 'json',

                            complete: function(data) {
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
					console.log("ARRAY PRO",$scope.arrayPruebas[$scope.gridOptionsFactura.rowData[data.codigo]])
					delete $scope.arrayPruebas[$scope.gridOptionsFactura.rowData[data.codigo]]

                   /* var arrayNodes = jQuery.extend({},
                        $scope.gridOptionsProductos.api
                        .getSelectedNodes());
                    var producto;

                    for (producto in arrayNodes) {
                        if (nombreArticuloEliminar === arrayNodes[producto].data.articulo) {

                            borraProducto = false;

                        }

                    }*/
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
					$scope.gridOptionsFactura.api.setFocusedCell(data, 6)

                    // refrescar y
                    // no hacer esto
                    cleanTotales()
                    calculateTotales()
                    recalculateGridProductos()
                }

                /** ***FIN Eventos Grillas****** */

                /** ***Calculos****** */
                function obtenerTotales() {
                    calculateSaldosTotales();
                }

                function setEfectivo() {
                    //$scope.montoEfectivo = getTotal();

                    //$scope.montoEfectivo = Number(parseFloat(parseInt(getTotal())).toFixed(2
                    $scope.montoEfectivo = getTotal()
                }

                function setTotalPrecioLista(totalPrecioLista) {
                    $scope.totalPrecioLista = totalPrecioLista;
                }

                /* Se bloquea el uso de IVA para calculo de articulo
                function getResultadoConIva(valor) {
                	return valor + valor * getIva() / 100;
                }*/

                function calculateSaldosTotales() {
                    var producto;
					debugger
                    var total = 0;
                    var totalPrecioLista = 0;

                    for (producto in $scope.gridOptionsFactura.rowData) {
                        //total = total+ (parseInt($scope.gridOptionsFactura.rowData[producto].canMaxima) * parseInt(getNumber($scope.gridOptionsFactura.rowData[producto].precio)));
                        total = total + ($scope.gridOptionsFactura.rowData[producto].canMaxima * getNumber($scope.gridOptionsFactura.rowData[producto].precio));

                    }
                    //Seteo el total del precio de lista
                    setTotalPrecioLista(total);

                    //Sumo los intereses al subtotal para obtener el total
                    var totalFact = sumoInteresTarjetaAlTotalFactura(total);
                    setTotal(totalFact);
                    if (totalFact < 1000) {
                        $scope.nombre = ""
                        $scope.dni = ""
                    }

                  var ivaTotal = (totalFact * getIva()  / 100)
                   // var subTotal = totalFact / ((getIva() / 100) + 1)
				   var subTotal=totalFact-ivaTotal;
                    setSubTotal(subTotal);
                    /* Impuestos y Subtotal */
                    //Agrego que el subtotal sea el total menos el IVA
                    //var ivaTotal = calculaIva(totalFact);
                  
                    setIvaInscriptoTotal(ivaTotal)

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
                    return $scope.totalPrecioLista;

                    //return parseFloat($scope.totalPrecioLista);
                }

                function getSubTotalConIva() {
                    return parseFloat(getSubTotal() + getIvaInscriptoTotal());
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


                        totalFact = parseFloat(totalFact) +
                            parseFloat($scope.interesTC)
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
                    $scope.dataCliente.razonSocial = $scope.clienteSeleccionadoRazon;
                    if (event.which == 13) {
                        $scope.dataCliente.codigoCliente = ""
                        $scope.dataCliente.cuit = ""
                        $scope.dataCliente.razonSocial = ""
                        $scope.clienteSeleccionadoRazon = "";
                        $scope.clienteSeleccionadoRazon = "";
                        $scope.primerIngresoCliente = 1;
                        $scope.focusedClientes = false
                        $scope.isShowingClientePopup = true
                        $scope.openDemoModalCliente('lg');


                    }
                }

                function showArticuloPopup(event) {
                    $scope.data.articulo = $scope.articuloSeleccionadoBuscar;
                    if (event.which == 13) {
                        $scope.articuloSeleccionadoBuscar = "";
                        $scope.articuloSeleccionadoBuscar = "";
                        $scope.data.codigo1 = ""
                        $scope.data.codigo2 = ""
                        $scope.data.codigo3 = ""
                        $scope.primerIngreso = 1;
                        $scope.focusedProductos = false
                        $scope.isShowingArticuloPopup = true
                        $scope.openDemoModalArticulo('lg');
                    }

                }

                function onFocusTipoDocumento() {
                    if ($scope.isShowingArticuloPopup == true) {
                        $timeout(function() {
                            $('#busquedaArticulo').focus();
                            $scope.focusedProductos = false;
                        });
                    }

                    if ($scope.isShowingClientePopup == true) {
                        $timeout(function() {
                            $('#numeroCuit').focus();
                            $scope.focusedClientes = false
                        });
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
                    filtro.codigo = $scope.dataCliente.codigoCliente;
                    filtro.razonSocial = $scope.dataCliente.razonSocial;
                    filtro.cuit = $scope.dataCliente.cuit;

                    filtro.pagina = start;
                    filtro.cantRegistros = end;
                    return filtro;
                }

                function checkClient() {
                    if (($scope.TotalFact < 1000 && $scope.chkConsumidorFinal == true) || ($scope.chkConsumidorFinal == false)) {
                        cleanClienteData()
                        return true;
                    } else {

                        return false;
                    }
                }

                function guardarFactura() {
                    var factura
                    factura = getHeader()
                    factura.lineas = getLineas();
                    factura.pagos = getPagos();
                    $
                        .ajax({
                            type: 'POST',
                            url: 'Documento/save',
                            contentType: "application/json",
                            data: JSON.stringify(factura),
                            dataType: 'json',

                            complete: function(data) {
                                if (data.status = 200) {
                                    console.log("RES", data)
                                    $scope.numeroFactura = data.responseText;
                                    $scope
                                        .openDemoModalSuccessFactura('sm');
                                }

                            }
                        });
                }

                function obtenerAlicuotaCategoriaIvaByCategoria(categoria) {
                    $
                        .ajax({
                            type: 'POST',
                            url: 'documento/getAlicuotaCategoriaIva',
                            contentType: "application/json",
                            data: JSON
                                .stringify(categoria),
                            dataType: 'json',

                            success: function(data) {
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

                    if ($scope.cuotaSeleccionada != undefined && $scope.recargoTC != "") {
                        var montoTotal = calculateInteresTC($scope.cuotaSeleccionada.coeficiente, $scope.montoTC, parseFloat($scope.recargoTC))

                        $scope.interesTC = (montoTotal).toFixed(2);
                    }
                    obtenerTotales();

                }

                function calculateInteresTC(coefCuotaTC, montoTC, recargoTC) {
                    var coefCuota = coefCuotaTC;
                    var montoParcialTC = montoTC

                    var coefRecargoTC = recargoTC / 100;
                    var montoCoefCuota = montoParcialTC * coefCuota;

                    var montoCoefRecargo = montoCoefCuota * coefRecargoTC;

                    var montoTotal = montoCoefCuota + montoCoefRecargo;

                    return montoTotal;
                }

                function obtenerCuotasTarjeta() {
                    // $scope.interesTarjeta=0;


                    resetSelectedInfoTC();
                    var tarjeta = new Object()
                    tarjeta.codigo = $scope.selectTarjetaCredito.codigo;
                    tarjeta.monto = $scope.montoTC;
                    setRecargoTC();
                    tarjeta.recargo = $scope.selectTarjetaCredito.recargo;
                    var codigoTarjeta = $scope.selectTarjetaCredito.codigo;

                    $
                        .ajax({
                            type: 'POST',
                            url: 'tarjeta/getCuotas',
                            contentType: "application/json",
                            data: JSON.stringify(tarjeta),
                            dataType: 'json',

                            success: function(data) {
                                resultadoBusqueda = JSON
                                    .parse(angular
                                        .toJson(data))
                                    // selecciono la cuotra 1
                                $scope.cuotasTC = 1;
                                $scope.cuotas = resultadoBusqueda;
                                //obtenerTarjetas() 
                                // $scope.tipoFactura = data;
                            }
                        });
                }

                function setRecargoTC() {
                    $scope.recargoTC = (parseFloat($scope.selectTarjetaCredito.recargo) * 100) + "%";
                }



                function obtenerTarjetas() {
                    console.log("Lee tarjetas");
                    $
                        .ajax({
                            type: 'POST',
                            url: 'tarjeta/getTarjetas',
                            contentType: "application/json",
                            dataType: 'json',

                            complete: function(data) {
                                if (data.status == 200) {
                                    // resultadoBusqueda =
                                    // data.responseText;
                                    resultadoBusqueda = data.responseJSON;
                                    $scope.tarjetasList = resultadoBusqueda;

                                }
                            }
                        });
                }

                function obtenerAlicuotaTarjeta() {
                    var tarjeta = new Object();
                    tarjeta.codigo = $scope.selectTarjetaCredito.codigo;
                    tarjeta.cuotas = $scope.cuotasTC;

                    $
                        .ajax({
                            type: 'POST',
                            url: 'tarjeta/getAlicuota',
                            contentType: "application/json",
                            data: JSON.stringify(tarjeta),
                            dataType: 'json',

                            success: function(data) {
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

                    header.clienteNro = $scope.clienteSeleccionadoId;
                    header.clienteIvaInscripto = $scope.ivaInscripto;
                    header.letra = $scope.tipoFactura;
                    header.descripcion = $scope.facturaNotas;
                    header.nombreConsumidorFinal = $scope.nombreConsumidorFinal;
                    header.documentoConsumidorFinal = $scope.documentoConsumidorFinal;


                    return header;
                }

                function getLineas() {

                    var linea;
                    var arrayLineas = new Array();
                    console.log("LINEAS a FActurar/Iterar",
                        $scope.gridOptionsFactura.rowData)

                    for (linea in $scope.gridOptionsFactura.rowData) {
                        var lineaFacturar = new Object()
                        lineaFacturar.articuloId = $scope.gridOptionsFactura.rowData[linea].codigo;
                        lineaFacturar.precioUnitario = $scope.gridOptionsFactura.rowData[linea].precio;
                        lineaFacturar.precio = calculaTotalLinea($scope.gridOptionsFactura.rowData[linea].precio, $scope.gridOptionsFactura.rowData[linea].canMaxima);
                        lineaFacturar.cantidad = $scope.gridOptionsFactura.rowData[linea].canMaxima
                        arrayLineas.push(lineaFacturar)
                    }
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
                        pagoFacturar.coeficiente = $scope.cuotaSeleccionada.coeficiente;
                        pagoFacturar.cupon = $scope.cuponTC;
                        pagoFacturar.tarjeta = $scope.selectTarjetaCredito.codigo;
                        var recargoTC = parseFloat($scope.recargoTC);
                        pagoFacturar.coefRecargoTC = parseFloat($scope.recargoTC) / 100;
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
                    //Valido que no se pueda ingresar un monto mayor al maximo de precio de lista
                    console.log("MONTO FT: ", parseFloat($scope.montoEfectivo))
                    console.log("TOTAL FT: ", $scope.totalPrecioLista)

                    if ($scope.montoEfectivo > $scope.totalPrecioLista) {
                        $scope.montoEfectivo = $scope.totalPrecioLista
                    }

                    var montoAnterior = $scope.montoTC;
                    resetSelectedInfoTC()
                    var nuevoMonto = parseFloat(getTotal() - $scope.montoEfectivo).toFixed(2);;

                    if (nuevoMonto > 0) {
                        $scope.montoTC = nuevoMonto;
                        resetSelectedInfoTC()
                        $scope.selectTarjetaCredito = null;
                    } else {
                        resetSelectedTC();
                        resetSelectedInfoTC()
                    }

                    if ($scope.montoTC > 0 || ($scope.montoTC == 0 && montoAnterior > 0)) {
                        cuotaChange();
                        // obtenerCuotasTarjeta()
                    }
                    recalculateGridProductos()
                }



                function seleccionConsumidorFinal() {
                    if ($scope.clienteSeleccionadoRazon == undefined || $scope.clienteSeleccionadoRazon == null || $scope.clienteSeleccionadoRazon == "") {
                        $scope.chkConsumidorFinal = true
                        return false;
                    }

                    if ($scope.chkConsumidorFinal == true) {
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


                function borrarArticulosTodos() {

                    $scope.gridOptionsProductos.api
                        .forEachNode(function(node) {

                            $scope.gridOptionsProductos.api.selectionController
                                .deselectNode(node);
                        });
                    $scope.gridOptionsFactura.rowData.splice(0);

                    var newArray = $scope.gridOptionsFactura.rowData
                    $scope.gridOptionsFactura.api
                        .setRowData(newArray); // Investigar
                    // refrescar y
                    // no hacer esto								

                    cleanTotales()
                    calculateTotales()
                    recalculateGridProductos()
					$scope.focusedBusqueda=true
					 focus($("#busquedaProd"))

                }



            }
        ]);