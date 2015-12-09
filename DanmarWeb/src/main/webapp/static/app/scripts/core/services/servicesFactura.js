angular
  .module('theme.core.servicesFactura', ['ngResource']).factory('ArticuloService',  function ($resource) {
	    'use strict';
	    return $resource('http://localhost:8080/DanmarWeb/articulo/findAll', {}, {
	        query: { method: 'GET', isArray: true },
	       save: { method: 'POST'},
		 update: { method: 'PUT'}
	   })
	  }).factory('ArticuloServiceFiltro',  function ($resource) {
		    'use strict';
		    return $resource('http://localhost:8080/DanmarWeb//articulo/searchByFiltros/:filtro', {}, {
		        query: { method: 'GET', isArray: true , params: {filtro: '@filtro'}},
		       save: { method: 'POST'},
			 update: { method: 'PUT'}
		   })
		  })
  