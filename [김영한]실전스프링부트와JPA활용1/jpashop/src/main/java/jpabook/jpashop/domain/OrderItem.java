package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private int count;

    //==생성 메서드==//
    public static OrderItem createOrderItem(Item item, int orderPrice, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item); // 어떤 아이텐인지
        orderItem.setOrderPrice(orderPrice); // 아이템의 가격 세팅
        orderItem.setCount(count); // 아이템의 개수 세팅

        item.removeStock(count); // 아이템의 재고를 줄인다.
        return orderItem;
    }

    //==비즈니스 로직==//
    public void cancel(){
        //재고 수량을 원래대로 돌려놓음
        getItem().addStock(count);
    }
    //==조회 로직==//
    public int getTotalPrice(){
        return getOrderPrice() * getCount();
    }
}
