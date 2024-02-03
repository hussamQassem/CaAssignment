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
            Scanner sc = new Scanner(new File(path));
            
            while (sc.hasNextLine()) {
            String ID="";
            line = sc.nextLine();
            name = line.split(" ");
                //System.out.println(name[0]);
            if (!name[0].matches("[a-zA-Z]*")) {
                    System.out.println("Invalid name, it contains a number: " + name[0]);
                    break;
                } 
                line=sc.nextLine();
                //System.out.println(line);
                int classNum = Integer.parseInt(line);
                //System.out.println(classNum);
                String classLoad;
                if (classNum == 1) {
                    classLoad="Very light"; 
                   // System.out.println(classLoad);
                }
                else if (classNum == 2) {
                    classLoad="light";
                   // System.out.println(classLoad);
                } else if (classNum > 2 && classNum < 6) {
                    classLoad="Parttime";
                   // System.out.println(classLoad);
                } else if (classNum >= 6 && classNum <= 8) {
                    classLoad="Fulltime";
                   // System.out.println(classLoad);
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
                //System.out.println(validInput);
                int checkNumber=Integer.parseInt(line.substring(0, 2));
                //System.out.println(checkNumber);

                if (validInput.matches("\\d\\d")&&checkNumber>=20) {
                   // System.out.println("First 2 chars are numbers");
                  ID=ID+validInput;
                   // System.out.println(ID);
                }
                else{System.out.println("first two characters must be numbers and bigger than 19");
                break;
                }
                validInput = line.substring(2, 4);
                //System.out.println(validInput);
                if(validInput.matches("[a-zA-Z]+")){
                   // System.out.println("Characters are letters");
                   ID=ID+validInput;
                }
                else{
                    System.out.println("the 3rd and 4th Characters must be letters");
                    break;
                }
                validInput = line.substring(6);
                //System.out.println(validInput);
                if(validInput.matches("[0-9]+")){
                    //System.out.println("the rest of the ID is numbers");
                    ID=ID+line.substring(4,5)+validInput;
                }
                else{System.out.println("there is letters in the last part");}
                studentDetail=ID+"-"+name[1]+"\n"+classLoad;
                System.out.println(studentDetail);
              status=status+"\n"+studentDetail+"\n";
                System.out.println("");
                if(sc.hasNextLine()){line =sc.nextLine();
                }
            

            }
            
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
