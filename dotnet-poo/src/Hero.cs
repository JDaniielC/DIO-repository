using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DIO_repository.src
{
    public class Hero
    {
        public string name = "no name";
        public int level { get; set; }
        public string typeHero = "default";
        // Método construtor precisa colocar public or private
        public Hero() {}

        public override string ToString() {
            return "It's a " + this.typeHero + " named " + this.name;
        }

        public virtual string Attack() {
            return this.name + " Atacou";
        }
    }
}