package pkg;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LogicHandler {
FileHandler fh = new FileHandler();
    int pointer = 0;
    int bank = 0;
    //int brackLoop = 0;
    int non_null = 0;
    int[] mainArray = new int[20];
    String[] bracket_contents = new String[5];
    String localContent;
    {
        try {
            localContent = fh.readFile();
        } catch (IOException e) {
            System.out.println("IOEXCEPT");
            e.printStackTrace();
        }
    }
    boolean running = false;
    boolean foundBracket = false;

    public void start_Logic() throws IOException {
        System.out.println("Contents: " + localContent);
        captureBracket();
        if(!foundBracket) {
            for (int i=0; i<localContent.length();i++) {
                switch (localContent.charAt(i)) {
                    case '+':
                        pointer++;
                        mainArray[bank] = pointer;
                        break;
                    case '-':
                        if (!running) {
                            pointer--;
                            mainArray[bank] = pointer;
                        }
                        break;
                    case '>':
                        bank++;
                        break;
                    case '<':
                        System.out.println("< found");
                        bank--;
                        break;
                    case '.':
                        System.out.println("0x" + Integer.toHexString(pointer));
                        break;
                    case ',':
                        System.out.println(", found");
                        break;
                }
            }
        }
            System.out.println("Pointer: " + pointer);
            System.out.println("End Bank: " + bank);
            testingCode();
            ErrorHandler(0);
    }
    private void captureBracket() {
        int store = 0;
        boolean alreadyExecuted = false;
        boolean notgofast = false;
        String[] given = localContent.split("");
        for (int i=0;i<given.length;i++) {
            if (given[i].equalsIgnoreCase("[")) {
               // System.out.println("start of bracketed code = " + i);
                i++;
                running=true;
                foundBracket=true;
            }
            if (given[i].equalsIgnoreCase("]")) {
               // System.out.println("end of bracketed code = " + i);
                running=false;
            }
            if(running) {
                bracket_contents[store] = given[i];
                store++;
            }
            if(!alreadyExecuted) {
                foundBracket=false;
                alreadyExecuted = true;
            }

        }
        for (int i=0;i<bracket_contents.length;i++)
            if (Objects.equals(bracket_contents[i], "+")) {
                pointer--;
            }else if(Objects.equals(bracket_contents[i], "-")){
                pointer++;
            }else if(Objects.equals(bracket_contents[i], ">")){
                bank--;
            }
    }
    private void ErrorHandler(int opt) {
        switch(opt) {
            case 0:
                System.out.println("Code ran successfully!");
                break;
            case 1:
                System.out.println("Code encountered an error!");
                break;
            case 2:
                System.out.println("test");
                break;
        }
    }
    public void testingCode() {
        int local_pointer = 0;
        int local_bank = 0;


       for(int i=0;i<bracket_contents.length;i++) {
            if(!Objects.equals(bracket_contents[i], null)) {
                non_null++;
            }
       }
       for(int n=0;n<non_null;n++) {
           if(Objects.equals(bracket_contents[n], "+")) {
                local_pointer++;
           }else if(Objects.equals(bracket_contents[n], "-")) {
                local_pointer--;
           }else if(Objects.equals(bracket_contents[n], ">")) {
                bank++;
           }else if(Objects.equals(bracket_contents[n], "<")) {
                bank--;
           }
       }
    }
}
//Pointer if statement is still identifying the commands within the brackets therefore changing the pointer value with
//the preoccupied bracketed text as a for loop