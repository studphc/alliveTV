package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.BasicQueueDisposable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class fw1 extends BasicQueueDisposable {

    /* renamed from: a */
    public final Observer f17417a;

    /* renamed from: b */
    public final Object[] f17418b;

    /* renamed from: c */
    public int f17419c;

    /* renamed from: d */
    public boolean f17420d;

    /* renamed from: e */
    public volatile boolean f17421e;

    public fw1(Observer observer, Object[] objArr) {
        this.f17417a = observer;
        this.f17418b = objArr;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f17419c = this.f17418b.length;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f17421e = true;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17421e;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (this.f17419c == this.f17418b.length) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        int i = this.f17419c;
        Object[] objArr = this.f17418b;
        if (i != objArr.length) {
            this.f17419c = i + 1;
            Object obj = objArr[i];
            Objects.requireNonNull(obj, "The array element is null");
            return obj;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 1) != 0) {
            this.f17420d = true;
            return 1;
        }
        return 0;
    }
}
