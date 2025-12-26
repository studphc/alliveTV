package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import p000.ye0;

/* loaded from: classes2.dex */
public class PreJava9DateFormatProvider {
    public static DateFormat getUSDateFormat(int i) {
        String str;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        str = "M/d/yy";
                    } else {
                        throw new IllegalArgumentException(ye0.m8291k(i, "Unknown DateFormat style: "));
                    }
                } else {
                    str = "MMM d, y";
                }
            } else {
                str = "MMMM d, y";
            }
        } else {
            str = "EEEE, MMMM d, y";
        }
        return new SimpleDateFormat(str, Locale.US);
    }

    public static DateFormat getUSDateTimeFormat(int i, int i2) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        str = "M/d/yy";
                    } else {
                        throw new IllegalArgumentException(ye0.m8291k(i, "Unknown DateFormat style: "));
                    }
                } else {
                    str = "MMM d, yyyy";
                }
            } else {
                str = "MMMM d, yyyy";
            }
        } else {
            str = "EEEE, MMMM d, yyyy";
        }
        sb.append(str);
        sb.append(" ");
        if (i2 != 0 && i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    str2 = "h:mm a";
                } else {
                    throw new IllegalArgumentException(ye0.m8291k(i2, "Unknown DateFormat style: "));
                }
            } else {
                str2 = "h:mm:ss a";
            }
        } else {
            str2 = "h:mm:ss a z";
        }
        sb.append(str2);
        return new SimpleDateFormat(sb.toString(), Locale.US);
    }
}
