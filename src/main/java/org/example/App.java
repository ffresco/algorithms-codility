package org.example;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //ClassSource source = new ClassSource(null);
        ClassSource source = new ClassSource(true);
        ClassDestiny destiny = new ClassDestiny(false);
        BeanUtils.copyProperties(source, destiny);

        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.stream().map(i -> i + 1).forEach(i-> System.out.println(i));
        String vector[] = {"a","b","c","d"};
        List<String> list2 = List.of(vector);
        for (String s : list2) {

        }


    }
}
