package androidx.activity;

import android.content.res.Resources;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: androidx.activity.a */
/* loaded from: classes.dex */
public final class C0074a extends Lambda implements Function1 {

    /* renamed from: b */
    public static final C0074a f524b = new Lambda(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        Resources resources = (Resources) obj;
        Intrinsics.checkNotNullParameter(resources, "resources");
        if ((resources.getConfiguration().uiMode & 48) == 32) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
