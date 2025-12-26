package p000;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Rect;
import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.SystemClock;
import android.service.media.MediaBrowserService;
import android.util.Base64;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.appcompat.R;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.ViewOnKeyListenerC0088b;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.ViewUtils;
import androidx.arch.core.util.Function;
import androidx.core.content.ContextCompat;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader$EndOfFileException;
import com.bumptech.glide.manager.RequestManagerFragment;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.facebook.android.crypto.keychain.AndroidConceal;
import com.facebook.android.crypto.keychain.SharedPrefsBackedKeyChain;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.CryptoConfig;
import com.facebook.crypto.Entity;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mkv.EbmlProcessor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.source.dash.DashManifestStaleException;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.gms.internal.measurement.zzmk;
import com.google.common.base.Preconditions;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.hawk.LogInterceptor;
import com.orhanobut.hawk.Parser;
import com.orhanobut.hawk.Serializer;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Predicate;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.regex.Matcher;

/* loaded from: classes2.dex */
public class b01 implements InterfaceC1665ow, InterfaceC2005y2, OnApplyWindowInsetsListener, InterfaceC1188fa, ListUpdateCallback, MenuItemHoverListener, z80, InterfaceC1849tv, InterfaceC1923vv, LoaderErrorThrower, v00, Function, Predicate, BiConsumer, Serializer, EbmlProcessor, DifferentialMotionFlingTarget, RequestManagerTreeNode {

    /* renamed from: c */
    public static final k93 f7831c = new Object();

    /* renamed from: a */
    public final /* synthetic */ int f7832a;

    /* renamed from: b */
    public final Object f7833b;

    public /* synthetic */ b01(int i, Object obj) {
        this.f7832a = i;
        this.f7833b = obj;
    }

    @Override // p000.InterfaceC1923vv
    /* renamed from: a */
    public Uri mo1984a() {
        Uri linkUri;
        linkUri = ((ContentInfo) this.f7833b).getLinkUri();
        return linkUri;
    }

    @Override // io.reactivex.rxjava3.functions.BiConsumer
    public void accept(Object obj, Object obj2) {
        ((Map) obj).put(((io.reactivex.rxjava3.functions.Function) this.f7833b).apply(obj2), obj2);
    }

    @Override // androidx.arch.core.util.Function
    public Object apply(Object obj) {
        switch (this.f7832a) {
            case 14:
                Fragment fragment = (Fragment) this.f7833b;
                Object obj2 = fragment.f4469w;
                if (obj2 instanceof ActivityResultRegistryOwner) {
                    return ((ActivityResultRegistryOwner) obj2).getActivityResultRegistry();
                }
                return fragment.requireActivity().getActivityResultRegistry();
            default:
                return (ActivityResultRegistry) this.f7833b;
        }
    }

