package ProjetoFinal.repository;

import ProjetoFinal.model.Produto;

public interface HairMagiaRepository {
	
		//CRUD
		public void listarTodas();
		public void cadastrar(Produto produto);
		public void procurarPorID(int id);
		public void atualizar(Produto produto);
		public void deletar(int id);
}
