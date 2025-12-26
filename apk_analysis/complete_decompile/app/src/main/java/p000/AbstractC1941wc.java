package p000;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import androidx.annotation.DoNotInline;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;

/* renamed from: wc */
/* loaded from: classes.dex */
public abstract class AbstractC1941wc {

    /* renamed from: a */
    public static final AudioAttributes f28135a = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

    /* JADX WARN: Multi-variable type inference failed */
    @DoNotInline
    /* renamed from: a */
    public static int[] m8021a() {
        boolean isDirectPlaybackSupported;
        ImmutableList.Builder builder = ImmutableList.builder();
        UnmodifiableIterator it = AudioCapabilities.f9644d.keySet().iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(num.intValue()).setSampleRate(OpusUtil.SAMPLE_RATE).build(), f28135a);
            if (isDirectPlaybackSupported) {
                builder.add((ImmutableList.Builder) num);
            }
        }
        builder.add((ImmutableList.Builder) 2);
        return Ints.toArray(builder.build());
    }

    @DoNotInline
    /* renamed from: b */
    public static int m8022b(int i, int i2) {
        boolean isDirectPlaybackSupported;
        for (int i3 = 8; i3 > 0; i3--) {
            isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(Util.getAudioTrackChannelConfig(i3)).build(), f28135a);
            if (isDirectPlaybackSupported) {
                return i3;
            }
        }
        return 0;
    }
}
