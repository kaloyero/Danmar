angular
  .module('theme', [
    'ngRoute',    
    'ui.bootstrap',
    'theme.core.templates',
    
    'theme.core.main_controller',
    'theme.core.navigation_controller',
    'theme.demos.ng_grid',
    'theme.demos.busquedaFactura'
  ]);