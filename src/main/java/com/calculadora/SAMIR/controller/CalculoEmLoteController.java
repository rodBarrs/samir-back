package com.calculadora.SAMIR.controller;


import com.calculadora.SAMIR.Modelo.Beneficios;
import com.calculadora.SAMIR.Modelo.CalculoEmLote;
import com.calculadora.SAMIR.Modelo.TaxaDeCorrecao;
import com.calculadora.SAMIR.Repositorio.CalculoEmLoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/calculoEmLote")
public class CalculoEmLoteController {

    @Autowired
    private CalculoEmLoteRepository repository;
    
    @PostMapping("/ProcurarPorName")
    public @ResponseBody
    CalculoEmLote procurarPorName(@RequestBody String name) {
        return repository.findByName(name);
    }

    @GetMapping("/procurarPorCodigo/{codigo}")
    public @ResponseBody
    CalculoEmLote filtrarCorrecaoCodigo(@PathVariable Integer codigo) {
        return repository.findByCodigo(codigo);
    }

    @PostMapping("/salvar")

    public @ResponseBody
    CalculoEmLote salvarCalculoEmLote(@RequestBody CalculoEmLote calculoEmLote) {
        return repository.save(calculoEmLote);

    }

    @PostMapping("/salvarLista")
    public @ResponseBody
    List<CalculoEmLote> salvarLista(@RequestBody List<CalculoEmLote> list){
        return repository.saveAll(list);
    }


}