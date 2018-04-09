function saveList(){
  var mylist = [];

  $("#dynamicList > li").each(function () {
      mylist.push({
          "id": $(this).attr("id"),
          // "name": $(this).("span.listNames").html(),
          "name": $(this).find('span').html(),
          "price": $(this).attr("price")
      });
  });

  $("#result").html(JSON.stringify(mylist));
  //console.log(mylist);

  postToServer({list: JSON.stringify(mylist)});
}


function postToServer(myList){
  var url = 'http://localhost:3001/addItem';

  $.post(url, myList)
   .done(resp => console.log(resp))
   .fail(err => console.error(err))
   .always(() => console.log('End'));
}
