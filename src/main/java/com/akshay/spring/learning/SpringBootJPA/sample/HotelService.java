package com.akshay.spring.learning.SpringBootJPA.sample;/*
package com.akshay.spring.learning.SpringBootJPA.sample;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HotelService {
    List<Hotel> hotels;
    public Hotel cheapestHotel(Request request){
        hotels.stream().min(hotel -> Comparator.comparing(h -> ((Hotel) h).costOf(request)));
    }
}

class Category{
    private Customer customer;
    private Day day;

    public Category(Customer customer, Day day) {
        this.customer = customer;
        this.day = day;
    }
}

class Hotel{
    private String name;
    private int rating;
    private Map<Category, Integer> rateCard;

    public int costOf(Request request){
        return request.categories().stream().mapToInt(category -> rateCard.get(category)).sum();
    }
}

class Request {
    private Customer customer;
    private List<Day> days;

    public List<Category> categories() {
        return days.stream().map(d -> new Category(customer, d)).collect(Collectors.toList());
    }
}

enum Day{
    WEEKDAY, WEEKEND
}

enum Customer {
    REGULAR, PREMIUM
}

*/





import java.util.*;
import java.util.concurrent.Semaphore;

class ThreadEx extends Thread {
    Semaphore even, odd;
    int no;

    ThreadEx(int no, Semaphore even, Semaphore odd) {
        this.no = no;
        this.even = even;
        this.odd = odd;
    }

    public void run() {
        if(Thread.currentThread().getName().equals("even")) {
            try {
                for (int i = 1; i <=no; i+=2) {
                    even.acquire();
                    System.out.println(this.getName() + " : " + i);
                    odd.release();


                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        else
        {
            try {
                for (int i = 2; i <=no; i+=2) {
                    even.acquire();
                    //Thread.sleep(10000);
                    System.out.println(this.getName() + " : " + i);
                    odd.release();


                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}


class Thread1 {
    public static void main(String args[]) {
        Semaphore even = new Semaphore(0);
        Semaphore odd = new Semaphore(1);

        int no = 10;

        ThreadEx t1 = new ThreadEx(no, even, odd);
        ThreadEx t2 = new ThreadEx(no, odd, even);
        t1.setName("even");
        t2.setName("odd");
        t1.start();
        t2.start();
    }
}
