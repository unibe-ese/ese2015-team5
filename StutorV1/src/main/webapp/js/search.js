
function myFunction(){
	var sq = document.getElementById('searchQuery').value;
	console.log(sq);
}

function ajaxTest() {
      var xhttp = new XMLHttpRequest();
			xhttp.open("GET", "ajaxTest", true);
  		xhttp.send();
			console.log(xhttp.responseText());
		}
