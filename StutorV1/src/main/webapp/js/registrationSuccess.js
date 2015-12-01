
function displaySuccess(output){
  var div = document.getElementById('registration-Message');

  div.innerHTML = output;
}

function getArg(search){
  var pageURL = window.location.search.substring(1);
  var args = pageURL.split("&");
  console.log(args);
  for (var i=0;i<args.length;i++) {
    var pair = args[i].split("=");
    if (pair[0] == "success") {
      return pair[1];
      }
  }
}


$( document ).ready(function() {
  if( getArg('success') == "true"){
	   displaySuccess('Created Account');
    }
});
