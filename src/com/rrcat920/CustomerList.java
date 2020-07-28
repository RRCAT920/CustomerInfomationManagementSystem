package com.rrcat920;

import java.util.Arrays;

public class CustomerList {
    private Customer[] customers;
    private static int size = 0;

    public CustomerList(int length) {
        customers = new Customer[length];
    }

    public Customer getCustomer(int index) {
        if (index < 0 || index >= size) return null;
        return customers[index];
    }

    public void addCustomer(Customer customer) {
        if (size == customers.length - 1)
            customers = Arrays.copyOf(customers, customers.length * 2);
        customers[size++] = customer;
    }

    public void replaceCustomer(int index, Customer customer) {
        if (index < 0 || index >= size) return;
        customers[index] = customer;
    }

    public void deleteCustomer(int index) {
        if (index < 0 || index >= size) return;
        customers[index] = null;
        for (int i = index; i < size - 1; i++) {
            customers[index] = customers[index + 1];
        }
        size--;
        customers[size] = null;
        if (customers[customers.length / 3 * 2 - 1] == null)
            customers = Arrays.copyOf(customers, customers.length / 3 * 2);
    }

    public int length() {
        return size;
    }
}
