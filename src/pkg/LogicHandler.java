package pkg;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LogicHandler {
FileHandler fh = new FileHandler();

    int[] mainArray = new int[20];
    String[] bracket_contents = new String[10];
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
        int pointer = 0;
        int bank = 0;
        System.out.println("Contents: " + localContent);
        captureBracket();
        if(!foundBracket) {
            for (int i = 0; i < localContent.length(); i++) {
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
              /*  case '[':
                    System.out.println();
                    break;*/
               /* case ']':
                    System.out.println("bracket (]) found");
                    captureBracket();
                    break;*/ //Possibly redudant
                }
            }
        }
            System.out.println("Pointer: " + pointer);
            System.out.println("End Bank: " + bank);
            debug();

    }
    private void debug() {
        //captureBracket();
        for(int i=0;i<bracket_contents.length;i++) {
            System.out.println(bracket_contents[i]);
            //prints out whats inside the found bracket
        }
    }
    private void captureBracket() {
        int store = 0;
        boolean alreadyExecuted = false;
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

    }
}
//Pointer if statement is still identifying the commands within the brackets therefore changing the pointer value with
//the preoccupied bracketed text as a for loop