package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import p000.qw2;
import p000.rw2;

@Beta
@GwtCompatible
@Deprecated
/* loaded from: classes.dex */
public abstract class TreeTraverser<T> {
    @Deprecated
    public static <T> TreeTraverser<T> using(Function<T, ? extends Iterable<T>> function) {
        Preconditions.checkNotNull(function);
        return new qw2(function);
    }

    @Deprecated
    public final FluentIterable<T> breadthFirstTraversal(T t) {
        Preconditions.checkNotNull(t);
        return new rw2(this, t, 2);
    }

    public abstract Iterable<T> children(T t);

    @Deprecated
    public final FluentIterable<T> postOrderTraversal(T t) {
        Preconditions.checkNotNull(t);
        return new rw2(this, t, 1);
    }

    @Deprecated
    public final FluentIterable<T> preOrderTraversal(T t) {
        Preconditions.checkNotNull(t);
        return new rw2(this, t, 0);
    }
}
