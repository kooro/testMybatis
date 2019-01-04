package com.weigram.model;

public class OrderDetail {
    private Integer id;//定单详情ID
    private Integer itemsId;//商品ID
    private Integer itemsNum;//商品购买数量

    private Items items;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", itemsId=" + itemsId +
                ", itemsNum=" + itemsNum +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public Integer getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(Integer itemsNum) {
        this.itemsNum = itemsNum;
    }
}
