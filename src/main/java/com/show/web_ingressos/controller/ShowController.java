package com.show.web_ingressos.controller;

import com.show.web_ingressos.model.Cliente;
import com.show.web_ingressos.model.Setor;
import com.show.web_ingressos.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/setores")
    public List<Setor> listarSetores() {
        return showService.getSetores();
    }

    @PostMapping("/comprar")
        public ResponseEntity<byte[]> comprar(@RequestParam int indice, @RequestBody Cliente cliente) {
        try {
            byte[] imagem = showService.processarVenda(indice, cliente);
            if (imagem == null) return ResponseEntity.badRequest().build();
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imagem);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}