package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Predicate;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public class AppendOnlyLinkedArrayList<T> {

    /* renamed from: a */
    public final int f19945a;

    /* renamed from: b */
    public final Object[] f19946b;

    /* renamed from: c */
    public Object[] f19947c;

    /* renamed from: d */
    public int f19948d;

    /* loaded from: classes2.dex */
    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.rxjava3.functions.Predicate
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int i) {
        this.f19945a = i;
        Object[] objArr = new Object[i + 1];
        this.f19946b = objArr;
        this.f19947c = objArr;
    }

    public <U> boolean accept(Subscriber<? super U> subscriber) {
        int i;
        Object[] objArr;
        Object[] objArr2 = this.f19946b;
        while (true) {
            int i2 = 0;
            if (objArr2 == null) {
                return false;
            }
            while (true) {
                i = this.f19945a;
                if (i2 < i && (objArr = objArr2[i2]) != null) {
                    if (NotificationLite.acceptFull(objArr, subscriber)) {
                        return true;
                    }
                    i2++;
                }
            }
            objArr2 = objArr2[i];
        }
    }

    public void add(T t) {
        int i = this.f19948d;
        int i2 = this.f19945a;
        if (i == i2) {
            Object[] objArr = new Object[i2 + 1];
            this.f19947c[i2] = objArr;
            this.f19947c = objArr;
            i = 0;
        }
        this.f19947c[i] = t;
        this.f19948d = i + 1;
    }

    public void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i;
        Object obj;
        Object[] objArr = this.f19946b;
        while (objArr != null) {
            int i2 = 0;
            while (true) {
                i = this.f19945a;
                if (i2 < i && (obj = objArr[i2]) != null) {
                    if (nonThrowingPredicate.test(obj)) {
                        return;
                    } else {
                        i2++;
                    }
                }
            }
            objArr = (Object[]) objArr[i];
        }
    }

    public void setFirst(T t) {
        this.f19946b[0] = t;
    }

    public <U> boolean accept(Observer<? super U> observer) {
        int i;
        Object[] objArr;
        Object[] objArr2 = this.f19946b;
        while (true) {
            int i2 = 0;
            if (objArr2 == null) {
                return false;
            }
            while (true) {
                i = this.f19945a;
                if (i2 < i && (objArr = objArr2[i2]) != null) {
                    if (NotificationLite.acceptFull(objArr, observer)) {
                        return true;
                    }
                    i2++;
                }
            }
            objArr2 = objArr2[i];
        }
    }

    public <S> void forEachWhile(S s, BiPredicate<? super S, ? super T> biPredicate) {
        int i;
        Object[] objArr = this.f19946b;
        while (true) {
            int i2 = 0;
            while (true) {
                i = this.f19945a;
                if (i2 < i) {
                    Object obj = objArr[i2];
                    if (obj == null || biPredicate.test(s, obj)) {
                        return;
                    } else {
                        i2++;
                    }
                }
            }
            objArr = (Object[]) objArr[i];
        }
    }
}
