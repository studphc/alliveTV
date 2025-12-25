package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000.x30;

@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
@Deprecated
/* loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    @NonNull
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;

    @NonNull
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;

    /* renamed from: k */
    public static final x30 f12932k;

    @NonNull
    @VisibleForTesting
    public static final Scope zaa = new Scope(Scopes.PROFILE);

    @NonNull
    @VisibleForTesting
    public static final Scope zab = new Scope("email");

    @NonNull
    @VisibleForTesting
    public static final Scope zac = new Scope(Scopes.OPEN_ID);

    @NonNull
    @VisibleForTesting
    public static final Scope zad;

    @NonNull
    @VisibleForTesting
    public static final Scope zae;

    /* renamed from: a */
    public final int f12933a;

    /* renamed from: b */
    public final ArrayList f12934b;

    /* renamed from: c */
    public final Account f12935c;

    /* renamed from: d */
    public final boolean f12936d;

    /* renamed from: e */
    public final boolean f12937e;

    /* renamed from: f */
    public final boolean f12938f;

    /* renamed from: g */
    public final String f12939g;

    /* renamed from: h */
    public final String f12940h;

    /* renamed from: i */
    public final ArrayList f12941i;

    /* renamed from: j */
    public final String f12942j;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final HashSet f12943a;

        /* renamed from: b */
        public boolean f12944b;

        /* renamed from: c */
        public boolean f12945c;

        /* renamed from: d */
        public boolean f12946d;

        /* renamed from: e */
        public String f12947e;

        /* renamed from: f */
        public Account f12948f;

        /* renamed from: g */
        public String f12949g;

        /* renamed from: h */
        public final HashMap f12950h;

        /* renamed from: i */
        public String f12951i;

        public Builder() {
            this.f12943a = new HashSet();
            this.f12950h = new HashMap();
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addExtension(@NonNull GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            Integer valueOf = Integer.valueOf(googleSignInOptionsExtension.getExtensionType());
            HashMap hashMap = this.f12950h;
            if (!hashMap.containsKey(valueOf)) {
                List<Scope> impliedScopes = googleSignInOptionsExtension.getImpliedScopes();
                if (impliedScopes != null) {
                    this.f12943a.addAll(impliedScopes);
                }
                hashMap.put(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(googleSignInOptionsExtension));
                return this;
            }
            throw new IllegalStateException("Only one extension per type may be added");
        }

        @NonNull
        public GoogleSignInOptions build() {
            Scope scope = GoogleSignInOptions.zae;
            HashSet hashSet = this.f12943a;
            if (hashSet.contains(scope)) {
                Scope scope2 = GoogleSignInOptions.zad;
                if (hashSet.contains(scope2)) {
                    hashSet.remove(scope2);
                }
            }
            if (this.f12946d && (this.f12948f == null || !hashSet.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(3, new ArrayList(hashSet), this.f12948f, this.f12946d, this.f12944b, this.f12945c, this.f12947e, this.f12949g, this.f12950h, this.f12951i);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestEmail() {
            this.f12943a.add(GoogleSignInOptions.zab);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestId() {
            this.f12943a.add(GoogleSignInOptions.zac);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestIdToken(@NonNull String str) {
            boolean z = true;
            this.f12946d = true;
            Preconditions.checkNotEmpty(str);
            String str2 = this.f12947e;
            if (str2 != null && !str2.equals(str)) {
                z = false;
            }
            Preconditions.checkArgument(z, "two different server client ids provided");
            this.f12947e = str;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestProfile() {
            this.f12943a.add(GoogleSignInOptions.zaa);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestScopes(@NonNull Scope scope, @NonNull Scope... scopeArr) {
            HashSet hashSet = this.f12943a;
            hashSet.add(scope);
            hashSet.addAll(Arrays.asList(scopeArr));
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestServerAuthCode(@NonNull String str) {
            requestServerAuthCode(str, false);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setAccountName(@NonNull String str) {
            this.f12948f = new Account(Preconditions.checkNotEmpty(str), AccountType.GOOGLE);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setHostedDomain(@NonNull String str) {
            this.f12949g = Preconditions.checkNotEmpty(str);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder setLogSessionId(@NonNull String str) {
            this.f12951i = str;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestServerAuthCode(@NonNull String str, boolean z) {
            boolean z2 = true;
            this.f12944b = true;
            Preconditions.checkNotEmpty(str);
            String str2 = this.f12947e;
            if (str2 != null && !str2.equals(str)) {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "two different server client ids provided");
            this.f12947e = str;
            this.f12945c = z;
            return this;
        }

        public Builder(@NonNull GoogleSignInOptions googleSignInOptions) {
            this.f12943a = new HashSet();
            this.f12950h = new HashMap();
            Preconditions.checkNotNull(googleSignInOptions);
            this.f12943a = new HashSet(googleSignInOptions.f12934b);
            this.f12944b = googleSignInOptions.f12937e;
            this.f12945c = googleSignInOptions.f12938f;
            this.f12946d = googleSignInOptions.f12936d;
            this.f12947e = googleSignInOptions.f12939g;
            this.f12948f = googleSignInOptions.f12935c;
            this.f12949g = googleSignInOptions.f12940h;
            this.f12950h = GoogleSignInOptions.m3070a(googleSignInOptions.f12941i);
            this.f12951i = googleSignInOptions.f12942j;
        }
    }

    static {
        Scope scope = new Scope(Scopes.GAMES_LITE);
        zad = scope;
        zae = new Scope(Scopes.GAMES);
        Builder builder = new Builder();
        builder.requestId();
        builder.requestProfile();
        DEFAULT_SIGN_IN = builder.build();
        Builder builder2 = new Builder();
        builder2.requestScopes(scope, new Scope[0]);
        DEFAULT_GAMES_SIGN_IN = builder2.build();
        CREATOR = new zae();
        f12932k = new x30(6);
    }

    public GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, HashMap hashMap, String str3) {
        this.f12933a = i;
        this.f12934b = arrayList;
        this.f12935c = account;
        this.f12936d = z;
        this.f12937e = z2;
        this.f12938f = z3;
        this.f12939g = str;
        this.f12940h = str2;
        this.f12941i = new ArrayList(hashMap.values());
        this.f12942j = str3;
    }

    /* renamed from: a */
    public static HashMap m3070a(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) it.next();
                hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable);
            }
        }
        return hashMap;
    }

    @Nullable
    public static GoogleSignInOptions zab(@Nullable String str) {
        String str2;
        Account account;
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        if (jSONObject.has("accountName")) {
            str2 = jSONObject.optString("accountName");
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            account = new Account(str2, AccountType.GOOGLE);
        } else {
            account = null;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        boolean z = jSONObject.getBoolean("idTokenRequested");
        boolean z2 = jSONObject.getBoolean("serverAuthRequested");
        boolean z3 = jSONObject.getBoolean("forceCodeForRefreshToken");
        if (jSONObject.has("serverClientId")) {
            str3 = jSONObject.optString("serverClientId");
        } else {
            str3 = null;
        }
        if (jSONObject.has("hostedDomain")) {
            str4 = jSONObject.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, arrayList, account, z, z2, z3, str3, str4, new HashMap(), null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0048, code lost:
    
        if (r1.equals(r6.getAccount()) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(@Nullable Object obj) {
        String str = this.f12939g;
        ArrayList arrayList = this.f12934b;
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f12941i.isEmpty() && googleSignInOptions.f12941i.isEmpty() && arrayList.size() == googleSignInOptions.getScopes().size() && arrayList.containsAll(googleSignInOptions.getScopes())) {
                Account account = this.f12935c;
                if (account == null) {
                    if (googleSignInOptions.getAccount() == null) {
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(googleSignInOptions.getServerClientId())) {
                    }
                } else if (!str.equals(googleSignInOptions.getServerClientId())) {
                }
                if (this.f12938f == googleSignInOptions.isForceCodeForRefreshToken() && this.f12936d == googleSignInOptions.isIdTokenRequested() && this.f12937e == googleSignInOptions.isServerAuthCodeRequested()) {
                    if (TextUtils.equals(this.f12942j, googleSignInOptions.getLogSessionId())) {
                        return true;
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    @Nullable
    @KeepForSdk
    public Account getAccount() {
        return this.f12935c;
    }

    @NonNull
    @KeepForSdk
    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.f12941i;
    }

    @Nullable
    @KeepForSdk
    public String getLogSessionId() {
        return this.f12942j;
    }

    @NonNull
    public Scope[] getScopeArray() {
        ArrayList arrayList = this.f12934b;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    @NonNull
    @KeepForSdk
    public ArrayList<Scope> getScopes() {
        return new ArrayList<>(this.f12934b);
    }

    @Nullable
    @KeepForSdk
    public String getServerClientId() {
        return this.f12939g;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f12934b;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((Scope) arrayList2.get(i)).getScopeUri());
        }
        Collections.sort(arrayList);
        HashAccumulator hashAccumulator = new HashAccumulator();
        hashAccumulator.addObject(arrayList);
        hashAccumulator.addObject(this.f12935c);
        hashAccumulator.addObject(this.f12939g);
        hashAccumulator.zaa(this.f12938f);
        hashAccumulator.zaa(this.f12936d);
        hashAccumulator.zaa(this.f12937e);
        hashAccumulator.addObject(this.f12942j);
        return hashAccumulator.hash();
    }

    @KeepForSdk
    public boolean isForceCodeForRefreshToken() {
        return this.f12938f;
    }

    @KeepForSdk
    public boolean isIdTokenRequested() {
        return this.f12936d;
    }

    @KeepForSdk
    public boolean isServerAuthCodeRequested() {
        return this.f12937e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f12933a);
        SafeParcelWriter.writeTypedList(parcel, 2, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getAccount(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isIdTokenRequested());
        SafeParcelWriter.writeBoolean(parcel, 5, isServerAuthCodeRequested());
        SafeParcelWriter.writeBoolean(parcel, 6, isForceCodeForRefreshToken());
        SafeParcelWriter.writeString(parcel, 7, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 8, this.f12940h, false);
        SafeParcelWriter.writeTypedList(parcel, 9, getExtensions(), false);
        SafeParcelWriter.writeString(parcel, 10, getLogSessionId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final String zaf() {
        String str = this.f12940h;
        String str2 = this.f12939g;
        ArrayList arrayList = this.f12934b;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(arrayList, f12932k);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Scope) it.next()).getScopeUri());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.f12935c;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.f12936d);
            jSONObject.put("forceCodeForRefreshToken", this.f12938f);
            jSONObject.put("serverAuthRequested", this.f12937e);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("serverClientId", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("hostedDomain", str);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
