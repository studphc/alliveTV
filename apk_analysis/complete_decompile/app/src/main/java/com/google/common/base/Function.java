package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

@GwtCompatible
/* loaded from: classes.dex */
public interface Function<F, T> {
    @CanIgnoreReturnValue
    T apply(F f);

    boolean equals(@CheckForNull Object obj);
}
