package com.google.gson;

/* loaded from: classes2.dex */
public interface ReflectionAccessFilter {
    public static final ReflectionAccessFilter BLOCK_INACCESSIBLE_JAVA = new Object();
    public static final ReflectionAccessFilter BLOCK_ALL_JAVA = new Object();
    public static final ReflectionAccessFilter BLOCK_ALL_ANDROID = new Object();
    public static final ReflectionAccessFilter BLOCK_ALL_PLATFORM = new Object();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes2.dex */
    public static final class FilterResult {
        public static final FilterResult ALLOW;
        public static final FilterResult BLOCK_ALL;
        public static final FilterResult BLOCK_INACCESSIBLE;
        public static final FilterResult INDECISIVE;

        /* renamed from: a */
        public static final /* synthetic */ FilterResult[] f15714a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, com.google.gson.ReflectionAccessFilter$FilterResult] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, com.google.gson.ReflectionAccessFilter$FilterResult] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, com.google.gson.ReflectionAccessFilter$FilterResult] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, com.google.gson.ReflectionAccessFilter$FilterResult] */
        static {
            ?? r4 = new Enum("ALLOW", 0);
            ALLOW = r4;
            ?? r5 = new Enum("INDECISIVE", 1);
            INDECISIVE = r5;
            ?? r6 = new Enum("BLOCK_INACCESSIBLE", 2);
            BLOCK_INACCESSIBLE = r6;
            ?? r7 = new Enum("BLOCK_ALL", 3);
            BLOCK_ALL = r7;
            f15714a = new FilterResult[]{r4, r5, r6, r7};
        }

        public static FilterResult valueOf(String str) {
            return (FilterResult) Enum.valueOf(FilterResult.class, str);
        }

        public static FilterResult[] values() {
            return (FilterResult[]) f15714a.clone();
        }
    }

    FilterResult check(Class<?> cls);
}
