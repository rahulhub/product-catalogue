requirejs.config({
	urlArgs : "bust=" + (new Date()).getTime(),
	/*config:{
	    moment:{
	        noGlobal:true
	    }
	},*/
	paths : {
		'text' : '../lib/require/text',
		'durandal' : '../lib/durandal/js',
		'plugins' : '../lib/durandal/js/plugins',
		'transitions' : '../lib/durandal/js/transitions',
		'knockout' : '../lib/knockout/knockout-3.1.0',
		'knockout.mapping' : '../lib/knockout/knockout.mapping-latest',
		'bootstrap' : '../lib/bootstrap/js/bootstrap',
		'jquery' : '../lib/jquery/jquery-1.9.1',
		'd3' : "../lib/d3/d3",
		'lodash' : '../lib/jointjs/lodash',
		'underscore' : '../lib/jointjs/lodash',
		'backbone' : '../lib/jointjs/backbone',
		'moment' : '../lib/moment/moment.min',
		'q' : '../lib/q/q',
		'watable' : '../lib/watable/js/jquery.watable',
		'bootstrapEdit' : '../lib/bootstrap3-editable/js/bootstrap-editable',
		'sugar' : '../lib/sugar/sugar-1.4.1-custom.min',
		'list': '../lib/list/list',
		'bootstrapDatepicker':'../lib/bootstrap-datepicker/js/bootstrap-datepicker',
		 toastr: '../lib/toastr/js/toastr',
		 'jqueryUi':'../lib/notification_menu/js/jquery-ui-1.8.14.custom.min',
		 menuNotification:'../lib/notification_menu/js/ttw-notification-menu',
		 "jqueryValidationEn" : '../lib/jQuery-ValidationEngine/js/languages/jquery.validationEngine-en',
	     "jqueryValidation" : '../lib/jQuery-ValidationEngine/js/jquery.validationEngine',
		 'blockUi' : '../lib/blockui-master/jquery.blockUI',
		 'carousel':'../lib/carousel/thumbnails.carousel.js'
	/*'datatables':'../lib/jqdatatable/js/jquery.dataTables'
	 */
	},
	shim : {

		'bootstrap' : {
			deps : [ 'jquery' ],
			exports : 'jQuery'
		},
		'knockout.mapping' : {
			deps : [ 'knockout' ]
		},
		'q' : {
			exports : 'Q'
		},
		lodash : {
			exports : '_'
		},
		'breeze' : {
			deps : [ 'jquery', 'q', 'knockout' ]
		},
		backbone : {
			//These script dependencies should be loaded before loading backbone.js.
			deps : [ 'underscore', 'jquery' ],
			//Once loaded, use the global 'Backbone' as the module value.
			exports : 'Backbone'
		},
	    toastr: {
	        deps: ['jquery'],
	        exports: 'toastr'
	      },
	      menuNotification:{
	    	  deps: ['jquery','jqueryUi'],
		        exports: 'menuNotification'
	      } 
	}
});

define(
		[ 'durandal/system', 'durandal/app', 'durandal/viewLocator',
				'knockout', 'knockout.mapping'],
		function(system, app, viewLocator, ko, kom) {
			//>>excludeStart("build", true);
			system.debug(true);
			//>>excludeEnd("build");
			//d3.select("body").append("h1").text("Successfully loaded D3 version " + d3.version);



			ko.mapping = kom;
			ko.bindingHandlers.tooltip = {
				init : function(element, valueAccessor) {
					var local = ko.utils.unwrapObservable(valueAccessor()), options = {};

					ko.utils.extend(options, local);

					$(element).tooltip(options);

					ko.utils.domNodeDisposal.addDisposeCallback(element,
							function() {
								$(element).tooltip("destroy");
							});
				}
			};

            app.title = 'POC';

            app.configurePlugins({
                router : true,
                dialog : true,
                widget : true
            });

            app.start().then(function() {
                //Replace 'viewmodels' in the moduleId with 'views' to locate the view.
                //Look for partial views in a 'views' folder in the root.
                viewLocator.useConvention();

                //Show the app by setting the root view model for our application with a transition.
                app.setRoot('viewmodels/shell', 'entrance');
            });


		});