/**
  Script to show the current coordinates
  and which mouse button is clicked.
*/
function leftMouseBtnClick(event){
    
	var x = 0;
	var y = 0;
	
	x = event.clientX;
	y = event.clientY;

	alert('Left mouse button was clicked at ' + x + ',' + y);
	
};

function rightMouseBtnClick(event){
    
	var x = 0;
	var y = 0;
	
	x = event.clientX;
	y = event.clientY;

	alert('Right mouse button was clicked at ' + x + ',' + y);
	
};

