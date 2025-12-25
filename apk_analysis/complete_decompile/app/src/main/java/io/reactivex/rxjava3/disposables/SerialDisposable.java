package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import p000.g50;

/* loaded from: classes2.dex */
public final class SerialDisposable implements Disposable {

    /* renamed from: a */
    public final AtomicReference f18508a;

    public SerialDisposable() {
        this.f18508a = new AtomicReference();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.f18508a);
    }

    @Nullable
    public Disposable get() {
        Disposable disposable = (Disposable) this.f18508a.get();
        if (disposable == DisposableHelper.DISPOSED) {
            return g50.m4919a();
        }
        return disposable;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f18508a.get());
    }

    public boolean replace(@Nullable Disposable disposable) {
        return DisposableHelper.replace(this.f18508a, disposable);
    }

    public boolean set(@Nullable Disposable disposable) {
        return DisposableHelper.set(this.f18508a, disposable);
    }

    public SerialDisposable(@Nullable Disposable disposable) {
        this.f18508a = new AtomicReference(disposable);
    }
}
