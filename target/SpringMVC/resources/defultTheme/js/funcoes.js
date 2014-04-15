// Tudo que for tiver que ser executado no carregamento de todas as páginas colocar nesse bloco
$(function() {
	$.datepicker.setDefaults($.datepicker.regional['pt-BR']);
	$(".campoData").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy",
		yearRange : "c-20:c+20"
	});
});

function redirecPagina(pagina) {
	window.location.href = pagina;
}

function setSituacao(id, situacao) {
	$.post("setSituacao", {
		'id' : id,
		'situacao' : situacao
	}, function(data) {
		// selecionando o elemento html através da
		// ID e alterando o HTML dele
		if (data.finalizado) {
			date = new Date(data.dataFinalizacao);
			dataString = date.format("dd/mm/yyyy");
		} else {
			dataString = '';
		}
		$("#dataFinalizacao_" + id).html(dataString);
	});
}