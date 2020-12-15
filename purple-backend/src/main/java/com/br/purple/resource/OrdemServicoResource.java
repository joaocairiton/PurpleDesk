package com.br.purple.resource;

import com.br.purple.model.OrdemServico;
import com.br.purple.repository.OrdemServicoRepository;
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
@RequestMapping("/ordem")
public class OrdemServicoResource {

    @Autowired
    private OrdemServicoRepository ordemRepository;

    @GetMapping
    public List<OrdemServico> list() {
        return ordemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<OrdemServico> findById(@PathVariable Long id) {
        return ordemRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<OrdemServico> create(@Valid @RequestBody OrdemServico ordemServico, HttpServletResponse response) {
        OrdemServico save = ordemRepository.save(ordemServico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        ordemRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> update(@PathVariable Long id, @Valid @RequestBody OrdemServico ordemServico) {
        Optional<OrdemServico> ordemBanco = ordemRepository.findById(id);
        BeanUtils.copyProperties(ordemServico, ordemBanco.get(), "id");
        ordemRepository.save(ordemBanco.get());
        return ResponseEntity.ok(ordemServico);
    }
}
