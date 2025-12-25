package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.ProtocolViolationException;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class DisposableHelper implements Disposable {
    public static final DisposableHelper DISPOSED;

    /* renamed from: a */
    public static final /* synthetic */ DisposableHelper[] f18513a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, io.reactivex.rxjava3.internal.disposables.DisposableHelper] */
    static {
        ?? r1 = new Enum("DISPOSED", 0);
        DISPOSED = r1;
        f18513a = new DisposableHelper[]{r1};
    }

    public static boolean replace(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        while (true) {
            Disposable disposable2 = atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable != null) {
                    disposable.dispose();
                    return false;
                }
                return false;
            }
            while (!atomicReference.compareAndSet(disposable2, disposable)) {
                if (atomicReference.get() != disposable2) {
                    break;
                }
            }
            return true;
        }
    }

    public static void reportDisposableSet() {
        RxJavaPlugins.onError(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        while (true) {
            Disposable disposable2 = atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable != null) {
                    disposable.dispose();
                    return false;
                }
                return false;
            }
            while (!atomicReference.compareAndSet(disposable2, disposable)) {
                if (atomicReference.get() != disposable2) {
                    break;
                }
            }
            if (disposable2 != null) {
                disposable2.dispose();
                return true;
            }
            return true;
        }
    }

    public static boolean setOnce(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Objects.requireNonNull(disposable, "d is null");
        while (!atomicReference.compareAndSet(null, disposable)) {
            if (atomicReference.get() != null) {
                disposable.dispose();
                if (atomicReference.get() != DISPOSED) {
                    reportDisposableSet();
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    public static boolean trySet(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        while (!atomicReference.compareAndSet(null, disposable)) {
            if (atomicReference.get() != null) {
                if (atomicReference.get() == DISPOSED) {
                    disposable.dispose();
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    public static boolean validate(Disposable disposable, Disposable disposable2) {
        if (disposable2 == null) {
            RxJavaPlugins.onError(new NullPointerException("next is null"));
            return false;
        }
        if (disposable != null) {
            disposable2.dispose();
            reportDisposableSet();
            return false;
        }
        return true;
    }

    public static DisposableHelper valueOf(String str) {
        return (DisposableHelper) Enum.valueOf(DisposableHelper.class, str);
    }

    public static DisposableHelper[] values() {
        return (DisposableHelper[]) f18513a.clone();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    public static boolean dispose(AtomicReference<Disposable> atomicReference) {
        Disposable andSet;
        Disposable disposable = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (disposable == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean isDisposed(Disposable disposable) {
        return disposable == DISPOSED;
    }
}
