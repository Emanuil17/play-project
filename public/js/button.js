$(document).ready(function() {
    $('#btnAdd').click(function() {
        var domElement = $('.clonedSection');
        var domForm  = $('.fieldset');       
        domForm.append(domElement.html());
    	});
});







/*
$(document).ready(function(e){
	//Variables
	var domElements = '<div id="clonedSection1"> <label for="productID">Product id: </label><br/> <input type="text" class="typeahead" name = "productID" id="childproductID" /><br/> </div><label for="productName">Product name: </label><br/> <input type="text" class="typeahead" name = "productName" id="childproductName" /><br/><label for="productPrice">Product price: </label><br/><input type="text" class="typeahead" name = "productPrice" id="childproductPrice" /><br/> <input type="button" id="remove" value="Remove" /></div>';     
	var maxCopies = 5;
	var x = 1;
	
	//Add fields
	$('#btnAdd').click(function(e) {
       if(x<=maxCopies){
       $('#clonedSection1').append(domElements);
       x++;
        }
     });
	
	/*	
	 //Remove button - Deletes everything
	$("#clonedSection1").on('click','#remove',function(e){
		
		if(x>1 && x<=maxCopies){
			
		$(this).parent('div').remove();
		x--;
		}
	});
	*/
	
	/*
	$('#clonedSection1').on('dblclick','childproductID',function(e){
		$(this).val( $ ('#productID').val());
		
	});
	
	$('#clonedSection1').on('dblclick','childproductName',function(e){
		$(this).val( $ ('#productName').val());
		
	});
	
	$('#clonedSection1').on('dblclick','childproductPrice',function(e){
		$(this).val( $ ('#productPrice').val());
		
	});
	
	
});

*/







