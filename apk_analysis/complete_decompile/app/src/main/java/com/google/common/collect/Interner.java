package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Use Interners.new*Interner")
@GwtIncompatible
/* loaded from: classes.dex */
public interface Interner<E> {
    @CanIgnoreReturnValue
    E intern(E e);
}
