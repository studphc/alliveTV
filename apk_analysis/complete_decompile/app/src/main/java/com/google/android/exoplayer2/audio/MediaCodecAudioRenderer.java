package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import p000.qa2;

/* loaded from: classes.dex */
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {

    /* renamed from: F0 */
    public final Context f9756F0;

    /* renamed from: G0 */
    public final AudioRendererEventListener.EventDispatcher f9757G0;

    /* renamed from: H0 */
    public final AudioSink f9758H0;

    /* renamed from: I0 */
    public int f9759I0;

    /* renamed from: J0 */
    public boolean f9760J0;

    /* renamed from: K0 */
    public Format f9761K0;

    /* renamed from: L0 */
    public long f9762L0;

    /* renamed from: M0 */
    public boolean f9763M0;

    /* renamed from: N0 */
    public boolean f9764N0;

    /* renamed from: O0 */
    public boolean f9765O0;

    /* renamed from: P0 */
    public boolean f9766P0;

    /* renamed from: Q0 */
    public Renderer.WakeupListener f9767Q0;

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, null, null);
    }

    /* renamed from: r */
    public static ImmutableList m2470r(MediaCodecSelector mediaCodecSelector, Format format, boolean z, AudioSink audioSink) {
        MediaCodecInfo decryptOnlyDecoderInfo;
        String str = format.sampleMimeType;
        if (str == null) {
            return ImmutableList.m3902of();
        }
        if (audioSink.supportsFormat(format) && (decryptOnlyDecoderInfo = MediaCodecUtil.getDecryptOnlyDecoderInfo()) != null) {
            return ImmutableList.m3903of(decryptOnlyDecoderInfo);
        }
        List<MediaCodecInfo> decoderInfos = mediaCodecSelector.getDecoderInfos(str, z, false);
        String alternativeCodecMimeType = MediaCodecUtil.getAlternativeCodecMimeType(format);
        if (alternativeCodecMimeType == null) {
            return ImmutableList.copyOf((Collection) decoderInfos);
        }
        return ImmutableList.builder().addAll((Iterable) decoderInfos).addAll((Iterable) mediaCodecSelector.getDecoderInfos(alternativeCodecMimeType, z, false)).build();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        int i;
        DecoderReuseEvaluation canReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i2 = canReuseCodec.discardReasons;
        if (m2471q(mediaCodecInfo, format2) > this.f9759I0) {
            i2 |= 64;
        }
        int i3 = i2;
        String str = mediaCodecInfo.name;
        if (i3 != 0) {
            i = 0;
        } else {
            i = canReuseCodec.result;
        }
        return new DecoderReuseEvaluation(str, format, format2, i, i3);
    }

    public void experimentalSetEnableKeepAudioTrackOnSeek(boolean z) {
        this.f9766P0 = z;
    }

    public int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int m2471q = m2471q(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            return m2471q;
        }
        for (Format format2 : formatArr) {
            if (mediaCodecInfo.canReuseCodec(format, format2).result != 0) {
                m2471q = Math.max(m2471q, m2471q(mediaCodecInfo, format2));
            }
        }
        return m2471q;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        int i = -1;
        for (Format format2 : formatArr) {
            int i2 = format2.sampleRate;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return f * i;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) {
        return MediaCodecUtil.getDecoderInfosSortedByFormatSupport(m2470r(mediaCodecSelector, format, z, this.f9758H0), format);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    @Nullable
    public MediaClock getMediaClock() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, @Nullable MediaCrypto mediaCrypto, float f) {
        boolean z;
        Format format2;
        this.f9759I0 = getCodecMaxInputSize(mediaCodecInfo, format, getStreamFormats());
        String str = mediaCodecInfo.name;
        if (Util.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(Util.MANUFACTURER)) {
            String str2 = Util.DEVICE;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                z = true;
                this.f9760J0 = z;
                MediaFormat mediaFormat = getMediaFormat(format, mediaCodecInfo.codecMimeType, this.f9759I0, f);
                if (!MimeTypes.AUDIO_RAW.equals(mediaCodecInfo.mimeType) && !MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
                    format2 = format;
                } else {
                    format2 = null;
                }
                this.f9761K0 = format2;
                return MediaCodecAdapter.Configuration.createForAudioDecoding(mediaCodecInfo, mediaFormat, format, mediaCrypto);
            }
        }
        z = false;
        this.f9760J0 = z;
        MediaFormat mediaFormat2 = getMediaFormat(format, mediaCodecInfo.codecMimeType, this.f9759I0, f);
        if (!MimeTypes.AUDIO_RAW.equals(mediaCodecInfo.mimeType)) {
        }
        format2 = null;
        this.f9761K0 = format2;
        return MediaCodecAdapter.Configuration.createForAudioDecoding(mediaCodecInfo, mediaFormat2, format, mediaCrypto);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0046, code lost:
    
        if ("AXON 7 mini".equals(r6) == false) goto L12;
     */
    @SuppressLint({"InlinedApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MediaFormat getMediaFormat(Format format, String str, int i, float f) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", format.channelCount);
        mediaFormat.setInteger("sample-rate", format.sampleRate);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", i);
        int i2 = Util.SDK_INT;
        if (i2 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                if (i2 == 23) {
                    String str2 = Util.MODEL;
                    if (!"ZTE B2017G".equals(str2)) {
                    }
                }
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (i2 <= 28 && MimeTypes.AUDIO_AC4.equals(format.sampleMimeType)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i2 >= 24) {
            if (this.f9758H0.getFormatSupport(Util.getPcmFormat(4, format.channelCount, format.sampleRate)) == 2) {
                mediaFormat.setInteger("pcm-encoding", 4);
            }
        }
        if (i2 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return this.f9758H0.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (getState() == 2) {
            m2472s();
        }
        return this.f9762L0;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) {
        AudioSink audioSink = this.f9758H0;
        if (i != 2) {
            if (i != 3) {
                if (i != 6) {
                    switch (i) {
                        case 9:
                            audioSink.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
                            return;
                        case 10:
                            audioSink.setAudioSessionId(((Integer) obj).intValue());
                            return;
                        case 11:
                            this.f9767Q0 = (Renderer.WakeupListener) obj;
                            return;
                        default:
                            super.handleMessage(i, obj);
                            return;
                    }
                }
                audioSink.setAuxEffectInfo((AuxEffectInfo) obj);
                return;
            }
            audioSink.setAudioAttributes((AudioAttributes) obj);
            return;
        }
        audioSink.setVolume(((Float) obj).floatValue());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        if (super.isEnded() && this.f9758H0.isEnded()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (!this.f9758H0.hasPendingData() && !super.isReady()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecError(Exception exc) {
        Log.m3024e("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.f9757G0.audioCodecError(exc);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j, long j2) {
        this.f9757G0.decoderInitialized(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecReleased(String str) {
        this.f9757G0.decoderReleased(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.f9757G0;
        this.f9765O0 = true;
        try {
            this.f9758H0.flush();
            try {
                super.onDisabled();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.onDisabled();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) {
        super.onEnabled(z, z2);
        this.f9757G0.enabled(this.decoderCounters);
        boolean z3 = getConfiguration().tunneling;
        AudioSink audioSink = this.f9758H0;
        if (z3) {
            audioSink.enableTunnelingV21();
        } else {
            audioSink.disableTunneling();
        }
        audioSink.setPlayerId(getPlayerId());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) {
        DecoderReuseEvaluation onInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.f9757G0.inputFormatChanged(formatHolder.format, onInputFormatChanged);
        return onInputFormatChanged;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(Format format, @Nullable MediaFormat mediaFormat) {
        int i;
        int i2;
        Format format2 = this.f9761K0;
        int[] iArr = null;
        if (format2 != null) {
            format = format2;
        } else if (getCodec() != null) {
            if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
                i = format.pcmEncoding;
            } else if (Util.SDK_INT >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                i = Util.getPcmEncoding(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                i = 2;
            }
            Format build = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_RAW).setPcmEncoding(i).setEncoderDelay(format.encoderDelay).setEncoderPadding(format.encoderPadding).setChannelCount(mediaFormat.getInteger("channel-count")).setSampleRate(mediaFormat.getInteger("sample-rate")).build();
            if (this.f9760J0 && build.channelCount == 6 && (i2 = format.channelCount) < 6) {
                iArr = new int[i2];
                for (int i3 = 0; i3 < format.channelCount; i3++) {
                    iArr[i3] = i3;
                }
            }
            format = build;
        }
        try {
            this.f9758H0.configure(format, 0, iArr);
        } catch (AudioSink.ConfigurationException e) {
            throw createRendererException(e, e.format, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
        }
    }

    @CallSuper
    public void onPositionDiscontinuity() {
        this.f9764N0 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        super.onPositionReset(j, z);
        boolean z2 = this.f9766P0;
        AudioSink audioSink = this.f9758H0;
        if (z2) {
            audioSink.experimentalFlushWithoutAudioTrackRelease();
        } else {
            audioSink.flush();
        }
        this.f9762L0 = j;
        this.f9763M0 = true;
        this.f9764N0 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        this.f9758H0.handleDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (this.f9763M0 && !decoderInputBuffer.isDecodeOnly()) {
            if (Math.abs(decoderInputBuffer.timeUs - this.f9762L0) > 500000) {
                this.f9762L0 = decoderInputBuffer.timeUs;
            }
            this.f9763M0 = false;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onReset() {
        AudioSink audioSink = this.f9758H0;
        try {
            super.onReset();
        } finally {
            if (this.f9765O0) {
                this.f9765O0 = false;
                audioSink.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        super.onStarted();
        this.f9758H0.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        m2472s();
        this.f9758H0.pause();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j, long j2, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) {
        Assertions.checkNotNull(byteBuffer);
        if (this.f9761K0 != null && (i2 & 2) != 0) {
            ((MediaCodecAdapter) Assertions.checkNotNull(mediaCodecAdapter)).releaseOutputBuffer(i, false);
            return true;
        }
        AudioSink audioSink = this.f9758H0;
        if (z) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.releaseOutputBuffer(i, false);
            }
            this.decoderCounters.skippedOutputBufferCount += i3;
            audioSink.handleDiscontinuity();
            return true;
        }
        try {
            if (!audioSink.handleBuffer(byteBuffer, j3, i3)) {
                return false;
            }
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.releaseOutputBuffer(i, false);
            }
            this.decoderCounters.renderedOutputBufferCount += i3;
            return true;
        } catch (AudioSink.InitializationException e) {
            throw createRendererException(e, e.format, e.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
        } catch (AudioSink.WriteException e2) {
            throw createRendererException(e2, format, e2.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
        }
    }

    /* renamed from: q */
    public final int m2471q(MediaCodecInfo mediaCodecInfo, Format format) {
        int i;
        if ("OMX.google.raw.decoder".equals(mediaCodecInfo.name) && (i = Util.SDK_INT) < 24 && (i != 23 || !Util.isTv(this.f9756F0))) {
            return -1;
        }
        return format.maxInputSize;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void renderToEndOfStream() {
        try {
            this.f9758H0.playToEndOfStream();
        } catch (AudioSink.WriteException e) {
            throw createRendererException(e, e.format, e.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
        }
    }

    /* renamed from: s */
    public final void m2472s() {
        long currentPositionUs = this.f9758H0.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.f9764N0) {
                currentPositionUs = Math.max(this.f9762L0, currentPositionUs);
            }
            this.f9762L0 = currentPositionUs;
            this.f9764N0 = false;
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.f9758H0.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldUseBypass(Format format) {
        return this.f9758H0.supportsFormat(format);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) {
        int i;
        boolean z;
        boolean z2;
        int i2;
        int i3 = 0;
        if (!MimeTypes.isAudio(format.sampleMimeType)) {
            return qa2.m7011a(0);
        }
        if (Util.SDK_INT >= 21) {
            i = 32;
        } else {
            i = 0;
        }
        boolean z3 = true;
        if (format.cryptoType != 0) {
            z = true;
        } else {
            z = false;
        }
        boolean supportsFormatDrm = MediaCodecRenderer.supportsFormatDrm(format);
        int i4 = 8;
        int i5 = 4;
        AudioSink audioSink = this.f9758H0;
        if (supportsFormatDrm && audioSink.supportsFormat(format) && (!z || MediaCodecUtil.getDecryptOnlyDecoderInfo() != null)) {
            return qa2.m7012b(4, 8, i);
        }
        if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType) && !audioSink.supportsFormat(format)) {
            return qa2.m7011a(1);
        }
        if (!audioSink.supportsFormat(Util.getPcmFormat(2, format.channelCount, format.sampleRate))) {
            return qa2.m7011a(1);
        }
        ImmutableList m2470r = m2470r(mediaCodecSelector, format, false, audioSink);
        if (m2470r.isEmpty()) {
            return qa2.m7011a(1);
        }
        if (!supportsFormatDrm) {
            return qa2.m7011a(2);
        }
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) m2470r.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        if (!isFormatSupported) {
            for (int i6 = 1; i6 < m2470r.size(); i6++) {
                MediaCodecInfo mediaCodecInfo2 = (MediaCodecInfo) m2470r.get(i6);
                if (mediaCodecInfo2.isFormatSupported(format)) {
                    z2 = false;
                    mediaCodecInfo = mediaCodecInfo2;
                    break;
                }
            }
        }
        z2 = true;
        z3 = isFormatSupported;
        if (!z3) {
            i5 = 3;
        }
        if (z3 && mediaCodecInfo.isSeamlessAdaptationSupported(format)) {
            i4 = 16;
        }
        if (mediaCodecInfo.hardwareAccelerated) {
            i2 = 64;
        } else {
            i2 = 0;
        }
        if (z2) {
            i3 = 128;
        }
        return qa2.m7013c(i5, i4, i, i2, i3);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
        this(context, mediaCodecSelector, handler, audioRendererEventListener, AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES, new AudioProcessor[0]);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(context, mediaCodecSelector, handler, audioRendererEventListener, new DefaultAudioSink.Builder().setAudioCapabilities((AudioCapabilities) MoreObjects.firstNonNull(audioCapabilities, AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES)).setAudioProcessors(audioProcessorArr).build());
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, false, handler, audioRendererEventListener, audioSink);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, boolean z, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, z, handler, audioRendererEventListener, audioSink);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1, factory, mediaCodecSelector, z, 44100.0f);
        this.f9756F0 = context.getApplicationContext();
        this.f9758H0 = audioSink;
        this.f9757G0 = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        audioSink.setListener(new C0654h(this));
    }
}
