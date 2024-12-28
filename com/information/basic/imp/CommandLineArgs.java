package com.information.basic.imp;

/* WE ARE LEARNING JAVA SE WHERE REQUEST ARE COMMING FROM COMMAND LINE ARGUMENT BUT IN WEB APPLICATION (i.e. JAVA EE )
REQUEST IS COMING FROM BROWSER OR WEB REQUEST*/
public class CommandLineArgs {

    /* We can interact with the system with 2 method */
    //1. GUI method : what we always do, selecting files etc. (generally instructions to OS are given by mouse cursor)
    //2. CommandLine method: we give instructions by command. To write command we need terminal(interface) provided
    //                       by system.

    /* Difference Between Terminal Shell and console */
    // Terminal: Interface where we write command (set of instructions) to perform operation
    // Shell Script: A file(.sh) with commands written in a shell scripting language , designed to be executed by the shell.
    // To run (execute) the shell script, we use the terminal.
    // Shell: The interpreter that reads the shell script, processes the commands,
    //        and communicates with the OS to perform the actions. It serves as a bridge between the user
    //        and the operating system.
    // -- To know what path of shell we are using
    // (linux and macOS) [default bash] command : echo $SHELL,
    // (Windows) [default cmd or powershell] command :
    // for Android : Use similar to bash

    /* Types of Shell */
    // 1. Bash (Bourne Again Shell) Bash is the default shell on many Linux distributions and macOS.   [.sh file]
    // known for its robust scripting capabilities and user-friendly features like command history and tab completion.
    // Others Shell : Zsh Shell or Z Shell [.Zsh], Fish, Ksh etc.
    // Different Shell has their own script but mostly common

    /*
         User -> Terminal -> Shell -> OS
                                    ↪ Execute Commands
                                    ↩ Results
           <- Terminal <- Shell <- OS
    */

    /* Console */
    // Earlier time there is no mouse and GUI method, that time console is there to interact with computer
    // Today also we can use console, there is particular keyword shortcut keys need to execute to enable console
    // Remember after that u cant use GUI, there is also some shortcut key by which i can come back to GUI

    /* Command line arguments
       Running Java Without intellij, using Bash shell terminal to communicate OS Steps :
       1. cd project src file
       2. javac com/example/ClassName.java     --> java compiler generate .class file(contains bytecode platform independent)
                                                   from .java file (contains source code or java code)
       3. java com.example.ClassName  <you can pass arguments here>  ---> From here JVM takes control (executes bytecode
                                                                          to machine level code)
       NOTE: Here we understood Java Compiler is not part of JVM
       JDK : Java Development Tools (Contains Everything
     */
    public static void main(String[] args){
        for (String arg : args) {
            System.out.println(" parameter with index ${i} : " + arg);
        }
    }
}

/*
*     JDK : It is a software development kit, that includes tools and libraries necessary for developing and
*           running Java applications. It contains everything.
*
*     JDK Components:
*     Java Compiler (javac): Compiles Java source files into bytecode.
*     Java Runtime Environment (JRE): Provides the libraries, Java Virtual Machine (JVM), and other components
*                                     to run Java applications. A subset of the JDK, it includes only the JVM and
*                                     libraries needed to run Java applications. It is used by end-users who want
*                                     to run Java programs but not develop them.
*     Development Tools: Includes tools like the java launcher, javadoc for generating documentation,
*                        jar for packaging, and more.
*
* */


/*  How Intellij works internally */