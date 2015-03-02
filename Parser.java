/**
  *
  * Java parser for cpsc 449
  *
  * @version 0.0 from 2/23/15
  * @author Group 5-04
  */
  
import java.io.*;
import java.util.*;
import java.text.*;

public class Parser {
    // start attributes
    // end attribute
    /*The entry point for the program.
    *This method will read the command line arguments and decide which mode if any will be used
    
    *   --TODO--
    *   accept qualifiers based on - that can be combined such as "-hv" which combined -h and -v
    *   accept qualifiers based on -- that are case insensitive such as "--help" and "--HELP"
    *   run help mode if -h, -? or --help are inputs
    *   throw a fatal error if any other arguments appear with a help qualifier
    *   run help mode WITHOUT the last paragraph (just the synopsis) if no qualifiers or arguments are present
    *   run normal mode if a required first argument and an optional second argument appear
    */
    // start method
    public static void main(String[] args) {
        boolean verbose = true; //placeholder setting, needs to be true if and only if specified in the command line argument
        parser(verbose);
        if (args.length > 0)
        {
        	String inputFromUser = args[0];
        	if (inputFromUser.equals ("Commands"))
        	{
        		System.out.println("q           : Quit the program.");
        		System.out.println("v           : Toggle verbose mode (stack traces)."); 
        		System.out.println(" \n f           : List all known functions.");
        		System.out.println("?           : Print this helpful text.");
        		System.out.println("<expression>: Evaluate the expression.");
        		System.out.println("Expressions can be integers, floats, strings (surrounded in double quotes) or function");
        		System.out.println("calls of the form '(identifier {expression}*)'.");
        	}
        	else if (inputFromUser.equals ("-h") || inputFromUser.equals ("--help") || inputFromUser.equals ("-?"));
        	{
        		System.out.println("Synopsis:");
        		System.out.println("methods");
        		System.out.println("methods { -h | -? | --help }+");
        		System.out.println("methods {-v --verbose}* <jar-file> [<class-name>]");
        		System.out.println("Arguments:");
        		System.out.println("<jar-file>:   The .jar file that contains the class to load (see next line).");
        		System.out.println("<class-name>: The fully qualified class name containing public static command methods to call. [Default=Commands]");
        		System.out.println("Qualifiers:");
        		System.out.println("-v --verbose: Print out detailed errors, warning, and tracking.");
        		System.out.println("-h -? --help: Print out a detailed help message.");
        		System.out.println("Single-char qualifiers may be grouped; long qualifiers may be truncated to unique prefixes and are not case sensitive.");
        		System.out.println("This program interprets commands of the format '(<method> {arg}*)' on the command line, finds corresponding");
        		System.out.println("methods in <class-name>, and executes them, printing the result to sysout.");
        	}
        		
        	
        }
        else 
        {
        	System.out.println("enter arguments");
        }
    } // end of main
    
    /*The main looping function
    *This method will print the help text before beginning the loop where it interprets the expressions
    *   --TODO--
    *   prompt the user with a ">"
    *   interpret the line as a meta command or as an expression
    *   print the result
    */
    public static void parser(boolean verbose) {
        //ParseTree tree = new ParseTree();    
        while (true) { 
            System.out.print(">");
            System.out.print(inputGet()+System.lineSeparator());
        } // end of while
    } // end of parser
    
    /*Helper function to retrieve user input
    *This method may prove to be redundant
    *This method may be inefficient in creating a new scanner for each call
    */
    public static String inputGet() {
            return new Scanner(System.in).nextLine();
    }
    // end methods

} // end of class Parser
