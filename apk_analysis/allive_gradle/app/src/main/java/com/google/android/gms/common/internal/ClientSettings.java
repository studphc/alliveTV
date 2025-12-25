package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.SignInOptions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@KeepForSdk
/* loaded from: classes.dex */
public final class ClientSettings {

    /* renamed from: a */
    public final Account f13398a;

    /* renamed from: b */
    public final Set f13399b;

    /* renamed from: c */
    public final Set f13400c;

    /* renamed from: d */
    public final Map f13401d;

    /* renamed from: e */
    public final int f13402e;

    /* renamed from: f */
    public final View f13403f;

    /* renamed from: g */
    public final String f13404g;

    /* renamed from: h */
    public final String f13405h;

    /* renamed from: i */
    public final SignInOptions f13406i;

    /* renamed from: j */
    public Integer f13407j;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public Account f13408a;

        /* renamed from: b */
        public ArraySet f13409b;

        /* renamed from: c */
        public String f13410c;

        /* renamed from: d */
        public String f13411d;

        /* renamed from: e */
        public final SignInOptions f13412e = SignInOptions.zaa;

        @NonNull
        @KeepForSdk
        public ClientSettings build() {
            return new ClientSettings(this.f13408a, this.f13409b, null, 0, null, this.f13410c, this.f13411d, this.f13412e, false);
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder setRealClientPackageName(@NonNull String str) {
            this.f13410c = str;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public final Builder zaa(@NonNull Collection collection) {
            if (this.f13409b == null) {
                this.f13409b = new ArraySet();
            }
            this.f13409b.addAll(collection);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public final Builder zab(@Nullable Account account) {
            this.f13408a = account;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public final Builder zac(@NonNull String str) {
            this.f13411d = str;
            return this;
        }
    }

    @KeepForSdk
    public ClientSettings(@NonNull Account account, @NonNull Set<Scope> set, @NonNull Map<Api<?>, zab> map, int i, @Nullable View view, @NonNull String str, @NonNull String str2, @Nullable SignInOptions signInOptions) {
        this(account, set, map, i, view, str, str2, signInOptions, false);
    }

    @NonNull
    @KeepForSdk
    public static ClientSettings createDefault(@NonNull Context context) {
        return new GoogleApiClient.Builder(context).zaa();
    }

    @androidx.annotation.Nullable
    @KeepForSdk
    public Account getAccount() {
        return this.f13398a;
    }

    @androidx.annotation.Nullable
    @KeepForSdk
    @Deprecated
    public String getAccountName() {
        Account account = this.f13398a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @NonNull
    @KeepForSdk
    public Account getAccountOrDefault() {
        Account account = this.f13398a;
        if (account != null) {
            return account;
        }
        return new Account("<<default account>>", AccountType.GOOGLE);
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getAllRequestedScopes() {
        return this.f13400c;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getApplicableScopes(@NonNull Api<?> api) {
        zab zabVar = (zab) this.f13401d.get(api);
        Set<Scope> set = this.f13399b;
        if (zabVar != null && !zabVar.zaa.isEmpty()) {
            HashSet hashSet = new HashSet(set);
            hashSet.addAll(zabVar.zaa);
            return hashSet;
        }
        return set;
    }

    @KeepForSdk
    public int getGravityForPopups() {
        return this.f13402e;
    }

    @NonNull
    @KeepForSdk
    public String getRealClientPackageName() {
        return this.f13404g;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getRequiredScopes() {
        return this.f13399b;
    }

    @androidx.annotation.Nullable
    @KeepForSdk
    public View getViewForPopups() {
        return this.f13403f;
    }

    @NonNull
    public final SignInOptions zaa() {
        return this.f13406i;
    }

    @androidx.annotation.Nullable
    public final Integer zab() {
        return this.f13407j;
    }

    @androidx.annotation.Nullable
    public final String zac() {
        return this.f13405h;
    }

    @NonNull
    public final Map zad() {
        return this.f13401d;
    }

    public final void zae(@NonNull Integer num) {
        this.f13407j = num;
    }

    public ClientSettings(@Nullable Account account, @NonNull Set set, @NonNull Map map, int i, @Nullable View view, @NonNull String str, @NonNull String str2, @Nullable SignInOptions signInOptions, boolean z) {
        this.f13398a = account;
        Set emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f13399b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f13401d = map;
        this.f13403f = view;
        this.f13402e = i;
        this.f13404g = str;
        this.f13405h = str2;
        this.f13406i = signInOptions == null ? SignInOptions.zaa : signInOptions;
        HashSet hashSet = new HashSet(emptySet);
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(((zab) it.next()).zaa);
        }
        this.f13400c = Collections.unmodifiableSet(hashSet);
    }
}
