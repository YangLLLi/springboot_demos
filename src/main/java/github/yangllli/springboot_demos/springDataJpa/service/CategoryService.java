package github.yangllli.springboot_demos.springDataJpa.service;

import github.yangllli.springboot_demos.springDataJpa.dao.CategoryRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRep categoryRep;

}
