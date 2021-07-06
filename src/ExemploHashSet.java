import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExemploHashSet {
    public static void main(String[] args) {

/*----------------------------------------------------------------------------------------------------------------------
            java.util.Set

            Por padrão, não garante a ordem de inserção.
            Não é indexada.
            Não permite itens repetidos.
            Ela é mais performática, principalmente quando utilizamos um conjunto muito grande de dados.

            Implementações possíveis com propriedades diferentes:
                HashSet -- usar quando não é necessário manter a ordenação
                TreeSet -- mantém ordem de inserção
                LinkedHasSet -- quando é necessário alterar a ordem
----------------------------------------------------------------------------------------------------------------------*/

        Set<Double> notas = new HashSet<>(8, 0.3f);

        notas.add(5.8);
        notas.add(9.3);
        notas.add(6.5);
        notas.add(10.0);
        notas.add(5.4);
        notas.add(7.3);
        notas.add(3.8);
        notas.add(4.0);

        System.out.println(notas); // retorna as notas sem ordenação [4.0, 5.8, 10.0, 9.3, 3.8, 6.5, 7.3, 5.4]

        notas.remove(3.8);

        System.out.println(notas);

        System.out.println(notas.size());

        Iterator<Double> iterator = notas.iterator();
        while(iterator.hasNext()) System.out.println(iterator.next());

        for (Double nota: notas) System.out.println("-->> " + nota);

        notas.clear();

        System.out.println(notas.isEmpty());
    }
}
