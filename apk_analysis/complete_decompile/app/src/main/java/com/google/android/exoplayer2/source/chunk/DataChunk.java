package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class DataChunk extends Chunk {

    /* renamed from: a */
    public byte[] f11182a;

    /* renamed from: b */
    public volatile boolean f11183b;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i, Format format, int i2, @Nullable Object obj, @Nullable byte[] bArr) {
        super(dataSource, dataSpec, i, format, i2, obj, C0643C.TIME_UNSET, C0643C.TIME_UNSET);
        DataChunk dataChunk;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = Util.EMPTY_BYTE_ARRAY;
            dataChunk = this;
        } else {
            dataChunk = this;
            bArr2 = bArr;
        }
        dataChunk.f11182a = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.f11183b = true;
    }

    public abstract void consume(byte[] bArr, int i);

    public byte[] getDataHolder() {
        return this.f11182a;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() {
        try {
            this.dataSource.open(this.dataSpec);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.f11183b) {
                byte[] bArr = this.f11182a;
                if (bArr.length < i2 + 16384) {
                    this.f11182a = Arrays.copyOf(bArr, bArr.length + 16384);
                }
                i = this.dataSource.read(this.f11182a, i2, 16384);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.f11183b) {
                consume(this.f11182a, i2);
            }
            DataSourceUtil.closeQuietly(this.dataSource);
        } catch (Throwable th) {
            DataSourceUtil.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
