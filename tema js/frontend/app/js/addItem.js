function addItem(){
  var ul = document.getElementById("dynamicList")

  var li = document.createElement("li");
  var name = document.createElement("span");
  name.className = "listNames";
  var price = document.createElement("span");

  var nameInput = document.getElementById("nameInput");
  var priceInput = document.getElementById("priceInput");
  var list = document.getElementById("dynamicList").getElementsByTagName("li");
  var listLength = document.getElementById("dynamicList").getElementsByTagName("li").length;

  //--Generate ids
  if (list.length > 0){
    var max, nr;

    max = parseInt(list[0].id);
    for(var i in list){
      nr = parseInt(list[i].id);
      if(nr>max){
        max = nr;
      }
    }

    var idValue = max+1;
  }else {
    idValue = 0;
  }
  //-----------

  if (nameInput.value != "" && priceInput.value > 0) {
    li.setAttribute('name',nameInput.value);
    li.setAttribute('id', idValue);
    li.setAttribute('price',priceInput.value);

    name.appendChild(document.createTextNode(nameInput.value));
    price.appendChild(document.createTextNode(", Price:" + priceInput.value));
    li.appendChild(name);
    li.appendChild(price);

    ul.appendChild(li);

    saveList();
  }
}
