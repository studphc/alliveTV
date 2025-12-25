package com.bumptech.glide.disklrucache;

import android.os.Build;
import android.os.StrictMode;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000.b13;
import p000.jo2;
import p000.u40;

/* loaded from: classes.dex */
public final class DiskLruCache implements Closeable {

    /* renamed from: a */
    public final File f8544a;

    /* renamed from: b */
    public final File f8545b;

    /* renamed from: c */
    public final File f8546c;

    /* renamed from: d */
    public final File f8547d;

    /* renamed from: e */
    public final int f8548e;

    /* renamed from: f */
    public long f8549f;

    /* renamed from: g */
    public final int f8550g;

    /* renamed from: i */
    public BufferedWriter f8552i;

    /* renamed from: k */
    public int f8554k;

    /* renamed from: h */
    public long f8551h = 0;

    /* renamed from: j */
    public final LinkedHashMap f8553j = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: l */
    public long f8555l = 0;

    /* renamed from: m */
    public final ThreadPoolExecutor f8556m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), (ThreadFactory) new Object());

    /* renamed from: n */
    public final u40 f8557n = new u40(0, this);

    /* loaded from: classes.dex */
    public final class Editor {

        /* renamed from: a */
        public final C0604a f8558a;

        /* renamed from: b */
        public final boolean[] f8559b;

        /* renamed from: c */
        public boolean f8560c;

        public Editor(C0604a c0604a) {
            boolean[] zArr;
            this.f8558a = c0604a;
            if (c0604a.f8571e) {
                zArr = null;
            } else {
                zArr = new boolean[DiskLruCache.this.f8550g];
            }
            this.f8559b = zArr;
        }

        public void abort() {
            DiskLruCache.m2287b(DiskLruCache.this, this, false);
        }

        public void abortUnlessCommitted() {
            if (!this.f8560c) {
                try {
                    abort();
                } catch (IOException unused) {
                }
            }
        }

        public void commit() {
            DiskLruCache.m2287b(DiskLruCache.this, this, true);
            this.f8560c = true;
        }

        public File getFile(int i) {
            File file;
            synchronized (DiskLruCache.this) {
                try {
                    C0604a c0604a = this.f8558a;
                    if (c0604a.f8572f == this) {
                        if (!c0604a.f8571e) {
                            this.f8559b[i] = true;
                        }
                        file = c0604a.f8570d[i];
                        DiskLruCache.this.f8544a.mkdirs();
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return file;
        }

        public String getString(int i) {
            FileInputStream fileInputStream;
            synchronized (DiskLruCache.this) {
                C0604a c0604a = this.f8558a;
                if (c0604a.f8572f == this) {
                    if (c0604a.f8571e) {
                        try {
                            fileInputStream = new FileInputStream(this.f8558a.f8569c[i]);
                        } catch (FileNotFoundException unused) {
                        }
                    }
                    fileInputStream = null;
                } else {
                    throw new IllegalStateException();
                }
            }
            if (fileInputStream == null) {
                return null;
            }
            return DiskLruCache.m2286a(fileInputStream);
        }

        public void set(int i, String str) {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(getFile(i)), b13.f7855b);
                try {
                    outputStreamWriter2.write(str);
                    try {
                        outputStreamWriter2.close();
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused) {
                    }
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    Charset charset = b13.f7854a;
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (RuntimeException e2) {
                            throw e2;
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Value {

        /* renamed from: a */
        public final String f8562a;

        /* renamed from: b */
        public final long f8563b;

        /* renamed from: c */
        public final long[] f8564c;

        /* renamed from: d */
        public final File[] f8565d;

        public Value(String str, long j, File[] fileArr, long[] jArr) {
            this.f8562a = str;
            this.f8563b = j;
            this.f8565d = fileArr;
            this.f8564c = jArr;
        }

        public Editor edit() {
            return DiskLruCache.this.m2292e(this.f8563b, this.f8562a);
        }

        public File getFile(int i) {
            return this.f8565d[i];
        }

        public long getLength(int i) {
            return this.f8564c[i];
        }

        public String getString(int i) {
            return DiskLruCache.m2286a(new FileInputStream(this.f8565d[i]));
        }
    }

    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.Object, java.util.concurrent.ThreadFactory] */
    public DiskLruCache(File file, int i, int i2, long j) {
        this.f8544a = file;
        this.f8548e = i;
        this.f8545b = new File(file, "journal");
        this.f8546c = new File(file, "journal.tmp");
        this.f8547d = new File(file, "journal.bkp");
        this.f8550g = i2;
        this.f8549f = j;
    }

    /* renamed from: a */
    public static String m2286a(FileInputStream fileInputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, b13.f7855b);
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    String stringWriter2 = stringWriter.toString();
                    inputStreamReader.close();
                    return stringWriter2;
                }
            }
        } catch (Throwable th) {
            inputStreamReader.close();
            throw th;
        }
    }

    /* renamed from: b */
    public static void m2287b(DiskLruCache diskLruCache, Editor editor, boolean z) {
        synchronized (diskLruCache) {
            C0604a c0604a = editor.f8558a;
            if (c0604a.f8572f == editor) {
                if (z && !c0604a.f8571e) {
                    for (int i = 0; i < diskLruCache.f8550g; i++) {
                        if (editor.f8559b[i]) {
                            if (!c0604a.f8570d[i].exists()) {
                                editor.abort();
                                return;
                            }
                        } else {
                            editor.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < diskLruCache.f8550g; i2++) {
                    File file = c0604a.f8570d[i2];
                    if (z) {
                        if (file.exists()) {
                            File file2 = c0604a.f8569c[i2];
                            file.renameTo(file2);
                            long j = c0604a.f8568b[i2];
                            long length = file2.length();
                            c0604a.f8568b[i2] = length;
                            diskLruCache.f8551h = (diskLruCache.f8551h - j) + length;
                        }
                    } else {
                        m2289d(file);
                    }
                }
                diskLruCache.f8554k++;
                c0604a.f8572f = null;
                if (c0604a.f8571e | z) {
                    c0604a.f8571e = true;
                    diskLruCache.f8552i.append((CharSequence) "CLEAN");
                    diskLruCache.f8552i.append(' ');
                    diskLruCache.f8552i.append((CharSequence) c0604a.f8567a);
                    diskLruCache.f8552i.append((CharSequence) c0604a.m2299a());
                    diskLruCache.f8552i.append('\n');
                    if (z) {
                        long j2 = diskLruCache.f8555l;
                        diskLruCache.f8555l = 1 + j2;
                        c0604a.f8573g = j2;
                    }
                } else {
                    diskLruCache.f8553j.remove(c0604a.f8567a);
                    diskLruCache.f8552i.append((CharSequence) "REMOVE");
                    diskLruCache.f8552i.append(' ');
                    diskLruCache.f8552i.append((CharSequence) c0604a.f8567a);
                    diskLruCache.f8552i.append('\n');
                }
                m2290f(diskLruCache.f8552i);
                if (diskLruCache.f8551h > diskLruCache.f8549f || diskLruCache.m2293g()) {
                    diskLruCache.f8556m.submit(diskLruCache.f8557n);
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: c */
    public static void m2288c(BufferedWriter bufferedWriter) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            bufferedWriter.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* renamed from: d */
    public static void m2289d(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: f */
    public static void m2290f(BufferedWriter bufferedWriter) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            bufferedWriter.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* renamed from: l */
    public static void m2291l(File file, File file2, boolean z) {
        if (z) {
            m2289d(file2);
        }
        if (file.renameTo(file2)) {
        } else {
            throw new IOException();
        }
    }

    public static DiskLruCache open(File file, int i, int i2, long j) {
        if (j > 0) {
            if (i2 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        m2291l(file2, file3, false);
                    }
                }
                DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
                if (diskLruCache.f8545b.exists()) {
                    try {
                        diskLruCache.m2295i();
                        diskLruCache.m2294h();
                        return diskLruCache;
                    } catch (IOException e) {
                        System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                        diskLruCache.delete();
                    }
                }
                file.mkdirs();
                DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
                diskLruCache2.m2297k();
                return diskLruCache2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f8552i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f8553j.values()).iterator();
            while (it.hasNext()) {
                Editor editor = ((C0604a) it.next()).f8572f;
                if (editor != null) {
                    editor.abort();
                }
            }
            m2298m();
            m2288c(this.f8552i);
            this.f8552i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void delete() {
        close();
        b13.m2004a(this.f8544a);
    }

    /* renamed from: e */
    public final synchronized Editor m2292e(long j, String str) {
        try {
            if (this.f8552i != null) {
                C0604a c0604a = (C0604a) this.f8553j.get(str);
                if (j != -1 && (c0604a == null || c0604a.f8573g != j)) {
                    return null;
                }
                if (c0604a == null) {
                    c0604a = new C0604a(this, str);
                    this.f8553j.put(str, c0604a);
                } else if (c0604a.f8572f != null) {
                    return null;
                }
                Editor editor = new Editor(c0604a);
                c0604a.f8572f = editor;
                this.f8552i.append((CharSequence) "DIRTY");
                this.f8552i.append(' ');
                this.f8552i.append((CharSequence) str);
                this.f8552i.append('\n');
                m2290f(this.f8552i);
                return editor;
            }
            throw new IllegalStateException("cache is closed");
        } catch (Throwable th) {
            throw th;
        }
    }

    public Editor edit(String str) {
        return m2292e(-1L, str);
    }

    public synchronized void flush() {
        if (this.f8552i != null) {
            m2298m();
            m2290f(this.f8552i);
        } else {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: g */
    public final boolean m2293g() {
        int i = this.f8554k;
        if (i >= 2000 && i >= this.f8553j.size()) {
            return true;
        }
        return false;
    }

    public synchronized Value get(String str) {
        if (this.f8552i != null) {
            C0604a c0604a = (C0604a) this.f8553j.get(str);
            if (c0604a == null) {
                return null;
            }
            if (!c0604a.f8571e) {
                return null;
            }
            for (File file : c0604a.f8569c) {
                if (!file.exists()) {
                    return null;
                }
            }
            this.f8554k++;
            this.f8552i.append((CharSequence) "READ");
            this.f8552i.append(' ');
            this.f8552i.append((CharSequence) str);
            this.f8552i.append('\n');
            if (m2293g()) {
                this.f8556m.submit(this.f8557n);
            }
            return new Value(str, c0604a.f8573g, c0604a.f8569c, c0604a.f8568b);
        }
        throw new IllegalStateException("cache is closed");
    }

    public File getDirectory() {
        return this.f8544a;
    }

    public synchronized long getMaxSize() {
        return this.f8549f;
    }

    /* renamed from: h */
    public final void m2294h() {
        m2289d(this.f8546c);
        Iterator it = this.f8553j.values().iterator();
        while (it.hasNext()) {
            C0604a c0604a = (C0604a) it.next();
            Editor editor = c0604a.f8572f;
            int i = this.f8550g;
            int i2 = 0;
            if (editor == null) {
                while (i2 < i) {
                    this.f8551h += c0604a.f8568b[i2];
                    i2++;
                }
            } else {
                c0604a.f8572f = null;
                while (i2 < i) {
                    m2289d(c0604a.f8569c[i2]);
                    m2289d(c0604a.f8570d[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* renamed from: i */
    public final void m2295i() {
        File file = this.f8545b;
        jo2 jo2Var = new jo2(new FileInputStream(file), b13.f7854a);
        try {
            String m5447a = jo2Var.m5447a();
            String m5447a2 = jo2Var.m5447a();
            String m5447a3 = jo2Var.m5447a();
            String m5447a4 = jo2Var.m5447a();
            String m5447a5 = jo2Var.m5447a();
            if ("libcore.io.DiskLruCache".equals(m5447a) && IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(m5447a2) && Integer.toString(this.f8548e).equals(m5447a3) && Integer.toString(this.f8550g).equals(m5447a4) && "".equals(m5447a5)) {
                int i = 0;
                while (true) {
                    try {
                        m2296j(jo2Var.m5447a());
                        i++;
                    } catch (EOFException unused) {
                        this.f8554k = i - this.f8553j.size();
                        if (jo2Var.f20574e == -1) {
                            m2297k();
                        } else {
                            this.f8552i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), b13.f7854a));
                        }
                        try {
                            jo2Var.close();
                            return;
                        } catch (RuntimeException e) {
                            throw e;
                        } catch (Exception unused2) {
                            return;
                        }
                    }
                }
            } else {
                throw new IOException("unexpected journal header: [" + m5447a + ", " + m5447a2 + ", " + m5447a4 + ", " + m5447a5 + "]");
            }
        } catch (Throwable th) {
            try {
                jo2Var.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public synchronized boolean isClosed() {
        boolean z;
        if (this.f8552i == null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    /* renamed from: j */
    public final void m2296j(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            LinkedHashMap linkedHashMap = this.f8553j;
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    linkedHashMap.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf2);
            }
            C0604a c0604a = (C0604a) linkedHashMap.get(substring);
            if (c0604a == null) {
                c0604a = new C0604a(this, substring);
                linkedHashMap.put(substring, c0604a);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                c0604a.f8571e = true;
                c0604a.f8572f = null;
                if (split.length == c0604a.f8574h.f8550g) {
                    for (int i2 = 0; i2 < split.length; i2++) {
                        try {
                            c0604a.f8568b[i2] = Long.parseLong(split[i2]);
                        } catch (NumberFormatException unused) {
                            throw new IOException("unexpected journal line: " + Arrays.toString(split));
                        }
                    }
                    return;
                }
                throw new IOException("unexpected journal line: " + Arrays.toString(split));
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                c0604a.f8572f = new Editor(c0604a);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: ".concat(str));
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    /* renamed from: k */
    public final synchronized void m2297k() {
        try {
            BufferedWriter bufferedWriter = this.f8552i;
            if (bufferedWriter != null) {
                m2288c(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8546c), b13.f7854a));
            try {
                bufferedWriter2.write("libcore.io.DiskLruCache");
                bufferedWriter2.write("\n");
                bufferedWriter2.write(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f8548e));
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f8550g));
                bufferedWriter2.write("\n");
                bufferedWriter2.write("\n");
                for (C0604a c0604a : this.f8553j.values()) {
                    if (c0604a.f8572f != null) {
                        bufferedWriter2.write("DIRTY " + c0604a.f8567a + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + c0604a.f8567a + c0604a.m2299a() + '\n');
                    }
                }
                m2288c(bufferedWriter2);
                if (this.f8545b.exists()) {
                    m2291l(this.f8545b, this.f8547d, true);
                }
                m2291l(this.f8546c, this.f8545b, false);
                this.f8547d.delete();
                this.f8552i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8545b, true), b13.f7854a));
            } catch (Throwable th) {
                m2288c(bufferedWriter2);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: m */
    public final void m2298m() {
        while (this.f8551h > this.f8549f) {
            remove((String) ((Map.Entry) this.f8553j.entrySet().iterator().next()).getKey());
        }
    }

    public synchronized boolean remove(String str) {
        try {
            if (this.f8552i != null) {
                C0604a c0604a = (C0604a) this.f8553j.get(str);
                if (c0604a != null && c0604a.f8572f == null) {
                    for (int i = 0; i < this.f8550g; i++) {
                        File file = c0604a.f8569c[i];
                        if (file.exists() && !file.delete()) {
                            throw new IOException("failed to delete " + file);
                        }
                        long j = this.f8551h;
                        long[] jArr = c0604a.f8568b;
                        this.f8551h = j - jArr[i];
                        jArr[i] = 0;
                    }
                    this.f8554k++;
                    this.f8552i.append((CharSequence) "REMOVE");
                    this.f8552i.append(' ');
                    this.f8552i.append((CharSequence) str);
                    this.f8552i.append('\n');
                    this.f8553j.remove(str);
                    if (m2293g()) {
                        this.f8556m.submit(this.f8557n);
                    }
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("cache is closed");
        } finally {
        }
    }

    public synchronized void setMaxSize(long j) {
        this.f8549f = j;
        this.f8556m.submit(this.f8557n);
    }

    public synchronized long size() {
        return this.f8551h;
    }
}
