package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributes;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class r32 {
    /* renamed from: f */
    public static /* bridge */ /* synthetic */ ComponentName m7194f(Context context, Intent intent) {
        return context.startForegroundService(intent);
    }

    /* renamed from: i */
    public static /* bridge */ /* synthetic */ IBinder m7197i(m61 m61Var) {
        return m61Var.getBinder();
    }

    /* renamed from: n */
    public static /* bridge */ /* synthetic */ Path m7202n(Object obj) {
        return (Path) obj;
    }

    /* renamed from: q */
    public static /* bridge */ /* synthetic */ SecureDirectoryStream m7205q(Object obj) {
        return (SecureDirectoryStream) obj;
    }

    /* renamed from: r */
    public static /* bridge */ /* synthetic */ BasicFileAttributes m7206r(Object obj) {
        return (BasicFileAttributes) obj;
    }
}
