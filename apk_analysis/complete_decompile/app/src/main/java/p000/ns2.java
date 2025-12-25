package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class ns2 implements Observer {

    /* renamed from: a */
    public static final ns2 f23481a;

    /* renamed from: b */
    public static final /* synthetic */ ns2[] f23482b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, ns2] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f23481a = r1;
        f23482b = new ns2[]{r1};
    }

    public static ns2 valueOf(String str) {
        return (ns2) Enum.valueOf(ns2.class, str);
    }

    public static ns2[] values() {
        return (ns2[]) f23482b.clone();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
    }
}
