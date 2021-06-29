package br.com.alura.forum.controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest //classe generica de teste
//@DataJpaTest //propria para controller e repository
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //indica para o Spring não Substiurir o BD que não sejoo Padrão H2
//@WebMvcTest //Controllers puro
@AutoConfigureMockMvc //possibilita a injeçao do MockMvc
@ActiveProfiles("test") //força o ambinete de teste
class AutenticacaoTokenControllerTest {

	@Autowired
	private MockMvc mockMvc; //classe utilitaria do Spring que simula uma requisiçao MVC do controller (como se fosse o Postmam)

	@Test
	public void deveriaDevolverBadRequestCasoDadosDeAutenticaoEstejamIncorretos() throws Exception {

		URI uri = new URI("/auth");
		String json = "{\"email\":\"invalido@email.com\",\"senha\":\"123456\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
	}
}
