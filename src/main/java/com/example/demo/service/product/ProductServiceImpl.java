package com.example.demo.service.product;

import com.example.demo.domain.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    OAuth2RestOperations restTemplate;

    @Override
    public Product getByIdx(Long pIdx) {
        try {
            ResponseEntity<Product> response = restTemplate.exchange("/dsites/1/stores/1/products/"+pIdx, HttpMethod.GET,
                    null, new ParameterizedTypeReference<Product>() {});
            return response.getBody();
        } catch (Exception e) {
            return null;
        }
    }

}
