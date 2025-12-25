package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class tx1 extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = 2728361546769921047L;

    /* renamed from: a */
    public final yx1 f27012a;

    /* renamed from: b */
    public final Observer f27013b;

    /* renamed from: c */
    public Serializable f27014c;

    /* renamed from: d */
    public volatile boolean f27015d;

    public tx1(yx1 yx1Var, Observer observer) {
        this.f27012a = yx1Var;
        this.f27013b = observer;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f27015d) {
            this.f27015d = true;
            this.f27012a.m8331a(this);
            this.f27014c = null;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f27015d;
    }
}
