// --------------
var StarOutSrc = 'img/images/starOut.png';
var StarOnSrc = 'img/images/starOver.png';
var n = 5; 
// --------------
function init(){
  var html = '';
  for (i=0; i<n; i++){
    id = i+1;
    html += '<img src="'+StarOutSrc+'" ';
    html += 'id="star" value="off" ';
    html += 'onMouseOver="over('+id+');" ';
    html += 'onMouseOut="out('+id+');" ';
    html += '<a onClick="on('+id+')"/></a>'
  }
  document.getElementById("note").innerHTML = html;

}
// --------------
function over(nb){
  elemClassement = document.getElementById("note");
  tabImg = elemClassement.getElementsByTagName("img");
  
  if (nb > 0){
    for (i=0; i<nb; i++){
      tabImg[i].src = StarOnSrc;
    }
  }
  for (i=nb; i<n; i++){
    tabImg[i].src = StarOutSrc;
  }
}
// --------------
function out(nb){
  elemClassement = document.getElementById("note");
  tabImg = elemClassement.getElementsByTagName("img");
  
  for (i=0; i<nb; i++){
    tabImg[i].src = StarOutSrc;
  }
  for (i=0; i<n; i++){
    if (tabImg[i].value == "on")
       tabImg[i].src = StarOnSrc;
  }
}
// --------------
function on(nb){
  elemClassement = document.getElementById("note");
  tabImg = elemClassement.getElementsByTagName("img");
  
  for (i=0; i<nb; i++){
    tabImg[i].src = StarOnSrc;
    tabImg[i].value="on";
  }
  for (i=nb; i<n; i++){
    tabImg[i].src = StarOutSrc;
    tabImg[i].value = "off";
  }
  // ICI, on rempli l'input hidden avec la valeur
  document.getElementById('notehidden').value = nb;
}
// --------------