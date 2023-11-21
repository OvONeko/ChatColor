package io.github.elihuso.chatcolor.utils;

public class ColorHandleUtils {
    public static String HandleFormat(String s) {
        char[] charmap = s.toCharArray();
        int length = charmap.length;
        for (int i = 0; i < charmap.length; ++i) {
            if (charmap[i] == '&') {
                if (charmap[i + 1] != '&') {
                    charmap[i] = '§';
                }
                else {
                    for (int j = i; j < charmap.length - 1; ++j) {
                        charmap[j] = charmap[j + 1];
                    }
                    i += 1;
                    length -= 1;
                }
            }
        }
        char[] out = new char[length];
        System.arraycopy(charmap, 0, out, 0, length);
        return new String(out);
    }
}
