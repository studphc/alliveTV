package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.BasicQueueDisposable;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class iw1 extends BasicQueueDisposable {

    /* renamed from: a */
    public final Observer f20290a;

    /* renamed from: b */
    public final Iterator f20291b;

    /* renamed from: c */
    public volatile boolean f20292c;

    /* renamed from: d */
    public boolean f20293d;

    /* renamed from: e */
    public boolean f20294e;

    /* renamed from: f */
    public boolean f20295f;

    public iw1(Observer observer, Iterator it) {
        this.f20290a = observer;
        this.f20291b = it;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f20294e = true;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f20292c = true;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f20292c;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        return this.f20294e;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        if (this.f20294e) {
            return null;
        }
        boolean z = this.f20295f;
        Iterator it = this.f20291b;
        if (z) {
            if (!it.hasNext()) {
                this.f20294e = true;
                return null;
            }
        } else {
            this.f20295f = true;
        }
        Object next = it.next();
        Objects.requireNonNull(next, "The iterator returned a null value");
        return next;
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 1) != 0) {
            this.f20293d = true;
            return 1;
        }
        return 0;
    }
}
