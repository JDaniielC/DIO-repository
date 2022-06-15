using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AspDotNet.Models
{
    public class Context : DbContext
    {
        public DbSet<Categoria> Categorias { get; set; }
        // Para ser feito isso precisou instalar o SqlServer e Tools:
        // https://docs.microsoft.com/pt-br/ef/core/get-started/overview/install

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(@"Server=(localdb)\mssqllocaldb;Database=Cursomvc;Integrated Security=True");
        }
    }
}
