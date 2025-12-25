package com.google.android.exoplayer2.util;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.widget.TextView;
import androidx.core.os.EnvironmentCompat;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import java.util.Locale;
import p000.AbstractC1726qj;
import p000.RunnableC2074zy;

/* loaded from: classes.dex */
public class DebugTextViewHelper {

    /* renamed from: a */
    public final ExoPlayer f12681a;

    /* renamed from: b */
    public final TextView f12682b;

    /* renamed from: c */
    public final RunnableC2074zy f12683c;

    /* renamed from: d */
    public boolean f12684d;

    public DebugTextViewHelper(ExoPlayer exoPlayer, TextView textView) {
        boolean z;
        if (exoPlayer.getApplicationLooper() == Looper.getMainLooper()) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        this.f12681a = exoPlayer;
        this.f12682b = textView;
        this.f12683c = new RunnableC2074zy(this);
    }

    /* renamed from: a */
    public static String m3010a(DecoderCounters decoderCounters) {
        decoderCounters.ensureUpdated();
        return " sib:" + decoderCounters.skippedInputBufferCount + " sb:" + decoderCounters.skippedOutputBufferCount + " rb:" + decoderCounters.renderedOutputBufferCount + " db:" + decoderCounters.droppedBufferCount + " mcdb:" + decoderCounters.maxConsecutiveDroppedBufferCount + " dk:" + decoderCounters.droppedToKeyframeCount;
    }

    public String getAudioString() {
        ExoPlayer exoPlayer = this.f12681a;
        Format audioFormat = exoPlayer.getAudioFormat();
        DecoderCounters audioDecoderCounters = exoPlayer.getAudioDecoderCounters();
        if (audioFormat != null && audioDecoderCounters != null) {
            return "\n" + audioFormat.sampleMimeType + "(id:" + audioFormat.f9354id + " hz:" + audioFormat.sampleRate + " ch:" + audioFormat.channelCount + m3010a(audioDecoderCounters) + ")";
        }
        return "";
    }

    public String getDebugString() {
        return getPlayerStateString() + getVideoString() + getAudioString();
    }

    public String getPlayerStateString() {
        String str;
        ExoPlayer exoPlayer = this.f12681a;
        int playbackState = exoPlayer.getPlaybackState();
        if (playbackState != 1) {
            if (playbackState != 2) {
                if (playbackState != 3) {
                    if (playbackState != 4) {
                        str = EnvironmentCompat.MEDIA_UNKNOWN;
                    } else {
                        str = "ended";
                    }
                } else {
                    str = "ready";
                }
            } else {
                str = "buffering";
            }
        } else {
            str = "idle";
        }
        return "playWhenReady:" + exoPlayer.getPlayWhenReady() + " playbackState:" + str + " item:" + exoPlayer.getCurrentMediaItemIndex();
    }

    public String getVideoString() {
        String valueOf;
        ExoPlayer exoPlayer = this.f12681a;
        Format videoFormat = exoPlayer.getVideoFormat();
        DecoderCounters videoDecoderCounters = exoPlayer.getVideoDecoderCounters();
        String str = "";
        if (videoFormat == null || videoDecoderCounters == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("\n");
        sb.append(videoFormat.sampleMimeType);
        sb.append("(id:");
        sb.append(videoFormat.f9354id);
        sb.append(" r:");
        sb.append(videoFormat.width);
        sb.append("x");
        sb.append(videoFormat.height);
        float f = videoFormat.pixelWidthHeightRatio;
        if (f != -1.0f && f != 1.0f) {
            str = " par:".concat(String.format(Locale.US, "%.02f", Float.valueOf(f)));
        }
        sb.append(str);
        sb.append(m3010a(videoDecoderCounters));
        sb.append(" vfpo: ");
        long j = videoDecoderCounters.totalVideoFrameProcessingOffsetUs;
        int i = videoDecoderCounters.videoFrameProcessingOffsetCount;
        if (i == 0) {
            valueOf = "N/A";
        } else {
            valueOf = String.valueOf((long) (j / i));
        }
        return AbstractC1726qj.m7061q(sb, valueOf, ")");
    }

    public final void start() {
        if (this.f12684d) {
            return;
        }
        this.f12684d = true;
        this.f12681a.addListener(this.f12683c);
        updateAndPost();
    }

    public final void stop() {
        if (!this.f12684d) {
            return;
        }
        this.f12684d = false;
        ExoPlayer exoPlayer = this.f12681a;
        RunnableC2074zy runnableC2074zy = this.f12683c;
        exoPlayer.removeListener(runnableC2074zy);
        this.f12682b.removeCallbacks(runnableC2074zy);
    }

    @SuppressLint({"SetTextI18n"})
    public final void updateAndPost() {
        String debugString = getDebugString();
        TextView textView = this.f12682b;
        textView.setText(debugString);
        RunnableC2074zy runnableC2074zy = this.f12683c;
        textView.removeCallbacks(runnableC2074zy);
        textView.postDelayed(runnableC2074zy, 1000L);
    }
}
