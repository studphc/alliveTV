package p000;

import android.os.StrictMode;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class x93 {
    @DoNotInline
    /* renamed from: a */
    public static StrictMode.VmPolicy.Builder m8153a(StrictMode.VmPolicy.Builder builder) {
        StrictMode.VmPolicy.Builder permitUnsafeIntentLaunch;
        permitUnsafeIntentLaunch = builder.permitUnsafeIntentLaunch();
        return permitUnsafeIntentLaunch;
    }
}
