package com.educandoweb.course.entities.pk;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class OrderItemPK implements Serializable {

    private static final long serialVersionUID= 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK orderItem = (OrderItemPK) o;
        return Objects.equals(order, orderItem.order) && Objects.equals(product, orderItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "order=" + order +
                ", product=" + product +
                '}';
    }
}
