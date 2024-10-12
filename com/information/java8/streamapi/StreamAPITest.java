package com.information.java8.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest {

    /*
    * Advantage of Stream
    * 1. Readability -> b/c of declarative approach
    * 2. Flexibility -> variety of operation i.e filter, map etc
    * 3. Parallelism -> can be processed in parallel. performance boost for large collections
    * 4. Encapsulation ->
    *
    * */

    public static void main(String[] args){

        /* How to create a stream */
        // 1
        List<Integer> integerList = List.of(1,2,3);
        Stream<Integer> integerStream = integerList.stream();
        System.out.println("Interger Stream : " + integerStream.toList());

        // 2
        Stream<String> stringStream = Stream.of("abc","xyz");
        System.out.println("String Stream : " + stringStream.toList());

        // 3
        Stream<String> iteratorStream = Stream.iterate("a", s -> s+s).limit(3);
        System.out.println("Iterator Stream : " + iteratorStream.toList());

        // 4
        Stream<String> integerStream1 = Stream.generate(()-> "hi").limit(2);
        System.out.println("Generate Stream : " + integerStream1.toList());

        // 5
        Integer intArray[] = {10,20,30,40,50};
        Stream<Integer> integerStreamArray = Arrays.stream(intArray);
        System.out.println("Integer array : " + integerStreamArray.toList());


        // .collect(Collectors.toList()) -> convert Stream to list
        // .toList() -> better approach


        /* Testing operation
                1. Creation
                2. Intermediate(filter,map, flatMap, distinct, sorted..etc)
                3. Terminal(foreach, count,max,min..etc) after terminal stream operation will stop
        *
        * Intermediate operations return a new stream and can be chained together,
        *
        * while terminal operations produce a result and mark the end of a stream pipeline.
        * */


        /*
        * Example 1
        * */
        List<Integer> integerList1 = Arrays.asList(10,11,7,19,29,100,1,6,7,81,10);

        System.out.println("distinct even and sorted-descending");
        // filter, distinct, sorted -> .sorted((x,y)->y.compareTo(x))
        // IMP -> peek - we can perform operation accepts consumer/ same as forEach

        integerList1.stream().distinct().filter(n -> n%2 == 0)
//                .sorted(Comparator.comparing(n->n).reversed()) C.T
                .sorted(Comparator.reverseOrder()) // Works
                //.sorted(Comparator.comparing((x,y)->x)) C.T // Here issue is type. By using getter
                // we provide the return type of Function<> interface which means we provide Comparable type also
                .limit(3)
                .peek(x -> System.out.println("before skip : "+ x))
                .skip(1) // It will skip n element from 1st here n is 1 so it will skip 1st element
                .forEach(System.out::println);
        // Stream class -> public static final PrintStream out = null;

        /*System.out: The System class has a static field named out, which is of type PrintStream.
        This field is initialized automatically when the JVM starts. You don't need to create an instance manually. */


        /*
         * Example 2
         * */

        int minimumValueInList = Stream.iterate(0, i -> i + 1)
                .limit(integerList1.size())
                .map(integerList1::get) // -> .map(i -> integerList1.get(i))
                .peek(x -> System.out.println("started operation of element : " + x))
                .min(Comparator.naturalOrder())//.min(Comparator::naturalOrder) not working don't know
                .get();

        System.out.println("Minimum value: "+minimumValueInList);


        /* MapToObj
        * You can use mapToObj when working with a stream of primitive types (such as IntStream, LongStream,
        * or DoubleStream) and want to convert it into a stream of objects.
        * It allows you to map primitive values to objects by applying a function that returns the desired object type.
        *
        * IntStream.range(1, 5)
            .mapToObj(i -> "Number: " + i)
            .forEach(System.out::println);
        * */






















        /* Code Check prime number */
        // Check Prime number
        List<String> stringList = integerList1.stream().map((x) -> {

            int sqrt = (int)Math.sqrt(x);
            while(sqrt>1){
                if(x%sqrt == 0)
                    return x + ": Not Prime";

                sqrt--;
            }
            return x + ": prime";
        }).toList();

        System.out.println("Calculating prime");
        System.out.println(stringList);


    }
}
