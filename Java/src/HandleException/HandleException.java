package HandleException;
/*

Checked vs Unchecked Exceptions in Java
In Java, there two types of exceptions:

1) Checked: are the exceptions that are checked at compile time.
If some code within a method throws a checked exception,
then the method must either handle the exception or it must specify the exception using throws keyword.

For example, consider the following Java program that opens file at locatiobn “C:\test\a.txt” and prints first three lines of it.
The program doesn’t compile,
because the function main() uses FileReader() and FileReader() throws a checked exception FileNotFoundException.
It also uses readLine() and close() methods, and these methods also throw checked exception IOException

import java.io.*;

class Main {
    public static void main(String[] args) {
        FileReader file = new FileReader("C:\\test\\a.txt");
        BufferedReader fileInput = new BufferedReader(file);

        // Print first 3 lines of file "C:\test\a.txt"
        for (int counter = 0; counter < 3; counter++)
            System.out.println(fileInput.readLine());

        fileInput.close();
    }
}


Correct version:

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("C:\\test\\a.txt");
        BufferedReader fileInput = new BufferedReader(file);

        // Print first 3 lines of file "C:\test\a.txt"
        for (int counter = 0; counter < 3; counter++)
            System.out.println(fileInput.readLine());

        fileInput.close();
    }
}


2) Unchecked are the exceptions that are not checked at compiled time.
In C++, all exceptions are unchecked, so it is not forced by the compiler to either handle or specify the exception.
It is up to the programmers to be civilized, and specify or catch the exceptions.
In Java exceptions under Error and RuntimeException classes are unchecked exceptions,
everything else under throwable is checked.


Consider the following Java program. It compiles fine, but it throws ArithmeticException when run. The compiler allows it to compile, because ArithmeticException is an unchecked exception.

class Main {
   public static void main(String args[]) {
      int x = 0;
      int y = 10;
      int z = y/x;
  }
}

 */
public class HandleException {
}
