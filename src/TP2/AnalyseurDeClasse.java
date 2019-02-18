package TP2;

import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse {

    public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
        // Récupération d'un objet de type Class correspondant au nom passé en paramètres
        Class cl = Class.forName(nomClasse);
        afficheEnTeteClasse(cl);

        System.out.println();
        afficheAttributs(cl);

        System.out.println();
        afficheConstructeurs(cl);

        System.out.println();
        afficheMethodes(cl);

        // L'accolade fermante de fin de classe !
        System.out.println("}");
    }


    /** Retourne la classe dont le nom est passé en paramètre */
    public static Class getClasse(String nomClasse) throws ClassNotFoundException {
        return nomClasse.getClass();
    }

    /** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
    public static void afficheEnTeteClasse(Class cl) {

        String res = "";

        //  Affichage du modifier et du nom de la classe
        int i = cl.getModifiers();
        String retval = Modifier.toString(i);
        System.out.println("Class Modifier = " + retval);

        // Récupération de la superclasse si elle existe (null si cl est le type Object)
        if((cl.getSuperclass() instanceof Object) && (cl.getSuperclass() != null)) {
            Class supercl = cl.getSuperclass();
            res += supercl;
            //System.out.println(supercl);
        }

        // Affichage des interfaces que la classe implemente
        if(cl.getInterfaces() != null){
            Object[] interfaces = cl.getInterfaces();

            res += " implements ";

            for(int j = 0; j<interfaces.length;j++){
                Object interfacej = interfaces[j];
                if(j==0){
                    res += interfacej;
                }else{
                    res += ", " +interfacej;
                }
            }
        }
                // Enfin, l'accolade ouvrante !
                System.out.print(" {\n");
    }

    public static void afficheAttributs(Class cl) {
        System.out.println("------ Liste des attributs ------");
        Field f[] = cl.getFields();
        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i]);
        }
    }

    public static void afficheConstructeurs(Class cl) {
        System.out.println("------ Constructeurs ------");

        Constructor c[] = cl.getConstructors();
        for(int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
            System.out.println("{}");
        }
    }

    public static void afficheMethodes(Class cl) {
        System.out.println( "------ Méthodes ------");

        Method[] method = cl.getMethods();
        for (int i  = 0; i< method.length; i++) {
            System.out.println(method[i]);
            System.out.println("{}");
        }
    }


    public static String litChaineAuClavier() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static void main(String[] args) {
    boolean ok = false;

        while(!ok) {
            try {
            System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
            String nomClasse = litChaineAuClavier();

            analyseClasse(nomClasse);

            ok = true;

            } catch(ClassNotFoundException e) {
                System.out.println("Classe non trouvée.");
            }catch(IOException e) {
                System.out.println("Erreur d'E/S!");
            }
        }
    }
}
