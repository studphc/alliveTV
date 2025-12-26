package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public final class hw1 extends DeferredScalarDisposable implements BiConsumer {
    private static final long serialVersionUID = 4665335664328839859L;

    /* renamed from: a */
    public final gw1 f18205a;

    public hw1(Observer observer, gw1 gw1Var) {
        super(observer);
        this.f18205a = gw1Var;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        Throwable th = (Throwable) obj2;
        if (th != null) {
            this.downstream.onError(th);
        } else if (obj != null) {
            complete(obj);
        } else {
            this.downstream.onError(new NullPointerException("The CompletionStage terminated with null."));
        }
    }

    @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable, io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        super.dispose();
        this.f18205a.set(null);
    }
}
