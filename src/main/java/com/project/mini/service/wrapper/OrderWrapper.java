package com.project.mini.service.wrapper;

import java.util.Date;
import java.util.UUID;

public class OrderWrapper {

    // registrasi id
    private UUID registrationId;

    // nama barang
    private String itemName;

    // keterangan pemesanan
    private String description;

    // jumlah
    private Integer quantity;

    // name pemesan
    private String customerName;

    // alamat pemesan
    private String customerAddress;

    // tanggal pemesanan
    private Date orderDate;

    public UUID getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(UUID registrationId) {
        this.registrationId = registrationId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
