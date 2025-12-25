package p000;

import android.app.Notification;
import android.media.AudioAttributes;
import android.net.Uri;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class gs1 {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Builder m4986a(Notification.Builder builder, String str) {
        return builder.addPerson(str);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.Builder m4987b(Notification.Builder builder, String str) {
        return builder.setCategory(str);
    }

    @DoNotInline
    /* renamed from: c */
    public static Notification.Builder m4988c(Notification.Builder builder, int i) {
        return builder.setColor(i);
    }

    @DoNotInline
    /* renamed from: d */
    public static Notification.Builder m4989d(Notification.Builder builder, Notification notification) {
        return builder.setPublicVersion(notification);
    }

    @DoNotInline
    /* renamed from: e */
    public static Notification.Builder m4990e(Notification.Builder builder, Uri uri, Object obj) {
        return builder.setSound(uri, (AudioAttributes) obj);
    }

    @DoNotInline
    /* renamed from: f */
    public static Notification.Builder m4991f(Notification.Builder builder, int i) {
        return builder.setVisibility(i);
    }
}
