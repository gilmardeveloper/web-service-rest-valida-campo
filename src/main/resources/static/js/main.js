$(()=>{


   $("#btn-validar").click(validar);


});

function validar(){

var objeto = {valor: $("#campo-valor").val(), tipo: $("#campo-tipo").val()};
var solicitacao = JSON.stringify(objeto);

     $.ajax({
                url: "/rs/valida",
                type: "POST", 
                data: solicitacao,
                contentType: "application/json",

            success: (result,status,xhr) => {
                                                addLinha(result);
                                            }, 
            error: () => console.log("error")
    });
};

function addLinha(result){

    var linha = `<tr>
            		<td>${result.valor}</td>
					<td>${result.tipo}</td>
					<td>${result.statusText}</td>
					<td>${result.status}</td>
				</tr>`;

    $("tbody").append(linha);
}
