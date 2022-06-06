// Como podemos melhorar o esse código usando TS?

enum Trabalho {
  Atriz,
  Padeiro,
}

interface Iemployees {
  nome: string;
  idade: number;
  profissao: Trabalho;
}

let pessoa1: Iemployees = {} as Iemployees;
pessoa1.nome = "maria";
pessoa1.idade = 29;
pessoa1.profissao = Trabalho.Atriz;

let pessoa2: Iemployees = {} as Iemployees;
pessoa2.nome = "roberto";
pessoa2.idade = 19;
pessoa2.profissao = Trabalho.Padeiro;

let pessoa3: Iemployees = {
  nome: "laura",
  idade: 32, // Tem que ser number
  profissao: Trabalho.Atriz,
};

let pessoa4: Iemployees = {
  nome: "carlos", // É um objeto, então sem =
  idade: 19,
  profissao: Trabalho.Padeiro,
};
