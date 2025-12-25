package p000;

import android.graphics.Rect;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.FocusStrategy$BoundsAdapter;
import androidx.recyclerview.widget.StableIdStorage$StableIdLookup;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.zas;
import com.google.android.gms.internal.measurement.zzmd;
import com.google.common.base.FinalizableReferenceQueue;
import com.google.gson.internal.ObjectConstructor;
import com.orhanobut.hawk.LogInterceptor;
import io.reactivex.rxjava3.functions.Predicate;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes.dex */
public class wd0 implements xd0, df1, ss2, qd3, ObjectConstructor, vu0, FocusStrategy$BoundsAdapter, am2, Predicate, LogInterceptor, el1, sx1, StableIdStorage$StableIdLookup, SharingStarted, d23, zas {

    /* renamed from: b */
    public static final wd0 f28141b = new wd0(1);

    /* renamed from: c */
    public static final wd0 f28142c = new wd0(2);

    /* renamed from: d */
    public static final wd0 f28143d = new wd0(3);

    /* renamed from: e */
    public static final wd0 f28144e = new wd0(4);

    /* renamed from: f */
    public static final wd0 f28145f = new wd0(5);

    /* renamed from: a */
    public final /* synthetic */ int f28146a;

    public /* synthetic */ wd0(int i) {
        this.f28146a = i;
    }

    /* renamed from: q */
    public static URL m8048q() {
        String str;
        String concat = String.valueOf("com.google.common.base.internal.Finalizer".replace('.', '/')).concat(".class");
        URL resource = wd0.class.getClassLoader().getResource(concat);
        if (resource != null) {
            String url = resource.toString();
            if (!url.endsWith(concat)) {
                if (url.length() != 0) {
                    str = "Unsupported path style: ".concat(url);
                } else {
                    str = new String("Unsupported path style: ");
                }
                throw new IOException(str);
            }
            return new URL(resource, url.substring(0, url.length() - concat.length()));
        }
        throw new FileNotFoundException(concat);
    }

