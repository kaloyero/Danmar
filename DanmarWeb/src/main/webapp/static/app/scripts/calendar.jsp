<div id="page-heading">
    <ol class="breadcrumb">
        <li><a href="#/">Dashboard</a></li>
        <li class="active">Calendar</li>
    </ol>

    <h1>Calendar</h1>
    <div class="options">
        <div class="btn-toolbar">
            <div class="btn-group" dropdown>
                <button type="button" class="btn btn-default dropdown-toggle" dropdown-toggle>
                    Export as <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li class="divider"></li>
                  <li><a href="#">Separated link</a></li>
                </ul>
            </div>
            <a href="#" class="btn btn-default hidden-xs"><i class="glyphicon glyphicon-cog"></i></a>
        </div>
    </div>
</div>

<div class="container-fluid" ng-controller="CalendarController">
    <div class="row">
      <div class="col-xs-12">
        <div class="panel panel-danger calendar">
            <div class="panel-heading">
                <h2>Basic Calendar</h2>
            </div>
            <div class="panel-body">
                <div class="alert alert-info">Click on a date to create an event, drag &amp; drop to move events or extend time ranges</div>
                <div data-full-calendar="{ events: demoEvents }" ng-model="demoEvents"></div>
            </div>
        </div>
    </div>

    <div class="col-xs-12">
        <div class="panel panel-warning">
            <div class="panel-heading">
                <h2>Calendar with External Drag &amp; Drop</h2>
                <div class="options">
                    
                </div>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div id='external-events' class="col-sm-3">
                        <h3>Draggable Events</h3>
                        <form ng-submit="addEvent()" style="margin-bottom: 10px;" class="clearfix">
                            <label for="" class="control-label">Enter a name for an event:</label>
                            <input type="text" ng-model="newEvent" class="form-control" style="margin-bottom: 10px;" placeholder="Event Name...">
                            <button class="btn btn-primary pull-right" ng-click="addEvent()">Create Event</button>
                        </form>
                        <div ng-repeat="event in events" style="margin-bottom: 5px;">
                            <div class='external-event label label-info' data-draggable-event="{ title: event.title }" >{{event.title}}</div>
                        </div>
                    </div>

                    <div data-full-calendar="{ droppable: true, removeDroppedEvent: true }" class="col-sm-9"></div>
                </div>
            </div>
            </div>
        </div>
    </div>
</div> <!-- container-fluid -->
