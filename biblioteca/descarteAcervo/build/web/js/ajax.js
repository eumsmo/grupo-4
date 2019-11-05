const container_resultados = document.querySelector("#holder_descartados");
function pegaTabela(link) {
    return (fetch(link).then(res => res.text()));
}

async function mostraAcervosDescartados(){
  let xml_string = await pegaTabela("acervosDescartados");
  const descartes = analiseXML(xml_string);
  if (descartes == null || (status in descartes && descartes.status===false)) return; // Checa se ocorreu um erro

  container_resultados.innerHTML = ""; // Limpa conteudo do elemento
  descartes.forEach(descarte=>{
    let filhos = [...descarte.children],
        linhaEl = document.createElement("tr");

    for(let filho of filhos){
      let elemento=document.createElement("td");
      elemento.innerHTML = filho.innerHTML;
      linhaEl.appendChild(elemento);
    }
    container_resultados.appendChild(linhaEl);
  });
}

function alertarStatus({status,mensagem,causa}){
    let classe = status ? "sucesso" : "erro";
    M.toast({ html: mensagem, classes: classe });
    if(causa) console.log((status ? "SUCESSO" : "ERRO") + ": " + causa);
}

function analiseXML(xml_string,output_status=true){
    let resposta = {};
    const parser = new DOMParser(),
          doc = parser.parseFromString(xml_string, "text/xml");
    
    // Se resposta não for um status
    if (doc.querySelector("info > erro, info > sucesso") == null) {
        const info = doc.querySelector("info");
        if(info.children.length>1)
            return [...info.children]; // Retorna vetor com todos os filhos
        else if(info.children==1)
            return info.children[0]; // Retorna elemento único
        else 
            return null;
    }

    // As seguintes linhas só serão executadas caso a resposta seja um status (erro ou sucesso)

    // Variavel status é true caso o status seja sucesso e false se for erro
    let status = (doc.querySelector("info > erro")==null);
    resposta.status = status;

    // Já que causa é opcional
    if (doc.querySelector("info > * > causa") != null) {
      let causa = doc.querySelector("info > * > causa").innerHTML;
      resposta.causa = causa;
    }

    // Independentemente do status, sempre haverá uma mensagem
    let mensagem = doc.querySelector("info > * > mensagem").innerHTML;
    resposta.mensagem = mensagem;

    if(output_status)
      alertarStatus(resposta);

    return resposta;
}

const inputs = [
    document.querySelector("#acervo"),
    document.querySelector("#data"),
    document.querySelector("#funcionario"),
    document.querySelector("#motivacao")
];
async function descartarAcervo(){
    if(!window.confirm("Você tem certeza que deseja descartar o acervo?\nUma vez descartado, não há mais volta."))return;

    const link = "descarteAcervo?",
          query = inputs.map(input=>input.name+"="+input.value).join("&");

    const requisicao = await fetch(link+query),
          resposta = await requisicao.text(),
          analise = analiseXML(resposta);
    
    if(analise.status===true){ // Se deu certo
      inputs.forEach(input=>input.value=""); // Limpa os input
      mostraAcervosDescartados();
    }
}

mostraAcervosDescartados();

const botao_submit = document.querySelector("#submit");
botao_submit.addEventListener("click",descartarAcervo);
