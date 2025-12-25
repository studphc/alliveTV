package p000;

import android.app.Notification;
import android.media.session.MediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class xr1 {
    @DoNotInline
    /* renamed from: a */
    public static Notification.MediaStyle m8179a() {
        return new Notification.MediaStyle();
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.MediaStyle m8180b(Notification.MediaStyle mediaStyle, int[] iArr, MediaSessionCompat.Token token) {
        if (iArr != null) {
            m8183e(mediaStyle, iArr);
        }
        if (token != null) {
            m8181c(mediaStyle, (MediaSession.Token) token.getToken());
        }
        return mediaStyle;
    }

    @DoNotInline
    /* renamed from: c */
    public static void m8181c(Notification.MediaStyle mediaStyle, MediaSession.Token token) {
        mediaStyle.setMediaSession(token);
    }

    @DoNotInline
    /* renamed from: d */
    public static void m8182d(Notification.Builder builder, Notification.MediaStyle mediaStyle) {
        builder.setStyle(mediaStyle);
    }

    @DoNotInline
    /* renamed from: e */
    public static void m8183e(Notification.MediaStyle mediaStyle, int... iArr) {
        mediaStyle.setShowActionsInCompactView(iArr);
    }
}
