package pkg;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LogicHandler {
FileHandler fh = new FileHandler();
int[] mainArray = new int[20];
String[] bracket_contents = new String[10];
    String localContent = fh.readFile();

    public LogicHandler() throws IOException {
    }

    public void start_Logic() throws IOException {
        int pointer = 0;
        int bank = 0;

        System.out.println(localContent);
        for(int i=0; i < localContent.length(); i++) {
            switch(localContent.charAt(i)) {
                case '+':
                   // System.out.println("+ found");
                    pointer++;
                    mainArray[bank] = pointer;
                    break;
                case '-':
                  //  System.out.println("- found");
                    pointer--;
                    mainArray[bank] = pointer;
                    break;
                case '>':
                    //System.out.println("> found");
                    bank++;
                    break;
                case '<':
                    System.out.println("< found");
                    bank--;
                    break;
                case '.':
                    //System.out.println(". found");
                    System.out.println("0x" + Integer.toHexString(pointer));
                    break;
                case ',':
                    System.out.println(", found");
                    break;
                case '[':
                    System.out.println("bracket ([) found");
                    //captureBracket(0);
                    break;
                case ']':
                    System.out.println("bracket (]) found");
                    //captureBracket(1);
                    break;
            }
        }
        System.out.println("Pointer: " + pointer);
        System.out.println("End Bank: " + bank);
        debug();
    }
    private void debug() {
       // for(int i=0; i < mainArray.length; i++) {
       //     System.out.println(mainArray[i]);
       // }
        captureBracket();
        for(int i=0;i<bracket_contents.length;i++) {
            System.out.println(bracket_contents[i]);
        }
    }
    private void captureBracket() {
        boolean running = false;
        int store = 0;
        String[] given = localContent.split("");
        for (int i=0;i<given.length;i++) {
            if (given[i].equalsIgnoreCase("[")) {
               // System.out.println("start of bracketed code = " + i);
                i++;
                running=true;
            }
            if (given[i].equalsIgnoreCase("]")) {
               // System.out.println("end of bracketed code = " + i);
                running=false;
            }
            if(running) {
                System.out.println(given[i]);
                bracket_contents[store] = given[i];
                store++;
            }
        }
    /*    List<String> list = Arrays.asList(given);
        if(list.contains("[")) {

        }
        if(list.contains("]")) {

        }*/

    }
}
/*
no idea why the array does x2 what it should.....
set bracket_contents to editable and not just a stolid 10
 */