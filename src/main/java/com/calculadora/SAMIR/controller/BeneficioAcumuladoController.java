package com.calculadora.SAMIR.controller;

import com.calculadora.SAMIR.Modelo.BeneficioAcumulado;

import com.calculadora.SAMIR.Modelo.Beneficios;
import com.calculadora.SAMIR.Repositorio.BeneficioAcumuladoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/beneficioAcumulado")
public class BeneficioAcumuladoController {

    @Autowired
    private BeneficioAcumuladoRepository repository;

    @GetMapping("/listar")
    public @ResponseBody List<BeneficioAcumulado> listarBEneficios() {
        return repository.findAll();
    }

    @PostMapping("/salvar")
    public @ResponseBody
    BeneficioAcumulado salvarBeneficio(@RequestBody BeneficioAcumulado beneficio) {
        return repository.save(beneficio);
    }
    @PostMapping("/salvarLista")
    public @ResponseBody
    List<BeneficioAcumulado> salvarLista(@RequestBody List<BeneficioAcumulado> list){
        return repository.saveAll(list);
    }

}
