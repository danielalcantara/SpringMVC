$(function() {
	$("#finalizado").on("click", function() {
		if ($(this).is(":checked")) {
			$("#dataFinalizacao").prop('disabled', false);
		} else {
			$("#dataFinalizacao").prop('disabled', true);
			$("#dataFinalizacao").val('');
		}
	});
});