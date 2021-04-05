package com.taw.common.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class $ {

    public int get_index_of(String []array, String word){
        List<String> str = Arrays.asList(array);
        int indexOf = str.indexOf(word);
        return indexOf;
    }

    public String random_full_name(){
        String []names = {"Brenda Levine", "Rihanna Flowers", "Amiya Beard", "Andy Holden", "Daniel Hurst", "Mathew Maxwell", "Clarissa Guerrero", "Aylin Lam", "Dane Hunter", "Samson Reynolds", "Julianna Fisher", "Mariana Kelly", "Miracle Farmer", "Esperanza Shaw", "Eva Daugherty", "Reese Hancock", "Alexander Bonilla", "Angel Valentine", "Laila Morris", "Clark Randolph", "Marlon Stein", "Trevon Harris", "Tanner Ashley", "Kristian Mays", "Collin Mcgrath", "Yesenia Hanna", "Melody Delacruz", "Braylen Brewer", "Giovanna Watson", "Malakai Mitchell", "Ryland Clayton", "Alexzander Castillo", "Bailey Vance", "Charlie Kirby", "Rowan Pugh", "Emanuel Thomas", "London Estrada", "Lizbeth Hooper", "Julianne Stark", "Kiera Greene", "Marcos Ibarra", "Robert Mendez", "Pranav Duke", "Bryanna Dorsey", "Erin Anderson", "Andrew Velazquez", "Oliver Estrada", "Layla Hopkins", "Carsen Cohen", "Sadie Fuentes", "Madeline Ramos", "Diamond Zamora", "Conrad Zimmerman", "Desmond Kirby", "Grace Morrison", "Nayeli Wilcox", "Adelaide Hart", "Serenity Sutton", "Ivan Michael", "Grant Vang", "Londyn Schroeder", "Ryan Edwards", "Jimena Rivera", "Deandre Pennington", "Remington Kemp", "Jude Hicks", "Abel Hanson", "Brenton Anthony", "Madalyn Mcpherson", "Janelle Fitzgerald", "Tate Riddle", "Naima Raymond", "Boston Estes", "Alexander Sheppard", "Cecilia Gould", "Alexandra Mccarty", "Donald Boone", "Shannon Ramirez", "Carly Little", "Ronin Jordan", "Marques Blair", "Braxton Conrad", "Darien Kelley", "Oswaldo Livingston", "Caylee Parrish", "Johnathon Tucker", "Annabella Cox", "Gabriella Bradshaw", "Markus Dennis", "Estrella Hines", "Marianna Wilson", "Callie Patterson", "Weston Vance", "Frank Kaufman", "Ava Weber", "Parker Wade", "Mckinley Moore", "Dallas Coleman", "Brennan Soto", "Teresa Lutz"};
        Random r = new Random();
        return names[r.nextInt(100)];
    }

    public int random_adult_age(){
        Random r = new Random();
        return r.nextInt(65)+18;
    }

    public int random_minor_age(){
        Random r = new Random();
        return r.nextInt(18);
    }
}
