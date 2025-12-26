package androidx.media;

import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import p000.AbstractC1118dd;
import p000.AbstractC1154ed;
import p000.AbstractC1571n3;

/* loaded from: classes.dex */
public final class AudioManagerCompat {
    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;

    public static int abandonAudioFocusRequest(@NonNull AudioManager audioManager, @NonNull AudioFocusRequestCompat audioFocusRequestCompat) {
        if (audioManager != null) {
            if (audioFocusRequestCompat != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return AbstractC1118dd.m4569a(audioManager, AbstractC1571n3.m6293q(audioFocusRequestCompat.f6652f));
                }
                return audioManager.abandonAudioFocus(audioFocusRequestCompat.getOnAudioFocusChangeListener());
            }
            throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
        }
        throw new IllegalArgumentException("AudioManager must not be null");
    }

    @IntRange(from = 0)
    public static int getStreamMaxVolume(@NonNull AudioManager audioManager, int i) {
        return audioManager.getStreamMaxVolume(i);
    }

    @IntRange(from = 0)
    public static int getStreamMinVolume(@NonNull AudioManager audioManager, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC1154ed.m4687a(audioManager, i);
        }
        return 0;
    }

    public static int requestAudioFocus(@NonNull AudioManager audioManager, @NonNull AudioFocusRequestCompat audioFocusRequestCompat) {
        if (audioManager != null) {
            if (audioFocusRequestCompat != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return AbstractC1118dd.m4570b(audioManager, AbstractC1571n3.m6293q(audioFocusRequestCompat.f6652f));
                }
                return audioManager.requestAudioFocus(audioFocusRequestCompat.getOnAudioFocusChangeListener(), audioFocusRequestCompat.getAudioAttributesCompat().getLegacyStreamType(), audioFocusRequestCompat.getFocusGain());
            }
            throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
        }
        throw new IllegalArgumentException("AudioManager must not be null");
    }
}
