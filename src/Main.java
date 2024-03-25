import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        Scanner T = new Scanner(System.in);
        double c=0;
boolean isOp=false, isDiv=false, isNotN=false;
        ArrayList<String> inp=new ArrayList<>();
        File txt = new File("C:\\08_JAVA\\Obuchenie\\src\\input.txt");
        FileWriter writer=new FileWriter("C:\\08_JAVA\\Obuchenie\\src\\output.txt",true);
// - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - -
        System.out.println("Хотите ввести данные из файла \"input.txt\"? (y/n) ");
        String s=T.nextLine() ;
                        if (s.equals("Y")||s.equals("y")) {
                              Scanner T1 = new Scanner(txt);
                              while (T1.hasNextLine()) {
                                  inp.add(T1.nextLine()); }
                                  T1.close();
                         }
                       else if  (s.equals("N" )||s.equals("n" )) {
                          System.out.print("Введите задание: ");
                          inp.add(T.nextLine());
                          T.close();
                          }
                       else {
                            try { throw new MyException2() ; }
                             catch  (MyException2 e) {  System.out.println("Wrong selection!");
                                                        writer.write("Wrong selection! \n");
                                                        writer.flush();
                                                        writer.close();
                                                        System.exit(0); }
                        }
// . . . . . . . . . . . . . . . . . . . . . . . . . . .

        for(int i=0; i<inp.size(); i++){
               writer.write(inp.get(i)+" = ");
               writer.flush();
               System.out.print(inp.size()>1 ? inp.get(i)+" = " : " = ");
               String[] arr = inp.get(i).split(" ");
               char sign = arr[1].charAt(0);
               try {
                   Double a = Double.parseDouble(arr[0]), b = Double.parseDouble(arr[2]);
                   if ((sign != '+') && (sign != '-') && (sign != '*') && (sign != '/') || arr[1].length() > 1) {
                          try { throw new MyException(); }
                          catch (MyException e) {
                              System.out.println("Operation Error! ");
                              writer.write("Operation Error! \n");
                              writer.flush();
                              isOp=true;
                          }
                   }
                      if (b == 0 && (arr[1].charAt(0) == '/')) {
                          try {  throw new MyException1();  }
                          catch (MyException1 e) {
                              System.out.println("Error! Division by zero");
                              writer.write("Error! Division by zero \n");
                              writer.flush();
                              isDiv=true;
                              }
                      }
                      if(!isDiv && !isOp) {
                        if (arr[1].charAt(0) == '-') {  c = a - b;  }
                        if (arr[1].charAt(0) == '+') {  c = a + b;  }
                        if (arr[1].charAt(0) == '/') {  c = a / b;  }
                        if (arr[1].charAt(0) == '*') {  c = a * b;  }
                            System.out.println(c);
                            writer.write(Double.toString(c) + "\n");
                            writer.flush(); }
                      isOp=false; isDiv=false;
               } catch (NumberFormatException e) {
                   System.out.println("Error! Not number");
                   writer.write("Error! Not number \n");
                   writer.flush();
               }
        }
        writer.close();
//-----------------------------------------------------------------------------

    }}
   class MyException extends Exception {}
   class MyException1 extends Exception{}
   class MyException2 extends Exception{}

