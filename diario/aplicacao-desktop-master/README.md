# Apicação Desktop

Esse repositório é dedicado a parte de `front-end` desktop da aplicação a ser der desenvolvida.

## Aviso

Esse repositório tem afazeres globais, caso queira ajudar verifique o [`TO-DO`](TO-DO.md).

## Instruções para IDEs e Editores recomendados

### Ferramentas necessárias

- `Oracle JDK 7/8` ou `OpenJDK 7/8` [recomendado]
- Uma IDE recomendada

Instruções para instalação: [aqui](https://duckduckgo.com/)

### IDE's recomendadas

- NetBeans 8.2+
- IntelliJ IDEA

### Plugins e Configurações

Recomendamos, para sua facilidade, instalar o plugin `EditorConfig` que ira padronizar o seu projeto "automaticamente" baseado no arquivo `.editorconfig` em `app`. [Tutorial para instalação no NetBeans](https://inf2-2019.github.io/help/editorconfig/).

Serão usados:

- Indentação por `TAB`
- Charset `UTF-8`
- Fim de linha `LF`
- Uma linha em branco no fim de cada arquivo
- Remoção automática de espaços no fim da linha

#### `.editorconfig`

```ini
root = true

[*]
indent_style = tab
charset = utf-8
trim_trailing_whitespace = true
end_of_line = lf
insert_final_newline = true
```

## Como _buildar_ o projeto

Utilizar a ferramenta de _build_ padrão da IDE utilizada.

## Bibliotecas

As bibliotecas usadas atualmente são:

- `JavaFX 8`

## Documentações e links úteis

A documentação estará disponível na pasta `docs`.

`JavaFX 8`: [aqui](https://docs.oracle.com/javase/8/javafx/api/toc.htm)