    @Override // p000.InterfaceC1923vv
    /* renamed from: b */
    public ClipData mo1985b() {
        ClipData clip;
        clip = ((ContentInfo) this.f7833b).getClip();
        return clip;
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
    public void binaryElement(int i, int i2, ExtractorInput extractorInput) {
        ((MatroskaExtractor) this.f7833b).binaryElement(i, i2, extractorInput);
    }

    @Override // p000.InterfaceC1849tv
    public ContentInfoCompat build() {
        ContentInfo build;
        build = ((ContentInfo.Builder) this.f7833b).build();
        return new ContentInfoCompat(new b01(build));
    }

    @Override // p000.InterfaceC1849tv
    /* renamed from: c */
    public void mo1986c(int i) {
        ((ContentInfo.Builder) this.f7833b).setSource(i);
    }

    @Override // p000.InterfaceC2005y2
    public void cancel() {
        ((Future) this.f7833b).cancel(false);
    }

    @Override // p000.v00
    /* renamed from: d */
    public int mo1987d() {
        return (mo1991h() << 8) | mo1991h();
    }

    @Override // p000.z80
    public String decrypt(String str, String str2) {
        Entity create = Entity.create(str);
        return new String(((Crypto) this.f7833b).decrypt(Base64.decode(str2, 2), create));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    @Override // com.orhanobut.hawk.Serializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C1704py deserialize(String str) {
        Class<?> cls;
        String str2;
        int indexOf;
        String[] split = str.split("#");
        char charAt = split[2].charAt(0);
        String str3 = split[0];
        LogInterceptor logInterceptor = (LogInterceptor) this.f7833b;
        Class<?> cls2 = null;
        if (str3 != null && str3.length() != 0) {
            try {
                cls = Class.forName(str3);
            } catch (ClassNotFoundException e) {
                logInterceptor.onLog("HawkSerializer -> " + e.getMessage());
            }
            str2 = split[1];
            if (str2 != null && str2.length() != 0) {
                try {
                    cls2 = Class.forName(str2);
                } catch (ClassNotFoundException e2) {
                    logInterceptor.onLog("HawkSerializer -> " + e2.getMessage());
                }
            }
            String str4 = split[split.length - 1];
            indexOf = str4.indexOf(64);
            if (indexOf == -1) {
                return new C1704py(charAt, str4.substring(indexOf + 1), cls, cls2);
            }
            throw new IllegalArgumentException("Text should contain delimiter");
        }
        cls = null;
        str2 = split[1];
        if (str2 != null) {
            cls2 = Class.forName(str2);
        }
        String str42 = split[split.length - 1];
        indexOf = str42.indexOf(64);
        if (indexOf == -1) {
        }
    }

    @Override // p000.InterfaceC1849tv
    /* renamed from: e */
    public void mo1988e(Uri uri) {
        ((ContentInfo.Builder) this.f7833b).setLinkUri(uri);
    }

    @Override // p000.z80
    public String encrypt(String str, String str2) {
        return Base64.encodeToString(((Crypto) this.f7833b).encrypt(str2.getBytes(), Entity.create(str)), 2);
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
    public void endMasterElement(int i) {
        ((MatroskaExtractor) this.f7833b).endMasterElement(i);
    }

    @Override // p000.InterfaceC1849tv
    /* renamed from: f */
    public void mo1989f(ClipData clipData) {
        ((ContentInfo.Builder) this.f7833b).setClip(clipData);
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
    public void floatElement(int i, double d) {
        ((MatroskaExtractor) this.f7833b).floatElement(i, d);
    }

    @Override // com.bumptech.glide.manager.RequestManagerTreeNode
    public Set getDescendants() {
        Set<RequestManagerFragment> m2364a = ((RequestManagerFragment) this.f7833b).m2364a();
        HashSet hashSet = new HashSet(m2364a.size());
        for (RequestManagerFragment requestManagerFragment : m2364a) {
            if (requestManagerFragment.getRequestManager() != null) {
                hashSet.add(requestManagerFragment.getRequestManager());
            }
        }
        return hashSet;
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
    public int getElementType(int i) {
        return ((MatroskaExtractor) this.f7833b).getElementType(i);
    }

    @Override // p000.InterfaceC1923vv
    public Bundle getExtras() {
        Bundle extras;
        extras = ((ContentInfo) this.f7833b).getExtras();
        return extras;
    }

    @Override // p000.InterfaceC1923vv
    public int getFlags() {
        int flags;
        flags = ((ContentInfo) this.f7833b).getFlags();
        return flags;
    }

    @Override // androidx.core.view.DifferentialMotionFlingTarget
    public float getScaledScrollFactor() {
        return -((NestedScrollView) this.f7833b).getVerticalScrollFactorCompat();
    }

    @Override // p000.v00
    /* renamed from: h */
    public short mo1991h() {
        int read = ((InputStream) this.f7833b).read();
        if (read != -1) {
            return (short) read;
        }
        throw new DefaultImageHeaderParser$Reader$EndOfFileException();
    }

    @Override // p000.v00
    /* renamed from: i */
    public int mo1992i(int i, byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i && (i3 = ((InputStream) this.f7833b).read(bArr, i2, i - i2)) != -1) {
            i2 += i3;
        }
        if (i2 == 0 && i3 == -1) {
            throw new DefaultImageHeaderParser$Reader$EndOfFileException();
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
    public void integerElement(int i, long j) {
        ((MatroskaExtractor) this.f7833b).integerElement(i, j);
    }

    @Override // p000.InterfaceC2005y2
    public boolean isCancelled() {
        return ((Future) this.f7833b).isCancelled();
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
    public boolean isLevel1Element(int i) {
        return ((MatroskaExtractor) this.f7833b).isLevel1Element(i);
    }

    @Override // p000.InterfaceC1923vv
    /* renamed from: j */
    public ContentInfo mo1993j() {
        return (ContentInfo) this.f7833b;
    }

    @Override // p000.InterfaceC1923vv
    /* renamed from: l */
    public int mo1995l() {
        int source;
        source = ((ContentInfo) this.f7833b).getSource();
        return source;
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError() {
        DashMediaSource dashMediaSource = (DashMediaSource) this.f7833b;
        dashMediaSource.f11212A.maybeThrowError();
        DashManifestStaleException dashManifestStaleException = dashMediaSource.f11214C;
        if (dashManifestStaleException != null) {
            throw dashManifestStaleException;
        }
    }

    /* renamed from: n */
    public Object m1997n(String str, C1704py c1704py) {
        Class cls;
        char c = c1704py.f25332a;
        Parser parser = (Parser) this.f7833b;
        Class cls2 = c1704py.f25334c;
        switch (c) {
            case '0':
                return parser.fromJson(str, cls2);
            case '1':
                if (cls2 == null) {
                    return new ArrayList();
                }
                List list = (List) parser.fromJson(str, new TypeToken().getType());
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.set(i, parser.fromJson(parser.toJson(list.get(i)), cls2));
                }
                return list;
            case '2':
                HashMap hashMap = new HashMap();
                if (cls2 != null && (cls = c1704py.f25335d) != null) {
                    for (Map.Entry entry : ((Map) parser.fromJson(str, new TypeToken().getType())).entrySet()) {
                        hashMap.put(parser.fromJson(parser.toJson(entry.getKey()), cls2), parser.fromJson(parser.toJson(entry.getValue()), cls));
                    }
                }
                return hashMap;
            case '3':
                HashSet hashSet = new HashSet();
                if (cls2 != null) {
                    Iterator it = ((Set) parser.fromJson(str, new TypeToken().getType())).iterator();
                    while (it.hasNext()) {
                        hashSet.add(parser.fromJson(parser.toJson(it.next()), cls2));
                    }
                }
                return hashSet;
            default:
                return null;
        }
    }

    /* renamed from: o */
    public t40 m1998o() {
        t40 t40Var;
        synchronized (((ArrayDeque) this.f7833b)) {
            t40Var = (t40) ((ArrayDeque) this.f7833b).poll();
        }
        if (t40Var == null) {
            return new t40();
        }
        return t40Var;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        boolean z;
        View view2;
        WindowInsetsCompat windowInsetsCompat2;
        int systemWindowInsetLeft;
        int systemWindowInsetRight;
        boolean z2;
        int color;
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = (LayoutInflaterFactory2C0084e) this.f7833b;
        layoutInflaterFactory2C0084e.getClass();
        int systemWindowInsetTop2 = windowInsetsCompat.getSystemWindowInsetTop();
        ActionBarContextView actionBarContextView = layoutInflaterFactory2C0084e.f732v;
        int i = 0;
        if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutInflaterFactory2C0084e.f732v.getLayoutParams();
            boolean z3 = true;
            if (layoutInflaterFactory2C0084e.f732v.isShown()) {
                if (layoutInflaterFactory2C0084e.f715d0 == null) {
                    layoutInflaterFactory2C0084e.f715d0 = new Rect();
                    layoutInflaterFactory2C0084e.f716e0 = new Rect();
                }
                Rect rect = layoutInflaterFactory2C0084e.f715d0;
                Rect rect2 = layoutInflaterFactory2C0084e.f716e0;
                rect.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                ViewUtils.computeFitSystemWindows(layoutInflaterFactory2C0084e.f687B, rect, rect2);
                int i2 = rect.top;
                int i3 = rect.left;
                int i4 = rect.right;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(layoutInflaterFactory2C0084e.f687B);
                if (rootWindowInsets == null) {
                    systemWindowInsetLeft = 0;
                } else {
                    systemWindowInsetLeft = rootWindowInsets.getSystemWindowInsetLeft();
                }
                if (rootWindowInsets == null) {
                    systemWindowInsetRight = 0;
                } else {
                    systemWindowInsetRight = rootWindowInsets.getSystemWindowInsetRight();
                }
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z2 = true;
                }
                Context context = layoutInflaterFactory2C0084e.f721k;
                if (i2 > 0 && layoutInflaterFactory2C0084e.f689D == null) {
                    View view3 = new View(context);
                    layoutInflaterFactory2C0084e.f689D = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = systemWindowInsetLeft;
                    layoutParams.rightMargin = systemWindowInsetRight;
                    layoutInflaterFactory2C0084e.f687B.addView(layoutInflaterFactory2C0084e.f689D, -1, layoutParams);
                } else {
                    View view4 = layoutInflaterFactory2C0084e.f689D;
                    if (view4 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view4.getLayoutParams();
                        int i5 = marginLayoutParams2.height;
                        int i6 = marginLayoutParams.topMargin;
                        if (i5 != i6 || marginLayoutParams2.leftMargin != systemWindowInsetLeft || marginLayoutParams2.rightMargin != systemWindowInsetRight) {
                            marginLayoutParams2.height = i6;
                            marginLayoutParams2.leftMargin = systemWindowInsetLeft;
                            marginLayoutParams2.rightMargin = systemWindowInsetRight;
                            layoutInflaterFactory2C0084e.f689D.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                View view5 = layoutInflaterFactory2C0084e.f689D;
                if (view5 == null) {
                    z3 = false;
                }
                if (z3 && view5.getVisibility() != 0) {
                    View view6 = layoutInflaterFactory2C0084e.f689D;
                    if ((ViewCompat.getWindowSystemUiVisibility(view6) & 8192) != 0) {
                        color = ContextCompat.getColor(context, R.color.abc_decor_view_status_guard_light);
                    } else {
                        color = ContextCompat.getColor(context, R.color.abc_decor_view_status_guard);
                    }
                    view6.setBackgroundColor(color);
                }
                if (!layoutInflaterFactory2C0084e.f694I && z3) {
                    systemWindowInsetTop2 = 0;
                }
                boolean z4 = z3;
                z3 = z2;
                z = z4;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z3 = false;
            }
            if (z3) {
                layoutInflaterFactory2C0084e.f732v.setLayoutParams(marginLayoutParams);
            }
        } else {
            z = false;
        }
        View view7 = layoutInflaterFactory2C0084e.f689D;
        if (view7 != null) {
            if (!z) {
                i = 8;
            }
            view7.setVisibility(i);
        }
        if (systemWindowInsetTop != systemWindowInsetTop2) {
            windowInsetsCompat2 = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), systemWindowInsetTop2, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            view2 = view;
        } else {
            view2 = view;
            windowInsetsCompat2 = windowInsetsCompat;
        }
        return ViewCompat.onApplyWindowInsets(view2, windowInsetsCompat2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        ((ArrayObjectAdapter) this.f7833b).notifyItemRangeChanged(i, i2, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        ((ArrayObjectAdapter) this.f7833b).notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItem menuItem) {
        ViewOnKeyListenerC0088b viewOnKeyListenerC0088b = (ViewOnKeyListenerC0088b) this.f7833b;
        C1236gl c1236gl = null;
        viewOnKeyListenerC0088b.f969g.removeCallbacksAndMessages(null);
        ArrayList arrayList = viewOnKeyListenerC0088b.f971i;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (menuBuilder == ((C1236gl) arrayList.get(i)).f17747b) {
                    break;
                } else {
                    i++;
                }
            } else {
                i = -1;
                break;
            }
        }
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        if (i2 < arrayList.size()) {
            c1236gl = (C1236gl) arrayList.get(i2);
        }
        viewOnKeyListenerC0088b.f969g.postAtTime(new RunnableC1199fl(0, this, c1236gl, menuItem, menuBuilder), menuBuilder, SystemClock.uptimeMillis() + 200);
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
        ((ViewOnKeyListenerC0088b) this.f7833b).f969g.removeCallbacksAndMessages(menuBuilder);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        ((ArrayObjectAdapter) this.f7833b).notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        ((ArrayObjectAdapter) this.f7833b).notifyItemRangeRemoved(i, i2);
    }

    /* renamed from: p */
    public void m1999p(t40 t40Var) {
        synchronized (((ArrayDeque) this.f7833b)) {
            if (((ArrayDeque) this.f7833b).size() < 10) {
                ((ArrayDeque) this.f7833b).offer(t40Var);
            }
        }
    }

    /* renamed from: q */
    public void m2000q(Object obj) {
        boolean z = obj instanceof List;
        ArrayList arrayList = null;
        MediaBrowserService.Result result = (MediaBrowserService.Result) this.f7833b;
        if (z) {
            List<Parcel> list = (List) obj;
            if (list != null) {
                arrayList = new ArrayList();
                for (Parcel parcel : list) {
                    parcel.setDataPosition(0);
                    arrayList.add((MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                    parcel.recycle();
                }
            }
            result.sendResult(arrayList);
            return;
        }
        if (obj instanceof Parcel) {
            Parcel parcel2 = (Parcel) obj;
            parcel2.setDataPosition(0);
            result.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel2));
            parcel2.recycle();
            return;
        }
        result.sendResult(null);
    }

    /* renamed from: r */
    public void m2001r(Serializable serializable, Object obj) {
        try {
            ((Field) this.f7833b).set(serializable, obj);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.orhanobut.hawk.Serializer
    public String serialize(String str, Object obj) {
        String name;
        char c;
        String str2;
        if (str != null && str.trim().length() != 0) {
            p63.m6871o(obj, "Value");
            String str3 = "";
            if (List.class.isAssignableFrom(obj.getClass())) {
                List list = (List) obj;
                if (list.isEmpty()) {
                    name = "";
                } else {
                    name = list.get(0).getClass().getName();
                }
                c = '1';
            } else if (Map.class.isAssignableFrom(obj.getClass())) {
                Map map = (Map) obj;
                if (!map.isEmpty()) {
                    Iterator it = map.entrySet().iterator();
                    if (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        str3 = entry.getKey().getClass().getName();
                        str2 = entry.getValue().getClass().getName();
                        c = '2';
                        String str4 = str3;
                        str3 = str2;
                        name = str4;
                    }
                }
                str2 = "";
                c = '2';
                String str42 = str3;
                str3 = str2;
                name = str42;
            } else if (Set.class.isAssignableFrom(obj.getClass())) {
                Set set = (Set) obj;
                if (!set.isEmpty()) {
                    Iterator it2 = set.iterator();
                    if (it2.hasNext()) {
                        name = it2.next().getClass().getName();
                        c = '3';
                    }
                }
                name = "";
                c = '3';
            } else {
                name = obj.getClass().getName();
                c = '0';
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append("#");
            sb.append(str3);
            sb.append("#");
            sb.append(c);
            return AbstractC1726qj.m7061q(sb, "V@", str);
        }
        throw new NullPointerException("Cipher text should not be null or empty");
    }

    @Override // p000.InterfaceC1849tv
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.f7833b).setExtras(bundle);
    }

    @Override // p000.InterfaceC1849tv
    public void setFlags(int i) {
        ((ContentInfo.Builder) this.f7833b).setFlags(i);
    }

    @Override // p000.v00
    public long skip(long j) {
        if (j < 0) {
            return 0L;
        }
        long j2 = j;
        while (j2 > 0) {
            InputStream inputStream = (InputStream) this.f7833b;
            long skip = inputStream.skip(j2);
            if (skip > 0) {
                j2 -= skip;
            } else {
                if (inputStream.read() == -1) {
                    break;
                }
                j2--;
            }
        }
        return j - j2;
    }

    @Override // androidx.core.view.DifferentialMotionFlingTarget
    public boolean startDifferentialMotionFling(float f) {
        if (f == RecyclerView.f7068F0) {
            return false;
        }
        stopDifferentialMotionFling();
        ((NestedScrollView) this.f7833b).fling((int) f);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
    public void startMasterElement(int i, long j, long j2) {
        ((MatroskaExtractor) this.f7833b).startMasterElement(i, j, j2);
    }

    @Override // androidx.core.view.DifferentialMotionFlingTarget
    public void stopDifferentialMotionFling() {
        ((NestedScrollView) this.f7833b).f4057d.abortAnimation();
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
    public void stringElement(int i, String str) {
        ((MatroskaExtractor) this.f7833b).stringElement(i, str);
    }

    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(Object obj) {
        return !((BooleanSupplier) this.f7833b).getAsBoolean();
    }

    public String toString() {
        switch (this.f7832a) {
            case 9:
                return "ContentInfoCompat{" + ((ContentInfo) this.f7833b) + "}";
            case 28:
                return super.toString() + "{fragment=" + ((RequestManagerFragment) this.f7833b) + "}";
            default:
                return super.toString();
        }
    }

    public b01(int i) {
        this.f7832a = i;
        switch (i) {
            case 13:
                this.f7833b = new ArrayDeque();
                return;
            case 16:
                this.f7833b = new LinkedHashMap(5, 1.0f, false);
                return;
            default:
                ud3 ud3Var = ud3.f27230c;
                ai2 ai2Var = new ai2(23, new qd3[]{wd0.f28145f, f7831c});
                Charset charset = zzmk.f13887a;
                this.f7833b = ai2Var;
                return;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError(int i) {
        DashMediaSource dashMediaSource = (DashMediaSource) this.f7833b;
        dashMediaSource.f11212A.maybeThrowError(i);
        DashManifestStaleException dashManifestStaleException = dashMediaSource.f11214C;
        if (dashManifestStaleException != null) {
            throw dashManifestStaleException;
        }
    }

    public b01(Context context) {
        this.f7832a = 7;
        this.f7833b = AndroidConceal.get().createDefaultCrypto(new SharedPrefsBackedKeyChain(context, CryptoConfig.KEY_256));
    }

    public b01(Parser parser) {
        this.f7832a = 0;
        if (parser != null) {
            this.f7833b = parser;
            return;
        }
        throw new NullPointerException("Parser should not be null");
    }

    public b01(Matcher matcher) {
        this.f7832a = 21;
        this.f7833b = (Matcher) Preconditions.checkNotNull(matcher);
    }

    public b01(Field field) {
        this.f7832a = 29;
        this.f7833b = field;
        field.setAccessible(true);
    }

    public b01(ContentInfo contentInfo) {
        this.f7832a = 9;
        this.f7833b = AbstractC1267hf.m5074o(androidx.core.util.Preconditions.checkNotNull(contentInfo));
    }

    public b01(ClipData clipData, int i) {
        this.f7832a = 8;
        this.f7833b = AbstractC1267hf.m5071l(clipData, i);
    }

    public b01(ContentInfoCompat contentInfoCompat) {
        this.f7832a = 8;
        AbstractC1267hf.m5077r();
        this.f7833b = AbstractC1267hf.m5072m(contentInfoCompat.toContentInfo());
    }

    @Override // p000.InterfaceC1188fa
    /* renamed from: g */
    public void mo1990g(int i) {
    }

    @Override // p000.InterfaceC1188fa
    /* renamed from: k */
    public void mo1994k(int i) {
    }

    @Override // p000.InterfaceC1188fa
    /* renamed from: m */
    public void mo1996m(int i, float f) {
    }
}
