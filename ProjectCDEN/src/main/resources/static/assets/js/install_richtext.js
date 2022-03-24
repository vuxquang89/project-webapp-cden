$(document).ready(function(){
	/**=============install rich text editor============= */
    
	$("#campaign-content").richText({
		// text formatting
		bold:true,
		italic:true,
		underline:true,
		// fonts
		fonts:true,
		fontList: ["Arial",
			"Arial Black",
			"Comic Sans MS",
			"Courier New",
			"Geneva",
			"Georgia",
			"Helvetica",
			"Impact",
			"Lucida Console",
			"Tahoma",
			"Times New Roman",
			"Verdana"],
		fontColor:true,
		fontSize:true,
		// uploads
		imageUpload:true,
		fileUpload:true,

	});
});

   