package com.kakarot.plcenter.java8;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test4 {

    public static void main(String[] args) {
        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt(){
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);
    }
}
