package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import p000.q41;
import p000.r41;
import p000.r62;
import p000.s41;
import p000.t41;
import p000.u41;
import p000.v41;
import p000.ye0;

/* loaded from: classes.dex */
public class IntentSanitizer {

    /* renamed from: a */
    public int f3532a;

    /* renamed from: b */
    public Predicate f3533b;

    /* renamed from: c */
    public Predicate f3534c;

    /* renamed from: d */
    public Predicate f3535d;

    /* renamed from: e */
    public Predicate f3536e;

    /* renamed from: f */
    public Predicate f3537f;

    /* renamed from: g */
    public Predicate f3538g;

    /* renamed from: h */
    public boolean f3539h;

    /* renamed from: i */
    public HashMap f3540i;

    /* renamed from: j */
    public boolean f3541j;

    /* renamed from: k */
    public Predicate f3542k;

    /* renamed from: l */
    public Predicate f3543l;

    /* renamed from: m */
    public boolean f3544m;

    /* renamed from: n */
    public boolean f3545n;

    /* renamed from: o */
    public boolean f3546o;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public int f3547a;

        /* renamed from: h */
        public boolean f3554h;

        /* renamed from: i */
        public boolean f3555i;

        /* renamed from: n */
        public boolean f3560n;

        /* renamed from: o */
        public boolean f3561o;

        /* renamed from: p */
        public boolean f3562p;

        /* renamed from: b */
        public Predicate f3548b = new v41(2);

        /* renamed from: c */
        public Predicate f3549c = new v41(3);

        /* renamed from: d */
        public Predicate f3550d = new v41(2);

        /* renamed from: e */
        public Predicate f3551e = new v41(2);

        /* renamed from: f */
        public Predicate f3552f = new v41(2);

        /* renamed from: g */
        public Predicate f3553g = new v41(4);

        /* renamed from: j */
        public final HashMap f3556j = new HashMap();

        /* renamed from: k */
        public boolean f3557k = false;

        /* renamed from: l */
        public Predicate f3558l = new v41(3);

