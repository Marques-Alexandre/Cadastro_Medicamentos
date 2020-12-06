


 //declara uma variável global contendo o ID do registro atual
var idmedicamentoAtual = 0;

// lista todos os medicamentos assim que o javascript é executado
listarMedicamento();


function listarMedicamento(){
	document.getElementById("listamedicamentos").innerHTML = "<tr><td>Aguarde, carregando...</td></tr>";
	
	fetch("Controller?service=MedicamentoListar").then(function(response) {
		response.json().then(function(dados) {
			
			//carrega os dados na tabela
			var tab = "<thead class='thead-dark'>" 
					  + "<th>Nome</th>"
					  + "<th>Marca</th>"
					  + "<th>Quantidade</th>"
					  + "<th>Data de Fabricação</th>"
			          + "<th>Data de Validade</th>"
					  + "<th>Preço</th>"
					  + "<th width='10px'></th>"
	  		          + "<th width='10px'></th>";
					  + "</thead>"
					 
			for (var i in dados) {
				tab += "<tr>"
					+"<td>" + dados[i].nome + "</td>"
					+"<td>" + dados[i].marca + "</td>"
					+"<td>" + dados[i].quantidade + "</td>"
					+"<td>" + dados[i].dataFabricacaoFormatada + "</td>"
					+"<td>" + dados[i].dataValidadeFormatada + "</td>"
					+"<td>" + "R$ " + dados[i].preco + "</td>"
					+"<td><button type='button' class='btn btn-primary' onclick='alterarMedicamento("+dados[i].id+")'>Alterar</button></td>"
	  			    +"<td><button type='button' class='btn btn-danger' onclick='excluirMedicamento("+dados[i].id+")'>Excluir</button></td>"
					+"</tr>"
					
			}
			document.getElementById("listamedicamentos").innerHTML = tab;
		});
	});
	
}

function salvarMedicamento(){
	
	const params = new URLSearchParams({
	  	idmedicamento:idmedicamentoAtual, 
    	nome:document.getElementById("nome").value,
    	marca:document.getElementById("marca").value,
		quantidade:document.getElementById("quantidade").value,
		data_fabricacao:document.getElementById("dataFabricacao").value,
		data_validade:document.getElementById("dataValidade").value,
		preco:document.getElementById("preco").value
	});
	
	var url ="Controller?service=MedicamentoSalvar&"+params.toString();
	
	fetch(url).then(function(response) {
	    response.json().then(function(dados) {
			if (dados=="ok") {
				listarMedicamento();
				$('#formmedicamento').modal('hide');
			} else {
				alert("Erro ao salvar os dados");
			} 
		});
	});

}

function novoMedicamento(){
	idmedicamentoAtual = 0;
	document.getElementById("nome").value = "";
	document.getElementById("marca").value = "";
	document.getElementById("quantidade").value = "";
	document.getElementById("dataFabricacao").value = "";
	document.getElementById("dataValidade").value = "";
	document.getElementById("preco").value = "";
	
	 $('#formmedicamento').modal('show');
}

function excluirMedicamento(idmedicamento) {
	fetch("Controller?service=MedicamentoExcluir&idmedicamento="+idmedicamento)
	.then(function(response) {
	    response.json().then(function(dados) {
		if (dados == "ok"){
			listarMedicamento();
		} else {
			alert("Erro ao excluir o medicamento.");
		}
		
		}); 
	});
	
}

function alterarMedicamento(idmedicamento){
	fetch("Controller?service=MedicamentoConsultar&idmedicamento="+idmedicamento)
	.then(function(response){
		response.json().then(function(dados){
			
			idmedicamentoAtual = dados.id;
			document.getElementById("nome").value = dados.nome;
			document.getElementById("marca").value = dados.marca;
			document.getElementById("quantidade").value = dados.quantidade;
			document.getElementById("dataFabricacao").value = formatarData(dados.dataFabricacaoFormatada);
			document.getElementById("dataValidade").value = formatarData(dados.dataValidadeFormatada);
			document.getElementById("preco").value = dados.preco;
			
			 $('#formmedicamento').modal('show');
		});
			
	});
}

function formatarData(dataptbr) {
	var vetor = dataptbr.split("/");
	return vetor[2] + '-' + vetor[1] + '-' + vetor[0]; 
}