function removeItem(){
  var index = document.getElementById("removeInput");
  var listLength = document.getElementById("dynamicList").getElementsByTagName("li").length;

  if(index.value >= 0 && index.value < listLength){
    var list = document.getElementById("dynamicList");
    list.removeChild(list.childNodes[index.value]);
    saveList();
  }
}
