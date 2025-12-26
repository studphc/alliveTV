package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.function.BiConsumer;

/* renamed from: os */
/* loaded from: classes2.dex */
public final class C1661os implements Disposable, BiConsumer {

    /* renamed from: a */
    public final /* synthetic */ int f24892a;

    /* renamed from: b */
    public final jm0 f24893b;

    /* renamed from: c */
    public final Object f24894c;

    public /* synthetic */ C1661os(Object obj, jm0 jm0Var, int i) {
        this.f24892a = i;
        this.f24894c = obj;
        this.f24893b = jm0Var;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f24892a) {
            case 0:
                Throwable th = (Throwable) obj2;
                if (th != null) {
                    ((CompletableObserver) this.f24894c).onError(th);
                    return;
                } else {
                    ((CompletableObserver) this.f24894c).onComplete();
                    return;
                }
            case 1:
                Throwable th2 = (Throwable) obj2;
                if (th2 != null) {
                    ((MaybeObserver) this.f24894c).onError(th2);
                    return;
                } else if (obj != null) {
                    ((MaybeObserver) this.f24894c).onSuccess(obj);
                    return;
                } else {
                    ((MaybeObserver) this.f24894c).onComplete();
                    return;
                }
            default:
                Throwable th3 = (Throwable) obj2;
                if (th3 != null) {
                    ((SingleObserver) this.f24894c).onError(th3);
                    return;
                } else if (obj != null) {
                    ((SingleObserver) this.f24894c).onSuccess(obj);
                    return;
                } else {
                    ((SingleObserver) this.f24894c).onError(new NullPointerException("The CompletionStage terminated with null."));
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f24892a) {
            case 0:
                this.f24893b.set(null);
                return;
            case 1:
                this.f24893b.set(null);
                return;
            default:
                this.f24893b.set(null);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f24892a) {
            case 0:
                if (this.f24893b.get() == null) {
                    return true;
                }
                return false;
            case 1:
                if (this.f24893b.get() == null) {
                    return true;
                }
                return false;
            default:
                if (this.f24893b.get() == null) {
                    return true;
                }
                return false;
        }
    }
}
