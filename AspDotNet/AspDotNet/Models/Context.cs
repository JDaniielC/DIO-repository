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
        public DbSet<Produto> Produtos { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(@"Server=(localdb)\mssqllocaldb;Database=Cursomvc;Integrated Security=True");
        }
        // Com esse método novo, foi modificado o controller do Produto em PUT!
        public virtual void SetModified(object entity)
        {
            Entry(entity).State = EntityState.Modified;
        }

        public static implicit operator global::Moq.Mock<object>(Context v)
        {
            throw new NotImplementedException();
        }
    }
}
