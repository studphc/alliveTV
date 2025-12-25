package org.checkerframework.dataflow.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface Pure {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes2.dex */
    public static final class Kind {
        public static final Kind DETERMINISTIC;
        public static final Kind SIDE_EFFECT_FREE;

        /* renamed from: a */
        public static final /* synthetic */ Kind[] f24887a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [org.checkerframework.dataflow.qual.Pure$Kind, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r3v1, types: [org.checkerframework.dataflow.qual.Pure$Kind, java.lang.Enum] */
        static {
            ?? r2 = new Enum("SIDE_EFFECT_FREE", 0);
            SIDE_EFFECT_FREE = r2;
            ?? r3 = new Enum("DETERMINISTIC", 1);
            DETERMINISTIC = r3;
            f24887a = new Kind[]{r2, r3};
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) f24887a.clone();
        }
    }
}
