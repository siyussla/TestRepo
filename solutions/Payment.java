package Payment;

import java.io.*;
import java.util.*;

public class Payment2 {

    static Queue<String> Platinum = new Queue<>();
    static Queue<String> Gold = new Queue<>();
    static Queue<String> Silver = new Queue<>();
    static Queue<String> Bronze = new Queue<>();
    static ArrayList<Character> check = new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc=new Scanner(new BufferedInputStream(System.in));
        int i=0;

        String END = "END";
        String CLEAR = "CLEAR";


        while(true){
            String input=sc.nextLine();

            if(input.equals(END)){
                break;
            }

            else if(input.equals(CLEAR)){
                print(i);
            }

            else{
                String[] words=input.split(" ");
                check.add(words[0].charAt(9));
                if(i==0){



                    if(words[2].equals("PLATINUM")){
                        Platinum.enqueue(words[1]);
                    }
                    else if(words[2].equals("GOLD")){
                        Gold.enqueue(words[1]);
                    }
                    else if(words[2].equals("SILVER")){
                        Silver.enqueue(words[1]);
                    }
                    else if(words[2].equals("BRONZE")){
                        Bronze.enqueue(words[1]);
                    }

                }

                else{
                    if(check.get(i-1).equals(check.get(i))){

                        if(words[2].equals("PLATINUM")){
                            Platinum.enqueue(words[1]);
                        }
                        else if(words[2].equals("GOLD")){
                            Gold.enqueue(words[1]);
                        }
                        else if(words[2].equals("SILVER")){
                            Silver.enqueue(words[1]);
                        }
                        else if(words[2].equals("BRONZE")){
                            Bronze.enqueue(words[1]);
                        }
                    }

                    else{

                        if(words[2].equals("PLATINUM")){
                            Platinum.enqueue(words[1]);
                        }
                        else if(words[2].equals("GOLD")){
                            Gold.enqueue(words[1]);
                        }
                        else if(words[2].equals("SILVER")){
                            Silver.enqueue(words[1]);
                        }
                        else if(words[2].equals("BRONZE")){
                            Bronze.enqueue(words[1]);
                        }
                        i++;
                        print(i);

                        System.exit(0);
                    }

                }
                i++;
            }
        }

    }

    public static void print(int i){

        for(int count=0;count<i;count++){

            if(!Platinum.isEmpty()){
               Platinum.dequeue();
            }
            if(!Gold.isEmpty()){

                Gold.dequeue();
            }
            if(!Silver.isEmpty()){

                Silver.dequeue();
            }
            if(!Bronze.isEmpty()){

                Bronze.dequeue();
            }
        }
    }
    public static class Queue<E> {

        private java.util.LinkedList<E> list = new java.util.LinkedList<>();

        public Queue() {
        }

        public void enqueue(E e) {

            list.addLast(e);

        }

        public E dequeue() {

            return list.removeFirst();

        }
        
        public E first(){

            return list.peek();

        }

        public boolean isEmpty(){

            return list.isEmpty();

        }

        public int getSize() {

            return list.size();

        }

        public String toString(){

            return "Queue: " + list.toString();

        }

    }

}
