package auxilio;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.input.SAXBuilder;
import org.jdom2.*;

/**
 *
 * @author livmm
 */
public class Dicionario {
    private final SAXBuilder builder;
    private ArrayList<File> arquivosXML;
    
    public ArrayList<String> palavras;
    
    public Dicionario(String diretorioDoDicionario)
    {
        palavras = new ArrayList<>();
        arquivosXML = new ArrayList<>();
        builder = new SAXBuilder();
        File directory;
        try {
            directory = new File(diretorioDoDicionario).getCanonicalFile();
            FilenameFilter filter = new FilenameFilterImpl();

            for (File f : directory.listFiles(filter)) {
                if (f.isFile()) {
                    arquivosXML.add(f);
                }
            }

        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
        
    }
    
    public void listaDePalavras(int tamanhoPalavras)
    {
        ArrayList<String> lista = new ArrayList<>();
        for(int i = 0; i < arquivosXML.size(); i++)
        {
            try {

		Document document = (Document) builder.build(arquivosXML.get(i));
		Element rootNode = document.getRootElement();
                
		List list = rootNode.getChildren("entry");
                
		for (int j = 0; j < list.size(); j++) {

		   Element node = (Element) list.get(j);
                   
                   if(node.getChild("form").getChildText("orth").length() == tamanhoPalavras)
                   {
//                       System.out.println("Palavra : " + node.getChild("form").getChildText("orth"));
                       lista.add(node.getChild("form").getChildText("orth").toLowerCase());
                   }
		}

            } catch (IOException | JDOMException err) {
                  System.out.println(err.getMessage());
            }
       }
                        
        palavras = lista;
    }
    
    private static class FilenameFilterImpl implements FilenameFilter {
        
        public FilenameFilterImpl() {
            
        }
        
        @Override
        public boolean accept(File arquivo, String nome) {
            return nome.toLowerCase().endsWith(".xml");
        }
    }
}
