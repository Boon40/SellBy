package com.sellby.sellby.model.response;


import com.sellby.sellby.model.entity.Category;
import com.sellby.sellby.model.entity.ProductPhoto;
import com.sellby.sellby.model.entity.State;
import com.sellby.sellby.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductResponse {
    private int id;
    private String name;
    private String description;
    private float price;
    private User seller;
    private State state;
    private List<ProductPhoto> photos = new ArrayList<>();
    //private List<User> users = new ArrayList<>();
    private Category category;
    private boolean isBuyerPayingDelivery;
    private LocalDate createdDate;
}
