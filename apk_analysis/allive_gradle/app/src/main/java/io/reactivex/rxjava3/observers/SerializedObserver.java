package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class SerializedObserver<T> implements Observer<T>, Disposable {

    /* renamed from: a */
    public final Observer f19985a;

    /* renamed from: b */
    public final boolean f19986b;

    /* renamed from: c */
    public Disposable f19987c;

    /* renamed from: d */
    public boolean f19988d;

    /* renamed from: e */
    public AppendOnlyLinkedArrayList f19989e;

    /* renamed from: f */
    public volatile boolean f19990f;

    public SerializedObserver(@NonNull Observer<? super T> observer) {
        this(observer, false);
    }

    /* renamed from: a */
    public final void m5304a() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.f19989e;
                    if (appendOnlyLinkedArrayList == null) {
                        this.f19988d = false;
                        return;
                    }
                    this.f19989e = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (!appendOnlyLinkedArrayList.accept(this.f19985a));
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        this.f19990f = true;
        this.f19987c.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.f19987c.isDisposed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (this.f19990f) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f19990f) {
                    return;
                }
                if (this.f19988d) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f19989e;
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList;
                    if (appendOnlyLinkedArrayList == null) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList3 = new AppendOnlyLinkedArrayList(4);
                        this.f19989e = appendOnlyLinkedArrayList3;
                        appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList3;
                    }
                    appendOnlyLinkedArrayList2.add(NotificationLite.complete());
                    return;
                }
                this.f19990f = true;
                this.f19988d = true;
                this.f19985a.onComplete();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(@NonNull Throwable th) {
        if (this.f19990f) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z = true;
                if (!this.f19990f) {
                    if (this.f19988d) {
                        this.f19990f = true;
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f19989e;
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList;
                        if (appendOnlyLinkedArrayList == null) {
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList3 = new AppendOnlyLinkedArrayList(4);
                            this.f19989e = appendOnlyLinkedArrayList3;
                            appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList3;
                        }
                        Object error = NotificationLite.error(th);
                        if (this.f19986b) {
                            appendOnlyLinkedArrayList2.add(error);
                        } else {
                            appendOnlyLinkedArrayList2.setFirst(error);
                        }
                        return;
                    }
                    this.f19990f = true;
                    this.f19988d = true;
                    z = false;
                }
                if (z) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.f19985a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(@NonNull T t) {
        if (this.f19990f) {
            return;
        }
        if (t == null) {
            this.f19987c.dispose();
            onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            return;
        }
        synchronized (this) {
            try {
                if (this.f19990f) {
                    return;
                }
                if (this.f19988d) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f19989e;
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList;
                    if (appendOnlyLinkedArrayList == null) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList3 = new AppendOnlyLinkedArrayList(4);
                        this.f19989e = appendOnlyLinkedArrayList3;
                        appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList3;
                    }
                    appendOnlyLinkedArrayList2.add(NotificationLite.next(t));
                    return;
                }
                this.f19988d = true;
                this.f19985a.onNext(t);
                m5304a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.f19987c, disposable)) {
            this.f19987c = disposable;
            this.f19985a.onSubscribe(this);
        }
    }

    public SerializedObserver(@NonNull Observer<? super T> observer, boolean z) {
        this.f19985a = observer;
        this.f19986b = z;
    }
}
