package com.github.curriculeon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by leon on 1/8/2020.
 */
public class FileReader {
    private final String filename;

    public FileReader(String filename){
        this.filename = filename;
    }

    @Override
    public String toString(){
        String filepath = "src/main/resources" + filename;
        String data = "";
        File fileObject = new File(filepath);
        try {
            Scanner scanner = new Scanner(fileObject);
            while (scanner.hasNextLine()){
                data += scanner.nextLine();
                if(scanner.hasNextLine()){
                    data += "\n";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            data = new String(Files.readAllBytes(Paths.get(filepath)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return data;
    }
}
