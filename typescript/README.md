# Projeto Typescript da DIO

## O que é o Typescript

É um superset do typescript que trás tipagem estática para a linguagem, além de outras features, com o propósito de melhorar a qualidade do código escrito e a sua usabilidade. Como é um superset o código compilado e usado em produção ainda é javascript, porém é um JS mais resiliente e turbinado graças ao uso de TS durante o desenvolvimento.

## Do que você vai precisar

Ferramentas necessárias:

- Do Node instalado na sua máquina
- Instalar o typescript usando o npm (npm install -g typescript)

## Estrutura do repositório

- _src_
  - Contém arquivos com exemplos de uso de TS e JS comentados para facilitar o entendimento da ferramenta
- _desafios_
  - Contém vários arquivos JS que podem ser refatorados para solidificar o conhecimento adquirido na aula
- _index.html_
  - É onde está a chamada para o arquivo app.js e pode ser manipulado a vontade para testarem seus scripts
- _tsconfig.json_
  - O coração do TS que configura suas funcionalidades.
- _package.json_
  - Nesse arquivo foram colocados alguns scripts com o propósito de facilitar a vida de quem usar esse repositório
    - start
      - Inicia o _lite-server_, que vai escutar modificações no index.html e em seus arquivos importados. É útil caso queira fazer testes no browser. A porta disposta normalmente é a _localhost:3000_
    - watch
      - Roda o _tsc --watch_ com o propósito de compilar constantemente qualquer coisa que for editada nos arquivos TS para sua contraparte em JS. Esse comando evita que _tsc_ tenha que ser digitado constantemente para fazer a compilação.

## Sobre o tsconfig.json

- Algumas configurações e funcionalidades legais são:
  1. Opções básicas:
     - target
       - Define para qual versão do ECMAScript o typescript vai ser convertido
     - lib
       - Define quais bibliotecas vão vir por default com o TS. Isso é bacana caso o TS esteja sendo usado no backend e a iteração com o DOM não é necessária. Como teste, tentem remover as bibliotecas do DOM e olhem seu código enchendo de erros porque não sabe o que é um document
     - sourceMap
       - Cria arquivos .map.js que geram uma cópia do seu arquivo TS no source do browser (aquele do inspect). Podem ser debugados via breakpoint direto no browser e são uma excelente ajuda, já que o código compilado de JS é menos legível que o TS.
     - outDir
       - Pasta para onde seus arquivos JS serão enviados
     - rootDir
       - Pasta de onde seus arquivos TS serão coletados. Pode ser necessário inserir a opção include fora do _compilerOptions_ com a pasta _src_ inclusa
  2. Opções de checagem de tipo:
     - strict
       - Marca todas opções de checagem de tipo como verdadeiras. Ideal caso seja a intenção do usuário ter o código mais consistente possível
     - noImplicitAny
       - Levanta erro caso variáveis não estejam tipadas. Caso essa seja a intenção, um "any" tem que ser explicitamente tipado
     - strictNullChecks
       - Pode levantar erro caso uma variável em uso seja potencialmente nula.
         - Ex: um botão que foi buscado usando um getElementById que não necessariamente vai encontrar um elemento é usado para escutar um evento.
  3. Outras opções
     - noUnusedLocals
       - Levanta erro sempre que uma variável local não está sendo utilizada, como um let dentro de uma função
     - nuUnusedParameters
       - Mesmo caso de noUnusedLocals, mas para parâmetros de função
     - noImplicitReturns
       - Levanta um erro caso uma função tenha caminhos que retornam valor e outros que não retornam
  4. Existem outras regras e explicações mais elaboradas na documentação oficial (https://www.typescriptlang.org/tsconfig)
