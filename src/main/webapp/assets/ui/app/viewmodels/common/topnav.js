define([ 'knockout', 'jquery', 'bootstrap','plugins/router' ], function(ko, $, bootstrap,router) {
	//window.session = session;
	
	function backToCaseList(){
			router.navigate('');
		}
	
	
	var vm = {
		activate : activate,
		backToCaseList:backToCaseList

	};
	return vm;

	
	
	function activate() {
		console.log('Topnav activated...');

	}

});