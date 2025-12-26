package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

@GwtCompatible
/* loaded from: classes.dex */
public interface Predicate<T> {
    @CanIgnoreReturnValue
    boolean apply(T t);

    boolean equals(@CheckForNull Object obj);
}
