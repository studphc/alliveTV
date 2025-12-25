package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class ResourceCompletableObserver implements CompletableObserver, Disposable {

    /* renamed from: a */
    public final AtomicReference f19974a = new AtomicReference();

    /* renamed from: b */
    public final ListCompositeDisposable f19975b = new ListCompositeDisposable();

    public final void add(@NonNull Disposable disposable) {
        Objects.requireNonNull(disposable, "resource is null");
        this.f19975b.add(disposable);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (DisposableHelper.dispose(this.f19974a)) {
            this.f19975b.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f19974a.get());
    }

    public void onStart() {
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.setOnce((AtomicReference<Disposable>) this.f19974a, disposable, getClass())) {
            onStart();
        }
    }
}
