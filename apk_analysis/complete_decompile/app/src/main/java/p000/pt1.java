package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class pt1 extends AtomicBoolean implements Observer, Disposable {
    private static final long serialVersionUID = -8223395059921494546L;

    /* renamed from: a */
    public final Observer f25286a;

    /* renamed from: b */
    public final int f25287b;

    /* renamed from: c */
    public final int f25288c;

    /* renamed from: d */
    public final Supplier f25289d;

    /* renamed from: e */
    public Disposable f25290e;

    /* renamed from: f */
    public final ArrayDeque f25291f = new ArrayDeque();

    /* renamed from: g */
    public long f25292g;

    public pt1(Observer observer, int i, int i2, Supplier supplier) {
        this.f25286a = observer;
        this.f25287b = i;
        this.f25288c = i2;
        this.f25289d = supplier;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f25290e.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f25290e.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        while (true) {
            ArrayDeque arrayDeque = this.f25291f;
            boolean isEmpty = arrayDeque.isEmpty();
            Observer observer = this.f25286a;
            if (!isEmpty) {
                observer.onNext(arrayDeque.poll());
            } else {
                observer.onComplete();
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f25291f.clear();
        this.f25286a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        long j = this.f25292g;
        this.f25292g = 1 + j;
        long j2 = j % this.f25288c;
        ArrayDeque arrayDeque = this.f25291f;
        Observer observer = this.f25286a;
        if (j2 == 0) {
            try {
                arrayDeque.offer((Collection) ExceptionHelper.nullCheck(this.f25289d.get(), "The bufferSupplier returned a null Collection."));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                arrayDeque.clear();
                this.f25290e.dispose();
                observer.onError(th);
                return;
            }
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            Collection collection = (Collection) it.next();
            collection.add(obj);
            if (this.f25287b <= collection.size()) {
                it.remove();
                observer.onNext(collection);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f25290e, disposable)) {
            this.f25290e = disposable;
            this.f25286a.onSubscribe(this);
        }
    }
}
