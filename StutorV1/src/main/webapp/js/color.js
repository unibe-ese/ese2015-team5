function changeStyle(){
	var table = document.getElementsByClassName("courseTable");
	var entries = table[0].getElementsByTagName("td");
	for(var i = 0, max = entries.length; i < max; i++){
		var inputs = entries[i].getElementsByTagName("input");
		for (var j = 0, m = inputs.length; j < m; j++){
			if(inputs[j].value === "free"){
				entries[i].className = "available";
			}
			if(inputs[j].value === "unfree"){
				entries[i].className = "taken";
			}
		}
	}
}

$( document ).ready(function() {
	changeStyle();
});