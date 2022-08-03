package mandacaru.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mandacaru.model.Imovel;
import mandacaru.service.ImovelService;
 
@RestController
@RequestMapping(path = "/api/imoveis")
public class ImovelController {
 
    @Autowired
    ImovelService service;
 
    @GetMapping
    public ResponseEntity<List<Imovel>> findall() {
        return new ResponseEntity<List<Imovel>>(service.findall(), HttpStatus.OK);
    }
 
    @GetMapping(path = "{id}")
    public ResponseEntity<Imovel> find(@PathVariable("id") int id) {
        return new ResponseEntity<Imovel>(service.find(id), HttpStatus.OK);
    }
 
    @PostMapping
    public void save(@RequestBody Imovel imovel) {
        service.save(0, imovel);
    }
 
    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") int id, @RequestBody Imovel imovel) {
        service.save(id, imovel);
    }
 
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }
}