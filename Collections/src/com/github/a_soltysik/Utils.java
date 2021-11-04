package com.github.a_soltysik;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;

public class Utils {
    private Utils() {

    }
    public static <T> void writeToFile(String fileName, Collection<? extends T> collection, boolean append) throws FileNotFoundException {
        File file = new File(fileName);
        FileOutputStream outputStream = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(outputStream, append);

        writer.println(toString(collection));

        writer.close();
    }

    public static <K, V> void writeToFile(String fileName, Map<? extends K, ? extends V> map, boolean append) throws FileNotFoundException {
        File file = new File(fileName);
        FileOutputStream outputStream = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(outputStream, append);

        writer.println(toString(map));

        writer.close();
    }

    public static void deleteFile(String fileName) {
        new File(fileName).delete();
    }

    public static <K, V> String toString(Map<? extends K, ? extends V> map) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        var it = map.entrySet().iterator();
        while (it.hasNext()) {
            var pair = it.next();
            sb.append('[').append(pair.getKey()).append(", ").append(pair.getValue()).append(']');
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public static <T> String toString(Collection<T> collection) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        var it = collection.iterator();
        while (it.hasNext()) {
            var element = it.next();
            sb.append(element);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
