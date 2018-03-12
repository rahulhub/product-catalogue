define(['plugins/router', 'durandal/app','plugins/http','knockout','./productEntry'], function (router, app,http,ko,prodEntry) {

	var attributes = ko.observableArray();
	var largeImgURL = ko.observable();
	var smallImgURL = ko.observable();
	var imageList = ko.observableArray();
	
	function activate(){
		
		var url = "/uruApp/api/prodCategory/getAttributes";

		http.get(url).then(function(response) {

			if (response != null) {
				attributes(response);
			}
		});
		
    }
	
	var createItemMedia = function createItemMedia(){
		 var taskFormId = 'addItemMedia';
		        var inputs = jQuery('#' + taskFormId + ' :input,textarea');
		        var o = {};
				  jQuery.map(inputs,function(n,i){
					  if (n.name && n.name != '' && $(n).is(":visible")) {
						   o[n.name] = $(n).val();
					  }
					  return true;
				  });
				  
				  var subCategory = prodEntry.newObjectToSave();
				  var itemToUpdate = subCategory.ecomProducts[0].ecomItems[0];
				  o["ecomItem"] = {"sku":itemToUpdate.sku};
				  
				  var itemMedia = [o];
//				  console.log("XXXXXXXXXXX Sub Category Data XXXXXXXXXXXX");
//				  console.log(rootCategory);
				  
				  var url = "/uruApp/api/items/addItemMedia";

					http.post(url,itemMedia[0]).then(function(response) {

						if (response != null) {
							console.log("Response");
							console.log(response);
							
						}
					}).then(function(afterResp){
						prodEntry.activate();
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
					formData.append("rootFolder", subCategory.ecomProducts[0].productId);
					formData.append("subFolder", "Item");
					var newPath = "/"+ subCategory.ecomProducts[0].productId +"/Item/"+ $("#"+param).val();
					if(param == "uploadItemSmallImage"){
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
    		createItemMedia:createItemMedia,
			attributes:attributes,
			smallImgURL:smallImgURL,
			largeImgURL:largeImgURL,
			handleImages:handleImages,
			uploadImages:uploadImages,
			reset:reset
        
    };
    return vm;
});