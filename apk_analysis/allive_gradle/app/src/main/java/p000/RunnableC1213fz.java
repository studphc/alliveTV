package p000;

import android.os.Build;
import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;

/* renamed from: fz */
/* loaded from: classes.dex */
public final class RunnableC1213fz implements DataFetcherGenerator$FetcherReadyCallback, Runnable, Comparable, FactoryPools.Poolable {

    /* renamed from: A */
    public volatile InterfaceC1667oy f17449A;

    /* renamed from: B */
    public volatile boolean f17450B;

    /* renamed from: C */
    public volatile boolean f17451C;

    /* renamed from: D */
    public boolean f17452D;

    /* renamed from: E */
    public int f17453E;

    /* renamed from: F */
    public int f17454F;

    /* renamed from: d */
    public final i90 f17458d;

    /* renamed from: e */
    public final Pools.Pool f17459e;

    /* renamed from: h */
    public GlideContext f17462h;

    /* renamed from: i */
    public Key f17463i;

    /* renamed from: j */
    public Priority f17464j;

    /* renamed from: k */
    public n90 f17465k;

    /* renamed from: l */
    public int f17466l;

    /* renamed from: m */
    public int f17467m;

    /* renamed from: n */
    public DiskCacheStrategy f17468n;

    /* renamed from: o */
    public Options f17469o;

    /* renamed from: p */
    public l90 f17470p;

    /* renamed from: q */
    public int f17471q;

    /* renamed from: r */
    public long f17472r;

    /* renamed from: s */
    public boolean f17473s;

    /* renamed from: t */
    public Object f17474t;

    /* renamed from: u */
    public Thread f17475u;

    /* renamed from: v */
    public Key f17476v;

    /* renamed from: w */
    public Key f17477w;

    /* renamed from: x */
    public Object f17478x;

    /* renamed from: y */
    public DataSource f17479y;

    /* renamed from: z */
    public DataFetcher f17480z;

    /* renamed from: a */
    public final C0538az f17455a = new C0538az();

    /* renamed from: b */
    public final ArrayList f17456b = new ArrayList();

    /* renamed from: c */
    public final StateVerifier f17457c = StateVerifier.newInstance();

    /* renamed from: f */
    public final C1139dz f17460f = new Object();

    /* renamed from: g */
    public final C1176ez f17461g = new Object();

    /* JADX WARN: Type inference failed for: r0v3, types: [dz, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [ez, java.lang.Object] */
    public RunnableC1213fz(i90 i90Var, Pools.Pool pool) {
        this.f17458d = i90Var;
        this.f17459e = pool;
    }

