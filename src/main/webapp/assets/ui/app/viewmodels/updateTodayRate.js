define(['plugins/router', 'durandal/app','plugins/http','knockout','./productEntry'], function (router, app,http,ko,prodEntry) {


	var rootCategory = ko.observable();
	var selectedCategory = ko.observable();
	var selectedSubCategory = ko.observable();
	
	var subCategories = ko.computed(function(){
		if(selectedCategory() != undefined)
		{
			return selectedCategory().ecomCategories;
		}else{
			return "";
		}
		
	},this);
	
	var tBaseRate = ko.observable();
	var tCutRate = ko.observable();
	var specGravity = ko.observable();
	var minDimension = ko.observable();
	
	
	function activate(){
		
		var url = "/uruApp/api/prodCategory/getAllRootCategories";

		http.get(url).then(function(response) {

			if (response != null) {
				rootCategory(response);
			}
		});
		
    }
	
	selectedSubCategory.subscribe(function(subCat){
		if(subCat != undefined)
		{
			tBaseRate(subCat.tBaseRate);
			tCutRate(subCat.tCutRate);
			specGravity(subCat.specGravity);
			minDimension(subCat.minDimension);
		}
	});
	
	var updateTodayRate = function updateTodayRate(){
		 var taskFormId = 'updateTodayRate';
		        var inputs = jQuery('#' + taskFormId + ' :input,textarea');
		        var o = {};
				  jQuery.map(inputs,function(n,i){
					  if (n.name && n.name != '' && $(n).is(":visible")) {
						   o[n.name] = $(n).val();
					  }
					  return true;
				  });
				  
				  o['categoryId'] = selectedSubCategory().categoryId;
				  
				  var url = "/uruApp/api/prodCategory/updateCategoryRates";

					http.post(url,o).then(function(response) {

						if (response != null) {
							console.log("Response");
							console.log(response);
						}
					});
				  
				  
				  
	}
   
    var vm={
		activate:activate,
    		rootCategory:rootCategory,
    		subCategories:subCategories,
    		selectedCategory:selectedCategory,
    		selectedSubCategory:selectedSubCategory,
    		tBaseRate :tBaseRate,
    		tCutRate :tCutRate,
    		specGravity :specGravity,
    		minDimension :minDimension,
			updateTodayRate:updateTodayRate
        
    };
    return vm;
});