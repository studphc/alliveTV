package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Locale;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public final class UrlTemplate {

    /* renamed from: a */
    public final String[] f11350a;

    /* renamed from: b */
    public final int[] f11351b;

    /* renamed from: c */
    public final String[] f11352c;

    /* renamed from: d */
    public final int f11353d;

    public UrlTemplate(String[] strArr, int[] iArr, String[] strArr2, int i) {
        this.f11350a = strArr;
        this.f11351b = iArr;
        this.f11352c = strArr2;
        this.f11353d = i;
    }

    public static UrlTemplate compile(String str) {
        String str2;
        char c;
        int i = -1;
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        strArr[0] = "";
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int indexOf = str.indexOf("$", i2);
            if (indexOf == i) {
                strArr[i3] = strArr[i3] + str.substring(i2);
                i2 = str.length();
            } else if (indexOf != i2) {
                strArr[i3] = strArr[i3] + str.substring(i2, indexOf);
                i2 = indexOf;
            } else if (str.startsWith("$$", i2)) {
                strArr[i3] = AbstractC1726qj.m7061q(new StringBuilder(), strArr[i3], "$");
                i2 += 2;
            } else {
                int i4 = i2 + 1;
                int indexOf2 = str.indexOf("$", i4);
                String substring = str.substring(i4, indexOf2);
                if (substring.equals("RepresentationID")) {
                    iArr[i3] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != i) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d") && !str2.endsWith("x") && !str2.endsWith("X")) {
                            str2 = str2.concat("d");
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    substring.getClass();
                    switch (substring.hashCode()) {
                        case -1950496919:
                            if (substring.equals("Number")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 2606829:
                            if (substring.equals("Time")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 38199441:
                            if (substring.equals("Bandwidth")) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    c = 65535;
                    switch (c) {
                        case 0:
                            iArr[i3] = 2;
                            break;
                        case 1:
                            iArr[i3] = 4;
                            break;
                        case 2:
                            iArr[i3] = 3;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: ".concat(str));
                    }
                    strArr2[i3] = str2;
                }
                i3++;
                strArr[i3] = "";
                i2 = indexOf2 + 1;
            }
            i = -1;
        }
        return new UrlTemplate(strArr, iArr, strArr2, i3);
    }

    public String buildUri(String str, long j, int i, long j2) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            String[] strArr = this.f11350a;
            int i3 = this.f11353d;
            if (i2 < i3) {
                sb.append(strArr[i2]);
                int i4 = this.f11351b[i2];
                if (i4 == 1) {
                    sb.append(str);
                } else {
                    String[] strArr2 = this.f11352c;
                    if (i4 == 2) {
                        sb.append(String.format(Locale.US, strArr2[i2], Long.valueOf(j)));
                    } else if (i4 == 3) {
                        sb.append(String.format(Locale.US, strArr2[i2], Integer.valueOf(i)));
                    } else if (i4 == 4) {
                        sb.append(String.format(Locale.US, strArr2[i2], Long.valueOf(j2)));
                    }
                }
                i2++;
            } else {
                sb.append(strArr[i3]);
                return sb.toString();
            }
        }
    }
}
