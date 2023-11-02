## Interface de linha de comando 💻

A interface CommandLineRunner é um recurso poderoso dentro do universo do Spring Framework, amplamente utilizado no desenvolvimento de aplicações Java. Ela permite que executemos alguma ação logo após a inicialização de nossa aplicação. Pode ser muito útil, por exemplo, se quisermos carregar alguns dados em nosso banco de dados logo na inicialização de nossa aplicação.

## **Como funciona?**

Quando uma aplicação Spring Boot é lançada pode ocorrer várias operações automáticas, como a criação de beans, configuração de banco de dados entre outros. A abertura para customização destas operações é limitada, e é aqui que a interface CommandLineRunner entra em cena.

A interface CommandLineRunner representa uma tarefa a ser executada após a inicialização do Spring Boot, ou seja, permite definir código para ser executado automaticamente quando o aplicativo é iniciado.

## Como Usar?

A utilização é bem simples. Na própria classe principal da aplicação, podemos incluir para que se implemente a interface CommandLineRunner. Veja um exemplo:

@SpringBootApplication

public class ScreenMatchApplication implements CommandLineRunner {

@Override
public void run(String... args) throws Exception {
System.out.println("Olá, Mundo!");
}
}

Note que no exemplo acima, criamos uma classe chamada "MyCommandLineRunner" que implementa a Interface CommandLineRunner. No método "run" inserimos a ação que desejamos que seja executada logo depois que a aplicação for iniciada, nesse caso, apenas printamos "Olá, Mundo!".

## Quando Usar?

A Interface CommandLineRunner é bem versátil e pode ser usada em diversas situações. Conforme mencionado anteriormente, ela pode ser usada para carregar dados para um banco de dados. Também pode ser usada para iniciar recursos, como conexões de rede, e para checar a integridade de determinados componentes ou serviços com os quais a aplicação irá interagir.

É importante lembrar que a CommandLineRunner é executada apenas na inicialização da aplicação, então não deve ser utilizada para tarefas que precisam ocorrer periodicamente durante o funcionamento da aplicação, para isso, Spring oferece outras ferramentas que serão mais adequadas.

## Motivação

Vamos imaginar uma situação onde temos que carregar uma grande quantidade de dados em nosso banco de dados assim que nossa aplicação Spring iniciar. Bem, manualmente isso seria desafiador e demorado, no entanto, a interface CommandLineRunner torna essa tarefa extremamente mais simples.

Ao aprofundar seu conhecimento no Spring, você terá diversas opções para otimizar suas aplicações e tornar seu código mais limpo e eficaz. O Spring é um framework que facilita o desenvolvimento de aplicações em Java. Ele oferece um modelo de programação abrangente e simplificado, escondendo muitos dos detalhes de baixo nível. Como resultado, você pode se concentrar em escrever o seu código, sem se preocupar com uma infinidade de detalhes técnicos. Vamos mergulhar juntos nesse conhecimento!

## JsonAlias e JsonProperty

@JsonAlias e @JsonProperty são anotações em Jackson, uma biblioteca Java para processar JSON, que ajudam a mapear propriedades de classe para campos JSON.

No entanto, eles possuem funções diferentes. Vamos conhecer melhor cada uma dessas anotações?

### @JsonProperty

Essa anotação é usada para definir o nome da propriedade JSON que está associada ao campo Java.

Quando o JSON é serializado, isto é, convertido de objetos Java para JSON, o nome especificado em @JsonProperty será usado como a chave para o campo no JSON de saída. Da mesma forma, quando o JSON é desserializado (convertido de JSON para objetos Java), a biblioteca procura pelo nome especificado em @JsonProperty para mapear o valor JSON para o campo Java.

Então, se você quiser usar um nome diferente no JSON, pode usar o @JsonProperty(“nomeNoJson”). Isso é útil, por exemplo, quando você precisa trabalhar com um JSON que segue uma convenção de nomenclatura diferente da sua classe Java.

Por exemplo, se você tiver uma classe Java com a propriedade "nomeCompleto" e quiser que ela seja mapeada para o JSON como "nome", você pode usar o @JsonProperty("nome") para especificar o nome correto no JSON.

### @JsonAlias

O @JsonAlias é usado para definir um ou mais apelidos para o nome da propriedade JSON associada ao campo Java.

Ao desserializar, o @JsonAlias permite que a biblioteca encontre o valor JSON correspondente, mesmo que o nome da propriedade no JSON não corresponda exatamente ao nome do campo Java.

Isso é útil quando você está trabalhando com diferentes versões de um JSON ou quando deseja permitir que uma propriedade seja referenciada por nomes diferentes.

Por exemplo, se você tiver uma classe Java com a propriedade "nomeCompleto" e o JSON usa "nome" em vez disso, você pode usar o @JsonAlias("nome") para mapear corretamente a propriedade. Dessa forma, tanto "nomeCompleto" quanto "nome" serão aceitos ao fazer o mapeamento.

Documentação Jackson: https://github.com/FasterXML/jackson

## Generics

Em Java, generics permitem criar classes, interfaces e métodos que podem trabalhar com tipos desconhecidos ou parâmetros genéricos. Eles fornecem uma forma de escrever código flexível e reutilizável, tornando-o independente de tipos específicos e permitindo que ele funcione com diferentes tipos de dados.

Para criar um método ou classe genérico, você precisa usar parâmetros de tipo (tipos genéricos) que são representados entre colchetes angulares < >. Geralmente, usamos letras maiúsculas únicas para representar os tipos genéricos, mas você pode usar qualquer identificador válido em Java.