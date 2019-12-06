package com.xinyu.test.java.stream;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by zy on 2019/10/30.
 * https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 *
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
 *
 * https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("c2", "d3", "a1", "5");
        strings.stream()
                .filter( (string) -> string.length() >=2)
//                .map((string) -> string.toUpperCase())
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
//                .forEach(string -> System.out.println(string));
        System.out.println("-------------------");
        strings.forEach(System.out::println);

//        Stream.of("223","fff","dddd","ccc").forEach(String::codePointCount);
        System.out.println("------------------");
        Stream.of("223","fff","dddd","ccc").forEach(System.out::println);

        IntStream.range(10,20).forEach(System.out::println);

        IntStream stream = Arrays.stream(new int[]{2, 3});
//        System.out.println(stream.sum());
        System.out.println(stream.average());
//        System.out.println(stream.count());
        Optional<Integer> max = Stream.of(12, 21, 23).max((num1, num2) -> num1 > num2 ? 1 : -1);
        System.out.println(max.get());

        IntStream.range(3,5).mapToObj(num -> "a"+num).forEach(System.out::println);

        IntStream.range(1,9).filter(num -> {System.out.println(num); return true;});
        IntStream.range(1,9).filter(num -> {System.out.println("filter:"+num); return true;}).forEach(System.out::println);


        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));


        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));


        Stream.of("d2", "a2", "b1", "b3", "c")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));



        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        Supplier<IntStream> streamSupplier = ()-> IntStream.range(10,20);
        System.out.println(streamSupplier.get().max());
        System.out.println(streamSupplier.get().average());

        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("Pamela2", 23),
                        new Person("David", 12));


        List<Person> filtered =
                persons
                        .stream()
                        .filter(p -> p.name.startsWith("P"))
                        .collect(Collectors.toList());

        System.out.println(filtered);    // [Peter, Pamela]

        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));

        personsByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));


        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));

        System.out.println(averageAge);     // 19.0

        IntSummaryStatistics ageSummary =
                persons
                        .stream()
                        .collect(Collectors.summarizingInt(p -> p.age));

        System.out.println(ageSummary);


        String phrase = persons
                .stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(phrase);

        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2));

        System.out.println(map);
// {18=Max, 23=Peter;Pamela, 12=David}


        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);


        List<Foo> foos = new ArrayList<>();

// create foos
        IntStream
                .range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

// create bars
        foos.forEach(f ->
                IntStream
                        .range(1, 4)
                        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- "+ f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));


        Outer outer = new Outer();
        if (outer != null && outer.nested != null && outer.nested.inner != null) {
            System.out.println(outer.nested.inner.foo);
        }

        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);

        persons
                .stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);    // Pamela


        Person result =
                persons
                        .stream()
                        .reduce(new Person("", 0), (p1, p2) -> {
                            p1.age += p2.age;
                            p1.name += p2.name;
                            return p1;
                        });

        System.out.format("name=%s; age=%s", result.name, result.age);
// name=MaxPeterPamelaDavid; age=76

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        /*Stream<Integer> outputStream =*/ inputStream.
                flatMap((childList) -> childList.stream()).forEach(System.out::println);

    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
        this.name = name;
    }
}

class Bar {
    String name;

    Bar(String name) {
        this.name = name;
    }
}

class Outer {
    Nested nested;
}

class Nested {
    Inner inner;
}

class Inner {
    String foo;
}
