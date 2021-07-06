import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class ExemploOptionals {
    public static void main(String[] args) {

/*----------------------------------------------------------------------------------------------------------------------
                    Optionals
                    Tratamento para valores que podem ser nulos
                    Possui 2 estados: Presente / Vazio
                    Permite que você execute operações em valores que podem ser nulos sem preocupação
                    Quando trabalha com valores que são nulos, retorna um Optional
----------------------------------------------------------------------------------------------------------------------*/

        Optional<String> optionalNull = Optional.ofNullable(null);
        // se valor null constroi com empty, senão retorna valor
        optionalNull.ifPresentOrElse(System.out::println, () -> System.out.println("null = valor não está presente"));
        optionalNull = Optional.empty();
        // esse comando reflete como é a construção acima com o null
        optionalNull.ifPresentOrElse(System.out::println, () -> System.out.println("empty() = valor não está presente"));


        Optional<String> optionalString = Optional.of("Valor presente");
        optionalString.ifPresentOrElse(System.out::println, () -> System.out.println("null = valor não está presente"));
        // optionalString = Optional.of(null);
        // optionalString.ifPresentOrElse(System.out::println, () -> System.out.println("null = valor não está presente"));
        // retorna Exception in thread "main" java.lang.NullPointerException


        System.out.println("Optionals com valor inteiro");
        OptionalInt.of(12).ifPresent(System.out::println); // retorna o valor inteiro

        System.out.println("Optionals com Double");
        OptionalDouble.of(12.123).ifPresent(System.out::println); // retorna o Double

        System.out.println("Optionals com Long");
        OptionalLong.of(4651561684684611L).ifPresent(System.out::println); // retorna o Long

        // métodos importantes
        System.out.println(optionalString.isEmpty());
        System.out.println(optionalString.isPresent());

        System.out.println(optionalNull.isEmpty());
        System.out.println(optionalNull.isPresent());

        optionalString.ifPresent(System.out::println);

        if (optionalString.isPresent()) {
            String valor = optionalString.get(); // se usar o get fora do verificador if, a IDE gera um alerta qdo null
            System.out.println(valor);
        }

        // String valor = optionalNull.get();
        // System.out.println(valor); // Exception in thread "main" java.util.NoSuchElementException: No value present

        optionalString.map((valor) -> valor.concat("****")).ifPresent(System.out::println);
        optionalNull.map((valor) -> valor.concat("****")).ifPresent(System.out::println);

        System.out.println(optionalString.orElseThrow(IllegalStateException::new));
        System.out.println(optionalNull.orElseThrow(IllegalStateException::new));
        // retorna Exception in thread "main" java.lang.IllegalStateException

    }
}
