<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Danmar V1.0</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Maverick">
	<meta name="author" content="nDevr Studios & The Red Team">

	<link rel="icon" type="image/png" href="favicon.png">

	<!-- prochtml:remove:dist -->
	<link href="static/app/assets/less/styles.less" rel="stylesheet/less" media="all"> 
	<!-- /prochtml -->

	<link href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,700' rel='stylesheet' type='text/css'>     

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries. Placeholdr.js enables the placeholder attribute -->
	<!--[if lte IE 9]>
	  <link rel="stylesheet" href="static/app/assets/css/ie8.css">
	  <script type="text/javascript" src="static/app/http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	  <script type="text/javascript" src="static/app/http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.1.0/respond.min.js"></script>
	  <script type="text/javascript" src="static/app/bower_components/flot/excanvas.min.js"></script>
	  <script type='text/javascript' src='assets/plugins/misc/placeholdr.js'></script>
	  <script type="text/javascript" src="static/app/assets/plugins/misc/media.match.min.js"></script>
	<![endif]-->

	<!-- The following CSS are included as plugins and can be removed if unused-->

	<!-- build:css assets/css/vendor.css -->
	<!-- bower:css -->
	<link rel="stylesheet" href="static/app/bower_components/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" href="static/app/bower_components/seiyria-bootstrap-slider/dist/css/bootstrap-slider.min.css" />
	<link rel="stylesheet" href="static/app/bower_components/angular-ui-tree/dist/angular-ui-tree.min.css" />
	<link rel="stylesheet" href="static/app/bower_components/ng-grid/ng-grid.css" />
	<link rel="stylesheet" href="static/app/bower_components/angular-xeditable/dist/css/xeditable.css" />
	<link rel="stylesheet" href="static/app/bower_components/iCheck/skins/all.css" />
	<link rel="stylesheet" href="static/app/bower_components/pnotify/pnotify.core.css" />
	<link rel="stylesheet" href="static/app/bower_components/pnotify/pnotify.buttons.css" />
	<link rel="stylesheet" href="static/app/bower_components/pnotify/pnotify.history.css" />
	<link rel="stylesheet" href="static/app/bower_components/nanoscroller/bin/css/nanoscroller.css" />
	<link rel="stylesheet" href="static/app/bower_components/textAngular/src/textAngular.css" />
	<link rel="stylesheet" href="static/app/bower_components/angular-ui-grid/ui-grid.css" />
	<link rel="stylesheet" href="static/app/bower_components/switchery/dist/switchery.css" />
	<link rel="stylesheet" href="static/app/bower_components/ng-sortable/dist/ng-sortable.css" />
	<link rel="stylesheet" href="static/app/bower_components/fullcalendar/fullcalendar.css" />
	<link rel="stylesheet" href="static/app/bower_components/angular-meditor/dist/meditor.min.css" />
	<link rel="stylesheet" href="static/app/bower_components/angular-ui-select/dist/select.css" />
	<link rel="stylesheet" href="static/app/bower_components/animate.css/animate.css" />
	<link rel="stylesheet" href="static/app/bower_components/bootstrap-daterangepicker/daterangepicker-bs3.css" />
	<link rel="stylesheet" href="static/app/bower_components/nvd3/src/nv.d3.css" />
	<link rel="stylesheet" href="static/app/bower_components/skylo/vendor/styles/skylo.css" />
	<link rel="stylesheet" href="static/app/bower_components/bootstrap-datepaginator/dist/bootstrap-datepaginator.min.css" />
	<!-- endbower -->
	<link rel='stylesheet' type='text/css' href='static/app/assets/fonts/glyphicons/css/glyphicons.min.css' /> 
	<link rel='stylesheet' type='text/css' href='static/app/assets/plugins/form-fseditor/fseditor.css' /> 
	<link rel='stylesheet' type='text/css' href='static/app/assets/plugins/jcrop/css/jquery.Jcrop.min.css' /> 
	<!-- endbuild -->

	<!-- build:css({.tmp,app}) assets/css/main.css -->
	  <link rel="stylesheet" href="static/app/assets/css/styles.css">
	<!-- endbuild -->

	<!-- prochtml:remove:dist -->
	<script type="text/javascript">less = { env: 'development'};</script>
	<script type="text/javascript" src="static/app/assets/plugins/misc/less.js"></script>
	<!-- /prochtml -->
	<style>
	.ag-fresh .ag-not-dragging {
  		border: none;
	}
	</style>
