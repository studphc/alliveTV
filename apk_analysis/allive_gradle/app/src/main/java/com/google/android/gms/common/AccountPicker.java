package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AccountPicker {

    /* loaded from: classes.dex */
    public static class AccountChooserOptions {

        /* renamed from: a */
        public Account f12960a;

        /* renamed from: b */
        public ArrayList f12961b;

        /* renamed from: c */
        public ArrayList f12962c;

        /* renamed from: d */
        public boolean f12963d;

        /* renamed from: e */
        public String f12964e;

        /* renamed from: f */
        public Bundle f12965f;

        /* loaded from: classes.dex */
        public static class Builder {

            /* renamed from: a */
            public Account f12966a;

            /* renamed from: b */
            public ArrayList f12967b;

            /* renamed from: c */
            public ArrayList f12968c;

            /* renamed from: d */
            public boolean f12969d = false;

            /* renamed from: e */
            public String f12970e;

            /* renamed from: f */
            public Bundle f12971f;

            @NonNull
            public AccountChooserOptions build() {
                Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
                Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
                AccountChooserOptions accountChooserOptions = new AccountChooserOptions();
                accountChooserOptions.f12962c = this.f12968c;
                accountChooserOptions.f12961b = this.f12967b;
                accountChooserOptions.f12963d = this.f12969d;
                accountChooserOptions.f12965f = this.f12971f;
                accountChooserOptions.f12960a = this.f12966a;
                accountChooserOptions.f12964e = this.f12970e;
                return accountChooserOptions;
            }

            @NonNull
            public Builder setAllowableAccounts(@Nullable List<Account> list) {
                ArrayList arrayList;
                if (list == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(list);
                }
                this.f12967b = arrayList;
                return this;
            }

            @NonNull
            public Builder setAllowableAccountsTypes(@Nullable List<String> list) {
                ArrayList arrayList;
                if (list == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(list);
                }
                this.f12968c = arrayList;
                return this;
            }

            @NonNull
            public Builder setAlwaysShowAccountPicker(boolean z) {
                this.f12969d = z;
                return this;
            }

            @NonNull
            public Builder setOptionsForAddingAccount(@Nullable Bundle bundle) {
                this.f12971f = bundle;
                return this;
            }

            @NonNull
            public Builder setSelectedAccount(@Nullable Account account) {
                this.f12966a = account;
                return this;
            }

            @NonNull
            public Builder setTitleOverrideText(@Nullable String str) {
                this.f12970e = str;
                return this;
            }
        }
    }

    @NonNull
    @Deprecated
    public static Intent newChooseAccountIntent(@Nullable Account account, @Nullable ArrayList<Account> arrayList, @Nullable String[] strArr, boolean z, @Nullable String str, @Nullable String str2, @Nullable String[] strArr2, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", arrayList);
        intent.putExtra("allowableAccountTypes", strArr);
        intent.putExtra("addAccountOptions", bundle);
        intent.putExtra("selectedAccount", account);
        intent.putExtra("alwaysPromptForAccount", z);
        intent.putExtra("descriptionTextOverride", str);
        intent.putExtra("authTokenType", str2);
        intent.putExtra("addAccountRequiredFeatures", strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra("overrideTheme", 0);
        intent.putExtra("overrideCustomTheme", 0);
        intent.putExtra("hostedDomainFilter", (String) null);
        return intent;
    }

    @NonNull
    public static Intent newChooseAccountIntent(@NonNull AccountChooserOptions accountChooserOptions) {
        Intent intent = new Intent();
        accountChooserOptions.getClass();
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
        Preconditions.checkArgument(true, "Making the selected account non-clickable is only supported for the THEME_DAY_NIGHT_GOOGLE_MATERIAL2, THEME_LIGHT_GOOGLE_MATERIAL3, THEME_DARK_GOOGLE_MATERIAL3 or THEME_DAY_NIGHT_GOOGLE_MATERIAL3 themes");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", accountChooserOptions.f12961b);
        ArrayList arrayList = accountChooserOptions.f12962c;
        if (arrayList != null) {
            intent.putExtra("allowableAccountTypes", (String[]) arrayList.toArray(new String[0]));
        }
        intent.putExtra("addAccountOptions", accountChooserOptions.f12965f);
        intent.putExtra("selectedAccount", accountChooserOptions.f12960a);
        intent.putExtra("selectedAccountIsNotClickable", false);
        intent.putExtra("alwaysPromptForAccount", accountChooserOptions.f12963d);
        intent.putExtra("descriptionTextOverride", accountChooserOptions.f12964e);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra("realClientPackage", (String) null);
        intent.putExtra("overrideTheme", 0);
        intent.putExtra("overrideCustomTheme", 0);
        intent.putExtra("hostedDomainFilter", (String) null);
        Bundle bundle = new Bundle();
        if (!bundle.isEmpty()) {
            intent.putExtra("first_party_options_bundle", bundle);
        }
        return intent;
    }
}
