package ProjetoFinal.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ProjetoFinal.model.Produto;
import ProjetoFinal.repository.HairMagiaRepository;
import ProjetoFinal.util.Cores;

public class HairMagiaController implements HairMagiaRepository{
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	int id = 0;

	@Override
	public void listarTodas() {
		for (var produto : listaProdutos) {
			produto.visualizar();
		}		
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.printf(Cores.TEXT_PINK, "O produto com ID %d foi criado com sucesso! \n", produto.getId(), Cores.TEXT_RESET);
	}

	@Override
	public void procurarPorID(int id) {
		Optional<Produto> produto = buscarNaCollection(id);
		
		if(produto.isPresent())
			produto.get().visualizar();
		else
			System.out.printf("\nO produto com o ID %d nao foi encontrado!", id);
	}

	@Override
	public void atualizar(Produto produto) {
		Optional<Produto> buscaProduto = buscarNaCollection(produto.getId());		
		if(buscaProduto.isPresent()) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()),produto);
				System.out.printf("\nO Prodto com o ID %d foi atualizado com sucesso!", produto.getId());
		}else
			System.out.printf("\nO produto com o ID %d nao foi encontrado!", produto.getId());		
	}

	@Override
	public void deletar(int id) {
		Optional<Produto> produto = buscarNaCollection(id);		
		if(produto.isPresent()) {
			if (listaProdutos.remove(produto.get()))
				System.out.printf("\nO Prodto com o ID %d foi atualizado com sucesso!", produto);
		}else
			System.out.printf("\nO produto com o ID %d nao foi encontrado!", produto);		
	}
	public int gerarId() {
		return ++ id;
	}
	public Optional<Produto> buscarNaCollection(int id){
		for(var produto : listaProdutos) {
			if (produto.getId() == id)
				return Optional.of(produto);
			}
		return Optional.empty();
	}
}
