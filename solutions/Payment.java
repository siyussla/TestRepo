import java.util.*;

class Payment {

    public static void main(String[] args) {

        PriorityQueue<Time> tran = new PriorityQueue<>();

        Long start = 0L;
        Long totalElapsed = 0L;
        Long timespent = 0L;
        Long elapsed;
        int rank = 0;
        boolean condition = true;

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            try {

                String data = in.nextLine();
                String[] arr = data.split(" ");

                if (data.equals("EXIT")) {
                    break;
                }
                if (data.equals("REBOOT")) {
                    tran.clear();
                }
                if (arr.length == 3) {    //for 3 element format

                    //for start of each 1000 milis
                    while (condition) {
                        start = Long.valueOf(arr[0]);
                        double tempstart = Math.round(start / 1000d) * 1000d;
                        start = (long) tempstart;   //to round off the long value
                        condition = false;
                    }

                    Long timenow = Long.parseLong(arr[0]);
                    elapsed = timenow - start;

                    //PriorityQueue according to count time
                    Long temptime = 1000L - (timenow - start);
                    if(arr[2].equalsIgnoreCase("BRONZE")) {
                        timespent = totalElapsed  -  temptime;
                        rank = 0;
                    }else if(arr[2].equalsIgnoreCase("SILVER")){
                        timespent = totalElapsed  -  temptime - 1000L;
                        rank = 1;
                    }else if(arr[2].equalsIgnoreCase("GOLD")){
                        timespent = totalElapsed  -  temptime - 2000L;
                        rank = 2;
                    }else if(arr[2].equalsIgnoreCase("PLATINUM")){
                        timespent = totalElapsed  -  temptime - 3000L;
                        rank = 3;
                    }
                    tran.add(new Time(timespent,rank,arr[1]));

                    if (elapsed >= 1000) {
                        condition = true;
                        totalElapsed += 1000L;

                        //only 100 transaction got cleared
                        for (int j = 0; j < 100; j++) {
                            System.out.print( tran.poll() + " ");
                        }

                    }
                }
            } catch(Exception e){
                return ;
            }
        }
    }
}

class Time implements Comparable<Time>{
    private final Long timespent;
    private final Integer rank;
    private final String txn_id;

    public Time(Long timespent, int rank, String txn_id) {
        this.timespent = timespent;
        this.rank = rank;
        this.txn_id = txn_id;
    }


    @Override
    public String toString() {
        return (this.txn_id);
    }


    @Override
    public int compareTo(Time o) {
        if(this.timespent.compareTo(o.timespent)==0) {
            return this.rank.compareTo(o.rank);
        }
        return this.timespent.compareTo(o.timespent);
    }

}
