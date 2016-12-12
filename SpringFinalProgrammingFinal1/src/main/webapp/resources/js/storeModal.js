$(function(){
	$("#selectSemail").on("change", function() {
		$("#inputSemail2").val($("#selectSemail").val());
	});
});

$(function(){
	$("#selectSname").on("change", function() {
		$("#inputSname").val($("#selectSname").val());
	});
});
