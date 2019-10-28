const container_resultados = document.querySelector("#holder_descartados");
function pegaTabela(link) {
    return (fetch(link).then(res => res.text()));
}

async function mostraAcervosDescartados(){
  const parser = new DOMParser();
  let xml_string = await pegaTabela("acervosDescartados");
  const doc = parser.parseFromString(xml_string, "text/xml");

  if(doc.querySelector("info > erro")!=null){
    M.toast("eita!");
  }

  container_resultados.innerHTML = "";
  const descartes = doc.querySelectorAll("info > *");
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

mostraAcervosDescartados();
