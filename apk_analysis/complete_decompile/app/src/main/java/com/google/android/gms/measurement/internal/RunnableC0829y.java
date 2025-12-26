package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.hisona.allive.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import p000.bd3;

/* renamed from: com.google.android.gms.measurement.internal.y */
/* loaded from: classes.dex */
public final class RunnableC0829y implements Runnable {

    /* renamed from: a */
    public final URL f14110a;

    /* renamed from: b */
    public final byte[] f14111b;

    /* renamed from: c */
    public final bd3 f14112c;

    /* renamed from: d */
    public final String f14113d;

    /* renamed from: e */
    public final HashMap f14114e;

    /* renamed from: f */
    public final /* synthetic */ zzmb f14115f;

    public RunnableC0829y(zzmb zzmbVar, String str, URL url, byte[] bArr, HashMap hashMap, bd3 bd3Var) {
        this.f14115f = zzmbVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(bd3Var);
        this.f14110a = url;
        this.f14111b = bArr;
        this.f14112c = bd3Var;
        this.f14113d = str;
        this.f14114e = hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0147 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        int i;
        Throwable th;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        final IOException iOException;
        final ?? r9;
        final ?? r92;
        String str;
        final int responseCode;
        InputStream inputStream;
        ?? hasNext;
        String str2 = this.f14113d;
        zzmb zzmbVar = this.f14115f;
        zzmbVar.zzaY();
        int i2 = 0;
        final Exception exc = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        try {
            URLConnection openConnection = this.f14110a.openConnection();
            if (openConnection instanceof HttpURLConnection) {
                httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setDefaultUseCaches(false);
                zzio zzioVar = zzmbVar.zzu;
                zzioVar.zzf();
                httpURLConnection.setConnectTimeout(60000);
                zzioVar.zzf();
                httpURLConnection.setReadTimeout(61000);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoInput(true);
                try {
                    try {
                        HashMap hashMap = this.f14114e;
                        if (hashMap != null) {
                            Iterator it = hashMap.entrySet().iterator();
                            while (true) {
                                hasNext = it.hasNext();
                                if (hasNext == 0) {
                                    break;
                                }
                                Map.Entry entry = (Map.Entry) it.next();
                                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                            }
                        }
                        byte[] bArr = this.f14111b;
                        str = hasNext;
                        if (bArr != null) {
                            try {
                                zzioVar.zzaV();
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                gZIPOutputStream.write(bArr);
                                gZIPOutputStream.close();
                                byteArrayOutputStream.close();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                zzhc zzj = zzmbVar.zzu.zzaW().zzj();
                                String str3 = "Uploading data. size";
                                int length = byteArray.length;
                                zzj.zzb("Uploading data. size", Integer.valueOf(length));
                                httpURLConnection.setDoOutput(true);
                                httpURLConnection.addRequestProperty("Content-Encoding", HttpRequest.ENCODING_GZIP);
                                httpURLConnection.setFixedLengthStreamingMode(length);
                                httpURLConnection.connect();
                                outputStream = httpURLConnection.getOutputStream();
                                try {
                                    outputStream.write(byteArray);
                                    outputStream.close();
                                    str = str3;
                                } catch (IOException e) {
                                    iOException = e;
                                    r92 = 0;
                                    if (outputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    zzil zzaX = zzmbVar.zzu.zzaX();
                                    final int i3 = i2;
                                    final boolean z4 = z3 ? 1 : 0;
                                    zzaX.zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlz
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            RunnableC0829y runnableC0829y = RunnableC0829y.this;
                                            runnableC0829y.f14112c.zza(runnableC0829y.f14113d, i3, iOException, z4, r92);
                                        }
                                    });
                                } catch (Throwable th2) {
                                    i = 0;
                                    th = th2;
                                    r9 = 0;
                                    if (outputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    zzil zzaX2 = zzmbVar.zzu.zzaX();
                                    final int i4 = i;
                                    final boolean z5 = z2 ? 1 : 0;
                                    final boolean z6 = z ? 1 : 0;
                                    zzaX2.zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlz
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            RunnableC0829y runnableC0829y = RunnableC0829y.this;
                                            runnableC0829y.f14112c.zza(runnableC0829y.f14113d, i4, z5, z6, r9);
                                        }
                                    });
                                    throw th;
                                }
                            } catch (IOException e2) {
                                zzmbVar.zzu.zzaW().zze().zzb("Failed to gzip post request content", e2);
                                throw e2;
                            }
                        }
                        responseCode = httpURLConnection.getResponseCode();
                    } catch (IOException e3) {
                        iOException = e3;
                    }
                } catch (Throwable th3) {
                    i = 0;
                    th = th3;
                }
                try {
                    try {
                        final Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                byte[] bArr2 = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr2);
                                    if (read > 0) {
                                        byteArrayOutputStream2.write(bArr2, 0, read);
                                    } else {
                                        final byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                                        inputStream.close();
                                        httpURLConnection.disconnect();
                                        zzmbVar.zzu.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlz
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                RunnableC0829y runnableC0829y = RunnableC0829y.this;
                                                runnableC0829y.f14112c.zza(runnableC0829y.f14113d, responseCode, exc, byteArray2, headerFields);
                                            }
                                        });
                                        return;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = null;
                        }
                    } catch (IOException e4) {
                        iOException = e4;
                        i2 = responseCode;
                        outputStream = null;
                        r92 = outputStream;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e5) {
                                zzmbVar.zzu.zzaW().zze().zzc("Error closing HTTP compressed POST connection output stream. appId", zzhe.zzn(str2), e5);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzil zzaX3 = zzmbVar.zzu.zzaX();
                        final int i32 = i2;
                        final byte[] z42 = z3 ? 1 : 0;
                        zzaX3.zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlz
                            @Override // java.lang.Runnable
                            public final void run() {
                                RunnableC0829y runnableC0829y = RunnableC0829y.this;
                                runnableC0829y.f14112c.zza(runnableC0829y.f14113d, i32, iOException, z42, r92);
                            }
                        });
                    } catch (Throwable th6) {
                        th = th6;
                        i = responseCode;
                        outputStream = null;
                        r9 = outputStream;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e6) {
                                zzmbVar.zzu.zzaW().zze().zzc("Error closing HTTP compressed POST connection output stream. appId", zzhe.zzn(str2), e6);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzil zzaX22 = zzmbVar.zzu.zzaX();
                        final int i42 = i;
                        final Exception z52 = z2 ? 1 : 0;
                        final byte[] z62 = z ? 1 : 0;
                        zzaX22.zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlz
                            @Override // java.lang.Runnable
                            public final void run() {
                                RunnableC0829y runnableC0829y = RunnableC0829y.this;
                                runnableC0829y.f14112c.zza(runnableC0829y.f14113d, i42, z52, z62, r9);
                            }
                        });
                        throw th;
                    }
                } catch (IOException e7) {
                    iOException = e7;
                    i2 = responseCode;
                    outputStream = null;
                    r92 = str;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzil zzaX32 = zzmbVar.zzu.zzaX();
                    final int i322 = i2;
                    final byte[] z422 = z3 ? 1 : 0;
                    zzaX32.zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlz
                        @Override // java.lang.Runnable
                        public final void run() {
                            RunnableC0829y runnableC0829y = RunnableC0829y.this;
                            runnableC0829y.f14112c.zza(runnableC0829y.f14113d, i322, iOException, z422, r92);
                        }
                    });
                } catch (Throwable th7) {
                    th = th7;
                    i = responseCode;
                    outputStream = null;
                    r9 = str;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzil zzaX222 = zzmbVar.zzu.zzaX();
                    final int i422 = i;
                    final Exception z522 = z2 ? 1 : 0;
                    final byte[] z622 = z ? 1 : 0;
                    zzaX222.zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlz
                        @Override // java.lang.Runnable
                        public final void run() {
                            RunnableC0829y runnableC0829y = RunnableC0829y.this;
                            runnableC0829y.f14112c.zza(runnableC0829y.f14113d, i422, z522, z622, r9);
                        }
                    });
                    throw th;
                }
            } else {
                throw new IOException("Failed to obtain HTTP connection");
            }
        } catch (IOException e8) {
            iOException = e8;
            httpURLConnection = null;
            outputStream = null;
        } catch (Throwable th8) {
            i = 0;
            th = th8;
            httpURLConnection = null;
            outputStream = null;
        }
    }
}
