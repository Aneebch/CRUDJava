package com.api.first;

import models.Coder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping("/coders")
public class CoderController {

    List<Coder> coderDB = new ArrayList<>(
            List.of(new Coder("Aneeb"), new Coder("Ali"))
    );

    @GetMapping("/check")
    public String check() {
        return "ok";
    }

    @GetMapping
    public List<Coder> getCoder() {

        return this.coderDB;
    }

    @GetMapping("{id}")
    public Coder getById(@PathVariable UUID id) {
//        for (Coder item:this.coderDB) {
        //           if(item.getId().equals(id)) return item;
        //       } return null;


        return this.coderDB.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst().get();

    }

    @PostMapping
    public Coder create(@RequestBody Coder coder) {
        this.coderDB.add(coder);
        return coder;
    }

    @DeleteMapping("{id}")
    public Coder delete(@PathVariable UUID id) {
        //encontrar el coder en la lista DB Fake
        // Borrar el coder en la lista DB Fake
        // Retornar el coder Borrado

 /*       for(Coder item: this.coderDB) {
            if(item.getId().equals(id)) {
                this.coderDB.remove(item);
                return item;
            }
        }
        return null; */

        var coderToDelete = this.coderDB.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst().get();
        this.coderDB.remove(coderToDelete);
        return coderToDelete;

    }

    @PutMapping("/{id}")
    public Coder updateById(@PathVariable UUID id, @RequestBody Coder coder) {

        for (Coder item: this.coderDB) {
            if (item.getId().equals(id)) {
                item.setName((coder.getName()));
                return item;
            }
        }
    }



}
