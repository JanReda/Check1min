package com.company;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        if (args.length != 4){
            //zła ilość parametrów
            System.out.println("");
            System.out.println("                     check1min     ver. 2.0, Belsk 2018-07-29");
            System.out.println("");
            System.out.println(" The program inspects Intermagnet Definitive files prepared for DVD one-minute compilation");
            System.out.println("");
            System.out.println("Program should be called with 4 arguments");
            System.out.println(" Example:");
            System.out.println("    check1min D:\\MAG2014\\HUA HUA 2014 REPORT.TXT");
            System.out.println(" In this example:");
            System.out.println("    D:\\MAG2014\\HUA        directory containing files of HUA for DVD2014");
            System.out.println("                          (12 IAF files, YEARMEAN.HUA, HUA2014.BLV, README.HUA)");
            System.out.println("    HUA                   IAGA code of given IMO");
            System.out.println("    2014                  year");
            System.out.println("    REPORT.TXT            report file (text file)");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            // halt;
            // zła ilość parametrów
        } else {
            //dobra ilość parametrów
            String Dir_iaf_str = args[0];
            Dir_iaf_str = Dir_iaf_str.toLowerCase();
            File File_dir_file_str = new File(Dir_iaf_str);
            if ( !File_dir_file_str.exists()) {
                //nie istnieje katalog z plikami IAF
                System.out.println("");
                System.out.println("There is not directory " + Dir_iaf_str);
                System.out.println("Continuation impossible");
                //nie istnieje katalog z plikami IAF
                //halt;
            }
            String IMO_str = args[1];
            IMO_str = IMO_str.toLowerCase();

            if (IMO_str.length() != 3) {
                System.out.println("Something wrong in 2-nd parameter - length of IMO code <> 3 chars");
                System.out.println("Continuation impossible");
                //halt
            }

            String year_str = args[2];
            year_str = year_str.toLowerCase();

            try {
                int year = Integer.parseInt(year_str);
            } catch(NumberFormatException e) {
                System.out.println(year_str);
                System.err.println("This is not a number! - continuation impossible");
                //halt
            }

            int year = Integer.parseInt(year_str);
            if ((year<1980) && (year>2040)){
                System.err.println("Something wrong in 3-rd parameter (year) - Continuation impossible");
                //halt
            }

            int Max_day = 365;
            if (year%4 == 0) {
                Max_day = 366;
            }

            String Raport_str = args[3];
            Raport_str = Raport_str.toLowerCase();
            System.out.println(Raport_str);
            Path path = Paths.get(Raport_str);
            path = path.toAbsolutePath(); // conversion realative path to absolute path
            Raport_str = path.toString();
            System.out.println(Raport_str);

//            //sposób 1
//            File fraport = new File(Raport_str);
//            if(fraport.createNewFile()) {//created successfully
//            } else {
//                fraport.delete();
//                fraport.createNewFile();
//            }
//
//            //sposób2
//            if(fraport.exists() == false) {
//                fraport.createNewFile();
//            } else {
//                fraport.delete();
//                fraport.createNewFile();
//            }

            //dobra ilość parametrów
        }

    }
}
