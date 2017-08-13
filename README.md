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
     https://rsvalidacampo.herokuapp.com/rs/valida/11988881234/telefone
     https://rsvalidacampo.herokuapp.com/rs/valida/96205663279/cpf

    ```
 * RESPOSTA
  - application/json
 
  ```java
     {"valor":"11988881234","tipo":"telefone","statusText":"OK","status":200}
     {"valor":"96205663279","tipo":"cpf","statusText":"OK","status":200}
  ```
 * URI
  
 - /rs/parametro
 - /rs/parametro/{codigo_do_parametro}

    ```java
     /* exemplo 1 */
     https://rsvalidacampo.herokuapp.com/rs/parametro
     /* exemplo 2 */
     https://rsvalidacampo.herokuapp.com/rs/parametro/0

    ```
 
* RESPOSTA
  - application/json
 
  ```java
     
     /* exemplo 1 */
     {"parameters":[{"codigo":0,"tipo":"cpf"},{"codigo":1,"tipo":"cpf_formatado"},{"codigo":2,"tipo":"titulo_de_eleitor"},...
     
     /* exemplo 2 */
     {"codigo":0,"tipo":"cpf"}
     
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
                                                    console.log(result.status);
                                                }, 
                error: () => console.log("error")
        });
    };

    ```

## Lista de validações completa

* [Tipos de validações](https://github.com/gilmardeveloper/java-validator-safeguard/blob/master/README.md#lista-de-validações) 

© 2017 Gilmar Carlos All rights reserved.
