define(['plugins/router', 'durandal/app','plugins/http','knockout','./productEntry'], function (router, app,http,ko,prodEntry) {

	
	
	var largeImgURL = ko.observable();
	var smallImgURL = ko.observable();
	var imageList = ko.observableArray();
	
	function activate(){
    }
	
	
	var createRootCategory = function createRootCategory(){
		 var taskFormId = 'createRootCategory';
		        var inputs = jQuery('#' + taskFormId + ' :input,textarea');
		        var o = {};
				  jQuery.map(inputs,function(n,i){
					  if (n.name && n.name != '' && $(n).is(":visible")) {
						   o[n.name] = $(n).val();
					  }
					  return true;
				  });
				  
//				  console.log("XXXXXXXXXXX Root Category Data XXXXXXXXXXXX");
//				  console.log(JSON.stringify(o));
				  
				  var rootCategory = o;
				//  rootCategory.ecomCategories = ;
//				  console.log("XXXXXXXXXXX Sub Category Data XXXXXXXXXXXX");
//				  console.log(rootCategory);
				  
				  var url = "/uruApp/api/prodCategory/createCategory";

					http.post(url,rootCategory).then(function(response) {

						if (response != null) {
							console.log("Response");
							console.log(response);
							prodEntry.showAddRootCat(false);
							
						}
					}).then(function(afterResp){
						prodEntry.getAllRootCategories();
					});
				  
				  
				  
	}
	
	function handleImages(files) {
		for (i = 0; i < files.length; i++) {
			imageList.push(files[i]);
		}
	};
	
	function uploadImages(data,e,param) {
		if (imageList().length < 1) {
				alert("Please select a file to upload");
					return false;
		} else {
					var formData = new FormData();
					var xhr = new XMLHttpRequest();
					for (i = 0; i < imageList().length; i++) {
						if (xhr.upload) {
							formData.append("fileToUpload[]", imageList()[i]);
						} else {
							alert("Please select a valid file (jpg,png,pdf,doc,docx formats supported).");
							return false;
						}
					}
					
					var subCategory = prodEntry.newObjectToSave()
					formData.append("rootFolder", "RootCategory");
					formData.append("subFolder", "Category");
					var newPath = "/RootCategory/Category/"+ $("#"+param).val().replace(/C:\\fakepath\\/i, '');
					if(param == "uploadSmallCategory"){
						smallImgURL(newPath);
					}else{
						largeImgURL(newPath);
					}
					xhr.open("POST",
							"/uruApp/api/fileupload/uploadFile",
							true);
					// xhr.setRequestHeader("X_FILENAME", tsAttachmentFileList()[i].name);
					xhr.setRequestHeader("Accept-Encoding",
							"multipart/form-data");
					xhr.send(formData);
					xhr.onreadystatechange = function() {
						if (xhr.readyState == xhr.DONE) {
							if (xhr.status == 200) {
								reset();
								//alert(xhr.response);
							} else if(xhr.status == 0) {
								reset();
								alert("Upload failed, file is too large.");
								return false;
							}
						}
					}
				}
			};
			
			
			function reset() {
				imageList.removeAll();
		};
   
    var vm={
		createRootCategory:createRootCategory,
		smallImgURL:smallImgURL,
		largeImgURL:largeImgURL,
		handleImages:handleImages,
		uploadImages:uploadImages,
		reset:reset
        };
    return vm;
});