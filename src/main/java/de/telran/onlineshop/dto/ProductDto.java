package de.telran.onlineshop.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class ProductDto {
    private long productID;
    private String name;
    private String description;
    private double price;
  //  private long categoryID;
    private String imageURL;
    private double discountPrice;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public ProductDto(Long productID, String name) {
    }

    public ProductDto(long productID, String name, String description, double price, String imageURL, double discountPrice, Timestamp createdAt, Timestamp updatedAt) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
       // this.categoryID = categoryID;
        this.imageURL = imageURL;
        this.discountPrice = discountPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

//    public long getCategoryID() {
//        return categoryID;
//    }

    public String getImageURL() {
        return imageURL;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public void setCategoryID(long categoryID) {
//        this.categoryID = categoryID;
//    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto productDto = (ProductDto) o;
        return productID == productDto.productID && Double.compare(price, productDto.price) == 0  && Double.compare(discountPrice, productDto.discountPrice) == 0 && Objects.equals(name, productDto.name) && Objects.equals(description, productDto.description) && Objects.equals(imageURL, productDto.imageURL) && Objects.equals(createdAt, productDto.createdAt) && Objects.equals(updatedAt, productDto.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, name, description, price, imageURL, discountPrice, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageURL='" + imageURL + '\'' +
                ", discountPrice=" + discountPrice +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}