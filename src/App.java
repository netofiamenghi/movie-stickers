import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    
    public static void main(String[] args) throws Exception {

        // var extrator = new ExtratorDeConteudoDaNasa();
        // String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";

        var extrator = new ExtratorDeConteudoDoImdb();
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";

        var http = new ClienteHttp();
        var json = http.buscaDados(url);

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinha();
        for (Conteudo conteudo : conteudos) {

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
            break;
        }
    }
}
