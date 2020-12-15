package com.br.purple.resource;

import com.br.purple.model.ListarPessoa;
import com.br.purple.model.Pessoa;
import com.br.purple.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> list() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> findById(@PathVariable Long id) {
        return pessoaRepository.findById(id);
    }

    @GetMapping("perfil/{perfil}")
    public List<ListarPessoa> list(@PathVariable String perfil) {
        return pessoaRepository.listaPessoaPorPerfil(perfil);
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
        Pessoa save = pessoaRepository.save(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
        Optional<Pessoa> pessoaBanco = pessoaRepository.findById(id);
        BeanUtils.copyProperties(pessoa, pessoaBanco.get(), "id");
        pessoaRepository.save(pessoaBanco.get());
        return ResponseEntity.ok(pessoa);
    }
}
