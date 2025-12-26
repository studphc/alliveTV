package com.google.android.exoplayer2.text;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import p000.ub0;
import p000.vb0;

/* loaded from: classes.dex */
public final class ExoplayerCuesDecoder implements SubtitleDecoder {

    /* renamed from: a */
    public final CueDecoder f11735a = new CueDecoder();

    /* renamed from: b */
    public final SubtitleInputBuffer f11736b = new SubtitleInputBuffer();

    /* renamed from: c */
    public final ArrayDeque f11737c = new ArrayDeque();

    /* renamed from: d */
    public int f11738d;

    /* renamed from: e */
    public boolean f11739e;

    public ExoplayerCuesDecoder() {
        for (int i = 0; i < 2; i++) {
            this.f11737c.addFirst(new ub0(this, 0));
        }
        this.f11738d = 0;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        Assertions.checkState(!this.f11739e);
        this.f11736b.clear();
        this.f11738d = 0;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "ExoplayerCuesDecoder";
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        this.f11739e = true;
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public SubtitleInputBuffer dequeueInputBuffer() {
        Assertions.checkState(!this.f11739e);
        if (this.f11738d != 0) {
            return null;
        }
        this.f11738d = 1;
        return this.f11736b;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public SubtitleOutputBuffer dequeueOutputBuffer() {
        Assertions.checkState(!this.f11739e);
        if (this.f11738d != 2) {
            return null;
        }
        ArrayDeque arrayDeque = this.f11737c;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) arrayDeque.removeFirst();
        SubtitleInputBuffer subtitleInputBuffer = this.f11736b;
        if (subtitleInputBuffer.isEndOfStream()) {
            subtitleOutputBuffer.addFlag(4);
        } else {
            subtitleOutputBuffer.setContent(subtitleInputBuffer.timeUs, new vb0(subtitleInputBuffer.timeUs, this.f11735a.decode(((ByteBuffer) Assertions.checkNotNull(subtitleInputBuffer.data)).array())), 0L);
        }
        subtitleInputBuffer.clear();
        this.f11738d = 0;
        return subtitleOutputBuffer;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) {
        Assertions.checkState(!this.f11739e);
        Assertions.checkState(this.f11738d == 1);
        Assertions.checkArgument(this.f11736b == subtitleInputBuffer);
        this.f11738d = 2;
    }
}
