package br.com.integracao.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.integracao.springboot.exception.ResourceNotFoundException;
import br.com.integracao.springboot.model.Usuario;
import br.com.integracao.springboot.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//get usuarios
	@GetMapping("usuarios")
	public List<Usuario> getAllUsuarios(){
		return this.usuarioRepository.findAll();
	}
		
	//get usuario (id)
	@GetMapping("usuario/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "id") Long usuarioId)
		throws ResourceNotFoundException{
			Usuario usuario = usuarioRepository.findById(usuarioId)
					.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado. id " + usuarioId));
		
		return ResponseEntity.ok().body(usuario);
	}
	
	//create usuario
	@PostMapping("usuarios")
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	//update usuario
	@PutMapping("usuarios/{id}")
	public ResponseEntity<Usuario> updateUsuario(
			@PathVariable(value = "id") Long usuarioId,
			@Valid @RequestBody Usuario usuarioData) throws ResourceNotFoundException{
		
			Usuario usuario = usuarioRepository.findById(usuarioId)
					.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado. id " + usuarioId));
		
			usuario.setEmail(usuarioData.getEmail());
			usuario.setNome(usuarioData.getNome());
			usuario.setSenha(usuarioData.getSenha());
			
			return ResponseEntity.ok(this.usuarioRepository.save(usuario));
	}
	
	//delete usuario
	@DeleteMapping("usuarios/{id}")
	public Map<String, Boolean> deleteUsuario(@PathVariable(value = "id") Long usuarioId) throws ResourceNotFoundException{
		
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado. id " + usuarioId));

		this.usuarioRepository.delete(usuario);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deletado", Boolean.TRUE);
		
		return response;
	}
	

}
