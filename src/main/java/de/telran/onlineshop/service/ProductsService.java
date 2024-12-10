package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.ProductsEntity;
import de.telran.onlineshop.dto.ProductDto;
import de.telran.onlineshop.repository.CategoriesRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private static final Logger log = LoggerFactory.getLogger(ProductsService.class);
    private final ProductsRepository productsRepository;
    private final CategoriesRepository categoriesRepository;
    private List<ProductDto> productDtoList;

    @PostConstruct
    void initProducts() {

        long currentMillis = System.currentTimeMillis();

        // Преобразование миллисекунд в Timestamp
        Timestamp timestamp = new Timestamp(currentMillis);

        Timestamp dateCr = timestamp;
        Timestamp dateUp = timestamp;
        CategoriesEntity category1= categoriesRepository.findById(1L).orElse(null);
        ProductsEntity productsEntity1 = new ProductsEntity((Long) null, "Milk", "Fresh liter of milk", 1.2, "https://example.com/milk.jpg", 0.0, dateCr, dateUp,category1,null,null,null);
        productsRepository.save(productsEntity1);
        ProductsEntity productsEntity2 = new ProductsEntity(null, "Bread", "Fresh loaf of bread", 0.8, "https://example.com/bread.jpg", 10.0, dateCr, dateUp,category1,null,null,null);
        productsRepository.save(productsEntity2);

        CategoriesEntity category2= categoriesRepository.findById(2L).orElse(null);
        ProductsEntity productsEntity3 = new ProductsEntity((Long) null, "Dishwashing Liquid", "For cleaning dishes", 2.5, "https://example.com/detergent.jpg", 5.0, dateCr, dateUp,category2,null,null,null);
        productsRepository.save(productsEntity3);
        ProductsEntity productsEntity4 = new ProductsEntity(null, "Glass Cleaner", "Effective glass cleaner", 3.0, "https://example.com/glass_cleaner.jpg", 0.0, dateCr, dateUp,category2,null,null,null);
        productsRepository.save(productsEntity4);

        CategoriesEntity category3= categoriesRepository.findByName("Радиотехника");
        ProductsEntity productsEntity5 = new ProductsEntity((Long) null, "Television", "LED TV", 150.0, "https://example.com/tv.jpg", 3.5, dateCr, dateUp,category3,null,null,null);
        productsRepository.save(productsEntity5);
        ProductsEntity productsEntity6 = new ProductsEntity(null, "Radio", "FM radio receiver", 30.0, "https://example.com/radio.jpg", 3.5, dateCr, dateUp,category3,null,null,null);
        productsRepository.save(productsEntity6);

        CategoriesEntity category4= categoriesRepository.findById(4L).orElse(null);
        ProductsEntity productsEntity7 = new ProductsEntity((Long) null, "Teddy Bear", "Plush teddy bear", 10.0, "https://example.com/teddy_bear.jpg", 0.0, dateCr, dateUp,category4,null,null,null);
        productsRepository.save(productsEntity7);
        ProductsEntity productsEntity8 = new ProductsEntity(null, "Building Blocks", "Kids' building blocks set", 15.0, "https://example.com/blocks.jpg", 0.0, dateCr, dateUp,category4,null,null,null);
        productsRepository.save(productsEntity8);

        CategoriesEntity category5= categoriesRepository.findByName("Одежда");
        ProductsEntity productsEntity9 = new ProductsEntity((Long) null, "T-Shirt", "Graphic T-shirt", 12.0, "https://example.com/tshirt.jpg", 10.0, dateCr, dateUp,category5,null,null,null);
        productsRepository.save(productsEntity9);
        ProductsEntity productsEntity10 = new ProductsEntity(null, "Jeans", "Stylish jeans", 25.0, "https://example.com/jeans.jpg", 20.0, dateCr, dateUp,category5,null,null,null);
        productsRepository.save(productsEntity10);

        CategoriesEntity category6= categoriesRepository.findById(6L).orElse(null);
        ProductsEntity productsEntity11 = new ProductsEntity((Long) null, "Notebook", "School notebook", 1.5, "https://example.com/notebook.jpg", 0.0, dateCr, dateUp,category6,null,null,null);
        productsRepository.save(productsEntity11);
        ProductsEntity productsEntity12 = new ProductsEntity(null, "Pen", "Gel pen", 0.5, "https://example.com/pen.jpg", 0.0, dateCr, dateUp,category6,null,null,null);
        productsRepository.save(productsEntity12);


        System.out.println("Выполняем логику при создании объекта " + this.getClass().getName());
    }

    public List<ProductDto> getAllProducts() {
        List<ProductsEntity> productsEntities = productsRepository.findAll();
        return productsEntities.stream()
                .map(entity -> ProductDto.builder()
                        .productID(entity.getProductId())
                        .name(entity.getName())
                        .description(entity.getDescription())
                        .price(entity.getPrice())
            //        .category(entity.getCategory())
                        .imageURL(entity.getImageUrl())
                        .discountPrice(entity.getDiscountPrice())
                        .createdAt(entity.getCreatedAt())
                        .updatedAt(entity.getUpdatedAt())
                        .build())
                .collect(Collectors.toList());
    }

