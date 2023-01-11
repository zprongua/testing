package com.example.demo.Repository;

import com.example.demo.Domain.Bookmark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookmarkRepository extends CrudRepository<Bookmark, Long> {
}
