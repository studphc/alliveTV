package p000;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zabi;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.zab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class f73 extends i73 {

    /* renamed from: b */
    public final ArrayList f17162b;

    /* renamed from: c */
    public final /* synthetic */ zaaw f17163c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f73(zaaw zaawVar, ArrayList arrayList) {
        super(zaawVar);
        this.f17163c = zaawVar;
        this.f17162b = arrayList;
    }

    @Override // p000.i73
    /* renamed from: a */
    public final void mo4668a() {
        Set set;
        zaaw zaawVar = this.f17163c;
        zabe zabeVar = zaawVar.f13195a.f13255n;
        zabi zabiVar = zaawVar.f13195a;
        ClientSettings clientSettings = zaawVar.f13212r;
        if (clientSettings == null) {
            set = Collections.emptySet();
        } else {
            HashSet hashSet = new HashSet(clientSettings.getRequiredScopes());
            Map zad = clientSettings.zad();
            for (Api api : zad.keySet()) {
                if (!zabiVar.f13248g.containsKey(api.zab())) {
                    hashSet.addAll(((zab) zad.get(api)).zaa);
                }
            }
            set = hashSet;
        }
        zabeVar.f13233p = set;
        ArrayList arrayList = this.f17162b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Api.Client) arrayList.get(i)).getRemoteService(zaawVar.f13209o, zabiVar.f13255n.f13233p);
        }
    }
}
