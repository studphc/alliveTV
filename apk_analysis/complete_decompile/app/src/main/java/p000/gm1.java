package p000;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;
import androidx.media.MediaSessionManager;

/* loaded from: classes.dex */
public class gm1 implements fm1 {

    /* renamed from: c */
    public static final boolean f17760c = MediaSessionManager.f6673b;

    /* renamed from: a */
    public Context f17761a;

    /* renamed from: b */
    public ContentResolver f17762b;

    public gm1(Context context) {
        this.f17761a = context;
        this.f17762b = context.getContentResolver();
        this.f17761a = context;
    }

    @Override // p000.fm1
    /* renamed from: a */
    public boolean mo4815a(km1 km1Var) {
        if (this.f17761a.checkPermission("android.permission.MEDIA_CONTENT_CONTROL", km1Var.f20898b, km1Var.f20899c) != 0) {
            boolean z = false;
            try {
                if (this.f17761a.getPackageManager().getApplicationInfo(km1Var.f20897a, 0) != null) {
                    if (!m4958b(km1Var, "android.permission.STATUS_BAR_SERVICE") && !m4958b(km1Var, "android.permission.MEDIA_CONTENT_CONTROL") && km1Var.f20899c != 1000) {
                        String string = Settings.Secure.getString(this.f17762b, "enabled_notification_listeners");
                        if (string != null) {
                            for (String str : string.split(":")) {
                                ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                                if (unflattenFromString == null || !unflattenFromString.getPackageName().equals(km1Var.f20897a)) {
                                }
                            }
                        }
                    }
                    z = true;
                    break;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                if (f17760c) {
                    Log.d("MediaSessionManager", "Package " + km1Var.f20897a + " doesn't exist");
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public final boolean m4958b(km1 km1Var, String str) {
        int i = km1Var.f20898b;
        if (i < 0) {
            if (this.f17761a.getPackageManager().checkPermission(str, km1Var.f20897a) != 0) {
                return false;
            }
            return true;
        }
        if (this.f17761a.checkPermission(str, i, km1Var.f20899c) != 0) {
            return false;
        }
        return true;
    }
}
