package com.sanjin;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        String baseFileName = "";
        try{
            baseFileName = args[0] ;
        } catch(ArrayIndexOutOfBoundsException e){
            baseFileName = "filename";
        }
        File curDir = new File(".");

        int counter=1;

        for(File f :curDir.listFiles()){
            if(f.isDirectory()){
                System.out.println("renaming "+f.getName());
                File newFile = new File(baseFileName+String.format(" %03d", counter));
                if (newFile.exists()) {
                    System.out.println("Destination file name already exists!");
                }
                if(!f.renameTo(newFile)) {
                    System.out.println("Failed to rename " + f.getName() + " -> " + newFile);
                }
                counter++;
            }
        }
    }
}
