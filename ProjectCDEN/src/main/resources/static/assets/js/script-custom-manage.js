/**
 * 
 */
$(document).ready(function(){
	$("[id*=fuUpload]").change(function () {
		if (typeof (FileReader) != "undefined") {
        	var dvPreview = $("[id*=dvPreview]");
            dvPreview.html("");
            var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.jpg|.jpeg|.gif|.png|.bmp)$/;
            $($(this)[0].files).each(function () {
            	var file = $(this);
                if (regex.test(file[0].name.toLowerCase())) {
                	var reader = new FileReader();
                    reader.onload = function (e) {
                    	var img = $("<img />");
                        img.attr("style", "height:100px;width: 100px");
                        img.attr("src", e.target.result);
                        dvPreview.append(img);
                    }
                    reader.readAsDataURL(file[0]);
                } else {
                	alert(file[0].name + " is not a valid image file.");
                    dvPreview.html("");
                    return false;
                }
             });
         } else {
         	alert("This browser does not support HTML5 FileReader.");
         }
    });

	$(".custom-file-input").on("change", function() {
		var fileName = $(this).val().split("\\").pop();
		$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
	});
});	