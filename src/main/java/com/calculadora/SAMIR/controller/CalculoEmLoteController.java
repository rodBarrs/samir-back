package com.calculadora.SAMIR.controller;


import com.calculadora.SAMIR.Modelo.CalculoEmLote;
import com.calculadora.SAMIR.Repositorio.CalculoEmLoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/calculoEmLote")
public class CalculoEmLoteController {

    @Autowired
    private CalculoEmLoteRepository repository;

    @GetMapping("/listar")
    public @ResponseBody
    List<CalculoEmLote> listar() {
        return repository.findAll();
    }
    @PostMapping("/ProcurarPorName")
    public @ResponseBody
    CalculoEmLote procurarPorName(@RequestBody String name) {
        return repository.findByNome(name);
    }

    @GetMapping("/procurarPorCodigo/{codigo}")
    public @ResponseBody
    Optional<CalculoEmLote> filtrarCorrecaoCodigo(@PathVariable Integer codigo) {
        return repository.findById(codigo);
    }

    @PostMapping("/salvar")
    public @ResponseBody
    CalculoEmLote salvarCalculoEmLote(@RequestBody CalculoEmLote calculoEmLote) {
        return repository.save(calculoEmLote);

    }
    @PutMapping("/alterar")
    public @ResponseBody
    CalculoEmLote alterar(@RequestBody CalculoEmLote calculoEmLote) {
        return repository.save(calculoEmLote);

    }

    @PostMapping("/salvrLista")
    public @ResponseBody
    List<CalculoEmLote> salvarLista(@RequestBody List<CalculoEmLote> list){
        return repository.saveAll(list);
    }

    @DeleteMapping("/deletar")
    public @ResponseBody CalculoEmLote deletar(@RequestBody CalculoEmLote calculoEmLote){
         repository.delete(calculoEmLote);
         return calculoEmLote;
    }
    @DeleteMapping("/deletarALL")
    public @ResponseBody List<CalculoEmLote> deletarALL(@RequestBody List<CalculoEmLote> list){
        repository.deleteAll(list);
        return list;
    }


}