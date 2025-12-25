package androidx.core.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.IntentCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import p000.ye0;

/* loaded from: classes.dex */
public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";

    /* loaded from: classes.dex */
    public static class IntentBuilder {

        /* renamed from: a */
        public final Context f3498a;

        /* renamed from: b */
        public final Intent f3499b;

        /* renamed from: c */
        public CharSequence f3500c;

        /* renamed from: d */
        public ArrayList f3501d;

        /* renamed from: e */
        public ArrayList f3502e;

        /* renamed from: f */
        public ArrayList f3503f;

        /* renamed from: g */
        public ArrayList f3504g;

        public IntentBuilder(@NonNull Context context) {
            Activity activity;
            this.f3498a = (Context) Preconditions.checkNotNull(context);
            Intent action = new Intent().setAction("android.intent.action.SEND");
            this.f3499b = action;
            action.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, context.getPackageName());
            action.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, context.getPackageName());
            action.addFlags(524288);
            while (true) {
                if (context instanceof ContextWrapper) {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    activity = null;
                    break;
                }
            }
            if (activity != null) {
                ComponentName componentName = activity.getComponentName();
                this.f3499b.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, componentName);
                this.f3499b.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, componentName);
            }
        }

        @NonNull
        @Deprecated
        public static IntentBuilder from(@NonNull Activity activity) {
            return new IntentBuilder(activity);
        }

        /* renamed from: a */
        public final void m712a(String str, ArrayList arrayList) {
            int i;
            Intent intent = this.f3499b;
            String[] stringArrayExtra = intent.getStringArrayExtra(str);
            if (stringArrayExtra != null) {
                i = stringArrayExtra.length;
            } else {
                i = 0;
            }
            String[] strArr = new String[arrayList.size() + i];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), i);
            }
            intent.putExtra(str, strArr);
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String str) {
            if (this.f3503f == null) {
                this.f3503f = new ArrayList();
            }
            this.f3503f.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String str) {
            if (this.f3502e == null) {
                this.f3502e = new ArrayList();
            }
            this.f3502e.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String str) {
            if (this.f3501d == null) {
                this.f3501d = new ArrayList();
            }
            this.f3501d.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addStream(@NonNull Uri uri) {
            if (this.f3504g == null) {
                this.f3504g = new ArrayList();
            }
            this.f3504g.add(uri);
            return this;
        }

        /* renamed from: b */
        public final void m713b(String str, String[] strArr) {
            int i;
            Intent intent = getIntent();
            String[] stringArrayExtra = intent.getStringArrayExtra(str);
            if (stringArrayExtra != null) {
                i = stringArrayExtra.length;
            } else {
                i = 0;
            }
            String[] strArr2 = new String[strArr.length + i];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr2, 0, i);
            }
            System.arraycopy(strArr, 0, strArr2, i, strArr.length);
            intent.putExtra(str, strArr2);
        }

        @NonNull
        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.f3500c);
        }

        @NonNull
        public Intent getIntent() {
            ArrayList arrayList = this.f3501d;
            if (arrayList != null) {
                m712a("android.intent.extra.EMAIL", arrayList);
                this.f3501d = null;
            }
            ArrayList arrayList2 = this.f3502e;
            if (arrayList2 != null) {
                m712a("android.intent.extra.CC", arrayList2);
                this.f3502e = null;
            }
            ArrayList arrayList3 = this.f3503f;
            if (arrayList3 != null) {
                m712a("android.intent.extra.BCC", arrayList3);
                this.f3503f = null;
            }
            ArrayList arrayList4 = this.f3504g;
            Intent intent = this.f3499b;
            if (arrayList4 != null && arrayList4.size() > 1) {
                intent.setAction("android.intent.action.SEND_MULTIPLE");
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f3504g);
                ShareCompat.m711a(intent, this.f3504g);
            } else {
                intent.setAction("android.intent.action.SEND");
                ArrayList arrayList5 = this.f3504g;
                if (arrayList5 != null && !arrayList5.isEmpty()) {
                    intent.putExtra("android.intent.extra.STREAM", (Parcelable) this.f3504g.get(0));
                    ShareCompat.m711a(intent, this.f3504g);
                } else {
                    intent.removeExtra("android.intent.extra.STREAM");
                    intent.setClipData(null);
                    intent.setFlags(intent.getFlags() & (-2));
                }
            }
            return intent;
        }

        @NonNull
        public IntentBuilder setChooserTitle(@Nullable CharSequence charSequence) {
            this.f3500c = charSequence;
            return this;
        }

        @NonNull
        public IntentBuilder setEmailBcc(@Nullable String[] strArr) {
            this.f3499b.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailCc(@Nullable String[] strArr) {
            this.f3499b.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailTo(@Nullable String[] strArr) {
            if (this.f3501d != null) {
                this.f3501d = null;
            }
            this.f3499b.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setHtmlText(@Nullable String str) {
            Intent intent = this.f3499b;
            intent.putExtra(IntentCompat.EXTRA_HTML_TEXT, str);
            if (!intent.hasExtra("android.intent.extra.TEXT")) {
                setText(Html.fromHtml(str));
            }
            return this;
        }

        @NonNull
        public IntentBuilder setStream(@Nullable Uri uri) {
            this.f3504g = null;
            if (uri != null) {
                addStream(uri);
            }
            return this;
        }

        @NonNull
        public IntentBuilder setSubject(@Nullable String str) {
            this.f3499b.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }

        @NonNull
        public IntentBuilder setText(@Nullable CharSequence charSequence) {
            this.f3499b.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        @NonNull
        public IntentBuilder setType(@Nullable String str) {
            this.f3499b.setType(str);
            return this;
        }

        public void startChooser() {
            this.f3498a.startActivity(createChooserIntent());
        }

        @NonNull
        public IntentBuilder setChooserTitle(@StringRes int i) {
            return setChooserTitle(this.f3498a.getText(i));
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String[] strArr) {
            m713b("android.intent.extra.BCC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String[] strArr) {
            m713b("android.intent.extra.CC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String[] strArr) {
            m713b("android.intent.extra.EMAIL", strArr);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class IntentReader {

        /* renamed from: a */
        public final Context f3505a;

        /* renamed from: b */
        public final Intent f3506b;

        /* renamed from: c */
        public final String f3507c;

        /* renamed from: d */
        public final ComponentName f3508d;

        /* renamed from: e */
        public ArrayList f3509e;

        public IntentReader(@NonNull Activity activity) {
            this((Context) Preconditions.checkNotNull(activity), activity.getIntent());
        }

        @NonNull
        @Deprecated
        public static IntentReader from(@NonNull Activity activity) {
            return new IntentReader(activity);
        }

        @Nullable
        public ComponentName getCallingActivity() {
            return this.f3508d;
        }

        @Nullable
        public Drawable getCallingActivityIcon() {
            ComponentName componentName = this.f3508d;
            if (componentName == null) {
                return null;
            }
            try {
                return this.f3505a.getPackageManager().getActivityIcon(componentName);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve icon for calling activity", e);
                return null;
            }
        }

        @Nullable
        public Drawable getCallingApplicationIcon() {
            String str = this.f3507c;
            if (str == null) {
                return null;
            }
            try {
                return this.f3505a.getPackageManager().getApplicationIcon(str);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve icon for calling application", e);
                return null;
            }
        }

        @Nullable
        public CharSequence getCallingApplicationLabel() {
            String str = this.f3507c;
            if (str == null) {
                return null;
            }
            PackageManager packageManager = this.f3505a.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0));
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve label for calling application", e);
                return null;
            }
        }

        @Nullable
        public String getCallingPackage() {
            return this.f3507c;
        }

        @Nullable
        public String[] getEmailBcc() {
            return this.f3506b.getStringArrayExtra("android.intent.extra.BCC");
        }

        @Nullable
        public String[] getEmailCc() {
            return this.f3506b.getStringArrayExtra("android.intent.extra.CC");
        }

        @Nullable
        public String[] getEmailTo() {
            return this.f3506b.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        @Nullable
        public String getHtmlText() {
            String stringExtra = this.f3506b.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (stringExtra == null) {
                CharSequence text = getText();
                if (text instanceof Spanned) {
                    return Html.toHtml((Spanned) text);
                }
                if (text != null) {
                    return Html.escapeHtml(text);
                }
                return stringExtra;
            }
            return stringExtra;
        }

        @Nullable
        public Uri getStream() {
            return (Uri) this.f3506b.getParcelableExtra("android.intent.extra.STREAM");
        }

        public int getStreamCount() {
            ArrayList arrayList = this.f3509e;
            Intent intent = this.f3506b;
            if (arrayList == null && isMultipleShare()) {
                this.f3509e = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList arrayList2 = this.f3509e;
            if (arrayList2 != null) {
                return arrayList2.size();
            }
            return intent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        @Nullable
        public String getSubject() {
            return this.f3506b.getStringExtra("android.intent.extra.SUBJECT");
        }

        @Nullable
        public CharSequence getText() {
            return this.f3506b.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        @Nullable
        public String getType() {
            return this.f3506b.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.f3506b.getAction());
        }

        public boolean isShareIntent() {
            String action = this.f3506b.getAction();
            if (!"android.intent.action.SEND".equals(action) && !"android.intent.action.SEND_MULTIPLE".equals(action)) {
                return false;
            }
            return true;
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.f3506b.getAction());
        }

        public IntentReader(@NonNull Context context, @NonNull Intent intent) {
            this.f3505a = (Context) Preconditions.checkNotNull(context);
            this.f3506b = (Intent) Preconditions.checkNotNull(intent);
            String stringExtra = intent.getStringExtra(ShareCompat.EXTRA_CALLING_PACKAGE);
            this.f3507c = stringExtra == null ? intent.getStringExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP) : stringExtra;
            ComponentName componentName = (ComponentName) intent.getParcelableExtra(ShareCompat.EXTRA_CALLING_ACTIVITY);
            this.f3508d = componentName == null ? (ComponentName) intent.getParcelableExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP) : componentName;
        }

        @Nullable
        public Uri getStream(int i) {
            ArrayList arrayList = this.f3509e;
            Intent intent = this.f3506b;
            if (arrayList == null && isMultipleShare()) {
                this.f3509e = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList arrayList2 = this.f3509e;
            if (arrayList2 != null) {
                return (Uri) arrayList2.get(i);
            }
            if (i == 0) {
                return (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
            }
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + i);
        }
    }

    /* renamed from: a */
    public static void m711a(Intent intent, ArrayList arrayList) {
        ClipData clipData = new ClipData(null, new String[]{intent.getType()}, new ClipData.Item(intent.getCharSequenceExtra("android.intent.extra.TEXT"), intent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT), null, (Uri) arrayList.get(0)));
        int size = arrayList.size();
        for (int i = 1; i < size; i++) {
            clipData.addItem(new ClipData.Item((Uri) arrayList.get(i)));
        }
        intent.setClipData(clipData);
        intent.addFlags(1);
    }

    @Deprecated
    public static void configureMenuItem(@NonNull MenuItem menuItem, @NonNull IntentBuilder intentBuilder) {
        ShareActionProvider shareActionProvider;
        ActionProvider actionProvider = menuItem.getActionProvider();
        if (!(actionProvider instanceof ShareActionProvider)) {
            shareActionProvider = new ShareActionProvider(intentBuilder.f3498a);
        } else {
            shareActionProvider = (ShareActionProvider) actionProvider;
        }
        shareActionProvider.setShareHistoryFileName(".sharecompat_".concat(intentBuilder.f3498a.getClass().getName()));
        shareActionProvider.setShareIntent(intentBuilder.getIntent());
        menuItem.setActionProvider(shareActionProvider);
    }

    @Nullable
    public static ComponentName getCallingActivity(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            ComponentName componentName = (ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
            if (componentName == null) {
                return (ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP);
            }
            return componentName;
        }
        return callingActivity;
    }

    @Nullable
    public static String getCallingPackage(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        String callingPackage = activity.getCallingPackage();
        if (callingPackage == null && intent != null) {
            String stringExtra = intent.getStringExtra(EXTRA_CALLING_PACKAGE);
            if (stringExtra == null) {
                return intent.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP);
            }
            return stringExtra;
        }
        return callingPackage;
    }

    @Deprecated
    public static void configureMenuItem(@NonNull Menu menu, @IdRes int i, @NonNull IntentBuilder intentBuilder) {
        MenuItem findItem = menu.findItem(i);
        if (findItem != null) {
            configureMenuItem(findItem, intentBuilder);
            return;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Could not find menu item with id ", " in the supplied menu"));
    }
}
