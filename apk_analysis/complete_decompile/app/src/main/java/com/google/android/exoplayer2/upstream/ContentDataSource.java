package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.Util;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public final class ContentDataSource extends BaseDataSource {

    /* renamed from: e */
    public final ContentResolver f12406e;

    /* renamed from: f */
    public Uri f12407f;

    /* renamed from: g */
    public AssetFileDescriptor f12408g;

    /* renamed from: h */
    public FileInputStream f12409h;

    /* renamed from: i */
    public long f12410i;

    /* renamed from: j */
    public boolean f12411j;

    /* loaded from: classes.dex */
    public static class ContentDataSourceException extends DataSourceException {
        @Deprecated
        public ContentDataSourceException(IOException iOException) {
            this(iOException, 2000);
        }

        public ContentDataSourceException(@Nullable IOException iOException, int i) {
            super(iOException, i);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f12406e = context.getContentResolver();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.f12407f = null;
        try {
            try {
                FileInputStream fileInputStream = this.f12409h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f12409h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f12408g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e) {
                        throw new ContentDataSourceException(e, 2000);
                    }
                } finally {
                    this.f12408g = null;
                    if (this.f12411j) {
                        this.f12411j = false;
                        transferEnded();
                    }
                }
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2, 2000);
            }
        } catch (Throwable th) {
            this.f12409h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f12408g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f12408g = null;
                    if (this.f12411j) {
                        this.f12411j = false;
                        transferEnded();
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new ContentDataSourceException(e3, 2000);
                }
            } finally {
                this.f12408g = null;
                if (this.f12411j) {
                    this.f12411j = false;
                    transferEnded();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f12407f;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        AssetFileDescriptor openAssetFileDescriptor;
        int i = 2000;
        try {
            Uri uri = dataSpec.uri;
            this.f12407f = uri;
            transferInitializing(dataSpec);
            boolean equals = FirebaseAnalytics.Param.CONTENT.equals(dataSpec.uri.getScheme());
            ContentResolver contentResolver = this.f12406e;
            if (equals) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                openAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
            }
            this.f12408g = openAssetFileDescriptor;
            if (openAssetFileDescriptor != null) {
                long length = openAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                this.f12409h = fileInputStream;
                if (length != -1 && dataSpec.position > length) {
                    throw new ContentDataSourceException(null, 2008);
                }
                long startOffset = openAssetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(dataSpec.position + startOffset) - startOffset;
                if (skip == dataSpec.position) {
                    if (length == -1) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.f12410i = -1L;
                        } else {
                            long position = size - channel.position();
                            this.f12410i = position;
                            if (position < 0) {
                                throw new ContentDataSourceException(null, 2008);
                            }
                        }
                    } else {
                        long j = length - skip;
                        this.f12410i = j;
                        if (j < 0) {
                            throw new ContentDataSourceException(null, 2008);
                        }
                    }
                    long j2 = dataSpec.length;
                    if (j2 != -1) {
                        long j3 = this.f12410i;
                        if (j3 != -1) {
                            j2 = Math.min(j3, j2);
                        }
                        this.f12410i = j2;
                    }
                    this.f12411j = true;
                    transferStarted(dataSpec);
                    long j4 = dataSpec.length;
                    if (j4 == -1) {
                        return this.f12410i;
                    }
                    return j4;
                }
                throw new ContentDataSourceException(null, 2008);
            }
            throw new ContentDataSourceException(new IOException("Could not open file descriptor for: " + uri), 2000);
        } catch (ContentDataSourceException e) {
            throw e;
        } catch (IOException e2) {
            if (e2 instanceof FileNotFoundException) {
                i = PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND;
            }
            throw new ContentDataSourceException(e2, i);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f12410i;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new ContentDataSourceException(e, 2000);
            }
        }
        int read = ((FileInputStream) Util.castNonNull(this.f12409h)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.f12410i;
        if (j2 != -1) {
            this.f12410i = j2 - read;
        }
        bytesTransferred(read);
        return read;
    }
}
