$(document).ready(function(){
	var self = this;
	hideAll();
	showStoredTab();
    $(".tabbable").find(".tabs").find("a").click(function(){
        var id = $(this).attr("href");
		hideAll();
		storeTab(id);
		showTab(id);
        return false;
    });
});
function hideAll(){
	$(".tabbable").find(".tabs").find("a").removeClass("active");
	$(".tabbable").find(".tab").hide();
}

function showTab(id){
	this.hideAll();
	$(id + "btn").addClass("active");
	$(id).show();
}

function storeTab(id){
	location.hash = id;
}

function showStoredTab(){
	if (location.hash){
		showTab(location.hash);
	} else {
		showTab("#tab1");
	}
}

/*
$(document).ready(function(){
    $(".tabbable").find(".tab").hide();
    $(".tabbable").find(".tab").first().show();
    $(".tabbable").find(".tabs li").first().find("a").addClass("active");
    $(".tabbable").find(".tabs").find("a").click(function(){
        tab = $(this).attr("href");
        $(".tabbable").find(".tab").hide();
        $(".tabbable").find(".tabs").find("a").removeClass("active");
        $(tab).show();
        $(this).addClass("active");
        return false;
    });
});

*/