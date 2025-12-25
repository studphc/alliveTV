package p000;

import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.DebugStringsKt;

/* loaded from: classes2.dex */
public final /* synthetic */ class pd1 extends PropertyReference0Impl {
    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
    public final Object get() {
        return DebugStringsKt.getClassSimpleName(this.receiver);
    }
}
