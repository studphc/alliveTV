package p000;

import com.google.firebase.Timestamp;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final /* synthetic */ class yt2 extends PropertyReference1Impl {

    /* renamed from: g */
    public static final yt2 f29132g = new PropertyReference1Impl(Timestamp.class, "seconds", "getSeconds()J", 0);

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public final Object get(Object obj) {
        return Long.valueOf(((Timestamp) obj).getSeconds());
    }
}
