import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {


/*----------------------------------------------------------------------------------------------------------------------
        Crie um dicionário com livros contendo: título,  autor e nº de páginas
        1 - exiba os autores e título dos livros
----------------------------------------------------------------------------------------------------------------------*/
    Map<String, Livro> meusLivros = new HashMap<>(){{
        put("King", new Livro("O Pistoleiro", 486));
        put("Silverthorn", new Livro("Fisiologia Humana", 510));
        put("Koss", new Livro("Koss' Diagnostic Cytology", 2149));
    }};
    for (Map.Entry<String, Livro> livro : meusLivros.entrySet()) System.out.println(livro.getKey() + " - " +
            livro.getValue().getNome());

/*----------------------------------------------------------------------------------------------------------------------
        2 - exiba por ordem de inserção
----------------------------------------------------------------------------------------------------------------------*/

        Map<String, Livro> meusLivros2 = new LinkedHashMap<>(){{
            put("King", new Livro("O Pistoleiro", 486));
            put("Silverthorn", new Livro("Fisiologia Humana", 510));
            put("Koss", new Livro("Koss' Diagnostic Cytology", 2149));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros2.entrySet()) System.out.println(livro.getKey() + " - " +
                livro.getValue().getNome());

/*----------------------------------------------------------------------------------------------------------------------
        3 - exiba por ordem alfabetica por autor (keys)
----------------------------------------------------------------------------------------------------------------------*/

        Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros2);
        for (Map.Entry<String, Livro> livro : meusLivros3.entrySet()) System.out.println(livro.getKey() + " - " +
                livro.getValue().getNome());

/*----------------------------------------------------------------------------------------------------------------------
        4 - exiba por ordem alfabetica por livro (value)
----------------------------------------------------------------------------------------------------------------------*/

        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros4) System.out.println(livro.getKey() + " - " +
                livro.getValue().getNome());

/*----------------------------------------------------------------------------------------------------------------------
        5 - exiba por ordem do número de páginas (value)
----------------------------------------------------------------------------------------------------------------------*/

        Set<Map.Entry<String, Livro>> meusLivros5 = new TreeSet<>(new ComparatorPaginas());
        meusLivros5.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros5) System.out.println(livro.getKey() + " - " +
                livro.getValue().getNome() + " - " + livro.getValue().getPaginas());


    }
}

class Livro {
    private String nome;
    private Integer paginas;


    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{
    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>>{
    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return o1.getValue().getPaginas().compareTo(o2.getValue().getPaginas());
    }
}
