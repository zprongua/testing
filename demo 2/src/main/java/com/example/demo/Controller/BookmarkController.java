package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Domain.Bookmark;
import com.example.demo.Repository.BookmarkRepository;

@Controller
@RequestMapping("/bookmark")
public class BookmarkController {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @GetMapping
    public ResponseEntity<Iterable<Bookmark>> getAllBookmarks() {
        return new ResponseEntity<>(bookmarkRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Bookmark getBookmarkById(@PathVariable Long id) {
        return bookmarkRepository.findBookmarkById(id);
    }

    @PostMapping
    public ResponseEntity<Bookmark> createBookmark(@RequestBody Bookmark bookmark) {
        return new ResponseEntity<>(bookmarkRepository.save(bookmark), HttpStatus.CREATED);
    }
    // @PostMapping("/add")
    // public ResponseEntity<Bookmark> create(@RequestBody Bookmark bookmark) {
    // bookmarkRepository.save(bookmark);
    // return new ResponseEntity<>(HttpStatus.OK);
    // }

    @RequestMapping(value = "/{bookmarkId}", method = RequestMethod.DELETE)
    public ResponseEntity<Bookmark> delete(@PathVariable Long id) {
        bookmarkRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
