package fizzBuzz;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class FizzBuzz implements Serializable {
    int counter = 0;
    ArrayList<Integer> fizzList = new ArrayList<>();
    ArrayList<Integer> buzzList = new ArrayList<>();
    ArrayList<Integer> fizzBuzzList = new ArrayList<>();
    ArrayList<Integer> noneList = new ArrayList<>();
    public FizzBuzz() {
        for(int i = 0; i < 1000; i++){
            counter++;
            if(counter%3==0 && counter%5==0){
                System.out.println("FizzBuzz");
                fizzBuzzList.add(counter);
            } else if (counter%3==0) {
                System.out.println("Fizz");
                fizzList.add(counter);
            } else if (counter%5==0) {
                System.out.println("Buzz");
                buzzList.add(counter);
            } else{
                System.out.println(counter);
                noneList.add(counter);
            }
        }
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public ArrayList<Integer> getFizzList() {
        return fizzList;
    }

    public void setFizzList(ArrayList<Integer> fizzList) {
        this.fizzList = fizzList;
    }

    public ArrayList<Integer> getBuzzList() {
        return buzzList;
    }

    public void setBuzzList(ArrayList<Integer> buzzList) {
        this.buzzList = buzzList;
    }

    public ArrayList<Integer> getFizzBuzzList() {
        return fizzBuzzList;
    }

    public void setFizzBuzzList(ArrayList<Integer> fizzBuzzList) {
        this.fizzBuzzList = fizzBuzzList;
    }

    public ArrayList<Integer> getNoneList() {
        return noneList;
    }

    public void setNoneList(ArrayList<Integer> noneList) {
        this.noneList = noneList;
    }

    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fizzBuzz.obj"))){
            FizzBuzz fb = new FizzBuzz();
            oos.writeObject(fb);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
