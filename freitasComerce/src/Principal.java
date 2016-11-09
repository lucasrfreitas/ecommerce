import java.sql.SQLException;
import java.util.ArrayList;

import br.freitas.control.ControlePessoa;
import br.freitas.model.Pessoa;

public class Principal {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws SQLException {
		
		Pessoa Murilo=new Pessoa(0, "Murilo", "079.367.888-99", "1111111");
		new ControlePessoa().InserePessoa(Murilo);
		ArrayList<Pessoa> Lista = new ControlePessoa().ListaPessoa();
		System.out.println(Lista);
	}

}
