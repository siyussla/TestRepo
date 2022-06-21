import java.util.*;

class Payment {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.print("INPUT : ");
        String newtrans = in.nextLine();
        String[] arr;
        String time = "", newtime = "";
        int counter = 0;

        PriorityQueue<Tier> TierList = new PriorityQueue<>(Collections.reverseOrder());

        while(!newtrans.equalsIgnoreCase("exit")) {
            if(counter>0){
                System.out.print("INPUT : ");
                newtrans = in.nextLine();
                if(newtrans.equalsIgnoreCase("exit")){
                    break;
                }
                arr = newtrans.split(" ");
                time = newtime;
                newtime = arr[0];
                TierList.add(new Tier(arr[0], arr[1], arr[2]));
            }
            if(counter == 0){
                arr = newtrans.split(" ");
                time = arr[0];
                TierList.add(new Tier(arr[0], arr[1], arr[2]));
                if(newtrans.equalsIgnoreCase("exit")){
                    break;
                }
            }

            if(counter>0){
                if(time.charAt(time.length()-4) != newtime.charAt(newtime.length()-4)){
                    System.out.println();
                    System.out.print("OUTPUT : ");
                    for(int i=0; i<100; i++){
                        if(!TierList.isEmpty()){
                            System.out.print(TierList.poll());
                        }
                        else{
                            break;
                        }
                    }
                    TierList.clear();
                    System.out.println();
                    System.out.println();
                }
            }

            if(counter == 0) {
                System.out.print("INPUT : ");
                newtrans = in.nextLine();
                if (newtrans.equalsIgnoreCase("exit")) {
                    break;
                }
                arr = newtrans.split(" ");
                newtime = arr[0];
                TierList.add(new Tier(arr[0], arr[1], arr[2]));
            }
            if(counter>0) {
                System.out.print("INPUT : ");
                newtrans = in.nextLine();
                if (newtrans.equalsIgnoreCase("exit")) {
                    break;
                }
                arr = newtrans.split(" ");
                time = newtime;
                newtime = arr[0];
                TierList.add(new Tier(arr[0], arr[1], arr[2]));
            }

            if(time.charAt(time.length()-4) != newtime.charAt(newtime.length()-4)){
                System.out.println();
                System.out.print("OUTPUT : ");
                for(int i=0; i<100; i++){
                    if(!TierList.isEmpty()){
                        System.out.print(TierList.poll());
                    }
                    else{
                        break;
                    }
                }
                TierList.clear();
                System.out.println();
                System.out.println();
            }

            if(newtrans.equalsIgnoreCase("reboot")){
                TierList.clear();
                break;
            }
            counter++;
        }
    }

    public static class Tier implements Comparable<Tier>{

        private String tier;
        private final String transaction, time;

        public Tier(String time, String transaction, String tier){
            this.time = time;
            this.transaction = transaction;
            this.tier = tier;
        }

        public void setTier(String tier) {
            this.tier = tier;
        }

        public String getTier() {
            return tier;
        }

        public String getTime() {
            return time;
        }

        public String getTransaction() {
            return transaction;
        }


        @Override
        public int compareTo(Tier o) {
            if(tier.equalsIgnoreCase("platinum")){
                tier = String.valueOf(4);
            }
            else if(tier.equalsIgnoreCase("gold")){
                tier = String.valueOf(3);
            }
            else if(tier.equalsIgnoreCase("silver")){
                tier = String.valueOf(2);
            }
            else if(tier.equalsIgnoreCase("bronze")){
                tier = String.valueOf(1);
            }
            if(o.getTier().equalsIgnoreCase("platinum")){
                o.setTier(String.valueOf(4));
            }
            else if(o.getTier().equalsIgnoreCase("gold")){
                o.setTier(String.valueOf(3));
            }
            else if(o.getTier().equalsIgnoreCase("silver")){
                o.setTier(String.valueOf(2));
            }
            else if(o.getTier().equalsIgnoreCase("bronze")){
                o.setTier(String.valueOf(1));
            }
            return this.tier.compareTo(o.getTier());
        }


        @Override
        public String toString() {
            return this.getTransaction() +" ";
        }
    }

}
