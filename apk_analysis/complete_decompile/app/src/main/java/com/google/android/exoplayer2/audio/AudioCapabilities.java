package com.google.android.exoplayer2.audio;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import p000.AbstractC1941wc;

/* loaded from: classes.dex */
public final class AudioCapabilities {
    public static final AudioCapabilities DEFAULT_AUDIO_CAPABILITIES = new AudioCapabilities(new int[]{2}, 8);

    /* renamed from: c */
    public static final AudioCapabilities f9643c = new AudioCapabilities(new int[]{2, 5, 6}, 8);

    /* renamed from: d */
    public static final ImmutableMap f9644d = new ImmutableMap.Builder().put(5, 6).put(17, 6).put(7, 6).put(18, 6).put(6, 8).put(8, 8).put(14, 8).buildOrThrow();

    /* renamed from: a */
    public final int[] f9645a;

    /* renamed from: b */
    public final int f9646b;

    public AudioCapabilities(@Nullable int[] iArr, int i) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f9645a = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f9645a = new int[0];
        }
        this.f9646b = i;
    }

    /* renamed from: a */
    public static boolean m2445a() {
        if (Util.SDK_INT >= 17) {
            String str = Util.MANUFACTURER;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static AudioCapabilities m2446b(Context context, Intent intent) {
        if (m2445a() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            return f9643c;
        }
        if (Util.SDK_INT >= 29 && (Util.isTv(context) || Util.isAutomotive(context))) {
            return new AudioCapabilities(AbstractC1941wc.m8021a(), 8);
        }
        if (intent != null && intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 0) {
            return new AudioCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        return DEFAULT_AUDIO_CAPABILITIES;
    }

    public static AudioCapabilities getCapabilities(Context context) {
        return m2446b(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        if (Arrays.equals(this.f9645a, audioCapabilities.f9645a) && this.f9646b == audioCapabilities.f9646b) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0088, code lost:
    
        if (r7 != 5) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<Integer, Integer> getEncodingAndChannelConfigForPassthrough(Format format) {
        int intValue;
        int audioTrackChannelConfig;
        int encoding = MimeTypes.getEncoding((String) Assertions.checkNotNull(format.sampleMimeType), format.codecs);
        Integer valueOf = Integer.valueOf(encoding);
        ImmutableMap immutableMap = f9644d;
        if (!immutableMap.containsKey(valueOf)) {
            return null;
        }
        int i = 6;
        if (encoding == 18 && !supportsEncoding(18)) {
            encoding = 6;
        } else if (encoding == 8 && !supportsEncoding(8)) {
            encoding = 7;
        }
        if (!supportsEncoding(encoding)) {
            return null;
        }
        int i2 = format.channelCount;
        if (i2 != -1 && encoding != 18) {
            if (i2 > this.f9646b) {
                return null;
            }
        } else {
            int i3 = format.sampleRate;
            if (i3 == -1) {
                i3 = OpusUtil.SAMPLE_RATE;
            }
            if (Util.SDK_INT >= 29) {
                intValue = AbstractC1941wc.m8022b(encoding, i3);
            } else {
                intValue = ((Integer) Assertions.checkNotNull((Integer) immutableMap.getOrDefault(Integer.valueOf(encoding), 0))).intValue();
            }
            i2 = intValue;
        }
        int i4 = Util.SDK_INT;
        if (i4 <= 28) {
            if (i2 == 7) {
                i = 8;
            } else if (i2 != 3) {
                if (i2 != 4) {
                }
            }
            if (i4 <= 26 && "fugu".equals(Util.DEVICE) && i == 1) {
                i = 2;
            }
            audioTrackChannelConfig = Util.getAudioTrackChannelConfig(i);
            if (audioTrackChannelConfig != 0) {
                return null;
            }
            return Pair.create(Integer.valueOf(encoding), Integer.valueOf(audioTrackChannelConfig));
        }
        i = i2;
        if (i4 <= 26) {
            i = 2;
        }
        audioTrackChannelConfig = Util.getAudioTrackChannelConfig(i);
        if (audioTrackChannelConfig != 0) {
        }
    }

    public int getMaxChannelCount() {
        return this.f9646b;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f9645a) * 31) + this.f9646b;
    }

    public boolean isPassthroughPlaybackSupported(Format format) {
        if (getEncodingAndChannelConfigForPassthrough(format) != null) {
            return true;
        }
        return false;
    }

    public boolean supportsEncoding(int i) {
        if (Arrays.binarySearch(this.f9645a, i) >= 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f9646b + ", supportedEncodings=" + Arrays.toString(this.f9645a) + "]";
    }
}
