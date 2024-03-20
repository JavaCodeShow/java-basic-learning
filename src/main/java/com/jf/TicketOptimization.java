package com.jf;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
class Ticket {
    String type;
    int price;
    int quantity;

    public Ticket(String type, int price, int quantity) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }
}

@Data
class ExchangeCoupon {
    List<String> ticketTypes;

    public ExchangeCoupon(List<String> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }
}

public class TicketOptimization {

    public static int calculateOptimalPrice(List<Ticket> tickets, List<ExchangeCoupon> coupons) {
        // Initialize the total price with the original total price for all tickets
        int totalPrice = tickets.stream().mapToInt(ticket -> ticket.price * ticket.quantity).sum();

        // Iterate through the coupons
        for (ExchangeCoupon coupon : coupons) {
            int minPrice = Integer.MAX_VALUE;

            // Find the minimum price of tickets that can be bought using this coupon
            for (String ticketType : coupon.ticketTypes) {
                int price = tickets.stream()
                        .filter(ticket -> ticket.type.equals(ticketType))
                        .mapToInt(ticket -> ticket.price)
                        .min()
                        .orElse(0);
                int quantity = (int) Math.ceil((double) totalPrice / price); // Calculate the quantity of tickets that can be bought with the current coupon
                minPrice = Math.min(minPrice, price * quantity);
            }

            // Deduct the minimum price from the total
            totalPrice = Math.min(totalPrice, totalPrice - minPrice);
        }
        return totalPrice;
    }

    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("A", 10, 2));
        tickets.add(new Ticket("B", 20, 2));
        tickets.add(new Ticket("C", 30, 2));

        List<ExchangeCoupon> coupons = new ArrayList<>();
        List<String> coupon1Types = Arrays.asList("A", "B");
        List<String> coupon2Types = Arrays.asList("A", "B", "C");
        coupons.add(new ExchangeCoupon(coupon1Types));
        coupons.add(new ExchangeCoupon(coupon2Types));

        int i = calculateOptimalPrice(tickets, coupons);
        System.out.println("Total Price: " + i);
    }
}