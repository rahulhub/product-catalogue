define([ 'knockout', 'jquery', 'bootstrap','plugins/http','./optiMatContent'], function(ko, $, bootstrap,http,optiMatContent) {

	this.selectedNodes = ko.observableArray([]);
	  
	this.data = ko.observableArray();

	function activate() {
		
		   
    ko.bindingHandlers.treeView = {
    		  
    		   createNodes: function(rootElement, options){
    		    
    		     var rootTmpl = '<script id="ko-treeview-root-tmpl"><ul class="ko-treeview-list" data-bind="template:{foreach:$data.data,name:\'ko-treeview-node-tmpl\'}"></ul></script>';
    		    
    		     var nodeTmpl = '<script id="ko-treeview-node-tmpl"><li class="ko-treeview-listitem"><div data-bind="template:{name:\'ko-treeview-item-tmpl\',data:$data}"></div><ul class="ko-treeview-list" data-bind="template:{name:\'ko-treeview-node-tmpl\',foreach:$data[$root.childNode]}"></div></li></script>';
    		   
    		     var itemTmpl ='<script id="ko-treeview-item-tmpl"><div data-bind="visible:$data[$root.label].indexOf($root.search()) > -1"><label  class="ko-treeview-label" data-bind="text:$data[$root.label], attr:{for:$data[$root.label]},, click: function (data,event){$root.selected($data)}"></label></div></script>'
    		     
    		      //append templates
    		       document.body.insertAdjacentHTML('beforeend', rootTmpl);
    		       document.body.insertAdjacentHTML('beforeend', nodeTmpl);
    		       document.body.insertAdjacentHTML('beforeend', itemTmpl);
    		     
    		       //apply first binding
    		       ko.applyBindingsToNode(rootElement, {template:{name:"ko-treeview-root-tmpl"}},options);
    		      
    		  },
    		    init: function(element, valueAccessor) {
    		      
    		      //style element
    		      element.className = "ko-treeview-container";
    		      
    		      //extend options with search
    		      var options = valueAccessor();
    		      options.search = ko.observable("");
    		      
    		      //set default data values
    		      if(!options.label) options.label = 'name';
    		      if(!options.childNode) options.childNode = 'ecomCategories';
    		      
    		     //create the tree
    		      ko.bindingHandlers.treeView.createNodes(element,options);
    		      valueAccessor().data.subscribe(function(){
    		        ko.bindingHandlers.treeView.createNodes(element,options);
    		      });
    		      
    		      
    		       //let this handler control its descendants. 
    		       return { controlsDescendantBindings: true };
    		    }
    		    
    		};
		
		
		
		var url = "/uruApp/api/prodCategory/getAllRootCategories";

		http.get(url).then(function(response) {

			if (response != null) {
				data(response);
			}
		});
		
	}
	
	var selectedCategory = function selectedCategory(category){
		console.log("Selected Category");
		console.log(category)
		optiMatContent.fetchProdForCategory(category);
	}
	
	function compComplete(){
	}
	
	var vm = {
		activate:activate,
		selectedCategory:selectedCategory
	};
	return vm;
	/*function logout(){
		console.log('logout called...');
		session.logout();
	}*/

});