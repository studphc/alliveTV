package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class eb2 extends AtomicReference implements za2 {
    private static final long serialVersionUID = -733876083048047795L;

    /* renamed from: a */
    public final ArrayList f16752a;

    /* renamed from: b */
    public volatile boolean f16753b;

    /* renamed from: c */
    public volatile int f16754c;

    public eb2(int i) {
        this.f16752a = new ArrayList(i);
    }

    @Override // p000.za2
    /* renamed from: a */
    public final void mo2075a(Object obj) {
        this.f16752a.add(obj);
        this.f16754c++;
        this.f16753b = true;
    }

    @Override // p000.za2
    public final void add(Object obj) {
        this.f16752a.add(obj);
        this.f16754c++;
    }

    @Override // p000.za2
    /* renamed from: b */
    public final void mo2076b(ab2 ab2Var) {
        int i;
        int i2;
        if (ab2Var.getAndIncrement() != 0) {
            return;
        }
        ArrayList arrayList = this.f16752a;
        Observer observer = ab2Var.f110a;
        Integer num = (Integer) ab2Var.f112c;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
            ab2Var.f112c = 0;
        }
        int i3 = 1;
        while (!ab2Var.f113d) {
            int i4 = this.f16754c;
            while (i4 != i) {
                if (ab2Var.f113d) {
                    ab2Var.f112c = null;
                    return;
                }
                Object obj = arrayList.get(i);
                if (this.f16753b && (i2 = i + 1) == i4 && i2 == (i4 = this.f16754c)) {
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
                i++;
            }
            if (i == this.f16754c) {
                ab2Var.f112c = Integer.valueOf(i);
                i3 = ab2Var.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
        }
        ab2Var.f112c = null;
    }

    @Override // p000.za2
    /* renamed from: d */
    public final Object[] mo2078d(Object[] objArr) {
        int i = this.f16754c;
        if (i == 0) {
            if (objArr.length != 0) {
                objArr[0] = null;
            }
            return objArr;
        }
        ArrayList arrayList = this.f16752a;
        Object obj = arrayList.get(i - 1);
        if ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) && i - 1 == 0) {
            if (objArr.length != 0) {
                objArr[0] = null;
            }
            return objArr;
        }
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = arrayList.get(i2);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }

    @Override // p000.za2
    public final Object getValue() {
        int i = this.f16754c;
        if (i == 0) {
            return null;
        }
        ArrayList arrayList = this.f16752a;
        Object obj = arrayList.get(i - 1);
        if (!NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
            return obj;
        }
        if (i == 1) {
            return null;
        }
        return arrayList.get(i - 2);
    }

    @Override // p000.za2
    public final int size() {
        int i = this.f16754c;
        if (i != 0) {
            int i2 = i - 1;
            Object obj = this.f16752a.get(i2);
            if (!NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
                return i;
            }
            return i2;
        }
        return 0;
    }

    @Override // p000.za2
    /* renamed from: c */
    public final void mo2077c() {
    }
}
