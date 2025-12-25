package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.profileinstaller.ProfileInstaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.concurrent.Executor;
import p000.RunnableC1185f7;
import p000.o63;
import p000.p63;
import p000.r30;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class DeviceProfileWriter {

    /* renamed from: a */
    public final AssetManager f6893a;

    /* renamed from: b */
    public final Executor f6894b;

    /* renamed from: c */
    public final ProfileInstaller.DiagnosticsCallback f6895c;

    /* renamed from: d */
    public final byte[] f6896d;

    /* renamed from: e */
    public final File f6897e;

    /* renamed from: f */
    public final String f6898f;

    /* renamed from: g */
    public final String f6899g;

    /* renamed from: h */
    public final String f6900h;

    /* renamed from: i */
    public boolean f6901i = false;

    /* renamed from: j */
    public r30[] f6902j;

    /* renamed from: k */
    public byte[] f6903k;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter(@NonNull AssetManager assetManager, @NonNull Executor executor, @NonNull ProfileInstaller.DiagnosticsCallback diagnosticsCallback, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull File file) {
        this.f6893a = assetManager;
        this.f6894b = executor;
        this.f6895c = diagnosticsCallback;
        this.f6898f = str;
        this.f6899g = str2;
        this.f6900h = str3;
        this.f6897e = file;
        int i = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i >= 24) {
            if (i >= 31) {
                bArr = ProfileVersion.f6913a;
            } else {
                switch (i) {
                    case 24:
                    case 25:
                        bArr = ProfileVersion.f6917e;
                        break;
                    case 26:
                        bArr = ProfileVersion.f6916d;
                        break;
                    case 27:
                        bArr = ProfileVersion.f6915c;
                        break;
                    case 28:
                    case 29:
                    case 30:
                        bArr = ProfileVersion.f6914b;
                        break;
                }
            }
        }
        this.f6896d = bArr;
    }

    /* renamed from: a */
    public final FileInputStream m1597a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f6895c.onDiagnosticReceived(5, null);
            }
            return null;
        }
    }

    /* renamed from: b */
    public final void m1598b(Serializable serializable, int i) {
        this.f6894b.execute(new RunnableC1185f7(this, i, serializable, 1));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.f6896d == null) {
            m1598b(Integer.valueOf(Build.VERSION.SDK_INT), 3);
            return false;
        }
        File file = this.f6897e;
        if (file.exists()) {
            if (!file.canWrite()) {
                m1598b(null, 4);
                return false;
            }
        } else {
            try {
                if (!file.createNewFile()) {
                    m1598b(null, 4);
                    return false;
                }
            } catch (IOException unused) {
                m1598b(null, 4);
                return false;
            }
        }
        this.f6901i = true;
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:7|(2:8|9)|10|11|(3:51|52|(4:54|55|56|57)(2:61|62))|13|(4:22|23|(3:29|30|(3:32|33|34)(2:35|36))(1:(1:26))|(1:28))|50) */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x005c, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x005d, code lost:
    
        r1.onResultReceived(7, r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DeviceProfileWriter read() {
        FileInputStream fileInputStream;
        r30[] r30VarArr;
        r30[] r30VarArr2;
        int i;
        FileInputStream m1597a;
        AssetManager assetManager = this.f6893a;
        ProfileInstaller.DiagnosticsCallback diagnosticsCallback = this.f6895c;
        if (this.f6901i) {
            byte[] bArr = this.f6896d;
            if (bArr == null) {
                return this;
            }
            DeviceProfileWriter deviceProfileWriter = null;
            try {
                try {
                    fileInputStream = m1597a(assetManager, this.f6899g);
                } catch (FileNotFoundException e) {
                    diagnosticsCallback.onResultReceived(6, e);
                    fileInputStream = null;
                    if (fileInputStream != null) {
                    }
                    r30VarArr2 = this.f6902j;
                    if (r30VarArr2 != null) {
                    }
                    return this;
                } catch (IOException e2) {
                    diagnosticsCallback.onResultReceived(7, e2);
                    fileInputStream = null;
                    if (fileInputStream != null) {
                    }
                    r30VarArr2 = this.f6902j;
                    if (r30VarArr2 != null) {
                    }
                    return this;
                }
                if (fileInputStream != null) {
                    try {
                        try {
                        } catch (IOException e3) {
                            diagnosticsCallback.onResultReceived(7, e3);
                            fileInputStream.close();
                            r30VarArr = null;
                            this.f6902j = r30VarArr;
                            r30VarArr2 = this.f6902j;
                            if (r30VarArr2 != null) {
                                try {
                                    m1597a = m1597a(assetManager, this.f6900h);
                                    if (m1597a == null) {
                                    }
                                } catch (FileNotFoundException e4) {
                                    diagnosticsCallback.onResultReceived(9, e4);
                                } catch (IOException e5) {
                                    diagnosticsCallback.onResultReceived(7, e5);
                                } catch (IllegalStateException e6) {
                                    this.f6902j = null;
                                    diagnosticsCallback.onResultReceived(8, e6);
                                }
                                if (deviceProfileWriter == null) {
                                }
                            }
                            return this;
                        }
                    } catch (IllegalStateException e7) {
                        diagnosticsCallback.onResultReceived(8, e7);
                        fileInputStream.close();
                        r30VarArr = null;
                        this.f6902j = r30VarArr;
                        r30VarArr2 = this.f6902j;
                        if (r30VarArr2 != null) {
                        }
                        return this;
                    }
                    if (Arrays.equals(o63.f23623e, p63.m6846F(fileInputStream, 4))) {
                        r30VarArr = o63.m6450E(fileInputStream, p63.m6846F(fileInputStream, 4), this.f6898f);
                        try {
                            fileInputStream.close();
                        } catch (IOException e8) {
                            diagnosticsCallback.onResultReceived(7, e8);
                        }
                        this.f6902j = r30VarArr;
                    } else {
                        throw new IllegalStateException("Invalid magic");
                    }
                }
                r30VarArr2 = this.f6902j;
                if (r30VarArr2 != null && (i = Build.VERSION.SDK_INT) >= 24 && (i >= 31 || i == 24 || i == 25)) {
                    m1597a = m1597a(assetManager, this.f6900h);
                    if (m1597a == null) {
                        try {
                            if (Arrays.equals(o63.f23624f, p63.m6846F(m1597a, 4))) {
                                this.f6902j = o63.m6447B(m1597a, p63.m6846F(m1597a, 4), bArr, r30VarArr2);
                                m1597a.close();
                                deviceProfileWriter = this;
                            } else {
                                throw new IllegalStateException("Invalid magic");
                            }
                        } catch (Throwable th) {
                            try {
                                m1597a.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } else if (m1597a != null) {
                        m1597a.close();
                    }
                    if (deviceProfileWriter == null) {
                        return deviceProfileWriter;
                    }
                }
                return this;
            } catch (Throwable th3) {
                try {
                    fileInputStream.close();
                } catch (IOException e9) {
                    diagnosticsCallback.onResultReceived(7, e9);
                }
                throw th3;
            }
        }
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter transcodeIfNeeded() {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        ProfileInstaller.DiagnosticsCallback diagnosticsCallback = this.f6895c;
        r30[] r30VarArr = this.f6902j;
        if (r30VarArr != null && (bArr = this.f6896d) != null) {
            if (this.f6901i) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byteArrayOutputStream.write(o63.f23623e);
                        byteArrayOutputStream.write(bArr);
                    } catch (Throwable th) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    diagnosticsCallback.onResultReceived(7, e);
                } catch (IllegalStateException e2) {
                    diagnosticsCallback.onResultReceived(8, e2);
                }
                if (!o63.m6455P(byteArrayOutputStream, bArr, r30VarArr)) {
                    diagnosticsCallback.onResultReceived(5, null);
                    this.f6902j = null;
                    byteArrayOutputStream.close();
                    return this;
                }
                this.f6903k = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                this.f6902j = null;
                return this;
            }
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean write() {
        byte[] bArr = this.f6903k;
        if (bArr == null) {
            return false;
        }
        if (this.f6901i) {
            try {
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.f6897e);
                        try {
                            FileChannel channel = fileOutputStream.getChannel();
                            try {
                                FileLock tryLock = channel.tryLock();
                                if (tryLock != null) {
                                    try {
                                        if (tryLock.isValid()) {
                                            byte[] bArr2 = new byte[512];
                                            while (true) {
                                                int read = byteArrayInputStream.read(bArr2);
                                                if (read > 0) {
                                                    fileOutputStream.write(bArr2, 0, read);
                                                } else {
                                                    m1598b(null, 1);
                                                    tryLock.close();
                                                    channel.close();
                                                    fileOutputStream.close();
                                                    byteArrayInputStream.close();
                                                    return true;
                                                }
                                            }
                                        }
                                    } finally {
                                    }
                                }
                                throw new IOException("Unable to acquire a lock on the underlying file channel.");
                            } finally {
                            }
                        } catch (Throwable th) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                } catch (FileNotFoundException e) {
                    m1598b(e, 6);
                    return false;
                } catch (IOException e2) {
                    m1598b(e2, 7);
                    return false;
                }
            } finally {
                this.f6903k = null;
                this.f6902j = null;
            }
        }
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    }
}
