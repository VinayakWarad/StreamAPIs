package com.example.StreamAPIs.programs;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierConsumer {
    public static void main(String[] args) {

        Supplier<String> sp=new Supplier<String>() {
            @Override
            public String get() {
                return "Hello String";
            }
        };

        Consumer<String> cs=new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        };
 // Stream Interface has static method generate which accepts supplier as arg
        Stream<String> streamOfString = Stream.generate(sp);
// Now we want to perform some action on generated String stream -> Let's print them here
       streamOfString.forEach(cs);


// ABove can be written using lambda as shown below (23 -26 optimised to below)
        (Stream.generate(()-> "Hello world")).forEach(str->System.out.println(str));

    }
}
