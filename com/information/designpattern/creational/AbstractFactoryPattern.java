package com.information.designpattern.creational;

/**
 *  Factory of factory
 *  When you want to provide a library of objects that does not show implementations and only reveals interfaces.
 *  When the system needs to be configured with one of a multiple family of objects.
 *
 *  Abstract Factory Pattern isolates the client code from concrete (implementation) classes.
 *  It eases the exchanging of object families.
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {

        AbstractFactory bankFactory = FactoryCreator.getFactory("Bank"); // based on the input it will return
                                                                                // factory
        Bank b = bankFactory.getBank("HDFC");
    }
}

/*
*    BankFactory and LoanFactory implements AbstractFactory (getBank and getLoan methods)
* */
class FactoryCreator {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Bank")){
            return new BankFactory();
        } else if(choice.equalsIgnoreCase("Loan")){
            return new LoanFactory();
        }
        return null;
    }
}

class BankFactory implements AbstractFactory {

    @Override
    public Bank getBank(String bank){
        if(bank == null){
            return null;
        }
        if(bank.equalsIgnoreCase("HDFC")){
            return new HDFC();
        } else if(bank.equalsIgnoreCase("SBI")){
            return new SBI();
        }
        return null;
    }

    @Override
    public Loan getLoan(String loan) { return null; }
}

class LoanFactory implements AbstractFactory {

    @Override
    public Bank getBank(String bank){
        return null;
    }

    @Override
    public Loan getLoan(String loan){
        if(loan == null){
            return null;
        }
        if(loan.equalsIgnoreCase("Home")){
            return new HomeLoan();
        }
        return null;
    }
}

interface AbstractFactory{
     Bank getBank(String bank);
     Loan getLoan(String loan);
}
interface Bank { String getBankName(); }
interface Loan { String getLoanName(); }

class HDFC implements Bank{
    private final String B_NAME;

    public HDFC(){
        B_NAME="HDFC BANK";
    }

    @Override
    public String getBankName() {
        return B_NAME;
    }
}

class SBI implements Bank{
    private final String B_NAME;

    public SBI(){
        B_NAME="SBI BANK";
    }

    @Override
    public String getBankName() {
        return B_NAME;
    }
}

class HomeLoan implements Loan{
    private final String L_NAME;

    public HomeLoan(){
        L_NAME="Home Loan";
    }

    @Override
    public String getLoanName() {
        return L_NAME;
    }
}

class BusinessLoan implements Loan{
    private final String L_NAME;

    public BusinessLoan(){
        L_NAME="Business Loan";
    }

    @Override
    public String getLoanName() {
        return L_NAME;
    }
}

