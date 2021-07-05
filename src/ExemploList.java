import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExemploList {
    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();

        nomes.add("Carlos");
        nomes.add("Pedro");
        nomes.add("Juliana");
        nomes.add("Anderson");
        nomes.add("Maria");
        nomes.add("João");

        System.out.println(nomes); // retorna a lista na ordem de inserção

        Collections.sort(nomes);
        System.out.println(nomes); // retorna a lista em ordem alfabética

        nomes.set(nomes.indexOf("Juliana"), "Larissa"); // troca Juliana por Larissa "lista.set(índice, novovalor)"
        System.out.println(nomes); // o indexOf retorna -1 caso o valor dado não exista na lista

        nomes.remove(2); // remove o elemento no índice dado
        System.out.println(nomes);
        nomes.remove("Maria"); // remove o elemento pelo valor dado
        System.out.println(nomes);

        String s = nomes.get(3);// retorna o valor do elemento na posição index dada
        System.out.println("Qual o nome de valor index 3? " + s);

        int size = nomes.size();
        System.out.println("Qual o tamanho da lista? " + size); // retorna o tamanho da lista

        System.out.println("O nome Thiago está na lista? " + nomes.contains("Thiago")); // retorna true/false se o valor dado está contido na lista

        System.out.println("A lista está vazia? " + nomes.isEmpty()); // retorna true/false se a lista está vazia

        nomes.clear(); // esvazia a lista

        System.out.println("A lista está vazia agora? " + nomes.isEmpty());

        nomes.add("Carlos");
        nomes.add("Pedro");
        nomes.add("Juliana");
        nomes.add("Anderson");
        nomes.add("Maria");
        nomes.add("João");

        System.out.println("Adicionando os nomes na lista novamente... " + nomes);

        for(String nome: nomes) System.out.println("Nome " + (nomes.indexOf(nome)+1) + ": " + nome);

        Iterator<String> iterator = nomes.iterator();

        while(iterator.hasNext()) {
            String aNome = iterator.next();
            System.out.println("Nome " + (nomes.indexOf(aNome)+1) + ": " + aNome);
        }

        List<String> nomes2 = new ArrayList<>();
        System.out.println(nomes2);
        nomes2.add("Esmeralda");
        System.out.println(nomes2);
        nomes2.add("Isaias");
        System.out.println(nomes2);
        nomes2.addAll(nomes);
        System.out.println(nomes2);
    }

}
