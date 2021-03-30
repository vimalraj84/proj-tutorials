package com.bilqu.structural.filter;

import com.bilqu.bo.acct.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Filter pattern or Criteria pattern
// enables developers to filter a set of objects,
// using different criteria, chaining them in a decoupled way through logical operations.
public class TestFilterPattern {

    public static void main(String[] args) {

        Criteria saveCriteria = new SavingAcctCriteria();
        Criteria cdCriteria = new CdAcctCriteria();

        List<Criteria> test1= new ArrayList<>();
        test1.add(cdCriteria);
        List<Criteria> test2= new ArrayList<>();
        test2.add(saveCriteria);

        List<Account> accounts = new ArrayList<>();
        accounts.add(new CdAccount());
        accounts.add(new CdAccount());
        accounts.add(new CdAccount());
        accounts.add(new IraAccount());
        accounts.add(new IraAccount());
        accounts.add(new SavingsAccount());
        accounts.add(new SavingsAccount());
        accounts.add(new SavingsAccount());

        Criteria andCriteria = new AndCriteria(test1);
        Criteria orCriteria = new OrCriteria(test2);
    }

    public interface Criteria{
        List<Account> filter(List<Account> accounts);
    }

    public static class SavingAcctCriteria implements Criteria{

        @Override
        public List<Account> filter(List<Account> accounts) {

            return accounts.stream().filter(acct ->  acct instanceof SavingsAccount).collect(Collectors.toList());
        }
    }

    public static class CdAcctCriteria implements Criteria{

        @Override
        public List<Account> filter(List<Account> accounts) {

            return accounts.stream().filter(acct ->  acct instanceof CdAccount).collect(Collectors.toList());
        }
    }

    public static class AndCriteria implements Criteria{

        private List<Criteria> criteriaList;

        AndCriteria(List<Criteria> criteriaList){
            this.criteriaList = criteriaList;
        }

        @Override
        public List<Account> filter(List<Account> accounts) {
            return null;
        }
    }

    public static class OrCriteria implements Criteria{
        private List<Criteria> criteriaList;

        OrCriteria(List<Criteria> criteriaList){
            this.criteriaList = criteriaList;
        }

        @Override
        public List<Account> filter(List<Account> accounts) {
            for(Criteria c:criteriaList){
            }
            return null;
        }

    }
}

