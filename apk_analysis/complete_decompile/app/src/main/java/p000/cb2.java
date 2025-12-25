package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class cb2 extends AtomicReference implements za2 {
    private static final long serialVersionUID = 1107649250281456395L;

    /* renamed from: a */
    public final int f8315a;

    /* renamed from: b */
    public int f8316b;

    /* renamed from: c */
    public volatile ya2 f8317c;

    /* renamed from: d */
    public ya2 f8318d;

    /* renamed from: e */
    public volatile boolean f8319e;

    public cb2(int i) {
        this.f8315a = i;
        ya2 ya2Var = new ya2(null);
        this.f8318d = ya2Var;
        this.f8317c = ya2Var;
    }

    @Override // p000.za2
    /* renamed from: a */
    public final void mo2075a(Object obj) {
        ya2 ya2Var = new ya2(obj);
        ya2 ya2Var2 = this.f8318d;
        this.f8318d = ya2Var;
        this.f8316b++;
        ya2Var2.lazySet(ya2Var);
        mo2077c();
        this.f8319e = true;
    }

    @Override // p000.za2
    public final void add(Object obj) {
        ya2 ya2Var = new ya2(obj);
        ya2 ya2Var2 = this.f8318d;
        this.f8318d = ya2Var;
        this.f8316b++;
        ya2Var2.set(ya2Var);
        int i = this.f8316b;
        if (i > this.f8315a) {
            this.f8316b = i - 1;
            this.f8317c = (ya2) this.f8317c.get();
        }
    }

    @Override // p000.za2
    /* renamed from: b */
    public final void mo2076b(ab2 ab2Var) {
        if (ab2Var.getAndIncrement() != 0) {
            return;
        }
        Observer observer = ab2Var.f110a;
        ya2 ya2Var = (ya2) ab2Var.f112c;
        if (ya2Var == null) {
            ya2Var = this.f8317c;
        }
        int i = 1;
        while (!ab2Var.f113d) {
            ya2 ya2Var2 = (ya2) ya2Var.get();
            if (ya2Var2 == null) {
                if (ya2Var.get() != null) {
                    continue;
                } else {
                    ab2Var.f112c = ya2Var;
                    i = ab2Var.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            } else {
                Object obj = ya2Var2.f28879a;
                if (this.f8319e && ya2Var2.get() == null) {
                    if (NotificationLite.isComplete(obj)) {
                        observer.onComplete();
                    } else {
                        observer.onError(NotificationLite.getError(obj));
                    }
                    ab2Var.f112c = null;
                    ab2Var.f113d = true;
                    return;
                }
                observer.onNext(obj);
                ya2Var = ya2Var2;
            }
        }
        ab2Var.f112c = null;
    }

    @Override // p000.za2
    /* renamed from: c */
    public final void mo2077c() {
        ya2 ya2Var = this.f8317c;
        if (ya2Var.f28879a != null) {
            ya2 ya2Var2 = new ya2(null);
            ya2Var2.lazySet(ya2Var.get());
            this.f8317c = ya2Var2;
        }
    }

    @Override // p000.za2
    /* renamed from: d */
    public final Object[] mo2078d(Object[] objArr) {
        ya2 ya2Var = this.f8317c;
        int size = size();
        if (size == 0) {
            if (objArr.length != 0) {
                objArr[0] = null;
            }
        } else {
            if (objArr.length < size) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
            }
            for (int i = 0; i != size; i++) {
                ya2Var = (ya2) ya2Var.get();
                objArr[i] = ya2Var.f28879a;
            }
            if (objArr.length > size) {
                objArr[size] = null;
            }
        }
        return objArr;
    }

    @Override // p000.za2
    public final Object getValue() {
        ya2 ya2Var = this.f8317c;
        ya2 ya2Var2 = null;
        while (true) {
            ya2 ya2Var3 = (ya2) ya2Var.get();
            if (ya2Var3 == null) {
                break;
            }
            ya2Var2 = ya2Var;
            ya2Var = ya2Var3;
        }
        Object obj = ya2Var.f28879a;
        if (obj == null) {
            return null;
        }
        if (!NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
            return obj;
        }
        return ya2Var2.f28879a;
    }

    @Override // p000.za2
    public final int size() {
        ya2 ya2Var = this.f8317c;
        int i = 0;
        while (i != Integer.MAX_VALUE) {
            ya2 ya2Var2 = (ya2) ya2Var.get();
            if (ya2Var2 == null) {
                Object obj = ya2Var.f28879a;
                if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
                    return i - 1;
                }
                return i;
            }
            i++;
            ya2Var = ya2Var2;
        }
        return i;
    }
}
