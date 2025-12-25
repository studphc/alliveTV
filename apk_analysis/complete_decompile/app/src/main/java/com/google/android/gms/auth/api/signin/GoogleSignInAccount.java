package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInAccountCreator")
@Deprecated
/* loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();

    @NonNull
    @VisibleForTesting
    public static final Clock zaa = DefaultClock.getInstance();

    /* renamed from: a */
    public final int f12919a;

    /* renamed from: b */
    public final String f12920b;

    /* renamed from: c */
    public final String f12921c;

    /* renamed from: d */
    public final String f12922d;

    /* renamed from: e */
    public final String f12923e;

    /* renamed from: f */
    public final Uri f12924f;

    /* renamed from: g */
    public String f12925g;

    /* renamed from: h */
    public final long f12926h;

    /* renamed from: i */
    public final String f12927i;

    /* renamed from: j */
    public final ArrayList f12928j;

    /* renamed from: k */
    public final String f12929k;

    /* renamed from: l */
    public final String f12930l;

    /* renamed from: m */
    public final HashSet f12931m = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, ArrayList arrayList, String str7, String str8) {
        this.f12919a = i;
        this.f12920b = str;
        this.f12921c = str2;
        this.f12922d = str3;
        this.f12923e = str4;
        this.f12924f = uri;
        this.f12925g = str5;
        this.f12926h = j;
        this.f12927i = str6;
        this.f12928j = arrayList;
        this.f12929k = str7;
        this.f12930l = str8;
    }

    /* renamed from: a */
    public static GoogleSignInAccount m3069a(Account account, Set set) {
        return zaa(null, null, account.name, null, null, null, null, 0L, account.name, set);
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignInAccount createDefault() {
        return m3069a(new Account("<<default account>>", AccountType.GOOGLE), new HashSet());
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignInAccount fromAccount(@NonNull Account account) {
        return m3069a(account, new ArraySet());
    }

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static GoogleSignInAccount fromAccountAndScopes(@NonNull Account account, @NonNull Scope scope, @NonNull Scope... scopeArr) {
        Preconditions.checkNotNull(account);
        Preconditions.checkNotNull(scope);
        HashSet hashSet = new HashSet();
        hashSet.add(scope);
        hashSet.addAll(Arrays.asList(scopeArr));
        return m3069a(account, hashSet);
    }

    @NonNull
    public static GoogleSignInAccount zaa(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l, @NonNull String str7, @NonNull Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), Preconditions.checkNotEmpty(str7), new ArrayList((Collection) Preconditions.checkNotNull(set)), str5, str6);
    }

    @Nullable
    public static GoogleSignInAccount zab(@Nullable String str) {
        Uri uri;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        if (!TextUtils.isEmpty(optString)) {
            uri = Uri.parse(optString);
        } else {
            uri = null;
        }
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString2 = jSONObject.optString("id");
        if (jSONObject.has("tokenId")) {
            str2 = jSONObject.optString("tokenId");
        } else {
            str2 = null;
        }
        if (jSONObject.has("email")) {
            str3 = jSONObject.optString("email");
        } else {
            str3 = null;
        }
        if (jSONObject.has("displayName")) {
            str4 = jSONObject.optString("displayName");
        } else {
            str4 = null;
        }
        if (jSONObject.has("givenName")) {
            str5 = jSONObject.optString("givenName");
        } else {
            str5 = null;
        }
        if (jSONObject.has("familyName")) {
            str6 = jSONObject.optString("familyName");
        } else {
            str6 = null;
        }
        GoogleSignInAccount zaa2 = zaa(optString2, str2, str3, str4, str5, str6, uri, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        if (jSONObject.has("serverAuthCode")) {
            str7 = jSONObject.optString("serverAuthCode");
        }
        zaa2.f12925g = str7;
        return zaa2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.f12927i.equals(this.f12927i) || !googleSignInAccount.getRequestedScopes().equals(getRequestedScopes())) {
            return false;
        }
        return true;
    }

    @Nullable
    public Account getAccount() {
        String str = this.f12922d;
        if (str == null) {
            return null;
        }
        return new Account(str, AccountType.GOOGLE);
    }

    @Nullable
    public String getDisplayName() {
        return this.f12923e;
    }

    @Nullable
    public String getEmail() {
        return this.f12922d;
    }

    @Nullable
    public String getFamilyName() {
        return this.f12930l;
    }

    @Nullable
    public String getGivenName() {
        return this.f12929k;
    }

    @NonNull
    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.f12928j);
    }

    @Nullable
    public String getId() {
        return this.f12920b;
    }

    @Nullable
    public String getIdToken() {
        return this.f12921c;
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.f12924f;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getRequestedScopes() {
        HashSet hashSet = new HashSet(this.f12928j);
        hashSet.addAll(this.f12931m);
        return hashSet;
    }

    @Nullable
    public String getServerAuthCode() {
        return this.f12925g;
    }

    public int hashCode() {
        return ((this.f12927i.hashCode() + 527) * 31) + getRequestedScopes().hashCode();
    }

    @KeepForSdk
    public boolean isExpired() {
        if (zaa.currentTimeMillis() / 1000 >= this.f12926h - 300) {
            return true;
        }
        return false;
    }

    @NonNull
    @CanIgnoreReturnValue
    @KeepForSdk
    public GoogleSignInAccount requestExtraScopes(@NonNull Scope... scopeArr) {
        if (scopeArr != null) {
            Collections.addAll(this.f12931m, scopeArr);
        }
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f12919a);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 4, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPhotoUrl(), i, false);
        SafeParcelWriter.writeString(parcel, 7, getServerAuthCode(), false);
        SafeParcelWriter.writeLong(parcel, 8, this.f12926h);
        SafeParcelWriter.writeString(parcel, 9, this.f12927i, false);
        SafeParcelWriter.writeTypedList(parcel, 10, this.f12928j, false);
        SafeParcelWriter.writeString(parcel, 11, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 12, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final String zac() {
        return this.f12927i;
    }

    @NonNull
    public final String zad() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            Uri photoUrl = getPhotoUrl();
            if (photoUrl != null) {
                jSONObject.put("photoUrl", photoUrl.toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.f12926h);
            jSONObject.put("obfuscatedIdentifier", this.f12927i);
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList = this.f12928j;
            Scope[] scopeArr = (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
            Arrays.sort(scopeArr, zaa.zaa);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.getScopeUri());
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
