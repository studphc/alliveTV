package androidx.core.app;

import android.media.AudioAttributes;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.l */
/* loaded from: classes.dex */
public abstract class AbstractC0159l {
    @DoNotInline
    /* renamed from: a */
    public static AudioAttributes m748a(AudioAttributes.Builder builder) {
        return builder.build();
    }

    @DoNotInline
    /* renamed from: b */
    public static AudioAttributes.Builder m749b() {
        return new AudioAttributes.Builder();
    }

    @DoNotInline
    /* renamed from: c */
    public static AudioAttributes.Builder m750c(AudioAttributes.Builder builder, int i) {
        return builder.setContentType(i);
    }

    @DoNotInline
    /* renamed from: d */
    public static AudioAttributes.Builder m751d(AudioAttributes.Builder builder, int i) {
        return builder.setLegacyStreamType(i);
    }

    @DoNotInline
    /* renamed from: e */
    public static AudioAttributes.Builder m752e(AudioAttributes.Builder builder, int i) {
        return builder.setUsage(i);
    }
}
