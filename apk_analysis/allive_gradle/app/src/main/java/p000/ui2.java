package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.Optional;

/* loaded from: classes2.dex */
public final class ui2 implements SingleObserver, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f27289a;

    /* renamed from: b */
    public final MaybeObserver f27290b;

    /* renamed from: c */
    public final Function f27291c;

    /* renamed from: d */
    public Disposable f27292d;

    public /* synthetic */ ui2(int i, MaybeObserver maybeObserver, Function function) {
        this.f27289a = i;
        this.f27290b = maybeObserver;
        this.f27291c = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f27289a) {
            case 0:
                this.f27292d.dispose();
                return;
            default:
                Disposable disposable = this.f27292d;
                this.f27292d = DisposableHelper.DISPOSED;
                disposable.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f27289a) {
            case 0:
                return this.f27292d.isDisposed();
            default:
                return this.f27292d.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        switch (this.f27289a) {
            case 0:
                this.f27290b.onError(th);
                return;
            default:
                this.f27290b.onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f27289a) {
            case 0:
                if (DisposableHelper.validate(this.f27292d, disposable)) {
                    this.f27292d = disposable;
                    this.f27290b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f27292d, disposable)) {
                    this.f27292d = disposable;
                    this.f27290b.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        boolean isPresent;
        Object obj2;
        switch (this.f27289a) {
            case 0:
                MaybeObserver maybeObserver = this.f27290b;
                try {
                    Object apply = this.f27291c.apply(obj);
                    Objects.requireNonNull(apply, "The selector returned a null Notification");
                    Notification notification = (Notification) apply;
                    if (notification.isOnNext()) {
                        maybeObserver.onSuccess(notification.getValue());
                        return;
                    } else if (notification.isOnComplete()) {
                        maybeObserver.onComplete();
                        return;
                    } else {
                        maybeObserver.onError(notification.getError());
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    maybeObserver.onError(th);
                    return;
                }
            default:
                MaybeObserver maybeObserver2 = this.f27290b;
                try {
                    Object apply2 = this.f27291c.apply(obj);
                    Objects.requireNonNull(apply2, "The mapper returned a null item");
                    Optional m5540h = ki0.m5540h(apply2);
                    isPresent = m5540h.isPresent();
                    if (isPresent) {
                        obj2 = m5540h.get();
                        maybeObserver2.onSuccess(obj2);
                        return;
                    } else {
                        maybeObserver2.onComplete();
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    maybeObserver2.onError(th2);
                    return;
                }
        }
    }
}
