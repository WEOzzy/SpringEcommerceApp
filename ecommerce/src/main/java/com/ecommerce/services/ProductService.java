package com.ecommerce.services;

import com.ecommerce.daos.ProductDAO;
import com.ecommerce.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> findAll() {
        return productDAO.findAll(Sort.by("title"));
    }
}
