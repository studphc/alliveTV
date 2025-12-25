package io.reactivex.rxjava3.internal.functions;

import io.reactivex.rxjava3.functions.BiPredicate;
import p000.dx0;

/* loaded from: classes2.dex */
public final class ObjectHelper {

    /* renamed from: a */
    public static final dx0 f18523a = new dx0(21);

    public static <T> BiPredicate<T, T> equalsPredicate() {
        return f18523a;
    }

    public static int verifyPositive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }

    public static long verifyPositive(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j);
    }
}
