package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Service;

/* renamed from: com.google.common.util.concurrent.t */
/* loaded from: classes2.dex */
public final class C1020t {

    /* renamed from: a */
    public final Service.State f15426a;

    /* renamed from: b */
    public final boolean f15427b;

    /* renamed from: c */
    public final Throwable f15428c;

    public C1020t(Service.State state) {
        this(state, false, null);
    }

    public C1020t(Service.State state, boolean z, Throwable th) {
        Preconditions.checkArgument(!z || state == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
        Preconditions.checkArgument((th != null) == (state == Service.State.FAILED), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
        this.f15426a = state;
        this.f15427b = z;
        this.f15428c = th;
    }
}
