package com.example.librarysystem.service;


import com.example.librarysystem.dto.request.AddTitleRequest;
import com.example.librarysystem.dto.response.TitleDto;
import com.example.librarysystem.exception.TitleNotFoundException;
import com.example.librarysystem.model.Title;
import com.example.librarysystem.repository.TitleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitleService {

    private final TitleRepository titleRepository;

    public TitleService(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }


    @Transactional
    public void addTitle(AddTitleRequest request) {
        if (titleRepository.findByTitle(request.title()).isPresent()){
            Title title = titleRepository.findByTitle(request.title()).orElseThrow(()->new TitleNotFoundException("title not found : " + request.title()));
            Integer unitsInStock = title.getUnitsInStock() + request.unitsInStock();
            title.setUnitsInStock(unitsInStock);
            titleRepository.save(title);
        }else {
            Title title = new Title(request.title(), request.unitsInStock());
            titleRepository.save(title);
        }
    }


    public List<TitleDto> getAll() {
        List<Title> titles = titleRepository.findAll();
        final var result =  titles.stream()
                .map(n->TitleDto.convert(n))
                .collect(Collectors.toList());
        return result;
    }


    public TitleDto getById(String id) {
        Title title = getTitleById(id);
        final var result  = TitleDto.convert(title);
        return result;
    }


    protected Title getByBookIsbn(String isbn){
        return titleRepository.foo(isbn).orElseThrow(()->new TitleNotFoundException("title not found"));
    }




    protected Title getTitleById(String id){
        Title title = titleRepository.findById(id)
                .orElseThrow(()-> new TitleNotFoundException("title not found : " + id));

        return title;
    }



}
