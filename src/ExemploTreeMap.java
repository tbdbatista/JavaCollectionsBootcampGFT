import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExemploTreeMap {
    public static void main(String[] args) {

        TreeMap<String, String> capitais = new TreeMap<>();

        capitais.put("Curitiba", "Paraná");
        capitais.put("São Paulo", "São Paulo");
        capitais.put("Rio de Janeiro", "Rio de Janeiro");
        capitais.put("Belo Horizonte", "Minas Gerais");
        capitais.put("Salvador", "Bahia");
        capitais.put("Florianópolis", "Santa Catarina");
        capitais.put("Porto Alegre", "Rio Grande do Sul");
        capitais.put("Vitória", "Espírito Santo");

        System.out.println(capitais);

        System.out.println("firstKey " + capitais.firstKey());
        System.out.println("lastKey " + capitais.lastKey());

        System.out.println("firstEntry " + capitais.firstEntry());
        System.out.println("lastEntry " + capitais.lastEntry());

        System.out.println("lowerEntry relativo a Florianópolis --> " + capitais.lowerEntry("Florianópolis"));
        System.out.println("higherEntry relativo a Florianópolis --> " + capitais.higherEntry("Florianópolis"));

        System.out.println("lowerKey " + capitais.lowerKey("Florianópolis"));
        System.out.println("higherKey " + capitais.higherKey("Florianópolis"));

        System.out.println(capitais.pollFirstEntry());
        System.out.println(capitais.pollLastEntry());

        System.out.println(capitais);

        Iterator<String> iterator = capitais.keySet().iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next + " - " + capitais.get(next));
        }
        for (Map.Entry<String, String> entries : capitais.entrySet()){
            System.out.println(entries.getKey() + " -->> " + entries.getValue());
        }


    }
}
