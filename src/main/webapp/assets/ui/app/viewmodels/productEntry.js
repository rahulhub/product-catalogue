define(
		[ 'knockout', 'plugins/http', 'jquery', 'bootstrap' ],
		function(ko, http, $, bootstrap) {

			var rootCategory = ko.observable();
			var selectedCategory = ko.observable();
			var selectedSubCategory = ko.observable();
			var selectedLevel2Category = ko.observable();
			var selectedLevel3Category = ko.observable();
			var selectedLevel4Category = ko.observable();
			var selectedProduct = ko.observable();
			var selectedItem = ko.observable();

			var showAddRootCat = ko.observable(false);
			var showAddSubCat = ko.observable(false);
			var showAddProduct = ko.observable(false);
			
			var showAddItem = ko.observable(false);
			var showAddAttr = ko.observable(false);
			var showAddItemMedia = ko.observable(false);

			

			var newObjectToSave = ko.observable();

			var itemAttributes = ko.observableArray();

			var attributes = ko.observableArray();
			var selectedAttributes = ko.observable();

			var subCatLevels = ko.observable(1);

			var nextLevSubCate = ko.observableArray();
			
			var prodInCategory = ko.observable();


			
			var subCategories = ko.computed(function() {
				if (selectedCategory() != undefined) {
					return selectedCategory().ecomCategories;
				} else {
					return "";
				}

			}, this);

			var level2Categories = ko.computed(function() {
				if (selectedSubCategory() != undefined) {
					return selectedSubCategory().ecomCategories;
				} else {
					return "";
				}

			}, this);

			var level3Categories = ko.computed(function() {
				if (selectedLevel2Category() != undefined) {
					return selectedLevel2Category().ecomCategories;
				} else {
					return "";
				}

			}, this);

			var level4Categories = ko.computed(function() {
				if (selectedLevel3Category() != undefined) {
					return selectedLevel3Category().ecomCategories;
				} else {
					return "";
				}

			}, this);

			
			var items = ko.computed(function() {
				if (selectedProduct() != undefined) {
					return selectedProduct().ecomItems;
				} else {
					return "";
				}

			}, this);

			// ##########################################

			selectedCategory.extend({
				notify : 'always'
			});
			selectedCategory.subscribe(function(newVal) {

				if (newVal != undefined) {
					var newValue = jQuery.extend(true, {}, newVal);
					newObjectToSave(newValue);
					// newObjectToSave().ecomCategories = [];
				}

			});

			selectedSubCategory.extend({
				notify : 'always'
			});
			selectedSubCategory.subscribe(function(subCat) {

				if (subCat != undefined) {
					newObjectToSave().ecomCategories = [ subCat ];
					newObjectToSave(newObjectToSave().ecomCategories[0]);
				}

			});

			selectedLevel2Category.extend({
				notify : 'always'
			});
			selectedLevel2Category.subscribe(function(l2Cat) {

				if (l2Cat != undefined) {
					newObjectToSave().ecomCategories = [ l2Cat ];
					newObjectToSave(newObjectToSave().ecomCategories[0]);

				}
			});

			selectedLevel3Category.extend({
				notify : 'always'
			});
			selectedLevel3Category.subscribe(function(l3Cat) {
				if (l3Cat != undefined) {
					newObjectToSave().ecomCategories = [ l3Cat ];
					newObjectToSave(newObjectToSave().ecomCategories[0]);
				}
			});

			selectedLevel2Category.extend({
				notify : 'always'
			});
			selectedLevel4Category.subscribe(function(l4Cat) {
				if (l4Cat != undefined) {
					newObjectToSave().ecomCategories = [ l4Cat ];
					newObjectToSave(newObjectToSave().ecomCategories[0]);

				}
			});

			// ##############################################################

			selectedProduct
					.subscribe(function(selProd) {
						if (selProd != undefined) {
							newObjectToSave().ecomProducts = [ selProd ];
							//newObjectToSave(newObjectToSave().ecomProducts[0]);
						}
					});

			selectedItem
					.subscribe(function(selItem) {
						if (selItem != undefined) {
							newObjectToSave().ecomProducts[0].ecomItems = [ selItem ];
							itemAttributes.removeAll();
							ko.utils.arrayForEach(selItem.catalogPropertyValues, function (val) {
								itemAttributes.push(val);
							})
						}
					});
			selectedAttributes.subscribe(function(selAtt) {

			});

			function activate() {
				showAddSubCat(false);
				showAddProduct(false);
				showAddItem(false);
				//itemAttributes('');
				newObjectToSave('');
				
				getAllRootCategories();
				

				var attrUrl = "/uruApp/api/prodCategory/getAttributes";

				http.get(attrUrl).then(function(response) {

					if (response != null) {
						attributes(response);
					}
				});
				
			}
			
			var getAllRootCategories = function getAllRootCategories(){
				var url = "/uruApp/api/prodCategory/getAllRootCategories";

				http.get(url).then(function(response) {

					if (response != null) {
						rootCategory(response);
					}
				});
				
			}

			var addRootCategory = function addRootCategory() {
				
				if(showAddRootCat() == true)
					showAddRootCat(false);
				else
					showAddRootCat(true);
			}

			var addSubCategory = function addSubCategory() {
				if(showAddSubCat() == true)
					showAddSubCat(false);
				else
					showAddSubCat(true);
				
			}

			var addProduct = function addProduct() {
				showAddProduct(true);
				console.log(newObjectToSave());
				if(newObjectToSave().ecomCategories != null){

					
					newObjectToSave().ecomCategories[0].ecomProducts = [];
				}else{
					newObjectToSave().ecomProducts = [];
				}
				
			}

			var addItem = function addProduct() {
				showAddItem(true);
			}

			

			
			var addItemMedia = function addItemMedia(){
				if(showAddItemMedia() == true)
					showAddItemMedia(false);
				else
					showAddItemMedia(true);
			}

			var addAttToItem = function addAttToItem() {
				var taskFormId = 'attValue';
				var inputs = jQuery('#' + taskFormId + ' :input,textarea');
				var o = {};
				jQuery.map(inputs, function(n, i) {
					if (n.name && n.name != '' && $(n).is(":visible")) {
						o[n.name] = $(n).val();
					}
					return true;
				});

				newObjectToSave().ecomProducts[0].ecomItems[0].catalogPropertyValues = [ o ];

				newObjectToSave().ecomProducts[0].ecomItems[0].catalogPropertyValues[0]["catalogPropertyKey"] = selectedAttributes();

				console.log("XXXXXXXXXXXXFinalXXXXXXXXXXXXXXX");
				console.log(JSON.stringify(newObjectToSave()));

				var url = "/uruApp/api/prodCategory/uppdateCategory";

				http.post(url, newObjectToSave()).then(function(response) {

					if (response != null) {
						console.log("Response");
						console.log(response);

					}
				}).then(function(afterResp) {
					activate();
				});
			}

			var addAttribute = function addAttribute() {
				showAddAttr(true);
			}

			var addNestedCategory = function addNestedCategory() {

				showAddSubCat(true);

			}

			function compComplete() {
			}
			
			var fetchProducts = function fetchProducts(){
				
				if (newObjectToSave() != undefined && newObjectToSave() != '') {
					console.log(newObjectToSave());
					
					var url = "/uruApp/api/prodCategory/getProductsByCategory?categoryId=" + newObjectToSave().categoryId;

					http.get(url).then(function(response) {

					if (response != null) {
						prodInCategory(response);
						}
					});
									
				} 
			}

			var vm = {
				activate : activate,
				compositionComplete : compComplete,
				selectedCategory : selectedCategory,
				rootCategory : rootCategory,
				subCategories : subCategories,
				selectedSubCategory : selectedSubCategory,
				selectedProduct : selectedProduct,
				addSubCategory : addSubCategory,
				showAddSubCat : showAddSubCat,
				newObjectToSave : newObjectToSave,
				addProduct : addProduct,
				showAddProduct : showAddProduct,
				addItem : addItem,
				selectedItem : selectedItem,
				showAddItem : showAddItem,
				items : items,
				itemAttributes : itemAttributes,
				attributes : attributes,
				selectedAttributes : selectedAttributes,
				addAttToItem : addAttToItem,
				addAttribute : addAttribute,
				showAddAttr : showAddAttr,
				showAddRootCat : showAddRootCat,
				addRootCategory : addRootCategory,
				addNestedCategory : addNestedCategory,
				selectedLevel2Category : selectedLevel2Category,
				selectedLevel3Category : selectedLevel3Category,
				selectedLevel4Category : selectedLevel4Category,
				level2Categories : level2Categories,
				level3Categories : level3Categories,
				level4Categories : level4Categories,
				fetchProducts:fetchProducts,
				prodInCategory:prodInCategory,
				addItemMedia:addItemMedia,
				showAddItemMedia:showAddItemMedia,
				getAllRootCategories:getAllRootCategories,
				
				
				

			};
			return vm;
			/*function logout(){
				console.log('logout called...');
				session.logout();
			}*/

		});