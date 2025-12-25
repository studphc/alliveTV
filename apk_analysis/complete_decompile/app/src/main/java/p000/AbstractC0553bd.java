package p000;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.DoNotInline;

/* renamed from: bd */
/* loaded from: classes.dex */
public abstract class AbstractC0553bd {
    @DoNotInline
    /* renamed from: a */
    public static AudioFocusRequest m2084a(int i, AudioAttributes audioAttributes, boolean z, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
        return new AudioFocusRequest.Builder(i).setAudioAttributes(audioAttributes).setWillPauseWhenDucked(z).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build();
    }
}
