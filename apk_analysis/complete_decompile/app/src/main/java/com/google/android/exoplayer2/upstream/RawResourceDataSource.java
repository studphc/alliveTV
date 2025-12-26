package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public final class RawResourceDataSource extends BaseDataSource {
    public static final String RAW_RESOURCE_SCHEME = "rawresource";

    /* renamed from: e */
    public final Resources f12528e;

    /* renamed from: f */
    public final String f12529f;

    /* renamed from: g */
    public Uri f12530g;

    /* renamed from: h */
    public AssetFileDescriptor f12531h;

    /* renamed from: i */
    public FileInputStream f12532i;

    /* renamed from: j */
    public long f12533j;

    /* renamed from: k */
    public boolean f12534k;

    /* loaded from: classes.dex */
    public static class RawResourceDataSourceException extends DataSourceException {
        @Deprecated
        public RawResourceDataSourceException(String str) {
            super(str, null, 2000);
        }

        @Deprecated
        public RawResourceDataSourceException(Throwable th) {
            super(th, 2000);
        }

        public RawResourceDataSourceException(@Nullable String str, @Nullable Throwable th, int i) {
            super(str, th, i);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f12528e = context.getResources();
        this.f12529f = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i) {
        return Uri.parse("rawresource:///" + i);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.f12530g = null;
        try {
            try {
                FileInputStream fileInputStream = this.f12532i;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f12532i = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f12531h;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e) {
                        throw new RawResourceDataSourceException(null, e, 2000);
                    }
                } finally {
                    this.f12531h = null;
                    if (this.f12534k) {
                        this.f12534k = false;
                        transferEnded();
                    }
                }
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(null, e2, 2000);
            }
        } catch (Throwable th) {
            this.f12532i = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f12531h;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f12531h = null;
                    if (this.f12534k) {
                        this.f12534k = false;
                        transferEnded();
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new RawResourceDataSourceException(null, e3, 2000);
                }
            } finally {
                this.f12531h = null;
                if (this.f12534k) {
                    this.f12534k = false;
                    transferEnded();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f12530g;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        int parseInt;
        String m7057m;
        Uri uri = dataSpec.uri;
        this.f12530g = uri;
        boolean equals = TextUtils.equals(RAW_RESOURCE_SCHEME, uri.getScheme());
        Resources resources = this.f12528e;
        if (!equals && (!TextUtils.equals("android.resource", uri.getScheme()) || uri.getPathSegments().size() != 1 || !((String) Assertions.checkNotNull(uri.getLastPathSegment())).matches("\\d+"))) {
            if (TextUtils.equals("android.resource", uri.getScheme())) {
                String str = (String) Assertions.checkNotNull(uri.getPath());
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                String host = uri.getHost();
                StringBuilder sb = new StringBuilder();
                if (TextUtils.isEmpty(host)) {
                    m7057m = "";
                } else {
                    m7057m = AbstractC1726qj.m7057m(host, ":");
                }
                parseInt = resources.getIdentifier(AbstractC1726qj.m7061q(sb, m7057m, str), "raw", this.f12529f);
                if (parseInt == 0) {
                    throw new RawResourceDataSourceException("Resource not found.", null, PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND);
                }
            } else {
                throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource", null, 1004);
            }
        } else {
            try {
                parseInt = Integer.parseInt((String) Assertions.checkNotNull(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
            }
        }
        transferInitializing(dataSpec);
        try {
            AssetFileDescriptor openRawResourceFd = resources.openRawResourceFd(parseInt);
            this.f12531h = openRawResourceFd;
            if (openRawResourceFd != null) {
                long length = openRawResourceFd.getLength();
                FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
                this.f12532i = fileInputStream;
                if (length != -1) {
                    try {
                        if (dataSpec.position > length) {
                            throw new RawResourceDataSourceException(null, null, 2008);
                        }
                    } catch (RawResourceDataSourceException e) {
                        throw e;
                    } catch (IOException e2) {
                        throw new RawResourceDataSourceException(null, e2, 2000);
                    }
                }
                long startOffset = openRawResourceFd.getStartOffset();
                long skip = fileInputStream.skip(dataSpec.position + startOffset) - startOffset;
                if (skip == dataSpec.position) {
                    if (length == -1) {
                        FileChannel channel = fileInputStream.getChannel();
                        if (channel.size() == 0) {
                            this.f12533j = -1L;
                        } else {
                            long size = channel.size() - channel.position();
                            this.f12533j = size;
                            if (size < 0) {
                                throw new RawResourceDataSourceException(null, null, 2008);
                            }
                        }
                    } else {
                        long j = length - skip;
                        this.f12533j = j;
                        if (j < 0) {
                            throw new DataSourceException(2008);
                        }
                    }
                    long j2 = dataSpec.length;
                    if (j2 != -1) {
                        long j3 = this.f12533j;
                        if (j3 != -1) {
                            j2 = Math.min(j3, j2);
                        }
                        this.f12533j = j2;
                    }
                    this.f12534k = true;
                    transferStarted(dataSpec);
                    long j4 = dataSpec.length;
                    if (j4 == -1) {
                        return this.f12533j;
                    }
                    return j4;
                }
                throw new RawResourceDataSourceException(null, null, 2008);
            }
            throw new RawResourceDataSourceException("Resource is compressed: " + uri, null, 2000);
        } catch (Resources.NotFoundException e3) {
            throw new RawResourceDataSourceException(null, e3, PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f12533j;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new RawResourceDataSourceException(null, e, 2000);
            }
        }
        int read = ((InputStream) Util.castNonNull(this.f12532i)).read(bArr, i, i2);
        if (read == -1) {
            if (this.f12533j == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j2 = this.f12533j;
        if (j2 != -1) {
            this.f12533j = j2 - read;
        }
        bytesTransferred(read);
        return read;
    }
}
