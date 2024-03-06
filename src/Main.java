import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner T = new Scanner(System.in);
        double c=0;
        String inp="" ;
        File txt = new File("C:\\08_JAVA\\Obuchenie\\src\\input.txt");
// - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - -
        System.out.println("Хотите ввести данные из файла \"input.txt\"? (y/n) ");
        String s=T.nextLine() ;
                        if (s.equals("Y" )||s.equals("y" )) {
                          Scanner T1 = new Scanner(txt);
                          inp = T1.nextLine();
                          T1.close();
                            System.out.println(inp+" =");
                         }
                       if  (s.equals("N" )||s.equals("n" )) {
                          System.out.println("Введите задание: ");
                          inp=T.nextLine();
                          T.close();
                          }
// . . . . . . . . . . . . . . . . . . . . . . . . . . .
            String[] arr = inp.split(" ");
            char sign = arr[1].charAt(0);
            try {
                Double a = Double.parseDouble(arr[0]), b = Double.parseDouble(arr[2]);
                if ((sign != '+') && (sign != '-') && (sign != '*') && (sign != '/') || arr[1].length() > 1) {
                    try {  throw new MyException(); }
                           catch (MyException e) {  System.out.println("Operation Error!");
                                                    System.exit(0); }
                }
                if (b == 0 && (arr[1].charAt(0) == '/')) {
                    try { throw new MyException1(); }
                          catch (MyException1 e) {  System.out.println("Error! Division by zero");
                                                     System.exit(0); }
                }
// ..............................................................................
                if (arr[1].charAt(0) == '-') { c = a - b; }
                if (arr[1].charAt(0) == '+') { c = a + b; }
                if (arr[1].charAt(0) == '/') { c = a / b; }
                if (arr[1].charAt(0) == '*') { c = a * b; }
                System.out.println(c);
            } catch (NumberFormatException e) {
                System.out.println("Error! Not number"); }
    }}
   class MyException extends Exception {}
   class MyException1 extends Exception{}