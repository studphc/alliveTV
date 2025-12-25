package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.Supplier;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class HashMapSupplier implements Supplier<Map<Object, Object>> {
    public static final HashMapSupplier INSTANCE;

    /* renamed from: a */
    public static final /* synthetic */ HashMapSupplier[] f19952a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, io.reactivex.rxjava3.internal.util.HashMapSupplier] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        INSTANCE = r1;
        f19952a = new HashMapSupplier[]{r1};
    }

    public static <K, V> Supplier<Map<K, V>> asSupplier() {
        return INSTANCE;
    }

    public static HashMapSupplier valueOf(String str) {
        return (HashMapSupplier) Enum.valueOf(HashMapSupplier.class, str);
    }

    public static HashMapSupplier[] values() {
        return (HashMapSupplier[]) f19952a.clone();
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public Map<Object, Object> get() {
        return new HashMap();
    }
}
