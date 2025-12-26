package p000;

import android.media.AudioManager;
import androidx.annotation.DoNotInline;

/* renamed from: ed */
/* loaded from: classes.dex */
public abstract class AbstractC1154ed {
    @DoNotInline
    /* renamed from: a */
    public static int m4687a(AudioManager audioManager, int i) {
        return audioManager.getStreamMinVolume(i);
    }
}
