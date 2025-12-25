package p000;

import com.google.firebase.Timestamp;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final /* synthetic */ class zt2 extends PropertyReference1Impl {

    /* renamed from: g */
    public static final zt2 f29521g = new PropertyReference1Impl(Timestamp.class, "nanoseconds", "getNanoseconds()I", 0);

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public final Object get(Object obj) {
        return Integer.valueOf(((Timestamp) obj).getNanoseconds());
    }
}
