define(['plugins/router', 'durandal/app','plugins/http','knockout'], function (router, app,http,ko) {

    var email=ko.observable();
    var password=ko.observable();
    var rememberMe=ko.observable();

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

    function canReuseForRoute(){
        console.log("some route called.");
        console.log(arguments);

        return true;
    }

    function logout(){
        window.location.href='/uruApp/index.html';
    }

    function activate(){
        console.log("login activated");
    }

    function signIn(){

    	if(password() == email()) {
    		router.navigate('home');
    	}
				
    }
});