</head>

<body
  ng-app="themesApp"
  ng-controller="MainController"
  class="{{getLayoutOption('topNavThemeClass')}} sidebar-default navbar-midnightblue ng-animate sidebar-collapsed"
  ng-class="{
			  'static-header': !getLayoutOption('fixedHeader'),
			  'focusedform': getLayoutOption('fullscreen'),
			  'layout-horizontal': getLayoutOption('layoutHorizontal'),
			  'fixed-layout': getLayoutOption('layoutBoxed'),
			  'sidebar-collapsed': getLayoutOption('leftbarCollapsed') && !getLayoutOption('leftbarShown'),
			  'show-infobar': getLayoutOption('rightbarCollapsed'),
			  'show-sidebar': getLayoutOption('leftbarShown')
			}"
  ng-click="hideHeaderBar();hideChatBox()"
  animate-page-content
  faux-offcanvas
  to-top-on-load
>


	<div ng-include="'static/app/views/templates/custom-styles.html'"></div>
	
	
<header id="topnav" class="navbar ng-scope navbar-fixed-top" ng-class="{'navbar-fixed-top': getLayoutOption('fixedHeader'), 'navbar-static-top': !getLayoutOption('fixedHeader')}" ng-controller="MainController" role="banner" ng-show="true">
	<a id="leftmenu-trigger" ng-click="toggleLeftBar()"></a>
	<a id="rightmenu-trigger" ng-click="toggleRightBar()"></a>


	<div class="navbar-header pull-left">
		<a class="navbar-brand" href="#/">Danmar</a>
	</div>


	<ul class="nav navbar-nav pull-right toolbar">
	  <li class="dropdown ng-hide" ng-show="!isLoggedIn">
		<a href="#/extras-login2" style="font-size: 14px"><i class="fa fa-sign-in"></i> Entrar</a>
	  </li>
	
	  <li class="dropdown hidden-xs ng-scope" dropdown="" ng-controller="MessagesController" ng-show="isLoggedIn">
		<a href="" class="dropdown-toggle" dropdown-toggle="" aria-haspopup="true" aria-expanded="false">
		 <i class="glyphicon glyphicon-envelope"></i><!-- ngIf: unseenCount>0 --><span class="badge badge-danger ng-binding ng-scope" ng-if="unseenCount>0" ng-bind="unseenCount">6</span><!-- end ngIf: unseenCount>0 -->
		</a>
		<ul class="dropdown-menu animated messages arrow">
		  <li class="dd-header">
			<span class="ng-binding">Messages (6)</span>
			<span><a href="#"><i class="glyphicon glyphicon-cog"></i></a></span>
		  </li>
			  <div class="scrollthis" scrollable=""><div class="nano has-scrollbar"><div class="nano-content" ng-transclude="" tabindex="0" style="right: -17px;">
				<!-- ngRepeat: item in messages --><li ng-repeat="item in messages" class="ng-scope">
				  <a href="#/" ng-class="{active: !item.read}" class="active">
					<!-- ngIf: !item.read --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark read" class="btn-mark-read ng-scope" ng-if="!item.read" ng-click="setRead(item, $event)"><i class="glyphicon glyphicon-unchecked"></i></button><!-- end ngIf: !item.read -->
					<!-- ngIf: item.read -->
					<span class="time ng-binding">3m</span>
					<img ng-src="assets/demo/avatar/paton.png" alt="avatar" src="http://placehold.it/400&amp;text=Placeholder">
					<div>
					  <span class="name ng-binding">Polly Paton</span>
					  <span class="msg ng-binding">Uploaded all the files to server</span>
					</div>
				  </a>
				</li><!-- end ngRepeat: item in messages --><li ng-repeat="item in messages" class="ng-scope">
				  <a href="#/" ng-class="{active: !item.read}" class="active">
					<!-- ngIf: !item.read --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark read" class="btn-mark-read ng-scope" ng-if="!item.read" ng-click="setRead(item, $event)"><i class="glyphicon glyphicon-unchecked"></i></button><!-- end ngIf: !item.read -->
					<!-- ngIf: item.read -->
					<span class="time ng-binding">17m</span>
					<img ng-src="assets/demo/avatar/corbett.png" alt="avatar" src="http://placehold.it/400&amp;text=Placeholder">
					<div>
					  <span class="name ng-binding">Simon Corbett</span>
					  <span class="msg ng-binding">I am signing off for today</span>
					</div>
				  </a>
				</li><!-- end ngRepeat: item in messages --><li ng-repeat="item in messages" class="ng-scope">
				  <a href="#/" ng-class="{active: !item.read}">
					<!-- ngIf: !item.read -->
					<!-- ngIf: item.read --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark unread" class="btn-mark-unread ng-scope" ng-if="item.read" ng-click="setUnread(item, $event)"><i class="glyphicon glyphicon-check"></i></button><!-- end ngIf: item.read -->
					<span class="time ng-binding">2h</span>
					<img ng-src="assets/demo/avatar/tennant.png" alt="avatar" src="http://placehold.it/400&amp;text=Placeholder">
					<div>
					  <span class="name ng-binding">Matt Tennant</span>
					  <span class="msg ng-binding">Everything is working just fine here</span>
					</div>
				  </a>
				</li><!-- end ngRepeat: item in messages --><li ng-repeat="item in messages" class="ng-scope">
				  <a href="#/" ng-class="{active: !item.read}" class="active">
					<!-- ngIf: !item.read --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark read" class="btn-mark-read ng-scope" ng-if="!item.read" ng-click="setRead(item, $event)"><i class="glyphicon glyphicon-unchecked"></i></button><!-- end ngIf: !item.read -->
					<!-- ngIf: item.read -->
					<span class="time ng-binding">5d</span>
					<img ng-src="assets/demo/avatar/doyle.png" alt="avatar" src="http://placehold.it/400&amp;text=Placeholder">
					<div>
					  <span class="name ng-binding">Alan Doyle</span>
					  <span class="msg ng-binding">Please mail me the files by tonight</span>
					</div>
				  </a>
				</li><!-- end ngRepeat: item in messages --><li ng-repeat="item in messages" class="ng-scope">
				  <a href="#/" ng-class="{active: !item.read}" class="active">
					<!-- ngIf: !item.read --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark read" class="btn-mark-read ng-scope" ng-if="!item.read" ng-click="setRead(item, $event)"><i class="glyphicon glyphicon-unchecked"></i></button><!-- end ngIf: !item.read -->
					<!-- ngIf: item.read -->
					<span class="time ng-binding">3m</span>
					<img ng-src="assets/demo/avatar/paton.png" alt="avatar" src="http://placehold.it/400&amp;text=Placeholder">
					<div>
					  <span class="name ng-binding">Polly Paton</span>
					  <span class="msg ng-binding">Uploaded all the files to server</span>
					</div>
				  </a>
				</li><!-- end ngRepeat: item in messages --><li ng-repeat="item in messages" class="ng-scope">
				  <a href="#/" ng-class="{active: !item.read}" class="active">
					<!-- ngIf: !item.read --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark read" class="btn-mark-read ng-scope" ng-if="!item.read" ng-click="setRead(item, $event)"><i class="glyphicon glyphicon-unchecked"></i></button><!-- end ngIf: !item.read -->
					<!-- ngIf: item.read -->
					<span class="time ng-binding">17m</span>
					<img ng-src="assets/demo/avatar/corbett.png" alt="avatar" src="http://placehold.it/400&amp;text=Placeholder">
					<div>
					  <span class="name ng-binding">Simon Corbett</span>
					  <span class="msg ng-binding">I am signing off for today</span>
					</div>
				  </a>
				</li><!-- end ngRepeat: item in messages --><li ng-repeat="item in messages" class="ng-scope">
				  <a href="#/" ng-class="{active: !item.read}">
					<!-- ngIf: !item.read -->
					<!-- ngIf: item.read --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark unread" class="btn-mark-unread ng-scope" ng-if="item.read" ng-click="setUnread(item, $event)"><i class="glyphicon glyphicon-check"></i></button><!-- end ngIf: item.read -->
					<span class="time ng-binding">2h</span>
					<img ng-src="assets/demo/avatar/tennant.png" alt="avatar" src="http://placehold.it/400&amp;text=Placeholder">
					<div>
					  <span class="name ng-binding">Matt Tennant</span>
					  <span class="msg ng-binding">Everything is working just fine here</span>
					</div>
				  </a>
				</li><!-- end ngRepeat: item in messages --><li ng-repeat="item in messages" class="ng-scope">
				  <a href="#/" ng-class="{active: !item.read}" class="active">
					<!-- ngIf: !item.read --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark read" class="btn-mark-read ng-scope" ng-if="!item.read" ng-click="setRead(item, $event)"><i class="glyphicon glyphicon-unchecked"></i></button><!-- end ngIf: !item.read -->
					<!-- ngIf: item.read -->
					<span class="time ng-binding">5d</span>
					<img ng-src="assets/demo/avatar/doyle.png" alt="avatar" src="http://placehold.it/400&amp;text=Placeholder">
					<div>
					  <span class="name ng-binding">Alan Doyle</span>
					  <span class="msg ng-binding">Please mail me the files by tonight</span>
					</div>
				  </a>
				</li><!-- end ngRepeat: item in messages -->
			  </div><div class="nano-pane" style="display: none;"><div class="nano-slider" style="height: 20px; transform: translate(0px, 0px);"></div></div></div></div>
		  <li class="dd-footer"><a href="#" ng-click="setReadAll($event)">Mark all read</a></li>
		</ul>
	  </li>
	  <li class="dropdown ng-scope" dropdown="" ng-controller="NotificationsController" ng-show="isLoggedIn">
		<a href="" dropdown-toggle="" class="dropdown-toggle" aria-haspopup="true" aria-expanded="false">
		  <i class="glyphicon glyphicon-globe"></i><!-- ngIf: unseenCount>0 --><span class="badge badge-indigo ng-binding ng-scope" ng-if="unseenCount>0" ng-bind="unseenCount">5</span><!-- end ngIf: unseenCount>0 -->
		</a>
		<ul class="dropdown-menu animated notifications arrow">
		  <li class="dd-header">
			<span class="ng-binding">Notifications (5)</span>
			<span><a href="#"><i class="glyphicon glyphicon-cog"></i></a></span>
		  </li>
				<div class="scrollthis" scrollable=""><div class="nano has-scrollbar"><div class="nano-content" ng-transclude="" tabindex="0" style="right: -17px;">
			<!-- ngRepeat: item in notifications --><li ng-repeat="item in notifications" class="ng-scope">
			  <a href="#" class="notification-success" ng-class="{active: !item.seen}">
				<!-- ngIf: !item.seen -->
				<!-- ngIf: item.seen --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark unseen" class="btn-mark-unread ng-scope" ng-if="item.seen" ng-click="setUnseen(item, $event)"><i class="glyphicon glyphicon-check"></i></button><!-- end ngIf: item.seen -->
				<span class="time ng-binding">4m</span>
				<i class="glyphicon glyphicon-ok"></i>
				<span class="msg ng-binding">Server #1 is live</span>
			  </a>
			</li><!-- end ngRepeat: item in notifications --><li ng-repeat="item in notifications" class="ng-scope">
			  <a href="#" class="notification-user active" ng-class="{active: !item.seen}">
				<!-- ngIf: !item.seen --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark seen" class="btn-mark-read ng-scope" ng-if="!item.seen" ng-click="setSeen(item, $event)"><i class="glyphicon glyphicon-unchecked"></i></button><!-- end ngIf: !item.seen -->
				<!-- ngIf: item.seen -->
				<span class="time ng-binding">10m</span>
				<i class="glyphicon glyphicon-user"></i>
				<span class="msg ng-binding">New user Registered</span>
			  </a>
			</li><!-- end ngRepeat: item in notifications --><li ng-repeat="item in notifications" class="ng-scope">
			  <a href="#" class="notification-danger active" ng-class="{active: !item.seen}">
				<!-- ngIf: !item.seen --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark seen" class="btn-mark-read ng-scope" ng-if="!item.seen" ng-click="setSeen(item, $event)"><i class="glyphicon glyphicon-unchecked"></i></button><!-- end ngIf: !item.seen -->
				<!-- ngIf: item.seen -->
				<span class="time ng-binding">22m</span>
				<i class="glyphicon glyphicon-exclamation-sign"></i>
				<span class="msg ng-binding">CPU at 92% on server#3!</span>
			  </a>
			</li><!-- end ngRepeat: item in notifications --><li ng-repeat="item in notifications" class="ng-scope">
			  <a href="#" class="notification-warning active" ng-class="{active: !item.seen}">
				<!-- ngIf: !item.seen --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark seen" class="btn-mark-read ng-scope" ng-if="!item.seen" ng-click="setSeen(item, $event)"><i class="glyphicon glyphicon-unchecked"></i></button><!-- end ngIf: !item.seen -->
				<!-- ngIf: item.seen -->
				<span class="time ng-binding">30m</span>
				<i class="glyphicon glyphicon-warning-sign"></i>
				<span class="msg ng-binding">Database overloaded</span>
			  </a>
			</li><!-- end ngRepeat: item in notifications --><li ng-repeat="item in notifications" class="ng-scope">
			  <a href="#" class="notification-order" ng-class="{active: !item.seen}">
				<!-- ngIf: !item.seen -->
				<!-- ngIf: item.seen --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark unseen" class="btn-mark-unread ng-scope" ng-if="item.seen" ng-click="setUnseen(item, $event)"><i class="glyphicon glyphicon-check"></i></button><!-- end ngIf: item.seen -->
				<span class="time ng-binding">1h</span>
				<i class="glyphicon glyphicon-shopping-cart"></i>
				<span class="msg ng-binding">New order received</span>
			  </a>
			</li><!-- end ngRepeat: item in notifications --><li ng-repeat="item in notifications" class="ng-scope">
			  <a href="#" class="notification-danger" ng-class="{active: !item.seen}">
				<!-- ngIf: !item.seen -->
				<!-- ngIf: item.seen --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark unseen" class="btn-mark-unread ng-scope" ng-if="item.seen" ng-click="setUnseen(item, $event)"><i class="glyphicon glyphicon-check"></i></button><!-- end ngIf: item.seen -->
				<span class="time ng-binding">9d</span>
				<i class="glyphicon glyphicon-remove"></i>
				<span class="msg ng-binding">Application error!</span>
			  </a>
			</li><!-- end ngRepeat: item in notifications --><li ng-repeat="item in notifications" class="ng-scope">
			  <a href="#" class="notification-success active" ng-class="{active: !item.seen}">
				<!-- ngIf: !item.seen --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark seen" class="btn-mark-read ng-scope" ng-if="!item.seen" ng-click="setSeen(item, $event)"><i class="glyphicon glyphicon-unchecked"></i></button><!-- end ngIf: !item.seen -->
				<!-- ngIf: item.seen -->
				<span class="time ng-binding">1d</span>
				<i class="glyphicon glyphicon-ok"></i>
				<span class="msg ng-binding">Installation Succeeded</span>
			  </a>
			</li><!-- end ngRepeat: item in notifications --><li ng-repeat="item in notifications" class="ng-scope">
			  <a href="#" class="notification-success active" ng-class="{active: !item.seen}">
				<!-- ngIf: !item.seen --><button tooltip-placement="top" tooltip-append-to-body="true" tooltip="Mark seen" class="btn-mark-read ng-scope" ng-if="!item.seen" ng-click="setSeen(item, $event)"><i class="glyphicon glyphicon-unchecked"></i></button><!-- end ngIf: !item.seen -->
				<!-- ngIf: item.seen -->
				<span class="time ng-binding">2d</span>
				<i class="glyphicon glyphicon-ok"></i>
				<span class="msg ng-binding">Account Created</span>
			  </a>
			</li><!-- end ngRepeat: item in notifications -->
				</div><div class="nano-pane" style="display: none;"><div class="nano-slider" style="height: 20px; transform: translate(0px, 0px);"></div></div></div></div>
		  <li class="dd-footer"><a href="javascript:;" ng-click="setSeenAll($event)">Mark all seen</a></li>
		</ul>
	  </li>
	
	</ul>
