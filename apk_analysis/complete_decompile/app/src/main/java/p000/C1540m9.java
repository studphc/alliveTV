package p000;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Binder;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.collection.LongSparseArray;
import androidx.constraintlayout.core.SolverVariable;
import androidx.core.app.BundleCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media.MediaBrowserProtocol;
import androidx.recyclerview.widget.C0487k0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage$IsolatedStableIdStorage;
import androidx.recyclerview.widget.StableIdStorage$StableIdLookup;
import androidx.recyclerview.widget.ViewTypeStorage$SharedIdRangeViewTypeStorage;
import androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.util.Preconditions;
import com.facebook.crypto.CryptoConfig;
import com.facebook.crypto.keychain.KeyChain;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.drm.C0660b;
import com.google.android.exoplayer2.drm.DefaultDrmSession$ProvisioningManager;
import com.google.android.exoplayer2.drm.HandlerC0659a;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory$ExtensionLoader$ConstructorSupplier;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.common.api.internal.zaad;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Function;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: m9 */
/* loaded from: classes.dex */
public class C1540m9 implements KeyChain, InterfaceC1250gz, DefaultDrmSession$ProvisioningManager, FidListenerHandle, BiConsumer, StableIdStorage$StableIdLookup, OnApplyWindowInsetsListener, ViewTypeStorage$ViewTypeLookup, OnCompleteListener {

    /* renamed from: d */
    public static final int[] f22851d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: e */
    public static final String[] f22852e = {AppMeasurementSdk.ConditionalUserProperty.NAME, "length", "last_touch_timestamp"};

    /* renamed from: a */
    public final /* synthetic */ int f22853a;

    /* renamed from: b */
    public Object f22854b;

    /* renamed from: c */
    public Object f22855c;

