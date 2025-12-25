package p000;

import android.content.pm.PermissionInfo;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class j42 {
    @DoNotInline
    /* renamed from: a */
    public static int m5392a(PermissionInfo permissionInfo) {
        return permissionInfo.getProtection();
    }

    @DoNotInline
    /* renamed from: b */
    public static int m5393b(PermissionInfo permissionInfo) {
        return permissionInfo.getProtectionFlags();
    }
}
