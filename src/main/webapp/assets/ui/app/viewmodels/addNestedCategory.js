define(['plugins/router', 'durandal/app','plugins/http','knockout','./productEntry'], function (router, app,http,ko,prodEntry) {

	
	function activate(){
		
		
    }
	
	function check(rootCategory){
		
		if(rootCategory.ecomCategories > 0){
			
			
		}
		
	}
	
	var createNestedCategory = function createNestedCategory(){
		 var taskFormId = 'createNestedCategory';
		        var inputs = jQuery('#' + taskFormId + ' :input,textarea');
		        var o = {};
				  jQuery.map(inputs,function(n,i){
					  if (n.name && n.name != '' && $(n).is(":visible")) {
						   o[n.name] = $(n).val();
					  }
					  return true;
				  });
				  
				  var rootCategory = prodEntry.newObjectToSave();
				  rootCategory.ecomCategories = [o];
//				  console.log("XXXXXXXXXXX Sub Category Data XXXXXXXXXXXX");
//				  console.log(rootCategory);
				  
				  var url = "/uruApp/api/prodCategory/uppdateCategory";

					http.post(url,rootCategory).then(function(response) {

						if (response != null) {
							console.log("Response");
							console.log(response);
							
						}
					}).then(function(afterResp){
						prodEntry.activate();
					});
				  
				  
				  
	}
   
    var vm={
    		createNestedCategory:createNestedCategory
        
    };
    return vm;
});