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
