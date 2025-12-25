package p000;

import android.content.ContentResolver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.C0264s;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.C0468e;
import androidx.recyclerview.widget.ThreadUtil$MainThreadCallback;
import androidx.recyclerview.widget.TileList$Tile;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class mt2 implements ThreadUtil$MainThreadCallback {

    /* renamed from: a */
    public final /* synthetic */ int f23106a;

    /* renamed from: b */
    public final Object f23107b;

    /* renamed from: c */
    public final Object f23108c;

    /* renamed from: d */
    public Object f23109d;

    /* renamed from: e */
    public Object f23110e;

    public mt2(C0468e c0468e) {
        this.f23106a = 2;
        this.f23110e = c0468e;
        this.f23107b = new C1540m9(18);
        this.f23108c = new Handler(Looper.getMainLooper());
        this.f23109d = new RunnableC1104d(29, this);
    }

    /* renamed from: a */
    public void m6249a(Fragment fragment) {
        if (!((ArrayList) this.f23107b).contains(fragment)) {
            synchronized (((ArrayList) this.f23107b)) {
                ((ArrayList) this.f23107b).add(fragment);
            }
            fragment.f4458l = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public void addTile(int i, TileList$Tile tileList$Tile) {
        ((C1540m9) this.f23107b).m6108r(un1.m7757b(2, i, 0, 0, 0, 0, tileList$Tile));
        ((Handler) this.f23108c).post((RunnableC1104d) this.f23109d);
    }

    /* renamed from: b */
    public Fragment m6250b(String str) {
        C0264s c0264s = (C0264s) ((HashMap) this.f23108c).get(str);
        if (c0264s != null) {
            return c0264s.f4692c;
        }
        return null;
    }

    /* renamed from: c */
    public Fragment m6251c(String str) {
        for (C0264s c0264s : ((HashMap) this.f23108c).values()) {
            if (c0264s != null) {
                Fragment fragment = c0264s.f4692c;
                if (!str.equals(fragment.f4452f)) {
                    fragment = fragment.f4470x.f4517c.m6251c(str);
                }
                if (fragment != null) {
                    return fragment;
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    public ArrayList m6252d() {
        ArrayList arrayList = new ArrayList();
        for (C0264s c0264s : ((HashMap) this.f23108c).values()) {
            if (c0264s != null) {
                arrayList.add(c0264s);
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public ArrayList m6253e() {
        ArrayList arrayList = new ArrayList();
        for (C0264s c0264s : ((HashMap) this.f23108c).values()) {
            if (c0264s != null) {
                arrayList.add(c0264s.f4692c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public List m6254f() {
        ArrayList arrayList;
        if (((ArrayList) this.f23107b).isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (((ArrayList) this.f23107b)) {
            arrayList = new ArrayList((ArrayList) this.f23107b);
        }
        return arrayList;
    }

    /* renamed from: g */
    public void m6255g(C0264s c0264s) {
        Fragment fragment = c0264s.f4692c;
        String str = fragment.f4452f;
        HashMap hashMap = (HashMap) this.f23108c;
        if (hashMap.get(str) != null) {
            return;
        }
        hashMap.put(fragment.f4452f, c0264s);
        if (fragment.f4423F) {
            if (fragment.f4422E) {
                ((du0) this.f23110e).m4613c(fragment);
            } else {
                ((du0) this.f23110e).m4618h(fragment);
            }
            fragment.f4423F = false;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Added fragment to active set " + fragment);
        }
    }

    /* renamed from: h */
    public void m6256h(C0264s c0264s) {
        Fragment fragment = c0264s.f4692c;
        if (fragment.f4422E) {
            ((du0) this.f23110e).m4618h(fragment);
        }
        HashMap hashMap = (HashMap) this.f23108c;
        if (hashMap.get(fragment.f4452f) == c0264s && ((C0264s) hashMap.put(fragment.f4452f, null)) != null && FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Removed fragment from active set " + fragment);
        }
    }

    /* renamed from: i */
    public Bundle m6257i(String str, Bundle bundle) {
        HashMap hashMap = (HashMap) this.f23109d;
        if (bundle != null) {
            return (Bundle) hashMap.put(str, bundle);
        }
        return (Bundle) hashMap.remove(str);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public void removeTile(int i, int i2) {
        ((C1540m9) this.f23107b).m6108r(un1.m7757b(3, i, i2, 0, 0, 0, null));
        ((Handler) this.f23108c).post((RunnableC1104d) this.f23109d);
    }

    public String toString() {
        switch (this.f23106a) {
            case 3:
                return "horizontal=" + ((m53) this.f23108c) + "; vertical=" + ((m53) this.f23107b);
            default:
                return super.toString();
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public void updateItemCount(int i, int i2) {
        ((C1540m9) this.f23107b).m6108r(un1.m7757b(1, i, i2, 0, 0, 0, null));
        ((Handler) this.f23108c).post((RunnableC1104d) this.f23109d);
    }

    public mt2(int i) {
        this.f23106a = i;
        switch (i) {
            case 3:
                m53 m53Var = new m53();
                this.f23107b = m53Var;
                m53 m53Var2 = new m53();
                this.f23108c = m53Var2;
                this.f23109d = m53Var2;
                this.f23110e = m53Var;
                return;
            default:
                this.f23107b = new ArrayList();
                this.f23108c = new HashMap();
                this.f23109d = new HashMap();
                return;
        }
    }

    public mt2(List list, lt2 lt2Var, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.f23106a = 0;
        this.f23107b = lt2Var;
        this.f23108c = arrayPool;
        this.f23109d = contentResolver;
        this.f23110e = list;
    }
}
