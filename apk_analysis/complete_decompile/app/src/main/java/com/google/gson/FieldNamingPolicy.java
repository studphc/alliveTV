package com.google.gson;

import com.google.gson.FieldNamingPolicy;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public abstract class FieldNamingPolicy implements FieldNamingStrategy {
    public static final FieldNamingPolicy IDENTITY;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DOTS;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES;
    public static final FieldNamingPolicy UPPER_CASE_WITH_UNDERSCORES;

    /* renamed from: a */
    public static final /* synthetic */ FieldNamingPolicy[] f15659a;

    static {
        FieldNamingPolicy fieldNamingPolicy = new FieldNamingPolicy() { // from class: ec0
            @Override // com.google.gson.FieldNamingStrategy
            public final String translateName(Field field) {
                return field.getName();
            }
        };
        IDENTITY = fieldNamingPolicy;
        FieldNamingPolicy fieldNamingPolicy2 = new FieldNamingPolicy() { // from class: fc0
            @Override // com.google.gson.FieldNamingStrategy
            public final String translateName(Field field) {
                return FieldNamingPolicy.m4410b(field.getName());
            }
        };
        UPPER_CAMEL_CASE = fieldNamingPolicy2;
        FieldNamingPolicy fieldNamingPolicy3 = new FieldNamingPolicy() { // from class: gc0
            @Override // com.google.gson.FieldNamingStrategy
            public final String translateName(Field field) {
                return FieldNamingPolicy.m4410b(FieldNamingPolicy.m4409a(field.getName(), ' '));
            }
        };
        UPPER_CAMEL_CASE_WITH_SPACES = fieldNamingPolicy3;
        FieldNamingPolicy fieldNamingPolicy4 = new FieldNamingPolicy() { // from class: hc0
            @Override // com.google.gson.FieldNamingStrategy
            public final String translateName(Field field) {
                return FieldNamingPolicy.m4409a(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        };
        UPPER_CASE_WITH_UNDERSCORES = fieldNamingPolicy4;
        FieldNamingPolicy fieldNamingPolicy5 = new FieldNamingPolicy() { // from class: ic0
            @Override // com.google.gson.FieldNamingStrategy
            public final String translateName(Field field) {
                return FieldNamingPolicy.m4409a(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_UNDERSCORES = fieldNamingPolicy5;
        FieldNamingPolicy fieldNamingPolicy6 = new FieldNamingPolicy() { // from class: jc0
            @Override // com.google.gson.FieldNamingStrategy
            public final String translateName(Field field) {
                return FieldNamingPolicy.m4409a(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DASHES = fieldNamingPolicy6;
        FieldNamingPolicy fieldNamingPolicy7 = new FieldNamingPolicy() { // from class: kc0
            @Override // com.google.gson.FieldNamingStrategy
            public final String translateName(Field field) {
                return FieldNamingPolicy.m4409a(field.getName(), '.').toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DOTS = fieldNamingPolicy7;
        f15659a = new FieldNamingPolicy[]{fieldNamingPolicy, fieldNamingPolicy2, fieldNamingPolicy3, fieldNamingPolicy4, fieldNamingPolicy5, fieldNamingPolicy6, fieldNamingPolicy7};
    }

    /* renamed from: a */
    public static String m4409a(String str, char c) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(c);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m4410b(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isLetter(charAt)) {
                if (Character.isUpperCase(charAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(charAt);
                if (i == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i) + upperCase + str.substring(i + 1);
            }
        }
        return str;
    }

    public static FieldNamingPolicy valueOf(String str) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, str);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) f15659a.clone();
    }
}
