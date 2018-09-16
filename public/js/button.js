$(document).ready(function() {
    $('#btnAdd').click(function() {
        var domElement = $('.clonedSection');
        var domForm  = $('.fieldset');       
        domForm.append(domElement.html());
    	});
});













