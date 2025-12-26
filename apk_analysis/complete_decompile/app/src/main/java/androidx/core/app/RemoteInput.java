package androidx.core.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p000.fa2;
import p000.ga2;
import p000.ha2;

/* loaded from: classes.dex */
public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;

    /* renamed from: a */
    public final String f3484a;

    /* renamed from: b */
    public final CharSequence f3485b;

    /* renamed from: c */
    public final CharSequence[] f3486c;

    /* renamed from: d */
    public final boolean f3487d;

    /* renamed from: e */
    public final int f3488e;

    /* renamed from: f */
    public final Bundle f3489f;

    /* renamed from: g */
    public final HashSet f3490g;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final String f3491a;

        /* renamed from: d */
        public CharSequence f3494d;

        /* renamed from: e */
        public CharSequence[] f3495e;

        /* renamed from: b */
        public final HashSet f3492b = new HashSet();

        /* renamed from: c */
        public final Bundle f3493c = new Bundle();

        /* renamed from: f */
        public boolean f3496f = true;

        /* renamed from: g */
        public int f3497g = 0;

        public Builder(@NonNull String str) {
            if (str != null) {
                this.f3491a = str;
                return;
            }
            throw new IllegalArgumentException("Result key can't be null");
        }

        @NonNull
        public Builder addExtras(@NonNull Bundle bundle) {
            if (bundle != null) {
                this.f3493c.putAll(bundle);
            }
            return this;
        }

        @NonNull
        public RemoteInput build() {
            return new RemoteInput(this.f3491a, this.f3494d, this.f3495e, this.f3496f, this.f3497g, this.f3493c, this.f3492b);
        }

        @NonNull
        public Bundle getExtras() {
            return this.f3493c;
        }

        @NonNull
        public Builder setAllowDataType(@NonNull String str, boolean z) {
            HashSet hashSet = this.f3492b;
            if (z) {
                hashSet.add(str);
            } else {
                hashSet.remove(str);
            }
            return this;
        }

        @NonNull
        public Builder setAllowFreeFormInput(boolean z) {
            this.f3496f = z;
            return this;
        }

        @NonNull
        public Builder setChoices(@Nullable CharSequence[] charSequenceArr) {
            this.f3495e = charSequenceArr;
            return this;
        }

        @NonNull
        public Builder setEditChoicesBeforeSending(int i) {
            this.f3497g = i;
            return this;
        }

        @NonNull
        public Builder setLabel(@Nullable CharSequence charSequence) {
            this.f3494d = charSequence;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Source {
    }

    public RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, int i, Bundle bundle, HashSet hashSet) {
        this.f3484a = str;
        this.f3485b = charSequence;
        this.f3486c = charSequenceArr;
        this.f3487d = z;
        this.f3488e = i;
        this.f3489f = bundle;
        this.f3490g = hashSet;
        if (getEditChoicesBeforeSending() == 2 && !getAllowFreeFormInput()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    /* renamed from: a */
    public static android.app.RemoteInput m708a(RemoteInput remoteInput) {
        Set<String> allowedDataTypes;
        RemoteInput.Builder addExtras = new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
        if (Build.VERSION.SDK_INT >= 26 && (allowedDataTypes = remoteInput.getAllowedDataTypes()) != null) {
            Iterator<String> it = allowedDataTypes.iterator();
            while (it.hasNext()) {
                fa2.m4793d(addExtras, it.next(), true);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            ha2.m5048b(addExtras, remoteInput.getEditChoicesBeforeSending());
        }
        return addExtras.build();
    }

    public static void addDataResultToIntent(@NonNull RemoteInput remoteInput, @NonNull Intent intent, @NonNull Map<String, Uri> map) {
        if (Build.VERSION.SDK_INT >= 26) {
            fa2.m4790a(remoteInput, intent, map);
            return;
        }
        Intent m710c = m710c(intent);
        if (m710c == null) {
            m710c = new Intent();
        }
        for (Map.Entry<String, Uri> entry : map.entrySet()) {
            String key = entry.getKey();
            Uri value = entry.getValue();
            if (key != null) {
                Bundle bundleExtra = m710c.getBundleExtra("android.remoteinput.dataTypeResultsData".concat(key));
                if (bundleExtra == null) {
                    bundleExtra = new Bundle();
                }
                bundleExtra.putString(remoteInput.getResultKey(), value.toString());
                m710c.putExtra("android.remoteinput.dataTypeResultsData".concat(key), bundleExtra);
            }
        }
        intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, m710c));
    }

    public static void addResultsToIntent(@NonNull RemoteInput[] remoteInputArr, @NonNull Intent intent, @NonNull Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0157j0.m744a(m709b(remoteInputArr), intent, bundle);
            return;
        }
        Bundle resultsFromIntent = getResultsFromIntent(intent);
        int resultsSource = getResultsSource(intent);
        if (resultsFromIntent != null) {
            resultsFromIntent.putAll(bundle);
            bundle = resultsFromIntent;
        }
        for (RemoteInput remoteInput : remoteInputArr) {
            Map<String, Uri> dataResultsFromIntent = getDataResultsFromIntent(intent, remoteInput.getResultKey());
            AbstractC0157j0.m744a(m709b(new RemoteInput[]{remoteInput}), intent, bundle);
            if (dataResultsFromIntent != null) {
                addDataResultToIntent(remoteInput, intent, dataResultsFromIntent);
            }
        }
        setResultsSource(intent, resultsSource);
    }

    /* renamed from: b */
    public static android.app.RemoteInput[] m709b(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            remoteInputArr2[i] = m708a(remoteInputArr[i]);
        }
        return remoteInputArr2;
    }

    /* renamed from: c */
    public static Intent m710c(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription description = clipData.getDescription();
        if (!description.hasMimeType("text/vnd.android.intent") || !description.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL)) {
            return null;
        }
        return clipData.getItemAt(0).getIntent();
    }

    @Nullable
    public static Map<String, Uri> getDataResultsFromIntent(@NonNull Intent intent, @NonNull String str) {
        String string;
        if (Build.VERSION.SDK_INT >= 26) {
            return fa2.m4792c(intent, str);
        }
        Intent m710c = m710c(intent);
        if (m710c == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : m710c.getExtras().keySet()) {
            if (str2.startsWith("android.remoteinput.dataTypeResultsData")) {
                String substring = str2.substring(39);
                if (!substring.isEmpty() && (string = m710c.getBundleExtra(str2).getString(str)) != null && !string.isEmpty()) {
                    hashMap.put(substring, Uri.parse(string));
                }
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    @Nullable
    public static Bundle getResultsFromIntent(@NonNull Intent intent) {
        return AbstractC0157j0.m745b(intent);
    }

    public static int getResultsSource(@NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return ga2.m4931a(intent);
        }
        Intent m710c = m710c(intent);
        if (m710c == null) {
            return 0;
        }
        return m710c.getExtras().getInt("android.remoteinput.resultsSource", 0);
    }

    public static void setResultsSource(@NonNull Intent intent, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            ga2.m4932b(intent, i);
            return;
        }
        Intent m710c = m710c(intent);
        if (m710c == null) {
            m710c = new Intent();
        }
        m710c.putExtra("android.remoteinput.resultsSource", i);
        intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, m710c));
    }

    public boolean getAllowFreeFormInput() {
        return this.f3487d;
    }

    @Nullable
    public Set<String> getAllowedDataTypes() {
        return this.f3490g;
    }

    @Nullable
    public CharSequence[] getChoices() {
        return this.f3486c;
    }

    public int getEditChoicesBeforeSending() {
        return this.f3488e;
    }

    @NonNull
    public Bundle getExtras() {
        return this.f3489f;
    }

    @Nullable
    public CharSequence getLabel() {
        return this.f3485b;
    }

    @NonNull
    public String getResultKey() {
        return this.f3484a;
    }

    public boolean isDataOnly() {
        if (!getAllowFreeFormInput() && ((getChoices() == null || getChoices().length == 0) && getAllowedDataTypes() != null && !getAllowedDataTypes().isEmpty())) {
            return true;
        }
        return false;
    }
}
