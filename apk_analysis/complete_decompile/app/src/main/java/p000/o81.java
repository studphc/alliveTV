package p000;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.SecureDirectoryStream;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class o81 {
    /* renamed from: A */
    public static /* bridge */ /* synthetic */ boolean m6492A(Object obj) {
        return obj instanceof SecureDirectoryStream;
    }

    /* renamed from: c */
    public static /* synthetic */ NotificationChannel m6498c(int i, String str, String str2) {
        return new NotificationChannel(str, str2, i);
    }

    /* renamed from: d */
    public static /* bridge */ /* synthetic */ NotificationChannel m6499d(Object obj) {
        return (NotificationChannel) obj;
    }

    /* renamed from: e */
    public static /* bridge */ /* synthetic */ NotificationChannelGroup m6500e(Object obj) {
        return (NotificationChannelGroup) obj;
    }

    /* renamed from: i */
    public static /* bridge */ /* synthetic */ DirectoryStream m6504i(Object obj) {
        return (DirectoryStream) obj;
    }

    /* renamed from: l */
    public static /* synthetic */ FileSystemException m6507l() {
        return new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
    }

    /* renamed from: v */
    public static /* synthetic */ void m6517v() {
    }
}
