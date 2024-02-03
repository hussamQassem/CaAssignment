/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.caassignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hussam
 */
public class CaAssignment {

    public static void main(String[] args) {
        String path = "E:\\CCT COLLEGE\\javaTerm2\\code\\Students.txt";
        try {
            String line;
            String[]name;
             String studentDetail="";
             String status="";
             int checkNumber=0;
            Scanner sc = new Scanner(new File(path));
            
            while (sc.hasNextLine()) {
            String ID="";
            line = sc.nextLine();
            name = line.split(" ");
            
            if (!name[0].matches("[a-zA-Z]*")) {
                    System.out.println("Invalid name, it contains a number: " + name[0]);
                    break;
                } 
                line=sc.nextLine();
                int classNum = Integer.parseInt(line);
                String classLoad;
                if (classNum == 1) {
                    classLoad="Very light";
                }
                else if (classNum == 2) {
                    classLoad="light";
                } else if (classNum > 2 && classNum < 6) {
                    classLoad="Parttime";
                } else if (classNum >= 6 && classNum <= 8) {
                    classLoad="Fulltime";
                }
                else{System.out.println("classes number out or range");
                break;
                }
                line=sc.nextLine();
                if (line.length() < 6) {
                    System.out.println("The ID should be a minimum of 6 characters");
                    break;
                }
                String validInput = line.substring(0, 2);

                if(validInput.matches("\\d\\d")){
                checkNumber=Integer.parseInt(line.substring(0, 2));
                }else{
                    System.out.println("first two characters must be numbers");
                    break;
                }
                if (validInput.matches("\\d\\d")&&checkNumber>=20) {
                  ID=ID+validInput;
                }
                else{System.out.println("first two characters must be bigger than 19");
                break;
                }
                validInput = line.substring(2, 4);
               
                if(validInput.matches("[a-zA-Z]+")){
                 
                   ID=ID+validInput;
                }
                else{
                    System.out.println("the 3rd and 4th Characters must be letters");
                    break;
                }
                validInput = line.substring(6);
               
                if(validInput.matches("[0-9]+")){
                    ID=ID+line.substring(4,5)+validInput;
                }
                else{System.out.println("there is letters in the last part");}
                studentDetail=ID+"-"+name[1]+"\n"+classLoad;
               
              status=status+"\n"+studentDetail+"\n";
                
                if(sc.hasNextLine()){line =sc.nextLine();
                }
               
            

            }
            Scanner scan=new Scanner(System.in);
            
             System.out.println(status);


             int option;
             do{
                System.out.println("menu:");
                System.out.println("please chose if want to save data or insert manually:");
                System.out.println("to save data perss 1:\nto insert manually press 2:\nto exit press 0:");
                 
                 option=scan.nextInt();
             
                 switch(option){
                     case 1:
                         System.out.println(" saving data");
                         break;
                     case 2:
                         System.out.println(" insert data");
                         break;
                     case 3:
                         System.out.println("exit");
                        
                     case 4:
                         System.out.println("invalid input");
                         break;
                     
                 }
             }while(option!=0);
             
             
                     
                     
                     
                     
                     
                 
             
             
             
             
            /*int chose=-1 ;
            while(chose!=0){
            Scanner scaner=new Scanner(System.in);
            
                System.out.println("please chose if want to save data or insert manually");
                System.out.println("perss\n 1- save data\n2- insert manually\n 0- exit");
                scaner.nextLine();
                if(chose==0){
                    break;
                
                }else if(chose==1){
                    System.out.println("saving data");
                }
                else if(chose==2){
                    scaner.nextLine();
                }
                else{
                    System.out.println("invalid insert");
                }
            }*/
             
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
