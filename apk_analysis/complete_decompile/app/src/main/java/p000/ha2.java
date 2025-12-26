package p000;

import android.app.RemoteInput;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class ha2 {
    @DoNotInline
    /* renamed from: a */
    public static int m5047a(Object obj) {
        return ((RemoteInput) obj).getEditChoicesBeforeSending();
    }

    @DoNotInline
    /* renamed from: b */
    public static RemoteInput.Builder m5048b(RemoteInput.Builder builder, int i) {
        return builder.setEditChoicesBeforeSending(i);
    }
}
