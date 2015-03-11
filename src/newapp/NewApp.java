/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newapp;

import java.io.*;
/*    System.out.println("scegli squadra");
 String scelta = "";
 scelta = myKeyboard.readLine();
 for (int g = 0; g < 25; g++) {
 if(scelta.equalsIgnoreCase(names[g])){
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
 System.out.println("choise another second team, please.");
 }
 choise2 = myKeyboard.readLine();
 } while (choise.equalsIgnoreCase(choise2));
 while (!names[team2].equalsIgnoreCase(choise2) && team2 < 25) {

 team2++;
 }

 String risultato = oracle(team1, team2);
 System.out.println(risultato);

 } catch (Exception e) {
 System.out.println("The choised team does not exist");
 e.printStackTrace();
 }

 }
 */

public class NewApp {

    private String names[] = new String[25];
    private float lost[] = new float[25];
    private float played[] = new float[25];
    private float goals_difference[] = new float[25];
    private float goals_for[] = new float[25];
    private float won[] = new float[25];
    private float goals_against[] = new float[25];
    private float drawn[] = new float[25];
    private float positions[] = new float[25];
    private float points[] = new float[25];

    public void parseFile() throws Exception {
        FileReader reader;
        reader = new FileReader("scores.csv");
        BufferedReader b;
        b = new BufferedReader(reader);

        String scores;
        int i = 0;

        while ((scores = b.readLine()) != null) {

            if (i >= 1) {

                String[] parts = scores.split(",");
                names[i] = parts[0];
                lost[i] = Float.parseFloat(parts[1]);
                played[i] = Float.parseFloat(parts[2]);
                parts[3] = parts[3].replace("−", "-");
                goals_difference[i] = Float.parseFloat(parts[3]);
                goals_for[i] = Float.parseFloat(parts[4]);
                won[i] = Float.parseFloat(parts[5]);
                goals_against[i] = Float.parseFloat(parts[6]);
                drawn[i] = Float.parseFloat(parts[7]);
                positions[i] = Float.parseFloat(parts[8]);
                points[i] = Float.parseFloat(parts[9]);
            }

            i++;
        }
    }

    public String oracle(int team1, int team2) {
        String choise_team;

        if (names[team2].equalsIgnoreCase(names[team1])) {
            choise_team = "choise another team, please.";
            return choise_team;
        }

        float result = (won[team1] - won[team2]) + (drawn[team1] - drawn[team2]) + (goals_difference[team1] / 10 - goals_difference[team2] / 10);

        //System.out.println("the result is" + result);     the calcul's result
        if (result > 6) {
            choise_team = "it's probabily " + names[team1] + " will win :)";
        } else if (result < -6) {
            choise_team = "it's probabily " + names[team2] + " will win :)";
        } else {
            choise_team = "it will probabily be a drawn match :)";
        }

        return choise_team;
    }

}
