package com.example.demo.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Repository.CommentRepository;
import com.example.demo.Domain.Comment;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public ResponseEntity<Iterable<Comment>> getAllComments() {
        Iterable<Comment> allComments = commentRepository.findAll();
        return new ResponseEntity<>(allComments, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Comment> create(@RequestBody Comment comment, @RequestBody String date) {
        DateTimeFormatter timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String text = date.formatted(timeStamp);
        LocalDateTime datetime = LocalDateTime.now();
        commentRepository.save(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Comment> delete(@PathVariable Long commentId) {
        commentRepository.deleteById(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}