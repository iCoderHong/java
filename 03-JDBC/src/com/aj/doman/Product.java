package com.aj.doman;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    private Integer pid;
    private String pname;
    private String brand;
    private Double price;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    @Override
//    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
//        Product product = new Product();
//        product.setPid(resultSet.getInt("pid"));
//        product.setPname(resultSet.getString("pname"));
//        product.setBrand(resultSet.getString("brand"));
//        product.setPrice(resultSet.getDouble("price"));
//        return product;
//    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
