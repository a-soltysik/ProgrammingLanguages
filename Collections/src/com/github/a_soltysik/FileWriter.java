package com.github.a_soltysik;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;

public class FileWriter {
    PrintWriter writer;

    public void open(String fileName, boolean append) throws FileNotFoundException {
        File file = new File(fileName);
        FileOutputStream outputStream = new FileOutputStream(file);
        writer = new PrintWriter(outputStream, append);
    }
    public void close() {
        writer.close();
    }

    public void write(String line) {
        writer.println(line);
    }

    public <T> void write(Collection<? extends T> collection) {
        writer.println(Utils.toString(collection));
    }

    public <K, V> void write(Map<? extends K, ? extends V> map) {
        writer.println(Utils.toString(map));
    }
}