        /* renamed from: m */
        public Predicate f3559m = new v41(5);

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAction(@NonNull String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            allowAction(new t41(str, 3));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAnyComponent() {
            this.f3554h = true;
            this.f3553g = new v41(0);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowCategory(@NonNull String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            return allowCategory(new t41(str, 3));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipData(@NonNull Predicate<ClipData> predicate) {
            Preconditions.checkNotNull(predicate);
            this.f3559m = this.f3559m.mo897or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataText() {
            this.f3557k = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataUri(@NonNull Predicate<Uri> predicate) {
            Preconditions.checkNotNull(predicate);
            this.f3558l = this.f3558l.mo897or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataUriWithAuthority(@NonNull String str) {
            Preconditions.checkNotNull(str);
            return allowClipDataUri(new t41(str, 1));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponent(@NonNull ComponentName componentName) {
            Preconditions.checkNotNull(componentName);
            Objects.requireNonNull(componentName);
            return allowComponent(new u41(0, componentName));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponentWithPackage(@NonNull String str) {
            Preconditions.checkNotNull(str);
            return allowComponent(new t41(str, 4));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowData(@NonNull Predicate<Uri> predicate) {
            Preconditions.checkNotNull(predicate);
            this.f3549c = this.f3549c.mo897or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowDataWithAuthority(@NonNull String str) {
            Preconditions.checkNotNull(str);
            allowData(new t41(str, 5));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtra(@NonNull String str, @NonNull Class<?> cls) {
            return allowExtra(str, cls, new v41(6));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraOutput(@NonNull String str) {
            allowExtra("output", Uri.class, new t41(str, 0));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraStream(@NonNull Predicate<Uri> predicate) {
            allowExtra("android.intent.extra.STREAM", Uri.class, predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraStreamUriWithAuthority(@NonNull String str) {
            Preconditions.checkNotNull(str);
            allowExtra("android.intent.extra.STREAM", Uri.class, new t41(str, 2));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowFlags(int i) {
            this.f3547a = i | this.f3547a;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowHistoryStackFlags() {
            this.f3547a |= 2112614400;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowIdentifier() {
            this.f3560n = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowPackage(@NonNull String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            return allowPackage(new t41(str, 3));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowReceiverFlags() {
            this.f3547a |= 2015363072;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowSelector() {
            this.f3561o = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowSourceBounds() {
            this.f3562p = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowType(@NonNull String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            return allowType(new t41(str, 3));
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [androidx.core.content.IntentSanitizer, java.lang.Object] */
        @NonNull
        public IntentSanitizer build() {
            boolean z = this.f3554h;
            if ((z && this.f3555i) || (!z && !this.f3555i)) {
                throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
            }
            ?? obj = new Object();
            obj.f3532a = this.f3547a;
            obj.f3533b = this.f3548b;
            obj.f3534c = this.f3549c;
            obj.f3535d = this.f3550d;
            obj.f3536e = this.f3551e;
            obj.f3537f = this.f3552f;
            obj.f3539h = z;
            obj.f3538g = this.f3553g;
            obj.f3540i = this.f3556j;
            obj.f3541j = this.f3557k;
            obj.f3542k = this.f3558l;
            obj.f3543l = this.f3559m;
            obj.f3544m = this.f3560n;
            obj.f3545n = this.f3561o;
            obj.f3546o = this.f3562p;
            return obj;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public <T> Builder allowExtra(@NonNull String str, @NonNull Class<T> cls, @NonNull Predicate<T> predicate) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(predicate);
            return allowExtra(str, new r62(cls, predicate));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraOutput(@NonNull Predicate<Uri> predicate) {
            allowExtra("output", Uri.class, predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAction(@NonNull Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.f3548b = this.f3548b.mo897or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowCategory(@NonNull Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.f3551e = this.f3551e.mo897or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponent(@NonNull Predicate<ComponentName> predicate) {
            Preconditions.checkNotNull(predicate);
            this.f3555i = true;
            this.f3553g = this.f3553g.mo897or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowPackage(@NonNull Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.f3552f = this.f3552f.mo897or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowType(@NonNull Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.f3550d = this.f3550d.mo897or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtra(@NonNull String str, @NonNull Predicate<Object> predicate) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(predicate);
            HashMap hashMap = this.f3556j;
            Predicate predicate2 = (Predicate) hashMap.get(str);
            if (predicate2 == null) {
                predicate2 = new v41(1);
            }
            hashMap.put(str, predicate2.mo897or(predicate));
            return this;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02aa  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent sanitize(@NonNull Intent intent, @NonNull Consumer<String> consumer) {
        CharSequence charSequence;
        Uri uri;
        Intent intent2 = new Intent();
        ComponentName component = intent.getComponent();
        if ((this.f3539h && component == null) || this.f3538g.test(component)) {
            intent2.setComponent(component);
        } else {
            consumer.accept("Component is not allowed: " + component);
            intent2.setComponent(new ComponentName("android", "java.lang.Void"));
        }
        String str = intent.getPackage();
        if (str != null && !this.f3537f.test(str)) {
            consumer.accept("Package is not allowed: ".concat(str));
        } else {
            intent2.setPackage(str);
        }
        int flags = this.f3532a | intent.getFlags();
        int i = this.f3532a;
        if (flags == i) {
            intent2.setFlags(intent.getFlags());
        } else {
            intent2.setFlags(intent.getFlags() & i);
            consumer.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(intent.getFlags() & (~this.f3532a)));
        }
        String action = intent.getAction();
        if (action != null && !this.f3533b.test(action)) {
            consumer.accept("Action is not allowed: ".concat(action));
        } else {
            intent2.setAction(action);
        }
        Uri data = intent.getData();
        if (data != null && !this.f3534c.test(data)) {
            consumer.accept("Data is not allowed: " + data);
        } else {
            intent2.setData(data);
        }
        String type = intent.getType();
        if (type != null && !this.f3535d.test(type)) {
            consumer.accept("Type is not allowed: ".concat(type));
        } else {
            intent2.setDataAndType(intent2.getData(), type);
        }
        Set<String> categories = intent.getCategories();
        if (categories != null) {
            for (String str2 : categories) {
                if (this.f3536e.test(str2)) {
                    intent2.addCategory(str2);
                } else {
                    consumer.accept("Category is not allowed: " + str2);
                }
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str3 : extras.keySet()) {
                if (str3.equals("android.intent.extra.STREAM") && (this.f3532a & 1) == 0) {
                    consumer.accept("Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.");
                } else if (str3.equals("output") && ((~this.f3532a) & 3) != 0) {
                    consumer.accept("Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.");
                } else {
                    Object obj = extras.get(str3);
                    Predicate predicate = (Predicate) this.f3540i.get(str3);
                    if (predicate != null && predicate.test(obj)) {
                        if (obj == null) {
                            intent2.getExtras().putString(str3, null);
                        } else if (obj instanceof Parcelable) {
                            intent2.putExtra(str3, (Parcelable) obj);
                        } else if (obj instanceof Parcelable[]) {
                            intent2.putExtra(str3, (Parcelable[]) obj);
                        } else if (obj instanceof Serializable) {
                            intent2.putExtra(str3, (Serializable) obj);
                        } else {
                            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
                        }
                    } else {
                        consumer.accept("Extra is not allowed. Key: " + str3 + ". Value: " + obj);
                    }
                }
            }
        }
        Predicate predicate2 = this.f3543l;
        boolean z = this.f3541j;
        Predicate predicate3 = this.f3542k;
        ClipData clipData = intent.getClipData();
        if (clipData != null) {
            if (predicate2 != null && predicate2.test(clipData)) {
                intent2.setClipData(clipData);
            } else {
                ClipData clipData2 = null;
                for (int i2 = 0; i2 < clipData.getItemCount(); i2++) {
                    ClipData.Item itemAt = clipData.getItemAt(i2);
                    if (Build.VERSION.SDK_INT >= 31) {
                        s41.m7330a(i2, itemAt, consumer);
                    } else if (itemAt.getHtmlText() != null || itemAt.getIntent() != null) {
                        consumer.accept("ClipData item at position " + i2 + " contains htmlText, textLinks or intent: " + itemAt);
                    }
                    if (z) {
                        charSequence = itemAt.getText();
                    } else {
                        if (itemAt.getText() != null) {
                            StringBuilder m8299s = ye0.m8299s(i2, "Item text cannot contain value. Item position: ", ". Text: ");
                            m8299s.append((Object) itemAt.getText());
                            consumer.accept(m8299s.toString());
                        }
                        charSequence = null;
                    }
                    if (predicate3 == null) {
                        if (itemAt.getUri() != null) {
                            StringBuilder m8299s2 = ye0.m8299s(i2, "Item URI is not allowed. Item position: ", ". URI: ");
                            m8299s2.append(itemAt.getUri());
                            consumer.accept(m8299s2.toString());
                        }
                    } else if (itemAt.getUri() != null && !predicate3.test(itemAt.getUri())) {
                        StringBuilder m8299s3 = ye0.m8299s(i2, "Item URI is not allowed. Item position: ", ". URI: ");
                        m8299s3.append(itemAt.getUri());
                        consumer.accept(m8299s3.toString());
                    } else {
                        uri = itemAt.getUri();
                        if (charSequence == null || uri != null) {
                            if (clipData2 != null) {
                                clipData2 = new ClipData(clipData.getDescription(), new ClipData.Item(charSequence, null, uri));
                            } else {
                                clipData2.addItem(new ClipData.Item(charSequence, null, uri));
                            }
                        }
                    }
                    uri = null;
                    if (charSequence == null) {
                    }
                    if (clipData2 != null) {
                    }
                }
                if (clipData2 != null) {
                    intent2.setClipData(clipData2);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (this.f3544m) {
                r41.m7218b(intent2, r41.m7217a(intent));
            } else if (r41.m7217a(intent) != null) {
                consumer.accept("Identifier is not allowed: " + r41.m7217a(intent));
            }
        }
        if (this.f3545n) {
            intent2.setSelector(intent.getSelector());
        } else if (intent.getSelector() != null) {
            consumer.accept("Selector is not allowed: " + intent.getSelector());
        }
        if (this.f3546o) {
            intent2.setSourceBounds(intent.getSourceBounds());
        } else if (intent.getSourceBounds() != null) {
            consumer.accept("SourceBounds is not allowed: " + intent.getSourceBounds());
        }
        return intent2;
    }

    @NonNull
    public Intent sanitizeByFiltering(@NonNull Intent intent) {
        return sanitize(intent, new q41(1));
    }

    @NonNull
    public Intent sanitizeByThrowing(@NonNull Intent intent) {
        return sanitize(intent, new q41(0));
    }
}
