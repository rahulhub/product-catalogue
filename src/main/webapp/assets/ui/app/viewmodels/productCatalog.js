define(['plugins/router', 'durandal/app','plugins/http','knockout'], function (router, app,http,ko) {

	
	function activate(){
        console.log("login activated");
    }
   
    var vm={
        email:email,
        password:password,
        rememberMe:rememberMe,
        signIn:signIn,
        activate: activate,
        logout:logout,
        canReuseForRoute: canReuseForRoute
    };
    return vm;

    

    

   
});