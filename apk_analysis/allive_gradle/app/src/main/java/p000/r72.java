package p000;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;

/* loaded from: classes.dex */
public abstract class r72 {
    /* renamed from: a */
    public static PackageInfo m7227a(PackageManager packageManager, Context context) {
        return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
    }

    /* renamed from: b */
    public static void m7228b(ShortcutInfo.Builder builder, int i) {
        builder.setExcludedFromSurfaces(i);
    }
}