    /* renamed from: a */
    public final Resource m4875a(Object obj, DataSource dataSource) {
        boolean z;
        Class<?> cls = obj.getClass();
        C0538az c0538az = this.f17455a;
        LoadPath loadPath = c0538az.f7800c.getRegistry().getLoadPath(cls, c0538az.f7804g, c0538az.f7808k);
        Options options = this.f17469o;
        if (Build.VERSION.SDK_INT >= 26) {
            if (dataSource != DataSource.RESOURCE_DISK_CACHE && !c0538az.f7815r) {
                z = false;
            } else {
                z = true;
            }
            Option<Boolean> option = Downsampler.ALLOW_HARDWARE_CONFIG;
            Boolean bool = (Boolean) options.get(option);
            if (bool == null || (bool.booleanValue() && !z)) {
                options = new Options();
                options.putAll(this.f17469o);
                options.set(option, Boolean.valueOf(z));
            }
        }
        Options options2 = options;
        DataRewinder rewinder = this.f17462h.getRegistry().getRewinder(obj);
        try {
            return loadPath.load(rewinder, options2, this.f17466l, this.f17467m, new C1540m9(5, this, dataSource, false));
        } finally {
            rewinder.cleanup();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e4  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4876b() {
        Resource resource;
        DataFetcher dataFetcher;
        Object obj;
        DataSource dataSource;
        if (Log.isLoggable("DecodeJob", 2)) {
            m4879e("Retrieved data", "data: " + this.f17478x + ", cache key: " + this.f17476v + ", fetcher: " + this.f17480z, this.f17472r);
        }
        rd1 rd1Var = null;
        try {
            dataFetcher = this.f17480z;
            obj = this.f17478x;
            dataSource = this.f17479y;
        } catch (GlideException e) {
            Key key = this.f17477w;
            DataSource dataSource2 = this.f17479y;
            e.f8682b = key;
            e.f8683c = dataSource2;
            e.f8684d = null;
            this.f17456b.add(e);
        }
        if (obj != null) {
            try {
                long logTime = LogTime.getLogTime();
                resource = m4875a(obj, dataSource);
                if (Log.isLoggable("DecodeJob", 2)) {
                    m4879e("Decoded result " + resource, null, logTime);
                }
                dataFetcher.cleanup();
                if (resource == null) {
                }
            } finally {
                dataFetcher.cleanup();
            }
        } else {
            resource = null;
            if (resource == null) {
                DataSource dataSource3 = this.f17479y;
                boolean z = this.f17452D;
                if (resource instanceof Initializable) {
                    ((Initializable) resource).initialize();
                }
                boolean z2 = true;
                if (this.f17460f.f16618c != null) {
                    rd1Var = (rd1) Preconditions.checkNotNull((rd1) rd1.f25935e.acquire());
                    rd1Var.f25939d = false;
                    rd1Var.f25938c = true;
                    rd1Var.f25937b = resource;
                    resource = rd1Var;
                }
                m4887m();
                l90 l90Var = this.f17470p;
                synchronized (l90Var) {
                    l90Var.f22408q = resource;
                    l90Var.f22409r = dataSource3;
                    l90Var.f22416y = z;
                }
                l90Var.m5904f();
                this.f17453E = 5;
                try {
                    C1139dz c1139dz = this.f17460f;
                    if (c1139dz.f16618c == null) {
                        z2 = false;
                    }
                    if (z2) {
                        c1139dz.m4646a(this.f17458d, this.f17469o);
                    }
                    m4881g();
                    return;
                } finally {
                    if (rd1Var != null) {
                        rd1Var.m7268a();
                    }
                }
            }
            m4885k();
        }
    }

    /* renamed from: c */
    public final InterfaceC1667oy m4877c() {
        int m7041F = AbstractC1726qj.m7041F(this.f17453E);
        C0538az c0538az = this.f17455a;
        if (m7041F != 1) {
            if (m7041F != 2) {
                if (m7041F != 3) {
                    if (m7041F == 5) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized stage: ".concat(AbstractC1726qj.m7042G(this.f17453E)));
                }
                return new ul2(c0538az, this);
            }
            return new C1528ly(c0538az.m1981a(), c0538az, this);
        }
        return new sb2(c0538az, this);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        RunnableC1213fz runnableC1213fz = (RunnableC1213fz) obj;
        int ordinal = this.f17464j.ordinal() - runnableC1213fz.f17464j.ordinal();
        if (ordinal == 0) {
            return this.f17471q - runnableC1213fz.f17471q;
        }
        return ordinal;
    }

    /* renamed from: d */
    public final int m4878d(int i) {
        int m7041F = AbstractC1726qj.m7041F(i);
        if (m7041F != 0) {
            if (m7041F != 1) {
                if (m7041F != 2) {
                    if (m7041F == 3 || m7041F == 5) {
                        return 6;
                    }
                    throw new IllegalArgumentException("Unrecognized stage: ".concat(AbstractC1726qj.m7042G(i)));
                }
                if (this.f17473s) {
                    return 6;
                }
                return 4;
            }
            if (this.f17468n.decodeCachedData()) {
                return 3;
            }
            return m4878d(3);
        }
        if (this.f17468n.decodeCachedResource()) {
            return 2;
        }
        return m4878d(2);
    }

    /* renamed from: e */
    public final void m4879e(String str, String str2, long j) {
        String str3;
        StringBuilder m8303w = ye0.m8303w(str, " in ");
        m8303w.append(LogTime.getElapsedMillis(j));
        m8303w.append(", load key: ");
        m8303w.append(this.f17465k);
        if (str2 != null) {
            str3 = ", ".concat(str2);
        } else {
            str3 = "";
        }
        m8303w.append(str3);
        m8303w.append(", thread: ");
        m8303w.append(Thread.currentThread().getName());
        Log.v("DecodeJob", m8303w.toString());
    }

    /* renamed from: f */
    public final void m4880f() {
        m4887m();
        GlideException glideException = new GlideException("Failed to load resource", new ArrayList(this.f17456b));
        l90 l90Var = this.f17470p;
        synchronized (l90Var) {
            l90Var.f22411t = glideException;
        }
        l90Var.m5903e();
        m4882h();
    }

    /* renamed from: g */
    public final void m4881g() {
        boolean m4763a;
        C1176ez c1176ez = this.f17461g;
        synchronized (c1176ez) {
            c1176ez.f17043b = true;
            m4763a = c1176ez.m4763a();
        }
        if (m4763a) {
            m4884j();
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public final StateVerifier getVerifier() {
        return this.f17457c;
    }

    /* renamed from: h */
    public final void m4882h() {
        boolean m4763a;
        C1176ez c1176ez = this.f17461g;
        synchronized (c1176ez) {
            c1176ez.f17044c = true;
            m4763a = c1176ez.m4763a();
        }
        if (m4763a) {
            m4884j();
        }
    }

    /* renamed from: i */
    public final void m4883i() {
        boolean m4763a;
        C1176ez c1176ez = this.f17461g;
        synchronized (c1176ez) {
            c1176ez.f17042a = true;
            m4763a = c1176ez.m4763a();
        }
        if (m4763a) {
            m4884j();
        }
    }

    /* renamed from: j */
    public final void m4884j() {
        C1176ez c1176ez = this.f17461g;
        synchronized (c1176ez) {
            c1176ez.f17043b = false;
            c1176ez.f17042a = false;
            c1176ez.f17044c = false;
        }
        C1139dz c1139dz = this.f17460f;
        c1139dz.f16616a = null;
        c1139dz.f16617b = null;
        c1139dz.f16618c = null;
        C0538az c0538az = this.f17455a;
        c0538az.f7800c = null;
        c0538az.f7801d = null;
        c0538az.f7811n = null;
        c0538az.f7804g = null;
        c0538az.f7808k = null;
        c0538az.f7806i = null;
        c0538az.f7812o = null;
        c0538az.f7807j = null;
        c0538az.f7813p = null;
        c0538az.f7798a.clear();
        c0538az.f7809l = false;
        c0538az.f7799b.clear();
        c0538az.f7810m = false;
        this.f17450B = false;
        this.f17462h = null;
        this.f17463i = null;
        this.f17469o = null;
        this.f17464j = null;
        this.f17465k = null;
        this.f17470p = null;
        this.f17453E = 0;
        this.f17449A = null;
        this.f17475u = null;
        this.f17476v = null;
        this.f17478x = null;
        this.f17479y = null;
        this.f17480z = null;
        this.f17472r = 0L;
        this.f17451C = false;
        this.f17474t = null;
        this.f17456b.clear();
        this.f17459e.release(this);
    }

    /* renamed from: k */
    public final void m4885k() {
        this.f17475u = Thread.currentThread();
        this.f17472r = LogTime.getLogTime();
        boolean z = false;
        while (!this.f17451C && this.f17449A != null && !(z = this.f17449A.mo5998a())) {
            this.f17453E = m4878d(this.f17453E);
            this.f17449A = m4877c();
            if (this.f17453E == 4) {
                reschedule();
                return;
            }
        }
        if ((this.f17453E == 6 || this.f17451C) && !z) {
            m4880f();
        }
    }

    /* renamed from: l */
    public final void m4886l() {
        String str;
        int m7041F = AbstractC1726qj.m7041F(this.f17454F);
        if (m7041F != 0) {
            if (m7041F != 1) {
                if (m7041F == 2) {
                    m4876b();
                    return;
                }
                int i = this.f17454F;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            str = "null";
                        } else {
                            str = "DECODE_DATA";
                        }
                    } else {
                        str = "SWITCH_TO_SOURCE_SERVICE";
                    }
                } else {
                    str = "INITIALIZE";
                }
                throw new IllegalStateException("Unrecognized run reason: ".concat(str));
            }
            m4885k();
            return;
        }
        this.f17453E = m4878d(1);
        this.f17449A = m4877c();
        m4885k();
    }

    /* renamed from: m */
    public final void m4887m() {
        Throwable th;
        this.f17457c.throwIfRecycled();
        if (this.f17450B) {
            if (this.f17456b.isEmpty()) {
                th = null;
            } else {
                th = (Throwable) AbstractC1726qj.m7053i(this.f17456b, 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.f17450B = true;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
    public final void onDataFetcherFailed(Key key, Exception exc, DataFetcher dataFetcher, DataSource dataSource) {
        GlideExecutor glideExecutor;
        dataFetcher.cleanup();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        Class dataClass = dataFetcher.getDataClass();
        glideException.f8682b = key;
        glideException.f8683c = dataSource;
        glideException.f8684d = dataClass;
        this.f17456b.add(glideException);
        if (Thread.currentThread() != this.f17475u) {
            this.f17454F = 2;
            l90 l90Var = this.f17470p;
            if (l90Var.f22405n) {
                glideExecutor = l90Var.f22400i;
            } else if (l90Var.f22406o) {
                glideExecutor = l90Var.f22401j;
            } else {
                glideExecutor = l90Var.f22399h;
            }
            glideExecutor.execute(this);
            return;
        }
        m4885k();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
    public final void onDataFetcherReady(Key key, Object obj, DataFetcher dataFetcher, DataSource dataSource, Key key2) {
        GlideExecutor glideExecutor;
        this.f17476v = key;
        this.f17478x = obj;
        this.f17480z = dataFetcher;
        this.f17479y = dataSource;
        this.f17477w = key2;
        boolean z = false;
        if (key != this.f17455a.m1981a().get(0)) {
            z = true;
        }
        this.f17452D = z;
        if (Thread.currentThread() != this.f17475u) {
            this.f17454F = 3;
            l90 l90Var = this.f17470p;
            if (l90Var.f22405n) {
                glideExecutor = l90Var.f22400i;
            } else if (l90Var.f22406o) {
                glideExecutor = l90Var.f22401j;
            } else {
                glideExecutor = l90Var.f22399h;
            }
            glideExecutor.execute(this);
            return;
        }
        GlideTrace.beginSection("DecodeJob.decodeFromRetrievedData");
        try {
            m4876b();
        } finally {
            GlideTrace.endSection();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
    public final void reschedule() {
        GlideExecutor glideExecutor;
        this.f17454F = 2;
        l90 l90Var = this.f17470p;
        if (l90Var.f22405n) {
            glideExecutor = l90Var.f22400i;
        } else if (l90Var.f22406o) {
            glideExecutor = l90Var.f22401j;
        } else {
            glideExecutor = l90Var.f22399h;
        }
        glideExecutor.execute(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        GlideTrace.beginSectionFormat("DecodeJob#run(model=%s)", this.f17474t);
        DataFetcher dataFetcher = this.f17480z;
        try {
            try {
                try {
                    if (this.f17451C) {
                        m4880f();
                        if (dataFetcher != null) {
                            dataFetcher.cleanup();
                        }
                        GlideTrace.endSection();
                        return;
                    }
                    m4886l();
                    if (dataFetcher != null) {
                        dataFetcher.cleanup();
                    }
                    GlideTrace.endSection();
                } catch (C1875uk e) {
                    throw e;
                }
            } catch (Throwable th) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.f17451C + ", stage: " + AbstractC1726qj.m7042G(this.f17453E), th);
                }
                if (this.f17453E != 5) {
                    this.f17456b.add(th);
                    m4880f();
                }
                if (!this.f17451C) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            GlideTrace.endSection();
            throw th2;
        }
    }
}
