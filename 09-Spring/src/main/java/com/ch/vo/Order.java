package com.ch.vo;

import com.ch.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Date;

@Component("Order")
public class Order {
    private int id;
    private double totalPrice;

    /**
     * 给引用类型赋值
     * @Autowired 声明自动注入 默认 byType
     * @Autowired + @Qualifier 指定应用类型自动注入 使用byName方式
     */
    @Autowired
    @Qualifier("User")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                '}';
    }
}
