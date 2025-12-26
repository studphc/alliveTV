package p000;

import android.os.Message;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class on1 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m6712a(Message message) {
        return message.isAsynchronous();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m6713b(Message message, boolean z) {
        message.setAsynchronous(z);
    }
}
