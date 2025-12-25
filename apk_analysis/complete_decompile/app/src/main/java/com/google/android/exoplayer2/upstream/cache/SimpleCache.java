package com.google.android.exoplayer2.upstream.cache;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import p000.AbstractC1726qj;
import p000.AbstractC1997xv;
import p000.C1198fk;
import p000.C1357jk;
import p000.C1394kk;
import p000.C1514lk;
import p000.C1540m9;
import p000.C1625ok;
import p000.f00;
import p000.ji2;
import p000.ye0;

/* loaded from: classes.dex */
public final class SimpleCache implements Cache {

    /* renamed from: l */
    public static final HashSet f12641l = new HashSet();

    /* renamed from: a */
    public final File f12642a;

    /* renamed from: b */
    public final CacheEvictor f12643b;

    /* renamed from: c */
    public final C1625ok f12644c;

    /* renamed from: d */
    public final C1540m9 f12645d;

    /* renamed from: e */
    public final HashMap f12646e;

    /* renamed from: f */
    public final Random f12647f;

    /* renamed from: g */
    public final boolean f12648g;

    /* renamed from: h */
    public long f12649h;

    /* renamed from: i */
    public long f12650i;

    /* renamed from: j */
    public boolean f12651j;

    /* renamed from: k */
    public Cache.CacheException f12652k;

    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, null, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m2998a(SimpleCache simpleCache) {
        C1625ok c1625ok = simpleCache.f12644c;
        File file = simpleCache.f12642a;
        if (!file.exists()) {
            try {
                m2999c(file);
            } catch (Cache.CacheException e) {
                simpleCache.f12652k = e;
                return;
            }
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            String str = "Failed to list cache directory files: " + file;
            Log.m3023e("SimpleCache", str);
            simpleCache.f12652k = new Cache.CacheException(str);
            return;
        }
        long m3001f = m3001f(listFiles);
        simpleCache.f12649h = m3001f;
        if (m3001f == -1) {
            try {
                simpleCache.f12649h = m3000d(file);
            } catch (IOException e2) {
                String str2 = "Failed to create cache UID: " + file;
                Log.m3024e("SimpleCache", str2, e2);
                simpleCache.f12652k = new Cache.CacheException(str2, e2);
                return;
            }
        }
        try {
            c1625ok.m6576e(simpleCache.f12649h);
            C1540m9 c1540m9 = simpleCache.f12645d;
            if (c1540m9 != null) {
                c1540m9.m6097g(simpleCache.f12649h);
                HashMap m6095e = c1540m9.m6095e();
                simpleCache.m3004e(file, true, listFiles, m6095e);
                c1540m9.m6104n(m6095e.keySet());
            } else {
                simpleCache.m3004e(file, true, listFiles, null);
            }
            UnmodifiableIterator it = ImmutableSet.copyOf((Collection) c1625ok.f23831a.keySet()).iterator();
            while (it.hasNext()) {
                c1625ok.m6577f((String) it.next());
            }
            try {
                c1625ok.m6578g();
            } catch (IOException e3) {
                Log.m3024e("SimpleCache", "Storing index file failed", e3);
            }
        } catch (IOException e4) {
            String str3 = "Failed to initialize cache indices: " + file;
            Log.m3024e("SimpleCache", str3, e4);
            simpleCache.f12652k = new Cache.CacheException(str3, e4);
        }
    }

    /* renamed from: c */
    public static void m2999c(File file) {
        if (!file.mkdirs() && !file.isDirectory()) {
            String str = "Failed to create cache directory: " + file;
            Log.m3023e("SimpleCache", str);
            throw new Cache.CacheException(str);
        }
    }

