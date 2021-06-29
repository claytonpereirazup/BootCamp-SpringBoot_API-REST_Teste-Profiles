package br.com.alura.forum.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import br.com.alura.forum.modelo.Curso;

//@SpringBootTest //classe generica de teste
@DataJpaTest //propria para repository
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //indica para o Spring não Substiurir o BD que não sejoo Padrão H2
@ActiveProfiles("test") //força o ambinete de teste
public class CursoRepositoryTest {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private TestEntityManager em;
	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloNome() {
		Curso curso = new Curso();
		curso.setNome("HTML 5");
		curso.setCategoria("Programação");
		em.persist(curso);
		
		String nomeCurso = "HTML 5";
		
		curso = cursoRepository.findByNome(nomeCurso);
		assertNotNull(curso);
		assertEquals(nomeCurso, curso.getNome());
	}
	
	@Test
	public void naoDeveriaCarregarUmCursoCujoNomeExista() {
		String nomeCurso = "JPA";
		
		Curso curso = cursoRepository.findByNome(nomeCurso);
		assertNull(curso);
	}

}
