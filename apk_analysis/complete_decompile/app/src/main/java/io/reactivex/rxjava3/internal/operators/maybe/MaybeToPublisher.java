package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class MaybeToPublisher implements Function<MaybeSource<Object>, Publisher<Object>> {
    public static final MaybeToPublisher INSTANCE;

    /* renamed from: a */
    public static final /* synthetic */ MaybeToPublisher[] f19218a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, io.reactivex.rxjava3.internal.operators.maybe.MaybeToPublisher] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        INSTANCE = r1;
        f19218a = new MaybeToPublisher[]{r1};
    }

    public static <T> Function<MaybeSource<T>, Publisher<T>> instance() {
        return INSTANCE;
    }

    public static MaybeToPublisher valueOf(String str) {
        return (MaybeToPublisher) Enum.valueOf(MaybeToPublisher.class, str);
    }

    public static MaybeToPublisher[] values() {
        return (MaybeToPublisher[]) f19218a.clone();
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public Publisher<Object> apply(MaybeSource<Object> maybeSource) {
        return new MaybeToFlowable(maybeSource);
    }
}
