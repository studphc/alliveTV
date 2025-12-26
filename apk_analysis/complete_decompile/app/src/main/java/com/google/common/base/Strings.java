package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.dx0;
import p000.t42;

@GwtCompatible
/* loaded from: classes.dex */
public final class Strings {
    /* renamed from: a */
    public static boolean m3786a(int i, CharSequence charSequence) {
        if (i >= 0 && i <= charSequence.length() - 2 && Character.isHighSurrogate(charSequence.charAt(i)) && Character.isLowSurrogate(charSequence.charAt(i + 1))) {
            return true;
        }
        return false;
    }

    public static String commonPrefix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i = 0;
        while (i < min && charSequence.charAt(i) == charSequence2.charAt(i)) {
            i++;
        }
        int i2 = i - 1;
        if (m3786a(i2, charSequence) || m3786a(i2, charSequence2)) {
            i--;
        }
        return charSequence.subSequence(0, i).toString();
    }

    public static String commonSuffix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i = 0;
        while (i < min && charSequence.charAt((charSequence.length() - i) - 1) == charSequence2.charAt((charSequence2.length() - i) - 1)) {
            i++;
        }
        if (m3786a((charSequence.length() - i) - 1, charSequence) || m3786a((charSequence2.length() - i) - 1, charSequence2)) {
            i--;
        }
        return charSequence.subSequence(charSequence.length() - i, charSequence.length()).toString();
    }

    @CheckForNull
    public static String emptyToNull(@CheckForNull String str) {
        dx0 dx0Var = t42.f26692a;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static boolean isNullOrEmpty(@CheckForNull String str) {
        dx0 dx0Var = t42.f26692a;
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    public static String lenientFormat(@CheckForNull String str, @CheckForNull Object... objArr) {
        String str2;
        String sb;
        int indexOf;
        String valueOf = String.valueOf(str);
        int i = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                if (obj == null) {
                    sb = "null";
                } else {
                    try {
                        sb = obj.toString();
                    } catch (Exception e) {
                        String name = obj.getClass().getName();
                        String hexString = Integer.toHexString(System.identityHashCode(obj));
                        StringBuilder sb2 = new StringBuilder(AbstractC1726qj.m7052h(name.length() + 1, hexString));
                        sb2.append(name);
                        sb2.append('@');
                        sb2.append(hexString);
                        String sb3 = sb2.toString();
                        Logger logger = Logger.getLogger("com.google.common.base.Strings");
                        Level level = Level.WARNING;
                        String valueOf2 = String.valueOf(sb3);
                        if (valueOf2.length() != 0) {
                            str2 = "Exception during lenientFormat for ".concat(valueOf2);
                        } else {
                            str2 = new String("Exception during lenientFormat for ");
                        }
                        logger.log(level, str2, (Throwable) e);
                        String name2 = e.getClass().getName();
                        StringBuilder m7062r = AbstractC1726qj.m7062r(name2.length() + AbstractC1726qj.m7052h(9, sb3), "<", sb3, " threw ", name2);
                        m7062r.append(">");
                        sb = m7062r.toString();
                    }
                }
                objArr[i2] = sb;
            }
        }
        StringBuilder sb4 = new StringBuilder((objArr.length * 16) + valueOf.length());
        int i3 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf("%s", i3)) != -1) {
            sb4.append((CharSequence) valueOf, i3, indexOf);
            sb4.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb4.append((CharSequence) valueOf, i3, valueOf.length());
        if (i < objArr.length) {
            sb4.append(" [");
            sb4.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb4.append(", ");
                sb4.append(objArr[i4]);
            }
            sb4.append(']');
        }
        return sb4.toString();
    }

    public static String nullToEmpty(@CheckForNull String str) {
        dx0 dx0Var = t42.f26692a;
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String padEnd(String str, int i, char c) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        for (int length = str.length(); length < i; length++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String padStart(String str, int i, char c) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i);
        for (int length = str.length(); length < i; length++) {
            sb.append(c);
        }
        sb.append(str);
        return sb.toString();
    }

    public static String repeat(String str, int i) {
        Preconditions.checkNotNull(str);
        boolean z = false;
        if (i <= 1) {
            if (i >= 0) {
                z = true;
            }
            Preconditions.checkArgument(z, "invalid count: %s", i);
            if (i == 0) {
                return "";
            }
            return str;
        }
        int length = str.length();
        long j = length * i;
        int i2 = (int) j;
        if (i2 == j) {
            char[] cArr = new char[i2];
            str.getChars(0, length, cArr, 0);
            while (true) {
                int i3 = i2 - length;
                if (length < i3) {
                    System.arraycopy(cArr, 0, cArr, length, length);
                    length <<= 1;
                } else {
                    System.arraycopy(cArr, 0, cArr, length, i3);
                    return new String(cArr);
                }
            }
        } else {
            StringBuilder sb = new StringBuilder(51);
            sb.append("Required array size too large: ");
            sb.append(j);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
    }
}
