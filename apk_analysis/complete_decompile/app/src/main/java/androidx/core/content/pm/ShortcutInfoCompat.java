package androidx.core.content.pm;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.LocusId;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000.AbstractC1726qj;
import p000.r72;
import p000.y70;

/* loaded from: classes.dex */
public class ShortcutInfoCompat {
    public static final int SURFACE_LAUNCHER = 1;

    /* renamed from: A */
    public int f3569A;

    /* renamed from: B */
    public int f3570B;

    /* renamed from: a */
    public Context f3571a;

    /* renamed from: b */
    public String f3572b;

    /* renamed from: c */
    public String f3573c;

    /* renamed from: d */
    public Intent[] f3574d;

    /* renamed from: e */
    public ComponentName f3575e;

    /* renamed from: f */
    public CharSequence f3576f;

    /* renamed from: g */
    public CharSequence f3577g;

    /* renamed from: h */
    public CharSequence f3578h;

    /* renamed from: i */
    public IconCompat f3579i;

    /* renamed from: j */
    public boolean f3580j;

    /* renamed from: k */
    public Person[] f3581k;

    /* renamed from: l */
    public Set f3582l;

    /* renamed from: m */
    public LocusIdCompat f3583m;

    /* renamed from: n */
    public boolean f3584n;

    /* renamed from: o */
    public int f3585o;

    /* renamed from: p */
    public PersistableBundle f3586p;

    /* renamed from: q */
    public Bundle f3587q;

    /* renamed from: r */
    public long f3588r;

    /* renamed from: s */
    public UserHandle f3589s;

    /* renamed from: t */
    public boolean f3590t;

    /* renamed from: u */
    public boolean f3591u;

    /* renamed from: v */
    public boolean f3592v;

    /* renamed from: w */
    public boolean f3593w;

    /* renamed from: x */
    public boolean f3594x;

    /* renamed from: y */
    public boolean f3595y = true;

    /* renamed from: z */
    public boolean f3596z;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public final ShortcutInfoCompat f3597a;

        /* renamed from: b */
        public boolean f3598b;

        /* renamed from: c */
        public HashSet f3599c;

        /* renamed from: d */
        public HashMap f3600d;

        /* renamed from: e */
        public Uri f3601e;

        public Builder(@NonNull Context context, @NonNull String str) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.f3597a = shortcutInfoCompat;
            shortcutInfoCompat.f3571a = context;
            shortcutInfoCompat.f3572b = str;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(@NonNull String str) {
            if (this.f3599c == null) {
                this.f3599c = new HashSet();
            }
            this.f3599c.add(str);
            return this;
        }

