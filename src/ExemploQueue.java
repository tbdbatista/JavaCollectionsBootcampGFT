import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ExemploQueue {
    public static void main(String[] args) {


        Queue<String> filaBanco = new LinkedList<>();

        filaBanco.add("Patrícia");
        filaBanco.add("Roberto");
        filaBanco.add("Flávio");
        filaBanco.add("Pamela");
        filaBanco.add("Anderson");

        System.out.println(filaBanco);

/*----------------------------------------------------------------------------------------------------------------------
                    poll() -->> retorna e remove o primeiro elemento da fila, retorna null se fila vazia
                    peek() -->> retorna o primeiro elemento sem remover, retorna null se fila vazia
                    element() -->> retorna o primeiro elemento sem remover, retorna exceção se fila vazia
----------------------------------------------------------------------------------------------------------------------*/

        String clienteProximo = filaBanco.poll();

        System.out.println(clienteProximo); // retorna Patrícia e remove da fila
        System.out.println(filaBanco); // retorna a fila sem Patrícia

        String consultaClienteProximo = filaBanco.peek();

        System.out.println(consultaClienteProximo); // retorna Roberto sem remover ele da fila
        System.out.println(filaBanco);

        consultaClienteProximo = filaBanco.element();

        System.out.println(consultaClienteProximo); // retorna Roberto sem remover ele da fila
        System.out.println(filaBanco);

        for (String cliente: filaBanco) System.out.println(cliente); // percorre a fila

        Iterator<String> iterator = filaBanco.iterator();
        while(iterator.hasNext()) System.out.println("-->> " + iterator.next());

        System.out.println(filaBanco.contains("Thiago"));

        System.out.println(filaBanco.size());

        System.out.println(filaBanco.isEmpty());

        filaBanco.clear(); // limpa fila

        System.out.println(filaBanco.isEmpty());

        System.out.println(filaBanco.peek()); // retorna null
        System.out.println(filaBanco.element()); // retorna exception


    }

}
