package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Message;
import androidx.annotation.NonNull;
import p000.on1;

/* loaded from: classes.dex */
public final class MessageCompat {
    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message message) {
        return on1.m6712a(message);
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message message, boolean z) {
        on1.m6713b(message, z);
    }
}
