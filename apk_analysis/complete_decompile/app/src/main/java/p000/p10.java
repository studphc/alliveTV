package p000;

import android.media.AudioFormat;
import android.media.Spatializer;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class p10 {

    /* renamed from: a */
    public final Spatializer f24999a;

    /* renamed from: b */
    public final boolean f25000b;

    /* renamed from: c */
    public Handler f25001c;

    /* renamed from: d */
    public o10 f25002d;

    public p10(Spatializer spatializer) {
        int immersiveAudioLevel;
        boolean z;
        this.f24999a = spatializer;
        immersiveAudioLevel = spatializer.getImmersiveAudioLevel();
        if (immersiveAudioLevel != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f25000b = z;
    }

    /* renamed from: a */
    public final boolean m6767a(Format format, AudioAttributes audioAttributes) {
        int i;
        boolean canBeSpatialized;
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(format.sampleMimeType) && format.channelCount == 16) {
            i = 12;
        } else {
            i = format.channelCount;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(Util.getAudioTrackChannelConfig(i));
        int i2 = format.sampleRate;
        if (i2 != -1) {
            channelMask.setSampleRate(i2);
        }
        canBeSpatialized = this.f24999a.canBeSpatialized(audioAttributes.getAudioAttributesV21().audioAttributes, channelMask.build());
        return canBeSpatialized;
    }
}
