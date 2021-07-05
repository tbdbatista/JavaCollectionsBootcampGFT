import java.util.*;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {

        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("HIMYM", "comédia", 30));
            add(new Serie("Friends", "comédia", 30));
            add(new Serie("House", "drama", 60));
        }};

        // System.out.println(minhasSeries);

        System.out.println("Conjunto em ordem aleatória");
        for (Serie serie : minhasSeries) System.out.println(serie.getNome() + "-" + serie.getGenero() + "-" + serie.getTempoEpisodio() + " min.");
        // retorna na ordem que o hash criou

        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("HIMYM", "comédia", 30));
            add(new Serie("Friends", "comédia", 30));
            add(new Serie("House", "drama", 60));
        }};

        System.out.println("Conjunto em ordem de inserção");
        for (Serie serie : minhasSeries1) System.out.println(serie.getNome() + "-" + serie.getGenero() + "-" +
                serie.getTempoEpisodio() + " min.");
        // retorna na ordem por usar LinkedHashSet

        Set<Serie> minhasSeries2 = new TreeSet<>(){{
            add(new Serie("HIMYM", "comédia", 30));
            add(new Serie("Friends", "comédia", 30));
            add(new Serie("House", "drama", 60));
        }};

        System.out.println("Conjunto em ordem por tempo de episódio");
        for (Serie serie : minhasSeries2) System.out.println(serie.getNome() + "-" + serie.getGenero() + "-" +
                serie.getTempoEpisodio() + " min.");
        System.out.println(minhasSeries2);


        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);

        for (Serie serie: minhasSeries3) System.out.println(serie.getNome() + "-" + serie.getGenero() + "-" +
                serie.getTempoEpisodio() + " min.");

    }
}


class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        if (this.tempoEpisodio.equals(serie.getTempoEpisodio())) {
            return this.nome.compareTo(serie.getNome());
        }
        return this.tempoEpisodio;
    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{
    @Override
    public int compare(Serie s1, Serie s2){
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome !=0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero !=0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}