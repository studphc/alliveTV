package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.net.URLDecoder;

/* loaded from: classes.dex */
public final class DataSchemeDataSource extends BaseDataSource {
    public static final String SCHEME_DATA = "data";

    /* renamed from: e */
    public DataSpec f12412e;

    /* renamed from: f */
    public byte[] f12413f;

    /* renamed from: g */
    public int f12414g;

    /* renamed from: h */
    public int f12415h;

    public DataSchemeDataSource() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if (this.f12413f != null) {
            this.f12413f = null;
            transferEnded();
        }
        this.f12412e = null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        DataSpec dataSpec = this.f12412e;
        if (dataSpec != null) {
            return dataSpec.uri;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        transferInitializing(dataSpec);
        this.f12412e = dataSpec;
        Uri uri = dataSpec.uri;
        String scheme = uri.getScheme();
        Assertions.checkArgument(SCHEME_DATA.equals(scheme), "Unsupported scheme: " + scheme);
        String[] split = Util.split(uri.getSchemeSpecificPart(), ",");
        if (split.length == 2) {
            String str = split[1];
            if (split[0].contains(";base64")) {
                try {
                    this.f12413f = Base64.decode(str, 0);
                } catch (IllegalArgumentException e) {
                    throw ParserException.createForMalformedDataOfUnknownType("Error while parsing Base64 encoded string: " + str, e);
                }
            } else {
                this.f12413f = Util.getUtf8Bytes(URLDecoder.decode(str, Charsets.US_ASCII.name()));
            }
            long j = dataSpec.position;
            byte[] bArr = this.f12413f;
            if (j <= bArr.length) {
                int i = (int) j;
                this.f12414g = i;
                int length = bArr.length - i;
                this.f12415h = length;
                long j2 = dataSpec.length;
                if (j2 != -1) {
                    this.f12415h = (int) Math.min(length, j2);
                }
                transferStarted(dataSpec);
                long j3 = dataSpec.length;
                if (j3 == -1) {
                    return this.f12415h;
                }
                return j3;
            }
            this.f12413f = null;
            throw new DataSourceException(2008);
        }
        throw ParserException.createForMalformedDataOfUnknownType("Unexpected URI format: " + uri, null);
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.f12415h;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(Util.castNonNull(this.f12413f), this.f12414g, bArr, i, min);
        this.f12414g += min;
        this.f12415h -= min;
        bytesTransferred(min);
        return min;
    }
}
