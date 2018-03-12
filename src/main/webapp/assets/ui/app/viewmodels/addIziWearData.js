define(['plugins/router', 'durandal/app','plugins/http','knockout','./productEntry'], function (router, app,http,ko,prodEntry) {

    var calcTemplates = ko.observableArray();
    var selectedTemplate = ko.observable();
    var imageList = ko.observableArray();

    var largeImgURL = ko.observable();
    var smallImgURL = ko.observable();

    var selectRootCategory = ko.observableArray([{name:"OPTIMET",value:"OPTIMET"},{name:"OPTITRADE",value:"OPTITRADE"},{name:"OPTIBUY",value:"OPTIBUY"},{name:"OPTIBRAND",value:"OPTIBRAND"},{name:"OPTIWEAR",value:"OPTIWEAR"}]);
    var selectedRootCategory = ko.observable();

    var showIziWearData = ko.observable(false);


    var showAddIziWearProduct = ko.observable(false);

    function activate(){
        http.get("/uruApp/api/prodCategory/getCalcTemplates").then(function(response) {
            if (response != null) {
                calcTemplates(response);
            }
        });
    }


    selectedRootCategory.extend({
        notify : 'always'
    });
    selectedRootCategory.subscribe(function(newVal) {

        //TODO: !!!! get correct category name here
        if(newVal.value == 'OPTIWEAR'){
            showAddIziWearProduct(true);
        }

    });

    var addIziwearData = function addIziwearData(){
        showIziWearData(true);
    }

    var createProduct = function createProduct(){
        var taskFormId = 'createProduct';
        var inputs = jQuery('#' + taskFormId + ' :input,textarea');
        var o = {};
        jQuery.map(inputs,function(n,i){
            if (n.name && n.name != '' && $(n).is(":visible")) {
                o[n.name] = $(n).val();
            }
            if(selectedTemplate() != null && selectedTemplate() != undefined){
                if(selectedTemplate().templateName != undefined){
                    o["calcTemplate"] = selectedTemplate().templateName;
                }
            }
            return true;
        });


        var iziWearFormId = 'iziwearForm';
        var iziWearInputs = jQuery('#' + iziWearFormId + ' :input,textarea');

        var m = {};

        jQuery.map(iziWearInputs,function(n,i){
            if (n.name && n.name != '' && $(n).is(":visible")) {
                m[n.name] = $(n).val();
            }

            return true;
        });

        o["iziWearDataModel"] = m;


        var subCategory = prodEntry.newObjectToSave();
        subCategory.ecomProducts = [o];
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
            formData.append("rootFolder", subCategory.categoryId);
            formData.append("subFolder", "Product");

            var newPath = "/"+subCategory.categoryId+"/Product/"+ $("#"+param).val().replace(/C:\\fakepath\\/i, '');
            if(param == "uploadSmallProductImg"){
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
        activate:activate,
        createProduct:createProduct,
        calcTemplates:calcTemplates,
        selectedTemplate:selectedTemplate,
        uploadImages:uploadImages,
        handleImages:handleImages,
        reset:reset,
        smallImgURL:smallImgURL,
        largeImgURL:largeImgURL,
        selectRootCategory:selectRootCategory,
        selectedRootCategory:selectedRootCategory,
        showIziWearData:showIziWearData,
        showAddIziWearProduct:showAddIziWearProduct,
        addIziwearData:addIziwearData
    };
    return vm;
});