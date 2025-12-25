package p000;

import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zabi;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zal;
import com.google.android.gms.signin.zae;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class e73 extends i73 {

    /* renamed from: b */
    public final HashMap f16703b;

    /* renamed from: c */
    public final /* synthetic */ zaaw f16704c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e73(zaaw zaawVar, HashMap hashMap) {
        super(zaawVar);
        this.f16704c = zaawVar;
        this.f16703b = hashMap;
    }

    @Override // p000.i73
    /* renamed from: a */
    public final void mo4668a() {
        zae zaeVar;
        zaaw zaawVar = this.f16704c;
        zal zalVar = new zal(zaawVar.f13198d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = this.f16703b;
        for (Api.Client client : hashMap.keySet()) {
            if (client.requiresGooglePlayServices() && !((b73) hashMap.get(client)).f7915c) {
                arrayList.add(client);
            } else {
                arrayList2.add(client);
            }
        }
        boolean isEmpty = arrayList.isEmpty();
        Context context = zaawVar.f13197c;
        int i = 0;
        int i2 = -1;
        if (isEmpty) {
            int size = arrayList2.size();
            while (i < size) {
                i2 = zalVar.zab(context, (Api.Client) arrayList2.get(i));
                i++;
                if (i2 == 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList.size();
            while (i < size2) {
                i2 = zalVar.zab(context, (Api.Client) arrayList.get(i));
                i++;
                if (i2 != 0) {
                    break;
                }
            }
        }
        zabi zabiVar = zaawVar.f13195a;
        if (i2 != 0) {
            c73 c73Var = new c73(this, zaawVar, new ConnectionResult(i2, null));
            p73 p73Var = zabiVar.f13246e;
            p73Var.sendMessage(p73Var.obtainMessage(1, c73Var));
            return;
        }
        if (zaawVar.f13207m && (zaeVar = zaawVar.f13205k) != null) {
            zaeVar.zab();
        }
        for (Api.Client client2 : hashMap.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (BaseGmsClient.ConnectionProgressReportCallbacks) hashMap.get(client2);
            if (client2.requiresGooglePlayServices() && zalVar.zab(context, client2) != 0) {
                d73 d73Var = new d73(zaawVar, connectionProgressReportCallbacks);
                p73 p73Var2 = zabiVar.f13246e;
                p73Var2.sendMessage(p73Var2.obtainMessage(1, d73Var));
            } else {
                client2.connect(connectionProgressReportCallbacks);
            }
        }
    }
}
