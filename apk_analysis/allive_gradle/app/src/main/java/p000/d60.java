package p000;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.offline.C0681b;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadCursor;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.DownloaderFactory;
import com.google.android.exoplayer2.offline.WritableDownloadIndex;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class d60 extends Handler {

    /* renamed from: a */
    public boolean f16259a;

    /* renamed from: b */
    public final HandlerThread f16260b;

    /* renamed from: c */
    public final WritableDownloadIndex f16261c;

    /* renamed from: d */
    public final DownloaderFactory f16262d;

    /* renamed from: e */
    public final Handler f16263e;

    /* renamed from: f */
    public final ArrayList f16264f;

    /* renamed from: g */
    public final HashMap f16265g;

    /* renamed from: h */
    public int f16266h;

    /* renamed from: i */
    public boolean f16267i;

    /* renamed from: j */
    public int f16268j;

    /* renamed from: k */
    public int f16269k;

    /* renamed from: l */
    public int f16270l;

    public d60(HandlerThread handlerThread, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory, Handler handler, int i, int i2, boolean z) {
        super(handlerThread.getLooper());
        this.f16260b = handlerThread;
        this.f16261c = writableDownloadIndex;
        this.f16262d = downloaderFactory;
        this.f16263e = handler;
        this.f16268j = i;
        this.f16269k = i2;
        this.f16267i = z;
        this.f16264f = new ArrayList();
        this.f16265g = new HashMap();
    }

    /* renamed from: a */
    public static Download m4526a(Download download, int i, int i2) {
        return new Download(download.request, i, download.startTimeMs, System.currentTimeMillis(), download.contentLength, i2, 0, download.f10780a);
    }

    /* renamed from: b */
    public final Download m4527b(String str, boolean z) {
        int m4528c = m4528c(str);
        if (m4528c != -1) {
            return (Download) this.f16264f.get(m4528c);
        }
        if (z) {
            try {
                return this.f16261c.getDownload(str);
            } catch (IOException e) {
                Log.m3024e("DownloadManager", "Failed to load download: " + str, e);
                return null;
            }
        }
        return null;
    }

    /* renamed from: c */
    public final int m4528c(String str) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f16264f;
            if (i < arrayList.size()) {
                if (((Download) arrayList.get(i)).request.f10811id.equals(str)) {
                    return i;
                }
                i++;
            } else {
                return -1;
            }
        }
    }

    /* renamed from: d */
    public final void m4529d(Download download) {
        boolean z;
        int i = download.state;
        boolean z2 = true;
        if (i != 3 && i != 4) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        int m4528c = m4528c(download.request.f10811id);
        ArrayList arrayList = this.f16264f;
        if (m4528c == -1) {
            arrayList.add(download);
            Collections.sort(arrayList, new C0556bg(10));
        } else {
            if (download.startTimeMs == ((Download) arrayList.get(m4528c)).startTimeMs) {
                z2 = false;
            }
            arrayList.set(m4528c, download);
            if (z2) {
                Collections.sort(arrayList, new C0556bg(10));
            }
        }
        try {
            this.f16261c.putDownload(download);
        } catch (IOException e) {
            Log.m3024e("DownloadManager", "Failed to update index.", e);
        }
        this.f16263e.obtainMessage(2, new c60(download, false, new ArrayList(arrayList), null)).sendToTarget();
    }

    /* renamed from: e */
    public final Download m4530e(Download download, int i, int i2) {
        boolean z;
        if (i != 3 && i != 4) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        Download m4526a = m4526a(download, i, i2);
        m4529d(m4526a);
        return m4526a;
    }

    /* renamed from: f */
    public final void m4531f(Download download, int i) {
        if (i == 0) {
            if (download.state == 1) {
                m4530e(download, 0, 0);
            }
        } else if (i != download.stopReason) {
            int i2 = download.state;
            if (i2 == 0 || i2 == 2) {
                i2 = 1;
            }
            m4529d(new Download(download.request, i2, download.startTimeMs, System.currentTimeMillis(), download.contentLength, i, 0, download.f10780a));
        }
    }

    /* renamed from: g */
    public final void m4532g() {
        int i = 0;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f16264f;
            if (i < arrayList.size()) {
                Download download = (Download) arrayList.get(i);
                HashMap hashMap = this.f16265g;
                C0681b c0681b = (C0681b) hashMap.get(download.request.f10811id);
                int i3 = download.state;
                DownloaderFactory downloaderFactory = this.f16262d;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 5 && i3 != 7) {
                                throw new IllegalStateException();
                            }
                            if (c0681b != null) {
                                if (!c0681b.f10863d) {
                                    c0681b.m2720a(false);
                                }
                            } else {
                                C0681b c0681b2 = new C0681b(download.request, downloaderFactory.createDownloader(download.request), download.f10780a, true, this.f16269k, this);
                                hashMap.put(download.request.f10811id, c0681b2);
                                c0681b2.start();
                            }
                        } else {
                            Assertions.checkNotNull(c0681b);
                            Assertions.checkState(!c0681b.f10863d);
                            if (this.f16267i || this.f16266h != 0 || i2 >= this.f16268j) {
                                m4530e(download, 0, 0);
                                c0681b.m2720a(false);
                            }
                        }
                    } else if (c0681b != null) {
                        Assertions.checkState(!c0681b.f10863d);
                        c0681b.m2720a(false);
                    }
                } else if (c0681b != null) {
                    Assertions.checkState(!c0681b.f10863d);
                    c0681b.m2720a(false);
                } else if (!this.f16267i && this.f16266h == 0 && this.f16270l < this.f16268j) {
                    Download m4530e = m4530e(download, 2, 0);
                    c0681b = new C0681b(m4530e.request, downloaderFactory.createDownloader(m4530e.request), m4530e.f10780a, false, this.f16269k, this);
                    hashMap.put(m4530e.request.f10811id, c0681b);
                    int i4 = this.f16270l;
                    this.f16270l = i4 + 1;
                    if (i4 == 0) {
                        sendEmptyMessageDelayed(11, 5000L);
                    }
                    c0681b.start();
                } else {
                    c0681b = null;
                }
                if (c0681b != null && !c0681b.f10863d) {
                    i2++;
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0010. Please report as an issue. */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i;
        long j;
        int i2;
        int i3;
        int i4;
        int i5;
        DownloadCursor downloadCursor = null;
        int i6 = 0;
        r10 = 0;
        int i7 = 0;
        int i8 = 0;
        boolean z = false;
        switch (message.what) {
            case 0:
                int i9 = message.arg1;
                WritableDownloadIndex writableDownloadIndex = this.f16261c;
                ArrayList arrayList = this.f16264f;
                this.f16266h = i9;
                try {
                    try {
                        writableDownloadIndex.setDownloadingStatesToQueued();
                        downloadCursor = writableDownloadIndex.getDownloads(0, 1, 2, 5, 7);
                        while (downloadCursor.moveToNext()) {
                            arrayList.add(downloadCursor.getDownload());
                        }
                    } finally {
                        Util.closeQuietly(downloadCursor);
                    }
                } catch (IOException e) {
                    Log.m3024e("DownloadManager", "Failed to load index.", e);
                    arrayList.clear();
                }
                this.f16263e.obtainMessage(0, new ArrayList(arrayList)).sendToTarget();
                m4532g();
                i7 = 1;
                this.f16263e.obtainMessage(1, i7, this.f16265g.size()).sendToTarget();
                return;
            case 1:
                if (message.arg1 != 0) {
                    z = true;
                }
                this.f16267i = z;
                m4532g();
                i7 = 1;
                this.f16263e.obtainMessage(1, i7, this.f16265g.size()).sendToTarget();
                return;
            case 2:
                this.f16266h = message.arg1;
                m4532g();
                i7 = 1;
                this.f16263e.obtainMessage(1, i7, this.f16265g.size()).sendToTarget();
                return;
            case 3:
                String str = (String) message.obj;
                int i10 = message.arg1;
                WritableDownloadIndex writableDownloadIndex2 = this.f16261c;
                if (str == null) {
                    while (true) {
                        ArrayList arrayList2 = this.f16264f;
                        if (i8 < arrayList2.size()) {
                            m4531f((Download) arrayList2.get(i8), i10);
                            i8++;
                        } else {
                            try {
                                writableDownloadIndex2.setStopReason(i10);
                            } catch (IOException e2) {
                                Log.m3024e("DownloadManager", "Failed to set manual stop reason", e2);
                            }
                        }
                    }
                } else {
                    Download m4527b = m4527b(str, false);
                    if (m4527b != null) {
                        m4531f(m4527b, i10);
                    } else {
                        try {
                            writableDownloadIndex2.setStopReason(str, i10);
                        } catch (IOException e3) {
                            Log.m3024e("DownloadManager", "Failed to set manual stop reason: ".concat(str), e3);
                        }
                    }
                }
                m4532g();
                i7 = 1;
                this.f16263e.obtainMessage(1, i7, this.f16265g.size()).sendToTarget();
                return;
            case 4:
                this.f16268j = message.arg1;
                m4532g();
                i7 = 1;
                this.f16263e.obtainMessage(1, i7, this.f16265g.size()).sendToTarget();
                return;
            case 5:
                this.f16269k = message.arg1;
                i7 = 1;
                this.f16263e.obtainMessage(1, i7, this.f16265g.size()).sendToTarget();
                return;
            case 6:
                DownloadRequest downloadRequest = (DownloadRequest) message.obj;
                int i11 = message.arg1;
                Download m4527b2 = m4527b(downloadRequest.f10811id, true);
                long currentTimeMillis = System.currentTimeMillis();
                if (m4527b2 != null) {
                    int i12 = DownloadManager.DEFAULT_MAX_PARALLEL_DOWNLOADS;
                    int i13 = m4527b2.state;
                    if (i13 != 5 && !m4527b2.isTerminalState()) {
                        j = m4527b2.startTimeMs;
                    } else {
                        j = currentTimeMillis;
                    }
                    if (i13 != 5 && i13 != 7) {
                        if (i11 != 0) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                    } else {
                        i2 = 7;
                    }
                    m4529d(new Download(m4527b2.request.copyWithMergedRequest(downloadRequest), i2, j, currentTimeMillis, -1L, i11, 0));
                } else {
                    if (i11 != 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    m4529d(new Download(downloadRequest, i, currentTimeMillis, currentTimeMillis, -1L, i11, 0));
                }
                m4532g();
                i7 = 1;
                this.f16263e.obtainMessage(1, i7, this.f16265g.size()).sendToTarget();
                return;
            case 7:
                String str2 = (String) message.obj;
                Download m4527b3 = m4527b(str2, true);
                if (m4527b3 == null) {
                    Log.m3023e("DownloadManager", "Failed to remove nonexistent download: " + str2);
                } else {
                    m4530e(m4527b3, 5, 0);
                    m4532g();
                }
                i7 = 1;
                this.f16263e.obtainMessage(1, i7, this.f16265g.size()).sendToTarget();
                return;
            case 8:
                WritableDownloadIndex writableDownloadIndex3 = this.f16261c;
                ArrayList arrayList3 = new ArrayList();
                try {
                    DownloadCursor downloads = writableDownloadIndex3.getDownloads(3, 4);
                    while (downloads.moveToNext()) {
                        try {
                            arrayList3.add(downloads.getDownload());
                        } finally {
                        }
                    }
                    downloads.close();
                } catch (IOException unused) {
                    Log.m3023e("DownloadManager", "Failed to load downloads.");
                }
                int i14 = 0;
                while (true) {
                    ArrayList arrayList4 = this.f16264f;
                    if (i14 < arrayList4.size()) {
                        arrayList4.set(i14, m4526a((Download) arrayList4.get(i14), 5, 0));
                        i14++;
                    } else {
                        for (int i15 = 0; i15 < arrayList3.size(); i15++) {
                            arrayList4.add(m4526a((Download) arrayList3.get(i15), 5, 0));
                        }
                        Collections.sort(arrayList4, new C0556bg(10));
                        try {
                            writableDownloadIndex3.setStatesToRemoving();
                        } catch (IOException e4) {
                            Log.m3024e("DownloadManager", "Failed to update index.", e4);
                        }
                        ArrayList arrayList5 = new ArrayList(arrayList4);
                        for (int i16 = 0; i16 < arrayList4.size(); i16++) {
                            this.f16263e.obtainMessage(2, new c60((Download) arrayList4.get(i16), false, arrayList5, null)).sendToTarget();
                        }
                        m4532g();
                        i7 = 1;
                        this.f16263e.obtainMessage(1, i7, this.f16265g.size()).sendToTarget();
                        return;
                    }
                }
            case 9:
                C0681b c0681b = (C0681b) message.obj;
                String str3 = c0681b.f10860a.f10811id;
                this.f16265g.remove(str3);
                boolean z2 = c0681b.f10863d;
                if (!z2) {
                    int i17 = this.f16270l - 1;
                    this.f16270l = i17;
                    if (i17 == 0) {
                        removeMessages(11);
                    }
                }
                if (c0681b.f10866g) {
                    m4532g();
                } else {
                    Exception exc = c0681b.f10867h;
                    if (exc != null) {
                        Log.m3024e("DownloadManager", "Task failed: " + c0681b.f10860a + ", " + z2, exc);
                    }
                    Download download = (Download) Assertions.checkNotNull(m4527b(str3, false));
                    int i18 = download.state;
                    if (i18 != 2) {
                        if (i18 != 5 && i18 != 7) {
                            throw new IllegalStateException();
                        }
                        Assertions.checkState(z2);
                        if (download.state == 7) {
                            int i19 = download.stopReason;
                            if (i19 == 0) {
                                i5 = 0;
                            } else {
                                i5 = 1;
                            }
                            m4530e(download, i5, i19);
                            m4532g();
                        } else {
                            int m4528c = m4528c(download.request.f10811id);
                            ArrayList arrayList6 = this.f16264f;
                            arrayList6.remove(m4528c);
                            try {
                                this.f16261c.removeDownload(download.request.f10811id);
                            } catch (IOException unused2) {
                                Log.m3023e("DownloadManager", "Failed to remove from database");
                            }
                            this.f16263e.obtainMessage(2, new c60(download, true, new ArrayList(arrayList6), null)).sendToTarget();
                        }
                    } else {
                        Assertions.checkState(!z2);
                        DownloadRequest downloadRequest2 = download.request;
                        if (exc == null) {
                            i3 = 3;
                        } else {
                            i3 = 4;
                        }
                        long j2 = download.startTimeMs;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        long j3 = download.contentLength;
                        int i20 = download.stopReason;
                        if (exc == null) {
                            i4 = 0;
                        } else {
                            i4 = 1;
                        }
                        Download download2 = new Download(downloadRequest2, i3, j2, currentTimeMillis2, j3, i20, i4, download.f10780a);
                        ArrayList arrayList7 = this.f16264f;
                        arrayList7.remove(m4528c(download2.request.f10811id));
                        try {
                            this.f16261c.putDownload(download2);
                        } catch (IOException e5) {
                            Log.m3024e("DownloadManager", "Failed to update index.", e5);
                        }
                        this.f16263e.obtainMessage(2, new c60(download2, false, new ArrayList(arrayList7), exc)).sendToTarget();
                    }
                    m4532g();
                }
                this.f16263e.obtainMessage(1, i7, this.f16265g.size()).sendToTarget();
                return;
            case 10:
                C0681b c0681b2 = (C0681b) message.obj;
                long j4 = Util.toLong(message.arg1, message.arg2);
                Download download3 = (Download) Assertions.checkNotNull(m4527b(c0681b2.f10860a.f10811id, false));
                if (j4 != download3.contentLength && j4 != -1) {
                    m4529d(new Download(download3.request, download3.state, download3.startTimeMs, System.currentTimeMillis(), j4, download3.stopReason, download3.failureReason, download3.f10780a));
                    return;
                }
                return;
            case 11:
                while (true) {
                    ArrayList arrayList8 = this.f16264f;
                    if (i6 < arrayList8.size()) {
                        Download download4 = (Download) arrayList8.get(i6);
                        if (download4.state == 2) {
                            try {
                                this.f16261c.putDownload(download4);
                            } catch (IOException e6) {
                                Log.m3024e("DownloadManager", "Failed to update index.", e6);
                            }
                        }
                        i6++;
                    } else {
                        sendEmptyMessageDelayed(11, 5000L);
                        return;
                    }
                }
            case 12:
                Iterator it = this.f16265g.values().iterator();
                while (it.hasNext()) {
                    ((C0681b) it.next()).m2720a(true);
                }
                try {
                    this.f16261c.setDownloadingStatesToQueued();
                } catch (IOException e7) {
                    Log.m3024e("DownloadManager", "Failed to update index.", e7);
                }
                this.f16264f.clear();
                this.f16260b.quit();
                synchronized (this) {
                    this.f16259a = true;
                    notifyAll();
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
