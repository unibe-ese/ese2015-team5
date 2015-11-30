function hideAll(){
	$(".tabbable").find(".tabs").find("a").removeClass("active");
	$(".tabbable").find(".tab").hide();
}

function showTab(id){
	this.hideAll();
	if(!id){
		id = "#tab1";
	}
	$(id + "btn").addClass("active");
	$(id).show();
}

function getTab(){
  var query = window.location.search.substring(1);
  var vars = query.split("&");
  for (var i=0;i<vars.length;i++) {
    var pair = vars[i].split("=");
    if (pair[0] == "tab") {
		return pair[1];
    }
  }
}


$(document).ready(function(){
	console.log("ready");
	id = getTab();
	console.log(id);
	if(id){
		showTab("#" + id);
	} else {
		showTab();
	}
    $(".tabbable").find(".tabs").find("a").click(function(){
        tab = $(this).attr("href");
		hideAll();
		showTab(tab);
        return false;
    });
});

