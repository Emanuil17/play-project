
/*


var CompanyData = [{
   id:"1",
   name:"Apple",
   empNum:"1000",
   email:"appleapplestore.com",
   productID:"1",
   productName:"Iphone",
   productPrice:"2000"
},{
   id:"2",
   name:"Microsoft",
   empNum:"3000",
   email:"microsoftgmail.com",
   productID:"2",
   productName:"Microsoft office",
   productPrice:"20"
},{
   id:"3",
   name:"Nokia",
   empNum:"4000",
   email:"nokiaapplestore.com",
   productID:"3",
   productName:"Nokia Z1",
   productPrice:"500"
}];

var ids = new Bloodhound({
	  datumTokenizer: function(d) {
	    return Bloodhound.tokenizers.whitespace(d.id);
	  },
	  queryTokenizer: Bloodhound.tokenizers.whitespace,
	  local: CompanyData
	});

var names = new Bloodhound({
  datumTokenizer: function(d) {
    return Bloodhound.tokenizers.whitespace(d.name);
 },
  queryTokenizer: Bloodhound.tokenizers.whitespace,
  local: CompanyData
});

var empNums = new Bloodhound({
  datumTokenizer: function(d) {
    return Bloodhound.tokenizers.whitespace(d.empNum);
 },
  queryTokenizer: Bloodhound.tokenizers.whitespace,
  local: CompanyData
});

var emails = new Bloodhound({
  datumTokenizer: function(d) {
    return Bloodhound.tokenizers.whitespace(d.email);
 },
 queryTokenizer: Bloodhound.tokenizers.whitespace,
 local: CompanyData
});

var productIDs = new Bloodhound({
 datumTokenizer: function(d) {
    return Bloodhound.tokenizers.whitespace(d.productID);
 },
  queryTokenizer: Bloodhound.tokenizers.whitespace,
  local: CompanyData
});

var productNames = new Bloodhound({
	  datumTokenizer: function(d) {
	    return Bloodhound.tokenizers.whitespace(d.productName);
	  },
	  queryTokenizer: Bloodhound.tokenizers.whitespace,
	  local: CompanyData
});

var productPrices = new Bloodhound({
	datumTokenizer: function(d) {
	return Bloodhound.tokenizers.whitespace(d.productPrice);
  },
  queryTokenizer: Bloodhound.tokenizers.whitespace,
  local: CompanyData
});
// Initialise Bloodhound suggestion engines for each input
ids.initialize();
names.initialize();
empNums.initialize();
emails.initialize();
productIDs.initialize();
productNames.initialize();
productPrices.initialize();

// Make the code less verbose by creating variables for the following
var idTypeahead = $('#id.typeahead');
var nameTypeahead = $('#name.typeahead');
var empNumTypeahead = $('#empNum.typeahead');
var emailTypeahead = $('#email.typeahead');
var productIDTypeahead = $('#productID.typeahead');
var productNameTypeahead = $('#productName.typeahead');
var productPriceTypeahead = $('#productPrice.typeahead');


//Initialise typeahead for the employee name
idTypeahead.typeahead({
  hint: true,
  highlight: true,
  minLength: 1
}, {
  name: 'id',
  displayKey: 'id',
  source: ids.ttAdapter()
});

// Initialise typeahead for the employee name
nameTypeahead.typeahead({
  hint: true,
  highlight: true,
  minLength: 1
}, {
  name: 'name',
  displayKey: 'name',
  source: names.ttAdapter()
});

empNumTypeahead.typeahead({
  hint: true,
  highlight: true,
  minLength: 1
}, {
  name: 'empNum',
  displayKey: 'empNum',
  source: empNums.ttAdapter()
});

emailTypeahead.typeahead({
  hint: true,
  highlight: true,
  minLength: 1
}, {
  name: 'email',
  displayKey: 'email',
  source: emails.ttAdapter()
});

productIDTypeahead.typeahead({
   hint: true,
   highlight: true,
   minLength: 1
}, {
   name: 'productID',
   displayKey: 'productID',
   source: productIDs.ttAdapter()
});

productNameTypeahead.typeahead({
   hint: true,
   highlight: true,
   minLength: 1
}, {
   name: 'productName',
   displayKey: 'productName',
   source: productNames.ttAdapter()
});

productPriceTypeahead.typeahead({
   hint: true,
   highlight: true,
   minLength: 1
}, {
   name: 'productPrice',
   displayKey: 'productPrice',
   source: productPrices.ttAdapter()
});

// Set-up event handlers so that the ID is auto-populated in the id typeahead input when the name is
// selected an vice versa


var idItemSelectedHandler = function(eventObject, suggestionObject, suggestionDataset) {
	  nameTypeahead.typeahead('val',suggestionObject.name);
	  empNumTypeahead.typeahead('val',suggestionObject.empNum);
	  emailTypeahead.typeahead('val',suggestionObject.email);
	  productIDTypeahead.typeahead('val',suggestionObject.productID);
	  productNameTypeahead.typeahead('val',suggestionObject.productName);
	  productPriceTypeahead.typeahead('val',suggestionObject.productPrice);
};

var nameItemSelectedHandler = function(eventObject, suggestionObject, suggestionDataset) {
	  idTypeahead.typeahead('val',suggestionObject.id);
	  empNumTypeahead.typeahead('val',suggestionObject.empNum);
	  emailTypeahead.typeahead('val',suggestionObject.email);
	  productIDTypeahead.typeahead('val',suggestionObject.productID);
	  productNameTypeahead.typeahead('val',suggestionObject.productName);
	  productPriceTypeahead.typeahead('val',suggestionObject.productPrice);
};
// CHANGED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
var empNumItemSelectedHandler = function(eventObject, suggestionObject, suggestionDataset) {
	  idTypeahead.val(suggestionObject.id);  
	  nameTypeahead.val(suggestionObject.name);
	  emailTypeahead.val(suggestionObject.email);
	  productIDTypeahead.val(suggestionObject.productID);
	  productNameTypeahead.val(suggestionObject.productName);
	  productPriceTypeahead.val(suggestionObject.productPrice);
};

var emailItemSelectedHandler = function(eventObject, suggestionObject, suggestionDataset) {
	  idTypeahead.val(suggestionObject.id);  
	  nameTypeahead.val(suggestionObject.name);
	  empNumTypeahead.val(suggestionObject.empNum);
	  productIDTypeahead.val(suggestionObject.productID);
	  productNameTypeahead.val(suggestionObject.productName);
	  productPriceTypeahead.val(suggestionObject.productPrice);
};

var productIDItemSelectedHandler = function(eventObject, suggestionObject, suggestionDataset) {
	  idTypeahead.val(suggestionObject.id);  
	  nameTypeahead.val(suggestionObject.name);
	  empNumTypeahead.val(suggestionObject.empNum);
	  emailTypeahead.val(suggestionObject.email);
	  productNameTypeahead.val(suggestionObject.productName);
	  productPriceTypeahead.val(suggestionObject.productPrice);
};

var productNameItemSelectedHandler = function(eventObje	ct, suggestionObject, suggestionDataset) {
	  idTypeahead.val(suggestionObject.id);  
	  nameTypeahead.val(suggestionObject.name);
	  empNumTypeahead.val(suggestionObject.empNum);
	  emailTypeahead.val(suggestionObject.email);
	  productIDTypeahead.val(suggestionObject.productID);
	  productPriceTypeahead.val(suggestionObject.productPrice);
};

var productPriceItemSelectedHandler = function(eventObject, suggestionObject, suggestionDataset) {
	  idTypeahead.val(suggestionObject.id);  
	  nameTypeahead.val(suggestionObject.name);
	  empNumTypeahead.val(suggestionObject.empNum);
	  emailTypeahead.val(suggestionObject.email);
	  productIDTypeahead.val(suggestionObject.productID);
	  productNameTypeahead.val(suggestionObject.productName);
};
// Associate the typeahead:selected event with the bespoke handler
idTypeahead.on('typeahead:selected', idItemSelectedHandler);
nameTypeahead.on('typeahead:selected', nameItemSelectedHandler);
empNumTypeahead.on('typeahead:selected', empNumItemSelectedHandler);
emailTypeahead.on('typeahead:selected', emailItemSelectedHandler);
productIDTypeahead.on('typeahead:selected', productIDItemSelectedHandler);
productNameTypeahead.on('typeahead:selected', productNameItemSelectedHandler);
productPriceTypeahead.on('typeahead:selected', productPriceItemSelectedHandler);
*/