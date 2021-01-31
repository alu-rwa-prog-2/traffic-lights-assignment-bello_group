package Question1;
/* 
Traffic Lights Assignment: I have tried the visual ine but I could not follow the rules for the timing and 
also the ligths. You can check it in the TrafficLights folder

Author: Bello Moussa Amadou
Email: b.moussaama@alustudent.com
*/

import java.util.*;

public class Traffic_Simulator {
    public static void main(String[] args) {
        // Our collection for the cars
        ArrayList<String> Cars = new ArrayList<String>();

        // cars in our collection are equal to the cars in the Road
        ArrayList<String> Road = new ArrayList<String>();

        // this array will help us keep track of cars quiting the Road
        ArrayList<String> out_cars = new ArrayList<String>();

        // Usage of a for loop to generate cars up to 100
        for (int i = 1; Cars.size() < 100; i++) {
            String add_int_str = Integer.toString(i);
            String name = "vehicle" + add_int_str;
            Cars.add(name);

        }

        // Random Object
        Random random = new Random();

        // variable to keep track of added cars in the road
        Integer in = 0;

        // Adding cars to the Road in the queue
        System.out.println("Let's begin");
        boolean cars_coming = true;
        while (cars_coming) {
            String c = Cars.get(random.nextInt(Cars.size()));

            // check if a car has already been added to the Road
            if (!Road.contains(c)) {
                Road.add(c);
                in++;
            } else if (in == 20){
                System.out.println("20 cars added to the road");
                in = 0;
                continue;
            }

            if (Road.size() == 100) {
                Cars.clear();
                break;
            }

        }

        /*
         * We will use while loops for the Traffic Lights Starting with RED -> GREEN -> YELLOW.
         * Each light has its own timing then it will alterne to the next
         */
        boolean red_ligth = true;
        while (red_ligth) {
            while (true) {
                Timer red = new Timer();
                int start_red = 0;
                int time_red = 20000;
                red.schedule(new TimerTask() {
                    int counter = 0;

                    public void run() {

                        System.out.println("********\nRed = Stop\n*********");
                        System.out.println("20s to go\n");
                        counter++;

                        if (counter == 1) {
                            red.cancel();
                        }
                    }
                }, start_red, time_red);

                try {
                    Thread.sleep(20000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                break;
            }
            if (Road.size() == 0) {
                break;
            }

            // Traffic Light GREEN
            boolean green_ligth = true;
            while (green_ligth) {
                Timer green = new Timer();
                int start_green = 0;
                int time_green = 1000; // moving cars per seconds
                green.schedule(new TimerTask() {
                    int counter = 0;

                    public void run() {
                        System.out.println("Green Light = Go");
                        if (Road.size() != 0) {
                            System.out.println(Road.get(Road.size() - 1) + " depart");
                            out_cars.add(Road.get(Road.size() - 1));
                            System.out.println();
                            Road.remove(Road.size() - 1);
                            counter++;

                        }
                        // We will move only 30 cars since each second each car will be gone
                        // and the red light has 30 seconds
                        if (counter >= 30) {
                            green.cancel();

                        }

                    }
                }, start_green, time_green);

                // We will use Thread.sleep to keep track of the time
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                break;
            }
            if (Road.size() == 0) {
                break;
            }

            // Traffic Light Yellow
            boolean yellow_ligth = true;
            while (yellow_ligth) {
                Timer yellow = new Timer();
                int start_yellow = 0;
                int time_yellow = 2000; // = 2secs
                yellow.schedule(new TimerTask() {
                    int counter = 0;

                    public void run() {
                        System.out.println("Yellow -> Slow Down");
                        if (Road.size() != 0) {
                            out_cars.add(Road.get(Road.size() - 1));
                            System.out.println(Road.get(Road.size() - 1) + " gone\n");
                            Road.remove(Road.size() - 1); // removing the cars that are gone
                            counter++;
                        }
                        if (counter >= 5) {
                            yellow.cancel();
                        }
                    }
                }, start_yellow, time_yellow);

                // We will use Thread.sleep to keep track of the time
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                break;
            }
            // We will end the program if all the cars are gone!!
            if (Road.size() == 0) {
                break;
            }
        }

    }

}
