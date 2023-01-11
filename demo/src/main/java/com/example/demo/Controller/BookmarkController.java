package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Domain.*;//Domain.Bookmark;
import com.example.demo.Repository.*;

@Controller
@RequestMapping("/bookmark")
public class BookmarkController {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    public BookmarkController(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @GetMapping("/bookmark")
    public ResponseEntity<Iterable<Bookmark>> getAllBookmarks() {
        return new ResponseEntity<>(bookmarkRepository.findAll(), HttpStatus.OK);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Bookmark> getBookmarkById(@PathVariable Long id) {
    // return new ResponseEntity<Bookmark>(bookmarkRepository.findById(id),
    // HttpStatus.OK);
    // }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Bookmark> create(@RequestBody Bookmark bookmark) {
        bookmarkRepository.save(bookmark);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{bookmarkId}", method = RequestMethod.DELETE)
    public ResponseEntity<Bookmark> delete(@PathVariable Long id) {
        bookmarkRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
