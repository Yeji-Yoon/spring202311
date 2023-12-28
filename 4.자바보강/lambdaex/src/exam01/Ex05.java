package exam01;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class Ex05 {
    public static void main(String[] args) {
        //BiFunction<Integer,Integer,Integer> func = (a,b) -> a + b;
        //BinaryOperator<Integer> func = (a,b) -> a+b;
        IntBinaryOperator func = (a,b) -> a + b;
        int result = func.applyAsInt(10,20);
        System.out.println(result);

        Function<Integer,Integer> func4 = x -> x;
        Function<Integer,Integer> func5 = Function.identity();}}
