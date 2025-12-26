package p000;

import android.media.MediaDescription;
import android.net.Uri;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class ml1 {
    @Nullable
    @DoNotInline
    /* renamed from: a */
    public static Uri m6182a(MediaDescription mediaDescription) {
        return mediaDescription.getMediaUri();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m6183b(MediaDescription.Builder builder, @Nullable Uri uri) {
        builder.setMediaUri(uri);
    }
}