    @Override // p000.el1
    /* renamed from: a */
    public MediaCodecInfo mo4723a(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // p000.df1
    /* renamed from: b */
    public ef1 mo4573b(zf1 zf1Var, int i) {
        switch (this.f28146a) {
            case 1:
                return new ef1(zf1Var, i);
            case 2:
                return new of1(zf1Var, i);
            default:
                return new sf1(zf1Var, i);
        }
    }

    @Override // p000.df1
    /* renamed from: c */
    public if1 mo4574c() {
        switch (this.f28146a) {
            case 1:
                return if1.f18394a;
            case 2:
                return if1.f18394a;
            default:
                return if1.f18395b;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [wx1, java.util.ArrayList] */
    @Override // p000.sx1
    public wx1 call() {
        return new ArrayList(16);
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow command(StateFlow stateFlow) {
        return FlowKt.flow(new kn2(stateFlow, null));
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f28146a) {
            case 7:
                return new LinkedHashSet();
            case 8:
                return new ArrayList();
            case 9:
                return new ConcurrentHashMap();
            default:
                return new LinkedHashMap();
        }
    }

    @Override // p000.df1
    /* renamed from: d */
    public if1 mo4575d() {
        switch (this.f28146a) {
            case 1:
                return if1.f18394a;
            case 2:
                return if1.f18395b;
            default:
                return if1.f18394a;
        }
    }

    @Override // p000.xd0
    /* renamed from: e */
    public Class mo4626e() {
        switch (this.f28146a) {
            case 0:
                try {
                    return new URLClassLoader(new URL[]{m8048q()}, null).loadClass("com.google.common.base.internal.Finalizer");
                } catch (Exception e) {
                    FinalizableReferenceQueue.f14476d.log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", (Throwable) e);
                    return null;
                }
            default:
                try {
                    ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                    if (systemClassLoader == null) {
                        return null;
                    }
                    try {
                        return systemClassLoader.loadClass("com.google.common.base.internal.Finalizer");
                    } catch (ClassNotFoundException unused) {
                        return null;
                    }
                } catch (SecurityException unused2) {
                    FinalizableReferenceQueue.f14476d.info("Not allowed to access system class loader.");
                    return null;
                }
        }
    }

    @Override // p000.el1
    /* renamed from: f */
    public boolean mo4724f(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if ("secure-playback".equals(str) && MimeTypes.VIDEO_H264.equals(str2)) {
            return true;
        }
        return false;
    }

    @Override // p000.df1
    /* renamed from: g */
    public cf1 mo4576g(ef1 ef1Var, cf1 cf1Var, cf1 cf1Var2) {
        switch (this.f28146a) {
            case 1:
                jf1 jf1Var = (jf1) cf1Var;
                return new ye1(jf1Var.f28923a, jf1Var.f28924b, (jf1) cf1Var2);
            case 2:
                of1 of1Var = (of1) ef1Var;
                nf1 nf1Var = (nf1) cf1Var;
                nf1 nf1Var2 = (nf1) cf1Var2;
                int i = ef1.f16785g;
                if (nf1Var.getValue() == null) {
                    return null;
                }
                ReferenceQueue referenceQueue = of1Var.f23797h;
                nf1 nf1Var3 = new nf1(nf1Var.f28923a, nf1Var.f28924b, nf1Var2);
                nf1Var3.f23349d = nf1Var.f23349d.mo8055b(referenceQueue, nf1Var3);
                return nf1Var3;
            default:
                sf1 sf1Var = (sf1) ef1Var;
                rf1 rf1Var = (rf1) cf1Var;
                rf1 rf1Var2 = (rf1) cf1Var2;
                if (rf1Var.get() == 0) {
                    return null;
                }
                rf1 rf1Var3 = new rf1(sf1Var.f26407h, rf1Var.get(), rf1Var.f29337a, rf1Var2);
                rf1Var3.f25955c = rf1Var.f25955c;
                return rf1Var3;
        }
    }

    @Override // p000.d23
    /* renamed from: h */
    public void mo4514h(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        switch (this.f28146a) {
            case 27:
                mediaMetadataRetriever.setDataSource(new c23((ByteBuffer) obj));
                return;
            default:
                mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
                return;
        }
    }

    @Override // p000.df1
    /* renamed from: i */
    public void mo4577i(ef1 ef1Var, cf1 cf1Var, Object obj) {
        switch (this.f28146a) {
            case 1:
                return;
            case 2:
                nf1 nf1Var = (nf1) cf1Var;
                ReferenceQueue referenceQueue = ((of1) ef1Var).f23797h;
                wf1 wf1Var = nf1Var.f23349d;
                nf1Var.f23349d = new xf1(referenceQueue, obj, nf1Var);
                wf1Var.clear();
                return;
            default:
                ((rf1) cf1Var).f25955c = obj;
                return;
        }
    }

    @Override // p000.ss2
    /* renamed from: j */
    public int mo4628j(CharSequence charSequence, int i, int i2) {
        int i3 = i2 + i;
        boolean z = false;
        while (true) {
            char c = 2;
            if (i < i3) {
                byte directionality = Character.getDirectionality(charSequence.charAt(i));
                TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
                if (directionality != 0) {
                    if (directionality == 1 || directionality == 2) {
                        c = 0;
                    }
                } else {
                    c = 1;
                }
                if (c == 0) {
                    return 0;
                }
                if (c == 1) {
                    z = true;
                }
                i++;
            } else {
                if (z) {
                    return 1;
                }
                return 2;
            }
        }
    }

    @Override // p000.el1
    /* renamed from: k */
    public boolean mo4725k(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    @Override // p000.el1
    /* renamed from: l */
    public int mo4726l() {
        return MediaCodecList.getCodecCount();
    }

    @Override // p000.qd3
    /* renamed from: m */
    public wd3 mo101m(Class cls) {
        if (zzmd.class.isAssignableFrom(cls)) {
            try {
                return (wd3) zzmd.m3469b(cls.asSubclass(zzmd.class)).zzl(3, null, null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
    }

    @Override // p000.df1
    /* renamed from: n */
    public cf1 mo4578n(ef1 ef1Var, Object obj, int i, cf1 cf1Var) {
        switch (this.f28146a) {
            case 1:
                return new ye1(obj, i, (jf1) cf1Var);
            case 2:
                return new nf1(obj, i, (nf1) cf1Var);
            default:
                return new rf1(((sf1) ef1Var).f26407h, obj, i, (rf1) cf1Var);
        }
    }

    @Override // p000.qd3
    /* renamed from: o */
    public boolean mo102o(Class cls) {
        return zzmd.class.isAssignableFrom(cls);
    }

    @Override // androidx.customview.widget.FocusStrategy$BoundsAdapter
    public void obtainBounds(Object obj, Rect rect) {
        ((AccessibilityNodeInfoCompat) obj).getBoundsInParent(rect);
    }

    @Override // p000.el1
    /* renamed from: p */
    public boolean mo4727p() {
        return false;
    }

    /* renamed from: r */
    public boolean mo5029r(CharSequence charSequence) {
        return charSequence instanceof PrecomputedTextCompat;
    }

    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(Object obj) {
        return false;
    }

    public String toString() {
        switch (this.f28146a) {
            case 25:
                return "SharingStarted.Lazily";
            default:
                return super.toString();
        }
    }

    @Override // androidx.recyclerview.widget.StableIdStorage$StableIdLookup
    public long localToGlobal(long j) {
        return j;
    }

    @Override // com.orhanobut.hawk.LogInterceptor
    public void onLog(String str) {
    }
}
