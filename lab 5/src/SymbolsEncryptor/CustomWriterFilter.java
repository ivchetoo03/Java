package SymbolsEncryptor;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CustomWriterFilter extends FilterWriter{
    
    char key;
    
    public CustomWriterFilter(Writer writer, char key){
        super(writer);
        this.key = key;
    }

    @Override
    public void write(int c) throws IOException{
        c += key;
        super.write(c);
    }
}
