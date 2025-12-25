package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.operators.single.SingleContains;
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnError;
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnEvent;
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnTerminate;
import io.reactivex.rxjava3.internal.operators.single.SingleOnErrorReturn;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class xi1 implements SingleObserver {

    /* renamed from: a */
    public final /* synthetic */ int f28578a;

    /* renamed from: b */
    public final Object f28579b;

    /* renamed from: c */
    public final Object f28580c;

    public /* synthetic */ xi1(int i, Object obj, Object obj2) {
        this.f28578a = i;
        this.f28579b = obj;
        this.f28580c = obj2;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        Object apply;
        Object obj = this.f28580c;
        Object obj2 = this.f28579b;
        switch (this.f28578a) {
            case 0:
                ((MaybeObserver) obj).onError(th);
                return;
            case 1:
                ((SingleObserver) obj2).onError(th);
                return;
            case 2:
                ((SingleObserver) obj2).onError(th);
                return;
            case 3:
                try {
                    ((SingleDoOnError) obj).f19746b.accept(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    th = new CompositeException(th, th2);
                }
                ((SingleObserver) obj2).onError(th);
                return;
            case 4:
                try {
                    ((SingleDoOnEvent) obj).f19748b.accept(null, th);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    th = new CompositeException(th, th3);
                }
                ((SingleObserver) obj2).onError(th);
                return;
            case 5:
                ((SingleObserver) obj2).onError(th);
                return;
            case 6:
                try {
                    ((SingleDoOnTerminate) obj).f19757b.run();
                } catch (Throwable th4) {
                    Exceptions.throwIfFatal(th4);
                    th = new CompositeException(th, th4);
                }
                ((SingleObserver) obj2).onError(th);
                return;
            case 7:
                ((SingleObserver) obj).onError(th);
                return;
            case 8:
                ((SingleObserver) obj2).onError(th);
                return;
            default:
                SingleOnErrorReturn singleOnErrorReturn = (SingleOnErrorReturn) obj;
                Function function = singleOnErrorReturn.f19795b;
                SingleObserver singleObserver = (SingleObserver) obj2;
                if (function != null) {
                    try {
                        apply = function.apply(th);
                    } catch (Throwable th5) {
                        Exceptions.throwIfFatal(th5);
                        singleObserver.onError(new CompositeException(th, th5));
                        return;
                    }
                } else {
                    apply = singleOnErrorReturn.f19796c;
                }
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                    nullPointerException.initCause(th);
                    singleObserver.onError(nullPointerException);
                    return;
                }
                singleObserver.onSuccess(apply);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f28578a) {
            case 0:
                DisposableHelper.replace((wi1) this.f28579b, disposable);
                return;
            case 1:
                DisposableHelper.setOnce((lj1) this.f28580c, disposable);
                return;
            case 2:
                ((SingleObserver) this.f28579b).onSubscribe(disposable);
                return;
            case 3:
                ((SingleObserver) this.f28579b).onSubscribe(disposable);
                return;
            case 4:
                ((SingleObserver) this.f28579b).onSubscribe(disposable);
                return;
            case 5:
                ((SingleObserver) this.f28579b).onSubscribe(disposable);
                return;
            case 6:
                ((SingleObserver) this.f28579b).onSubscribe(disposable);
                return;
            case 7:
                DisposableHelper.replace((cj2) this.f28579b, disposable);
                return;
            case 8:
                ((SingleObserver) this.f28579b).onSubscribe(disposable);
                return;
            default:
                ((SingleObserver) this.f28579b).onSubscribe(disposable);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        switch (this.f28578a) {
            case 0:
                ((MaybeObserver) this.f28580c).onSuccess(obj);
                return;
            case 1:
                ((SingleObserver) this.f28579b).onSuccess(obj);
                return;
            case 2:
                SingleObserver singleObserver = (SingleObserver) this.f28579b;
                try {
                    SingleContains singleContains = (SingleContains) this.f28580c;
                    singleObserver.onSuccess(Boolean.valueOf(singleContains.f19718c.test(obj, singleContains.f19717b)));
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    singleObserver.onError(th);
                    return;
                }
            case 3:
                ((SingleObserver) this.f28579b).onSuccess(obj);
                return;
            case 4:
                SingleObserver singleObserver2 = (SingleObserver) this.f28579b;
                try {
                    ((SingleDoOnEvent) this.f28580c).f19748b.accept(obj, null);
                    singleObserver2.onSuccess(obj);
                    return;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    singleObserver2.onError(th2);
                    return;
                }
            case 5:
                SingleObserver singleObserver3 = (SingleObserver) this.f28579b;
                try {
                    ((SingleDoOnSuccess) this.f28580c).f19755b.accept(obj);
                    singleObserver3.onSuccess(obj);
                    return;
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    singleObserver3.onError(th3);
                    return;
                }
            case 6:
                SingleObserver singleObserver4 = (SingleObserver) this.f28579b;
                try {
                    ((SingleDoOnTerminate) this.f28580c).f19757b.run();
                    singleObserver4.onSuccess(obj);
                    return;
                } catch (Throwable th4) {
                    Exceptions.throwIfFatal(th4);
                    singleObserver4.onError(th4);
                    return;
                }
            case 7:
                ((SingleObserver) this.f28580c).onSuccess(obj);
                return;
            case 8:
                try {
                    Object apply = ((Function) this.f28580c).apply(obj);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    ((SingleObserver) this.f28579b).onSuccess(apply);
                    return;
                } catch (Throwable th5) {
                    Exceptions.throwIfFatal(th5);
                    onError(th5);
                    return;
                }
            default:
                ((SingleObserver) this.f28579b).onSuccess(obj);
                return;
        }
    }

    public /* synthetic */ xi1(Single single, SingleObserver singleObserver, int i) {
        this.f28578a = i;
        this.f28580c = single;
        this.f28579b = singleObserver;
    }
}
