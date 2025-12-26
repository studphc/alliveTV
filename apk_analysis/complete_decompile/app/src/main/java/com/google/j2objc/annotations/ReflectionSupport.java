package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.PACKAGE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes2.dex */
public @interface ReflectionSupport {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes2.dex */
    public static final class Level {
        public static final Level FULL;
        public static final Level NATIVE_ONLY;

        /* renamed from: a */
        public static final /* synthetic */ Level[] f15793a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Enum, com.google.j2objc.annotations.ReflectionSupport$Level] */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, com.google.j2objc.annotations.ReflectionSupport$Level] */
        static {
            ?? r2 = new Enum("NATIVE_ONLY", 0);
            NATIVE_ONLY = r2;
            ?? r3 = new Enum("FULL", 1);
            FULL = r3;
            f15793a = new Level[]{r2, r3};
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) f15793a.clone();
        }
    }

    Level value();
}
