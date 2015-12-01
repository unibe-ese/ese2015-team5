function changeStyle(){
	var table = document.getElementById("tutorTable");
	var entries = table.getElementsByTagName("div");
	for(var i = 0, max = entries.length; i < max; i++){
		var inputs = entries[i].getElementsByTagName("input");
		for (var j = 0, m = inputs.length; j < m; j++){
			if(inputs[j].value === "free"){
				entries[i].style.backgroundColor = "#5A86B0";
			}
			if(inputs[j].value === "booked"){
				entries[i].style.backgroundColor = "#FFC878"
			}
		}
	}
}

$( document ).ready(function() {
	changeStyle();
});
