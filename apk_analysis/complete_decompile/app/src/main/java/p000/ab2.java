package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ab2 extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = 466549804534799122L;

    /* renamed from: a */
    public final Observer f110a;

    /* renamed from: b */
    public final ReplaySubject f111b;

    /* renamed from: c */
    public Serializable f112c;

    /* renamed from: d */
    public volatile boolean f113d;

    public ab2(Observer observer, ReplaySubject replaySubject) {
        this.f110a = observer;
        this.f111b = replaySubject;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f113d) {
            this.f113d = true;
            this.f111b.m5325d(this);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f113d;
    }
}
