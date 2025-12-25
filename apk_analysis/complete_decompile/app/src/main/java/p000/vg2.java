package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.Subject;

/* loaded from: classes2.dex */
public final class vg2 extends Subject implements AppendOnlyLinkedArrayList.NonThrowingPredicate {

    /* renamed from: a */
    public final Subject f27776a;

    /* renamed from: b */
    public boolean f27777b;

    /* renamed from: c */
    public AppendOnlyLinkedArrayList f27778c;

    /* renamed from: d */
    public volatile boolean f27779d;

    public vg2(Subject subject) {
        this.f27776a = subject;
    }

    /* renamed from: d */
    public final void m7911d() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.f27778c;
                    if (appendOnlyLinkedArrayList == null) {
                        this.f27777b = false;
                        return;
                    }
                    this.f27778c = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            appendOnlyLinkedArrayList.forEachWhile(this);
        }
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public final Throwable getThrowable() {
        return this.f27776a.getThrowable();
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public final boolean hasComplete() {
        return this.f27776a.hasComplete();
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public final boolean hasObservers() {
        return this.f27776a.hasObservers();
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public final boolean hasThrowable() {
        return this.f27776a.hasThrowable();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f27779d) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f27779d) {
                    return;
                }
                this.f27779d = true;
                if (this.f27777b) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f27778c;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                        this.f27778c = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.add(NotificationLite.complete());
                    return;
                }
                this.f27777b = true;
                this.f27776a.onComplete();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f27779d) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z = true;
                if (!this.f27779d) {
                    this.f27779d = true;
                    if (this.f27777b) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f27778c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                            this.f27778c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.setFirst(NotificationLite.error(th));
                        return;
                    }
                    this.f27777b = true;
                    z = false;
                }
                if (z) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.f27776a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f27779d) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f27779d) {
                    return;
                }
                if (this.f27777b) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f27778c;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                        this.f27778c = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.add(NotificationLite.next(obj));
                    return;
                }
                this.f27777b = true;
                this.f27776a.onNext(obj);
                m7911d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        boolean z = true;
        if (!this.f27779d) {
            synchronized (this) {
                try {
                    if (!this.f27779d) {
                        if (this.f27777b) {
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f27778c;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                                this.f27778c = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.add(NotificationLite.disposable(disposable));
                            return;
                        }
                        this.f27777b = true;
                        z = false;
                    }
                } finally {
                }
            }
        }
        if (z) {
            disposable.dispose();
        } else {
            this.f27776a.onSubscribe(disposable);
            m7911d();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public final void subscribeActual(Observer observer) {
        this.f27776a.subscribe(observer);
    }

    @Override // io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.rxjava3.functions.Predicate
    public final boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.f27776a);
    }
}