    public /* synthetic */ C1540m9(int i, Object obj) {
        this.f22853a = i;
        this.f22854b = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C1540m9 m6091a(Context context) {
        FileChannel fileChannel;
        FileLock fileLock;
        try {
            fileChannel = new RandomAccessFile(new File(context.getFilesDir(), "generatefid.lock"), "rw").getChannel();
            try {
                fileLock = fileChannel.lock();
            } catch (IOException | Error | OverlappingFileLockException e) {
                e = e;
                fileLock = null;
            }
            try {
                return new C1540m9(4, fileChannel, fileLock);
            } catch (IOException e2) {
                e = e2;
                Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException unused) {
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused2) {
                    }
                }
                return null;
            } catch (Error e3) {
                e = e3;
                Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                if (fileLock != null) {
                }
                if (fileChannel != null) {
                }
                return null;
            } catch (OverlappingFileLockException e4) {
                e = e4;
                Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                if (fileLock != null) {
                }
                if (fileChannel != null) {
                }
                return null;
            }
        } catch (IOException | Error | OverlappingFileLockException e5) {
            e = e5;
            fileChannel = null;
            fileLock = null;
        }
    }

    /* renamed from: b */
    public static void m6092b(String str, int i, byte[] bArr) {
        if (bArr.length == i) {
            return;
        }
        throw new IllegalStateException(str + " should be " + i + " bytes long but is " + bArr.length);
    }

    @Override // io.reactivex.rxjava3.functions.BiConsumer
    public void accept(Object obj, Object obj2) {
        ((Map) obj).put(((Function) this.f22855c).apply(obj2), ((Function) this.f22854b).apply(obj2));
    }

    /* renamed from: c */
    public View m6093c(int i, int i2, int i3, int i4) {
        int i5;
        q23 q23Var = (q23) this.f22854b;
        int mo1901b = q23Var.mo1901b();
        int mo1902c = q23Var.mo1902c();
        if (i2 > i) {
            i5 = 1;
        } else {
            i5 = -1;
        }
        View view = null;
        while (i != i2) {
            View mo1903d = q23Var.mo1903d(i);
            int mo1900a = q23Var.mo1900a(mo1903d);
            int mo1904e = q23Var.mo1904e(mo1903d);
            p23 p23Var = (p23) this.f22855c;
            p23Var.f25016b = mo1901b;
            p23Var.f25017c = mo1902c;
            p23Var.f25018d = mo1900a;
            p23Var.f25019e = mo1904e;
            if (i3 != 0) {
                p23Var.f25015a = i3;
                if (p23Var.m6799a()) {
                    return mo1903d;
                }
            }
            if (i4 != 0) {
                p23Var.f25015a = i4;
                if (p23Var.m6799a()) {
                    view = mo1903d;
                }
            }
            i += i5;
        }
        return view;
    }

    /* renamed from: d */
    public Object m6094d(n62 n62Var) {
        int i;
        HashMap hashMap = (HashMap) this.f22855c;
        ay0 ay0Var = (ay0) hashMap.get(n62Var);
        if (ay0Var == null) {
            ay0Var = new ay0(n62Var);
            hashMap.put(n62Var, ay0Var);
        } else {
            n62Var.mo5522a();
        }
        ay0 ay0Var2 = ay0Var.f7793d;
        ay0Var2.f7792c = ay0Var.f7792c;
        ay0Var.f7792c.f7793d = ay0Var2;
        ay0 ay0Var3 = (ay0) this.f22854b;
        ay0Var.f7793d = ay0Var3;
        ay0 ay0Var4 = ay0Var3.f7792c;
        ay0Var.f7792c = ay0Var4;
        ay0Var4.f7793d = ay0Var;
        ay0Var.f7793d.f7792c = ay0Var;
        ArrayList arrayList = ay0Var.f7791b;
        if (arrayList != null) {
            i = arrayList.size();
        } else {
            i = 0;
        }
        if (i > 0) {
            return ay0Var.f7791b.remove(i - 1);
        }
        return null;
    }

    @Override // com.facebook.crypto.keychain.KeyChain
    public void destroyKeys() {
        ((KeyChain) this.f22854b).destroyKeys();
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
    public void dispose() {
        SparseArray sparseArray = ((ViewTypeStorage$SharedIdRangeViewTypeStorage) this.f22855c).f7312a;
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            List list = (List) sparseArray.valueAt(size);
            if (list.remove((C0487k0) this.f22854b) && list.isEmpty()) {
                sparseArray.removeAt(size);
            }
        }
    }

    /* renamed from: e */
    public HashMap m6095e() {
        try {
            Assertions.checkNotNull((String) this.f22855c);
            Cursor query = ((DatabaseProvider) this.f22854b).getReadableDatabase().query((String) this.f22855c, f22852e, null, null, null, null, null);
            try {
                HashMap hashMap = new HashMap(query.getCount());
                while (query.moveToNext()) {
                    hashMap.put((String) Assertions.checkNotNull(query.getString(0)), new C1198fk(query.getLong(1), query.getLong(2)));
                }
                query.close();
                return hashMap;
            } finally {
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    /* renamed from: f */
    public Extractor m6096f(Object... objArr) {
        Constructor<? extends Extractor> constructor;
        synchronized (((AtomicBoolean) this.f22855c)) {
            if (!((AtomicBoolean) this.f22855c).get()) {
                try {
                    constructor = ((DefaultExtractorsFactory$ExtensionLoader$ConstructorSupplier) this.f22854b).getConstructor();
                } catch (ClassNotFoundException unused) {
                    ((AtomicBoolean) this.f22855c).set(true);
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating extension", e);
                }
            }
            constructor = null;
        }
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e2) {
            throw new IllegalStateException("Unexpected error creating extractor", e2);
        }
    }

    /* renamed from: g */
    public void m6097g(long j) {
        DatabaseProvider databaseProvider = (DatabaseProvider) this.f22854b;
        try {
            String hexString = Long.toHexString(j);
            this.f22855c = "ExoPlayerCacheFileMetadata" + hexString;
            if (VersionTable.getVersion(databaseProvider.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    VersionTable.setVersion(writableDatabase, 2, hexString, 1);
                    writableDatabase.execSQL("DROP TABLE IF EXISTS " + ((String) this.f22855c));
                    writableDatabase.execSQL("CREATE TABLE " + ((String) this.f22855c) + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @Override // com.facebook.crypto.keychain.KeyChain
    public byte[] getCipherKey() {
        byte[] cipherKey = ((KeyChain) this.f22854b).getCipherKey();
        m6092b("Key", ((CryptoConfig) this.f22855c).keyLength, cipherKey);
        return cipherKey;
    }

    @Override // com.facebook.crypto.keychain.KeyChain
    public byte[] getMacKey() {
        byte[] macKey = ((KeyChain) this.f22854b).getMacKey();
        m6092b("Mac", 64, macKey);
        return macKey;
    }

    @Override // com.facebook.crypto.keychain.KeyChain
    public byte[] getNewIV() {
        byte[] newIV = ((KeyChain) this.f22854b).getNewIV();
        m6092b("IV", ((CryptoConfig) this.f22855c).ivLength, newIV);
        return newIV;
    }

    /* renamed from: h */
    public boolean m6098h(View view) {
        q23 q23Var = (q23) this.f22854b;
        int mo1901b = q23Var.mo1901b();
        int mo1902c = q23Var.mo1902c();
        int mo1900a = q23Var.mo1900a(view);
        int mo1904e = q23Var.mo1904e(view);
        p23 p23Var = (p23) this.f22855c;
        p23Var.f25016b = mo1901b;
        p23Var.f25017c = mo1902c;
        p23Var.f25018d = mo1900a;
        p23Var.f25019e = mo1904e;
        p23Var.f25015a = 24579;
        return p23Var.m6799a();
    }

    /* renamed from: i */
    public void mo6099i(AttributeSet attributeSet, int i) {
        AbsSeekBar absSeekBar = (AbsSeekBar) this.f22854b;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(absSeekBar.getContext(), attributeSet, f22851d, i, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            if (drawableIfKnown instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) drawableIfKnown;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i2 = 0; i2 < numberOfFrames; i2++) {
                    Drawable m6111u = m6111u(animationDrawable.getFrame(i2), true);
                    m6111u.setLevel(10000);
                    animationDrawable2.addFrame(m6111u, animationDrawable.getDuration(i2));
                }
                animationDrawable2.setLevel(10000);
                drawableIfKnown = animationDrawable2;
            }
            absSeekBar.setIndeterminateDrawable(drawableIfKnown);
        }
        Drawable drawableIfKnown2 = obtainStyledAttributes.getDrawableIfKnown(1);
        if (drawableIfKnown2 != null) {
            absSeekBar.setProgressDrawable(m6111u(drawableIfKnown2, false));
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: j */
    public un1 m6100j() {
        synchronized (this.f22855c) {
            try {
                un1 un1Var = (un1) this.f22854b;
                if (un1Var == null) {
                    return null;
                }
                this.f22854b = (un1) un1Var.f27392g;
                return un1Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: k */
    public void m6101k(n62 n62Var, Object obj) {
        HashMap hashMap = (HashMap) this.f22855c;
        ay0 ay0Var = (ay0) hashMap.get(n62Var);
        if (ay0Var == null) {
            ay0Var = new ay0(n62Var);
            ay0Var.f7793d = ay0Var;
            ay0 ay0Var2 = (ay0) this.f22854b;
            ay0Var.f7793d = ay0Var2.f7793d;
            ay0Var.f7792c = ay0Var2;
            ay0Var2.f7793d = ay0Var;
            ay0Var.f7793d.f7792c = ay0Var;
            hashMap.put(n62Var, ay0Var);
        } else {
            n62Var.mo5522a();
        }
        if (ay0Var.f7791b == null) {
            ay0Var.f7791b = new ArrayList();
        }
        ay0Var.f7791b.add(obj);
    }

    /* renamed from: l */
    public void m6102l(String str) {
        t40 t40Var;
        synchronized (this) {
            try {
                t40Var = (t40) Preconditions.checkNotNull(((HashMap) this.f22854b).get(str));
                int i = t40Var.f26689b;
                if (i >= 1) {
                    int i2 = i - 1;
                    t40Var.f26689b = i2;
                    if (i2 == 0) {
                        t40 t40Var2 = (t40) ((HashMap) this.f22854b).remove(str);
                        if (t40Var2.equals(t40Var)) {
                            ((b01) this.f22855c).m1999p(t40Var2);
                        } else {
                            throw new IllegalStateException("Removed the wrong lock, expected to remove: " + t40Var + ", but actually removed: " + t40Var2 + ", safeKey: " + str);
                        }
                    }
                } else {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + t40Var.f26689b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        t40Var.f26688a.unlock();
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
    public int localToGlobal(int i) {
        ViewTypeStorage$SharedIdRangeViewTypeStorage viewTypeStorage$SharedIdRangeViewTypeStorage = (ViewTypeStorage$SharedIdRangeViewTypeStorage) this.f22855c;
        List list = (List) viewTypeStorage$SharedIdRangeViewTypeStorage.f7312a.get(i);
        if (list == null) {
            list = new ArrayList();
            viewTypeStorage$SharedIdRangeViewTypeStorage.f7312a.put(i, list);
        }
        C0487k0 c0487k0 = (C0487k0) this.f22854b;
        if (!list.contains(c0487k0)) {
            list.add(c0487k0);
        }
        return i;
    }

    /* renamed from: m */
    public void m6103m() {
        try {
            ((FileLock) this.f22855c).release();
            ((FileChannel) this.f22854b).close();
        } catch (IOException e) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e);
        }
    }

    /* renamed from: n */
    public void m6104n(Set set) {
        Assertions.checkNotNull((String) this.f22855c);
        try {
            SQLiteDatabase writableDatabase = ((DatabaseProvider) this.f22854b).getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete((String) this.f22855c, "name = ?", new String[]{(String) it.next()});
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    /* renamed from: o */
    public Object m6105o() {
        int i;
        ay0 ay0Var = (ay0) this.f22854b;
        ay0 ay0Var2 = ay0Var.f7793d;
        while (true) {
            Object obj = null;
            if (ay0Var2.equals(ay0Var)) {
                return null;
            }
            ArrayList arrayList = ay0Var2.f7791b;
            if (arrayList != null) {
                i = arrayList.size();
            } else {
                i = 0;
            }
            if (i > 0) {
                obj = ay0Var2.f7791b.remove(i - 1);
            }
            if (obj != null) {
                return obj;
            }
            ay0 ay0Var3 = ay0Var2.f7793d;
            ay0Var3.f7792c = ay0Var2.f7792c;
            ay0Var2.f7792c.f7793d = ay0Var3;
            HashMap hashMap = (HashMap) this.f22855c;
            n62 n62Var = ay0Var2.f7790a;
            hashMap.remove(n62Var);
            n62Var.mo5522a();
            ay0Var2 = ay0Var2.f7793d;
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        if (onApplyWindowInsets.isConsumed()) {
            return onApplyWindowInsets;
        }
        int systemWindowInsetLeft = onApplyWindowInsets.getSystemWindowInsetLeft();
        Rect rect = (Rect) this.f22854b;
        rect.left = systemWindowInsetLeft;
        rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
        rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
        rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
        ViewPager viewPager = (ViewPager) this.f22855c;
        int childCount = viewPager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(viewPager.getChildAt(i), onApplyWindowInsets);
            rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
            rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
            rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
            rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
        }
        return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        ((zaad) this.f22855c).f13189b.remove((TaskCompletionSource) this.f22854b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession$ProvisioningManager
    public void onProvisionCompleted() {
        this.f22855c = null;
        HashSet hashSet = (HashSet) this.f22854b;
        ImmutableList copyOf = ImmutableList.copyOf((Collection) hashSet);
        hashSet.clear();
        UnmodifiableIterator it = copyOf.iterator();
        while (it.hasNext()) {
            C0660b c0660b = (C0660b) it.next();
            if (c0660b.m2526e()) {
                c0660b.m2522a(true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession$ProvisioningManager
    public void onProvisionError(Exception exc, boolean z) {
        int i;
        this.f22855c = null;
        HashSet hashSet = (HashSet) this.f22854b;
        ImmutableList copyOf = ImmutableList.copyOf((Collection) hashSet);
        hashSet.clear();
        UnmodifiableIterator it = copyOf.iterator();
        while (it.hasNext()) {
            C0660b c0660b = (C0660b) it.next();
            c0660b.getClass();
            if (z) {
                i = 1;
            } else {
                i = 3;
            }
            c0660b.m2524c(i, exc);
        }
    }

    /* renamed from: p */
    public void m6106p(int i) {
        un1 un1Var;
        synchronized (this.f22855c) {
            while (true) {
                try {
                    un1Var = (un1) this.f22854b;
                    if (un1Var == null || un1Var.f27386a != i) {
                        break;
                    }
                    this.f22854b = (un1) un1Var.f27392g;
                    un1Var.m7758c();
                } finally {
                }
            }
            if (un1Var != null) {
                un1 un1Var2 = (un1) un1Var.f27392g;
                while (un1Var2 != null) {
                    un1 un1Var3 = (un1) un1Var2.f27392g;
                    if (un1Var2.f27386a == i) {
                        un1Var.f27392g = un1Var3;
                        un1Var2.m7758c();
                    } else {
                        un1Var = un1Var2;
                    }
                    un1Var2 = un1Var3;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession$ProvisioningManager
    public void provisionRequired(C0660b c0660b) {
        ((HashSet) this.f22854b).add(c0660b);
        if (((C0660b) this.f22855c) != null) {
            return;
        }
        this.f22855c = c0660b;
        c0660b.f10026x = c0660b.f10004b.getProvisionRequest();
        HandlerC0659a handlerC0659a = (HandlerC0659a) Util.castNonNull(c0660b.f10020r);
        Object checkNotNull = Assertions.checkNotNull(c0660b.f10026x);
        handlerC0659a.getClass();
        handlerC0659a.obtainMessage(0, new m00(LoadEventInfo.getNewId(), true, SystemClock.elapsedRealtime(), checkNotNull)).sendToTarget();
    }

    /* renamed from: q */
    public void m6107q(String str, Binder binder, Messenger messenger) {
        Bundle bundle = new Bundle();
        bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
        BundleCompat.putBinder(bundle, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, binder);
        m6109s(4, bundle, messenger);
    }

    /* renamed from: r */
    public void m6108r(un1 un1Var) {
        synchronized (this.f22855c) {
            try {
                un1 un1Var2 = (un1) this.f22854b;
                if (un1Var2 == null) {
                    this.f22854b = un1Var;
                    return;
                }
                while (true) {
                    un1 un1Var3 = (un1) un1Var2.f27392g;
                    if (un1Var3 != null) {
                        un1Var2 = un1Var3;
                    } else {
                        un1Var2.f27392g = un1Var;
                        return;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: s */
    public void m6109s(int i, Bundle bundle, Messenger messenger) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = 1;
        obtain.setData(bundle);
        obtain.replyTo = messenger;
        ((Messenger) this.f22854b).send(obtain);
    }

    /* renamed from: t */
    public void m6110t(String str, long j, long j2) {
        Assertions.checkNotNull((String) this.f22855c);
        try {
            SQLiteDatabase writableDatabase = ((DatabaseProvider) this.f22854b).getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
            contentValues.put("length", Long.valueOf(j));
            contentValues.put("last_touch_timestamp", Long.valueOf(j2));
            writableDatabase.replaceOrThrow((String) this.f22855c, null, contentValues);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public String toString() {
        int i;
        switch (this.f22853a) {
            case 14:
                StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
                ay0 ay0Var = (ay0) this.f22854b;
                ay0 ay0Var2 = ay0Var.f7792c;
                boolean z = false;
                while (!ay0Var2.equals(ay0Var)) {
                    sb.append('{');
                    sb.append(ay0Var2.f7790a);
                    sb.append(':');
                    ArrayList arrayList = ay0Var2.f7791b;
                    if (arrayList != null) {
                        i = arrayList.size();
                    } else {
                        i = 0;
                    }
                    sb.append(i);
                    sb.append("}, ");
                    ay0Var2 = ay0Var2.f7792c;
                    z = true;
                }
                if (z) {
                    sb.delete(sb.length() - 2, sb.length());
                }
                sb.append(" )");
                return sb.toString();
            case 19:
                String str = "[ ";
                if (((SolverVariable) this.f22854b) != null) {
                    for (int i2 = 0; i2 < 9; i2++) {
                        StringBuilder m7064t = AbstractC1726qj.m7064t(str);
                        m7064t.append(((SolverVariable) this.f22854b).f1857d[i2]);
                        m7064t.append(" ");
                        str = m7064t.toString();
                    }
                }
                StringBuilder m8303w = ye0.m8303w(str, "] ");
                m8303w.append((SolverVariable) this.f22854b);
                return m8303w.toString();
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: u */
    public Drawable m6111u(Drawable drawable, boolean z) {
        boolean z2;
        if (drawable instanceof WrappedDrawable) {
            WrappedDrawable wrappedDrawable = (WrappedDrawable) drawable;
            Drawable wrappedDrawable2 = wrappedDrawable.getWrappedDrawable();
            if (wrappedDrawable2 != null) {
                wrappedDrawable.setWrappedDrawable(m6111u(wrappedDrawable2, z));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id = layerDrawable.getId(i);
                    Drawable drawable2 = layerDrawable.getDrawable(i);
                    if (id != 16908301 && id != 16908303) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    drawableArr[i] = m6111u(drawable2, z2);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                    layerDrawable2.setLayerGravity(i2, layerDrawable.getLayerGravity(i2));
                    layerDrawable2.setLayerWidth(i2, layerDrawable.getLayerWidth(i2));
                    layerDrawable2.setLayerHeight(i2, layerDrawable.getLayerHeight(i2));
                    layerDrawable2.setLayerInsetLeft(i2, layerDrawable.getLayerInsetLeft(i2));
                    layerDrawable2.setLayerInsetRight(i2, layerDrawable.getLayerInsetRight(i2));
                    layerDrawable2.setLayerInsetTop(i2, layerDrawable.getLayerInsetTop(i2));
                    layerDrawable2.setLayerInsetBottom(i2, layerDrawable.getLayerInsetBottom(i2));
                    layerDrawable2.setLayerInsetStart(i2, layerDrawable.getLayerInsetStart(i2));
                    layerDrawable2.setLayerInsetEnd(i2, layerDrawable.getLayerInsetEnd(i2));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (((Bitmap) this.f22855c) == null) {
                    this.f22855c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                if (z) {
                    return new ClipDrawable(shapeDrawable, 3, 1);
                }
                return shapeDrawable;
            }
        }
        return drawable;
    }

    @Override // com.google.firebase.installations.internal.FidListenerHandle
    public void unregister() {
        synchronized (((FirebaseInstallations) this.f22855c)) {
            ((FirebaseInstallations) this.f22855c).f15578k.remove((FidListener) this.f22854b);
        }
    }

    public /* synthetic */ C1540m9(int i, Object obj, Object obj2) {
        this.f22853a = i;
        this.f22854b = obj;
        this.f22855c = obj2;
    }

    public /* synthetic */ C1540m9(int i, Object obj, Object obj2, boolean z) {
        this.f22853a = i;
        this.f22855c = obj;
        this.f22854b = obj2;
    }

    public /* synthetic */ C1540m9(int i, boolean z) {
        this.f22853a = i;
    }

    public /* synthetic */ C1540m9(Object obj, int i, boolean z) {
        this.f22853a = i;
        this.f22855c = obj;
    }

    public C1540m9(TextView textView) {
        this.f22853a = 2;
        this.f22854b = (TextView) androidx.core.util.Preconditions.checkNotNull(textView);
    }

    @Override // androidx.recyclerview.widget.StableIdStorage$StableIdLookup
    public long localToGlobal(long j) {
        LongSparseArray longSparseArray = (LongSparseArray) this.f22854b;
        Long l = (Long) longSparseArray.get(j);
        if (l == null) {
            StableIdStorage$IsolatedStableIdStorage stableIdStorage$IsolatedStableIdStorage = (StableIdStorage$IsolatedStableIdStorage) this.f22855c;
            long j2 = stableIdStorage$IsolatedStableIdStorage.f7266a;
            stableIdStorage$IsolatedStableIdStorage.f7266a = 1 + j2;
            l = Long.valueOf(j2);
            longSparseArray.put(j, l);
        }
        return l.longValue();
    }

    public C1540m9(StableIdStorage$IsolatedStableIdStorage stableIdStorage$IsolatedStableIdStorage) {
        this.f22853a = 22;
        this.f22855c = stableIdStorage$IsolatedStableIdStorage;
        this.f22854b = new LongSparseArray();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [p23, java.lang.Object] */
    public C1540m9(q23 q23Var) {
        this.f22853a = 24;
        this.f22854b = q23Var;
        ?? obj = new Object();
        obj.f25015a = 0;
        this.f22855c = obj;
    }

    public C1540m9(Animation animation) {
        this.f22853a = 11;
        this.f22854b = animation;
        this.f22855c = null;
    }

    public C1540m9(Animator animator) {
        this.f22853a = 11;
        this.f22854b = null;
        AnimatorSet animatorSet = new AnimatorSet();
        this.f22855c = animatorSet;
        animatorSet.play(animator);
    }

    public C1540m9(ArrayList arrayList, ArrayList arrayList2) {
        this.f22853a = 13;
        int size = arrayList.size();
        this.f22854b = new int[size];
        this.f22855c = new float[size];
        for (int i = 0; i < size; i++) {
            ((int[]) this.f22854b)[i] = ((Integer) arrayList.get(i)).intValue();
            ((float[]) this.f22855c)[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
    public int globalToLocal(int i) {
        return i;
    }

    public C1540m9(int i, int i2) {
        this.f22853a = 13;
        this.f22854b = new int[]{i, i2};
        this.f22855c = new float[]{RecyclerView.f7068F0, 1.0f};
    }

    public C1540m9(int i, int i2, int i3) {
        this.f22853a = 13;
        this.f22854b = new int[]{i, i2, i3};
        this.f22855c = new float[]{RecyclerView.f7068F0, 0.5f, 1.0f};
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [android.text.Editable$Factory, b80] */
    public C1540m9(EditText editText, boolean z) {
        this.f22853a = 9;
        this.f22854b = editText;
        n80 n80Var = new n80(editText, z);
        this.f22855c = n80Var;
        editText.addTextChangedListener(n80Var);
        if (b80.f7920b == null) {
            synchronized (b80.f7919a) {
                try {
                    if (b80.f7920b == null) {
                        ?? factory = new Editable.Factory();
                        try {
                            b80.f7921c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b80.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        b80.f7920b = factory;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(b80.f7920b);
    }

    public C1540m9(ViewPager viewPager) {
        this.f22853a = 25;
        this.f22855c = viewPager;
        this.f22854b = new Rect();
    }

    public C1540m9(DefaultExtractorsFactory$ExtensionLoader$ConstructorSupplier defaultExtractorsFactory$ExtensionLoader$ConstructorSupplier) {
        this.f22853a = 7;
        this.f22854b = defaultExtractorsFactory$ExtensionLoader$ConstructorSupplier;
        this.f22855c = new AtomicBoolean(false);
    }

    public C1540m9(int i) {
        this.f22853a = i;
        switch (i) {
            case 8:
                this.f22854b = new HashMap();
                this.f22855c = new b01(13);
                return;
            case 14:
                this.f22854b = new ay0(null);
                this.f22855c = new HashMap();
                return;
            case 15:
                this.f22854b = new HashMap();
                this.f22855c = new HashMap();
                return;
            case 18:
                this.f22855c = new Object();
                return;
            default:
                this.f22854b = new HashSet();
                return;
        }
    }
}
