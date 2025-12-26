package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import p000.mc0;

/* loaded from: classes.dex */
public final class FileDataSource extends BaseDataSource {

    /* renamed from: e */
    public RandomAccessFile f12501e;

    /* renamed from: f */
    public Uri f12502f;

    /* renamed from: g */
    public long f12503g;

    /* renamed from: h */
    public boolean f12504h;

    /* loaded from: classes.dex */
    public static final class Factory implements DataSource.Factory {

        /* renamed from: a */
        public TransferListener f12505a;

        public Factory setListener(@Nullable TransferListener transferListener) {
            this.f12505a = transferListener;
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public FileDataSource createDataSource() {
            FileDataSource fileDataSource = new FileDataSource();
            TransferListener transferListener = this.f12505a;
            if (transferListener != null) {
                fileDataSource.addTransferListener(transferListener);
            }
            return fileDataSource;
        }
    }

    /* loaded from: classes.dex */
    public static class FileDataSourceException extends DataSourceException {
        @Deprecated
        public FileDataSourceException(Exception exc) {
            super(exc, 2000);
        }

        @Deprecated
        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException, 2000);
        }

        public FileDataSourceException(Throwable th, int i) {
            super(th, i);
        }

        public FileDataSourceException(@Nullable String str, @Nullable Throwable th, int i) {
            super(str, th, i);
        }
    }

    public FileDataSource() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.f12502f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f12501e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e) {
                throw new FileDataSourceException(e, 2000);
            }
        } finally {
            this.f12501e = null;
            if (this.f12504h) {
                this.f12504h = false;
                transferEnded();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f12502f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x008d, code lost:
    
        if (r1 != false) goto L39;
     */
    @Override // com.google.android.exoplayer2.upstream.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long open(DataSpec dataSpec) {
        boolean m6129b;
        Uri uri = dataSpec.uri;
        this.f12502f = uri;
        transferInitializing(dataSpec);
        int i = PlaybackException.ERROR_CODE_IO_NO_PERMISSION;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile((String) Assertions.checkNotNull(uri.getPath()), "r");
            this.f12501e = randomAccessFile;
            try {
                randomAccessFile.seek(dataSpec.position);
                long j = dataSpec.length;
                if (j == -1) {
                    j = this.f12501e.length() - dataSpec.position;
                }
                this.f12503g = j;
                if (j >= 0) {
                    this.f12504h = true;
                    transferStarted(dataSpec);
                    return this.f12503g;
                }
                throw new FileDataSourceException(null, null, 2008);
            } catch (IOException e) {
                throw new FileDataSourceException(e, 2000);
            }
        } catch (FileNotFoundException e2) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                if (Util.SDK_INT >= 21) {
                    m6129b = mc0.m6129b(e2.getCause());
                }
                i = PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND;
                throw new FileDataSourceException(e2, i);
            }
            throw new FileDataSourceException("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=" + uri.getPath() + ",query=" + uri.getQuery() + ",fragment=" + uri.getFragment(), e2, 1004);
        } catch (SecurityException e3) {
            throw new FileDataSourceException(e3, PlaybackException.ERROR_CODE_IO_NO_PERMISSION);
        } catch (RuntimeException e4) {
            throw new FileDataSourceException(e4, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.f12503g == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) Util.castNonNull(this.f12501e)).read(bArr, i, (int) Math.min(this.f12503g, i2));
            if (read > 0) {
                this.f12503g -= read;
                bytesTransferred(read);
            }
            return read;
        } catch (IOException e) {
            throw new FileDataSourceException(e, 2000);
        }
    }
}
