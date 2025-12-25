package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes.dex */
public final class Ascii {
    public static final byte ACK = 6;
    public static final byte BEL = 7;

    /* renamed from: BS */
    public static final byte f14454BS = 8;
    public static final byte CAN = 24;

    /* renamed from: CR */
    public static final byte f14455CR = 13;
    public static final byte DC1 = 17;
    public static final byte DC2 = 18;
    public static final byte DC3 = 19;
    public static final byte DC4 = 20;
    public static final byte DEL = Byte.MAX_VALUE;
    public static final byte DLE = 16;

    /* renamed from: EM */
    public static final byte f14456EM = 25;
    public static final byte ENQ = 5;
    public static final byte EOT = 4;
    public static final byte ESC = 27;
    public static final byte ETB = 23;
    public static final byte ETX = 3;

    /* renamed from: FF */
    public static final byte f14457FF = 12;

    /* renamed from: FS */
    public static final byte f14458FS = 28;

    /* renamed from: GS */
    public static final byte f14459GS = 29;

    /* renamed from: HT */
    public static final byte f14460HT = 9;

    /* renamed from: LF */
    public static final byte f14461LF = 10;
    public static final char MAX = 127;
    public static final char MIN = 0;
    public static final byte NAK = 21;

    /* renamed from: NL */
    public static final byte f14462NL = 10;
    public static final byte NUL = 0;

    /* renamed from: RS */
    public static final byte f14463RS = 30;

    /* renamed from: SI */
    public static final byte f14464SI = 15;

    /* renamed from: SO */
    public static final byte f14465SO = 14;
    public static final byte SOH = 1;

    /* renamed from: SP */
    public static final byte f14466SP = 32;
    public static final byte SPACE = 32;
    public static final byte STX = 2;
    public static final byte SUB = 26;
    public static final byte SYN = 22;

    /* renamed from: US */
    public static final byte f14467US = 31;

    /* renamed from: VT */
    public static final byte f14468VT = 11;
    public static final byte XOFF = 19;
    public static final byte XON = 17;

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        char c;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i) && ((c = (char) ((r4 | ' ') - 97)) >= 26 || c != ((char) ((r5 | ' ') - 97)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static String toLowerCase(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (isUpperCase(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (isUpperCase(c)) {
                        charArray[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static String toUpperCase(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (isLowerCase(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (isLowerCase(c)) {
                        charArray[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static String truncate(CharSequence charSequence, int i, String str) {
        boolean z;
        Preconditions.checkNotNull(charSequence);
        int length = i - str.length();
        if (length >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "maxLength (%s) must be >= length of the truncation indicator (%s)", i, str.length());
        int length2 = charSequence.length();
        String str2 = charSequence;
        if (length2 <= i) {
            String charSequence2 = charSequence.toString();
            int length3 = charSequence2.length();
            str2 = charSequence2;
            if (length3 <= i) {
                return charSequence2;
            }
        }
        StringBuilder sb = new StringBuilder(i);
        sb.append((CharSequence) str2, 0, length);
        sb.append(str);
        return sb.toString();
    }

    public static String toLowerCase(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toLowerCase((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = toLowerCase(charSequence.charAt(i));
        }
        return String.valueOf(cArr);
    }

    public static String toUpperCase(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toUpperCase((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = toUpperCase(charSequence.charAt(i));
        }
        return String.valueOf(cArr);
    }

    public static char toLowerCase(char c) {
        return isUpperCase(c) ? (char) (c ^ ' ') : c;
    }

    public static char toUpperCase(char c) {
        return isLowerCase(c) ? (char) (c ^ ' ') : c;
    }
}
