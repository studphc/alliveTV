package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzqr;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000.AbstractC1726qj;
import p000.ub3;

/* loaded from: classes.dex */
public final class zzho {

    /* renamed from: a */
    public final String f14204a;

    /* renamed from: b */
    public final Bundle f14205b;

    /* renamed from: c */
    public Bundle f14206c;

    /* renamed from: d */
    public final /* synthetic */ ub3 f14207d;

    public zzho(ub3 ub3Var, String str, Bundle bundle) {
        this.f14207d = ub3Var;
        Preconditions.checkNotEmpty(str);
        this.f14204a = str;
        this.f14205b = new Bundle();
    }

    @WorkerThread
    public final Bundle zza() {
        char c;
        if (this.f14206c == null) {
            ub3 ub3Var = this.f14207d;
            String string = ub3Var.m7692b().getString(this.f14204a, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            int hashCode = string3.hashCode();
                            if (hashCode != 100) {
                                if (hashCode != 108) {
                                    if (hashCode != 115) {
                                        if (hashCode != 3352) {
                                            if (hashCode == 3445 && string3.equals("la")) {
                                                c = 4;
                                            }
                                            c = 65535;
                                        } else {
                                            if (string3.equals("ia")) {
                                                c = 3;
                                            }
                                            c = 65535;
                                        }
                                    } else {
                                        if (string3.equals("s")) {
                                            c = 0;
                                        }
                                        c = 65535;
                                    }
                                } else {
                                    if (string3.equals("l")) {
                                        c = 2;
                                    }
                                    c = 65535;
                                }
                            } else {
                                if (string3.equals("d")) {
                                    c = 1;
                                }
                                c = 65535;
                            }
                            if (c != 0) {
                                if (c != 1) {
                                    if (c != 2) {
                                        if (c != 3) {
                                            if (c != 4) {
                                                ub3Var.zzu.zzaW().zze().zzb("Unrecognized persisted bundle type. Type", string3);
                                            } else {
                                                zzqr.zzb();
                                                if (ub3Var.zzu.zzf().zzx(null, zzgi.zzaW)) {
                                                    JSONArray jSONArray2 = new JSONArray(jSONObject.getString("v"));
                                                    int length = jSONArray2.length();
                                                    long[] jArr = new long[length];
                                                    for (int i2 = 0; i2 < length; i2++) {
                                                        jArr[i2] = jSONArray2.optLong(i2);
                                                    }
                                                    bundle.putLongArray(string2, jArr);
                                                }
                                            }
                                        } else {
                                            zzqr.zzb();
                                            if (ub3Var.zzu.zzf().zzx(null, zzgi.zzaW)) {
                                                JSONArray jSONArray3 = new JSONArray(jSONObject.getString("v"));
                                                int length2 = jSONArray3.length();
                                                int[] iArr = new int[length2];
                                                for (int i3 = 0; i3 < length2; i3++) {
                                                    iArr[i3] = jSONArray3.optInt(i3);
                                                }
                                                bundle.putIntArray(string2, iArr);
                                            }
                                        }
                                    } else {
                                        bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                                    }
                                } else {
                                    bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                                }
                            } else {
                                bundle.putString(string2, jSONObject.getString("v"));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            ub3Var.zzu.zzaW().zze().zza("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.f14206c = bundle;
                } catch (JSONException unused2) {
                    AbstractC1726qj.m7039D(ub3Var.zzu, "Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.f14206c == null) {
                this.f14206c = this.f14205b;
            }
        }
        return new Bundle((Bundle) Preconditions.checkNotNull(this.f14206c));
    }

    @WorkerThread
    public final void zzb(Bundle bundle) {
        Bundle bundle2;
        Iterator<String> it;
        JSONObject jSONObject;
        zzio zzioVar;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
        }
        ub3 ub3Var = this.f14207d;
        SharedPreferences.Editor edit = ub3Var.m7692b().edit();
        int size = bundle2.size();
        String str = this.f14204a;
        if (size == 0) {
            edit.remove(str);
        } else {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it2 = bundle2.keySet().iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                Object obj = bundle2.get(next);
                if (obj != null) {
                    try {
                        jSONObject = new JSONObject();
                        jSONObject.put("n", next);
                        zzqr.zzb();
                        zzioVar = ub3Var.zzu;
                        it = it2;
                    } catch (JSONException e) {
                        e = e;
                        it = it2;
                    }
                    if (zzioVar.zzf().zzx(null, zzgi.zzaW)) {
                        try {
                        } catch (JSONException e2) {
                            e = e2;
                            ub3Var.zzu.zzaW().zze().zzb("Cannot serialize bundle value to SharedPreferences", e);
                            it2 = it;
                        }
                        if (obj instanceof String) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "l");
                        } else if (obj instanceof int[]) {
                            jSONObject.put("v", Arrays.toString((int[]) obj));
                            jSONObject.put("t", "ia");
                        } else if (obj instanceof long[]) {
                            jSONObject.put("v", Arrays.toString((long[]) obj));
                            jSONObject.put("t", "la");
                        } else if (obj instanceof Double) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "d");
                        } else {
                            zzioVar.zzaW().zze().zzb("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                            it2 = it;
                        }
                        jSONArray.put(jSONObject);
                        it2 = it;
                    } else {
                        jSONObject.put("v", obj.toString());
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            zzioVar.zzaW().zze().zzb("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                            it2 = it;
                        }
                        jSONArray.put(jSONObject);
                        it2 = it;
                    }
                }
            }
            edit.putString(str, jSONArray.toString());
        }
        edit.apply();
        this.f14206c = bundle2;
    }
}
