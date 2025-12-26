package p000;

import android.database.Cursor;
import com.google.android.exoplayer2.offline.DefaultDownloadIndex;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadCursor;

/* loaded from: classes.dex */
public final class l00 implements DownloadCursor {

    /* renamed from: a */
    public final Cursor f22269a;

    public l00(Cursor cursor) {
        this.f22269a = cursor;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f22269a.close();
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor
    public final int getCount() {
        return this.f22269a.getCount();
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor
    public final Download getDownload() {
        return DefaultDownloadIndex.m2695d(this.f22269a);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor
    public final int getPosition() {
        return this.f22269a.getPosition();
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor
    public final /* synthetic */ boolean isAfterLast() {
        return t50.m7450a(this);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor
    public final /* synthetic */ boolean isBeforeFirst() {
        return t50.m7451b(this);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor
    public final boolean isClosed() {
        return this.f22269a.isClosed();
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor
    public final /* synthetic */ boolean isFirst() {
        return t50.m7452c(this);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor
    public final /* synthetic */ boolean isLast() {
        return t50.m7453d(this);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor
    public final /* synthetic */ boolean moveToFirst() {
        return t50.m7454e(this);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor
    public final /* synthetic */ boolean moveToLast() {
        return t50.m7455f(this);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor
    public final /* synthetic */ boolean moveToNext() {
        return t50.m7456g(this);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor
    public final boolean moveToPosition(int i) {
        return this.f22269a.moveToPosition(i);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadCursor
    public final /* synthetic */ boolean moveToPrevious() {
        return t50.m7457h(this);
    }
}
