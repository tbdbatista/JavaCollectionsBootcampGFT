import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static java.lang.System.*;

public class ExemplosArrayList {
    public static void main(String[] args) {

/*----------------------------------------------------------------------------------------------------------------------
            DADA UMA LISTA COM 7 NOTAS DE UM ALUNO FAÇA:

        1 - crie a ArrayList() onde as notas serão armazenadas
            antes do Java 5 o comando usado era:
                List notas = new ArrayList();
            agora usamos
                List<Double> notas = new ArrayList<>();
            ou
                List<Double> notas = new ArrayList<Double>(); --> seguindo orientações da aula, adicionamos dessa forma
            outra forma também usada é acrescentando os valores a lista no momento em que ela é criada
                List<Double> notas = new ArrayList<Double>(Arrays.asList(10.5, 4d, 6d, 2d, 5.5, 6d, 3d));
            ou
                List<Double> notas = new ArrayList<Double>(List.of(10.5, 4d, 6d, 2d, 5.5, 6d, 3d));
----------------------------------------------------------------------------------------------------------------------*/

        List<Double> notas = new ArrayList<>();

/*----------------------------------------------------------------------------------------------------------------------
        2 - adicione os elementos à lista:
            [7d, 8.5, 9.3, 5d, 7d, 0d, 3.6]
        para isso usamos o comando
            notas.add(7d); --> para adicionar um por um (seguindo orientações da aula, iremos adicionar dessa forma)
        ou
            notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        ou
            notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
----------------------------------------------------------------------------------------------------------------------*/

        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
        notas.add(7d);
        notas.add(0d);
        notas.add(3.6);
        out.println(notas);
        // outra forma --> System.out.println(notas.toString());

/*----------------------------------------------------------------------------------------------------------------------
        3 - exiba a posição da nota 5.0, para isso usamos:
            notas.indexOf(5.0);
        esse comando retorna um int com a posição
----------------------------------------------------------------------------------------------------------------------*/

        out.println(notas.indexOf(5.0)); // retorna posição 3

/*----------------------------------------------------------------------------------------------------------------------
        4 - adicione na lista a nota 8.0 na posição 4, para isso usamos:
            notas.add(4, 8.0);
        esse comando adiciona sem substituir.
----------------------------------------------------------------------------------------------------------------------*/

        notas.add(4, 8.0);
        out.println(notas); // retorna [7.0, 8.5, 9.3, 5.0, 8.0, 7.0, 0.0, 3.6]

/*----------------------------------------------------------------------------------------------------------------------
        5 - substitua a nota 5.0 pela nota 7.0, para isso usamos:
            notas.set(notas.indexOf(5.0), 7.0);
        usamos o indexOf novamente para retornar a posição do 5.0 que será substituído pelo 7.0.
----------------------------------------------------------------------------------------------------------------------*/

        notas.set(notas.indexOf(5d), 7d);
        out.println(notas); // retorna [7.0, 8.5, 9.3, 7.0, 8.0, 7.0, 0.0, 3.6]

/*----------------------------------------------------------------------------------------------------------------------
        6 - confirme se a nota 5.0 está na lista, para isso usamos:
            notas.contains(5d); --> retorna um boolean
----------------------------------------------------------------------------------------------------------------------*/

        out.println(notas.contains(5d)); // retorna false

/*----------------------------------------------------------------------------------------------------------------------
        7 - imprima uma nota por linha, para isso usamos:
            for (Double nota : notas) System.out.println(nota);
----------------------------------------------------------------------------------------------------------------------*/

        for (Double nota : notas) out.println(nota); // retorna as notas em sequência, uma por linha


/*----------------------------------------------------------------------------------------------------------------------
        8 - exiba a terceira nota, para isso usamos:
            notas.get(posição);
----------------------------------------------------------------------------------------------------------------------*/

        out.println(notas.get(2)); // retorna 9.3

/*----------------------------------------------------------------------------------------------------------------------
        9 - exiba a menor notas, para isso usamos:
            Collections.min(notas));
        ou para a maior nota
            Collections.max(notas));
----------------------------------------------------------------------------------------------------------------------*/

        out.println("O menor valor é " + Collections.min(notas)); // retorna 0.0
        out.println("O maior valor é " + Collections.max(notas)); // retorna 9.3

/*----------------------------------------------------------------------------------------------------------------------
        10 - exiba a soma dos valores, para isso usamos:
            Iterator<Double> iterator = notas.iterator(); --> para criar a lista
            Double soma = 0.0;
            while (iterator.hasNext()){                   --> para percorrer a lista
                Double next = iterator.next();
                soma += next;
            }
        ou
            for (Double nota : notas) {soma2 += nota;};
----------------------------------------------------------------------------------------------------------------------*/

        Iterator<Double> iterator = notas.iterator(); // atalho ctrl + alt + V para criar a variavel após o comando
        Double soma = 0.0;                            // após o comando iterator já ter sido escrito
        while (iterator.hasNext()){
           soma += iterator.next();
        }
        out.println(soma); //retorna a soma 50.4

        //usando o for

        Double soma2 = 0.0;
        for (Double nota : notas){
            soma2 += nota;
        }
        out.println(soma2); //retorna a soma 50.4

/*----------------------------------------------------------------------------------------------------------------------
        11 - exiba a média, para isso usamos:
            soma/notas.size();;
----------------------------------------------------------------------------------------------------------------------*/

        out.println("A média das notas é " + soma/notas.size());

/*----------------------------------------------------------------------------------------------------------------------
        12 - remova a nota 0, para isso usamos:
            notas.remove(); // para remover podemos passar tanto o objeto quanto a posição
            devemos tomar cuidado para verificar qual valor ele está considerando
            int remove a posição
            Double remove o valor
----------------------------------------------------------------------------------------------------------------------*/

        notas.remove(0d); //remove o objeto
        out.println("Lista com o objeto 0.0 removido " + notas); //retorna [7.0, 8.5, 9.3, 7.0, 8.0, 7.0, 3.6]

        notas.remove(0); // remove o objeto que está na posição zero
        out.println("Lista com o objeto da posição 0 removido " + notas);//retorna [8.5, 9.3, 7.0, 8.0, 7.0, 3.6]

/*----------------------------------------------------------------------------------------------------------------------
        13 - remova as notas menores que 7, para isso usamos:
            iteration novamente
        ou
            for
        ou
            ** notas.removeIf(aDouble -> aDouble < 7); ** sugestão do intelliJ
----------------------------------------------------------------------------------------------------------------------*/

        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
           if(iterator1.next() < 7) iterator1.remove();
        }
        out.println("Lista sem as notas menores que 7.0. " + notas); // retorna [8.5, 9.3, 7.0, 8.0, 7.0]

/*----------------------------------------------------------------------------------------------------------------------
        14 - apague toda a lista e, em seguida, confira se a lista está vazia, para isso usamos:
            notas.clear();
        e
            notas.isEmpity(); // retorna um boolean
----------------------------------------------------------------------------------------------------------------------*/

        notas.clear();
        out.println("Esvaziando a lista. " + notas); // retorna a lista vazia
        out.println("A lista está vazia? " + notas.isEmpty()); // retorna true
    }
}


/*----------------------------------------------------------------------------------------------------------------------
__________________
| ATALHOS USADOS |
------------------

alt + enter -->> importa a classe quando o cursor está sobre a chamada do construtor
alt + D -->> duplicar rapidamente uma linha (notas.add(Double);)
ctrl + alt + O -->> remover as bibliotecas importadas que não foram usadas no arquivo final
ctrl + alt + v -->> cria uma variável para o método escrito
shift + 10 -->> Run
----------------------------------------------------------------------------------------------------------------------*/