    /* renamed from: d */
    public static long m3000d(File file) {
        long abs;
        long nextLong = new SecureRandom().nextLong();
        if (nextLong == Long.MIN_VALUE) {
            abs = 0;
        } else {
            abs = Math.abs(nextLong);
        }
        File file2 = new File(file, AbstractC1726qj.m7057m(Long.toString(abs, 16), ".uid"));
        if (file2.createNewFile()) {
            return abs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    @WorkerThread
    public static void delete(File file, @Nullable DatabaseProvider databaseProvider) {
        if (!file.exists()) {
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            file.delete();
            return;
        }
        if (databaseProvider != null) {
            long m3001f = m3001f(listFiles);
            if (m3001f != -1) {
                try {
                    String hexString = Long.toHexString(m3001f);
                    try {
                        String str = "ExoPlayerCacheFileMetadata" + hexString;
                        SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            VersionTable.removeVersion(writableDatabase, 2, hexString);
                            writableDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e) {
                        throw new DatabaseIOException(e);
                    }
                } catch (DatabaseIOException unused) {
                    Log.m3027w("SimpleCache", "Failed to delete file metadata: " + m3001f);
                }
                try {
                    C1514lk.m5929i(databaseProvider, Long.toHexString(m3001f));
                } catch (DatabaseIOException unused2) {
                    Log.m3027w("SimpleCache", "Failed to delete file metadata: " + m3001f);
                }
            }
        }
        Util.recursiveDelete(file);
    }

    /* renamed from: f */
    public static long m3001f(File[] fileArr) {
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            File file = fileArr[i];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return Long.parseLong(name.substring(0, name.indexOf(46)), 16);
                } catch (NumberFormatException unused) {
                    Log.m3023e("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    public static synchronized boolean isCacheFolderLocked(File file) {
        boolean contains;
        synchronized (SimpleCache.class) {
            contains = f12641l.contains(file.getAbsoluteFile());
        }
        return contains;
    }

    /* renamed from: j */
    public static synchronized void m3002j(File file) {
        synchronized (SimpleCache.class) {
            f12641l.remove(file.getAbsoluteFile());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized NavigableSet<CacheSpan> addListener(String str, Cache.Listener listener) {
        try {
            Assertions.checkState(!this.f12651j);
            Assertions.checkNotNull(str);
            Assertions.checkNotNull(listener);
            ArrayList arrayList = (ArrayList) this.f12646e.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f12646e.put(str, arrayList);
            }
            arrayList.add(listener);
        } catch (Throwable th) {
            throw th;
        }
        return getCachedSpans(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void applyContentMetadataMutations(String str, ContentMetadataMutations contentMetadataMutations) {
        Assertions.checkState(!this.f12651j);
        checkInitialization();
        C1625ok c1625ok = this.f12644c;
        C1394kk m6575d = c1625ok.m6575d(str);
        DefaultContentMetadata defaultContentMetadata = m6575d.f20881e;
        DefaultContentMetadata copyWithMutationsApplied = defaultContentMetadata.copyWithMutationsApplied(contentMetadataMutations);
        m6575d.f20881e = copyWithMutationsApplied;
        if (!copyWithMutationsApplied.equals(defaultContentMetadata)) {
            c1625ok.f23835e.mo5932c(m6575d);
        }
        try {
            this.f12644c.m6578g();
        } catch (IOException e) {
            throw new Cache.CacheException(e);
        }
    }

    /* renamed from: b */
    public final void m3003b(ji2 ji2Var) {
        this.f12644c.m6575d(ji2Var.key).f20879c.add(ji2Var);
        this.f12650i += ji2Var.length;
        ArrayList arrayList = (ArrayList) this.f12646e.get(ji2Var.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).onSpanAdded(this, ji2Var);
            }
        }
        this.f12643b.onSpanAdded(this, ji2Var);
    }

    public synchronized void checkInitialization() {
        Cache.CacheException cacheException = this.f12652k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void commitFile(File file, long j) {
        boolean z = true;
        Assertions.checkState(!this.f12651j);
        if (!file.exists()) {
            return;
        }
        if (j == 0) {
            file.delete();
            return;
        }
        ji2 ji2Var = (ji2) Assertions.checkNotNull(ji2.m5442a(file, j, C0643C.TIME_UNSET, this.f12644c));
        C1394kk c1394kk = (C1394kk) Assertions.checkNotNull(this.f12644c.m6574c(ji2Var.key));
        Assertions.checkState(c1394kk.m5562c(ji2Var.position, ji2Var.length));
        long m8193a = AbstractC1997xv.m8193a(c1394kk.f20881e);
        if (m8193a != -1) {
            if (ji2Var.position + ji2Var.length > m8193a) {
                z = false;
            }
            Assertions.checkState(z);
        }
        if (this.f12645d != null) {
            try {
                this.f12645d.m6110t(file.getName(), ji2Var.length, ji2Var.lastTouchTimestamp);
            } catch (IOException e) {
                throw new Cache.CacheException(e);
            }
        }
        m3003b(ji2Var);
        try {
            this.f12644c.m6578g();
            notifyAll();
        } catch (IOException e2) {
            throw new Cache.CacheException(e2);
        }
    }

    /* renamed from: e */
    public final void m3004e(File file, boolean z, File[] fileArr, HashMap hashMap) {
        C1198fk c1198fk;
        long j;
        long j2;
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                String name = file2.getName();
                if (z && name.indexOf(46) == -1) {
                    m3004e(file2, false, file2.listFiles(), hashMap);
                } else if (!z || (!name.startsWith("cached_content_index.exi") && !name.endsWith(".uid"))) {
                    if (hashMap != null) {
                        c1198fk = (C1198fk) hashMap.remove(name);
                    } else {
                        c1198fk = null;
                    }
                    if (c1198fk != null) {
                        j2 = c1198fk.f17298a;
                        j = c1198fk.f17299b;
                    } else {
                        j = -9223372036854775807L;
                        j2 = -1;
                    }
                    ji2 m5442a = ji2.m5442a(file2, j2, j, this.f12644c);
                    if (m5442a != null) {
                        m3003b(m5442a);
                    } else {
                        file2.delete();
                    }
                }
            }
            return;
        }
        if (!z) {
            file.delete();
        }
    }

    /* renamed from: g */
    public final void m3005g(CacheSpan cacheSpan) {
        String str = cacheSpan.key;
        C1625ok c1625ok = this.f12644c;
        C1394kk m6574c = c1625ok.m6574c(str);
        if (m6574c != null && m6574c.f20879c.remove(cacheSpan)) {
            File file = cacheSpan.file;
            if (file != null) {
                file.delete();
            }
            this.f12650i -= cacheSpan.length;
            C1540m9 c1540m9 = this.f12645d;
            if (c1540m9 != null) {
                String name = cacheSpan.file.getName();
                try {
                    Assertions.checkNotNull((String) c1540m9.f22855c);
                    try {
                        ((DatabaseProvider) c1540m9.f22854b).getWritableDatabase().delete((String) c1540m9.f22855c, "name = ?", new String[]{name});
                    } catch (SQLException e) {
                        throw new DatabaseIOException(e);
                    }
                } catch (IOException unused) {
                    ye0.m8279B("Failed to remove file index entry for: ", name, "SimpleCache");
                }
            }
            c1625ok.m6577f(m6574c.f20878b);
            ArrayList arrayList = (ArrayList) this.f12646e.get(cacheSpan.key);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((Cache.Listener) arrayList.get(size)).onSpanRemoved(this, cacheSpan);
                }
            }
            this.f12643b.onSpanRemoved(this, cacheSpan);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCacheSpace() {
        Assertions.checkState(!this.f12651j);
        return this.f12650i;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCachedBytes(String str, long j, long j2) {
        long j3;
        long j4;
        long j5;
        if (j2 == -1) {
            j3 = Long.MAX_VALUE;
        } else {
            j3 = j + j2;
        }
        if (j3 < 0) {
            j4 = Long.MAX_VALUE;
        } else {
            j4 = j3;
        }
        long j6 = j;
        j5 = 0;
        while (j6 < j4) {
            long cachedLength = getCachedLength(str, j6, j4 - j6);
            if (cachedLength > 0) {
                j5 += cachedLength;
            } else {
                cachedLength = -cachedLength;
            }
            j6 += cachedLength;
        }
        return j5;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCachedLength(String str, long j, long j2) {
        long j3;
        Assertions.checkState(!this.f12651j);
        if (j2 == -1) {
            j2 = Long.MAX_VALUE;
        }
        C1394kk m6574c = this.f12644c.m6574c(str);
        if (m6574c != null) {
            j3 = m6574c.m5560a(j, j2);
        } else {
            j3 = -j2;
        }
        return j3;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized NavigableSet<CacheSpan> getCachedSpans(String str) {
        TreeSet treeSet;
        try {
            Assertions.checkState(!this.f12651j);
            C1394kk m6574c = this.f12644c.m6574c(str);
            if (m6574c != null && !m6574c.f20879c.isEmpty()) {
                treeSet = new TreeSet((Collection) m6574c.f20879c);
            }
            treeSet = new TreeSet();
        } catch (Throwable th) {
            throw th;
        }
        return treeSet;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized ContentMetadata getContentMetadata(String str) {
        DefaultContentMetadata defaultContentMetadata;
        Assertions.checkState(!this.f12651j);
        C1394kk m6574c = this.f12644c.m6574c(str);
        if (m6574c != null) {
            defaultContentMetadata = m6574c.f20881e;
        } else {
            defaultContentMetadata = DefaultContentMetadata.EMPTY;
        }
        return defaultContentMetadata;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized Set<String> getKeys() {
        Assertions.checkState(!this.f12651j);
        return new HashSet(this.f12644c.f23831a.keySet());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getUid() {
        return this.f12649h;
    }

    /* renamed from: h */
    public final void m3006h() {
        ArrayList arrayList = new ArrayList();
        Iterator it = Collections.unmodifiableCollection(this.f12644c.f23831a.values()).iterator();
        while (it.hasNext()) {
            Iterator it2 = ((C1394kk) it.next()).f20879c.iterator();
            while (it2.hasNext()) {
                CacheSpan cacheSpan = (CacheSpan) it2.next();
                if (cacheSpan.file.length() != cacheSpan.length) {
                    arrayList.add(cacheSpan);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            m3005g((CacheSpan) arrayList.get(i));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a2  */
    /* JADX WARN: Type inference failed for: r3v4, types: [ji2, com.google.android.exoplayer2.upstream.cache.CacheSpan, java.lang.Object] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ji2 m3007i(String str, ji2 ji2Var) {
        boolean z;
        File file;
        ArrayList arrayList;
        if (!this.f12648g) {
            return ji2Var;
        }
        String name = ((File) Assertions.checkNotNull(ji2Var.file)).getName();
        long j = ji2Var.length;
        long currentTimeMillis = System.currentTimeMillis();
        C1540m9 c1540m9 = this.f12645d;
        if (c1540m9 != null) {
            try {
                c1540m9.m6110t(name, j, currentTimeMillis);
            } catch (IOException unused) {
                Log.m3027w("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z = false;
        } else {
            z = true;
        }
        C1394kk m6574c = this.f12644c.m6574c(str);
        TreeSet treeSet = m6574c.f20879c;
        Assertions.checkState(treeSet.remove(ji2Var));
        File file2 = (File) Assertions.checkNotNull(ji2Var.file);
        if (z) {
            File m5443b = ji2.m5443b((File) Assertions.checkNotNull(file2.getParentFile()), m6574c.f20877a, ji2Var.position, currentTimeMillis);
            if (file2.renameTo(m5443b)) {
                file = m5443b;
                Assertions.checkState(ji2Var.isCached);
                ?? cacheSpan = new CacheSpan(ji2Var.key, ji2Var.position, ji2Var.length, currentTimeMillis, file);
                treeSet.add(cacheSpan);
                arrayList = (ArrayList) this.f12646e.get(ji2Var.key);
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ((Cache.Listener) arrayList.get(size)).onSpanTouched(this, ji2Var, cacheSpan);
                    }
                }
                this.f12643b.onSpanTouched(this, ji2Var, cacheSpan);
                return cacheSpan;
            }
            Log.m3027w("CachedContent", "Failed to rename " + file2 + " to " + m5443b);
        }
        file = file2;
        Assertions.checkState(ji2Var.isCached);
        ?? cacheSpan2 = new CacheSpan(ji2Var.key, ji2Var.position, ji2Var.length, currentTimeMillis, file);
        treeSet.add(cacheSpan2);
        arrayList = (ArrayList) this.f12646e.get(ji2Var.key);
        if (arrayList != null) {
        }
        this.f12643b.onSpanTouched(this, ji2Var, cacheSpan2);
        return cacheSpan2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
    
        if (r3.m5560a(r4, r6) >= r6) goto L12;
     */
    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isCached(String str, long j, long j2) {
        boolean z;
        z = true;
        Assertions.checkState(!this.f12651j);
        C1394kk m6574c = this.f12644c.m6574c(str);
        if (m6574c != null) {
        }
        z = false;
        return z;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void release() {
        if (this.f12651j) {
            return;
        }
        this.f12646e.clear();
        m3006h();
        try {
            try {
                this.f12644c.m6578g();
                m3002j(this.f12642a);
            } catch (IOException e) {
                Log.m3024e("SimpleCache", "Storing index file failed", e);
                m3002j(this.f12642a);
            }
            this.f12651j = true;
        } catch (Throwable th) {
            m3002j(this.f12642a);
            this.f12651j = true;
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void releaseHoleSpan(CacheSpan cacheSpan) {
        Assertions.checkState(!this.f12651j);
        C1394kk c1394kk = (C1394kk) Assertions.checkNotNull(this.f12644c.m6574c(cacheSpan.key));
        long j = cacheSpan.position;
        int i = 0;
        while (true) {
            ArrayList arrayList = c1394kk.f20880d;
            if (i < arrayList.size()) {
                if (((C1357jk) arrayList.get(i)).f20526a == j) {
                    arrayList.remove(i);
                    this.f12644c.m6577f(c1394kk.f20878b);
                    notifyAll();
                } else {
                    i++;
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeListener(String str, Cache.Listener listener) {
        if (this.f12651j) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.f12646e.get(str);
        if (arrayList != null) {
            arrayList.remove(listener);
            if (arrayList.isEmpty()) {
                this.f12646e.remove(str);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeResource(String str) {
        Assertions.checkState(!this.f12651j);
        Iterator<CacheSpan> it = getCachedSpans(str).iterator();
        while (it.hasNext()) {
            m3005g(it.next());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeSpan(CacheSpan cacheSpan) {
        Assertions.checkState(!this.f12651j);
        m3005g(cacheSpan);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized File startFile(String str, long j, long j2) {
        C1394kk m6574c;
        File file;
        try {
            Assertions.checkState(!this.f12651j);
            checkInitialization();
            m6574c = this.f12644c.m6574c(str);
            Assertions.checkNotNull(m6574c);
            Assertions.checkState(m6574c.m5562c(j, j2));
            if (!this.f12642a.exists()) {
                m2999c(this.f12642a);
                m3006h();
            }
            this.f12643b.onStartFile(this, str, j, j2);
            file = new File(this.f12642a, Integer.toString(this.f12647f.nextInt(10)));
            if (!file.exists()) {
                m2999c(file);
            }
        } catch (Throwable th) {
            throw th;
        }
        return ji2.m5443b(file, m6574c.f20877a, j, System.currentTimeMillis());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized CacheSpan startReadWrite(String str, long j, long j2) {
        CacheSpan startReadWriteNonBlocking;
        Assertions.checkState(!this.f12651j);
        checkInitialization();
        while (true) {
            startReadWriteNonBlocking = startReadWriteNonBlocking(str, j, j2);
            if (startReadWriteNonBlocking == null) {
                wait();
            }
        }
        return startReadWriteNonBlocking;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.android.exoplayer2.upstream.cache.CacheSpan] */
    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    @Nullable
    public synchronized CacheSpan startReadWriteNonBlocking(String str, long j, long j2) {
        ji2 m5561b;
        ji2 ji2Var;
        Assertions.checkState(!this.f12651j);
        checkInitialization();
        C1394kk m6574c = this.f12644c.m6574c(str);
        if (m6574c == null) {
            ji2Var = new CacheSpan(str, j, j2, C0643C.TIME_UNSET, null);
        } else {
            while (true) {
                m5561b = m6574c.m5561b(j, j2);
                if (!m5561b.isCached || m5561b.file.length() == m5561b.length) {
                    break;
                }
                m3006h();
            }
            ji2Var = m5561b;
        }
        if (ji2Var.isCached) {
            return m3007i(str, ji2Var);
        }
        C1394kk m6575d = this.f12644c.m6575d(str);
        long j3 = ji2Var.length;
        int i = 0;
        while (true) {
            ArrayList arrayList = m6575d.f20880d;
            if (i < arrayList.size()) {
                C1357jk c1357jk = (C1357jk) arrayList.get(i);
                long j4 = c1357jk.f20526a;
                if (j4 <= j) {
                    long j5 = c1357jk.f20527b;
                    if (j5 == -1 || j4 + j5 > j) {
                        break;
                    }
                    i++;
                } else {
                    if (j3 == -1 || j + j3 > j4) {
                        break;
                    }
                    i++;
                }
            } else {
                arrayList.add(new C1357jk(j, j3));
                return ji2Var;
            }
        }
        return null;
    }

    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor, @Nullable byte[] bArr) {
        this(file, cacheEvictor, bArr, bArr != null);
    }

    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor, @Nullable byte[] bArr, boolean z) {
        this(file, cacheEvictor, null, bArr, z, true);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider) {
        this(file, cacheEvictor, databaseProvider, null, false, false);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, @Nullable DatabaseProvider databaseProvider, @Nullable byte[] bArr, boolean z, boolean z2) {
        boolean add;
        C1625ok c1625ok = new C1625ok(databaseProvider, file, bArr, z, z2);
        C1540m9 c1540m9 = (databaseProvider == null || z2) ? null : new C1540m9(1, databaseProvider);
        synchronized (SimpleCache.class) {
            add = f12641l.add(file.getAbsoluteFile());
        }
        if (add) {
            this.f12642a = file;
            this.f12643b = cacheEvictor;
            this.f12644c = c1625ok;
            this.f12645d = c1540m9;
            this.f12646e = new HashMap();
            this.f12647f = new Random();
            this.f12648g = cacheEvictor.requiresCacheSpanTouches();
            this.f12649h = -1L;
            ConditionVariable conditionVariable = new ConditionVariable();
            new f00(this, conditionVariable).start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
    }
}
