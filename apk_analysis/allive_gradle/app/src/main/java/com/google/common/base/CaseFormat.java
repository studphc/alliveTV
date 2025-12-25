package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import p000.AbstractC1726qj;
import p000.C1552ml;

@GwtCompatible
/* loaded from: classes.dex */
public enum CaseFormat {
    LOWER_HYPHEN(CharMatcher.m3759is('-'), "-"),
    LOWER_UNDERSCORE(CharMatcher.m3759is('_'), "_"),
    LOWER_CAMEL(CharMatcher.inRange('A', 'Z'), ""),
    UPPER_CAMEL(CharMatcher.inRange('A', 'Z'), ""),
    UPPER_UNDERSCORE(CharMatcher.m3759is('_'), "_");


    /* renamed from: a */
    public final CharMatcher f14470a;

    /* renamed from: b */
    public final String f14471b;

    CaseFormat(CharMatcher charMatcher, String str) {
        this.f14470a = charMatcher;
        this.f14471b = str;
    }

    /* renamed from: a */
    public static String m3752a(String str) {
        if (!str.isEmpty()) {
            char upperCase = Ascii.toUpperCase(str.charAt(0));
            String lowerCase = Ascii.toLowerCase(str.substring(1));
            StringBuilder sb = new StringBuilder(AbstractC1726qj.m7052h(1, lowerCase));
            sb.append(upperCase);
            sb.append(lowerCase);
            return sb.toString();
        }
        return str;
    }

    /* renamed from: b */
    public String mo3753b(CaseFormat caseFormat, String str) {
        StringBuilder sb = null;
        int i = 0;
        int i2 = -1;
        while (true) {
            i2 = this.f14470a.indexIn(str, i2 + 1);
            if (i2 == -1) {
                break;
            }
            if (i == 0) {
                sb = new StringBuilder((caseFormat.f14471b.length() * 4) + str.length());
                sb.append(caseFormat.mo3754c(str.substring(i, i2)));
            } else {
                java.util.Objects.requireNonNull(sb);
                sb.append(caseFormat.mo3755d(str.substring(i, i2)));
            }
            sb.append(caseFormat.f14471b);
            i = this.f14471b.length() + i2;
        }
        if (i == 0) {
            return caseFormat.mo3754c(str);
        }
        java.util.Objects.requireNonNull(sb);
        sb.append(caseFormat.mo3755d(str.substring(i)));
        return sb.toString();
    }

    /* renamed from: c */
    public String mo3754c(String str) {
        return mo3755d(str);
    }

    public Converter<String, String> converterTo(CaseFormat caseFormat) {
        return new C1552ml(this, caseFormat);
    }

    /* renamed from: d */
    public abstract String mo3755d(String str);

    /* renamed from: to */
    public final String m3756to(CaseFormat caseFormat, String str) {
        Preconditions.checkNotNull(caseFormat);
        Preconditions.checkNotNull(str);
        if (caseFormat != this) {
            return mo3753b(caseFormat, str);
        }
        return str;
    }
}
