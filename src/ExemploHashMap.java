import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ExemploHashMap {
    public static void main(String[] args) {


/*----------------------------------------------------------------------------------------------------------------------
                    java.util.Map
                    Não é uma interface que estende do Collections
                    implementações: hashMap (mais usada) / TreeMap (arvore binária) / HashTable (mais antiga)
                    existe também o LinkedHashMap com ordenação e menos performático
                    armazena dois tipos de elementos (valor e chave)
                    permite repetições de valores, mas não permite repetição de chave
----------------------------------------------------------------------------------------------------------------------*/

        HashMap<String, Integer> campeoesMundiais = new HashMap<>();

        campeoesMundiais.put("Brasil", 5);
        campeoesMundiais.put("Alemanha", 4);
        campeoesMundiais.put("Itália", 4);
        campeoesMundiais.put("Uruguai", 2);
        campeoesMundiais.put("Argentina", 2);
        campeoesMundiais.put("França", 2);
        campeoesMundiais.put("Inglaterra", 1);
        campeoesMundiais.put("Espanha", 1);

        System.out.println(campeoesMundiais); // não tem uma ordem específica e não mantém a ordem de inserção

        //Para atualizar um valor de uma chave, é só colocar outro valor para uma chave já existente
        campeoesMundiais.put("Brasil", 6);

        System.out.println(campeoesMundiais);

        System.out.println(campeoesMundiais.get("Argentina")); // retorna o valor da chave Argentina

        System.out.println(campeoesMundiais.containsKey("Itália")); // retorna true/false verificando se existe a chave
        System.out.println(campeoesMundiais.containsValue(2)); // retorna true/false verificando se existe o valor

        campeoesMundiais.remove("França", 2); // remove o elemento pela chave, com ou sem valor explícito
        System.out.println(campeoesMundiais);

        System.out.println(campeoesMundiais.size()); //retorna o tamanho do map

        for (Map.Entry<String, Integer> entries : campeoesMundiais.entrySet()) System.out.println(entries.getKey() +
                " - campeão por " + entries.getValue() + " vez(es).");

        for (String key : campeoesMundiais.keySet()) System.out.println( key +
                " - campeão por " + campeoesMundiais.get(key) + " vez(es).");

        Iterator<String> iterator = campeoesMundiais.keySet().iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next + " - " + campeoesMundiais.get(next));
        }

        System.out.println(campeoesMundiais.isEmpty());
        campeoesMundiais.clear();
        System.out.println(campeoesMundiais.isEmpty());
    }
}