//    public List<ProductDto> getAllProducts() {
//        List<ProductsEntity> productsEntities = productsRepository.findAll();
//        List<ProductDto> productDtoList1 = new ArrayList<>();
//        for (ProductsEntity entity : productsEntities) {
//            ProductDto currentProdukt = new ProductDto(entity.getProductId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getCategoryId(), entity.getImageUrl(), entity.getDiscountPrice(), entity.getCreatedAt(), entity.getUpdatedAt());
//            productDtoList1.add(currentProdukt);
//        }
//        return productDtoList1;
//    }
//        return productDtoList1;
//        return productDtoList = productsEntities.stream()
//                .map(entity -> new ProductDto(entity.getProductId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getCategoryId(), entity.getImageUrl(), entity.getDiscountPrice(), entity.getCreatedAt(), entity.getUpdatedAt()))
//                .collect(Collectors.toList());


    // работает с БД
//    public ProductDto getProductByID(Long id) {
//
//        ProductsEntity productsEntity = productsRepository.findById(id).orElse(new ProductsEntity());
//        return new ProductDto(productsEntity.getProductId(), productsEntity.getName(), productsEntity.getDescription(), productsEntity.getPrice(), productsEntity.getCategoryId(), productsEntity.getImageUrl(), productsEntity.getDiscountPrice(), productsEntity.getCreatedAt(), productsEntity.getUpdatedAt());
//    }

    public ProductDto getProductByName(String name) { ///categories/get?name=Other,k=2
        ProductsEntity productsEntity = productsRepository.findByName(name); // используем OQL
        return new ProductDto(productsEntity.getProductId(), productsEntity.getName(), productsEntity.getDescription(), productsEntity.getPrice(), productsEntity.getImageUrl(), productsEntity.getDiscountPrice(), productsEntity.getCreatedAt(), productsEntity.getUpdatedAt());
    }

//    public boolean createProduct(ProductDto newProduct) { //insert
//        ProductsEntity createProductEntity = new ProductsEntity(null, newProduct.getName(), newProduct.getDescription(), newProduct.getPrice(), newProduct.getCategoryID(), newProduct.getImageURL(), newProduct.getDiscountPrice(), newProduct.getCreatedAt(), newProduct.getUpdatedAt());
//        ProductsEntity returnCategoryEntity = productsRepository.save(createProductEntity);
//
//        return returnCategoryEntity.getCategoryId() != null;
//    }

//    public ProductDto updateProduct(ProductDto updProductDto) { //update
//        ProductsEntity createProductEntity = new ProductsEntity(updProductDto.getProductID(), updProductDto.getName(), updProductDto.getDescription(), updProductDto.getDiscountPrice(), updProductDto.getCategoryID(), updProductDto.getImageURL(), updProductDto.getDiscountPrice(), updProductDto.getCreatedAt(), updProductDto.getUpdatedAt());
//        ProductsEntity returnProductEntity = productsRepository.save(createProductEntity);
//        return new ProductDto(returnProductEntity.getProductId(), returnProductEntity.getName(), returnProductEntity.getDescription(), returnProductEntity.getPrice(), returnProductEntity.getCategoryId(), returnProductEntity.getImageUrl(), returnProductEntity.getDiscountPrice(), returnProductEntity.getCreatedAt(), returnProductEntity.getUpdatedAt());
//    }

    public void deleteProduct(Long id) {
        ProductsEntity products = productsRepository.findById(id).orElse(null);
        if (products == null) {
            throw new RuntimeException("Нету такого объекта с Id = " + id);
        } else {
            productsRepository.delete(products);
        }
    }

    @PreDestroy
    void destroy() {
        productDtoList.clear();
        System.out.println("Выполняем логику при окончании работы с  объектом " + this.getClass().getName());
    }

}
