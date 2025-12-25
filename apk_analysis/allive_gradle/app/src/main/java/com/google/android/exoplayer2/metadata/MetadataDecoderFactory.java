package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;

/* loaded from: classes.dex */
public interface MetadataDecoderFactory {
    public static final MetadataDecoderFactory DEFAULT = new Object();

    MetadataDecoder createDecoder(Format format);

    boolean supportsFormat(Format format);
}
