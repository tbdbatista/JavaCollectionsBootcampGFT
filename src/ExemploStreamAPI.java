import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ExemploStreamAPI {
    public static void main(String[] args) {

/*----------------------------------------------------------------------------------------------------------------------
            Stream API - é bem mais complexa do que os exemplos vistos aqui

            Manipulações de coleções com o paradigma funcional de forma paralela
            Imutável - Não altera a coleção origem, sempre criando uma nova coleção
            Principais funcionalidade
                Mapping - retorna coleção com manipulação requirida
                Filtering - retorna coleção com elementos selecionados de acordo com a regra
                ForEach - executa um algoritmo sobre os dados sem retornar o elemento
                Peek - executa um algoritmo sobre os dados retornando a coleção
                Counting - retorna quantos elementos tem na coleção
                Grouping - retorna coleção de acordo com uma regra definida de agrupamento
            Collect
                .collect(Collectors.toList()) -->> para uma lista
                .collect(Collectors.joining()) -->> retorna uma String de forma concatenada
                .collect(Collectors.toSet()) -->> coleta em um set
                .collect(Collectors.groupingBy()) -->> agrupa de acordo com uma regra
----------------------------------------------------------------------------------------------------------------------*/


        List<String> estudantes = new ArrayList<>();

        estudantes.add("Murilo");
        estudantes.add("Isaías");
        estudantes.add("Maria");
        estudantes.add("João");
        estudantes.add("Wesley");
        estudantes.add("Juliana");
        estudantes.add("Rafael");
        estudantes.add("Pedro");
        estudantes.add("Thiago");

        System.out.println(estudantes);

        System.out.println(estudantes.stream().max(Comparator.comparingInt(String::length))
                .stream().collect(Collectors.toList()));

        List<String> estudantes2 = new ArrayList<>();
        estudantes2 = (estudantes.stream().max(Comparator.comparingInt(String::length))
                .stream().collect(Collectors.toList()));
        System.out.println(estudantes);
        System.out.println(estudantes2);

        System.out.println("Algum elemento da lista contém a letra A?");
        System.out.println(estudantes.stream().anyMatch((letra) -> letra.toLowerCase(Locale.ROOT).contains("a")));

        System.out.println("Busca elementos com a letra A no nome: " + estudantes.stream().filter((estudante) ->
                estudante.toLowerCase(Locale.ROOT).contains("a")).collect(Collectors.toList()));

        System.out.println("Percorre os elementos da lista sem retornar outra coleção");
        estudantes.stream().forEach(System.out::println);

        System.out.println("Percorre os elementos da lista e retorna a coleção");
        System.out.println(estudantes.stream().peek(System.out::println).collect(Collectors.toList()));

        System.out.println(estudantes.stream()
                .map((estudante) -> estudante.concat(" - ")
                .concat(String.valueOf(estudante.length())))
                .peek(System.out::println)
                //.collect(Collectors.toList()));
                .collect(Collectors.groupingBy((estudante) -> estudante.substring(estudante.indexOf("-") + 1))));


    }
}
