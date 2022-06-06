enum Profissao {
  Professor,
  Engenheiro,
  Pintor,
  Porteiro,
}

type Pessoa = {
  name: string;
  idade: number;
  casado: boolean;
  trabalho: Profissao; // Enum como um tipo
};

const gabriel: Pessoa = {
  name: "Gabriel",
  idade: 26,
  casado: false,
  trabalho: Profissao.Engenheiro,
};

const mario: Pessoa = {
  name: "Mario",
  idade: 26,
  casado: false,
  trabalho: Profissao.Engenheiro,
};

function geradorDeErro(mensagem: string, codigoDeErro: number): never {
  // never é usado como tipos bem definidos.
  throw { message: mensagem, errorCode: codigoDeErro };
  // Aqui o script foi interrompido, no caso está bem definido.
}
geradorDeErro("Um erro ocorreu!", 500);
