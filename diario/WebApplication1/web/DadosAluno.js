let ALUNOS;
const stringEInteiro = numero => (/^\d+$/).test(numero);

const BARRA_PESQUISA = new URLSearchParams(window.location.search);
if (BARRA_PESQUISA.has("alunos") && stringEInteiro(BARRA_PESQUISA.get("alunos")))
    DISCIPLINA = Number(BARRA_PESQUISA.get("alunos"));
const infos = {
  consultarProfessor:{
        link: "localhost:8080/app/diario/alunos/consultar?",
        parametros_default: {
            tipo: "alunos",
            alunos: ALUNOS
        },
        queries: {
            holder: "#holder_conteudos",
            template: "#template_alunos",
            alterar: "#modalAlteraConteudos"
        },
        callback: consultarAlunos
    },
}

function consultarAlunos(info,resposta_dom){
    let args;
    const holder = document.querySelector(info.queries.holder);
    holder.innerHTML = "";
    if (resposta_dom == null) return;

    for(let alunosEl of resposta_dom){ //alterar pra alunosEl
        let id = alunosEl.querySelector("id").innerHTML,
            nome = alunosEl.querySelector("nome").innerHTML,
            sexo = alunosEl.querySelector("sexo").innerHTML,
            nascimento = alunosEl.querySelector("nascimento").innerHTML;
            email = alunosEl.querySelector("email").innerHTML,

        args = {
            id,
            nome,
            sexo,
            nascimento: dataFormatada(nascimento), //vai dar erro aqui ó, o id é nascimento mas era data
            //data_raw: data,
            email
        };

        let el = geraElemento(info.queries.template,args)[0];
        holder.appendChild(el);

    }
