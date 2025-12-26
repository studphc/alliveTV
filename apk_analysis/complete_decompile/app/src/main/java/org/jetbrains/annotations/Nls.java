package org.jetbrains.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE, ElementType.TYPE, ElementType.PACKAGE})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes2.dex */
public @interface Nls {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes2.dex */
    public static final class Capitalization {
        public static final Capitalization NotSpecified;
        public static final Capitalization Sentence;
        public static final Capitalization Title;

        /* renamed from: a */
        public static final /* synthetic */ Capitalization[] f24891a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, org.jetbrains.annotations.Nls$Capitalization] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, org.jetbrains.annotations.Nls$Capitalization] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, org.jetbrains.annotations.Nls$Capitalization] */
        static {
            ?? r3 = new Enum("NotSpecified", 0);
            NotSpecified = r3;
            ?? r4 = new Enum("Title", 1);
            Title = r4;
            ?? r5 = new Enum("Sentence", 2);
            Sentence = r5;
            f24891a = new Capitalization[]{r3, r4, r5};
        }

        public static Capitalization valueOf(String str) {
            return (Capitalization) Enum.valueOf(Capitalization.class, str);
        }

        public static Capitalization[] values() {
            return (Capitalization[]) f24891a.clone();
        }
    }

    Capitalization capitalization() default Capitalization.NotSpecified;
}
