//Created By: Rahul Dev

define([ 'plugins/router', 'durandal/app', 'plugins/http', 'knockout',
		'./productEntry' ], function(router, app, http, ko, prodEntry) {

	function activate() {
	}

	var createAttr = function createProduct() {
		var taskFormId = 'createAttr';
		var inputs = jQuery('#' + taskFormId + ' :input,textarea');
		var o = {};
		jQuery.map(inputs, function(n, i) {
			if (n.name && n.name != '' && $(n).is(":visible")) {
				o[n.name] = $(n).val();
			}
			return true;
		});

		var url = "/uruApp/api/prodCategory/createCatalogPropertyKey";

		http.post(url, o).then(function(response) {

			if (response != null) {
				console.log("Response");
				console.log(response);
			}
		}).then(function(afterResp) {
			prodEntry.activate();
		});
	}

	var vm = {
		createAttr : createAttr

	};
	return vm;
});