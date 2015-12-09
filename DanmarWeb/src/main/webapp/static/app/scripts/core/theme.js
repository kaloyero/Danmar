angular
  .module('theme', [
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute',
    'ngAnimate',
    
    'ui.bootstrap',
    'theme.core.templates',
    
    'theme.core.main_controller',
    'theme.core.navigation_controller',
    'theme.core.notifications_controller',
    'theme.core.messages_controller',
  ]);