</header>	
	
	
	
	
	<nav id="headernav" class="navbar ng-hide" role="navigation" ng-show="getLayoutOption('layoutHorizontal') && !layoutLoading">
		<div class="nav">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<i class="fa fa-reorder"></i>
			</button>
		</div>
		<div class="collapse navbar-collapse navbar-ex1-collapse" ng-class="{'large-icons-nav': getLayoutOption('layoutHorizontalLargeIcons')}" id="horizontal-navbar">
	
		</div>
	</nav>


	<div id="wrapper">
		<div id="layout-static">
<div class="static-sidebar-wrapper" ng-show="true">
				<nav class="static-sidebar" role="navigation">
					<ul ng-controller="NavigationController" id="sidebar" sticky-scroll="50" class="ng-scope" style="top: 50px;">
				  	  <li id="search">
		                <a href="">
		                	<i class="fa fa-binoculars opacity-control"></i>
		                </a>
						<form ng-click="$event.stopPropagation()" ng-submit="goToSearch()" class="ng-pristine ng-valid">
							<input type="text" ng-model="searchQuery" class="search-query ng-pristine ng-valid ng-touched" placeholder="Type to filter...">
							<button type="submit" ng-click="goToSearch()"><i class="fa fa-binoculars"></i></button>
						</form>
		              </li>
					<!-- end ngRepeat: item in menu --><!-- ngInclude: 'templates/nav_renderer.html' -->
					<li  class="ng-scope"><!-- ngIf: item.separator==true -->
