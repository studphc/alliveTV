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
import java.util.List;
import java.util.Map;
import p000.rb3;
import p000.sb3;

/* renamed from: com.google.android.gms.measurement.internal.e */
/* loaded from: classes.dex */
public final class RunnableC0795e implements Runnable {

    /* renamed from: a */
    public final URL f14010a;

    /* renamed from: b */
    public final byte[] f14011b;

    /* renamed from: c */
    public final rb3 f14012c;

    /* renamed from: d */
    public final String f14013d;

    /* renamed from: e */
    public final Map f14014e;

    /* renamed from: f */
    public final /* synthetic */ zzhk f14015f;

    public RunnableC0795e(zzhk zzhkVar, String str, URL url, byte[] bArr, Map map, rb3 rb3Var) {
        this.f14015f = zzhkVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(rb3Var);
        this.f14010a = url;
        this.f14011b = bArr;
        this.f14012c = rb3Var;
        this.f14013d = str;
        this.f14014e = map;
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x00fc: MOVE (r14 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:253), block:B:81:0x00fb */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0100: MOVE (r14 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:257), block:B:78:0x00fe */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Throwable th;
        int i;
        HttpURLConnection httpURLConnection;
        Map map;
        IOException e;
        int i2;
        Map map2;
        sb3 sb3Var;
        zzil zzilVar;
        IOException iOException;
        URLConnection openConnection;
        Map map3;
        Map map4;
        InputStream inputStream;
        String str = this.f14013d;
        zzhk zzhkVar = this.f14015f;
        zzhkVar.zzaY();
        OutputStream outputStream = null;
        try {
            openConnection = this.f14010a.openConnection();
        } catch (IOException e2) {
            e = e2;
            i2 = 0;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th2) {
            th = th2;
            i = 0;
            httpURLConnection = null;
            map = null;
        }
        if (openConnection instanceof HttpURLConnection) {
            httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            zzio zzioVar = zzhkVar.zzu;
            zzioVar.zzf();
            httpURLConnection.setConnectTimeout(60000);
            zzioVar.zzf();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                Map map5 = this.f14014e;
                if (map5 != null) {
                    for (Map.Entry entry : map5.entrySet()) {
                        httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                byte[] bArr = this.f14011b;
                if (bArr != null) {
                    byte[] m3688b = zzhkVar.zzg.zzA().m3688b(bArr);
                    zzhc zzj = zzioVar.zzaW().zzj();
                    int length = m3688b.length;
                    zzj.zzb("Uploading data. size", Integer.valueOf(length));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-Encoding", HttpRequest.ENCODING_GZIP);
                    httpURLConnection.setFixedLengthStreamingMode(length);
                    httpURLConnection.connect();
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(m3688b);
                        outputStream2.close();
                    } catch (IOException e3) {
                        e = e3;
                        i2 = 0;
                        map2 = null;
                        outputStream = outputStream2;
                        iOException = e;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        zzilVar = zzhkVar.zzu.zzaX();
                        sb3Var = new sb3(this.f14013d, this.f14012c, i2, iOException, null, map2);
                        zzilVar.zzq(sb3Var);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        i = 0;
                        map = null;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        zzhkVar.zzu.zzaX().zzq(new sb3(this.f14013d, this.f14012c, i, null, null, map));
                        throw th;
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                try {
                    try {
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                byte[] bArr2 = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr2);
                                    if (read <= 0) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr2, 0, read);
                                    }
                                }
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                inputStream.close();
                                httpURLConnection.disconnect();
                                zzilVar = zzhkVar.zzu.zzaX();
                                sb3Var = new sb3(this.f14013d, this.f14012c, responseCode, null, byteArray, headerFields);
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
                        map2 = null;
                        iOException = e4;
                        i2 = responseCode;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e5) {
                                zzhkVar.zzu.zzaW().zze().zzc("Error closing HTTP compressed POST connection output stream. appId", zzhe.zzn(str), e5);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzilVar = zzhkVar.zzu.zzaX();
                        sb3Var = new sb3(this.f14013d, this.f14012c, i2, iOException, null, map2);
                        zzilVar.zzq(sb3Var);
                        return;
                    } catch (Throwable th6) {
                        th = th6;
                        map = null;
                        i = responseCode;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e6) {
                                zzhkVar.zzu.zzaW().zze().zzc("Error closing HTTP compressed POST connection output stream. appId", zzhe.zzn(str), e6);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzhkVar.zzu.zzaX().zzq(new sb3(this.f14013d, this.f14012c, i, null, null, map));
                        throw th;
                    }
                } catch (IOException e7) {
                    iOException = e7;
                    i2 = responseCode;
                    map2 = map4;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzilVar = zzhkVar.zzu.zzaX();
                    sb3Var = new sb3(this.f14013d, this.f14012c, i2, iOException, null, map2);
                    zzilVar.zzq(sb3Var);
                    return;
                } catch (Throwable th7) {
                    th = th7;
                    i = responseCode;
                    map = map3;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzhkVar.zzu.zzaX().zzq(new sb3(this.f14013d, this.f14012c, i, null, null, map));
                    throw th;
                }
            } catch (IOException e8) {
                i2 = 0;
                map2 = null;
                iOException = e8;
            } catch (Throwable th8) {
                i = 0;
                map = null;
                th = th8;
            }
            zzilVar.zzq(sb3Var);
            return;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }
}
