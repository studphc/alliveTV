package androidx.leanback.system;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.ShadowOverlayContainer;
import java.util.Iterator;
import p000.C1540m9;

/* loaded from: classes.dex */
public class Settings {
    public static final String OUTLINE_CLIPPING_DISABLED = "OUTLINE_CLIPPING_DISABLED";
    public static final String PREFER_STATIC_SHADOWS = "PREFER_STATIC_SHADOWS";

    /* renamed from: c */
    public static Settings f5477c;

    /* renamed from: a */
    public boolean f5478a;

    /* renamed from: b */
    public boolean f5479b;

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.leanback.system.Settings, java.lang.Object] */
    public static Settings getInstance(Context context) {
        if (f5477c == null) {
            ?? obj = new Object();
            PackageManager packageManager = context.getPackageManager();
            boolean z = false;
            Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(new Intent("android.support.v17.leanback.action.PARTNER_CUSTOMIZATION"), 0).iterator();
            C1540m9 c1540m9 = null;
            Resources resources = null;
            String str = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityInfo activityInfo = it.next().activityInfo;
                String str2 = activityInfo.packageName;
                if (str2 != null && (activityInfo.applicationInfo.flags & 1) != 0) {
                    try {
                        resources = packageManager.getResourcesForApplication(str2);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (resources != null) {
                    str = str2;
                    break;
                }
                str = str2;
            }
            if (resources != null) {
                c1540m9 = new C1540m9(21, false);
                c1540m9.f22854b = resources;
                c1540m9.f22855c = str;
            }
            if (ShadowOverlayContainer.supportsDynamicShadow()) {
                obj.f5478a = false;
                if (c1540m9 != null) {
                    String str3 = (String) c1540m9.f22855c;
                    Resources resources2 = (Resources) c1540m9.f22854b;
                    int identifier = resources2.getIdentifier("leanback_prefer_static_shadows", "bool", str3);
                    if (identifier > 0) {
                        z = resources2.getBoolean(identifier);
                    }
                    obj.f5478a = z;
                }
            } else {
                obj.f5478a = true;
            }
            boolean isLowRamDevice = ((ActivityManager) context.getSystemService("activity")).isLowRamDevice();
            obj.f5479b = isLowRamDevice;
            if (c1540m9 != null) {
                String str4 = (String) c1540m9.f22855c;
                Resources resources3 = (Resources) c1540m9.f22854b;
                int identifier2 = resources3.getIdentifier("leanback_outline_clipping_disabled", "bool", str4);
                if (identifier2 > 0) {
                    isLowRamDevice = resources3.getBoolean(identifier2);
                }
                obj.f5479b = isLowRamDevice;
            }
            f5477c = obj;
        }
        return f5477c;
    }

    /* renamed from: a */
    public final boolean m1370a(String str, boolean z, boolean z2) {
        if (str.compareTo(PREFER_STATIC_SHADOWS) == 0) {
            if (z) {
                this.f5478a = z2;
                return z2;
            }
            return this.f5478a;
        }
        if (str.compareTo(OUTLINE_CLIPPING_DISABLED) == 0) {
            if (z) {
                this.f5479b = z2;
                return z2;
            }
            return this.f5479b;
        }
        throw new IllegalArgumentException("Invalid key");
    }

    public boolean getBoolean(String str) {
        return m1370a(str, false, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOutlineClippingDisabled() {
        return this.f5479b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean preferStaticShadows() {
        return this.f5478a;
    }

    public void setBoolean(String str, boolean z) {
        m1370a(str, true, z);
    }
}
