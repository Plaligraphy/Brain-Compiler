package pkg;

import java.io.IOException;
//Current problem: java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
//line 68

public class LogicHandler {
    public LogicHandler() throws IOException {
    }
    char[] toCompile = getFileContents().toCharArray();
    int bankCurrent = 0;
    int pointer = 0;
    public void start_Logic() throws IOException {
        System.out.println(getFileContents());
        for(int i=0;i<toCompile.length;i++) {
            switch(toCompile[i]) {
                case '[':
                    for_loop(1,i);
                    break;
                case ']':
                    for_loop(0,i);
                    break;
                case '<':
                    bankCurrent--;
                 //   System.out.println("bank --");
                    break;
                case '+':
                    pointer++;
                 //   System.out.println("inc");
                    break;
                case '-':
                    pointer--;
                //    System.out.println("dec");
                    break;
                case '>':
                    bankCurrent++;
                //    System.out.println("bank++");
                    break;
                case '.':
                   // System.out.println(pointer);
                //    System.out.println("out");
                    break;
                case ',':
                 //   System.out.println("out pt2");
                    break;
            }

        }
        System.out.println(bankCurrent);
        System.out.println(pointer);
    }
    private void for_loop(int status, int given_locale) {
        char[] for_contents = new char[10];
        int beginning_locale = 0;
        int ended_locale = 0;
        switch(status) {
            case 0:
              //  System.out.println("for loop stopped at");
                ended_locale = given_locale;
                break;
            case 1:
               // System.out.println("for loop started");
                beginning_locale = given_locale;
                break;
        }
        beginning_locale++;

        for(int c=0;c<pointer;c++) {
            for_contents[c] = toCompile[c];
            //System.out.println(for_contents[c]);
            if(for_contents[c] == '+') {
                pointer++;
            }else if(for_contents[c] == '-') {
                pointer--;
            }
        }

        for(int d=beginning_locale;d<ended_locale;d++){
            for_contents[d] = toCompile[d];
            if(for_contents[d] == '+') {
                pointer--;
            }else if(for_contents[d] == '-') {              //Has to be last to run
                pointer++;
            }
        }
    }
    private String getFileContents() throws IOException {
        FileHandler file_handle = new FileHandler();
        return(file_handle.readFile());
    }
}
