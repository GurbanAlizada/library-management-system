package com.example.librarysystem.service;


import com.example.librarysystem.dto.request.AddDetailRequest;
import com.example.librarysystem.dto.response.DetailDto;
import com.example.librarysystem.exception.TitleNotFoundException;
import com.example.librarysystem.model.Author;
import com.example.librarysystem.model.Category;
import com.example.librarysystem.model.Detail;
import com.example.librarysystem.repository.DetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetailService {

    private final DetailRepository detailRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public DetailService(DetailRepository detailRepository,
                         AuthorService authorService,
                         CategoryService categoryService) {
        this.detailRepository = detailRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


    @Transactional
    public void addDetail(AddDetailRequest request) {


        List<Long> aurhorIDs = request.aurhorIDs();
        List<Author> authors = new ArrayList<>();
        for (Long id : aurhorIDs){
            authors.add(authorService.getAuthorById(id));
        }

        List<Long> categoryIDs = request.categoryIDs();
        List<Category> categories = new ArrayList<>();
        for (Long id : categoryIDs){
            categories.add(categoryService.getCategoryById(id));
        }


        Detail detail = new Detail(
                request.title() ,
                request.descripton() ,
                0,
                authors ,
                categories );
        detailRepository.save(detail);
    }


    public List<DetailDto> getAll() {
        List<Detail> details = detailRepository.findAll();
        final var result =  details.stream()
                .map(n-> DetailDto.convert(n))
                .collect(Collectors.toList());
        return result;
    }


    public DetailDto getById(Long id) {
        Detail detail = getDetailById(id);
        final var result  = DetailDto.convert(detail);
        return result;
    }


    protected Detail getByBookIsbn(String isbn){
        return detailRepository.foo(isbn).orElseThrow(()->new TitleNotFoundException("detail not found"));
    }




    protected Detail getDetailById(Long id){
        Detail detail = detailRepository.findById(id)
                .orElseThrow(()-> new TitleNotFoundException("detail not found : " + id));

        return detail;
    }



}
