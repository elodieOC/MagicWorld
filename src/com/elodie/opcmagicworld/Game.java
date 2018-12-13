package com.elodie.opcmagicworld;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void start() {
        System.out.println("Bienvenu(e) dans Magic World!!!!");
        System.out.println("Création du personnage Joueur 1");
        Player player1 = enterPlayer();
        player1.setpName("Joueur 1");
        System.out.println(player1.description());
        System.out.println("Création du personnage Joueur 2");
        Player player2 = enterPlayer();
        player2.setpName("Joueur 2");
        System.out.println(player2.description());

        do {
            player1.attack(player2);
            if(player2.getpHP() > 0) {
                player2.attack(player1);
            }
        }while((player1.getpHP()>0)&&(player2.getpHP()>0));

    }
    public static Player enterPlayer() {
        int uClass = chooseClass();
        if (uClass == 1) {
            Warrior player = new Warrior("", 0, 0, 0, 0, 0);
            setStats(player);
            return player;
        } else if (uClass == 2) {
            Scout player = new Scout("", 0, 0, 0, 0, 0);
            setStats(player);
            return player;
        } else if (uClass == 3) {
            Magician player = new Magician("", 0, 0, 0, 0, 0);
            setStats(player);
            return player;
        }
        return enterPlayer();
    }
    public static void setStats(Player player){
        player.setpLevel(levelSetUp());
        player.setpHP(player.getpLevel()*5);
        player.setpStrength(strengthSetUp(player));
        player.setpAgility(agilitySetUp(player));
        player.setpIntel(intelSetUp(player));
    }
    public static int levelSetUp(){
        int level = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("niveau: ");
                level = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Saisie erronée, votre choix n'est pas un nombre");
                sc.next();
            }finally {
                if (level < 1 || level > 100) {
                    System.out.println("Votre choix n'est pas compris entre 1 et 100");
                }}
        } while ((level < 1) || (level > 100));
        return level;
    }
    public static int strengthSetUp(Player player){
        int strength = 0;
        int totalLeft = player.getpLevel();
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("force: ");
                strength = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Saisie erronée, votre choix n'est pas un nombre");
                sc.next();
            }finally {
                if(strength>totalLeft){
                    System.out.println("La somme totale de vos caractéristiques ne doit pas dépasser votre niveau");
                    System.out.println("Il vous reste " + totalLeft + " points à assigner");
                }
            }
        } while ((strength < 0) || (strength > 100)||(strength>totalLeft));
        player.setpStrength(strength);
        return strength;
    }
    public static int agilitySetUp(Player player){
        int agility = 0;
        int totalLeft = player.getpLevel()-player.getpStrength();
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("agilité: ");
                agility = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Saisie erronée, votre choix n'est pas un nombre");
                sc.next();
            }finally {

                if(agility>totalLeft){
                    System.out.println("La somme totale de vos caractéristiques ne doit pas dépasser votre niveau");
                    System.out.println("Il vous reste " + totalLeft + " points à assigner");
                }
            }
        } while ((agility < 0) || (agility > 100)||(agility>totalLeft));
        player.setpAgility(agility);
        return agility;
    }
    public static int intelSetUp(Player player){
        int intel = 0;
        int totalLeft = player.getpLevel()-player.getpStrength()-player.getpAgility();
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("intéligence: ");
                intel = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Saisie erronée, votre choix n'est pas un nombre");
                sc.next();
            }finally {

                if(intel>totalLeft){
                    System.out.println("La somme totale de vos caractéristiques ne doit pas dépasser votre niveau");
                    System.out.println("Il vous reste " + totalLeft + " points à assigner");
                }
            }
        } while ((intel < 0) || (intel > 100)||(intel>totalLeft));
        player.setpIntel(intel);
        return intel;
    }
    public static int chooseClass(){
        Scanner sc = new Scanner(System.in);
        int uClass = 0;
        do {
            try{
                System.out.print("Veuillez choisir la classe de votre personnage: 1 - Guerrier, 2 - Rôdeur, 3 - Magicien: ");
                uClass = sc.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Saisie erronée, votre choix n'est pas un nombre");
                sc.next();
            }
        } while ((uClass != 1) && (uClass != 2) && (uClass != 3));
        return uClass;
    }
    public static String stop(){
        String endgame = "GAME OVER!";
        System.out.println(endgame);
        return endgame;
    }
}
