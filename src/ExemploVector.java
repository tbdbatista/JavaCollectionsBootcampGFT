import java.util.List;
import java.util.Vector;

public class ExemploVector {
    public static void main(String[] args) {

        List<String> esportes = new Vector<>();

        esportes.add("Futebol");
        esportes.add("Basquete");
        esportes.add("Automoblismo");
        esportes.add("Tênis");
        esportes.add("Volei");

        esportes.set(2, "Ping Pong"); // altera o valor da posição 2 do vetor

        esportes.remove(2); // remove o elemento da posição 2

        esportes.remove("Volei"); // remove o elemento volei do vector

        System.out.println("Retorna o primeiro elemento do vetor: " + esportes.get(0)); // retorna o primeiro elemento

        for (String esporte: esportes) System.out.println(esporte);


    }
}
