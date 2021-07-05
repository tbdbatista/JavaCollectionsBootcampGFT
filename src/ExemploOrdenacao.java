import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacao {
    public static void main(String[] args) {

        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("John", 12, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("John", 18, "amarelo"));
        }};

        System.out.println(meusGatos); // retorna o endereço de memória, para consertar tem que criar toString na classe

/*----------------------------------------------------------------------------------------------------------------------
                1 - desordenar a lista dos objetos, para isso usamos:
                    Collection.shuffle(meusGatos);
----------------------------------------------------------------------------------------------------------------------*/

        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

/*----------------------------------------------------------------------------------------------------------------------
                2 - ordenar a lista dos objetos de acordo com o nome, para isso devemos implementar a
                interface Comparable na classe Gato, sobrescrevendo a interface compareTo. Na main class usamos o
                método sort do Collections:
                    Collection.sort(meusGatos);
----------------------------------------------------------------------------------------------------------------------*/
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

/*----------------------------------------------------------------------------------------------------------------------
                3 - ordenar por idade. Porém teremos que criar o ordenador idade por ser integer, não podemos usar o
                comparable criado para String. Então iremos implementar o método comparator, e depois usamos:
                    Collections.sort(meusGatos, new ComparatorIdade());
----------------------------------------------------------------------------------------------------------------------*/

        Collections.sort(meusGatos, new ComparatorIdade());
        System.out.println(meusGatos);

        meusGatos.sort(new ComparatorIdade()); // método sugerido pelo intelliJ
        System.out.println(meusGatos);

/*----------------------------------------------------------------------------------------------------------------------
                4 - ordenar por cor. Sem usar o comparable, usando o comparator:
                    Collections.sort(meusGatos, new ComparatorCor());
----------------------------------------------------------------------------------------------------------------------*/

        meusGatos.sort(new ComparatorCor()); // método sugerido pelo intelliJ
        System.out.println(meusGatos);

/*----------------------------------------------------------------------------------------------------------------------
                5 - ordenar por nome, usando a cor e a idade como critério de desempate. Criamos outro implement da
                interface Comparable. Depois usamos:
                    meusGatos.sort(new ComparatorNomeCorIdade());
----------------------------------------------------------------------------------------------------------------------*/

        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);
    }
}

class Gato implements Comparable<Gato>{
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {

        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());

    }
}




/*----------------------------------------------------------------------------------------------------------------------
__________________
| ATALHOS USADOS |
------------------

alt + insert -->> cria o construtor da classe, também serve para criar get, set, entre outros
alt + 1 -->> esconde a barra lateral da esquerda com as pastas e arquivos do projeto
shift + 10 -->> Run
----------------------------------------------------------------------------------------------------------------------*/