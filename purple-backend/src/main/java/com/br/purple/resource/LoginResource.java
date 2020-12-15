package com.br.purple.resource;

import com.br.purple.model.Login;
import com.br.purple.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<Object[]> create(@RequestBody Login login, HttpServletResponse response) {
        return ResponseEntity.ok(pessoaRepository.findFiltroUsuario(login.getLogin(), login.getSenha()));
    }
}
