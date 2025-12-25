package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import p000.C1540m9;
import p000.HandlerC1714q7;
import p000.ab1;

/* loaded from: classes.dex */
public final class LocalBroadcastManager {

    /* renamed from: f */
    public static final Object f6637f = new Object();

    /* renamed from: g */
    public static LocalBroadcastManager f6638g;

    /* renamed from: a */
    public final Context f6639a;

    /* renamed from: b */
    public final HashMap f6640b = new HashMap();

    /* renamed from: c */
    public final HashMap f6641c = new HashMap();

    /* renamed from: d */
    public final ArrayList f6642d = new ArrayList();

    /* renamed from: e */
    public final HandlerC1714q7 f6643e;

    public LocalBroadcastManager(Context context) {
        this.f6639a = context;
        this.f6643e = new HandlerC1714q7(this, context.getMainLooper(), 2);
    }

    @NonNull
    public static LocalBroadcastManager getInstance(@NonNull Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (f6637f) {
            try {
                if (f6638g == null) {
                    f6638g = new LocalBroadcastManager(context.getApplicationContext());
                }
                localBroadcastManager = f6638g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return localBroadcastManager;
    }

    /* renamed from: a */
    public final void m1547a() {
        int size;
        C1540m9[] c1540m9Arr;
        while (true) {
            synchronized (this.f6640b) {
                try {
                    size = this.f6642d.size();
                    if (size <= 0) {
                        return;
                    }
                    c1540m9Arr = new C1540m9[size];
                    this.f6642d.toArray(c1540m9Arr);
                    this.f6642d.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i = 0; i < size; i++) {
                C1540m9 c1540m9 = c1540m9Arr[i];
                int size2 = ((ArrayList) c1540m9.f22855c).size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ab1 ab1Var = (ab1) ((ArrayList) c1540m9.f22855c).get(i2);
                    if (!ab1Var.f109d) {
                        ab1Var.f107b.onReceive(this.f6639a, (Intent) c1540m9.f22854b);
                    }
                }
            }
        }
    }

    public void registerReceiver(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.f6640b) {
            try {
                ab1 ab1Var = new ab1(broadcastReceiver, intentFilter);
                ArrayList arrayList = (ArrayList) this.f6640b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f6640b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(ab1Var);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList arrayList2 = (ArrayList) this.f6641c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f6641c.put(action, arrayList2);
                    }
                    arrayList2.add(ab1Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean sendBroadcast(@NonNull Intent intent) {
        Object[] objArr;
        ArrayList arrayList;
        int i;
        String str;
        boolean z;
        String str2;
        synchronized (this.f6640b) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f6639a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z2 = true;
                boolean z3 = false;
                if ((intent.getFlags() & 8) != 0) {
                    objArr = true;
                } else {
                    objArr = false;
                }
                if (objArr != false) {
                    Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList2 = (ArrayList) this.f6641c.get(intent.getAction());
                if (arrayList2 != null) {
                    if (objArr != false) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList2);
                    }
                    ArrayList arrayList3 = null;
                    int i2 = 0;
                    while (i2 < arrayList2.size()) {
                        ab1 ab1Var = (ab1) arrayList2.get(i2);
                        if (objArr != false) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + ab1Var.f106a);
                        }
                        if (ab1Var.f108c) {
                            if (objArr != false) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            arrayList = arrayList2;
                            i = i2;
                            str = action;
                            z = z2;
                        } else {
                            String str3 = action;
                            arrayList = arrayList2;
                            i = i2;
                            str = action;
                            z = z2;
                            int match = ab1Var.f106a.match(str3, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (match >= 0) {
                                if (objArr != false) {
                                    Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                }
                                if (arrayList3 == null) {
                                    arrayList3 = new ArrayList();
                                }
                                arrayList3.add(ab1Var);
                                ab1Var.f108c = z;
                            } else if (objArr != false) {
                                if (match != -4) {
                                    if (match != -3) {
                                        if (match != -2) {
                                            if (match != -1) {
                                                str2 = "unknown reason";
                                            } else {
                                                str2 = "type";
                                            }
                                        } else {
                                            str2 = DataSchemeDataSource.SCHEME_DATA;
                                        }
                                    } else {
                                        str2 = "action";
                                    }
                                } else {
                                    str2 = "category";
                                }
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + str2);
                            }
                        }
                        i2 = i + 1;
                        z2 = z;
                        arrayList2 = arrayList;
                        action = str;
                        z3 = false;
                    }
                    boolean z4 = z2;
                    if (arrayList3 != null) {
                        for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                            ((ab1) arrayList3.get(i3)).f108c = false;
                        }
                        this.f6642d.add(new C1540m9(16, intent, arrayList3));
                        if (!this.f6643e.hasMessages(z4 ? 1 : 0)) {
                            this.f6643e.sendEmptyMessage(z4 ? 1 : 0);
                        }
                        return z4;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void sendBroadcastSync(@NonNull Intent intent) {
        if (sendBroadcast(intent)) {
            m1547a();
        }
    }

    public void unregisterReceiver(@NonNull BroadcastReceiver broadcastReceiver) {
        synchronized (this.f6640b) {
            try {
                ArrayList arrayList = (ArrayList) this.f6640b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ab1 ab1Var = (ab1) arrayList.get(size);
                    ab1Var.f109d = true;
                    for (int i = 0; i < ab1Var.f106a.countActions(); i++) {
                        String action = ab1Var.f106a.getAction(i);
                        ArrayList arrayList2 = (ArrayList) this.f6641c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                ab1 ab1Var2 = (ab1) arrayList2.get(size2);
                                if (ab1Var2.f107b == broadcastReceiver) {
                                    ab1Var2.f109d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f6641c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
