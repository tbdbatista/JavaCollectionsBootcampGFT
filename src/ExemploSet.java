import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {


/*----------------------------------------------------------------------------------------------------------------------
            DADA UMA LISTA COM 7 NOTAS DE UM ALUNO FAÇA:

        1 - crie um conjunto utilizando o Set onde as notas serão armazenadas (tanto list, quanto set, estendem
        a interface Collection). Para isso usamos:

                Set notas = new HashSet(); // antes do Java 5
            agora usamos
                Set<Double> notas = HashSet<>();
            ou
                HashSet<Double> notas = new HashSet<>();
            outra forma também usada é acrescentando os valores a lista no momento em que ela é criada
                Set<Double> notas = new HashSet<Double>(Arrays.asList(10.5, 4d, 6d, 2d, 5.5, 6d, 3d));
            ou
                Set<Double> notas = Set.of(10.5, 4d, 6d, 2d, 5.5, 6d, 3d);
            ou
                notas.add(valord);
                notas.remove(valord);
----------------------------------------------------------------------------------------------------------------------*/

        Set<Double> notas = new HashSet<>(Arrays.asList(10.5, 4d, 6d, 2d, 5.5, 6d, 2d));

        System.out.println(notas); // retorna uma lista com 6 elementos (valores repetidos não são duplicados), e fora
                                   // de ordem por utilizar o hash

/*----------------------------------------------------------------------------------------------------------------------
            Não conseguimos exibir posições pois não existe um index quando trabalhamos com Set (indexOf não funciona).
            Também não podemos adicionar um valor em uma posição específica.
            Também não podemos substituir de forma direta um valor.
            Primeiro temos que remover um valor e acrescentar outro de forma manual.

        2 - exiba se a nota 5.0 está no conjunto. Para isso o comando é o mesmo utilizado no exemplo da List
            notas.contains(valor); --> retorna true ou false
----------------------------------------------------------------------------------------------------------------------*/

        System.out.println(notas.contains(5.0)); //retorna false
        System.out.println(notas.contains(5.5)); //retorna true

/*----------------------------------------------------------------------------------------------------------------------
            Não conseguimos exibir potas por posição, apenas por valor

        3 - exiba a menor nota. Para isso o comando é o mesmo utilizado no exemplo da List
            Collections.min(notas); --> exibe a menor
            Collections.max(notas); --> exibe a maior
----------------------------------------------------------------------------------------------------------------------*/

        System.out.println(Collections.min(notas));
        System.out.println(Collections.max(notas));

/*----------------------------------------------------------------------------------------------------------------------
        4 - exiba a soma e a média dos valores. Para isso o comando é o mesmo utilizado no exemplo da List, o iterator
----------------------------------------------------------------------------------------------------------------------*/

        Iterator<Double> iterator;
        iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()) soma += iterator.next();
        System.out.println(soma); // retorna a soma 28.0
        System.out.println(soma/ notas.size()); // retorna a média 5.6

/*----------------------------------------------------------------------------------------------------------------------
        5 - remova a nota 2.0. Para isso usamos
            notas.remove(valor);
----------------------------------------------------------------------------------------------------------------------*/

        notas.remove(2.0); // não pode colocar inteiro que dá erro pois não existe mais index
        System.out.println(notas);

/*----------------------------------------------------------------------------------------------------------------------
        6 - remova as notas menores que 7.0. Para isso usamos o iterator
----------------------------------------------------------------------------------------------------------------------*/

        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()) if (iterator1.next() < 7.0) iterator1.remove();

        // poderíamos usar também notas.removeIf(aDouble -> aDouble < 7.0);
        // sugestão do inteliJ
/*----------------------------------------------------------------------------------------------------------------------
        7 - retorne o conjunto na sequencia que foi inserida.
        Não é possível fazer isso com o hash, para isso devemos utilizar o linkedHashSet.
----------------------------------------------------------------------------------------------------------------------*/

        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(10.5, 4d, 6d, 2d, 5.5, 6d, 2d));
        System.out.println(notas2); // exibe as notas na ordem que foram inseridas usando o LinkedHashSet

/*----------------------------------------------------------------------------------------------------------------------
        8 - exibir o conjunto na ordem crescente. Para isso podemos usar o TreeSet
----------------------------------------------------------------------------------------------------------------------*/

        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

/*----------------------------------------------------------------------------------------------------------------------
        9 - apague todos os elementos do conjunto
----------------------------------------------------------------------------------------------------------------------*/

        notas.clear();
        System.out.println(notas);

/*----------------------------------------------------------------------------------------------------------------------
        10 - confira se o conjunto está vazio
----------------------------------------------------------------------------------------------------------------------*/

        System.out.println("O conjunto notas está vazio? " + notas.isEmpty());
        System.out.println("O conjunto notas2 está vazio? " + notas2.isEmpty());
        System.out.println("O conjunto notas3 está vazio? " + notas3.isEmpty());

    }
}

/*----------------------------------------------------------------------------------------------------------------------
__________________
| ATALHOS USADOS |
------------------

alt + 4 -->> esconde a janela inferior
----------------------------------------------------------------------------------------------------------------------*/