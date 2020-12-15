package com.br.purple.resource;

import com.br.purple.model.TipoServico;
import com.br.purple.repository.TipoServicoRepository;
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
@RequestMapping("/tipo")
public class TipoServicoResource {

    @Autowired
    private TipoServicoRepository tipoRepository;

    @GetMapping
    public List<TipoServico> list() {
        return tipoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TipoServico> findById(@PathVariable Long id) {
        return tipoRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<TipoServico> create(@Valid @RequestBody TipoServico tipoServico, HttpServletResponse response) {
        TipoServico save = tipoRepository.save(tipoServico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        tipoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoServico> update(@PathVariable Long id, @Valid @RequestBody TipoServico tipoServico) {
        Optional<TipoServico> tipoBanco = tipoRepository.findById(id);
        BeanUtils.copyProperties(tipoServico, tipoBanco.get(), "id");
        tipoRepository.save(tipoBanco.get());
        return ResponseEntity.ok(tipoServico);
    }
}
