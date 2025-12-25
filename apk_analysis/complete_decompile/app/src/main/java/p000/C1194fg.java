package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

/* renamed from: fg */
/* loaded from: classes2.dex */
public final class C1194fg implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate {

    /* renamed from: a */
    public final Observer f17247a;

    /* renamed from: b */
    public final BehaviorSubject f17248b;

    /* renamed from: c */
    public boolean f17249c;

    /* renamed from: d */
    public boolean f17250d;

    /* renamed from: e */
    public AppendOnlyLinkedArrayList f17251e;

    /* renamed from: f */
    public boolean f17252f;

    /* renamed from: g */
    public volatile boolean f17253g;

    /* renamed from: h */
    public long f17254h;

    public C1194fg(Observer observer, BehaviorSubject behaviorSubject) {
        this.f17247a = observer;
        this.f17248b = behaviorSubject;
    }

    /* renamed from: a */
    public final void m4807a() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        while (!this.f17253g) {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.f17251e;
                    if (appendOnlyLinkedArrayList == null) {
                        this.f17250d = false;
                        return;
                    }
                    this.f17251e = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            appendOnlyLinkedArrayList.forEachWhile(this);
        }
    }

    /* renamed from: b */
    public final void m4808b(Object obj, long j) {
        if (this.f17253g) {
            return;
        }
        if (!this.f17252f) {
            synchronized (this) {
                try {
                    if (this.f17253g) {
                        return;
                    }
                    if (this.f17254h == j) {
                        return;
                    }
                    if (this.f17250d) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f17251e;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                            this.f17251e = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(obj);
                        return;
                    }
                    this.f17249c = true;
                    this.f17252f = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        test(obj);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f17253g) {
            this.f17253g = true;
            this.f17248b.m5321d(this);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17253g;
    }

    @Override // io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.rxjava3.functions.Predicate
    public final boolean test(Object obj) {
        if (!this.f17253g && !NotificationLite.accept(obj, this.f17247a)) {
            return false;
        }
        return true;
    }
}
