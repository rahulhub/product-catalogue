define([ 'knockout', 'jquery', 'bootstrap' ], function(ko, $, bootstrap) {

	var vm = {
	};
	return vm;

	function activate() {
		console.log('Footer activate...');
        console.log(session.profile.roles());
	}
	
	/*function logout(){
		console.log('logout called...');
		session.logout();
	}*/

});