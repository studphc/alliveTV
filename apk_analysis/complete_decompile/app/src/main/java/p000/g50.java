package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;
import java.util.concurrent.Future;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class g50 {
    /* renamed from: a */
    public static Disposable m4919a() {
        return EmptyDisposable.INSTANCE;
    }

    /* renamed from: b */
    public static Disposable m4920b() {
        return m4925g(Functions.EMPTY_RUNNABLE);
    }

    /* renamed from: c */
    public static Disposable m4921c(Action action) {
        Objects.requireNonNull(action, "action is null");
        return new i92(action);
    }

    /* renamed from: d */
    public static Disposable m4922d(AutoCloseable autoCloseable) {
        Objects.requireNonNull(autoCloseable, "autoCloseable is null");
        return new i92(autoCloseable);
    }

    /* renamed from: e */
    public static Disposable m4923e(Future future) {
        Objects.requireNonNull(future, "future is null");
        return m4924f(future, true);
    }

    /* renamed from: f */
    public static Disposable m4924f(Future future, boolean z) {
        Objects.requireNonNull(future, "future is null");
        return new dw0(future, z);
    }

    /* renamed from: g */
    public static Disposable m4925g(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return new i92(runnable);
    }

    /* renamed from: h */
    public static Disposable m4926h(Subscription subscription) {
        Objects.requireNonNull(subscription, "subscription is null");
        return new i92(subscription);
    }

    /* renamed from: i */
    public static AutoCloseable m4927i(final Disposable disposable) {
        Objects.requireNonNull(disposable, "disposable is null");
        return new AutoCloseable() { // from class: f50
            @Override // java.lang.AutoCloseable
            public final void close() {
                Disposable.this.dispose();
            }
        };
    }
}
