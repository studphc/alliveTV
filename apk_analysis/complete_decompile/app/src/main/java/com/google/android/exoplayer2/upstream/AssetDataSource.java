package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class AssetDataSource extends BaseDataSource {

    /* renamed from: e */
    public final AssetManager f12385e;

    /* renamed from: f */
    public Uri f12386f;

    /* renamed from: g */
    public InputStream f12387g;

    /* renamed from: h */
    public long f12388h;

    /* renamed from: i */
    public boolean f12389i;

    /* loaded from: classes.dex */
    public static final class AssetDataSourceException extends DataSourceException {
        @Deprecated
        public AssetDataSourceException(IOException iOException) {
            super(iOException, 2000);
        }

        public AssetDataSourceException(@Nullable Throwable th, int i) {
            super(th, i);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f12385e = context.getAssets();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.f12386f = null;
        try {
            try {
                InputStream inputStream = this.f12387g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new AssetDataSourceException(e, 2000);
            }
        } finally {
            this.f12387g = null;
            if (this.f12389i) {
                this.f12389i = false;
                transferEnded();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f12386f;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        int i;
        try {
            Uri uri = dataSpec.uri;
            this.f12386f = uri;
            String str = (String) Assertions.checkNotNull(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            transferInitializing(dataSpec);
            InputStream open = this.f12385e.open(str, 1);
            this.f12387g = open;
            if (open.skip(dataSpec.position) >= dataSpec.position) {
                long j = dataSpec.length;
                if (j != -1) {
                    this.f12388h = j;
                } else {
                    long available = this.f12387g.available();
                    this.f12388h = available;
                    if (available == 2147483647L) {
                        this.f12388h = -1L;
                    }
                }
                this.f12389i = true;
                transferStarted(dataSpec);
                return this.f12388h;
            }
            throw new AssetDataSourceException(null, 2008);
        } catch (AssetDataSourceException e) {
            throw e;
        } catch (IOException e2) {
            if (e2 instanceof FileNotFoundException) {
                i = PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND;
            } else {
                i = 2000;
            }
            throw new AssetDataSourceException(e2, i);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f12388h;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new AssetDataSourceException(e, 2000);
            }
        }
        int read = ((InputStream) Util.castNonNull(this.f12387g)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.f12388h;
        if (j2 != -1) {
            this.f12388h = j2 - read;
        }
        bytesTransferred(read);
        return read;
    }
}
