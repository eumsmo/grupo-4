const prefixo = "http://localhost:8080/app";
let DISCIPLINA = 1;

const infos = {
    inserirAtividade:{
        link: "/diario/diario/conteudo/inserir",
        parametros_default:{
            disciplina: DISCIPLINA,
            id: 1
        },
        queries:{
            inputs: "#inserir_atividade input"
        },
        ativadores: { evento: "click", query: "#submit_inserir_atividade" }
    },
    inserirConteudo:{
        link: "/diario/diario/conteudo/inserir",
        parametros_default: {
            disciplina: DISCIPLINA,
            valor: 0.0
        },
        queries: {
            inputs: "#inserir_conteudo input"
        },
        ativadores: { evento: "click", query: "#submit_inserir_conteudo" }
    },
    consultarConteudo:{
        link: "/diario/diario/conteudo/consulta",
        parametros_default: {
            especifico: "conteudo",
            disciplina: DISCIPLINA
        },
        queries: {
            holder: "#holder_conteudos",
            template: "#template_conteudos"
        }
    }
};

function consultarConteudoPos(resposta_dom){
    
}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  */
async function requisicao(info){
    const link = info.link;
    let params = {},
        inputs;

    if (info.parametros_default)
        params = Object.assign(params, info.parametros_default);

    if (info.queries && info.queries.inputs) {
        inputs = document.querySelectorAll(info.queries.inputs);
        inputs.forEach(input => params[input.name] = input.value);
    }

    const resposta = await pegaTabela(prefixo + link, params),
        analise = analiseXML(resposta);

    if (analise && analise.status === true) { // Se deu certo
        if (inputs != undefined)
            inputs.forEach(input => input.value = ""); // Limpa os input
    }

    return analise;
}

async function insere(info_insere){
    if (info_insere.constructor === String) {
        if (infos[info_insere]) return insere(infos[info_insere]);
        else return null;
    }

    requisicao(info_insere);
}

async function consulta(info_consulta){
    if (info_consulta.constructor === String) {
        if (infos[info_consulta]) return consulta(infos[info_consulta]);
        else return null;
    }

    let res = await requisicao(info_consulta);

    console.log(res);
    
}

function setaAtivadorUnico(info_insere, info_ativador){
    let elementos = document.querySelectorAll(info_ativador.query);
    for(let elemento of elementos)
        elemento.addEventListener(info_ativador.evento, () => insere(info_insere));
}


for(let nome in infos){
    let info_insere = infos[nome];

    if(info_insere.ativadores){
        let info_ativador = info_insere.ativadores;
        if(info_ativador.constructor == Object)
            setaAtivadorUnico(info_insere,info_ativador);
        else if(info_ativador.constructor == Array)
            info_ativador.forEach(i_a=>setaAtivadorUnico(info_insere,i_a));
    }
}