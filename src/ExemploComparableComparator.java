import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ExemploComparableComparator {
    public static void main(String[] args) {

        ArrayList<Estudante> estudantes = new ArrayList<>();

        estudantes.add(new Estudante("Pedro", 19));
        estudantes.add(new Estudante("Carlos", 23));
        estudantes.add(new Estudante("Mariana", 21));
        estudantes.add(new Estudante("João", 18));
        estudantes.add(new Estudante("Thiago", 20));
        estudantes.add(new Estudante("George", 22));
        estudantes.add(new Estudante("Larissa", 21));

        System.out.println(estudantes); // ordem de inserção

//        estudantes.sort((first, second) -> first.getIdade() - second.getIdade());
//
//        System.out.println(estudantes);

        estudantes.sort(Comparator.comparing(Estudante::getIdade));
        System.out.println(estudantes);

        estudantes.sort(Comparator.comparing(Estudante::getIdade).reversed());
        System.out.println(estudantes);

        Collections.sort(estudantes); // somente posso usar uma lista de objeto que implemente o comparable
        System.out.println(estudantes);

        // ou

        Collections.sort(estudantes, new EstudanteReversaComparator());
        System.out.println(estudantes);// não é obrigado a implementar o comparable

    }
}

class Estudante implements Comparable<Estudante>{
    private final String nome;
    private final Integer idade;

    Estudante(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return nome + " = " + idade;
    }

    @Override
    public int compareTo(Estudante o) {
        return this.getIdade() - o.getIdade();
    }
}

class EstudanteReversaComparator implements Comparator<Estudante> {
    @Override
    public int compare(Estudante o1, Estudante o2) {
        return o2.getIdade() - o1.getIdade();
    }
}
