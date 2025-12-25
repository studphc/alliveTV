package p000;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import androidx.annotation.DoNotInline;

/* renamed from: dd */
/* loaded from: classes.dex */
public abstract class AbstractC1118dd {
    @DoNotInline
    /* renamed from: a */
    public static int m4569a(AudioManager audioManager, AudioFocusRequest audioFocusRequest) {
        return audioManager.abandonAudioFocusRequest(audioFocusRequest);
    }

    @DoNotInline
    /* renamed from: b */
    public static int m4570b(AudioManager audioManager, AudioFocusRequest audioFocusRequest) {
        return audioManager.requestAudioFocus(audioFocusRequest);
    }
}
