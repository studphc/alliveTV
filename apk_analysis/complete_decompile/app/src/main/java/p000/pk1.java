package p000;

import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class pk1 {
    @DoNotInline
    /* renamed from: a */
    public static MediaDescription m6915a(MediaBrowser.MediaItem mediaItem) {
        return mediaItem.getDescription();
    }

    @DoNotInline
    /* renamed from: b */
    public static int m6916b(MediaBrowser.MediaItem mediaItem) {
        return mediaItem.getFlags();
    }
}
