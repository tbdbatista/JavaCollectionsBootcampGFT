import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ExemploLinkedHashSet {
    public static void main(String[] args) {


        LinkedHashSet<Integer> ordemInsercao = new LinkedHashSet<>();

        ordemInsercao.add(1);
        ordemInsercao.add(16);
        ordemInsercao.add(2);
        ordemInsercao.add(8);
        ordemInsercao.add(4);
        ordemInsercao.add(32);

        System.out.println(ordemInsercao);

        ordemInsercao.remove(32);

        System.out.println(ordemInsercao);

        System.out.println(ordemInsercao.size());

        Iterator<Integer> iterator = ordemInsercao.iterator();
        while (iterator.hasNext()) System.out.println("-->> " + iterator.next());

        for (Integer ordem : ordemInsercao) System.out.println(ordem);

        ordemInsercao.clear();

        System.out.println(ordemInsercao);
        System.out.println(ordemInsercao.isEmpty());


    }
}
