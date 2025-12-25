package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.Downloader;
import java.io.IOException;
import p000.d60;

/* renamed from: com.google.android.exoplayer2.offline.b */
/* loaded from: classes.dex */
public final class C0681b extends Thread implements Downloader.ProgressListener {

    /* renamed from: a */
    public final DownloadRequest f10860a;

    /* renamed from: b */
    public final Downloader f10861b;

    /* renamed from: c */
    public final DownloadProgress f10862c;

    /* renamed from: d */
    public final boolean f10863d;

    /* renamed from: e */
    public final int f10864e;

    /* renamed from: f */
    public volatile d60 f10865f;

    /* renamed from: g */
    public volatile boolean f10866g;

    /* renamed from: h */
    public Exception f10867h;

    /* renamed from: i */
    public long f10868i = -1;

    public C0681b(DownloadRequest downloadRequest, Downloader downloader, DownloadProgress downloadProgress, boolean z, int i, d60 d60Var) {
        this.f10860a = downloadRequest;
        this.f10861b = downloader;
        this.f10862c = downloadProgress;
        this.f10863d = z;
        this.f10864e = i;
        this.f10865f = d60Var;
    }

    /* renamed from: a */
    public final void m2720a(boolean z) {
        if (z) {
            this.f10865f = null;
        }
        if (!this.f10866g) {
            this.f10866g = true;
            this.f10861b.cancel();
            interrupt();
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader.ProgressListener
    public final void onProgress(long j, long j2, float f) {
        this.f10862c.bytesDownloaded = j2;
        this.f10862c.percentDownloaded = f;
        if (j != this.f10868i) {
            this.f10868i = j;
            d60 d60Var = this.f10865f;
            if (d60Var != null) {
                d60Var.obtainMessage(10, (int) (j >> 32), (int) j, this).sendToTarget();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            if (this.f10863d) {
                this.f10861b.remove();
            } else {
                long j = -1;
                int i = 0;
                while (!this.f10866g) {
                    try {
                        this.f10861b.download(this);
                        break;
                    } catch (IOException e) {
                        if (!this.f10866g) {
                            long j2 = this.f10862c.bytesDownloaded;
                            if (j2 != j) {
                                i = 0;
                                j = j2;
                            }
                            int i2 = i + 1;
                            if (i2 <= this.f10864e) {
                                Thread.sleep(Math.min(i * 1000, 5000));
                                i = i2;
                            } else {
                                throw e;
                            }
                        }
                    }
                }
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        } catch (Exception e2) {
            this.f10867h = e2;
        }
        d60 d60Var = this.f10865f;
        if (d60Var != null) {
            d60Var.obtainMessage(9, this).sendToTarget();
        }
    }
}
