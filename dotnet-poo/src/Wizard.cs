using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DIO_repository.src
{
    public class Wizard : Hero
    {
        public Wizard(string name, int level, string typeHero) {
            this.name = name;
            this.level = level;
            this.typeHero = typeHero;
        }
        public override string Attack() {
            return this.name + " lançou uma magia";
        }
        
    }
}