<!-- ngIf: !item.separator --><a ng-href="#/factura" class="ng-scope" href="#/factura">
	<!-- ngIf: item.iconClasses --><i class="glyphicon glyphicon-home"></i><!-- end ngIf: item.iconClasses -->
	<span class="ng-binding">Factura</span>
	<span ng-bind-html="item.html" class="ng-binding"></span>
</a><!-- end ngIf: !item.separator -->
<!-- ngIf: item.children.length --></li>
<li  class="ng-scope"><!-- ngIf: item.separator==true -->
<!-- ngIf: !item.separator --><a ng-href="#/consultaFactura" class="ng-scope" href="#/">
	<!-- ngIf: item.iconClasses --><i class="glyphicon glyphicon-home"></i><!-- end ngIf: item.iconClasses -->
	<span class="ng-binding">Busqueda</span>
	<span ng-bind-html="item.html" class="ng-binding"></span>
</a><!-- end ngIf: !item.separator -->
<!-- ngIf: item.children.length --></li>
					</ul>
				</nav> <!-- #sidebar-->
			</div>
			<div class="static-content-wrapper">
				<div class="static-content">
					<div id="wrap" ng-view="" class="mainview-animation animated">
					</div> <!--wrap -->
				</div>
				<footer role="contentinfo" ng-show="!layoutLoading" ng-cloak>
					<div class="clearfix">
						<ul class="list-unstyled list-inline pull-left">
							<li>MAVERICK &copy; 2015</li>
						</ul>
						<button class="pull-right btn btn-default btn-sm hidden-print" back-to-top style="padding: 1px 10px;"><i class="fa fa-angle-up"></i></button>
					</div>
				</footer>
			</div>
		</div>
	</div>


	<!--[if lt IE 9]>
	<script src="static/app/bower_components/es5-shim/es5-shim.js"></script>
	<script src="static/app/bower_components/json3/lib/json3.min.js"></script>
	<![endif]-->


	<!-- build:js scripts/vendor.js -->
	<!-- bower:js -->
	<script src="static/app/bower_components/jquery/dist/jquery.js"></script>
	<script src="static/app/bower_components/angular/angular.js"></script>
	<script src="static/app/bower_components/angular-resource/angular-resource.js"></script>
	<script src="static/app/bower_components/angular-cookies/angular-cookies.js"></script>
	<script src="static/app/bower_components/angular-sanitize/angular-sanitize.js"></script>
	<script src="static/app/bower_components/angular-route/angular-route.js"></script>
	<script src="static/app/bower_components/angular-animate/angular-animate.js"></script>
	<script src="static/app/bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script src="static/app/bower_components/angular-bootstrap/ui-bootstrap-tpls.js"></script>
	<script src="static/app/bower_components/ng-grid/build/ng-grid.js"></script>


	<script src="static/app/bower_components/enquire/dist/enquire.js"></script>
	
	<script src="static/app/bower_components/angularjs-nvd3-directives/dist/angularjs-nvd3-directives.js"></script>
	<script src="static/app/bower_components/oclazyload/dist/ocLazyLoad.min.js"></script>


	  <!-- build:js({.tmp,app}) scripts/scripts.js -->
	  			<script src="static/app/scripts/demos/modules/consultaFacturaController.js"></script>
	  
	<script src="static/app/scripts/core/controllers/mainController.js"></script>
	<script src="static/app/scripts/core/controllers/messagesController.js"></script>
	<script src="static/app/scripts/core/controllers/navigationController.js"></script>
	<script src="static/app/scripts/core/controllers/notificationsController.js"></script>
	<script src="static/app/scripts/core/directives/directives.js"></script>
	<script src="static/app/scripts/core/directives/form.js"></script>
	<script src="static/app/scripts/core/directives/ui.js"></script>
	<script src="static/app/scripts/core/modules/templates.js"></script>
	<script src="static/app/scripts/core/modules/panels/ngDraggable.js"></script>
	
	<script src="static/app/scripts/core/services/servicesold.js"></script>
	<script src="static/app/scripts/core/services/servicesFactura.js"></script>
	
	<script src="static/app/scripts/core/services/theme.js"></script>
	<script src="static/app/scripts/core/theme.js"></script>
	
    <script src="static/grid/dist/ag-grid.js?ignore=notused14"></script>
	
	
	<script src="static/app/scripts/demos/modules/facturaController.js"></script>
	

	<script src="static/app/scripts/demos/demos.js"></script>
	<script src="static/app/scripts/app.js"></script>
	
    <link rel="stylesheet" type="text/css" href="static/grid/dist/ag-grid.css?ignore=notused14">
    <link rel="stylesheet" type="text/css" href="static/grid/dist/theme-fresh.css?ignore=notused14">
	  <!-- endbuild -->
</body>
</html>