        @NonNull
        public ShortcutInfoCompat build() {
            String[] strArr;
            ShortcutInfoCompat shortcutInfoCompat = this.f3597a;
            if (!TextUtils.isEmpty(shortcutInfoCompat.f3576f)) {
                Intent[] intentArr = shortcutInfoCompat.f3574d;
                if (intentArr != null && intentArr.length != 0) {
                    if (this.f3598b) {
                        if (shortcutInfoCompat.f3583m == null) {
                            shortcutInfoCompat.f3583m = new LocusIdCompat(shortcutInfoCompat.f3572b);
                        }
                        shortcutInfoCompat.f3584n = true;
                    }
                    if (this.f3599c != null) {
                        if (shortcutInfoCompat.f3582l == null) {
                            shortcutInfoCompat.f3582l = new HashSet();
                        }
                        shortcutInfoCompat.f3582l.addAll(this.f3599c);
                    }
                    if (this.f3600d != null) {
                        if (shortcutInfoCompat.f3586p == null) {
                            shortcutInfoCompat.f3586p = new PersistableBundle();
                        }
                        for (String str : this.f3600d.keySet()) {
                            Map map = (Map) this.f3600d.get(str);
                            shortcutInfoCompat.f3586p.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                            for (String str2 : map.keySet()) {
                                List list = (List) map.get(str2);
                                PersistableBundle persistableBundle = shortcutInfoCompat.f3586p;
                                String m7058n = AbstractC1726qj.m7058n(str, "/", str2);
                                if (list == null) {
                                    strArr = new String[0];
                                } else {
                                    strArr = (String[]) list.toArray(new String[0]);
                                }
                                persistableBundle.putStringArray(m7058n, strArr);
                            }
                        }
                    }
                    if (this.f3601e != null) {
                        if (shortcutInfoCompat.f3586p == null) {
                            shortcutInfoCompat.f3586p = new PersistableBundle();
                        }
                        shortcutInfoCompat.f3586p.putString("extraSliceUri", UriCompat.toSafeString(this.f3601e));
                    }
                    return shortcutInfoCompat;
                }
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        @NonNull
        public Builder setActivity(@NonNull ComponentName componentName) {
            this.f3597a.f3575e = componentName;
            return this;
        }

        @NonNull
        public Builder setAlwaysBadged() {
            this.f3597a.f3580j = true;
            return this;
        }

        @NonNull
        public Builder setCategories(@NonNull Set<String> set) {
            ArraySet arraySet = new ArraySet();
            arraySet.addAll(set);
            this.f3597a.f3582l = arraySet;
            return this;
        }

        @NonNull
        public Builder setDisabledMessage(@NonNull CharSequence charSequence) {
            this.f3597a.f3578h = charSequence;
            return this;
        }

        @NonNull
        public Builder setExcludedFromSurfaces(int i) {
            this.f3597a.f3570B = i;
            return this;
        }

        @NonNull
        public Builder setExtras(@NonNull PersistableBundle persistableBundle) {
            this.f3597a.f3586p = persistableBundle;
            return this;
        }

        @NonNull
        public Builder setIcon(IconCompat iconCompat) {
            this.f3597a.f3579i = iconCompat;
            return this;
        }

        @NonNull
        public Builder setIntent(@NonNull Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        @NonNull
        public Builder setIntents(@NonNull Intent[] intentArr) {
            this.f3597a.f3574d = intentArr;
            return this;
        }

        @NonNull
        public Builder setIsConversation() {
            this.f3598b = true;
            return this;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat locusIdCompat) {
            this.f3597a.f3583m = locusIdCompat;
            return this;
        }

        @NonNull
        public Builder setLongLabel(@NonNull CharSequence charSequence) {
            this.f3597a.f3577g = charSequence;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setLongLived() {
            this.f3597a.f3584n = true;
            return this;
        }

        @NonNull
        public Builder setPerson(@NonNull Person person) {
            return setPersons(new Person[]{person});
        }

        @NonNull
        public Builder setPersons(@NonNull Person[] personArr) {
            this.f3597a.f3581k = personArr;
            return this;
        }

        @NonNull
        public Builder setRank(int i) {
            this.f3597a.f3585o = i;
            return this;
        }

        @NonNull
        public Builder setShortLabel(@NonNull CharSequence charSequence) {
            this.f3597a.f3576f = charSequence;
            return this;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setSliceUri(@NonNull Uri uri) {
            this.f3601e = uri;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setTransientExtras(@NonNull Bundle bundle) {
            this.f3597a.f3587q = (Bundle) Preconditions.checkNotNull(bundle);
            return this;
        }

        @NonNull
        public Builder setLongLived(boolean z) {
            this.f3597a.f3584n = z;
            return this;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(@NonNull String str, @NonNull String str2, @NonNull List<String> list) {
            addCapabilityBinding(str);
            if (!list.isEmpty()) {
                if (this.f3600d == null) {
                    this.f3600d = new HashMap();
                }
                if (this.f3600d.get(str) == null) {
                    this.f3600d.put(str, new HashMap());
                }
                ((Map) this.f3600d.get(str)).put(str2, list);
            }
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull ShortcutInfoCompat shortcutInfoCompat) {
            ShortcutInfoCompat shortcutInfoCompat2 = new ShortcutInfoCompat();
            this.f3597a = shortcutInfoCompat2;
            shortcutInfoCompat2.f3571a = shortcutInfoCompat.f3571a;
            shortcutInfoCompat2.f3572b = shortcutInfoCompat.f3572b;
            shortcutInfoCompat2.f3573c = shortcutInfoCompat.f3573c;
            Intent[] intentArr = shortcutInfoCompat.f3574d;
            shortcutInfoCompat2.f3574d = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            shortcutInfoCompat2.f3575e = shortcutInfoCompat.f3575e;
            shortcutInfoCompat2.f3576f = shortcutInfoCompat.f3576f;
            shortcutInfoCompat2.f3577g = shortcutInfoCompat.f3577g;
            shortcutInfoCompat2.f3578h = shortcutInfoCompat.f3578h;
            shortcutInfoCompat2.f3569A = shortcutInfoCompat.f3569A;
            shortcutInfoCompat2.f3579i = shortcutInfoCompat.f3579i;
            shortcutInfoCompat2.f3580j = shortcutInfoCompat.f3580j;
            shortcutInfoCompat2.f3589s = shortcutInfoCompat.f3589s;
            shortcutInfoCompat2.f3588r = shortcutInfoCompat.f3588r;
            shortcutInfoCompat2.f3590t = shortcutInfoCompat.f3590t;
            shortcutInfoCompat2.f3591u = shortcutInfoCompat.f3591u;
            shortcutInfoCompat2.f3592v = shortcutInfoCompat.f3592v;
            shortcutInfoCompat2.f3593w = shortcutInfoCompat.f3593w;
            shortcutInfoCompat2.f3594x = shortcutInfoCompat.f3594x;
            shortcutInfoCompat2.f3595y = shortcutInfoCompat.f3595y;
            shortcutInfoCompat2.f3583m = shortcutInfoCompat.f3583m;
            shortcutInfoCompat2.f3584n = shortcutInfoCompat.f3584n;
            shortcutInfoCompat2.f3596z = shortcutInfoCompat.f3596z;
            shortcutInfoCompat2.f3585o = shortcutInfoCompat.f3585o;
            Person[] personArr = shortcutInfoCompat.f3581k;
            if (personArr != null) {
                shortcutInfoCompat2.f3581k = (Person[]) Arrays.copyOf(personArr, personArr.length);
            }
            if (shortcutInfoCompat.f3582l != null) {
                shortcutInfoCompat2.f3582l = new HashSet(shortcutInfoCompat.f3582l);
            }
            PersistableBundle persistableBundle = shortcutInfoCompat.f3586p;
            if (persistableBundle != null) {
                shortcutInfoCompat2.f3586p = persistableBundle;
            }
            shortcutInfoCompat2.f3570B = shortcutInfoCompat.f3570B;
        }

        @RequiresApi(25)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull Context context, @NonNull ShortcutInfo shortcutInfo) {
            String id;
            String str;
            Intent[] intents;
            ComponentName activity;
            CharSequence shortLabel;
            CharSequence longLabel;
            CharSequence disabledMessage;
            boolean isEnabled;
            Set categories;
            PersistableBundle extras;
            Person[] personArr;
            UserHandle userHandle;
            long lastChangedTimestamp;
            boolean isDynamic;
            boolean isPinned;
            boolean isDeclaredInManifest;
            boolean isImmutable;
            boolean isEnabled2;
            boolean hasKeyFieldsOnly;
            PersistableBundle extras2;
            String string;
            int rank;
            PersistableBundle extras3;
            LocusId locusId;
            LocusId locusId2;
            boolean isCached;
            int disabledReason;
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.f3597a = shortcutInfoCompat;
            shortcutInfoCompat.f3571a = context;
            id = shortcutInfo.getId();
            shortcutInfoCompat.f3572b = id;
            str = shortcutInfo.getPackage();
            shortcutInfoCompat.f3573c = str;
            intents = shortcutInfo.getIntents();
            shortcutInfoCompat.f3574d = (Intent[]) Arrays.copyOf(intents, intents.length);
            activity = shortcutInfo.getActivity();
            shortcutInfoCompat.f3575e = activity;
            shortLabel = shortcutInfo.getShortLabel();
            shortcutInfoCompat.f3576f = shortLabel;
            longLabel = shortcutInfo.getLongLabel();
            shortcutInfoCompat.f3577g = longLabel;
            disabledMessage = shortcutInfo.getDisabledMessage();
            shortcutInfoCompat.f3578h = disabledMessage;
            int i = 0;
            if (Build.VERSION.SDK_INT >= 28) {
                disabledReason = shortcutInfo.getDisabledReason();
                shortcutInfoCompat.f3569A = disabledReason;
            } else {
                isEnabled = shortcutInfo.isEnabled();
                shortcutInfoCompat.f3569A = isEnabled ? 0 : 3;
            }
            categories = shortcutInfo.getCategories();
            shortcutInfoCompat.f3582l = categories;
            extras = shortcutInfo.getExtras();
            LocusIdCompat locusIdCompat = null;
            if (extras == null || !extras.containsKey("extraPersonCount")) {
                personArr = null;
            } else {
                int i2 = extras.getInt("extraPersonCount");
                personArr = new Person[i2];
                while (i < i2) {
                    StringBuilder sb = new StringBuilder("extraPerson_");
                    int i3 = i + 1;
                    sb.append(i3);
                    personArr[i] = Person.fromPersistableBundle(extras.getPersistableBundle(sb.toString()));
                    i = i3;
                }
            }
            shortcutInfoCompat.f3581k = personArr;
            ShortcutInfoCompat shortcutInfoCompat2 = this.f3597a;
            userHandle = shortcutInfo.getUserHandle();
            shortcutInfoCompat2.f3589s = userHandle;
            ShortcutInfoCompat shortcutInfoCompat3 = this.f3597a;
            lastChangedTimestamp = shortcutInfo.getLastChangedTimestamp();
            shortcutInfoCompat3.f3588r = lastChangedTimestamp;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 30) {
                ShortcutInfoCompat shortcutInfoCompat4 = this.f3597a;
                isCached = shortcutInfo.isCached();
                shortcutInfoCompat4.f3590t = isCached;
            }
            ShortcutInfoCompat shortcutInfoCompat5 = this.f3597a;
            isDynamic = shortcutInfo.isDynamic();
            shortcutInfoCompat5.f3591u = isDynamic;
            ShortcutInfoCompat shortcutInfoCompat6 = this.f3597a;
            isPinned = shortcutInfo.isPinned();
            shortcutInfoCompat6.f3592v = isPinned;
            ShortcutInfoCompat shortcutInfoCompat7 = this.f3597a;
            isDeclaredInManifest = shortcutInfo.isDeclaredInManifest();
            shortcutInfoCompat7.f3593w = isDeclaredInManifest;
            ShortcutInfoCompat shortcutInfoCompat8 = this.f3597a;
            isImmutable = shortcutInfo.isImmutable();
            shortcutInfoCompat8.f3594x = isImmutable;
            ShortcutInfoCompat shortcutInfoCompat9 = this.f3597a;
            isEnabled2 = shortcutInfo.isEnabled();
            shortcutInfoCompat9.f3595y = isEnabled2;
            ShortcutInfoCompat shortcutInfoCompat10 = this.f3597a;
            hasKeyFieldsOnly = shortcutInfo.hasKeyFieldsOnly();
            shortcutInfoCompat10.f3596z = hasKeyFieldsOnly;
            ShortcutInfoCompat shortcutInfoCompat11 = this.f3597a;
            if (i4 >= 29) {
                locusId = shortcutInfo.getLocusId();
                if (locusId != null) {
                    locusId2 = shortcutInfo.getLocusId();
                    locusIdCompat = LocusIdCompat.toLocusIdCompat(locusId2);
                }
            } else {
                extras2 = shortcutInfo.getExtras();
                if (extras2 != null && (string = extras2.getString("extraLocusId")) != null) {
                    locusIdCompat = new LocusIdCompat(string);
                }
            }
            shortcutInfoCompat11.f3583m = locusIdCompat;
            ShortcutInfoCompat shortcutInfoCompat12 = this.f3597a;
            rank = shortcutInfo.getRank();
            shortcutInfoCompat12.f3585o = rank;
            ShortcutInfoCompat shortcutInfoCompat13 = this.f3597a;
            extras3 = shortcutInfo.getExtras();
            shortcutInfoCompat13.f3586p = extras3;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Surface {
    }

    /* renamed from: b */
    public static ArrayList m805b(Context context, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Builder(context, y70.m8236h(it.next())).build());
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void m806a(Intent intent) {
        intent.putExtra("android.intent.extra.shortcut.INTENT", this.f3574d[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.f3576f.toString());
        if (this.f3579i != null) {
            Drawable drawable = null;
            if (this.f3580j) {
                PackageManager packageManager = this.f3571a.getPackageManager();
                ComponentName componentName = this.f3575e;
                if (componentName != null) {
                    try {
                        drawable = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (drawable == null) {
                    drawable = this.f3571a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.f3579i.addToShortcutIntent(intent, drawable, this.f3571a);
        }
    }

    @Nullable
    public ComponentName getActivity() {
        return this.f3575e;
    }

    @Nullable
    public Set<String> getCategories() {
        return this.f3582l;
    }

    @Nullable
    public CharSequence getDisabledMessage() {
        return this.f3578h;
    }

    public int getDisabledReason() {
        return this.f3569A;
    }

    public int getExcludedFromSurfaces() {
        return this.f3570B;
    }

    @Nullable
    public PersistableBundle getExtras() {
        return this.f3586p;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public IconCompat getIcon() {
        return this.f3579i;
    }

    @NonNull
    public String getId() {
        return this.f3572b;
    }

    @NonNull
    public Intent getIntent() {
        return this.f3574d[r0.length - 1];
    }

    @NonNull
    public Intent[] getIntents() {
        Intent[] intentArr = this.f3574d;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    public long getLastChangedTimestamp() {
        return this.f3588r;
    }

    @Nullable
    public LocusIdCompat getLocusId() {
        return this.f3583m;
    }

    @Nullable
    public CharSequence getLongLabel() {
        return this.f3577g;
    }

    @NonNull
    public String getPackage() {
        return this.f3573c;
    }

    public int getRank() {
        return this.f3585o;
    }

    @NonNull
    public CharSequence getShortLabel() {
        return this.f3576f;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bundle getTransientExtras() {
        return this.f3587q;
    }

    @Nullable
    public UserHandle getUserHandle() {
        return this.f3589s;
    }

    public boolean hasKeyFieldsOnly() {
        return this.f3596z;
    }

    public boolean isCached() {
        return this.f3590t;
    }

    public boolean isDeclaredInManifest() {
        return this.f3593w;
    }

    public boolean isDynamic() {
        return this.f3591u;
    }

    public boolean isEnabled() {
        return this.f3595y;
    }

    public boolean isExcludedFromSurfaces(int i) {
        if ((i & this.f3570B) != 0) {
            return true;
        }
        return false;
    }

    public boolean isImmutable() {
        return this.f3594x;
    }

    public boolean isPinned() {
        return this.f3592v;
    }

    @RequiresApi(25)
    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder shortLabel;
        ShortcutInfo.Builder intents;
        ShortcutInfo build;
        y70.m8243o();
        shortLabel = y70.m8232d(this.f3571a, this.f3572b).setShortLabel(this.f3576f);
        intents = shortLabel.setIntents(this.f3574d);
        IconCompat iconCompat = this.f3579i;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.toIcon(this.f3571a));
        }
        if (!TextUtils.isEmpty(this.f3577g)) {
            intents.setLongLabel(this.f3577g);
        }
        if (!TextUtils.isEmpty(this.f3578h)) {
            intents.setDisabledMessage(this.f3578h);
        }
        ComponentName componentName = this.f3575e;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set set = this.f3582l;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.f3585o);
        PersistableBundle persistableBundle = this.f3586p;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        int i = 0;
        if (Build.VERSION.SDK_INT >= 29) {
            Person[] personArr = this.f3581k;
            if (personArr != null && personArr.length > 0) {
                int length = personArr.length;
                android.app.Person[] personArr2 = new android.app.Person[length];
                while (i < length) {
                    personArr2[i] = this.f3581k[i].toAndroidPerson();
                    i++;
                }
                intents.setPersons(personArr2);
            }
            LocusIdCompat locusIdCompat = this.f3583m;
            if (locusIdCompat != null) {
                intents.setLocusId(locusIdCompat.toLocusId());
            }
            intents.setLongLived(this.f3584n);
        } else {
            if (this.f3586p == null) {
                this.f3586p = new PersistableBundle();
            }
            Person[] personArr3 = this.f3581k;
            if (personArr3 != null && personArr3.length > 0) {
                this.f3586p.putInt("extraPersonCount", personArr3.length);
                while (i < this.f3581k.length) {
                    PersistableBundle persistableBundle2 = this.f3586p;
                    StringBuilder sb = new StringBuilder("extraPerson_");
                    int i2 = i + 1;
                    sb.append(i2);
                    persistableBundle2.putPersistableBundle(sb.toString(), this.f3581k[i].toPersistableBundle());
                    i = i2;
                }
            }
            LocusIdCompat locusIdCompat2 = this.f3583m;
            if (locusIdCompat2 != null) {
                this.f3586p.putString("extraLocusId", locusIdCompat2.getId());
            }
            this.f3586p.putBoolean("extraLongLived", this.f3584n);
            intents.setExtras(this.f3586p);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            r72.m7228b(intents, this.f3570B);
        }
        build = intents.build();
        return build;
    }
}
