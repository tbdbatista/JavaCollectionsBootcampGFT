import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {


/*----------------------------------------------------------------------------------------------------------------------
            1 - implementar um map de carros com seu respectivo consumo.
----------------------------------------------------------------------------------------------------------------------*/

        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};

        System.out.println(carrosPopulares); // retorna {gol=14.4, kwid=15.6, uno=15.6, hb20=14.5, mobi=16.1}

/*----------------------------------------------------------------------------------------------------------------------
            2 - altere o consumo do gol para 15.2
----------------------------------------------------------------------------------------------------------------------*/

        carrosPopulares.put("gol", 15.2); // aqui ele apenas altera o valor pela string gol já existir no map
        System.out.println(carrosPopulares); // retorna {gol=15.2, kwid=15.6, uno=15.6, hb20=14.5, mobi=16.1}
        carrosPopulares.put("onix", 14.5); // aqui ele adiciona como um novo elemento por não existir a string onix
        System.out.println(carrosPopulares); // retorna {gol=15.2, kwid=15.6, uno=15.6, hb20=14.5, mobi=16.1, onix=14.5}

/*----------------------------------------------------------------------------------------------------------------------
            3 - verificar se um carro consta na lista
----------------------------------------------------------------------------------------------------------------------*/

        System.out.println(carrosPopulares.containsKey("tukson")); // retorna false
        System.out.println(carrosPopulares.containsKey("onix")); // retorna true
        System.out.println(carrosPopulares.containsKey("14.5")); // retorna false, pq ele procura nas keys

/*----------------------------------------------------------------------------------------------------------------------
            4 - verificar o consumo de um carro
----------------------------------------------------------------------------------------------------------------------*/

        System.out.println(carrosPopulares.get("uno")); // retorna o valor do Double 15.6

/*----------------------------------------------------------------------------------------------------------------------
            5 - exiba os modelos e os consumos dos carros separadamente
----------------------------------------------------------------------------------------------------------------------*/

        System.out.println(carrosPopulares.keySet()); // retorna um Set [gol, kwid, uno, hb20, mobi, onix]

        System.out.println(carrosPopulares.values()); // retorna Collection Double, [15.2, 15.6, 15.6, 14.5, 16.1, 14.5]

        //outra forma mais literal
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos); // retorna um Set [gol, kwid, uno, hb20, mobi, onix]
        Collection<Double> consumo = carrosPopulares.values();
        System.out.println(consumo); // retorna Collection Double, [15.2, 15.6, 15.6, 14.5, 16.1, 14.5]

/*----------------------------------------------------------------------------------------------------------------------
            6 - qual o modelo mais economico e qual seu consumo?
----------------------------------------------------------------------------------------------------------------------*/

        Double consumoEficiente = Collections.max(carrosPopulares.values());
        String modeloMaisEficiente;
        for (Map.Entry<String, Double> entry: carrosPopulares.entrySet()) {
            if (entry.getValue().equals(consumoEficiente)){
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + ". Consumo: " + consumoEficiente);
            }
        }

        // retorna Modelo mais eficiente: mobi;  consumo de: 16.1

/*----------------------------------------------------------------------------------------------------------------------
           7 - qual o modelo menos economico e qual seu consumo?
----------------------------------------------------------------------------------------------------------------------*/

        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente;
        for (Map.Entry<String, Double> entry: carrosPopulares.entrySet()){
            if(entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + ". Consumo: " +
                        consumoMenosEficiente);
            }
        }

/*----------------------------------------------------------------------------------------------------------------------
            8 - qual a soma dos consumos e a média de consumo desse dicionário?
----------------------------------------------------------------------------------------------------------------------*/

        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
            while(iterator.hasNext()){
                soma += iterator.next();
            }
        System.out.println("A soma dos consumos é de: " + soma);
        System.out.println("A média dos consumos é: " + soma/ carrosPopulares.size());

/*----------------------------------------------------------------------------------------------------------------------
            9 - remova os modelos com consumo igual a 15.6?
----------------------------------------------------------------------------------------------------------------------*/

        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()) if(iterator1.next().equals(15.6)) iterator1.remove();
        System.out.println(carrosPopulares);

/*----------------------------------------------------------------------------------------------------------------------
            10 - exibir na ordem em que os elementos foram inseridos
----------------------------------------------------------------------------------------------------------------------*/

        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1); // retorna {gol=14.4, uno=15.6, mobi=16.1, hb20=14.5, kwid=15.6}

/*----------------------------------------------------------------------------------------------------------------------
            11 - exibir na ordem de modelo
                modelo é chave e quem ordena a chave é o TreeMap
----------------------------------------------------------------------------------------------------------------------*/

        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2); // retorna {gol=14.4, hb20=14.5, kwid=15.6, mobi=16.1, uno=15.6}

/*----------------------------------------------------------------------------------------------------------------------
            11 - apague o primeiro dicionário de carros e confira se ele está vazio
----------------------------------------------------------------------------------------------------------------------*/

        carrosPopulares.clear();
        System.out.println(carrosPopulares);// retorna {}
        System.out.println(carrosPopulares.isEmpty()); // retorna true

    }
}
