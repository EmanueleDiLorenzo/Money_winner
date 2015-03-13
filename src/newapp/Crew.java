
package newapp;

/**
 *
 * @author babu
 */
public class Crew {

    float goals_difference, won, drawn;             // variable 
    String name;
    
    Crew(String name, float goals_difference, float won , float drawn) {                          //costructor
        this.name = name;
        this.goals_difference = goals_difference;
        this.drawn = drawn;
        this.won = won;
    }
    
}
