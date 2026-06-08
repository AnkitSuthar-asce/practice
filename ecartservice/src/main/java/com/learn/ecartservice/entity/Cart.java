package com.learn.ecartservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import java.util.List;

@Document(collection = "carts")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    private String cartId;

    @Field(name = "email_Id")
    private String emailId;

    @Field(name = "cartItems")
    private List<CartItem> cartItems;
}
