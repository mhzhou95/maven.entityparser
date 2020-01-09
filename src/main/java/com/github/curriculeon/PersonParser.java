package com.github.curriculeon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by leon on 1/8/2020.
 */
public class PersonParser implements Parser<Person> {
    @Override
    public Person parseString(String data) {
        String[] details = data.split("\n");
        long id = Long.parseLong(details[0]);
        Person person = new Person(id, details[1], details[2]);
        return person;
    }

    @Override
    public Person[] parseStrings(String[] data) {
        Person[] people = new Person[data.length];
        for (int i = 0; i < data.length; i++) {
            people[i] = parseString(data[i]);
        }
        return people;
    }

    @Override
    public Person[] parseFile(File data) throws FileNotFoundException {
        String person = "";
        List<Person> listPeople = new ArrayList<>();
        Person[] arrayPeople;
        Scanner scanner = new Scanner(data);
        int count =0;
        while(scanner.hasNextLine()) {
         person += scanner.nextLine();
         person += "\n";
         count ++;
         if(count ==3){
             Person someone = parseString(person);
             listPeople.add(someone);
             System.out.println(listPeople.get(0));
             System.out.println(person);
             person = "";
             count = 0;
         }
        }
        arrayPeople = listPeople.toArray(new Person[0
                ]);
        return arrayPeople;
    }
}
