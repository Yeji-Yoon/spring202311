package org.choongang.controllers;

import org.choongang.repositories.BoardDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @Autowired
    private BoardDataRepository repository;

    @GetMapping("/test1")
    public void test1() {
        Pageable pageable = PageRequest.of(0,3);
        repository.findBySubjectContaining("목",pageable);
    }
}
