package com.information.java8.functionalinterface.consumerandsupplier;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerAndSupplierTest {

    // Consumer Abstract method is void
    //void accept(T t);

    //Supplier
    // T get();

    public static void main(String[] args) {
        Consumer<Integer> consumer = (x) -> System.out.println(x);
        Consumer<Integer> consumer2 = (y) -> System.out.println(y*y);

        Consumer<List<Integer>> listConsumer = (li) -> {
          for(Integer x : li)
              System.out.println(x);
        };

        consumer.accept(10);
        listConsumer.accept(List.of(1,2,3,4,5));

        // only same type allowed in and then in consumer (consumer and consumer2 have same parameter type
        consumer.andThen(consumer2).accept(100); // First it will call consumer print 100 and then consumer2
                                                    // Print 10000

        Supplier<Integer> supplier = () -> 2024;
        supplier.get();// it will return 2024;

        consumer.accept(supplier.get()); // and consumer will  print
    }
}
