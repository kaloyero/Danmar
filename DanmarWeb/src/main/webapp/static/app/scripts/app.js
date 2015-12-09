angular
  .module('themesApp', [
    'theme',
    'theme.demos',
  ])
  .config(['$provide', '$routeProvider', function($provide, $routeProvider) {
    'use strict';
    $routeProvider
      .when('/', {
        templateUrl: 'static/app/views/index.html',
        resolve: {
          loadCalendar: ['$ocLazyLoad', function($ocLazyLoad) {
            return $ocLazyLoad.load([
              'static/app/bower_components/fullcalendar/fullcalendar.js',
            ]);
          }]
        }
      })
      .when('/:templateFile', {
        templateUrl: function(param) {
          return 'static/app/views/' + param.templateFile + '.html';
        }
      })
      .when('#', {
        templateUrl: 'static/app/views/index.html',
      })
      .otherwise({
        redirectTo: '/'
      });
  }]);