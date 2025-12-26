package androidx.core.util;

import android.annotation.SuppressLint;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public interface Predicate<T> {
    @SuppressLint({"MissingNullability"})
    Predicate<T> and(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate);

    @SuppressLint({"MissingNullability"})
    Predicate<T> negate();

    @SuppressLint({"MissingNullability"})
    /* renamed from: or */
    Predicate<T> mo897or(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate);

    boolean test(T t);
}
