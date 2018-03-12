define(
		[ 'knockout', 'jquery', 'bootstrap', 'plugins/http', 'toastr' ],
		function(ko, $, bootstrap, http, toastr) {

			var products = ko.observableArray();
			var showCalculator = ko.observable(false);
			var selectedCategory = ko.observable();

			var selectedProduct = ko.observable();

			var tBaseRate = ko.observable();
			var tCutRate = ko.observable();
			var specGravity = ko.observable();
			var minQuantity = ko.observable();
			var calImageUrl = ko.observable();
			var prodName = ko.observable();
			var prodItems = ko.observableArray();

			var selectedItem = ko.observable();

			var templateName = ko.observable();

			var pipeThickness = ko.observableArray();
			var selectedPipeThickness = ko.observable();

			var complexItems = ko.observableArray();
			var selectedComplexItem = ko.observable();
			var complexSizes = ko.observableArray();
			var selectedComplexSize = ko.observable();
			var crossSection = ko.observable();
			var crossSectionImage = ko.observable();
			var length = ko.observable(0);
			var width = ko.observable(0);
			var quantityRequired = ko.observable(0);

			selectedItem.subscribe(function(selItem) {
				// console.log(selItem.name);

				if (selItem != undefined && templateName() != undefined) {
					switch (templateName()) {
					case "seamlessPipetemplate":
						pipeThickness(selItem.catalogPropertyValues);
						break;
					}
				}
			});
			
			selectedComplexSize.subscribe(function(selSize) {
				if (selSize != undefined) {
					crossSection(selSize.crossSection);
					crossSectionImage(selSize.image);
				}
			});

			

			selectedComplexItem.subscribe(function(newVal) {
				if (newVal != undefined) {
					
					complexSizes(newVal.itemSize);
				}

			});

			width.subscribe(function(newVal) {

				if (newVal != 0) {
					if (parseInt(width()) < parseInt(minQuantity())) {
						toastr.error("Width entered is less than Minimum dimension required ");
						width(0);
					}
				}

			});

			length.subscribe(function(newVal) {

				if (newVal != 0) {
					if (parseInt(length()) < parseInt(minQuantity())) {
						toastr.error("Length entered is less than Minimum dimension required ");
						length(0);
					}

				}

			});

			var weightOfPc = ko
					.computed(
							function() {
								if (selectedItem() != undefined) {
									if (templateName() != undefined) {
										switch (templateName()) {
										case "sheetsNFlatstemplate":
											return (parseFloat(selectedItem().name)
													* parseFloat(length()) * parseFloat(width()) * parseFloat(specGravity())) / 100000;
										case "checkerPlatestemplate":
											return ((parseFloat(selectedItem().name)
													* parseFloat(length()) * parseFloat(width()) * parseFloat(specGravity())) / 100000) * 1.25;
										case "roundBartemplate":
											return (((parseFloat(selectedItem().name) / 2)
													* (parseFloat(selectedItem().name) / 2)
													* parseFloat(length()) * parseFloat(specGravity())) / 100000) * 3.14;
										case "squareBartemplate":
											return ((parseFloat(selectedItem().name)
													* parseFloat(selectedItem().name)
													* parseFloat(length()) * parseFloat(specGravity())) / 100000);
										case "seamlessPipetemplate":
											if (selectedPipeThickness() != undefined) {
												return ((3.14 * (parseFloat(selectedItem().name)
														* parseFloat(selectedPipeThickness().textValue)
														* parseFloat(length()) * parseFloat(specGravity()))) / 100000) * 0.85;
											}
											break;

										}
									}

								}

							}, this);

			var totalWeight = ko.computed(function() {
				if (weightOfPc() != undefined)
					return quantityRequired() * weightOfPc();

			}, this);

			var totalPrice = ko.computed(function() {
				if (totalWeight() != undefined)
					return totalWeight() * parseFloat(tCutRate());

			}, this);

			function activate() {
			}

			function compComplete() {
			}

			var fetchProdForCategory = function fetchProducts(category) {

				console.log("Fetch Products from Category");
				console.log(category);
				tBaseRate(category.tBaseRate);
				tCutRate(category.tCutRate);
				specGravity(category.specGravity);
				minQuantity(category.minDimension);
				selectedCategory(category);
				products(category.ecomProducts);

			}

			var openCalculator = function openCalculator(prodData) {

				console.log("Slected Product ");
				console.log(prodData);
				templateName(prodData.calcTemplate);

				selectedProduct(prodData);
				showCalculator(true);
				calImageUrl(prodData.largeImgUrl);
				prodName(prodData.name);
				prodItems(prodData.ecomItems);

				var url = "/uruApp/api/prodCategory/getCalcTemplateByName?templateName="
						+ templateName();

				http.get(url).then(
						function(response) {

							if (response != null) {
								if (response.templateProperties.type != null
										&& response.templateProperties.type == "complex")
									complexItems(response.templateProperties.items);
							}
						});
			}

			var vm = {
				fetchProdForCategory : fetchProdForCategory,
				products : products,
				showCalculator : showCalculator,
				openCalculator : openCalculator,
				selectedCategory : selectedCategory,
				tBaseRate : tBaseRate,
				tCutRate : tCutRate,
				specGravity : specGravity,
				minQuantity : minQuantity,
				calImageUrl : calImageUrl,
				prodName : prodName,
				prodItems : prodItems,
				selectedItem : selectedItem,
				length : length,
				width : width,
				weightOfPc : weightOfPc,
				quantityRequired : quantityRequired,
				totalWeight : totalWeight,
				totalPrice : totalPrice,
				selectedProduct : selectedProduct,
				templateName : templateName,
				pipeThickness : pipeThickness,
				selectedPipeThickness : selectedPipeThickness,
				complexItems : complexItems,
				selectedComplexItem : selectedComplexItem,
				complexSizes : complexSizes,
				selectedComplexSize : selectedComplexSize,
				crossSection:crossSection,
				crossSectionImage:crossSectionImage
			};
			return vm;

		});