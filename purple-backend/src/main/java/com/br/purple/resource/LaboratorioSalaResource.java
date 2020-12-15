package com.br.purple.resource;

import com.br.purple.model.LaboratorioSala;
import com.br.purple.repository.LaboratorioSalaRepository;
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
@RequestMapping("/laboratorio")
public class LaboratorioSalaResource {

    @Autowired
    private LaboratorioSalaRepository laboratorioRepository;

    @GetMapping
    public List<LaboratorioSala> list() {
        return laboratorioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<LaboratorioSala> findById(@PathVariable Long id) {
        return laboratorioRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<LaboratorioSala> create(@Valid @RequestBody LaboratorioSala laboratorio, HttpServletResponse response) {
        LaboratorioSala save = laboratorioRepository.save(laboratorio);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        laboratorioRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LaboratorioSala> update(@PathVariable Long id, @Valid @RequestBody LaboratorioSala laboratorio) {
        Optional<LaboratorioSala> laboratorioBanco = laboratorioRepository.findById(id);
        BeanUtils.copyProperties(laboratorio, laboratorioBanco.get(), "id");
        laboratorioRepository.save(laboratorioBanco.get());
        return ResponseEntity.ok(laboratorio);
    }
}
