package Cwiczenia;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class cwiczenia {

    public static void main(String[] args) throws IOException {

        //new Branch

        File file = new File("src\\main\\resources\\pliczek.txt");
        file.createNewFile();

        String name1 = "Paweł";
        String name2 = "Paweł";

        boolean czysatakiesame = name1.equals(name2);
        System.out.println("czy są?: "+ czysatakiesame);

        int res = 5;

        if (res==5){
            System.out.println("równa się 5");
        } if(res>1)
            System.out.println("jest większe od 1");
        else if (res<1)
            System.out.println("jest mniejsze od 1");
        else
            System.out.println("else");

        FileWriter writer = new FileWriter(file,true);
        FileReader reader = new FileReader(file);
        Scanner scanner = new Scanner(file);
        List<String>calyTeks = new ArrayList<>();

        writer.write("\npiaty podjazd elo");
        writer.close();
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            calyTeks.add(line);
            System.out.println(calyTeks.size());
        }

        calyTeks.forEach(System.out::println);

        int [] array = {1,2,2,2,3,3,4,5,5,5,5,5};
        counter(array);
        reverseAyyay(array);
        fizzbuzz();
        int silnia7 = silnia(3);
        System.out.println(silnia7);
        int fibbonaczi13 = fibonaci(13);
        System.out.println(fibbonaczi13);
        boolean kajak = kajak("Kajak");
        System.out.println(kajak);

        List<String> lista = Arrays.asList("Tomek", "Romek", "Ola");
        System.out.println("Czy ma Ole? -> " + lista.contains("Ola"));

        Collections.sort(lista);
        System.out.println(lista);

        Collections.reverse(lista);
        System.out.println(lista);

        //STREAMY, KOLEKCJE

        List<String> names = Arrays.asList("Paweł", "Piotrek", "PAmela", "Ola", "Pola");


        Stream<String> namesString = names.stream();
        namesString.filter(el -> el.startsWith("P"))
                .limit(3);

        Stream<Integer> numberStrem = Arrays.asList(2,6,4,54,4).stream();
        boolean iseven = numberStrem.allMatch(num -> num%2==0);
        System.out.println("are the numver even: " + iseven);


    }


    //OBLICZAC ILE RAZY WYSTAPIŁ
    public static void counter(int[]array){
        System.out.println("ZLICZANIE ILE RAZY SIĘ POJAWIŁO--------------");
        Map<Integer,Integer> occurance = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(occurance.containsKey(array[i])){
                int value = occurance.get(array[i]);
                occurance.put(array[i], value+1);
            }
            else {
                occurance.put(array[i], 1);
            }
        }
        for (Integer key : occurance.keySet()) {
            System.out.println("Liczba: " + key + "Pojawiła się: " + occurance.get(key));
        }
    }

    //ODWÓRCONA TABLICA

    public static void reverseAyyay(int[]array){
        System.out.println("ODWRÓCONA TABLICA --------------");
        for (int i = 0; i < array.length/2; i++) {
            int value = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = value;
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

    //FIZZBUZZ

    public static void fizzbuzz(){
        System.out.println("FIZZZBUZZZ------------");
        int fizz=0;
        int buzz=0;
        int fizzbuzz=0;
        int non=0;

        for (int i = 0; i < 100; i++) {
            if(i%3==0 && i%5==0){
                System.out.println("FIZZBUZZ");
                fizzbuzz++;
            }
            else if(i%3==0){
                System.out.println("FIZZ");
                fizz++;
            }
            else if (i%5==0){
                System.out.println("BUZZ");
                buzz++;
            }
            else {
                System.out.println("non");
                non++;
            }
        }
        System.out.println("FIZZ: " + fizz + " BUZZ: " + buzz + " FIZZBUZZ: " + fizzbuzz + " non: " + non);
        System.out.println("Poprawny wynik: Fizzbuzz: 7 Fizz: 27 Bizz: 13 NON: 53");
    }

    //SILNIA
    public static int silnia(int n){
        if(n<2) {
            System.out.println("SILNIA-------------------");
            return 1;
        }
        else
            return n*silnia(n-1);
    }

    //FIBONACZI
    public static int fibbonaczi(int n){
        if(n==0){
            return 0;
        } else if (n==1){
            return 1;
        }
        else
            return fibbonaczi(n-1)+fibbonaczi(n-2);
    }


    public static int silniaa(int n){
        if(n<2){
            return 1;
        } else
            return n*silniaa(n-1);
    }















    public static int fibonaci(int n){
        if(n==0)
            return 0;
        else if (n==1)
            return 1;
        else
            return fibonaci(n-1)+fibonaci(n-2);
    }

    //KAJAK
    public static boolean kajak(String word){
        System.out.println("KAJAK--------------");
        word.toLowerCase(Locale.ROOT);
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < wordChar.length/2; i++) {
            if(wordChar[i]==wordChar[wordChar.length-i-1])
                return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
