package br.com.sandes.produtosapi.controllers;

import br.com.sandes.produtosapi.model.Produto;
import br.com.sandes.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
   public Produto salvar(@RequestBody Produto produto){
       System.out.println("Produto recebido: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

       repository.save(produto);
       return produto;
   }

   @GetMapping("/{id}")
    public Produto obterProId(@PathVariable("id") String id){
        return repository.findById(id).orElse(null);
   }
}
