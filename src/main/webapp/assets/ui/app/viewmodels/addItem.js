define(['plugins/router', 'durandal/app','plugins/http','knockout','./productEntry'], function (router, app,http,ko,prodEntry) {

	var attributes = ko.observableArray();
	function activate(){
		
		var url = "/uruApp/api/prodCategory/getAttributes";

		http.get(url).then(function(response) {

			if (response != null) {
				attributes(response);
			}
		});
		
    }
	
	var createItem = function createItem(){
		 var taskFormId = 'createItem';
		        var inputs = jQuery('#' + taskFormId + ' :input,textarea');
		        var o = {};
				  jQuery.map(inputs,function(n,i){
					  if (n.name && n.name != '' && $(n).is(":visible")) {
						   o[n.name] = $(n).val();
					  }
					  return true;
				  });
				  
				  var subCategory = prodEntry.newObjectToSave();
				  subCategory.ecomProducts[0].ecomItems = [o];
//				  console.log("XXXXXXXXXXX Sub Category Data XXXXXXXXXXXX");
//				  console.log(rootCategory);
				  
				  var url = "/uruApp/api/prodCategory/uppdateCategory";

					http.post(url,subCategory).then(function(response) {

						if (response != null) {
							console.log("Response");
							console.log(response);
							
						}
					}).then(function(afterResp){
						prodEntry.activate();
					});
				  
				  
				  
	}
   
    var vm={
    		createItem:createItem,
			attributes:attributes
        
    };
    return vm;
});