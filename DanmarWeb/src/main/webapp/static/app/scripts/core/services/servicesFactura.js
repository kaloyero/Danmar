angular
  .module('theme.core.servicesFactura', ['ngResource']).factory('ArticuloService',  function ($resource) {
	    'use strict';
	    return $resource('articulo/findAll', {}, {
	        query: { method: 'GET', isArray: true },
	       save: { method: 'POST'},
		 update: { method: 'PUT'}
	   })
	  }).factory('ArticuloServiceFiltro',  function ($resource) {
		    'use strict';
		    return $resource('articulo/searchByFiltros/:filtro', {}, {
		        query: { method: 'GET', isArray: true , params: {filtro: '@filtro'}},
		       save: { method: 'POST'},
			 update: { method: 'PUT'}
		   })
		  })
  