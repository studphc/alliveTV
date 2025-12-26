package p000;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class kw1 implements Emitter, Disposable {

    /* renamed from: a */
    public final Observer f22226a;

    /* renamed from: b */
    public final BiFunction f22227b;

    /* renamed from: c */
    public final Consumer f22228c;

    /* renamed from: d */
    public Object f22229d;

    /* renamed from: e */
    public volatile boolean f22230e;

    /* renamed from: f */
    public boolean f22231f;

    /* renamed from: g */
    public boolean f22232g;

    public kw1(Observer observer, BiFunction biFunction, Consumer consumer, Object obj) {
        this.f22226a = observer;
        this.f22227b = biFunction;
        this.f22228c = consumer;
        this.f22229d = obj;
    }

    /* renamed from: a */
    public final void m5797a(Object obj) {
        try {
            this.f22228c.accept(obj);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f22230e = true;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f22230e;
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onComplete() {
        if (!this.f22231f) {
            this.f22231f = true;
            this.f22226a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onError(Throwable th) {
        if (this.f22231f) {
            RxJavaPlugins.onError(th);
            return;
        }
        if (th == null) {
            th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
        }
        this.f22231f = true;
        this.f22226a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onNext(Object obj) {
        if (!this.f22231f) {
            if (this.f22232g) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (obj == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            } else {
                this.f22232g = true;
                this.f22226a.onNext(obj);
            }
        }
    }
}
