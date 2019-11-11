async function pegaTabela(link,parametros,isPost=false) {
    /*
    
        # Função para fazer requisição com o fetch, feita com o proposito de evitar repetição

        link: String             # String com o link a se fazer a requisição
        parametros: Object       # Objeto com os parametros a serem passado na requisição
        isPost: Boolean          # Boleano que define se o método de requisição é post (setado como false por padrão) 

    */

    let config = {
        method: isPost? "POST": "GET"
    };

    if(isPost){ // Parametros para o metodo POST
        config.body = new URLSearchParams(parametros);
        config.headers = new Headers({ 'Content-type': 'application/x-www-form-urlencoded; charset=UTF-8' });
    } else { // Parametros para o metodo GET
        let query = [];
        for(let nome in parametros)
            query.push(nome+"="+parametros[nome]);
        link+= '?'+query.join("&");
    }

    let request = await fetch(link, config); 
    return request.text();
}

function alertarStatus({ status, mensagem, causa }) {
    let classe = status ? "sucesso" : "erro";
    M.toast({ html: mensagem, classes: classe });
    if (causa) console.log((status ? "SUCESSO" : "ERRO") + ": " + causa);
}

function analiseXML(xml_string, output_status = true) {
    let resposta = {};
    const parser = new DOMParser(),
        doc = parser.parseFromString(xml_string, "text/xml");

    // Se resposta não for um status
    if (doc.querySelector("info > erro, info > sucesso") == null) {
        const info = doc.querySelector("info");
        if (info.children.length >= 1)
            return [...info.children]; // Retorna vetor com todos os filhos
        else
            return null;
    }

    // As seguintes linhas só serão executadas caso a resposta seja um status (erro ou sucesso)

    // Variavel status é true caso o status seja sucesso e false se for erro
    let status = (doc.querySelector("info > erro") == null);
    resposta.status = status;

    // Já que causa é opcional
    if (doc.querySelector("info > * > causa") != null) {
        let causa = doc.querySelector("info > * > causa").innerHTML;
        resposta.causa = causa;
    }

    // Independentemente do status, sempre haverá uma mensagem
    let mensagem = doc.querySelector("info > * > mensagem").innerHTML;
    resposta.mensagem = mensagem;

    if (output_status)
        alertarStatus(resposta);

    return resposta;
}