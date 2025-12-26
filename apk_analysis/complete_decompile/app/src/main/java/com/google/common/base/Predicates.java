package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;
import p000.dx0;
import p000.e72;
import p000.f72;
import p000.g72;
import p000.h61;
import p000.t42;
import p000.t62;
import p000.u62;
import p000.w62;
import p000.x62;
import p000.y62;
import p000.z62;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class Predicates {
    /* renamed from: a */
    public static String m3775a(String str, Iterable iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z = true;
        for (Object obj : iterable) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysFalse() {
        return e72.f16699b;
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysTrue() {
        return e72.f16698a;
    }

    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> iterable) {
        return new t62(m3776b(iterable));
    }

    /* renamed from: b */
    public static ArrayList m3776b(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Preconditions.checkNotNull(it.next()));
        }
        return arrayList;
    }

    public static <A, B> Predicate<A> compose(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new u62(predicate, function);
    }

    @GwtIncompatible("java.util.regex.Pattern")
    public static Predicate<CharSequence> contains(Pattern pattern) {
        return new C0835d(new h61(pattern));
    }

    @GwtIncompatible
    public static Predicate<CharSequence> containsPattern(String str) {
        dx0 dx0Var = t42.f26692a;
        Preconditions.checkNotNull(str);
        t42.f26692a.getClass();
        return new C0835d(new h61(Pattern.compile(str)));
    }

    public static <T> Predicate<T> equalTo(T t) {
        if (t == null) {
            return isNull();
        }
        return new y62(t);
    }

    /* renamed from: in */
    public static <T> Predicate<T> m3777in(Collection<? extends T> collection) {
        return new w62(collection);
    }

    @GwtIncompatible
    public static <T> Predicate<T> instanceOf(Class<?> cls) {
        return new x62(cls);
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> isNull() {
        return e72.f16700c;
    }

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return new z62(predicate);
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> notNull() {
        return e72.f16701d;
    }

    /* renamed from: or */
    public static <T> Predicate<T> m3779or(Iterable<? extends Predicate<? super T>> iterable) {
        return new f72(m3776b(iterable));
    }

    @Beta
    @GwtIncompatible
    public static Predicate<Class<?>> subtypeOf(Class<?> cls) {
        return new g72(cls);
    }

    @SafeVarargs
    public static <T> Predicate<T> and(Predicate<? super T>... predicateArr) {
        return new t62(m3776b(Arrays.asList(predicateArr)));
    }

    @SafeVarargs
    /* renamed from: or */
    public static <T> Predicate<T> m3780or(Predicate<? super T>... predicateArr) {
        return new f72(m3776b(Arrays.asList(predicateArr)));
    }

    public static <T> Predicate<T> and(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new t62(Arrays.asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }

    /* renamed from: or */
    public static <T> Predicate<T> m3778or(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new f72(Arrays.asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }
}
