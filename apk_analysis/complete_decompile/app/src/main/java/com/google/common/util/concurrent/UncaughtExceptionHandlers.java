package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.lang.Thread;
import p000.wz2;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class UncaughtExceptionHandlers {
    public static Thread.UncaughtExceptionHandler systemExit() {
        return new wz2(Runtime.getRuntime());
    }
}
