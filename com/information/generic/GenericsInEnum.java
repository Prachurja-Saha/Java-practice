package com.information.generic;

enum Operation {

    SUBTRACTION, ADDITION, MULTIPLICATION;

    public <P extends Number, Q extends Number> double apply(P a, Q b) {

        // Java 12 concepts
        return switch (this) {

            case SUBTRACTION -> a.doubleValue() - b.doubleValue();

            /*
            The -> syntax can either directly return a value (without braces) or execute a block of code if you use {}.
            When using a block, you need to explicitly specify the value to return using the yield keyword.
            */
            case MULTIPLICATION -> {
                // Extra Operation
                // Why not return  -> b/c return is meant for method that's why Java provides the yield
                // keyword to return the value from the block.
                yield a.doubleValue() * b.doubleValue();
            }

            case ADDITION -> a.doubleValue() + b.doubleValue();

        };

    }

}

public class GenericsInEnum {

    public static void main(String[] args) {

        Operation operation = Operation.SUBTRACTION;

        System.out.println(operation.apply(10, 100));
    }
}
