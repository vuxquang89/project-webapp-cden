function readMore() {
    var dots = document.getElementById("dots");
    var moreText = document.getElementById("more");
    var btnText = document.getElementById("readmore");
  
    if (dots.style.display === "none") {
      dots.style.display = "inline";
      btnText.innerHTML = "Xem thêm"; 
      moreText.style.display = "none";
    } else {
      dots.style.display = "none";
      btnText.innerHTML = "Thu gọn"; 
      moreText.style.display = "inline";
    }
 }

//set path URL for Ajax when run localhost Tomcat 
function setPathURL(){
	var pathname = window.location.pathname;
	
	var pt = pathname.split("/");
	
	var path = "";
	if(pt[1].indexOf(pt[2]) >= 0){
        path = "/"+pt[1];
	}
	
	return path;
}