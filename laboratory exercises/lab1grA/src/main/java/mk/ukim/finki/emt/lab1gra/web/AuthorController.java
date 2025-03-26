package mk.ukim.finki.emt.lab1gra.web;

import mk.ukim.finki.emt.lab1gra.model.Author;
import mk.ukim.finki.emt.lab1gra.model.dto.AuthorDto;
import mk.ukim.finki.emt.lab1gra.service.AuthorService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //findAll
    @GetMapping
    public List<Author> findAll(){
        return authorService.findAll();
    }
    //findById
    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){
        return authorService.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    //save
    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestBody AuthorDto authorDto){
        return authorService.save(authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    //update
    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody AuthorDto authorDto){
        return authorService.update(id, authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> delete(@PathVariable Long id){
        if(authorService.findById(id).isPresent()){
            authorService.deleteById(authorService.findById(id).get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
