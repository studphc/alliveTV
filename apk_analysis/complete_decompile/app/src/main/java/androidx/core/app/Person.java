package androidx.core.app;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Objects;

/* loaded from: classes.dex */
public class Person {

    /* renamed from: a */
    public CharSequence f3470a;

    /* renamed from: b */
    public IconCompat f3471b;

    /* renamed from: c */
    public String f3472c;

    /* renamed from: d */
    public String f3473d;

    /* renamed from: e */
    public boolean f3474e;

    /* renamed from: f */
    public boolean f3475f;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public CharSequence f3476a;

        /* renamed from: b */
        public IconCompat f3477b;

        /* renamed from: c */
        public String f3478c;

        /* renamed from: d */
        public String f3479d;

        /* renamed from: e */
        public boolean f3480e;

        /* renamed from: f */
        public boolean f3481f;

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.core.app.Person, java.lang.Object] */
        @NonNull
        public Person build() {
            ?? obj = new Object();
            obj.f3470a = this.f3476a;
            obj.f3471b = this.f3477b;
            obj.f3472c = this.f3478c;
            obj.f3473d = this.f3479d;
            obj.f3474e = this.f3480e;
            obj.f3475f = this.f3481f;
            return obj;
        }

        @NonNull
        public Builder setBot(boolean z) {
            this.f3480e = z;
            return this;
        }

        @NonNull
        public Builder setIcon(@Nullable IconCompat iconCompat) {
            this.f3477b = iconCompat;
            return this;
        }

        @NonNull
        public Builder setImportant(boolean z) {
            this.f3481f = z;
            return this;
        }

        @NonNull
        public Builder setKey(@Nullable String str) {
            this.f3479d = str;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.f3476a = charSequence;
            return this;
        }

        @NonNull
        public Builder setUri(@Nullable String str) {
            this.f3478c = str;
            return this;
        }
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromAndroidPerson(@NonNull android.app.Person person) {
        return AbstractC0155i0.m740a(person);
    }

    @NonNull
    public static Person fromBundle(@NonNull Bundle bundle) {
        IconCompat iconCompat;
        Bundle bundle2 = bundle.getBundle("icon");
        Builder name = new Builder().setName(bundle.getCharSequence(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (bundle2 != null) {
            iconCompat = IconCompat.createFromBundle(bundle2);
        } else {
            iconCompat = null;
        }
        return name.setIcon(iconCompat).setUri(bundle.getString("uri")).setKey(bundle.getString("key")).setBot(bundle.getBoolean("isBot")).setImportant(bundle.getBoolean("isImportant")).build();
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromPersistableBundle(@NonNull PersistableBundle persistableBundle) {
        return AbstractC0153h0.m735a(persistableBundle);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        String key = getKey();
        String key2 = person.getKey();
        if (key == null && key2 == null) {
            if (!Objects.equals(Objects.toString(getName()), Objects.toString(person.getName())) || !Objects.equals(getUri(), person.getUri()) || !Boolean.valueOf(isBot()).equals(Boolean.valueOf(person.isBot())) || !Boolean.valueOf(isImportant()).equals(Boolean.valueOf(person.isImportant()))) {
                return false;
            }
            return true;
        }
        return Objects.equals(key, key2);
    }

    @Nullable
    public IconCompat getIcon() {
        return this.f3471b;
    }

    @Nullable
    public String getKey() {
        return this.f3473d;
    }

    @Nullable
    public CharSequence getName() {
        return this.f3470a;
    }

    @Nullable
    public String getUri() {
        return this.f3472c;
    }

    public int hashCode() {
        String key = getKey();
        if (key != null) {
            return key.hashCode();
        }
        return Objects.hash(getName(), getUri(), Boolean.valueOf(isBot()), Boolean.valueOf(isImportant()));
    }

    public boolean isBot() {
        return this.f3474e;
    }

    public boolean isImportant() {
        return this.f3475f;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String resolveToLegacyUri() {
        String str = this.f3472c;
        if (str != null) {
            return str;
        }
        CharSequence charSequence = this.f3470a;
        if (charSequence != null) {
            return "name:" + ((Object) charSequence);
        }
        return "";
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.app.Person toAndroidPerson() {
        return AbstractC0155i0.m741b(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.core.app.Person$Builder, java.lang.Object] */
    @NonNull
    public Builder toBuilder() {
        ?? obj = new Object();
        obj.f3476a = this.f3470a;
        obj.f3477b = this.f3471b;
        obj.f3478c = this.f3472c;
        obj.f3479d = this.f3473d;
        obj.f3480e = this.f3474e;
        obj.f3481f = this.f3475f;
        return obj;
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putCharSequence(AppMeasurementSdk.ConditionalUserProperty.NAME, this.f3470a);
        IconCompat iconCompat = this.f3471b;
        if (iconCompat != null) {
            bundle = iconCompat.toBundle();
        } else {
            bundle = null;
        }
        bundle2.putBundle("icon", bundle);
        bundle2.putString("uri", this.f3472c);
        bundle2.putString("key", this.f3473d);
        bundle2.putBoolean("isBot", this.f3474e);
        bundle2.putBoolean("isImportant", this.f3475f);
        return bundle2;
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PersistableBundle toPersistableBundle() {
        return AbstractC0153h0.m736b(this);
    }
}
