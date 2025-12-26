package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.BiFunction;
import java.util.List;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class ListAddBiConsumer implements BiFunction<List, Object, List> {
    public static final ListAddBiConsumer INSTANCE;

    /* renamed from: a */
    public static final /* synthetic */ ListAddBiConsumer[] f19958a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [io.reactivex.rxjava3.internal.util.ListAddBiConsumer, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        INSTANCE = r1;
        f19958a = new ListAddBiConsumer[]{r1};
    }

    public static <T> BiFunction<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    public static ListAddBiConsumer valueOf(String str) {
        return (ListAddBiConsumer) Enum.valueOf(ListAddBiConsumer.class, str);
    }

    public static ListAddBiConsumer[] values() {
        return (ListAddBiConsumer[]) f19958a.clone();
    }

    @Override // io.reactivex.rxjava3.functions.BiFunction
    public List apply(List list, Object obj) {
        list.add(obj);
        return list;
    }
}
