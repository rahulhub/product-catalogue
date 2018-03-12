define(['plugins/router', 'durandal/app','knockout','viewmodels/login','plugins/http'], function (router, app,ko,login,http) {

   // window.session = session;
  //  console.log(window.session);

    router.guardRoute=function(instance, instruction){
        /*if (session.isAuthenticated() === false) {
            //TODO redirect to login page.
            window.location.href = '/CaseManagementSystem/login.jsp';
            return 'login';
        }else{
           //proceed.
        }*/

        return true;
    };
    return {
        router: router,
        search: function() {
            //It's really easy to show a message box.
            //You can add custom options too. Also, it returns a promise for the user's response.
            app.showMessage('Search not yet implemented...');
        },
        activate: function () {
			//$.blockUI.defaults.css = {}
//        	$(document).ajaxStart($.blockUI({ css: { 
//            border: 'none', 
//            padding: '0px', 
//            backgroundColor: '#000', 
//            '-webkit-border-radius': '10px', 
//            '-moz-border-radius': '10px', 
//            opacity: .5, 
//            color: '#fff' 
//        } })).ajaxStop($.unblockUI);
            // router.guardRoute=guardRoute;
            // read local storage or cookies to get existing data
            // validate on the server, on fail, redirect to login page.
            // on success, display all account info and continue.

            router.map([
                { route:'',moduleId:'viewmodels/login',nav:true,title:'Login'},
                { route:'home',moduleId:'viewmodels/karobarMain',nav:true,title:'URU Home'},
                { route:'content',moduleId:'viewmodels/content',nav:true,title:'Content'},
                { route:'productEntry',moduleId:'viewmodels/productEntry',nav:true,title:'Product Entry'},
                { route:'updateRates',moduleId:'viewmodels/updateTodayRate',nav:true,title:'Update Rates'}
            ]).buildNavigationModel();
            return router.activate();
           /* var data=null;
            if(typeof(Storage) !== "undefined") {
                    data=sessionStorage.hsn18_cms_session;
            } else {
                data=readCookie("hsn18_cms_session");
                function readCookie(name) {
                    var nameEQ = name + "=";
                    var ca = document.cookie.split(';');
                    for (var i = 0; i < ca.length; i++) {
                        var c = ca[i];
                        while (c.charAt(0) == ' ') c = c.substring(1, c.length);
                        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
                    }
                    return null;
                }
            }

            var obj=JSON.parse(data);
            if(!obj){
                //TODO redirect to login page.
                window.location.href = '/CaseManagementSystem/login.jsp';
                return false;
            }
            //validate on server.
            return http.post('/CaseManagementSystem/api/auth/validatesession',{userName:obj.account.userName,token:obj.token}).then(function(response){
                if(response.validation==true){
                    session.isAuthenticated(true);
                    session.profile.populate(obj);

                }else{
                    //TODO redirect to login page.
                    window.location.href = '/CaseManagementSystem/login.jsp';
                    return false;
                }
            });*/

        },
        logout:function(){
            login.logout();
        }
    };
    
 
    
    
    
    
    
});