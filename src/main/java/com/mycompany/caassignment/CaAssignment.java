/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.caassignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hussam
 */
public class CaAssignment {

    public static void main(String[] args) {
        
        
            String line;
            String[]name;
            String studentDetail="";
            String status="";
            int checkNumber=0;
           
            
        String path = "E:\\CCT COLLEGE\\javaTerm2\\code\\Students.txt";
        try {

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
            System.out.println(status);
            Scanner scan=new Scanner(System.in);
            
             int option;
             do{
                System.out.println("menu:");
                System.out.println("please chose if want to save data or insert manually:");
                System.out.println("to save data perss 1:\nto insert manually press 2:\nto exit press 0:");
                 
                 option=scan.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("saving data");
                        writToFile(status);
                        break;
                    case 2:
                        dataInput();
                        //System.out.println("please insert data");
                        break;
                    case 0:
                        System.out.println("exit");
                        break;
                    default:
                        System.out.println("please insert valid option");
                        break;
                }

             }while(option!=0);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }// end of main
    public static void writToFile(String status){
    
       // System.out.println(status);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("status.txt"));
            
            bw.write(status);
            bw.newLine();
            bw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(CaAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//end of writToFile
    public static void dataInput(){
    Scanner scan=new Scanner(System.in);
    String studentInput="";
    boolean inputValue=false;
    while(inputValue==false){
        try{
        System.out.println("insert full name");
       String fullName =scan.nextLine();
        String[] name = fullName.split(" ");
            
            if (!name[0].matches("[a-zA-Z]*")) {
                    System.out.println("Invalid name, it contains a number: " + name[0]);
                    
                }
            
            int classNum =0;
            String srtInput;
            boolean value=false;
            String classLoad="";
            
                 while(value==false){
                     System.out.println("how maney classes attended");
                     srtInput=scan.nextLine();
                     try{
                    classNum= Integer.parseInt(srtInput);
                    value=true;
                     }catch(NumberFormatException e){
                         System.out.println("please insert a valid number");
                     }

                 }// end of while
                System.out.println(classNum);
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
                }
                System.out.println("please insert student ID");
                System.out.println("ID must be a minimum of 6 characters\nfirst two characters must be numbers");
                System.out.println("the 3rd and 4th and possibly 5th being letters\neverything after last letter character being a number");
                
                String IdInput=scan.nextLine();
                if (IdInput.length() < 6) {
                    System.out.println("The ID should be a minimum of 6 characters");
                    
                }
                int checkNumber=0;
                String ID="";
                
                System.out.println(IdInput);
                String validInput = IdInput.substring(0, 2);

                if(validInput.matches("\\d\\d")){
                checkNumber=Integer.parseInt(IdInput.substring(0, 2));
                }else{
                    System.out.println("first two characters must be numbers");
                    
                }
                if (validInput.matches("\\d\\d")&&checkNumber>=20) {
                 ID=ID+validInput;
                }
                else{System.out.println("first two characters must be bigger than 19");
                }
                validInput = IdInput.substring(2, 4);
               
                if(validInput.matches("[a-zA-Z]+")){
                 
                   ID=ID+validInput;
                }
                else{
                    System.out.println("the 3rd and 4th Characters must be letters"); 
                }
                validInput = IdInput.substring(6);
               
                if(validInput.matches("[0-9]+")){
                    ID=ID+IdInput.substring(4,5)+validInput;
                }
                else{System.out.println("there is letters in the last part");
                }
                studentInput=ID+"-"+name[1]+"\n"+classLoad;
                System.out.println(studentInput);
                inputValue=true;
                
        }//end of try
        catch(NumberFormatException e){
            System.out.println("invalid inputs");
        }
        if(inputValue==true){
            try {
                FileWriter fw=new FileWriter("status.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(studentInput);
            bw.newLine();
            
            bw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(CaAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{System.out.println("invalid student data wont be saved");}
    }// end of while

    }//end of dataInput()
}
