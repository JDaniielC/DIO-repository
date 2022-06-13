using DIO_repository.src;

namespace DIO_repository {
  class Program {
    static void Main(string[] args) {
      Warrior arus = new Warrior("Arus", 1, "warrior");
      Wizard angelic = new Wizard("Angelic", 1, "wizard");
      Console.WriteLine(arus);
      Console.WriteLine(angelic);
      Console.WriteLine(arus.Attack());
      Console.WriteLine(angelic.Attack());
    }
  }
}

