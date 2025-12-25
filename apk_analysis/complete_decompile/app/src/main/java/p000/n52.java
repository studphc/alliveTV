package p000;

import android.media.session.PlaybackState;
import android.os.Bundle;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class n52 {
    @DoNotInline
    /* renamed from: a */
    public static Bundle m6313a(PlaybackState playbackState) {
        return playbackState.getExtras();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m6314b(PlaybackState.Builder builder, Bundle bundle) {
        builder.setExtras(bundle);
    }
}
