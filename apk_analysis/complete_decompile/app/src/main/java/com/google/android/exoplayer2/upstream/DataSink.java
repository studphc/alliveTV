package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public interface DataSink {

    /* loaded from: classes.dex */
    public interface Factory {
        DataSink createDataSink();
    }

    void close();

    void open(DataSpec dataSpec);

    void write(byte[] bArr, int i, int i2);
}
