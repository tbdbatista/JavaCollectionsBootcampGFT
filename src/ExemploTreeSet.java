import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ExemploTreeSet {
    public static void main(String[] args) {

/*----------------------------------------------------------------------------------------------------------------------
            A leitura é bastante performática no TreeSet
            Porém, alterações resultam em novas ordenações (algoritmo de ordenação de árvore vai ser aplicado novamente)
----------------------------------------------------------------------------------------------------------------------*/

        TreeSet<String> capitais = new TreeSet<>(); // a ordem tomada é a partir de um algoritmo que monta uma árvore

        capitais.add("Curitiba");
        capitais.add("Porto Alegre");
        capitais.add("São Paulo");
        capitais.add("Rio de Janeiro");
        capitais.add("Belo Horizonte");
        capitais.add("Salvador");

        System.out.println(capitais); // retorna na ordem de árvore binária

        System.out.println(capitais.first()); // primeiro elemento da árvore
        System.out.println(capitais.last()); // último elemento da árvore

        System.out.println(capitais.lower("Rio de Janeiro")); // elemento abaixo na árvore
        System.out.println(capitais.higher("Rio de Janeiro")); // elemento acima na árvore

        System.out.println(capitais.pollFirst()); // retorna e remove o primeiro
        System.out.println(capitais.pollLast()); // retorna e remove o último

        System.out.println(capitais);

        Iterator<String> iterator = capitais.iterator();
        while (iterator.hasNext()) System.out.println("-->>" + iterator.next());

        for (String capital : capitais) System.out.println(capital);

    }
}
