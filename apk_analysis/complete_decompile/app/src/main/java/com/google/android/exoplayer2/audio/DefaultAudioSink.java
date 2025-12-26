package com.google.android.exoplayer2.audio;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.InlineMeValidationDisabled;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import p000.C1618od;
import p000.C1683pd;
import p000.C1720qd;
import p000.C1972x6;
import p000.ExecutorC1700pu;
import p000.f00;
import p000.g00;
import p000.h00;
import p000.i00;
import p000.ye0;

/* loaded from: classes.dex */
public final class DefaultAudioSink implements AudioSink {
    public static final float DEFAULT_PLAYBACK_SPEED = 1.0f;
    public static final float MAX_PITCH = 8.0f;
    public static final float MAX_PLAYBACK_SPEED = 8.0f;
    public static final float MIN_PITCH = 0.1f;
    public static final float MIN_PLAYBACK_SPEED = 0.1f;
    public static final int OFFLOAD_MODE_DISABLED = 0;
    public static final int OFFLOAD_MODE_ENABLED_GAPLESS_DISABLED = 3;
    public static final int OFFLOAD_MODE_ENABLED_GAPLESS_NOT_REQUIRED = 2;
    public static final int OFFLOAD_MODE_ENABLED_GAPLESS_REQUIRED = 1;
    public static final int OUTPUT_MODE_OFFLOAD = 1;
    public static final int OUTPUT_MODE_PASSTHROUGH = 2;
    public static final int OUTPUT_MODE_PCM = 0;
    public static boolean failOnSpuriousAudioTimestamp = false;

    /* renamed from: A */
    public int f9683A;

    /* renamed from: B */
    public long f9684B;

    /* renamed from: C */
    public long f9685C;

    /* renamed from: D */
    public long f9686D;

    /* renamed from: E */
    public long f9687E;

    /* renamed from: F */
    public int f9688F;

    /* renamed from: G */
    public boolean f9689G;

    /* renamed from: H */
    public boolean f9690H;

    /* renamed from: I */
    public long f9691I;

    /* renamed from: J */
    public float f9692J;

    /* renamed from: K */
    public AudioProcessor[] f9693K;

    /* renamed from: L */
    public ByteBuffer[] f9694L;

    /* renamed from: M */
    public ByteBuffer f9695M;

    /* renamed from: N */
    public int f9696N;

    /* renamed from: O */
    public ByteBuffer f9697O;

    /* renamed from: P */
    public byte[] f9698P;

    /* renamed from: Q */
    public int f9699Q;

    /* renamed from: R */
    public int f9700R;

    /* renamed from: S */
    public boolean f9701S;

    /* renamed from: T */
    public boolean f9702T;

    /* renamed from: U */
    public boolean f9703U;

    /* renamed from: V */
    public boolean f9704V;

    /* renamed from: W */
    public int f9705W;

    /* renamed from: X */
    public AuxEffectInfo f9706X;

    /* renamed from: Y */
    public boolean f9707Y;

    /* renamed from: Z */
    public long f9708Z;

    /* renamed from: a */
    public final AudioCapabilities f9709a;

    /* renamed from: a0 */
    public boolean f9710a0;

    /* renamed from: b */
    public final AudioProcessorChain f9711b;

    /* renamed from: b0 */
    public boolean f9712b0;

    /* renamed from: c */
    public final boolean f9713c;

    /* renamed from: d */
    public final C0647a f9714d;

    /* renamed from: e */
    public final C0656j f9715e;

    /* renamed from: f */
    public final AudioProcessor[] f9716f;

    /* renamed from: g */
    public final AudioProcessor[] f9717g;

    /* renamed from: h */
    public final ConditionVariable f9718h;

    /* renamed from: i */
    public final C1720qd f9719i;

    /* renamed from: j */
    public final ArrayDeque f9720j;

    /* renamed from: k */
    public final boolean f9721k;

    /* renamed from: l */
    public final int f9722l;

    /* renamed from: m */
    public i00 f9723m;

    /* renamed from: n */
    public final C1972x6 f9724n;

    /* renamed from: o */
    public final C1972x6 f9725o;

    /* renamed from: p */
    public final InterfaceC0649c f9726p;

    /* renamed from: q */
    public PlayerId f9727q;

    /* renamed from: r */
    public AudioSink.Listener f9728r;

    /* renamed from: s */
    public C0650d f9729s;

    /* renamed from: t */
    public C0650d f9730t;

    /* renamed from: u */
    public AudioTrack f9731u;

    /* renamed from: v */
    public AudioAttributes f9732v;

    /* renamed from: w */
    public h00 f9733w;

    /* renamed from: x */
    public h00 f9734x;

    /* renamed from: y */
    public PlaybackParameters f9735y;

    /* renamed from: z */
    public ByteBuffer f9736z;

    /* loaded from: classes.dex */
    public interface AudioProcessorChain {
        PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters);

        boolean applySkipSilenceEnabled(boolean z);

        AudioProcessor[] getAudioProcessors();

        long getMediaDuration(long j);

        long getSkippedOutputFrameCount();
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: b */
        public AudioProcessorChain f9738b;

        /* renamed from: c */
        public boolean f9739c;

        /* renamed from: d */
        public boolean f9740d;

        /* renamed from: a */
        public AudioCapabilities f9737a = AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES;

        /* renamed from: e */
        public int f9741e = 0;

        /* renamed from: f */
        public InterfaceC0649c f9742f = InterfaceC0649c.f9815a;

        public DefaultAudioSink build() {
            if (this.f9738b == null) {
                this.f9738b = new DefaultAudioProcessorChain(new AudioProcessor[0]);
            }
            return new DefaultAudioSink(this);
        }

        public Builder setAudioCapabilities(AudioCapabilities audioCapabilities) {
            Assertions.checkNotNull(audioCapabilities);
            this.f9737a = audioCapabilities;
            return this;
        }

        public Builder setAudioProcessorChain(AudioProcessorChain audioProcessorChain) {
            Assertions.checkNotNull(audioProcessorChain);
            this.f9738b = audioProcessorChain;
            return this;
        }

        public Builder setAudioProcessors(AudioProcessor[] audioProcessorArr) {
            Assertions.checkNotNull(audioProcessorArr);
            return setAudioProcessorChain(new DefaultAudioProcessorChain(audioProcessorArr));
        }

        public Builder setAudioTrackBufferSizeProvider(InterfaceC0649c interfaceC0649c) {
            this.f9742f = interfaceC0649c;
            return this;
        }

        public Builder setEnableAudioTrackPlaybackParams(boolean z) {
            this.f9740d = z;
            return this;
        }

        public Builder setEnableFloatOutput(boolean z) {
            this.f9739c = z;
            return this;
        }

