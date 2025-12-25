package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class ArrayListSupplier implements Supplier<List<Object>>, Function<Object, List<Object>> {
    public static final ArrayListSupplier INSTANCE;

    /* renamed from: a */
    public static final /* synthetic */ ArrayListSupplier[] f19949a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, io.reactivex.rxjava3.internal.util.ArrayListSupplier] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        INSTANCE = r1;
        f19949a = new ArrayListSupplier[]{r1};
    }

    public static <T, O> Function<O, List<T>> asFunction() {
        return INSTANCE;
    }

    public static <T> Supplier<List<T>> asSupplier() {
        return INSTANCE;
    }

    public static ArrayListSupplier valueOf(String str) {
        return (ArrayListSupplier) Enum.valueOf(ArrayListSupplier.class, str);
    }

    public static ArrayListSupplier[] values() {
        return (ArrayListSupplier[]) f19949a.clone();
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public List<Object> apply(Object obj) {
        return new ArrayList();
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public List<Object> get() {
        return new ArrayList();
    }
}
