# RS Valida Campo
### Protótipo de servidor de recursos para validação de campos de texto

## MÉTODO GET

* TIPOS DE VALIDAÇÃO
  - CPF
  - CNPJ
  - TELEFONE

* URI
  - /rs/valida/{valor_para_validar}/{tipo_da_validação}

    ```java
     /* exemplo */
     /rs/valida/11988881234/telefone
     /rs/valida/96205663279/cpf

    ```
* RESPOSTA
  - application/json
 
  ```java
     {"valor":"11988881234","tipo":"telefone","statusText":"OK","status":200}
     {"valor":"96205663279","tipo":"cpf","statusText":"OK","status":200}
  ```

## MÉTODO POST

* TIPOS DE VALIDAÇÃO
  - TODOS

* URI:
  - /rs/valida
  
* CONTENT-TYPE 
  - application/json
  
* PARAMETROS 
  -  valor: valor_para_validar 
  - tipo: tipo_da_validação 
  
* AJAX

    ```javascript

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

    ```

## Lista de validações completa

* [Tipos de validações](https://github.com/gilmardeveloper/java-validator-safeguard/blob/master/README.md#lista-de-validações) 

© 2017 Gilmar Carlos All rights reserved.
