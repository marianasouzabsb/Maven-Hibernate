package mavenhibernate;

import java.util.List;

import org.junit.Test;

import dao.GenericDAO;
import model.TelefoneUser;
import model.UsuarioPessoa;

public class TesteHibernate {

	@Test
	public void testeHibernateUtil() {
		GenericDAO<UsuarioPessoa> genericDao = new GenericDAO<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setNome("Sarah");
		pessoa.setEmail("sarah@gmail.com");
		pessoa.setSenha("123");
		pessoa.setSobrenome("Besta");
		pessoa.setLogin("admim");
		genericDao.salvar(pessoa);
	}

	@Test
	public void testeUpdate() {
		GenericDAO<UsuarioPessoa> genericDao = new GenericDAO<UsuarioPessoa>();
		UsuarioPessoa pessoa = genericDao.pesquisar(1L, UsuarioPessoa.class);
		pessoa.setNome("nome atualizado Hiber");
		pessoa = genericDao.updateMerge(pessoa);
		System.out.println(pessoa);
	}

	@Test
	public void testebuscar() {
		GenericDAO<UsuarioPessoa> genericDao = new GenericDAO<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(1L);
		pessoa = genericDao.pesquisar(pessoa);
		System.out.println(pessoa);
	}

	@Test
	public void testebuscar2() {

		GenericDAO<UsuarioPessoa> genericDao = new GenericDAO<UsuarioPessoa>();
		UsuarioPessoa pessoa = genericDao.pesquisar(2L, UsuarioPessoa.class);
		System.out.println(pessoa);
	}

	// DELETE
	@Test
	public void testeDelete() {

		GenericDAO<UsuarioPessoa> genericDao = new GenericDAO<UsuarioPessoa>();
		UsuarioPessoa pessoa = genericDao.pesquisar(1L, UsuarioPessoa.class);
		genericDao.deletarPorID(pessoa);

	}

	// Lista
	@Test
	public void testeConsulta() {

		GenericDAO<UsuarioPessoa> genericDao = new GenericDAO<UsuarioPessoa>();
		List<UsuarioPessoa> List = genericDao.Listar(UsuarioPessoa.class);
		for (UsuarioPessoa usuarioPessoa : List) {
			System.out.println("____________________________");
			System.out.println(usuarioPessoa);
		}

	}
	@Test
	public void TesteQueryList() {
		GenericDAO<UsuarioPessoa> genericDao = new GenericDAO<UsuarioPessoa>();
		List<UsuarioPessoa> list = genericDao.getEntityManager().createQuery("from UsuarioPessoa").getResultList();
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println("____________________________");
			System.out.println(usuarioPessoa);
		}
	}
	@Test
	public void testeGravaTelefone() {
		GenericDAO genericDAO = new GenericDAO();
		
		UsuarioPessoa pessoa = (UsuarioPessoa) genericDAO.pesquisar(4L, UsuarioPessoa.class);
		TelefoneUser telefoneUser = new TelefoneUser();
		telefoneUser.setTipo("casa");
		telefoneUser.setNumero("61 9333-9854");
		telefoneUser.setUsuarioPessoa(pessoa);
		genericDAO.salvar(telefoneUser);
	}
	
	//Consulta telefones
	@Test
	public void testeConsultaTelefone() {
		GenericDAO genericDAO = new GenericDAO();
		
		UsuarioPessoa pessoa = (UsuarioPessoa) genericDAO.pesquisar(4L, UsuarioPessoa.class);
		for (TelefoneUser fone : pessoa.getTelefoneUsers()) {
			System.out.println(fone.getNumero());
			System.out.println(fone.getTipo());
			System.out.println(fone.getUsuarioPessoa().getNome());
			System.out.println("____________________________");
		}
	}

//
}
