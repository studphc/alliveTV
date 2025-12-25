package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import org.jspecify.annotations.NullMarked;
import p000.o93;
import p000.p93;

@NullMarked
/* loaded from: classes.dex */
public abstract class zzak extends zzag implements List, RandomAccess {

    /* renamed from: b */
    public static final o93 f13743b = new o93(C0780a.f13734e, 0);

    /* renamed from: f */
    public static C0780a m3214f(int i, Object[] objArr) {
        if (i == 0) {
            return C0780a.f13734e;
        }
        return new C0780a(i, objArr);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [m93, com.google.android.gms.internal.common.zzah, java.lang.Object] */
    public static zzak zzj(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return zzk((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return C0780a.f13734e;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return zzm(next);
        }
        ?? obj = new Object();
        obj.f22857a = new Object[4];
        obj.f22858b = 0;
        obj.zzb(next);
        obj.zzc(it);
        obj.f22859c = true;
        return m3214f(obj.f22858b, obj.f22857a);
    }

    public static zzak zzk(Collection collection) {
        if (collection instanceof zzag) {
            zzak zzd = ((zzag) collection).zzd();
            if (zzd.mo3212d()) {
                Object[] array = zzd.toArray();
                return m3214f(array.length, array);
            }
            return zzd;
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzal.m3215a(length, array2);
        return m3214f(length, array2);
    }

    public static zzak zzl() {
        return C0780a.f13734e;
    }

    public static zzak zzm(Object obj) {
        Object[] objArr = {obj};
        zzal.m3215a(1, objArr);
        return m3214f(1, objArr);
    }

    public static zzak zzn(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzal.m3215a(2, objArr);
        return m3214f(2, objArr);
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* renamed from: a */
    public void mo3209a(Object[] objArr) {
        int size = size();
        for (int i = 0; i < size; i++) {
            objArr[i] = get(i);
        }
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (zzu.zza(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!it2.hasNext() || !zzu.zza(it.next(), it2.next())) {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.common.zzag, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.common.zzag
    @Deprecated
    public final zzak zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* renamed from: zze */
    public final zzan iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: zzh */
    public zzak subList(int i, int i2) {
        zzv.zzc(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return C0780a.f13734e;
        }
        return new p93(this, i, i3);
    }

    @Override // java.util.List
    /* renamed from: zzo, reason: merged with bridge method [inline-methods] */
    public final zzao listIterator(int i) {
        zzv.zzb(i, size(), FirebaseAnalytics.Param.INDEX);
        if (isEmpty()) {
            return f13743b;
        }
        return new o93(this, i);
    }
}
