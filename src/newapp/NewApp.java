package newapp;

import java.io.*;
import java.util.HashMap;
import java.util.Set;
/*    
 System.out.println("choise team");
 String answer = "";
 answer = myKeyboard.readLine();
 for (int g = 0; g < 25; g++) {
 if(answer.equalsIgnoreCase(names[g])){
 System.out.println(names[g]);
 System.out.println(lost[g]);
 System.out.println(played[g]);
 System.out.println(goals_difference[g]);
 System.out.println(goals_for[g]);
 System.out.println(won[g]);
 System.out.println(goals_against[g]);
 System.out.println(drawn[g]);
 System.out.println(positions[g]);
 System.out.println(points[g]);
 }
 } 
 System.out.println(parts[0]);    print the first word :D

 public static void main(String[] args) throws FileNotFoundException {
 //String team;
 int team1 = 1;
 int team2 = 1;
 float result = 0;

 //scores.csv file to read 
 try {
 parseFile();

 InputStreamReader myInput = new InputStreamReader(System.in);
 BufferedReader myKeyboard = new BufferedReader(myInput);

 String choise = "";
 String choise2 = "";
 System.out.println("first team");
 choise = myKeyboard.readLine();
 while (!names[team1].equalsIgnoreCase(choise) && team1 < 25) {

 team1++;
 }
 System.out.println("second team");
 do {
 if (choise2.equalsIgnoreCase(choise)) {
 System.out.println("choise another team, please.");
 }
 choise2 = myKeyboard.readLine();
 } while (choise.equalsIgnoreCase(choise2));                                             "This is the method for lunch the app with the java console"               
 while (!names[team2].equalsIgnoreCase(choise2) && team2 < 25) {

 team2++;
 }

 String risultato = oracle(team1, team2);
 System.out.println(risultato);

 } catch (Exception e) {
 System.out.println("The choised team doesn't exist");
 e.printStackTrace();
 }

 }                                                                                          
 */

public class NewApp {

    private String name;
    //private float lost;
    //private float played;
    private float goals_difference;
    //private float goals_for;
    private float won;
    // private float goals_against;
    private float drawn;
    //private float positions;
    //private float points;
    private HashMap<String, Crew> teams = new HashMap<String, Crew>();

    public Set<String> parseFile() throws Exception {
        FileReader reader;
        reader = new FileReader("scores.csv");
        BufferedReader br;
        br = new BufferedReader(reader);

        String scores;
        int i = 0;

        while ((scores = br.readLine()) != null) {

            if (i >= 1) {

                String[] parts = scores.split(",");
                name = parts[0];
                //lost = Float.parseFloat(parts[1]);
                //played = Float.parseFloat(parts[2]);
                parts[3] = parts[3].replace("−", "-");
                goals_difference = Float.parseFloat(parts[3]);
                //goals_for = Float.parseFloat(parts[4]);
                won = Float.parseFloat(parts[5]);
                // goals_against = Float.parseFloat(parts[6]);
                drawn = Float.parseFloat(parts[7]);
                // positions = Float.parseFloat(parts[8]);
                // points = Float.parseFloat(parts[9]);

                Crew sq = new Crew(name, goals_difference, drawn, won);
                teams.put(name, sq);
            }

            i++;
        }

        return teams.keySet();
    }

    public String oracle(String name1, String name2) {
        Crew sq1, sq2;
        sq1 = teams.get(name1);
        sq2 = teams.get(name2);

        String choise_team;

        if (sq2 == sq1) {
            choise_team = "choise another team, please.";
            return choise_team;
        }
        int value_gol = 20;
        float result_parameter = (float) 4.5;
        float result_parameter2 = (float) -4.5;
        float first_calculation = (sq1.won - sq2.won);
        float second_calculation = (sq1.drawn - sq2.drawn);
        float third_calculation = (sq1.goals_difference / value_gol - sq2.goals_difference / value_gol);

        float result = first_calculation + second_calculation + third_calculation;    // <----- my algorithm

        //System.out.println("the result is" + result);   <----    print result
        if (result > result_parameter) {
            choise_team = "it's probabily " + sq1.name + " will win :)";
        } else if (result < result_parameter2) {
            choise_team = "it's probabily " + sq2.name + " will win :)";
        } else {
            choise_team = "it will probabily be a drawn match :)";
        }

        return choise_team;
    }

}
