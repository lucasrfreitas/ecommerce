import br.freitas.control.ControlePessoa;
import br.freitas.model.Pessoa;

public class Principal {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Pessoa Freitas=new Pessoa(0, "Lucas", "079.367.949-48", "150476");
		new ControlePessoa().InserePessoa(Freitas);
		
	}

}