        public Builder setOffloadMode(int i) {
            this.f9741e = i;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class DefaultAudioProcessorChain implements AudioProcessorChain {

        /* renamed from: a */
        public final AudioProcessor[] f9743a;

        /* renamed from: b */
        public final SilenceSkippingAudioProcessor f9744b;

        /* renamed from: c */
        public final SonicAudioProcessor f9745c;

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new SilenceSkippingAudioProcessor(), new SonicAudioProcessor());
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters) {
            float f = playbackParameters.speed;
            SonicAudioProcessor sonicAudioProcessor = this.f9745c;
            sonicAudioProcessor.setSpeed(f);
            sonicAudioProcessor.setPitch(playbackParameters.pitch);
            return playbackParameters;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public boolean applySkipSilenceEnabled(boolean z) {
            this.f9744b.setEnabled(z);
            return z;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public AudioProcessor[] getAudioProcessors() {
            return this.f9743a;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getMediaDuration(long j) {
            return this.f9745c.getMediaDuration(j);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getSkippedOutputFrameCount() {
            return this.f9744b.getSkippedFrames();
        }

        public DefaultAudioProcessorChain(AudioProcessor[] audioProcessorArr, SilenceSkippingAudioProcessor silenceSkippingAudioProcessor, SonicAudioProcessor sonicAudioProcessor) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.f9743a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f9744b = silenceSkippingAudioProcessor;
            this.f9745c = sonicAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor;
        }
    }

    /* loaded from: classes.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OffloadMode {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OutputMode {
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.audio.DefaultAudioSink"}, replacement = "new DefaultAudioSink.Builder().setAudioCapabilities(audioCapabilities).setAudioProcessors(audioProcessors).build()")
    @InlineMeValidationDisabled("Migrate constructor to Builder")
    @Deprecated
    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessorArr) {
        this(new Builder().setAudioCapabilities((AudioCapabilities) MoreObjects.firstNonNull(audioCapabilities, AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES)).setAudioProcessors(audioProcessorArr));
    }

    /* renamed from: c */
    public static AudioFormat m2453c(int i, int i2, int i3) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    /* renamed from: i */
    public static boolean m2454i(AudioTrack audioTrack) {
        boolean isOffloadedPlayback;
        if (Util.SDK_INT >= 29) {
            isOffloadedPlayback = audioTrack.isOffloadedPlayback();
            if (isOffloadedPlayback) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void m2455a(long j) {
        PlaybackParameters playbackParameters;
        boolean z;
        boolean m2467o = m2467o();
        AudioProcessorChain audioProcessorChain = this.f9711b;
        if (m2467o) {
            playbackParameters = audioProcessorChain.applyPlaybackParameters(m2457d().f17901a);
        } else {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        PlaybackParameters playbackParameters2 = playbackParameters;
        int i = 0;
        if (m2467o()) {
            z = audioProcessorChain.applySkipSilenceEnabled(getSkipSilenceEnabled());
        } else {
            z = false;
        }
        this.f9720j.add(new h00(playbackParameters2, z, Math.max(0L, j), (m2459f() * 1000000) / this.f9730t.f9820e));
        AudioProcessor[] audioProcessorArr = this.f9730t.f9824i;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.f9693K = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.f9694L = new ByteBuffer[size];
        while (true) {
            AudioProcessor[] audioProcessorArr2 = this.f9693K;
            if (i >= audioProcessorArr2.length) {
                break;
            }
            AudioProcessor audioProcessor2 = audioProcessorArr2[i];
            audioProcessor2.flush();
            this.f9694L[i] = audioProcessor2.getOutput();
            i++;
        }
        AudioSink.Listener listener = this.f9728r;
        if (listener != null) {
            listener.onSkipSilenceEnabledChanged(z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0029 -> B:4:0x0009). Please report as a decompilation issue!!! */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m2456b() {
        boolean z;
        int i;
        AudioProcessor[] audioProcessorArr;
        if (this.f9700R == -1) {
            this.f9700R = 0;
            z = true;
            i = this.f9700R;
            audioProcessorArr = this.f9693K;
            if (i < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i];
                if (z) {
                    audioProcessor.queueEndOfStream();
                }
                m2463k(C0643C.TIME_UNSET);
                if (!audioProcessor.isEnded()) {
                    return false;
                }
                this.f9700R++;
                z = true;
                i = this.f9700R;
                audioProcessorArr = this.f9693K;
                if (i < audioProcessorArr.length) {
                    ByteBuffer byteBuffer = this.f9697O;
                    if (byteBuffer != null) {
                        m2469q(byteBuffer, C0643C.TIME_UNSET);
                        if (this.f9697O != null) {
                            return false;
                        }
                    }
                    this.f9700R = -1;
                    return true;
                }
            }
        } else {
            z = false;
            i = this.f9700R;
            audioProcessorArr = this.f9693K;
            if (i < audioProcessorArr.length) {
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void configure(Format format, int i, @Nullable int[] iArr) {
        int i2;
        AudioProcessor[] audioProcessorArr;
        int i3;
        int intValue;
        int i4;
        int i5;
        int i6;
        double d;
        int i7;
        int i8;
        int bufferSizeInBytes;
        AudioProcessor[] audioProcessorArr2;
        int[] iArr2;
        boolean z = true;
        if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
            Assertions.checkArgument(Util.isEncodingLinearPcm(format.pcmEncoding));
            int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
            int i9 = format.pcmEncoding;
            if (this.f9713c && Util.isEncodingHighResolutionPcm(i9)) {
                audioProcessorArr2 = this.f9717g;
            } else {
                audioProcessorArr2 = this.f9716f;
            }
            int i10 = format.encoderDelay;
            int i11 = format.encoderPadding;
            C0656j c0656j = this.f9715e;
            c0656j.f9829f = i10;
            c0656j.f9830g = i11;
            if (Util.SDK_INT < 21 && format.channelCount == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i12 = 0; i12 < 6; i12++) {
                    iArr2[i12] = i12;
                }
            } else {
                iArr2 = iArr;
            }
            this.f9714d.f9812f = iArr2;
            AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(format.sampleRate, format.channelCount, format.pcmEncoding);
            for (AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    AudioProcessor.AudioFormat configure = audioProcessor.configure(audioFormat);
                    if (audioProcessor.isActive()) {
                        audioFormat = configure;
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e) {
                    throw new AudioSink.ConfigurationException(e, format);
                }
            }
            int i13 = audioFormat.encoding;
            int i14 = audioFormat.sampleRate;
            int audioTrackChannelConfig = Util.getAudioTrackChannelConfig(audioFormat.channelCount);
            i4 = Util.getPcmFrameSize(i13, audioFormat.channelCount);
            audioProcessorArr = audioProcessorArr2;
            i5 = i13;
            intValue = audioTrackChannelConfig;
            i2 = pcmFrameSize;
            i6 = 0;
            i3 = i14;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i15 = format.sampleRate;
            i2 = -1;
            if (m2468p(format, this.f9732v)) {
                audioProcessorArr = audioProcessorArr3;
                i3 = i15;
                i5 = MimeTypes.getEncoding((String) Assertions.checkNotNull(format.sampleMimeType), format.codecs);
                i4 = -1;
                intValue = Util.getAudioTrackChannelConfig(format.channelCount);
                i6 = 1;
            } else {
                Pair<Integer, Integer> encodingAndChannelConfigForPassthrough = this.f9709a.getEncodingAndChannelConfigForPassthrough(format);
                if (encodingAndChannelConfigForPassthrough != null) {
                    int intValue2 = ((Integer) encodingAndChannelConfigForPassthrough.first).intValue();
                    audioProcessorArr = audioProcessorArr3;
                    i3 = i15;
                    intValue = ((Integer) encodingAndChannelConfigForPassthrough.second).intValue();
                    i4 = -1;
                    i5 = intValue2;
                    i6 = 2;
                } else {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + format, format);
                }
            }
        }
        if (i != 0) {
            bufferSizeInBytes = i;
            i7 = intValue;
            i8 = i5;
        } else {
            int minBufferSize = AudioTrack.getMinBufferSize(i3, intValue, i5);
            if (minBufferSize == -2) {
                z = false;
            }
            Assertions.checkState(z);
            if (this.f9721k) {
                d = 8.0d;
            } else {
                d = 1.0d;
            }
            i7 = intValue;
            i8 = i5;
            bufferSizeInBytes = this.f9726p.getBufferSizeInBytes(minBufferSize, i5, i6, i4, i3, d);
        }
        if (i8 != 0) {
            if (i7 != 0) {
                this.f9710a0 = false;
                C0650d c0650d = new C0650d(format, i2, i6, i4, i3, i7, i8, bufferSizeInBytes, audioProcessorArr);
                if (m2461h()) {
                    this.f9729s = c0650d;
                    return;
                } else {
                    this.f9730t = c0650d;
                    return;
                }
            }
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i6 + ") for: " + format, format);
        }
        throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i6 + ") for: " + format, format);
    }

    /* renamed from: d */
    public final h00 m2457d() {
        h00 h00Var = this.f9733w;
        if (h00Var == null) {
            ArrayDeque arrayDeque = this.f9720j;
            if (!arrayDeque.isEmpty()) {
                return (h00) arrayDeque.getLast();
            }
            return this.f9734x;
        }
        return h00Var;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        if (this.f9707Y) {
            this.f9707Y = false;
            flush();
        }
    }

    /* renamed from: e */
    public final long m2458e() {
        if (this.f9730t.f9818c == 0) {
            return this.f9684B / r0.f9817b;
        }
        return this.f9685C;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21() {
        boolean z;
        if (Util.SDK_INT >= 21) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        Assertions.checkState(this.f9704V);
        if (!this.f9707Y) {
            this.f9707Y = true;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void experimentalFlushWithoutAudioTrackRelease() {
        boolean z;
        if (Util.SDK_INT < 25) {
            flush();
            return;
        }
        this.f9725o.f28447c = null;
        this.f9724n.f28447c = null;
        if (!m2461h()) {
            return;
        }
        m2464l();
        C1720qd c1720qd = this.f9719i;
        if (((AudioTrack) Assertions.checkNotNull(c1720qd.f25526c)).getPlayState() == 3) {
            this.f9731u.pause();
        }
        this.f9731u.flush();
        c1720qd.f25535l = 0L;
        c1720qd.f25546w = 0;
        c1720qd.f25545v = 0;
        c1720qd.f25536m = 0L;
        c1720qd.f25520C = 0L;
        c1720qd.f25523F = 0L;
        c1720qd.f25534k = false;
        c1720qd.f25526c = null;
        c1720qd.f25529f = null;
        AudioTrack audioTrack = this.f9731u;
        C0650d c0650d = this.f9730t;
        if (c0650d.f9818c == 2) {
            z = true;
        } else {
            z = false;
        }
        this.f9719i.m7030c(audioTrack, z, c0650d.f9822g, c0650d.f9819d, c0650d.f9823h);
        this.f9690H = true;
    }

    /* renamed from: f */
    public final long m2459f() {
        if (this.f9730t.f9818c == 0) {
            return this.f9686D / r0.f9819d;
        }
        return this.f9687E;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        if (m2461h()) {
            m2464l();
            C1720qd c1720qd = this.f9719i;
            if (((AudioTrack) Assertions.checkNotNull(c1720qd.f25526c)).getPlayState() == 3) {
                this.f9731u.pause();
            }
            if (m2454i(this.f9731u)) {
                i00 i00Var = (i00) Assertions.checkNotNull(this.f9723m);
                this.f9731u.unregisterStreamEventCallback(i00Var.f18235b);
                i00Var.f18234a.removeCallbacksAndMessages(null);
            }
            AudioTrack audioTrack = this.f9731u;
            this.f9731u = null;
            if (Util.SDK_INT < 21 && !this.f9704V) {
                this.f9705W = 0;
            }
            C0650d c0650d = this.f9729s;
            if (c0650d != null) {
                this.f9730t = c0650d;
                this.f9729s = null;
            }
            c1720qd.f25535l = 0L;
            c1720qd.f25546w = 0;
            c1720qd.f25545v = 0;
            c1720qd.f25536m = 0L;
            c1720qd.f25520C = 0L;
            c1720qd.f25523F = 0L;
            c1720qd.f25534k = false;
            c1720qd.f25526c = null;
            c1720qd.f25529f = null;
            this.f9718h.close();
            new f00(this, audioTrack).start();
        }
        this.f9725o.f28447c = null;
        this.f9724n.f28447c = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m2460g() {
        AudioTrack m2480a;
        boolean z;
        PlayerId playerId;
        if (!this.f9718h.isOpen()) {
            return false;
        }
        try {
        } catch (AudioSink.InitializationException e) {
            C0650d c0650d = this.f9730t;
            if (c0650d.f9823h > 1000000) {
                C0650d c0650d2 = new C0650d(c0650d.f9816a, c0650d.f9817b, c0650d.f9818c, c0650d.f9819d, c0650d.f9820e, c0650d.f9821f, c0650d.f9822g, 1000000, c0650d.f9824i);
                try {
                    try {
                        m2480a = c0650d2.m2480a(this.f9707Y, this.f9732v, this.f9705W);
                        this.f9730t = c0650d2;
                    } catch (AudioSink.InitializationException e2) {
                        AudioSink.Listener listener = this.f9728r;
                        if (listener != null) {
                            listener.onAudioSinkError(e2);
                        }
                        throw e2;
                    }
                } catch (AudioSink.InitializationException e3) {
                    e.addSuppressed(e3);
                    if (this.f9730t.f9818c != 1) {
                    }
                }
            }
            if (this.f9730t.f9818c != 1) {
                this.f9710a0 = true;
                throw e;
            }
            throw e;
        }
        try {
            m2480a = ((C0650d) Assertions.checkNotNull(this.f9730t)).m2480a(this.f9707Y, this.f9732v, this.f9705W);
            this.f9731u = m2480a;
            if (m2454i(m2480a)) {
                AudioTrack audioTrack = this.f9731u;
                if (this.f9723m == null) {
                    this.f9723m = new i00(this);
                }
                i00 i00Var = this.f9723m;
                Handler handler = i00Var.f18234a;
                Objects.requireNonNull(handler);
                audioTrack.registerStreamEventCallback(new ExecutorC1700pu(handler), i00Var.f18235b);
                if (this.f9722l != 3) {
                    AudioTrack audioTrack2 = this.f9731u;
                    Format format = this.f9730t.f9816a;
                    audioTrack2.setOffloadDelayPadding(format.encoderDelay, format.encoderPadding);
                }
            }
            int i = Util.SDK_INT;
            if (i >= 31 && (playerId = this.f9727q) != null) {
                g00.m4895a(this.f9731u, playerId);
            }
            this.f9705W = this.f9731u.getAudioSessionId();
            AudioTrack audioTrack3 = this.f9731u;
            C0650d c0650d3 = this.f9730t;
            if (c0650d3.f9818c == 2) {
                z = true;
            } else {
                z = false;
            }
            this.f9719i.m7030c(audioTrack3, z, c0650d3.f9822g, c0650d3.f9819d, c0650d3.f9823h);
            if (m2461h()) {
                if (i >= 21) {
                    this.f9731u.setVolume(this.f9692J);
                } else {
                    AudioTrack audioTrack4 = this.f9731u;
                    float f = this.f9692J;
                    audioTrack4.setStereoVolume(f, f);
                }
            }
            int i2 = this.f9706X.effectId;
            if (i2 != 0) {
                this.f9731u.attachAuxEffect(i2);
                this.f9731u.setAuxEffectSendLevel(this.f9706X.sendLevel);
            }
            this.f9690H = true;
            return true;
        } catch (AudioSink.InitializationException e4) {
            AudioSink.Listener listener2 = this.f9728r;
            if (listener2 != null) {
                listener2.onAudioSinkError(e4);
            }
            throw e4;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public AudioAttributes getAudioAttributes() {
        return this.f9732v;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b8 A[Catch: Exception -> 0x01be, TRY_LEAVE, TryCatch #0 {Exception -> 0x01be, blocks: (B:68:0x018d, B:70:0x01b8), top: B:67:0x018d }] */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getCurrentPositionUs(boolean z) {
        boolean z2;
        long j;
        long j2;
        ArrayDeque arrayDeque;
        long mediaDurationForPlayoutDuration;
        long j3;
        long j4;
        boolean z3;
        Method method;
        long max;
        long j5;
        long j6;
        if (m2461h() && !this.f9690H) {
            C1720qd c1720qd = this.f9719i;
            int playState = ((AudioTrack) Assertions.checkNotNull(c1720qd.f25526c)).getPlayState();
            AudioTrackPositionTracker$Listener audioTrackPositionTracker$Listener = c1720qd.f25524a;
            if (playState == 3) {
                long m7028a = (c1720qd.m7028a() * 1000000) / c1720qd.f25530g;
                if (m7028a != 0) {
                    long nanoTime = System.nanoTime() / 1000;
                    if (nanoTime - c1720qd.f25536m >= 30000) {
                        int i = c1720qd.f25545v;
                        long[] jArr = c1720qd.f25525b;
                        jArr[i] = m7028a - nanoTime;
                        c1720qd.f25545v = (i + 1) % 10;
                        int i2 = c1720qd.f25546w;
                        if (i2 < 10) {
                            c1720qd.f25546w = i2 + 1;
                        }
                        c1720qd.f25536m = nanoTime;
                        c1720qd.f25535l = 0L;
                        int i3 = 0;
                        while (true) {
                            int i4 = c1720qd.f25546w;
                            if (i3 >= i4) {
                                break;
                            }
                            c1720qd.f25535l = (jArr[i3] / i4) + c1720qd.f25535l;
                            i3++;
                        }
                    }
                    if (!c1720qd.f25531h) {
                        C1683pd c1683pd = (C1683pd) Assertions.checkNotNull(c1720qd.f25529f);
                        C1618od c1618od = c1683pd.f25120a;
                        if (c1618od != null && nanoTime - c1683pd.f25124e >= c1683pd.f25123d) {
                            c1683pd.f25124e = nanoTime;
                            AudioTrack audioTrack = c1618od.f23771a;
                            AudioTimestamp audioTimestamp = c1618od.f23772b;
                            z3 = audioTrack.getTimestamp(audioTimestamp);
                            if (z3) {
                                long j7 = audioTimestamp.framePosition;
                                if (c1618od.f23774d > j7) {
                                    c1618od.f23773c++;
                                }
                                c1618od.f23774d = j7;
                                c1618od.f23775e = j7 + (c1618od.f23773c << 32);
                            }
                            int i5 = c1683pd.f25121b;
                            if (i5 != 0) {
                                if (i5 != 1) {
                                    if (i5 != 2) {
                                        if (i5 != 3) {
                                            if (i5 != 4) {
                                                throw new IllegalStateException();
                                            }
                                        } else if (z3) {
                                            c1683pd.m6909a();
                                        }
                                    } else if (!z3) {
                                        c1683pd.m6909a();
                                    }
                                } else if (z3) {
                                    if (c1618od.f23775e > c1683pd.f25125f) {
                                        c1683pd.m6910b(2);
                                    }
                                } else {
                                    c1683pd.m6909a();
                                }
                            } else if (z3) {
                                if (audioTimestamp.nanoTime / 1000 >= c1683pd.f25122c) {
                                    c1683pd.f25125f = c1618od.f23775e;
                                    c1683pd.m6910b(1);
                                }
                            } else if (nanoTime - c1683pd.f25122c > 500000) {
                                c1683pd.m6910b(3);
                            }
                            if (z3) {
                                C1618od c1618od2 = c1683pd.f25120a;
                                if (c1618od2 != null) {
                                    j5 = c1618od2.f23772b.nanoTime / 1000;
                                } else {
                                    j5 = C0643C.TIME_UNSET;
                                }
                                if (c1618od2 != null) {
                                    j6 = c1618od2.f23775e;
                                } else {
                                    j6 = -1;
                                }
                                if (Math.abs(j5 - nanoTime) > 5000000) {
                                    c1720qd.f25524a.onSystemTimeUsMismatch(j6, j5, nanoTime, m7028a);
                                    c1683pd.m6910b(4);
                                } else if (Math.abs(((j6 * 1000000) / c1720qd.f25530g) - m7028a) > 5000000) {
                                    c1720qd.f25524a.onPositionFramesMismatch(j6, j5, nanoTime, m7028a);
                                    c1683pd.m6910b(4);
                                } else if (c1683pd.f25121b == 4) {
                                    c1683pd.m6909a();
                                }
                            }
                            if (c1720qd.f25540q && (method = c1720qd.f25537n) != null && nanoTime - c1720qd.f25541r >= 500000) {
                                try {
                                    long intValue = (((Integer) Util.castNonNull((Integer) method.invoke(Assertions.checkNotNull(c1720qd.f25526c), null))).intValue() * 1000) - c1720qd.f25532i;
                                    c1720qd.f25538o = intValue;
                                    max = Math.max(intValue, 0L);
                                    c1720qd.f25538o = max;
                                    if (max > 5000000) {
                                        audioTrackPositionTracker$Listener.onInvalidLatency(max);
                                        c1720qd.f25538o = 0L;
                                    }
                                } catch (Exception unused) {
                                    c1720qd.f25537n = null;
                                }
                                c1720qd.f25541r = nanoTime;
                            }
                        }
                        z3 = false;
                        if (z3) {
                        }
                        if (c1720qd.f25540q) {
                            long intValue2 = (((Integer) Util.castNonNull((Integer) method.invoke(Assertions.checkNotNull(c1720qd.f25526c), null))).intValue() * 1000) - c1720qd.f25532i;
                            c1720qd.f25538o = intValue2;
                            max = Math.max(intValue2, 0L);
                            c1720qd.f25538o = max;
                            if (max > 5000000) {
                            }
                            c1720qd.f25541r = nanoTime;
                        }
                    }
                }
            }
            long nanoTime2 = System.nanoTime() / 1000;
            C1683pd c1683pd2 = (C1683pd) Assertions.checkNotNull(c1720qd.f25529f);
            if (c1683pd2.f25121b == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                C1618od c1618od3 = c1683pd2.f25120a;
                if (c1618od3 != null) {
                    j3 = c1618od3.f23775e;
                } else {
                    j3 = -1;
                }
                long j8 = (j3 * 1000000) / c1720qd.f25530g;
                if (c1618od3 != null) {
                    j4 = c1618od3.f23772b.nanoTime / 1000;
                } else {
                    j4 = C0643C.TIME_UNSET;
                }
                j2 = Util.getMediaDurationForPlayoutDuration(nanoTime2 - j4, c1720qd.f25533j) + j8;
            } else {
                if (c1720qd.f25546w == 0) {
                    j = (c1720qd.m7028a() * 1000000) / c1720qd.f25530g;
                } else {
                    j = c1720qd.f25535l + nanoTime2;
                }
                j2 = j;
                if (!z) {
                    j2 = Math.max(0L, j2 - c1720qd.f25538o);
                }
            }
            if (c1720qd.f25521D != z2) {
                c1720qd.f25523F = c1720qd.f25520C;
                c1720qd.f25522E = c1720qd.f25519B;
            }
            long j9 = nanoTime2 - c1720qd.f25523F;
            long j10 = j2;
            if (j9 < 1000000) {
                long mediaDurationForPlayoutDuration2 = Util.getMediaDurationForPlayoutDuration(j9, c1720qd.f25533j) + c1720qd.f25522E;
                long j11 = (j9 * 1000) / 1000000;
                j2 = (((1000 - j11) * mediaDurationForPlayoutDuration2) + (j10 * j11)) / 1000;
            }
            if (!c1720qd.f25534k) {
                long j12 = c1720qd.f25519B;
                if (j2 > j12) {
                    c1720qd.f25534k = true;
                    audioTrackPositionTracker$Listener.onPositionAdvancing(System.currentTimeMillis() - Util.usToMs(Util.getPlayoutDurationForMediaDuration(Util.usToMs(j2 - j12), c1720qd.f25533j)));
                }
            }
            c1720qd.f25520C = nanoTime2;
            c1720qd.f25519B = j2;
            c1720qd.f25521D = z2;
            long min = Math.min(j2, (m2459f() * 1000000) / this.f9730t.f9820e);
            while (true) {
                arrayDeque = this.f9720j;
                if (arrayDeque.isEmpty() || min < ((h00) arrayDeque.getFirst()).f17904d) {
                    break;
                }
                this.f9734x = (h00) arrayDeque.remove();
            }
            h00 h00Var = this.f9734x;
            long j13 = min - h00Var.f17904d;
            boolean equals = h00Var.f17901a.equals(PlaybackParameters.DEFAULT);
            AudioProcessorChain audioProcessorChain = this.f9711b;
            if (equals) {
                mediaDurationForPlayoutDuration = this.f9734x.f17903c + j13;
            } else if (arrayDeque.isEmpty()) {
                mediaDurationForPlayoutDuration = audioProcessorChain.getMediaDuration(j13) + this.f9734x.f17903c;
            } else {
                h00 h00Var2 = (h00) arrayDeque.getFirst();
                mediaDurationForPlayoutDuration = h00Var2.f17903c - Util.getMediaDurationForPlayoutDuration(h00Var2.f17904d - min, this.f9734x.f17901a.speed);
            }
            return ((audioProcessorChain.getSkippedOutputFrameCount() * 1000000) / this.f9730t.f9820e) + mediaDurationForPlayoutDuration;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int getFormatSupport(Format format) {
        if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
            if (!Util.isEncodingLinearPcm(format.pcmEncoding)) {
                Log.m3027w("DefaultAudioSink", "Invalid PCM encoding: " + format.pcmEncoding);
                return 0;
            }
            int i = format.pcmEncoding;
            if (i == 2 || (this.f9713c && i == 4)) {
                return 2;
            }
            return 1;
        }
        if ((this.f9710a0 || !m2468p(format, this.f9732v)) && !this.f9709a.isPassthroughPlaybackSupported(format)) {
            return 0;
        }
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters getPlaybackParameters() {
        if (this.f9721k) {
            return this.f9735y;
        }
        return m2457d().f17901a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean getSkipSilenceEnabled() {
        return m2457d().f17902b;
    }

    /* renamed from: h */
    public final boolean m2461h() {
        if (this.f9731u != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f1, code lost:
    
        if (r5.m7028a() == 0) goto L65;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:73:0x0137. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0183 A[RETURN] */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleBuffer(ByteBuffer byteBuffer, long j, int i) {
        boolean z;
        boolean z2;
        ByteBuffer byteBuffer2 = this.f9695M;
        if (byteBuffer2 != null && byteBuffer != byteBuffer2) {
            z = false;
        } else {
            z = true;
        }
        Assertions.checkArgument(z);
        if (this.f9729s != null) {
            if (!m2456b()) {
                return false;
            }
            C0650d c0650d = this.f9729s;
            C0650d c0650d2 = this.f9730t;
            c0650d.getClass();
            if (c0650d2.f9818c == c0650d.f9818c && c0650d2.f9822g == c0650d.f9822g && c0650d2.f9820e == c0650d.f9820e && c0650d2.f9821f == c0650d.f9821f && c0650d2.f9819d == c0650d.f9819d) {
                this.f9730t = this.f9729s;
                this.f9729s = null;
                if (m2454i(this.f9731u) && this.f9722l != 3) {
                    if (this.f9731u.getPlayState() == 3) {
                        this.f9731u.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack = this.f9731u;
                    Format format = this.f9730t.f9816a;
                    audioTrack.setOffloadDelayPadding(format.encoderDelay, format.encoderPadding);
                    this.f9712b0 = true;
                }
            } else {
                m2462j();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            }
            m2455a(j);
        }
        boolean m2461h = m2461h();
        C1972x6 c1972x6 = this.f9724n;
        if (!m2461h) {
            try {
                if (!m2460g()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e) {
                if (!e.isRecoverable) {
                    c1972x6.m8145i(e);
                    return false;
                }
                throw e;
            }
        }
        c1972x6.f28447c = null;
        if (this.f9690H) {
            this.f9691I = Math.max(0L, j);
            this.f9689G = false;
            this.f9690H = false;
            if (this.f9721k && Util.SDK_INT >= 23) {
                m2466n(this.f9735y);
            }
            m2455a(j);
            if (this.f9703U) {
                play();
            }
        }
        long m2459f = m2459f();
        C1720qd c1720qd = this.f9719i;
        int playState = ((AudioTrack) Assertions.checkNotNull(c1720qd.f25526c)).getPlayState();
        if (c1720qd.f25531h) {
            if (playState == 2) {
                c1720qd.f25539p = false;
            } else if (playState == 1) {
            }
            return false;
        }
        boolean z3 = c1720qd.f25539p;
        boolean m7029b = c1720qd.m7029b(m2459f);
        c1720qd.f25539p = m7029b;
        if (z3 && !m7029b && playState != 1) {
            c1720qd.f25524a.onUnderrun(c1720qd.f25528e, Util.usToMs(c1720qd.f25532i));
        }
        if (this.f9695M == null) {
            if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkArgument(z2);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            C0650d c0650d3 = this.f9730t;
            if (c0650d3.f9818c != 0 && this.f9688F == 0) {
                int i2 = c0650d3.f9822g;
                int i3 = 1024;
                switch (i2) {
                    case 5:
                    case 6:
                    case 18:
                        i3 = Ac3Util.parseAc3SyncframeAudioSampleCount(byteBuffer);
                        this.f9688F = i3;
                        if (i3 == 0) {
                            return true;
                        }
                        break;
                    case 7:
                    case 8:
                        i3 = DtsUtil.parseDtsAudioSampleCount(byteBuffer);
                        this.f9688F = i3;
                        if (i3 == 0) {
                        }
                        break;
                    case 9:
                        i3 = MpegAudioUtil.parseMpegAudioFrameSampleCount(Util.getBigEndianInt(byteBuffer, byteBuffer.position()));
                        if (i3 == -1) {
                            throw new IllegalArgumentException();
                        }
                        this.f9688F = i3;
                        if (i3 == 0) {
                        }
                        break;
                    case 10:
                    case 16:
                        this.f9688F = i3;
                        if (i3 == 0) {
                        }
                        break;
                    case 11:
                    case 12:
                        i3 = 2048;
                        this.f9688F = i3;
                        if (i3 == 0) {
                        }
                        break;
                    case 13:
                    default:
                        throw new IllegalStateException(ye0.m8291k(i2, "Unexpected audio encoding: "));
                    case 14:
                        int findTrueHdSyncframeOffset = Ac3Util.findTrueHdSyncframeOffset(byteBuffer);
                        if (findTrueHdSyncframeOffset == -1) {
                            i3 = 0;
                        } else {
                            i3 = Ac3Util.parseTrueHdSyncframeAudioSampleCount(byteBuffer, findTrueHdSyncframeOffset) * 16;
                        }
                        this.f9688F = i3;
                        if (i3 == 0) {
                        }
                        break;
                    case 15:
                        i3 = 512;
                        this.f9688F = i3;
                        if (i3 == 0) {
                        }
                        break;
                    case 17:
                        i3 = Ac4Util.parseAc4SyncframeAudioSampleCount(byteBuffer);
                        this.f9688F = i3;
                        if (i3 == 0) {
                        }
                        break;
                }
            }
            if (this.f9733w != null) {
                if (!m2456b()) {
                    return false;
                }
                m2455a(j);
                this.f9733w = null;
            }
            long m2458e = (((m2458e() - this.f9715e.f9835l) * 1000000) / this.f9730t.f9816a.sampleRate) + this.f9691I;
            if (!this.f9689G && Math.abs(m2458e - j) > 200000) {
                this.f9728r.onAudioSinkError(new AudioSink.UnexpectedDiscontinuityException(j, m2458e));
                this.f9689G = true;
            }
            if (this.f9689G) {
                if (!m2456b()) {
                    return false;
                }
                long j2 = j - m2458e;
                this.f9691I += j2;
                this.f9689G = false;
                m2455a(j);
                AudioSink.Listener listener = this.f9728r;
                if (listener != null && j2 != 0) {
                    listener.onPositionDiscontinuity();
                }
            }
            if (this.f9730t.f9818c == 0) {
                this.f9684B += byteBuffer.remaining();
            } else {
                this.f9685C = (this.f9688F * i) + this.f9685C;
            }
            this.f9695M = byteBuffer;
            this.f9696N = i;
        }
        m2463k(j);
        if (!this.f9695M.hasRemaining()) {
            this.f9695M = null;
            this.f9696N = 0;
            return true;
        }
        long m2459f2 = m2459f();
        if (c1720qd.f25548y == C0643C.TIME_UNSET || m2459f2 <= 0 || SystemClock.elapsedRealtime() - c1720qd.f25548y < 200) {
            return false;
        }
        Log.m3027w("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        this.f9689G = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        if (m2461h() && this.f9719i.m7029b(m2459f())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        if (m2461h() && (!this.f9701S || hasPendingData())) {
            return false;
        }
        return true;
    }

    /* renamed from: j */
    public final void m2462j() {
        if (!this.f9702T) {
            this.f9702T = true;
            long m2459f = m2459f();
            C1720qd c1720qd = this.f9719i;
            c1720qd.f25549z = c1720qd.m7028a();
            c1720qd.f25547x = SystemClock.elapsedRealtime() * 1000;
            c1720qd.f25518A = m2459f;
            this.f9731u.stop();
            this.f9683A = 0;
        }
    }

    /* renamed from: k */
    public final void m2463k(long j) {
        ByteBuffer byteBuffer;
        int length = this.f9693K.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.f9694L[i - 1];
            } else {
                byteBuffer = this.f9695M;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.EMPTY_BUFFER;
                }
            }
            if (i == length) {
                m2469q(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.f9693K[i];
                if (i > this.f9700R) {
                    audioProcessor.queueInput(byteBuffer);
                }
                ByteBuffer output = audioProcessor.getOutput();
                this.f9694L[i] = output;
                if (output.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    /* renamed from: l */
    public final void m2464l() {
        this.f9684B = 0L;
        this.f9685C = 0L;
        this.f9686D = 0L;
        this.f9687E = 0L;
        int i = 0;
        this.f9712b0 = false;
        this.f9688F = 0;
        this.f9734x = new h00(m2457d().f17901a, getSkipSilenceEnabled(), 0L, 0L);
        this.f9691I = 0L;
        this.f9733w = null;
        this.f9720j.clear();
        this.f9695M = null;
        this.f9696N = 0;
        this.f9697O = null;
        this.f9702T = false;
        this.f9701S = false;
        this.f9700R = -1;
        this.f9736z = null;
        this.f9683A = 0;
        this.f9715e.f9835l = 0L;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.f9693K;
            if (i < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i];
                audioProcessor.flush();
                this.f9694L[i] = audioProcessor.getOutput();
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: m */
    public final void m2465m(PlaybackParameters playbackParameters, boolean z) {
        h00 m2457d = m2457d();
        if (!playbackParameters.equals(m2457d.f17901a) || z != m2457d.f17902b) {
            h00 h00Var = new h00(playbackParameters, z, C0643C.TIME_UNSET, C0643C.TIME_UNSET);
            if (m2461h()) {
                this.f9733w = h00Var;
            } else {
                this.f9734x = h00Var;
            }
        }
    }

    /* renamed from: n */
    public final void m2466n(PlaybackParameters playbackParameters) {
        if (m2461h()) {
            try {
                this.f9731u.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(playbackParameters.speed).setPitch(playbackParameters.pitch).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e) {
                Log.m3028w("DefaultAudioSink", "Failed to set playback params", e);
            }
            playbackParameters = new PlaybackParameters(this.f9731u.getPlaybackParams().getSpeed(), this.f9731u.getPlaybackParams().getPitch());
            float f = playbackParameters.speed;
            C1720qd c1720qd = this.f9719i;
            c1720qd.f25533j = f;
            C1683pd c1683pd = c1720qd.f25529f;
            if (c1683pd != null) {
                c1683pd.m6909a();
            }
        }
        this.f9735y = playbackParameters;
    }

    /* renamed from: o */
    public final boolean m2467o() {
        if (!this.f9707Y && MimeTypes.AUDIO_RAW.equals(this.f9730t.f9816a.sampleMimeType)) {
            int i = this.f9730t.f9816a.pcmEncoding;
            if (!this.f9713c || !Util.isEncodingHighResolutionPcm(i)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: p */
    public final boolean m2468p(Format format, AudioAttributes audioAttributes) {
        int i;
        int encoding;
        int audioTrackChannelConfig;
        boolean isOffloadedPlaybackSupported;
        int i2;
        boolean z;
        boolean z2;
        int i3 = Util.SDK_INT;
        if (i3 < 29 || (i = this.f9722l) == 0 || (encoding = MimeTypes.getEncoding((String) Assertions.checkNotNull(format.sampleMimeType), format.codecs)) == 0 || (audioTrackChannelConfig = Util.getAudioTrackChannelConfig(format.channelCount)) == 0) {
            return false;
        }
        AudioFormat m2453c = m2453c(format.sampleRate, audioTrackChannelConfig, encoding);
        android.media.AudioAttributes audioAttributes2 = audioAttributes.getAudioAttributesV21().audioAttributes;
        if (i3 >= 31) {
            i2 = AudioManager.getPlaybackOffloadSupport(m2453c, audioAttributes2);
        } else {
            isOffloadedPlaybackSupported = AudioManager.isOffloadedPlaybackSupported(m2453c, audioAttributes2);
            if (!isOffloadedPlaybackSupported) {
                i2 = 0;
            } else if (i3 == 30 && Util.MODEL.startsWith("Pixel")) {
                i2 = 2;
            } else {
                i2 = 1;
            }
        }
        if (i2 == 0) {
            return false;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                return true;
            }
            throw new IllegalStateException();
        }
        if (format.encoderDelay == 0 && format.encoderPadding == 0) {
            z = false;
        } else {
            z = true;
        }
        if (i == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.f9703U = false;
        if (m2461h()) {
            C1720qd c1720qd = this.f9719i;
            c1720qd.f25535l = 0L;
            c1720qd.f25546w = 0;
            c1720qd.f25545v = 0;
            c1720qd.f25536m = 0L;
            c1720qd.f25520C = 0L;
            c1720qd.f25523F = 0L;
            c1720qd.f25534k = false;
            if (c1720qd.f25547x == C0643C.TIME_UNSET) {
                ((C1683pd) Assertions.checkNotNull(c1720qd.f25529f)).m6909a();
                this.f9731u.pause();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.f9703U = true;
        if (m2461h()) {
            ((C1683pd) Assertions.checkNotNull(this.f9719i.f25529f)).m6909a();
            this.f9731u.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() {
        if (!this.f9701S && m2461h() && m2456b()) {
            m2462j();
            this.f9701S = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00e3, code lost:
    
        if (r15 < r14) goto L26;
     */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2469q(ByteBuffer byteBuffer, long j) {
        int write;
        boolean z;
        AudioSink.Listener listener;
        boolean z2;
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        ByteBuffer byteBuffer2 = this.f9697O;
        boolean z3 = true;
        boolean z4 = false;
        if (byteBuffer2 != null) {
            if (byteBuffer2 == byteBuffer) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkArgument(z2);
        } else {
            this.f9697O = byteBuffer;
            if (Util.SDK_INT < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.f9698P;
                if (bArr == null || bArr.length < remaining) {
                    this.f9698P = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.f9698P, 0, remaining);
                byteBuffer.position(position);
                this.f9699Q = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        int i = Util.SDK_INT;
        if (i < 21) {
            long j2 = this.f9686D;
            C1720qd c1720qd = this.f9719i;
            int m7028a = c1720qd.f25528e - ((int) (j2 - (c1720qd.m7028a() * c1720qd.f25527d)));
            if (m7028a > 0) {
                write = this.f9731u.write(this.f9698P, this.f9699Q, Math.min(remaining2, m7028a));
                if (write > 0) {
                    this.f9699Q += write;
                    byteBuffer.position(byteBuffer.position() + write);
                }
            }
            write = 0;
        } else if (this.f9707Y) {
            if (j != C0643C.TIME_UNSET) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            AudioTrack audioTrack = this.f9731u;
            if (i >= 26) {
                write = audioTrack.write(byteBuffer, remaining2, 1, j * 1000);
            } else {
                if (this.f9736z == null) {
                    ByteBuffer allocate = ByteBuffer.allocate(16);
                    this.f9736z = allocate;
                    allocate.order(ByteOrder.BIG_ENDIAN);
                    this.f9736z.putInt(1431633921);
                }
                if (this.f9683A == 0) {
                    this.f9736z.putInt(4, remaining2);
                    this.f9736z.putLong(8, j * 1000);
                    this.f9736z.position(0);
                    this.f9683A = remaining2;
                }
                int remaining3 = this.f9736z.remaining();
                if (remaining3 > 0) {
                    int write2 = audioTrack.write(this.f9736z, remaining3, 1);
                    if (write2 < 0) {
                        this.f9683A = 0;
                        write = write2;
                    }
                }
                write = audioTrack.write(byteBuffer, remaining2, 1);
                if (write < 0) {
                    this.f9683A = 0;
                } else {
                    this.f9683A -= write;
                }
            }
        } else {
            write = this.f9731u.write(byteBuffer, remaining2, 1);
        }
        this.f9708Z = SystemClock.elapsedRealtime();
        C1972x6 c1972x6 = this.f9725o;
        if (write < 0) {
            if ((i >= 24 && write == -6) || write == -32) {
                z4 = true;
            }
            if (z4 && this.f9730t.f9818c == 1) {
                this.f9710a0 = true;
            }
            AudioSink.WriteException writeException = new AudioSink.WriteException(write, this.f9730t.f9816a, z4);
            AudioSink.Listener listener2 = this.f9728r;
            if (listener2 != null) {
                listener2.onAudioSinkError(writeException);
            }
            if (!writeException.isRecoverable) {
                c1972x6.m8145i(writeException);
                return;
            }
            throw writeException;
        }
        c1972x6.f28447c = null;
        if (m2454i(this.f9731u)) {
            if (this.f9687E > 0) {
                this.f9712b0 = false;
            }
            if (this.f9703U && (listener = this.f9728r) != null && write < remaining2 && !this.f9712b0) {
                listener.onOffloadBufferFull();
            }
        }
        int i2 = this.f9730t.f9818c;
        if (i2 == 0) {
            this.f9686D += write;
        }
        if (write == remaining2) {
            if (i2 != 0) {
                if (byteBuffer != this.f9695M) {
                    z3 = false;
                }
                Assertions.checkState(z3);
                this.f9687E = (this.f9688F * this.f9696N) + this.f9687E;
            }
            this.f9697O = null;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        flush();
        for (AudioProcessor audioProcessor : this.f9716f) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.f9717g) {
            audioProcessor2.reset();
        }
        this.f9703U = false;
        this.f9710a0 = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes) {
        if (this.f9732v.equals(audioAttributes)) {
            return;
        }
        this.f9732v = audioAttributes;
        if (this.f9707Y) {
            return;
        }
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i) {
        boolean z;
        if (this.f9705W != i) {
            this.f9705W = i;
            if (i != 0) {
                z = true;
            } else {
                z = false;
            }
            this.f9704V = z;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        if (this.f9706X.equals(auxEffectInfo)) {
            return;
        }
        int i = auxEffectInfo.effectId;
        float f = auxEffectInfo.sendLevel;
        AudioTrack audioTrack = this.f9731u;
        if (audioTrack != null) {
            if (this.f9706X.effectId != i) {
                audioTrack.attachAuxEffect(i);
            }
            if (i != 0) {
                this.f9731u.setAuxEffectSendLevel(f);
            }
        }
        this.f9706X = auxEffectInfo;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setListener(AudioSink.Listener listener) {
        this.f9728r = listener;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        PlaybackParameters playbackParameters2 = new PlaybackParameters(Util.constrainValue(playbackParameters.speed, 0.1f, 8.0f), Util.constrainValue(playbackParameters.pitch, 0.1f, 8.0f));
        if (this.f9721k && Util.SDK_INT >= 23) {
            m2466n(playbackParameters2);
        } else {
            m2465m(playbackParameters2, getSkipSilenceEnabled());
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setPlayerId(@Nullable PlayerId playerId) {
        this.f9727q = playerId;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setSkipSilenceEnabled(boolean z) {
        m2465m(m2457d().f17901a, z);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        if (this.f9692J != f) {
            this.f9692J = f;
            if (m2461h()) {
                if (Util.SDK_INT >= 21) {
                    this.f9731u.setVolume(this.f9692J);
                    return;
                }
                AudioTrack audioTrack = this.f9731u;
                float f2 = this.f9692J;
                audioTrack.setStereoVolume(f2, f2);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean supportsFormat(Format format) {
        if (getFormatSupport(format) != 0) {
            return true;
        }
        return false;
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.audio.DefaultAudioSink"}, replacement = "new DefaultAudioSink.Builder().setAudioCapabilities(audioCapabilities).setAudioProcessors(audioProcessors).setEnableFloatOutput(enableFloatOutput).build()")
    @InlineMeValidationDisabled("Migrate constructor to Builder")
    @Deprecated
    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessorArr, boolean z) {
        this(new Builder().setAudioCapabilities((AudioCapabilities) MoreObjects.firstNonNull(audioCapabilities, AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES)).setAudioProcessors(audioProcessorArr).setEnableFloatOutput(z));
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.audio.DefaultAudioSink"}, replacement = "new DefaultAudioSink.Builder().setAudioCapabilities(audioCapabilities).setAudioProcessorChain(audioProcessorChain).setEnableFloatOutput(enableFloatOutput).setEnableAudioTrackPlaybackParams(enableAudioTrackPlaybackParams).setOffloadMode(offloadMode).build()")
    @InlineMeValidationDisabled("Migrate constructor to Builder")
    @Deprecated
    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities, AudioProcessorChain audioProcessorChain, boolean z, boolean z2, int i) {
        this(new Builder().setAudioCapabilities((AudioCapabilities) MoreObjects.firstNonNull(audioCapabilities, AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES)).setAudioProcessorChain(audioProcessorChain).setEnableFloatOutput(z).setEnableAudioTrackPlaybackParams(z2).setOffloadMode(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4, types: [com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.a] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.j] */
    public DefaultAudioSink(Builder builder) {
        this.f9709a = builder.f9737a;
        AudioProcessorChain audioProcessorChain = builder.f9738b;
        this.f9711b = audioProcessorChain;
        int i = Util.SDK_INT;
        this.f9713c = i >= 21 && builder.f9739c;
        this.f9721k = i >= 23 && builder.f9740d;
        this.f9722l = i >= 29 ? builder.f9741e : 0;
        this.f9726p = builder.f9742f;
        ConditionVariable conditionVariable = new ConditionVariable(Clock.DEFAULT);
        this.f9718h = conditionVariable;
        conditionVariable.open();
        this.f9719i = new C1720qd(new C0651e(this));
        ?? baseAudioProcessor = new BaseAudioProcessor();
        this.f9714d = baseAudioProcessor;
        ?? baseAudioProcessor2 = new BaseAudioProcessor();
        baseAudioProcessor2.f9833j = Util.EMPTY_BYTE_ARRAY;
        this.f9715e = baseAudioProcessor2;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new BaseAudioProcessor(), baseAudioProcessor, baseAudioProcessor2);
        Collections.addAll(arrayList, audioProcessorChain.getAudioProcessors());
        this.f9716f = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.f9717g = new AudioProcessor[]{new BaseAudioProcessor()};
        this.f9692J = 1.0f;
        this.f9732v = AudioAttributes.DEFAULT;
        this.f9705W = 0;
        this.f9706X = new AuxEffectInfo(0, RecyclerView.f7068F0);
        PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
        this.f9734x = new h00(playbackParameters, false, 0L, 0L);
        this.f9735y = playbackParameters;
        this.f9700R = -1;
        this.f9693K = new AudioProcessor[0];
        this.f9694L = new ByteBuffer[0];
        this.f9720j = new ArrayDeque();
        this.f9724n = new C1972x6(2);
        this.f9725o = new C1972x6(2);
    }
}
