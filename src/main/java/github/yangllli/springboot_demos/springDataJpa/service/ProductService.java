package github.yangllli.springboot_demos.springDataJpa.service;

import github.yangllli.springboot_demos.springDataJpa.dao.ProductRep;
import github.yangllli.springboot_demos.springDataJpa.pojo.Category;
import github.yangllli.springboot_demos.springDataJpa.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRep productRep;

    public List<Product> search(String name) {
        return productRep.findByNameLike(name);
    }

    public List<Product> list(Category category,int page,int size) {
        Sort by = Sort.by(Sort.Direction.DESC, "createDateTime");
        Pageable pageable = PageRequest.of(page, size,by);
        return productRep.findProductsByCategory(category,pageable);
    }
}
