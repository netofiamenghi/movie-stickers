import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinha {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

        var imagemOriginal = ImageIO.read(inputStream);

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 25;
        var novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        var graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 18);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        graphics.drawString("TOPZERA", 23, novaAltura - 7);

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }   
}