package com.desafio.santander.servicoproduto.controller;

import com.desafio.santander.servicoproduto.exception.ResourceNotFoundException;
import com.desafio.santander.servicoproduto.model.Gastos;
import com.desafio.santander.servicoproduto.repository.GastosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class GastosController {

    @Autowired
    private GastosRepository gastosRepository;

    //get gastos

    @GetMapping("gastos")
    public List<Gastos> getAllGastos(){
        return this.gastosRepository.findAll();
    }

    //filtrar por id
    @GetMapping("/gastosid/{id}")
    public ResponseEntity<Gastos> getGastosById(@PathVariable(value = "id") Long gastosId)
            throws ResourceNotFoundException {
        Gastos gastos = gastosRepository.findById(gastosId)
                .orElseThrow(() -> new ResourceNotFoundException("Gastos not found for this id"));
        return ResponseEntity.ok().body(gastos);
    }




    //filtrar por data
    @GetMapping("/gastosdata/{data}")
    public ResponseEntity<Gastos> getGastosByData(@PathVariable(value = "data") Long gastosData)
            throws ResourceNotFoundException {
        Gastos gastos = gastosRepository.findById(gastosData)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found"));
        return ResponseEntity.ok().body(gastos);
    }

    //filtrar por valor
    @GetMapping("/gastos/valor/{valor}")
    public ResponseEntity<Gastos> getGastosByValor(@PathVariable(value = "valor") Long gastosValor)
            throws ResourceNotFoundException {
        Gastos gastos = gastosRepository.findById(gastosValor)
                .orElseThrow(() -> new ResourceNotFoundException("Gastos not found"));
        return ResponseEntity.ok().body(gastos);
    }

    //adicionar gastos
    @PostMapping("/gastos")
    public Gastos createGastos(@RequestBody Gastos gastos) {
        return gastosRepository.save(gastos);
    }

    //filtrar gastos
    @PutMapping("/gastos/{id}")
    public ResponseEntity<Gastos> updateGastos(@PathVariable(value = "id") Long gastosId,
                                                    @RequestBody Gastos gastosDetails) throws ResourceNotFoundException {
        Gastos gastos = gastosRepository.findById(gastosId)
                .orElseThrow(() -> new ResourceNotFoundException("Gastos not found for this id"));


        gastos.setData(gastosDetails.getData());
        gastos.setValor(gastosDetails.getValor());
        gastos.setDescricao(gastosDetails.getDescricao());


        final Gastos updatedGastos = gastosRepository.save(gastos);
        return ResponseEntity.ok(updatedGastos);
    }

    //deletar gastos
    @DeleteMapping("/gastos/{id}")
    public Map<String, Boolean> deleteGastos(@PathVariable(value = "id") Long gastosId)
            throws ResourceNotFoundException {
        Gastos gastos = gastosRepository.findById(gastosId)
                .orElseThrow(() -> new ResourceNotFoundException("Gastos not found for this id"));

        gastosRepository.delete(gastos);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

