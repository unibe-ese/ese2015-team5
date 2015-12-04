
function displaySuccess(output){
  var div = document.getElementById('edit-Message');
  div.className = div.className + "success-Message";
  div.innerHTML = output + ' successfull';
}

function displayFail(output){
  var div = document.getElementById('edit-Message');
  div.className = div.className + "error-Message";
  div.innerHTML = output + ' failed';
}

function getArg(search){
  console.log('SearchQuery: ' + search);
  var pageURL = window.location.search.substring(1);
  var args = pageURL.split("&");
  console.log(args);
  for (var i=0; i<args.length; i++) {
    var pair = args[i].split("=");
    if (pair[0] == search) {
      return pair[1];
      }
  }
}


$( document ).ready(function() {
  var arg = getArg('edit');
  console.log('arg: ' + arg);
  if( arg == 'success'){
      console.log('edit = Success');
      displaySuccess('Edit');
    }
    else if( arg == 'fail'){
      console.log('edit = fail');
      displayFail('Edit');
    }
});
