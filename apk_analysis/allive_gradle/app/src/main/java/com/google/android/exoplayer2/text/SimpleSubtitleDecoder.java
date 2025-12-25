package com.google.android.exoplayer2.text;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;
import p000.ub0;

/* loaded from: classes.dex */
public abstract class SimpleSubtitleDecoder extends SimpleDecoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder {

    /* renamed from: n */
    public final String f11740n;

    public SimpleSubtitleDecoder(String str) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        this.f11740n = str;
        setInitialInputBufferSize(1024);
    }

    public abstract Subtitle decode(byte[] bArr, int i, boolean z);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final String getName() {
        return this.f11740n;
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public final SubtitleInputBuffer createInputBuffer() {
        return new SubtitleInputBuffer();
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public final SubtitleOutputBuffer createOutputBuffer() {
        return new ub0(this, 1);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public final SubtitleDecoderException createUnexpectedDecodeException(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    @Nullable
    public final SubtitleDecoderException decode(SubtitleInputBuffer subtitleInputBuffer, SubtitleOutputBuffer subtitleOutputBuffer, boolean z) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(subtitleInputBuffer.data);
            subtitleOutputBuffer.setContent(subtitleInputBuffer.timeUs, decode(byteBuffer.array(), byteBuffer.limit(), z), subtitleInputBuffer.subsampleOffsetUs);
            subtitleOutputBuffer.clearFlag(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }
}
