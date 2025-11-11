package SymbolsEncryptor;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CustomReaderFilter extends FilterReader{
    
    char key;

    public CustomReaderFilter(Reader reader, char key){
        super(reader);
        this.key = key;
    }

    @Override
    public int read() throws IOException {
        int symbolAscii = super.read();
        symbolAscii -= key;
        return symbolAscii;
    }

}
