package dev.ossenbeck.common;

import java.math.BigInteger;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {
    public static final Pattern DOUBLE_LINE_SEPARATOR = Pattern.compile(System.lineSeparator() + System.lineSeparator());
    public static final Pattern LINE_SEPARATOR = Pattern.compile(System.lineSeparator());
    public static final Pattern SPACE_SEPARATOR = Pattern.compile("\\s");
    public static final Pattern SINGLE_CHAR_SEPARATOR = Pattern.compile("");
    public static final Pattern NUMBER_PATTERN = Pattern.compile("(-?\\d+)");

    public static IntStream parseNumbers(String line) {
        return NUMBER_PATTERN.matcher(line).results()
                .map(MatchResult::group)
                .mapToInt(Integer::parseInt);
    }

    public static List<Integer> parseNumbersAsList(String line) {
        return parseNumbers(line).boxed().toList();
    }

    public static int[] parseNumbersAsArray(String line) {
        return parseNumbers(line).toArray();
    }

    public static List<String> zip(List<String> rows) {
        return IntStream.range(0, rows.getFirst().length())
                .mapToObj(column -> rows.stream()
                        .map(row -> row.charAt(column))
                        .map(String::valueOf)
                        .collect(Collectors.joining()))
                .toList();
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long determinant(long ax, long ay, long bx, long by) {
        return ax * by - ay * bx;
    }

    //Gauß'sche Trapezformel (engl. Shoelace formula)
    public static long area(List<Coordinate> c) {
        return Math.abs(IntStream.range(0, c.size())
                .mapToLong(i -> (long) c.get(i).x() * (long) (c.get((i + 1) % c.size()).y() - c.get((i - 1 + c.size()) % c.size()).y()))
                .sum()) / 2;
    }

    public static long concatNumbers(long a, long b) {
        return Long.parseLong(String.valueOf(a) + b);
    }

    public static int concatNumbers(int a, int b) {
        return Integer.parseInt(String.valueOf(a) + b);
    }

    public static int mod(int value, int mod) {
        return (value % mod + mod) % mod;
    }

    public static long mod(long value, long mod) {
        return (value % mod + mod) % mod;
    }

    public static long factorial(long n) {
        var result = 1L;
        for (var i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static BigInteger factorialBig(long n) {
        var result = BigInteger.ONE;
        for (var i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}