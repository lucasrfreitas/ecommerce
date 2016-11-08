package br.freitas.control;

import java.util.ArrayList;

import br.freitas.dao.DaoPessoa;
import br.freitas.model.Pessoa;

public class ControlePessoa {

	public ControlePessoa() {
	}
	
	
	public static boolean AlteraPessoa(Pessoa umaPessoa){
		return new DaoPessoa().AlteraPessoa(umaPessoa);
	}
	
	public static boolean DeletaPessoa(Pessoa umaPessoa){
		return new DaoPessoa().DeletaPessoa(umaPessoa);
	}
	
	public static boolean InserePessoa(Pessoa umaPessoa){
		return new DaoPessoa().InserePessoa(umaPessoa);
	}
	
	public static ArrayList<Pessoa> ListaPessoa(){
		return new DaoPessoa().ListaPessoa();
	}
	
	public static Pessoa PesquisaPessoaCodigo(int cod){
		return new DaoPessoa().PesquisaPessoaCodigo(cod);
	}


	public static ArrayList<Pessoa> PesquisaPessoaNome(String termodebusca) {
		return new DaoPessoa().PesquisaPessoaNome(termodebusca);
	}

}
