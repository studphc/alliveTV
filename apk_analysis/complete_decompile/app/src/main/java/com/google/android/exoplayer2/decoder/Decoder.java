package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;

/* loaded from: classes.dex */
public interface Decoder<I, O, E extends DecoderException> {
    @Nullable
    I dequeueInputBuffer();

    @Nullable
    O dequeueOutputBuffer();

    void flush();

    String getName();

    void queueInputBuffer(I i);

    void release();
}
