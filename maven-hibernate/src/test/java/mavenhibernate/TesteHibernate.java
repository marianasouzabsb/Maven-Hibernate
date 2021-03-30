package mavenhibernate;

import org.junit.Test;

import dao.GenericDAO;
import model.UsuarioPessoa;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		GenericDAO<UsuarioPessoa> genericDao = new GenericDAO<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setNome("Mariana");
		pessoa.setEmail("mari@gmail.com");
		pessoa.setSenha("123");
		pessoa.setSobrenome("Oliveira");
		pessoa.setLogin("admim");
		
		genericDao.salvar(pessoa);
	}
	
//
}
