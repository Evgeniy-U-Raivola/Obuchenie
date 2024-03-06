import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        Scanner T = new Scanner(System.in);
        double c=0;
        String inp="" ;
        File txt = new File("C:\\08_JAVA\\Obuchenie\\src\\input.txt");
        FileWriter writer=new FileWriter("C:\\08_JAVA\\Obuchenie\\src\\output.txt",true);
// - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - -
        System.out.println("Хотите ввести данные из файла \"input.txt\"? (y/n) ");
        String s=T.nextLine() ;
                        if (s.equals("Y" )||s.equals("y" )) {
                          Scanner T1 = new Scanner(txt);
                          inp = T1.nextLine();
                          T1.close();
                            System.out.println(inp+" =");
                            writer.write(inp+" = \n");
                            writer.flush();
                         }
                       if  (s.equals("N" )||s.equals("n" )) {
                          System.out.println("Введите задание: ");
                          inp=T.nextLine();
                          T.close();
                          writer.write(inp+" =\n");
                          writer.flush();
                          }
// . . . . . . . . . . . . . . . . . . . . . . . . . . .
            String[] arr = inp.split(" ");
            char sign = arr[1].charAt(0);
            try {
                Double a = Double.parseDouble(arr[0]), b = Double.parseDouble(arr[2]);
                if ((sign != '+') && (sign != '-') && (sign != '*') && (sign != '/') || arr[1].length() > 1) {
                    try {  throw new MyException(); }
                           catch (MyException e) {  System.out.println("Operation Error! ");
                                                    writer.write("Operation Error! \n");
                                                    writer.flush();
                                                    writer.close();
                                                    System.exit(0); }
                }
                if (b == 0 && (arr[1].charAt(0) == '/')) {
                    try { throw new MyException1(); }
                          catch (MyException1 e) {  System.out.println("Error! Division by zero");
                                                    writer.write("Error! Division by zero \n");
                                                    writer.flush();
                                                    writer.close();
                                                    System.exit(0); }
                }
// ..............................................................................
                if (arr[1].charAt(0) == '-') { c = a - b; }
                if (arr[1].charAt(0) == '+') { c = a + b; }
                if (arr[1].charAt(0) == '/') { c = a / b; }
                if (arr[1].charAt(0) == '*') { c = a * b; }
                System.out.println(c);
                writer.write(Double.toString(c)+"\n");  //c+""
                writer.flush();
            } catch (NumberFormatException e) {
                System.out.println("Error! Not number");
                writer.write("Error! Not number \n");
                writer.flush();
                writer.close();  }
//-----------------------------------------------------------------------------
    }}
   class MyException extends Exception {}
   class MyException1 extends Exception{}

